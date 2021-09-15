package com.proyectofinal.inventario.repository;

import com.proyectofinal.inventario.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioUsuario extends JpaRepository<Usuario,Integer> {

    Usuario findUsuarioByUserName(String username);

}
