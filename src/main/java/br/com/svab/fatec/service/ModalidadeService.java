package br.com.svab.fatec.service;

import java.util.List;

import br.com.svab.fatec.model.Modalidade;

public interface ModalidadeService 
{
	Modalidade findById(Long idModalidade);
	
	Modalidade findByName(String nomeModalidade);
	
	void saveModalidade(Modalidade modalidade);
	
	void updateModalidade(Modalidade modalidade);
	
	void deleteModalidadeById(Long idModalidade);
	
	void deleteAllModalidades();
	
	List<Modalidade> findAllModalidade();
	
}
