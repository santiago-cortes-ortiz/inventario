package com.proyectofinal.inventario.controller;

import com.proyectofinal.inventario.dto.RespuestaDTO;
import com.proyectofinal.inventario.entity.Proveedor;
import com.proyectofinal.inventario.service.ServicioProveedor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/proveedores")
public class ControladorProveedor {

    private final ServicioProveedor servicioProveedor;

    public ControladorProveedor(ServicioProveedor servicioProveedor) {
        this.servicioProveedor = servicioProveedor;
    }

    @PostMapping
    public RespuestaDTO<Proveedor> guardarProveedor(@RequestBody @Valid Proveedor proveedor){
        return new RespuestaDTO<Proveedor>(
                false,
                HttpStatus.CREATED.value(),
                "Se guardo con exito el proveedor",
                servicioProveedor.guardarProveedor(proveedor),
                String.valueOf(System.currentTimeMillis())
        );
    }

    @GetMapping
    public RespuestaDTO listarProveedores(){
        return new RespuestaDTO(
                false,
                HttpStatus.OK.value(),
                "Se listaron con exito los proveedores",
                servicioProveedor.listarProveedor(),
                String.valueOf(System.currentTimeMillis())
        );
    }

    @PutMapping
    public RespuestaDTO<Proveedor> modificarProveedor(@RequestBody @Valid Proveedor proveedor){
        return new RespuestaDTO<>(
                false,
                HttpStatus.NO_CONTENT.value(),
                "Se actualizo con exito el proveedor",
                servicioProveedor.modificarProveedor(proveedor),
                String.valueOf(System.currentTimeMillis())
        );
    }


}
