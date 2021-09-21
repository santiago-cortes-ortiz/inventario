package com.proyectofinal.inventario.controller;

import com.proyectofinal.inventario.dto.RespuestaDTO;
import com.proyectofinal.inventario.exception.ProveedorException;
import com.proyectofinal.inventario.exception.UsuarioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public RespuestaDTO<Object> exception(Exception e) {
        return new RespuestaDTO(true, HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),String.valueOf(System.currentTimeMillis()));
    }

    @ExceptionHandler(ProveedorException.class)
    public RespuestaDTO<Object> exception(ProveedorException e) {
        return new RespuestaDTO(true, HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),String.valueOf(System.currentTimeMillis()));
    }

    @ExceptionHandler(UsuarioException.class)
    public RespuestaDTO<Object> exception(UsuarioException e) {
        return new RespuestaDTO(true, HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage(),String.valueOf(System.currentTimeMillis()));
    }
}
