package br.com.softblue.bluekeeper.dao.xml;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import br.com.softblue.bluekeeper.dao.DAOException;
import br.com.softblue.bluekeeper.dao.SenhaServicoDAO;
import br.com.softblue.bluekeeper.model.SenhaServico;

public class SenhaServicoXMLDAO implements SenhaServicoDAO {

	private static final Path STORAGE_FILE = Paths.get(System.getProperty("user.home"), "senhas.xml");

	public List<SenhaServico> load() {
		List<SenhaServico> senhasServico = new ArrayList<>();

		if (!Files.exists(STORAGE_FILE)) {
			return senhasServico;
		}

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.parse(Files.newInputStream(STORAGE_FILE));
			NodeList senhaServicoTags = doc.getElementsByTagName("SenhaServico");

			for (int i = 0; i < senhaServicoTags.getLength(); i++) {
				Element senhaServicoTag = (Element) senhaServicoTags.item(i);
				SenhaServico senhaServico = new SenhaServico();

				senhaServico.setId(Integer.parseInt(senhaServicoTag.getAttribute("id")));
				senhaServico.setServico(senhaServicoTag.getElementsByTagName("Servico").item(0).getTextContent());
				senhaServico.setLogin(senhaServicoTag.getElementsByTagName("Login").item(0).getTextContent());
				senhaServico.setSenha(decrypt(senhaServicoTag.getElementsByTagName("Senha").item(0).getTextContent()));
				senhaServico
						.setObservacoes(senhaServicoTag.getElementsByTagName("Observacoes").item(0).getTextContent());
				senhasServico.add(senhaServico);
			}

			return senhasServico;

		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public void store(List<SenhaServico> senhasServico) {

		try {

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbFactory.newDocumentBuilder();
			Document doc = db.newDocument();

			Element rootTag = doc.createElement("BlueKeeper");
			doc.appendChild(rootTag);

			senhasServico.forEach(senhaServico -> {
				Element senhaServicoTag = doc.createElement("SenhaServico");
				senhaServicoTag.setAttribute("id", String.valueOf(senhaServico.getId()));

				Element servicoTag = doc.createElement("Servico");
				servicoTag.appendChild(doc.createTextNode(senhaServico.getServico()));
				senhaServicoTag.appendChild(servicoTag);

				Element loginTag = doc.createElement("Login");
				loginTag.appendChild(doc.createTextNode(senhaServico.getLogin()));
				senhaServicoTag.appendChild(loginTag);

				Element senhaTag = doc.createElement("Senha");
				senhaTag.appendChild(doc.createTextNode(encrypt(senhaServico.getSenha())));
				senhaServicoTag.appendChild(senhaTag);

				Element observacoes = doc.createElement("Observacoes");
				observacoes.appendChild(doc.createCDATASection(
						senhaServico.getObservacoes() == null ? "" : senhaServico.getObservacoes()));
				senhaServicoTag.appendChild(observacoes);

				rootTag.appendChild(senhaServicoTag);
			});

			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer t = tf.newTransformer();
			t.setOutputProperty(OutputKeys.INDENT, "yes");
			t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(Files.newOutputStream(STORAGE_FILE));
			t.transform(source, result);

		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public List<SenhaServico> filter(String text) {

		List<SenhaServico> itens = load();

		String textUpper = text.toUpperCase();

		return itens.stream().filter(
				s -> s.getLogin().toUpperCase().contains(textUpper) || s.getServico().toUpperCase().contains(textUpper))
				.collect(Collectors.toList());
	}

	@Override
	public int generateId() {

		return load().stream().mapToInt(s -> s.getId() + 1).max().orElse(1);
	}
}
