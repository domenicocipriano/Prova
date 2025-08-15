package com.domenico.dto;

public class CartaDTOLight {
	private Long id;
	private String numeroCarta;
	
	public CartaDTOLight() {
	}
	public CartaDTOLight(Long id, String numeroCarta) {
		this.id = id;
		this.numeroCarta = numeroCarta;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	

}
