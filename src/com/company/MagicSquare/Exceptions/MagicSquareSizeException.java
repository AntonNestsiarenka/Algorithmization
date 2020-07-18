package com.company.MagicSquare.Exceptions;

public class MagicSquareSizeException extends Exception {

    public MagicSquareSizeException() {
        super("MagicSquareSizeOutOfBounds");
    }

    public MagicSquareSizeException(String message) {
        super(message);
    }

    public MagicSquareSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public MagicSquareSizeException(Throwable cause) {
        super(cause);
    }
}
