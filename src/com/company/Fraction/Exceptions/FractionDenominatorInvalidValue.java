package com.company.Fraction.Exceptions;

public class FractionDenominatorInvalidValue extends Exception {
    public FractionDenominatorInvalidValue() {
        super();
    }

    public FractionDenominatorInvalidValue(String message) {
        super(message);
    }

    public FractionDenominatorInvalidValue(String message, Throwable cause) {
        super(message, cause);
    }

    public FractionDenominatorInvalidValue(Throwable cause) {
        super(cause);
    }
}
