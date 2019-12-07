package com.bolsadeideas.springboot.app.models.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.ISubastaDao;
import com.bolsadeideas.springboot.app.models.entity.Subasta;
import com.bolsadeideas.springboot.app.models.service.ISubastaService;

@Service
public class SubastaServiceImpl implements ISubastaService{

	
	@Autowired
	private ISubastaDao subastaDao;

	@Override
	public void save(Subasta subasta) {
		subastaDao.save(subasta);
		
	}

	@Override
	public Subasta findByIdCliente(Long id) {
		
		return subastaDao.findByIdCliente(id);
	}
	
	
	


}
