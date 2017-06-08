package br.com.svab.fatec.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.svab.fatec.model.Atleta;

@Repository
public class AtletaJDBCRepositoryTest 
{
	private JdbcTemplate jdbcTemplate;

	@Value("${br.com.svab.fatec.select.atleta.single}")
	private String selectAtletaById;

	@Value("${br.com.svab.fatec.select.atleta.name}")
	private String selectAtletaByName;
	
	@Value("${br.com.svab.fatec.select.atleta.all}")
	private String selectAllAtletas;

	@Value("${br.com.svab.fatec.insert.atleta}")
	private String insertAtleta;
	
	@Value("${br.com.svab.fatec.update.atleta}")
	private String updateAtleta;
	
	@Value("${br.com.svab.fatec.delete.atleta.single}")
	private String deleteAtletaById;

	//CRUD Operations
	public Atleta findOne(Long atletaId)
	{
		Atleta atleta = new Atleta(101, "John", 1, 1);
		
		return atleta;
	}
	
	public List<Atleta> findAll() 
	{
		List<Atleta> allAtletas = new ArrayList<Atleta>();
		
		allAtletas.add(new Atleta(101, "John", 1, 1));
		allAtletas.add(new Atleta(201, "Doe", 2, 2));
		allAtletas.add(new Atleta(301, "Eck", 3, 3));
		
		return allAtletas;
	}

	public Atleta findByName(String nomeAtleta) 
	{
		//Atleta atleta = jdbcTemplate.queryForObject(selectAtletaByName, new Object[] { nomeAtleta }, new AtletaRowmapper());
		
		return null;
	}

	public void save(Atleta atleta) 
	{
		Object[] params = new Object[] {atleta.getIdAtleta(),atleta.getNomeAtleta(),atleta.getNascAtleta(),atleta.getModalidadeAtleta(),atleta.getPaisAtleta()};

		jdbcTemplate.update(insertAtleta, params);
	}

	public void update(Atleta atleta) 
	{
		Object[] params = new Object[] {atleta.getNomeAtleta(),atleta.getNascAtleta(),atleta.getModalidadeAtleta(),atleta.getPaisAtleta()};

		jdbcTemplate.update(updateAtleta, params);
	}
	
	public void delete(Long atletaId) 
	{
		jdbcTemplate.update(deleteAtletaById, new Object[] { atletaId });
	}

}
