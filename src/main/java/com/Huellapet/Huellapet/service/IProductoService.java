package com.Huellapet.Huellapet.service;

import com.Huellapet.Huellapet.model.Producto;

import java.util.List;

public interface IProductoService {

    //metodo mostrar productos
    public List<Producto> traerProductos();

    //metodo guardar productos
    public void guardarProducto(Producto p);

    //metodo borrar productos
    public void borrarProducto(Long id);

    //metodo buscar producto por id
    public Producto buscarProducto(Long id);

    //metodo editar producto
    public void editarProducto(Long id_producto, String nuevoNombre, String nuevaCategoria, Double nuevoPrecio, String nuevaDescripcion, String nuevaImagen, boolean nuevaDisponibilidad);
}
