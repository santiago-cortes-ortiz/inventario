package com.proyectofinal.inventario.service.imp;

import com.proyectofinal.inventario.entity.Proveedor;
import com.proyectofinal.inventario.exception.ProveedorException;
import com.proyectofinal.inventario.repository.RepositorioProveedor;
import com.proyectofinal.inventario.service.ServicioProveedor;
import com.proyectofinal.inventario.util.Constantes;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return repositorioProveedor.findById(id).orElseThrow(() ->
        {throw new ProveedorException(Constantes.NO_EXISTE_PROVEEDOR);});
    }

    @Override
    public boolean eliminarProveedorPorId(Long id) {
        return false;
    }
}
