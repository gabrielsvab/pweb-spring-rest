package br.com.svab.fatec.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import br.com.svab.fatec.model.Modalidade;
import br.com.svab.fatec.rowmapper.ModalidadeRowmapper;

@Repository
public class ModalidadeJDBCRepository 
{
	private JdbcTemplate jdbcTemplate;

	@Value("${br.com.svab.fatec.select.modalidade.single}")
	private String selectModalidadeById;

	@Value("${br.com.svab.fatec.select.modalidade.name}")
	private String selectModalidadeByName;
	
	@Value("${br.com.svab.fatec.select.modalidade.all}")
	private String selectAllModalidades;

	@Value("${br.com.svab.fatec.insert.modalidade}")
	private String insertModalidade;
	
	@Value("${br.com.svab.fatec.update.modalidade}")
	private String updateModalidade;
	
	@Value("${br.com.svab.fatec.delete.modalidade.single}")
	private String deleteModalidadeById;

	@Autowired
	@Qualifier("mySqlDataSource")
	public void setModalidadeDatasource(DataSource modalidadeDatasource)
	{
		jdbcTemplate = new JdbcTemplate(modalidadeDatasource);
	}

	//CRUD Operations
	public Modalidade findOne(Long idModalidade)
	{
		Modalidade modalidade = jdbcTemplate.queryForObject(selectModalidadeById, new Object[] { idModalidade }, new ModalidadeRowmapper());

		return modalidade;
	}
	
	public List<Modalidade> findAll() 
	{
		List<Modalidade> allModalidades = jdbcTemplate.query(selectAllModalidades, new BeanPropertyRowMapper<Modalidade>());
		
		return allModalidades;
	}

	public Modalidade findByName(String nomeModalidade) 
	{	
		Modalidade modalidade = new Modalidade();
		try
		{
			modalidade = jdbcTemplate.queryForObject(selectModalidadeByName, new Object[] { nomeModalidade }, new ModalidadeRowmapper());
		}
		catch(Exception e)
		{
			return null;
		}

		return modalidade;
	}

	public void save(Modalidade modalidade) 
	{
		Object[] params = new Object[] {modalidade.getIdModalidade(),modalidade.getNomeModalidade()};

		jdbcTemplate.update(insertModalidade, params);
	}

	public void update(Modalidade modalidade) 
	{
		Object[] params = new Object[] {modalidade.getNomeModalidade()};

		jdbcTemplate.update(updateModalidade, params);
	}
	
	public void delete(Long idModalidade) 
	{
		jdbcTemplate.update(deleteModalidadeById, new Object[] { idModalidade });
	}

}
