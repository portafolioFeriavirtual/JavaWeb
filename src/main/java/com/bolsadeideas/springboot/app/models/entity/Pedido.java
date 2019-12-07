
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pedidos")
public class Pedido implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String descripcion;
	
	public String observacion;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_pedido")
	public Date createAt;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_termino_pedido")
	public Date createFin;

	@ManyToOne(fetch = FetchType.LAZY)
	public Cliente cliente;
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
	@JoinColumn(name = "pedido_id")
    public List<ItemPedido> items;
	
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL )
	@JoinColumn(name = "estado_id")
	public Estado estado;
	
	
	@OneToOne(fetch = FetchType.LAZY , cascade = CascadeType.ALL)
	@JoinColumn(name = "id_subasta")
	private Subasta subasta;

	
    	
	public Estado getEstado() {
		  
		return estado;
	}




	public void setEstado(Estado estado) {
		this.estado = estado;
	}




	public Pedido() {
      this.items = new ArrayList<ItemPedido>();
	}




	public List<ItemPedido> getItems() {
		return items;
	}




	public void setItems(List<ItemPedido> items) {
		this.items = items;
	}




	@PrePersist
	public void prePresiscreat() {
		createAt = new Date();
	}
	
	/*
	 * @PrePersist public void prePresiscrefin() { createFin = new Date(); }
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItemPedido(ItemPedido item) {
		this.items.add(item);
	}
	
	
	
	
	
	public Double getTotal() {
		Double total = 0.0;	
		int size = items.size();
		for (int i = 0; i < size; i++) {
			total += items.get(i).calcularImporte();
			
		}
		return total;
		
	}
	
	

	private static final long serialVersionUID = 1L;

}
