package br.com.svab.fatec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.svab.fatec.model.Modalidade;
import br.com.svab.fatec.repository.ModalidadeJDBCRepository;
import br.com.svab.fatec.service.ModalidadeService;

@Service
public class ModalidadeServiceImpl implements ModalidadeService
{
	@Autowired
	ModalidadeJDBCRepository modalidadeRepository;
	
	public Modalidade findById(Long idModalidade)
	{
		return modalidadeRepository.findOne(idModalidade);
	}
	
	public Modalidade findByName(String nomeModalidade)
	{
		return modalidadeRepository.findByName(nomeModalidade);
	}

	public void saveModalidade(Modalidade modalidade)
	{
		modalidadeRepository.save(modalidade);
	}
	
	public void updateModalidade(Modalidade modalidade)
	{
		modalidadeRepository.update(modalidade);
	}
	
	public void deleteModalidadeById(Long idModalidade)
	{
		modalidadeRepository.delete(idModalidade);
	}
	
	public List<Modalidade> findAllModalidade()
	{
		return modalidadeRepository.findAll();
	}
	
	public boolean isModalidadeExists(Modalidade modalidade)
	{
		return findByName(modalidade.getNomeModalidade()) != null;
	}
}
