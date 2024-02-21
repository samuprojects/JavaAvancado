package br.com.softblue.java.calculadora;

import java.text.NumberFormat;
import java.util.Locale;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;

@SuppressWarnings("deprecation")
public class CalcModel {

	private static final int MAX_LENGTH = 12;

	private static final int MAX_FRACTION_DIGITS = 4;

	public static final NumberFormat NUMBER_FORMAT;

	static {

		NUMBER_FORMAT = NumberFormat.getNumberInstance(new Locale("en", "US"));

		NUMBER_FORMAT.setMinimumFractionDigits(0);

		NUMBER_FORMAT.setMaximumFractionDigits(MAX_FRACTION_DIGITS);

		NUMBER_FORMAT.setGroupingUsed(false);
	}

	private DoubleProperty currentValue = new SimpleDoubleProperty();

	private BooleanProperty error = new SimpleBooleanProperty();

	private double savedValue;

	private boolean appendComma;

	private Operation currentOperation;

	private boolean clearOnNextNumber;

	private boolean operationApplied;

	public DoubleProperty currentValueProperty() {
		return this.currentValue;
	}

	public double getCurrentValue() {
		return this.currentValueProperty().get();
	}

	public void setCurrentValue(double result) {
		this.currentValueProperty().set(result);
	}

	public void appendNumber(int number) {
		String resultStr = getResultAsString();

		if (clearOnNextNumber) {
			resultStr = "";

			if (operationApplied) {
				clear();

			} else {
				clearOnNextNumber = false;

			}

		} else if (resultStr.length() == MAX_LENGTH) {
			return;
		}

		if (appendComma) {
			resultStr += "." + number;

			appendComma = false;

		} else {
			resultStr += number;
		}

		setCurrentValue(Double.parseDouble(resultStr));
	}

	public void appendComma() {
		String resultStr = getResultAsString();

		if (!resultStr.contains(".")) {
			appendComma = true;

		}
	}

	public void clear() {
		setCurrentValue(0);
		savedValue = 0;
		currentOperation = null;
		appendComma = false;
		clearOnNextNumber = false;
		operationApplied = false;
		setError(false);
	}

	public void doOperation(Operation operation) {
		if (operation != Operation.EQUALS) {
			currentOperation = operation;
			clearOnNextNumber = true;
			savedValue = getCurrentValue();
			operationApplied = false;

		} else if (!operationApplied && currentOperation != null) {
			double value = currentOperation.apply(savedValue, getCurrentValue());
			operationApplied = true;
			setCurrentValue(value);
			clearOnNextNumber = true;

			String resultStr = getResultAsString();
			if (resultStr.length() > MAX_LENGTH) {
				resultStr = resultStr.substring(0, MAX_LENGTH);
				setCurrentValue(Double.parseDouble(resultStr));
				setError(true);
			}
		}

		appendComma = false;
	}

	private String getResultAsString() {
		return NUMBER_FORMAT.format(getCurrentValue());
	}

	public BooleanProperty errorProperty() {
		return this.error;
	}

	public boolean isError() {
		return this.errorProperty().get();
	}

	public void setError(final boolean error) {
		this.errorProperty().set(error);
	}
}
