package br.com.svab.fatec.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.svab.fatec.model.Pais;
import br.com.svab.fatec.rowmapper.PaisRowmapper;

@Repository
public class PaisJDBCRepository 
{
	private JdbcTemplate jdbcTemplate;

	@Value("${br.com.svab.fatec.select.pais.single}")
	private String selectPaisById;

	@Value("${br.com.svab.fatec.select.pais.name}")
	private String selectPaisByName;
	
	@Value("${br.com.svab.fatec.select.pais.all}")
	private String selectAllPais;

	@Value("${br.com.svab.fatec.insert.pais}")
	private String insertPais;
	
	@Value("${br.com.svab.fatec.update.pais}")
	private String updatePais;
	
	@Value("${br.com.svab.fatec.delete.pais.single}")
	private String deletePaisById;

	@Autowired
	@Qualifier("mySqlDataSource")
	public void setPaisDatasource(DataSource paisDatasource)
	{
		jdbcTemplate = new JdbcTemplate(paisDatasource);
	}

	//CRUD Operations
	public Pais findOne(Long idPais)
	{
		Pais pais = jdbcTemplate.queryForObject(selectPaisById, new Object[] { idPais }, new PaisRowmapper());

		return pais;
	}
	
	public List<Pais> findAll() 
	{
		List<Pais> allPais = jdbcTemplate.query(selectAllPais, new BeanPropertyRowMapper<Pais>());
		
		return allPais;
	}

	public Pais findByName(String nomePais) 
	{
		Pais pais = jdbcTemplate.queryForObject(selectPaisByName, new Object[] { nomePais }, new PaisRowmapper());

		return pais;
	}

	public void save(Pais pais) 
	{
		Object[] params = new Object[] {pais.getIdPais(),pais.getNomePais()};

		jdbcTemplate.update(insertPais, params);
	}

	public void update(Pais pais) 
	{
		Object[] params = new Object[] {pais.getNomePais()};

		jdbcTemplate.update(updatePais, params);
	}
	
	public void delete(Long idPais) 
	{
		jdbcTemplate.update(deletePaisById, new Object[] { idPais });
	}

}
