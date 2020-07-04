package com.ini.products.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ini.products.entitys.Product;

//con esto accedemos a los objetos de la base 
//<Product->es la clase que retornara los valores>
//Long->el tipo de dato del id de la tabla
public interface ProductsDAO extends JpaRepository<Product, Long> {

}
