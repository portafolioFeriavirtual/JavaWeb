package com.bolsadeideas.springboot.app.models.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.Productor;

public interface IProductorDao extends PagingAndSortingRepository<Productor, Long> {

}
