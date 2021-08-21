package com.proyectofinal.inventario.service;

import com.proyectofinal.inventario.entity.Producto;
import com.proyectofinal.inventario.entity.Proveedor;

import java.util.List;

public interface ServicioProveedor {
    Proveedor guardarProveedor(Proveedor proveedor);

    List<Proveedor> listarProveedor();

    Proveedor obtenerProveedorPorId(Long id);

    boolean eliminarProveedorPorId(Long id);
}
