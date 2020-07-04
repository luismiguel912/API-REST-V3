package com.ini.products.rest;

import java.awt.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ini.products.dao.ProductsDAO;
import com.ini.products.entitys.Product;
import com.sun.el.stream.Optional;

//le indicamos que esta clase sera un Servicio REST
@RestController
//en que url se dispondra los servicios
@RequestMapping("products")
public class ProductsREST {
	
	//inyeccion de dependencia de ProductsDAO
	@Autowired
	private ProductsDAO productDAO;
	
	@GetMapping
	//ResponseEntity -> regresa objetos de la Class Product
	//getProduct nombre del metodo
	//List<> devuenbe todo lo de la base
	public ResponseEntity<java.util.List<Product>> getProduct(){
		java.util.List<Product> products = productDAO.findAll();
		//regresa un estatus 200 de que salio bien 
		return ResponseEntity.ok(products);
	}

	
	@RequestMapping(value="{productId}")
	//ResponseEntity -> regresa objetos de la Class Product
	//getProduct nombre del metodo
	//List<> devuenbe todo lo de la base
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId){
		java.util.Optional<Product> optinalProduct = productDAO.findById(productId);
		
		if(optinalProduct.isPresent()) {
			return ResponseEntity.ok(optinalProduct.get());
		}else {
			//regresa un estatus 200 de que salio bien 
		
		return ResponseEntity.noContent().build();
		}
		
	}
	
	@PostMapping
	//para crear un producto
	public ResponseEntity<Product> createProduct(@RequestBody Product product){
		Product newProduct = productDAO.save(product);
		return ResponseEntity.ok(newProduct);
	}
	
@DeleteMapping(value="{productId}")
//para eliminar un producto
public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId){
	productDAO.deleteById(productId);
	return ResponseEntity.ok(null);
}

@PutMapping
public ResponseEntity<Product> updateProduct(@RequestBody Product product){
	java.util.Optional<Product> optinalProduct = productDAO.findById(product.getId());
	if(optinalProduct.isPresent()) {
		Product updateProduct = optinalProduct.get();
		updateProduct.setName(product.getName());
		productDAO.save(updateProduct);
		return ResponseEntity.ok(updateProduct);
	}else {
		//regresa un estatus 200 de que salio bien 
	
	return ResponseEntity.notFound().build();
	}
	
}

		
	
	
	
	
	
	
	
	//Que sera un clase get
	//@GetMapping //localhost:8080/
	//se indica en que url estara este servicio y que metodo se tomara en este caso GET
	//value=hello->ruta para acceder al metodo
	//@RequestMapping(value="hello", method = RequestMethod.GET) //localhost:8080/hello
	public String hello() {
		return "Hello world";
	}
}
