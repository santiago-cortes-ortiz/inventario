package com.proyectofinal.inventario.service;

import com.proyectofinal.inventario.entity.Producto;

import java.util.List;

public interface ServicioProducto {
    Producto guardarProducto(Producto producto);

    List<Producto> listarProductos();

    Producto obtenerProductoPorId(Long id);

    boolean eliminarProductoPorId(Long id) throws Exception;
}
