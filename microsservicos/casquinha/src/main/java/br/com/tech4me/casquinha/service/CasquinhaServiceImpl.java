package br.com.tech4me.casquinha.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.tech4me.casquinha.httpClient.CaixaSorveteClient;
import br.com.tech4me.casquinha.model.Casquinha;
import br.com.tech4me.casquinha.repository.CasquinhaRepository;
import br.com.tech4me.casquinha.shared.CasquinhaCompletoDto;
import br.com.tech4me.casquinha.shared.CasquinhaDto;

@Service
public class CasquinhaServiceImpl implements CasquinhaService{

    @Autowired
    private CasquinhaRepository repository;

    @Autowired
    private CaixaSorveteClient caixaSorveteClient;

    @Override
    public List<CasquinhaCompletoDto> obterCasquinhas(){
        List<Casquinha> casquinhas = repository.findAll();
        List<CasquinhaCompletoDto> dto = casquinhas.stream().map(c -> new ModelMapper().map(c, CasquinhaCompletoDto.class)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public Optional<CasquinhaDto> obterCasquinhaPorId(String id){
        
        Optional<Casquinha> casquinha = repository.findById(id);
        if(casquinha.isPresent()){
            CasquinhaDto casquinhaComCaixa = new ModelMapper().map(casquinha, CasquinhaDto.class);
            casquinhaComCaixa.setDadosCaixa(caixaSorveteClient.obterCaixaSorvete(casquinhaComCaixa.getIdCaixa()));
            return Optional.of(casquinhaComCaixa);
        }
        else{
            return Optional.empty();
        }
    }

    @Override
    public void excluirCasquinha(String id){
        repository.deleteById(id);
    }

    @Override
    public CasquinhaCompletoDto CadastrarCasquinha(CasquinhaCompletoDto dto){
        Casquinha casquinha = new ModelMapper().map(dto, Casquinha.class);

        repository.save(casquinha);
        return new ModelMapper().map(casquinha,CasquinhaCompletoDto.class);
    }

    @Override
    public Optional<CasquinhaDto> atualizarCasquinhaPorId(String id, CasquinhaDto dto){
        Optional<Casquinha> retorno = repository.findById(id);

        if(retorno.isPresent()){
            Casquinha casquinhaRetorno = new ModelMapper().map(dto, Casquinha.class);
            casquinhaRetorno.setId(id);
            repository.save(casquinhaRetorno);
            return Optional.of(new ModelMapper().map(casquinhaRetorno, CasquinhaDto.class));
        }
        else{
            return Optional.empty();
        }
    }

}
