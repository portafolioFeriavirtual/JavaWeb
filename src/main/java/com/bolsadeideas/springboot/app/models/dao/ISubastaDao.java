package com.bolsadeideas.springboot.app.models.dao;




import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.bolsadeideas.springboot.app.models.entity.Subasta;

public interface ISubastaDao extends CrudRepository<Subasta, Long> {

	@Query("select s from Subasta s where id_cliente = ?1")
	public Subasta findByIdCliente(Long id);
	
}
