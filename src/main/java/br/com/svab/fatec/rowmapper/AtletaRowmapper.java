package br.com.svab.fatec.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.svab.fatec.model.Atleta;

public class AtletaRowmapper implements RowMapper<Atleta> 
{

	@Override
	public Atleta mapRow(ResultSet rs, int line) throws SQLException 
	{
		Atleta atleta = new Atleta();
		
		atleta.setIdAtleta(rs.getInt("IDATLETA"));
		atleta.setNomeAtleta(rs.getString("NOMEATLETA"));
		atleta.setNascAtleta(rs.getDate("NASCATLETA"));
		//atleta.setModalidadeAtleta(rs.getInt("MODALIDADE_IDMODALIDADE"));
		return atleta;
	}

}
