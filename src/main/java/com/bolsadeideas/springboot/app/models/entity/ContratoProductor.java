package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "contrato_productores")
@Entity
public class ContratoProductor implements Serializable {

	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String acuerdo;

	public String direccion;

	public String encargado;

	public String razonsocial;

	@NotNull
	@Column(name = "inicio")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date inicio_contrato;
	@NotNull
	@Column(name = "fin")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date fin_contrato;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "productor_id")
	public Productor productor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getInicio_contrato() {
		return inicio_contrato;
	}

	public void setInicio_contrato(Date inicio_contrato) {
		this.inicio_contrato = inicio_contrato;
	}

	public Date getFin_contrato() {
		return fin_contrato;
	}

	public void setFin_contrato(Date fin_contrato) {
		this.fin_contrato = fin_contrato;
	}

	public Productor getProductor() {
		return productor;
	}

	public void setProductor(Productor productor) {
		this.productor = productor;
	}

	private static final long serialVersionUID = 1L;

	public String getAcuerdo() {
		return acuerdo;
	}

	public void setAcuerdo(String acuerdo) {
		this.acuerdo = acuerdo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEncargado() {
		return encargado;
	}

	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}

	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getCreateFin() {
		return createFin;
	}

	public void setCreateFin(Date createFin) {
		this.createFin = createFin;
	}

}
