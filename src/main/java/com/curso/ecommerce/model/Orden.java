package com.curso.ecommerce.model;

import java.util.Date;

public class Orden {

	private Integer id;
	private String numero;
	private Date fechaCreacion;
	private Date fechaRecibida;
	private double total;

	public Orden() {
		super();
	}

	public Orden(Integer id, String numero, Date fechaCreacion, Date fechaRecibida, double total) {
		super();
		this.id = id;
		this.numero = numero;
		this.fechaCreacion = fechaCreacion;
		this.fechaRecibida = fechaRecibida;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaRecibida() {
		return fechaRecibida;
	}

	public void setFechaRecibida(Date fechaRecibida) {
		this.fechaRecibida = fechaRecibida;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Orden [id=");
		builder.append(id);
		builder.append(", numero=");
		builder.append(numero);
		builder.append(", fechaCreacion=");
		builder.append(fechaCreacion);
		builder.append(", fechaRecibida=");
		builder.append(fechaRecibida);
		builder.append(", total=");
		builder.append(total);
		builder.append("]");
		return builder.toString();
	}

	

}
