package com.proyectofinal.inventario.service.imp;

import com.proyectofinal.inventario.entity.Producto;
import com.proyectofinal.inventario.repository.RepositorioProducto;
import com.proyectofinal.inventario.service.ServicioProducto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioProductoImpl implements ServicioProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioProductoImpl(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    @Override
    public Producto guardarProducto(Producto producto) {
        return repositorioProducto.save(producto);
    }

    @Override
    public List<Producto> listarProductos() {
        return repositorioProducto.findAll();
    }

    @Override
    public Producto obtenerProductoPorId(Long id) {
        return repositorioProducto.findById(id).orElseThrow(() -> new RuntimeException("No se encontro el producto: id: "+id));
    }

    @Override
    public boolean eliminarProductoPorId(Long id) throws Exception {
        Optional<Producto> producto = repositorioProducto.findById(id);
        if (!producto.isPresent()){
            throw new Exception("No se encontro el producto");
        }
        repositorioProducto.deleteById(id);
        return true;
    }
}
