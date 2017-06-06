package br.com.svab.fatec.service;

import java.util.List;

import br.com.svab.fatec.model.Atleta;

public interface AtletaService 
{
	Atleta findById(Long idAtleta);
	
	Atleta findByName(String nomeAtleta);
	
	void saveAtleta(Atleta atleta);
	
	void updateAtleta(Atleta atleta);
	
	void deleteAtletaById(Long idAtleta);
	
	void deleteAllAtletas();
	
	List<Atleta> findAllAtletas();
	
	boolean isAtletaExists(Atleta atleta);
}
