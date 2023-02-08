package br.com.tech4me.casquinha.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.casquinha.service.CasquinhaService;
import br.com.tech4me.casquinha.shared.CasquinhaCompletoDto;
import br.com.tech4me.casquinha.shared.CasquinhaDto;
import jakarta.validation.Valid;
    

@RestController
@RequestMapping("/casquinhas")
public class CasquinhaController{
    
    @Autowired
    private CasquinhaService servico;

    @PostMapping
    public ResponseEntity<CasquinhaCompletoDto> cadastrarCasquinha(@RequestBody @Valid CasquinhaCompletoDto casquinha){
        return new ResponseEntity<>(servico.CadastrarCasquinha(casquinha),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CasquinhaCompletoDto>> obterCasquinhas(){
        return new ResponseEntity<>(servico.obterCasquinhas(),HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<CasquinhaDto> obterCasquinhaPorId(@PathVariable String id){
        Optional<CasquinhaDto> retorno = servico.obterCasquinhaPorId(id);
        
        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }    
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCasquinha(@PathVariable String id){
        servico.excluirCasquinha(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CasquinhaDto> atualizarCasquinha(@PathVariable String id, @RequestBody @Valid CasquinhaDto casquinha){
        Optional<CasquinhaDto> retorno = servico.atualizarCasquinhaPorId(id, casquinha);

        if(retorno.isPresent()){
            return new ResponseEntity<>(retorno.get(),HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
 
}
