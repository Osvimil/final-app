package com.videumcorp.desarrolladorandroid.cursosinformaticosconandroid.utils;

/**
 * Created by David on 24/05/2016.
 */
public class Respuesta<T> {
    private final T resultado;
    private final Exception exception;
    public Respuesta(T resultado, Exception exception) {
        this.resultado = resultado;
        this.exception = exception;
    }
    public Exception getException() {
        return exception;
    }
    public T getResultado() {
        return resultado;
    }
}

