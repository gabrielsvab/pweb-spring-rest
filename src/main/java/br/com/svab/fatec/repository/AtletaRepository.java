package br.com.svab.fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.svab.fatec.model.Atleta;

public interface AtletaRepository extends JpaRepository<Atleta, Long>
{
	Atleta findByName(String nomeAtleta);
}
