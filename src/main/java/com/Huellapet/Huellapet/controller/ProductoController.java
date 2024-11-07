package com.Huellapet.Huellapet.controller;

import com.Huellapet.Huellapet.model.Producto;
import com.Huellapet.Huellapet.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5502")
@RestController
public class ProductoController {
    @Autowired
    private IProductoService productoService;

    //Endpoint de buscar productos
    @GetMapping("/producto/traer")
    public List<Producto> traerProductos(){
        return productoService.traerProductos();
    }

    @GetMapping("/producto/traer/{id}")
    public Producto buscarProducto(@PathVariable Long id) {
        return productoService.buscarProducto(id);
    }

    //Endopoint de crear productos
    @PostMapping("/producto/crear")
    public String guardarProducto(@RequestBody Producto p){
        productoService.guardarProducto(p);
        return "Se ha creado el producto";
    }

    //Endpoint de borrar producto
    @DeleteMapping("/producto/borrar/{id}")
    public String borrarProducto(@PathVariable Long id){
        productoService.borrarProducto(id);
        return "Se ha eliminado el producto";
    }

    //Endopoint de editar producto
    @PutMapping("/producto/editar/{id_producto}")
    public Producto editarProducto(@PathVariable Long id_producto,
                                   @RequestParam(required = false, name = "nombre") String nuevoNombre,
                                   @RequestParam(required = false, name = "categoria") String nuevaCategoria,
                                   @RequestParam(required = false, name = "precio") Double nuevoPrecio,
                                   @RequestParam(required = false, name = "descripcion") String nuevaDescripcion,
                                   @RequestParam(required = false, name = "imagen") String nuevaImagen,
                                   @RequestParam(required = false, name = "disponibilidad") boolean nuevaDisponibilidad){
        productoService.editarProducto(id_producto, nuevoNombre, nuevaCategoria, nuevoPrecio, nuevaDescripcion, nuevaImagen, nuevaDisponibilidad);
        Producto p = productoService.buscarProducto(id_producto);
        return p;
    }
}
