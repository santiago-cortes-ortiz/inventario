package com.proyectofinal.inventario.dto;

import java.io.Serializable;

public class RespuestaDTO<T> implements Serializable {

    private boolean fallo;

    private int codigo;

    private String mensaje;

    private T cuerpo;

    private String timestamp;

    public RespuestaDTO(boolean fallo, int codigo, String mensaje, T cuerpo, String timestamp) {
        this.fallo = fallo;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.cuerpo = cuerpo;
        this.timestamp = timestamp;
    }

    public RespuestaDTO(boolean fallo, int codigo, String mensaje, String timestamp) {
        this.fallo = fallo;
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.timestamp = timestamp;
    }

    public boolean isFallo() {
        return fallo;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public T getCuerpo() {
        return cuerpo;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
