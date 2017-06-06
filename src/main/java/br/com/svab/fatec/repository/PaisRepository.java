package br.com.svab.fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.svab.fatec.model.Pais;

public interface PaisRepository extends JpaRepository<Pais, Long>
{
	Pais findByName(String nomePais);
}
