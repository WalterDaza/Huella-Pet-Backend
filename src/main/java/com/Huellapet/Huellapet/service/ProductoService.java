package com.Huellapet.Huellapet.service;

import com.Huellapet.Huellapet.model.Producto;
import com.Huellapet.Huellapet.repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService implements IProductoService{
    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> traerProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        return  listaProductos;
    }

    @Override
    public void guardarProducto(Producto p) {
        productoRepository.save(p);
    }

    @Override
    public void borrarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    @Override
    public Producto buscarProducto(Long id) {
        Producto p = productoRepository.findById(id).orElse(null);
        return p;
    }

    @Override
    public void editarProducto(Long id_producto, String nuevoNombre, String nuevaCategoria, Double nuevoPrecio, String nuevaDescripcion, String nuevaImagen, boolean nuevaDisponibilidad) {
        Producto p = this.buscarProducto(id_producto);

        if (nuevoNombre != null) p.setNombre(nuevoNombre);
        if (nuevaCategoria != null) p.setCategoria(nuevaCategoria);
        if (nuevoPrecio != null) p.setPrecio(nuevoPrecio);
        if (nuevaDescripcion != null) p.setDescripcion(nuevaDescripcion);
        if (nuevaImagen != null) p.setImagen(nuevaImagen);
        p.setDisponibilidad(nuevaDisponibilidad);

        this.guardarProducto(p);
    }
}
