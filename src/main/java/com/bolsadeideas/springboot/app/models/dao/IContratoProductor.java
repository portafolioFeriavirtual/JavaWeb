package com.bolsadeideas.springboot.app.models.dao;


import org.springframework.data.repository.PagingAndSortingRepository;

import com.bolsadeideas.springboot.app.models.entity.ContratoProducto;

public interface IContratoProductor extends PagingAndSortingRepository<ContratoProducto, Long> {

}
