package com.proyectofinal.inventario.service.imp;

import com.proyectofinal.inventario.entity.Proveedor;
import com.proyectofinal.inventario.exception.ProveedorException;
import com.proyectofinal.inventario.repository.RepositorioProveedor;
import com.proyectofinal.inventario.service.ServicioProveedor;
import com.proyectofinal.inventario.util.Constantes;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioProveedorImpl implements ServicioProveedor {

    private final RepositorioProveedor repositorioProveedor;

    public ServicioProveedorImpl(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }

    @Override
    public Proveedor guardarProveedor(Proveedor proveedor) {
        if (!repositorioProveedor.findById(proveedor.getId()).isPresent()){
            return repositorioProveedor.save(proveedor);
        }
        throw new ProveedorException(Constantes.EXISTE_YA_UN_PROVEEDOR);
    }

    @Override
    public List<Proveedor> listarProveedor() {
        return repositorioProveedor.findAll();
    }

    @Override
    public Proveedor obtenerProveedorPorId(Long id) {
        Optional<Proveedor> buscarProveedor = repositorioProveedor.findById(id);
        if (buscarProveedor.isPresent()){
            return buscarProveedor.get();
        }
        throw new ProveedorException(Constantes.NO_EXISTE_PROVEEDOR);
    }

    @Override
    public boolean eliminarProveedorPorId(Long id) {
        try {
            repositorioProveedor.deleteById(id);
            return true;
        }catch (EmptyResultDataAccessException e){
            return false;
        }
    }
}
