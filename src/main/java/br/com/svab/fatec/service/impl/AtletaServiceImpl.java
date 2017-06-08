package br.com.svab.fatec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.svab.fatec.model.Atleta;
import br.com.svab.fatec.repository.AtletaJDBCRepositoryTest;
import br.com.svab.fatec.service.AtletaService;

@Service
public class AtletaServiceImpl implements AtletaService
{
	@Autowired
	AtletaJDBCRepositoryTest atletaRepository;
	
	public Atleta findById(Long idAtleta)
	{
		return atletaRepository.findOne(idAtleta);
	}
	
	public Atleta findByName(String nomeAtleta)
	{
		return atletaRepository.findByName(nomeAtleta);
	}

	public void saveAtleta(Atleta atleta)
	{
		atletaRepository.save(atleta);
	}
	
	public void updateAtleta(Atleta atleta)
	{
		atletaRepository.update(atleta);
	}
	
	public void deleteAtletaById(Long idAtleta)
	{
		atletaRepository.delete(idAtleta);
	}
	
	public List<Atleta> findAllAtletas()
	{
		return atletaRepository.findAll();
	}
	
	public boolean isAtletaExists(Atleta atleta)
	{
		return findByName(atleta.getNomeAtleta()) != null;
	}
}
