package br.com.svab.fatec.service;

import java.util.List;

import br.com.svab.fatec.model.Pais;

public interface PaisService 
{
	Pais findById(Long idPais);
	
	Pais findByName(String nomePais);
	
	void savePais(Pais pais);
	
	void updatePais(Pais pais);
	
	void deletePaisById(Long idPais);
	
	List<Pais> findAllPais();
	
	boolean isPaisExists(Pais pais);
	
}
