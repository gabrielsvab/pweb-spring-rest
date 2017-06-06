package br.com.svab.fatec.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;

public class AtletaJDBCRepository 
{
	private JdbcTemplate jdbcTemplate;
	
	@Value("${br.com.svab.fatec.insert.atleta}")
	private String insertAtleta;
	
	@Autowired
	@Qualifier("mySqlDataSource")
	public void setAtletaDatasource(DataSource atletaDatasource)
	{
		jdbcTemplate = new JdbcTemplate(atletaDatasource);
	}
	
	
	

}
