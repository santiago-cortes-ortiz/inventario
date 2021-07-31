package com.proyectofinal.inventario.exception;

public class ModeloNotFoundException extends  RuntimeException{
    public ModeloNotFoundException(String message) {
        super(message);
    }
}
