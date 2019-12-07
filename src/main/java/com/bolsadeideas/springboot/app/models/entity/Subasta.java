package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subastas")
public class Subasta implements Serializable {

	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long idCliente;

	
	
	
	// private Usuario usuario;
	  
	private String nombre_transportista;
	  
	private int monto_transporte;
	  
	
	
	
	 	
	  
	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idUsuario) {
		this.idCliente = idUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getNombre_transportista() {
		return nombre_transportista;
	}

	public void setNombre_transportista(String nombre_transportista) {
		this.nombre_transportista = nombre_transportista;
	}

	public Integer getMonto_transporte() {
		return monto_transporte;
	}

	public void setMonto_transporte(Integer monto_transporte) {
		this.monto_transporte = monto_transporte;
	}

	
	
	  
	public Integer sumarSubasta(Subasta subasta) {
	   int totalsubasta;
	   subasta.setMonto_transporte(monto_transporte + subasta.monto_transporte);
	   totalsubasta = subasta.getMonto_transporte();
	   return  totalsubasta;
	}
	
	
	  
	  
	  
	private static final long serialVersionUID = 1L;
	  
	  
	
}
