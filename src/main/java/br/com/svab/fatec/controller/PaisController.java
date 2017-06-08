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

import br.com.svab.fatec.model.Pais;
import br.com.svab.fatec.service.PaisService;

@RestController
@RequestMapping(value="/pais")
public class PaisController 
{
	@Autowired
	PaisService paisService; //Service which will do all data retrieval/manipulation work
	
    // Todos os paises
    @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Pais>> listAllPaises() 
    {
        List<Pais> paises = paisService.findAllPais();
        
        if (paises.isEmpty()) 
        {
            return new ResponseEntity<List<Pais>>(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
    }
	 
    
    // Unico Pais
    @RequestMapping(value = "/{idPais}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pais> getPais(@PathVariable("idPais") Long id) 
    {
    	Pais pais = paisService.findById(id);
        
        if (pais == null) 
        {
            return new ResponseEntity<Pais>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Pais>(pais, HttpStatus.OK); 
    }
	 
    
    // Adicionar Pais
    @PostMapping(value = "/", consumes= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pais> createPais(@RequestBody Pais pais, UriComponentsBuilder ucBuilder) 
    {
        if (paisService.isPaisExists(pais)) 
        {
            return new ResponseEntity<Pais>(HttpStatus.CONFLICT);
        }
        paisService.savePais(pais);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/{idPais}").buildAndExpand(pais.getIdPais()).toUri());
        return new ResponseEntity<Pais>(headers, HttpStatus.CREATED);
    }
	 
    // Atualizar Pais
    @PutMapping(value = "/{idPais}", consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pais> updatePais(@PathVariable("idPais") Long id, @RequestBody Pais pais) 
    {
    	Pais current = paisService.findById(id);
 
        if (current == null) 
        {
            return new ResponseEntity<Pais>(HttpStatus.NOT_FOUND);
        }
 
        current.setNomePais(pais.getNomePais());
 
        paisService.updatePais(current);
        
        return new ResponseEntity<Pais>(HttpStatus.OK);
    }
	 
    
    // Deletar Pais
    @DeleteMapping(value = "/{idPais}",consumes=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pais> deletePais(@PathVariable("idPais") Long id) 
    {
        Pais pais = paisService.findById(id);
        
        if (pais == null) 
        {
            return new ResponseEntity<Pais>(HttpStatus.NOT_FOUND);
        }
        paisService.deletePaisById(id);
        
        return new ResponseEntity<Pais>(HttpStatus.NO_CONTENT);
    }
	 
}
