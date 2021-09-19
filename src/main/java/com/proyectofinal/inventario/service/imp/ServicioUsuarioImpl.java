package com.proyectofinal.inventario.service.imp;

import com.proyectofinal.inventario.entity.Usuario;
import com.proyectofinal.inventario.exception.UsuarioException;
import com.proyectofinal.inventario.repository.RepositorioUsuario;
import com.proyectofinal.inventario.service.ServicioUsuario;
import com.proyectofinal.inventario.util.Constantes;
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
public class ServicioUsuarioImpl implements UserDetailsService, ServicioUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
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

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return repositorioUsuario.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return repositorioUsuario.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return repositorioUsuario.findById(id).orElseThrow(() -> new UsuarioException(Constantes.NO_EXISTE_USUARIO));
    }

    @Override
    public boolean eliminarUsuarioPorId(Long id) {
        try{
            repositorioUsuario.deleteById(id);
            return true;
        }catch(UsuarioException ex){
            return false;
        }
    }
}
