package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.ContratoProducto;



public interface IContratoProducto {

	public List<ContratoProducto> findAll();
	
	public Page<ContratoProducto> findAll(Pageable pageable);
	
	public void save(ContratoProducto ContratoProducto);
	
	
	
}
