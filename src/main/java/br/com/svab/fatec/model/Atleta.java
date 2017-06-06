package br.com.svab.fatec.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="ATLETA")
public class Atleta implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="IDATLETA")
    private Integer idAtleta;
 
	@NotEmpty
    @Column(name="NOMEATLETA", nullable=false)
    private String nomeAtleta;
    
    @NotEmpty
    @Temporal(value = TemporalType.DATE)
    @Column(name="NASCATLETA", nullable=false)
    private Date nascAtleta;

    @ManyToOne
    @NotEmpty
    @Column(name="MODALIDADE_IDMODALIDADE", nullable=false)
    private Modalidade modalidadeAtleta;
    
    @ManyToOne
    @NotEmpty
    @Column(name="PAIS_IDPAIS", nullable=false)
    private Pais paisAtleta;
    
    
    //Getters and Setters
    public Integer getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(Integer idAtleta) {
		this.idAtleta = idAtleta;
	}

	public String getNomeAtleta() {
		return nomeAtleta;
	}

	public void setNomeAtleta(String nomeAtleta) {
		this.nomeAtleta = nomeAtleta;
	}

	public Date getNascAtleta() {
		return nascAtleta;
	}

	public void setNascAtleta(Date nascAtleta) {
		this.nascAtleta = nascAtleta;
	}

	public Modalidade getModalidadeAtleta() {
		return modalidadeAtleta;
	}

	public void setModalidadeAtleta(Modalidade modalidadeAtleta) {
		this.modalidadeAtleta = modalidadeAtleta;
	}

	public Pais getPaisAtleta() {
		return paisAtleta;
	}

	public void setPaisAtleta(Pais paisAtleta) {
		this.paisAtleta = paisAtleta;
	}
 
 
}
