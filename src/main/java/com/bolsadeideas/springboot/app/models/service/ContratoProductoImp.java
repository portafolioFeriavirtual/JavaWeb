package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.bolsadeideas.springboot.app.models.entity.ContratoProducto;

public class ContratoProductoImp implements IContratoProducto {

	@Autowired
	private IContratoProducto contratoProducto;
	
	
	
	@Override
	public List<ContratoProducto> findAll() {
	
		return (List<ContratoProducto>) contratoProducto.findAll();
	}

	@Override
	public Page<ContratoProducto> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ContratoProducto ContratoProducto) {
		// TODO Auto-generated method stub
		
	}

}
