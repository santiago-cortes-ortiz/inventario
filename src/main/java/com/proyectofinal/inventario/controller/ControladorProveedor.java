package com.proyectofinal.inventario.controller;

import com.proyectofinal.inventario.dto.RespuestaDTO;
import com.proyectofinal.inventario.entity.Proveedor;
import com.proyectofinal.inventario.service.ServicioProveedor;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/proveedores")
@Api(
        tags = "Controlador proveedor",
        value = "Controlador Rest para gestionar el proveedor"
)
public class ControladorProveedor {

    private final ServicioProveedor servicioProveedor;

    public ControladorProveedor(ServicioProveedor servicioProveedor) {
        this.servicioProveedor = servicioProveedor;
    }

    @PostMapping
    @ApiOperation("Guarda un proveedor")
    @ApiResponses(
            {
                    @ApiResponse(code = 201,message = "Guarda un proveedor con exito"),
                    @ApiResponse(code = 500,message = "Ocurrio un error en el servidor")
            }
    )
    public RespuestaDTO<Proveedor> guardarProveedor(
            @ApiParam(value = "El cuerpo con el cual se guardara el proveedor", required = true) @RequestBody @Valid Proveedor proveedor
    ){
        return new RespuestaDTO<Proveedor>(
                false,
                HttpStatus.CREATED.value(),
                "Se guardo con exito el proveedor",
                servicioProveedor.guardarProveedor(proveedor),
                String.valueOf(System.currentTimeMillis())
        );
    }

    @GetMapping
    @ApiOperation("Devuelve todos los proveedores")
    @ApiResponse(code = 200,message = "OK")
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
    @ApiOperation("Actualiza un proveedor")
    @ApiResponses(
            {
                    @ApiResponse(code = 204,message = "Se actualiza un proveedor con exito"),
                    @ApiResponse(code = 500,message = "Ocurrio un error en el servidor")
            }
    )
    public RespuestaDTO<Proveedor> modificarProveedor(@ApiParam(value = "El cuerpo con el cual se actualizar el proveedor", required = true)@RequestBody @Valid Proveedor proveedor){
        return new RespuestaDTO<>(
                false,
                HttpStatus.NO_CONTENT.value(),
                "Se actualizo con exito el proveedor",
                servicioProveedor.modificarProveedor(proveedor),
                String.valueOf(System.currentTimeMillis())
        );
    }


}
