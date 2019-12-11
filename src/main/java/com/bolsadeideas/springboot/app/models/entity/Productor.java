package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name = "productores")
public class Productor implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String nombre_productor;

	public String estado;

	/*
	 * public String direccion;
	 * 
	 * public String encargado;
	 * 
	 * public String razonsocial;
	 */
	
	@ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
	public Usuario Usuario;


	
	
	
	public Usuario getUsuario() {
		return Usuario;
	}

	public void setUsuario(Usuario usuario) {
		Usuario = usuario;
	}




	/*
	 * @NotNull
	 * 
	 * @Column(name = "inicio")
	 * 
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") public Date createAt;
	 * 
	 * 
	 * @NotNull
	 * 
	 * @Column(name = "termino")
	 * 
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @DateTimeFormat(pattern = "yyyy-MM-dd") public Date createFin;
	 */
	

	@OneToMany(mappedBy = "productor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<ContratoProductor> contratoproductor;

	public Productor() {
		contratoproductor = new ArrayList<>();
	}

	/*
	 * @PrePersist public void prePresiscreat() { createAt = new Date(); }
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre_productor() {
		return nombre_productor;
	}

	public void setNombre_productor(String nombre_productor) {
		this.nombre_productor = nombre_productor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<ContratoProductor> getContratoproductor() {
		return contratoproductor;
	}

	public void setContratoproductor(List<ContratoProductor> contratoproductor) {
		this.contratoproductor = contratoproductor;
	}
	

    


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
