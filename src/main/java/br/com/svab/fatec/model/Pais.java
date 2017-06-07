package br.com.svab.fatec.model;

import java.io.Serializable;

//@Entity
//@Table(name="PAIS")
public class Pais implements Serializable
{
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	@Column(name="IDPAIS")
	private Long idPais;
	
//	@NotEmpty
//	@Column(name="NOMEPAIS", unique=true)
	private String nomePais;

	//Getters and Setters
	public Long getIdPais() {
		return idPais;
	}

	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}

	public String getNomePais() {
		return nomePais;
	}

	public void setNomePais(String nomePais) {
		this.nomePais = nomePais;
	}

}
