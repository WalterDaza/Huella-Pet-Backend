package com.Huellapet.Huellapet.repository;

import com.Huellapet.Huellapet.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository <Producto, Long> {

}
