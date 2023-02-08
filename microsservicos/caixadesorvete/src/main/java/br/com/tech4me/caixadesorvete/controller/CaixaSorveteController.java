package br.com.tech4me.caixadesorvete.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import br.com.tech4me.caixadesorvete.service.CaixaSorveteService;
import br.com.tech4me.caixadesorvete.shared.CaixaSorveteCompletoDto;
import br.com.tech4me.caixadesorvete.shared.CaixaSorveteDto;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/sorveteria")
public class CaixaSorveteController{
    @Autowired
    private CaixaSorveteService servico;
    
    @PostMapping public ResponseEntity<CaixaSorveteCompletoDto> cadastrarCaixa(@RequestBody @Valid CaixaSorveteCompletoDto caixa){
        return new ResponseEntity<>(servico.cadastrar(caixa), HttpStatus.CREATED);
 
    }

    @GetMapping
    public ResponseEntity<List<CaixaSorveteCompletoDto>> obterCaixas(){
        return new ResponseEntity<>(servico.obterTodas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
  public ResponseEntity<CaixaSorveteDto> obterCaixaPorId(@PathVariable String id){
    Optional<CaixaSorveteDto> retorno = servico.obterPorId(id);

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.OK);
      }
    else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }

    }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> excluirCaixa(@PathVariable String id){
    servico.excluirPorId(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CaixaSorveteCompletoDto> atualizarCaixaSorvete(@PathVariable String id, @RequestBody CaixaSorveteCompletoDto caixaSorvete){
    Optional<CaixaSorveteCompletoDto> retorno = servico.atualizarPorId(id, caixaSorvete); 

    if (retorno.isPresent()){
      return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } 
    else{
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
   
  }

  @GetMapping("/porta")
  public String obterPorta(@Value("${local.server.port}") String porta){
    return "A instância que respondeu a requisição está rodando na porta" + porta;
  }

}
