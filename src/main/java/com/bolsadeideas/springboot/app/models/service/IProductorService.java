package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.bolsadeideas.springboot.app.models.entity.Productor;

public interface IProductorService {

	public List<Productor> findAll();

	public Page<Productor> findAll(Pageable pageable);
	
	public void save(Productor productor);

}
