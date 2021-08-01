package com.proyectofinal.inventario.controller;

import com.proyectofinal.inventario.entity.Producto;
import com.proyectofinal.inventario.service.ServicioProducto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ControladorProducto {

    private final ServicioProducto servicioProducto;

    public ControladorProducto(ServicioProducto servicioProducto) {
        this.servicioProducto = servicioProducto;
    }

    @PostMapping
    public ResponseEntity<Producto> guardarProducto(@Valid @RequestBody Producto producto ){
        return new ResponseEntity<>(servicioProducto.guardarProducto(producto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Producto>> listarProductos(){
        return new ResponseEntity<>(servicioProducto.listarProductos(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable("id") Long id){
        return new ResponseEntity<>(servicioProducto.obtenerProductoPorId(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarProductoPorId(@PathVariable("id") Long id)throws Exception{
        return new ResponseEntity(servicioProducto.eliminarProductoPorId(id),HttpStatus.OK);
    }



}
