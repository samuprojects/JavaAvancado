package br.com.softblue.java.calculadora;

public enum Operation {
	SUM('+'), SUBTRACT('-'), MULTIPLY('*'), DIVIDE('/'), EQUALS('=');

	char symbol;

	Operation(char symbol) {
		this.symbol = symbol;
	}

	public double apply(double n1, double n2) {
		if (this == Operation.SUM) {
			return n1 + n2;

		} else if (this == Operation.SUBTRACT) {
			return n1 - n2;

		} else if (this == Operation.MULTIPLY) {
			return n1 * n2;

		} else if (this == Operation.DIVIDE) {
			return n1 / n2;
		}

		throw new UnsupportedOperationException("O operador '" + symbol + "' não suporta esta operação");
	}

	public static Operation fromSymbol(char symbol) {
		for (Operation o : Operation.values()) {
			if (o.symbol == symbol) {
				return o;
			}
		}

		return null;
	}

}
