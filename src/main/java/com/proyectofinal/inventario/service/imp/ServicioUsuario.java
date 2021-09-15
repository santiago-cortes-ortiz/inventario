package com.proyectofinal.inventario.service.imp;

import com.proyectofinal.inventario.entity.Usuario;
import com.proyectofinal.inventario.repository.RepositorioUsuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioUsuario implements UserDetailsService {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = repositorioUsuario.findUsuarioByUserName(username);
        if (usuario == null){
            throw new UsernameNotFoundException("No se encontro el usuario");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        usuario.getRols().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });
        UserDetails userDetails = new User(usuario.getUserName(),usuario.getPassword(),roles);
        return userDetails;
    }
}
