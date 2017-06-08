package br.com.svab.fatec.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.svab.fatec.model.Pais;
import br.com.svab.fatec.repository.PaisJDBCRepository;
import br.com.svab.fatec.service.PaisService;

@Service
public class PaisServiceImpl implements PaisService
{
	@Autowired
	PaisJDBCRepository paisRepository;
	
	public Pais findById(Long idPais)
	{
		return paisRepository.findOne(idPais);
	}
	
	public Pais findByName(String nomePais)
	{
		return paisRepository.findByName(nomePais);
	}

	public void savePais(Pais pais)
	{
		paisRepository.save(pais);
	}
	
	public void updatePais(Pais pais)
	{
		paisRepository.update(pais);
	}
	
	public void deletePaisById(Long idPais)
	{
		paisRepository.delete(idPais);
	}
	
	public List<Pais> findAllPais()
	{
		return paisRepository.findAll();
	}
	
	public boolean isPaisExists(Pais pais)
	{
		return findByName(pais.getNomePais()) != null;
	}
}
