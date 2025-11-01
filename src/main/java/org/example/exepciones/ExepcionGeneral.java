package org.example.exepciones;

public class ExepcionGeneral extends AssertionError{
    public ExepcionGeneral(String message) {
        super(message);
    }
}
