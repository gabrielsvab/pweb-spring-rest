package br.com.svab.fatec.model;

import java.io.Serializable;
import java.util.Date;

//@Entity
//@Table(name="ATLETA")
public class Atleta
{
//	@Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    @Column(name="IDATLETA")
    private Long idAtleta;
 
//	@NotEmpty
//    @Column(name="NOMEATLETA", nullable=false)
    private String nomeAtleta;
    
//    @NotEmpty
//    @Temporal(value = TemporalType.DATE)
//    @Column(name="NASCATLETA", nullable=false)
    private Date nascAtleta;

//    @ManyToOne
//    @NotEmpty
//    @Column(name="MODALIDADE_IDMODALIDADE", nullable=false)
    private Long modalidadeAtleta;
    
//    @ManyToOne
//    @NotEmpty
//    @Column(name="PAIS_IDPAIS", nullable=false)
    private Long paisAtleta;
    
    public Atleta(long idAtleta, String nomeAtleta, long modalidadeAtleta, long paisAtleta)
    {
    	this.idAtleta = idAtleta;
    	this.nomeAtleta = nomeAtleta;
    	this.nascAtleta = new Date();
    	this.modalidadeAtleta = modalidadeAtleta;
    	this.paisAtleta = paisAtleta;
    }
    
    public Atleta(){};
    
    
    //Getters and Setters
    public Long getIdAtleta() {
		return idAtleta;
	}

	public void setIdAtleta(Long idAtleta) {
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

	public Long getModalidadeAtleta() {
		return modalidadeAtleta;
	}

	public void setModalidadeAtleta(Long modalidadeAtleta) {
		this.modalidadeAtleta = modalidadeAtleta;
	}

	public Long getPaisAtleta() {
		return paisAtleta;
	}

	public void setPaisAtleta(Long paisAtleta) {
		this.paisAtleta = paisAtleta;
	}
 
 
}
