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

import br.com.svab.fatec.model.Atleta;
import br.com.svab.fatec.service.AtletaService;

@RestController
@RequestMapping(value="/atleta")
public class AtletaController 
{
	@Autowired
	AtletaService atletaService; //Service which will do all data retrieval/manipulation work
	
    // Todos os Atletas
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Atleta>> listAllAtletas() 
    {
        List<Atleta> atletas = atletaService.findAllAtletas();
        
        if (atletas.isEmpty()) 
        {
            return new ResponseEntity<List<Atleta>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Atleta>>(atletas, HttpStatus.OK);
    }
	 
    
    // Unico Atleta
    @RequestMapping(value = "/{idAtleta}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Atleta> getAtleta(@PathVariable("idAtleta") Long id) 
    {
        Atleta atleta = atletaService.findById(id);
        
        if (atleta == null) 
        {
            return new ResponseEntity<Atleta>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Atleta>(atleta, HttpStatus.OK); 
    }
	 
    
    // Adicionar Atleta
    @PostMapping(value = "/", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Atleta> addAtleta(@RequestBody Atleta atleta, UriComponentsBuilder ucBuilder) 
    {
        if (atletaService.isAtletaExists(atleta)) 
        {
            return new ResponseEntity<Atleta>(HttpStatus.CONFLICT);
        }
        atletaService.saveAtleta(atleta);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{idAtleta}").buildAndExpand(atleta.getIdAtleta()).toUri());
        return new ResponseEntity<Atleta>(headers, HttpStatus.CREATED);
    }
	 
    // Atualizar Atleta
    @PutMapping(value = "/{idAtleta}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Atleta> updateAtleta(@PathVariable("idAtleta") Long id, @RequestBody Atleta atleta) 
    {
        Atleta current = atletaService.findById(id);
 
        if (current == null) 
        {
            return new ResponseEntity<Atleta>(HttpStatus.NOT_FOUND);
        }
 
        current.setNomeAtleta(atleta.getNomeAtleta());
        current.setNascAtleta(atleta.getNascAtleta());
        current.setModalidadeAtleta(atleta.getModalidadeAtleta());
        current.setPaisAtleta(atleta.getPaisAtleta());
 
        atletaService.updateAtleta(current);
        
        return new ResponseEntity<Atleta>(HttpStatus.OK);
    }
	 
    
    // Deletar Atleta
    @DeleteMapping(value = "/{idAtleta}",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Atleta> deleteAtleta(@PathVariable("idAtleta") Long id) 
    {
        Atleta atleta = atletaService.findById(id);
        
        if (atleta == null) 
        {
            return new ResponseEntity<Atleta>(HttpStatus.NOT_FOUND);
        }
        atletaService.deleteAtletaById(id);
        
        return new ResponseEntity<Atleta>(HttpStatus.NO_CONTENT);
    }
	 
}
