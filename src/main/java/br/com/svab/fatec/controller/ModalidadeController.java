package br.com.svab.fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.svab.fatec.model.Modalidade;
import br.com.svab.fatec.service.ModalidadeService;

@RestController
@RequestMapping(value="/modalidade")
public class ModalidadeController 
{
	@Autowired
	ModalidadeService modalidadeService; //Service which will do all data retrieval/manipulation work
	
    // Todos as modalidades
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Modalidade>> listAllModalidades() 
    {
        List<Modalidade> modalidades = modalidadeService.findAllModalidade();
        
        if (modalidades.isEmpty()) 
        {
            return new ResponseEntity<List<Modalidade>>(HttpStatus.NO_CONTENT);
        }
        
        
        
        return new ResponseEntity<List<Modalidade>>(modalidades, HttpStatus.OK);
    }
	 
    
    // Unica Modalidade
    @RequestMapping(value = "/{idModalidade}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Modalidade> getModalidade(@PathVariable("idModalidade") Long id) 
    {
    	Modalidade modalidade = modalidadeService.findById(id);
        
        if (modalidade == null) 
        {
            return new ResponseEntity<Modalidade>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Modalidade>(modalidade, HttpStatus.OK); 
    }
	 
    
    // Adicionar Modalidade
    
    @PostMapping(value = "/", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Modalidade> createModalidade(@RequestBody Modalidade modalidade, UriComponentsBuilder ucBuilder) 
    {
        if (modalidadeService.isModalidadeExists(modalidade)) 
        {
            return new ResponseEntity<Modalidade>(HttpStatus.CONFLICT);
        }
        modalidadeService.saveModalidade(modalidade);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{idModalidade}").buildAndExpand(modalidade.getIdModalidade()).toUri());
        return new ResponseEntity<Modalidade>(headers, HttpStatus.CREATED);
    }
	 
    // Atualizar Modalidade
    @PutMapping(value = "/{idModalidade}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Modalidade> updateModalidade(@PathVariable("idModalidade") Long id, @RequestBody Modalidade modalidade) 
    {
    	Modalidade current = modalidadeService.findById(id);
 
        if (current == null) 
        {
            return new ResponseEntity<Modalidade>(HttpStatus.NOT_FOUND);
        }
 
        current.setNomeModalidade(modalidade.getNomeModalidade());
 
        modalidadeService.updateModalidade(current);
        
        return new ResponseEntity<Modalidade>(HttpStatus.OK);
    }
	 
    
    // Deletar Modalidade
    @DeleteMapping(value = "/{idModalidade}",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Modalidade> deleteModalidade(@PathVariable("idModalidade") Long id) 
    {
        Modalidade modalidade = modalidadeService.findById(id);
        
        if (modalidade == null) 
        {
            return new ResponseEntity<Modalidade>(HttpStatus.NOT_FOUND);
        }
        modalidadeService.deleteModalidadeById(id);
        
        return new ResponseEntity<Modalidade>(HttpStatus.NO_CONTENT);
    }
	 
}
