package br.com.svab.fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.svab.fatec.model.Modalidade;

public interface ModalidadeRepository extends JpaRepository<Modalidade, Long>
{
	Modalidade findByName(String nomeModalidade);
}
