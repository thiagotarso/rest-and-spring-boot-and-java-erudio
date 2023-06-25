package com.example.model;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
    private String nombre;
    private String Documento;
    private String direccion;
    private String codigoPostal;
    private String ciudad;
    private String provincia;
    
	public Person() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return Documento;
	}

	public void setDocumento(String documento) {
		Documento = documento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Documento, ciudad, codigoPostal, direccion, id, nombre, provincia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(Documento, other.Documento) && Objects.equals(ciudad, other.ciudad)
				&& Objects.equals(codigoPostal, other.codigoPostal) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(provincia, other.provincia);
	}
}
