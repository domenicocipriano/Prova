package com.domenico.dto;

public class IndirizzoDTO {
	private Long id;
	private String via;
	private String citta;
	private String cap;
	private String provincia;
	private PersonaDTOLight persona;

	
	
	public IndirizzoDTO(Long id,String via, String citta, String cap, String provincia, PersonaDTOLight persona) {
		this.id = id;
		this.via = via;
		this.citta = citta;
		this.cap = cap;
		this.provincia = provincia;
		this.persona = persona;
	}


	public PersonaDTOLight getPersona() {
		return persona;
	}


	public void setPersona(PersonaDTOLight persona) {
		this.persona = persona;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getVia() {
		return via;
	}


	public void setVia(String via) {
		this.via = via;
	}


	public String getCitta() {
		return citta;
	}


	public void setCitta(String citta) {
		this.citta = citta;
	}


	public String getCap() {
		return cap;
	}


	public void setCap(String cap) {
		this.cap = cap;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	

}
