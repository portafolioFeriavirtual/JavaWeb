package com.bolsadeideas.springboot.app.models.implement;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.dao.IProductorDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Productor;
import com.bolsadeideas.springboot.app.models.service.IProductorService;


@Service
public class ProductorServiceImpl implements IProductorService {

	@Autowired
	private IProductorDao productorDao;
	
	
	@Override
	public List<Productor> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Productor> findAll(Pageable pageable) {
		return productorDao.findAll(pageable);
	}

	@Override
	public void save(Productor productor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Productor findOne(Long id) {
		// TODO Auto-generated method stub
		return productorDao.findById(id).orElse(null);
	}

}
