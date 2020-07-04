package com.ini.products.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //indica que es una entidad
@Table(name="products") //que see grabaran en la tabla product
public class Product {
	@Id //se indica que es el id de la tabla
	@Column(name="id") //columna de la tabla
	@GeneratedValue(strategy = GenerationType.IDENTITY) //se indica que sea autoincrementable
	private Long id;
	
	@Column(name="name", nullable = false, length = 30)
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
