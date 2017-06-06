package br.com.svab.fatec.controller;

import java.util.List;

import javax.swing.text.DefaultEditorKit.CutAction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.svab.fatec.model.Atleta;
import br.com.svab.fatec.service.AtletaService;
import br.com.svab.fatec.util.CustomErrorType;

@RestController
@RequestMapping("/")
public class AtletaController 
{
	@Autowired
	AtletaService atletaService; //Service which will do all data retrieval/manipulation work
 
    // Todos os Atletas
	 
    @RequestMapping(value = "/atleta/", method = RequestMethod.GET)
    public ResponseEntity<List<Atleta>> listAllAtletas() 
    {
        List<Atleta> atletas = atletaService.findAllAtletas();
        
        if (atletas.isEmpty()) 
        {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        
        return new ResponseEntity<List<Atleta>>(atletas, HttpStatus.OK);
    }
	 
    
    // Unico Atleta
    @RequestMapping(value = "/atleta/{idAtleta}", method = RequestMethod.GET)
    public ResponseEntity getAtleta(@PathVariable("idAtleta") long id) 
    {
        Atleta atleta = atletaService.findById(id);
        
        if (atleta == null) 
        {
            return new ResponseEntity(new CustomErrorType("Atleta com id " + id + " nao encontrado! "), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Atleta>(atleta, HttpStatus.OK);
    }
	 
    
    // Adicionar Atleta
    @RequestMapping(value = "/atleta/", method = RequestMethod.POST)
    public ResponseEntity createAtleta(@RequestBody Atleta atleta, UriComponentsBuilder ucBuilder) 
    {
        if (atletaService.isAtletaExists(atleta)) 
        {
            return new ResponseEntity(new CustomErrorType("Nao foi possivel adicionar!. O atleta com o nome " +  atleta.getNomeAtleta() + " ja existe."),HttpStatus.CONFLICT);
        }
        atletaService.saveAtleta(atleta);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/atleta/{idAtleta}").buildAndExpand(atleta.getIdAtleta()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
	 
    // Atualizar Atleta
    @RequestMapping(value = "/atleta/{idAtleta}", method = RequestMethod.PUT)
    public ResponseEntity updateAtleta(@PathVariable("idAtleta") long id, @RequestBody Atleta atleta) 
    {
        Atleta current = atletaService.findById(id);
 
        if (current == null) 
        {
            return new ResponseEntity(new CustomErrorType("Nao foi possivel atualizar!. O Atleta com id " + id + " nao foi encontrado."), HttpStatus.NOT_FOUND);
        }
 
        current.setNomeAtleta(atleta.getNomeAtleta());
        current.setNascAtleta(atleta.getNascAtleta());
        current.setModalidadeAtleta(atleta.getModalidadeAtleta());
        current.setPaisAtleta(atleta.getPaisAtleta());
 
        atletaService.updateAtleta(current);
        return new ResponseEntity<Atleta>(current, HttpStatus.OK);
    }
	 
    
    // Deletar Atleta
    @RequestMapping(value = "/atleta/{idAtleta}", method = RequestMethod.DELETE)
    public ResponseEntity<Atleta> deleteAtleta(@PathVariable("idAtleta") long id) 
    {
        Atleta atleta = atletaService.findById(id);
        
        if (atleta == null) 
        {
            return new ResponseEntity(new CustomErrorType("Nao foi possivel excluir!. O Atleta com id " + id + " nao foi encontrado."), HttpStatus.NOT_FOUND);
        }
        atletaService.deleteAtletaById(id);
        return new ResponseEntity<Atleta>(HttpStatus.NO_CONTENT);
    }
 
    
    // Deletar todos os Atletas
    @RequestMapping(value = "/atleta/", method = RequestMethod.DELETE)
    public ResponseEntity<Atleta> deleteAllAtletas() 
    {
        atletaService.deleteAllAtletas();
        return new ResponseEntity<Atleta>(HttpStatus.NO_CONTENT);
    }
	 
}
