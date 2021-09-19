package com.proyectofinal.inventario.controller;

import com.proyectofinal.inventario.dto.RespuestaDTO;
import com.proyectofinal.inventario.service.ServicioUsuario;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping
    public RespuestaDTO listarUsuarios(){
        return new RespuestaDTO(
                false,
                HttpStatus.OK.value(),
                "Se listaron los usuarios correctamente",
                servicioUsuario.listarUsuario(),
                String.valueOf(System.currentTimeMillis())
        );
    }
}
