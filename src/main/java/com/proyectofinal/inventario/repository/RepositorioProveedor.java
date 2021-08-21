package com.proyectofinal.inventario.repository;

import com.proyectofinal.inventario.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioProveedor extends JpaRepository<Proveedor,Integer> {
}
