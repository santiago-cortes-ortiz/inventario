package com.proyectofinal.inventario.repository;

import com.proyectofinal.inventario.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProducto extends JpaRepository<Producto,Long> {
}
