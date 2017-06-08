package br.com.svab.fatec.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.svab.fatec.model.Atleta;
import br.com.svab.fatec.rowmapper.AtletaRowmapper;

@Repository
public class AtletaJDBCRepository 
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

	@Autowired
	@Qualifier("mySqlDataSource")
	public void setAtletaDatasource(DataSource atletaDatasource)
	{
		jdbcTemplate = new JdbcTemplate(atletaDatasource);
	}

	//CRUD Operations
	public Atleta findOne(Long atletaId)
	{
		Atleta atleta = jdbcTemplate.queryForObject(selectAtletaById, new Object[] { atletaId }, new AtletaRowmapper());

		return atleta;
	}
	
	public List<Atleta> findAll() 
	{
		List<Atleta> allAtletas = jdbcTemplate.query(selectAllAtletas, new BeanPropertyRowMapper<Atleta>());
		
		return allAtletas;
	}

	public Atleta findByName(String nomeAtleta) 
	{
		Atleta atleta = jdbcTemplate.queryForObject(selectAtletaByName, new Object[] { nomeAtleta }, new AtletaRowmapper());

		return atleta;
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
