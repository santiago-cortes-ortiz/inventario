package com.proyectofinal.inventario.controller;

import com.proyectofinal.inventario.dto.RespuestaDTO;
import com.proyectofinal.inventario.service.ServicioUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@Api(
        tags = "Controlador usuarios",
        value = "Controlador Rest para gestionar los usuarios"
)
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @GetMapping
    @ApiOperation("Devuelve una lista de usuarios")
    @ApiResponse(code = 200,message = "Se listaron los usuarios ")
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
