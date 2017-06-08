package br.com.svab.fatec.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.svab.fatec.model.Modalidade;

public class ModalidadeRowmapper implements RowMapper<Modalidade> 
{

	@Override
	public Modalidade mapRow(ResultSet rs, int line) throws SQLException 
	{
		Modalidade modalidade = new Modalidade();
		
		modalidade.setIdModalidade(rs.getLong("IDMODALIDADE"));
		modalidade.setNomeModalidade(rs.getString("NOMEMODALIDADE"));
		return modalidade;
	}

}
