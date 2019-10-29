package com.bolsadeideas.springboot.app.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "users")
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	//DATO UNICO EN LA TABLA UNIQUE
	@Column(unique = true, length = 40)
	private String username;
	//DATO UNICO EN LA TABLA UNIQUE
	@Column(length = 60)
	private String password;

	private Boolean enable;

	
	//Relación con la tabla roles , con cascade , la tabla roles tiene el user_id 
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private List<Rol> roles;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnable() {
		return enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	// private String users_id;
//	private String  users_nombre ;
//	private String  users_ap_materno;
//	private String  users_ap_paterno;
//	private Boolean users_status;
//	private String  user_name; 
//	private String  user_pass;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
