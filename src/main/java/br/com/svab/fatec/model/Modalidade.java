package br.com.svab.fatec.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="MODALIDADE")
public class Modalidade implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IDMODALIDADE")
    private Long idModalidade;
    
    @NotEmpty
    @Column(name="NOMEMODALIDADE", nullable=false)
    private String nomeModalidade;
    
    
    //Getters and Setters
    public Long getIdModalidade() {
		return idModalidade;
	}

	public void setIdModalidade(Long idModalidade) {
		this.idModalidade = idModalidade;
	}

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}
	
}
