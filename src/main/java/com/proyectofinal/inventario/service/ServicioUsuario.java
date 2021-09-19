package com.proyectofinal.inventario.service;

import com.proyectofinal.inventario.entity.Proveedor;
import com.proyectofinal.inventario.entity.Usuario;

import java.util.List;

public interface ServicioUsuario {
    Usuario guardarUsuario(Usuario usuario);

    List<Usuario> listarUsuario();

    Usuario obtenerUsuarioPorId(Long id);

    boolean eliminarUsuarioPorId(Long id);
}
