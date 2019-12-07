package com.bolsadeideas.springboot.app.models.service;


import com.bolsadeideas.springboot.app.models.entity.Subasta;

public interface ISubastaService {
	
	public void save(Subasta subasta);
	public Subasta findByIdCliente(Long id);
	
}
