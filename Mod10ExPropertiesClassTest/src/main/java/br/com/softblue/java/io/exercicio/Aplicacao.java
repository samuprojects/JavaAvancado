package br.com.softblue.java.io.exercicio;

public class Aplicacao {

	public static void main(String[] args) throws Exception {

		Config c = new Config("info.properties");

		String versao = c.getPropertyAsString("appVersion");
		if (versao == null) {
			c.setProperty("appVersion", "1.0.1");
			System.out.println("Propriedade adicionada: 'appVersion'");
		} else {
			System.out.println("Propriedade 'appVersion' lida: " + versao);
		}

		Boolean enviarEmail = c.getPropertyAsBoolean("sendEmail");
		if (enviarEmail == null) {
			c.setProperty("sendEmail", true);
			System.out.println("Propriedade adicionada: 'sendEmail'");
			;
		} else {
			System.out.println("Propriedade 'sendEmail' lida: " + enviarEmail);
		}

		Integer tempoEspera = c.getPropertyAsInteger("wait");
		if (tempoEspera == null) {
			c.setProperty("wait", 1000);
			System.out.println("Propriedade adicionada: 'wait'");
		} else {
			System.out.println("Propriedade 'wait' lida: " + tempoEspera);
		}
	}
}