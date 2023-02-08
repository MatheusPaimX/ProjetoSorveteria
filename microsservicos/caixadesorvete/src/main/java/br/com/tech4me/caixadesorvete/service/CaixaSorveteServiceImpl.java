package br.com.tech4me.caixadesorvete.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.caixadesorvete.model.CaixaSorvete;
import br.com.tech4me.caixadesorvete.repository.CaixaSorveteRepository;
import br.com.tech4me.caixadesorvete.shared.CaixaSorveteCompletoDto;
import br.com.tech4me.caixadesorvete.shared.CaixaSorveteDto;

@Service
public class CaixaSorveteServiceImpl implements CaixaSorveteService{ 
  @Autowired
  private CaixaSorveteRepository repositorio;

  @Override
  public List<CaixaSorveteCompletoDto> obterTodas(){
    List<CaixaSorvete> caixasorvetes = repositorio.findAll(); 
    
    return caixasorvetes.stream()
                .map(c -> new ModelMapper().map(c, CaixaSorveteCompletoDto.class))
                .collect(Collectors.toList());
  }

  @Override
  public Optional<CaixaSorveteDto> obterPorId(String id){
    Optional<CaixaSorvete> caixasorvete  = repositorio.findById(id);

    if (caixasorvete.isPresent()){
      return Optional.of(new ModelMapper().map(caixasorvete.get(), CaixaSorveteDto.class));
    }
    return Optional.empty();
  }

  @Override
  public void excluirPorId(String id){ 
    repositorio.deleteById(id);
  }

  @Override
  public CaixaSorveteCompletoDto cadastrar(CaixaSorveteCompletoDto dto){
    CaixaSorvete caixasorvete = new ModelMapper().map(dto, CaixaSorvete.class);
    repositorio.save(caixasorvete);
    return new ModelMapper().map(caixasorvete, CaixaSorveteCompletoDto.class);  
  }

  @Override
  public Optional<CaixaSorveteCompletoDto> atualizarPorId(String id, CaixaSorveteCompletoDto dto){ 
    Optional<CaixaSorvete> retorno = repositorio.findById(id);

    if (retorno.isPresent()){
      CaixaSorvete caixasorvete = new ModelMapper().map(dto, CaixaSorvete.class);
      caixasorvete.setId(id);
      repositorio.save(caixasorvete);
      return Optional.of(new ModelMapper().map(caixasorvete, CaixaSorveteCompletoDto.class));
    }else{
      return Optional.empty();
    }
  
  }

}
  