package br.com.svab.fatec.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.svab.fatec.model.Pais;

public class PaisRowmapper implements RowMapper<Pais> 
{

	@Override
	public Pais mapRow(ResultSet rs, int line) throws SQLException 
	{
		Pais pais = new Pais();
		
		pais.setIdPais(rs.getLong("IDPAIS"));
		pais.setNomePais(rs.getString("NOMEPAIS"));
		return pais;
	}

}
