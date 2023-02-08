package br.com.tech4me.casquinha.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.casquinha.shared.CasquinhaCompletoDto;
import br.com.tech4me.casquinha.shared.CasquinhaDto;

public interface CasquinhaService{
    List<CasquinhaCompletoDto> obterCasquinhas();
    Optional<CasquinhaDto> obterCasquinhaPorId(String id);
    void excluirCasquinha(String id);
    CasquinhaCompletoDto CadastrarCasquinha(CasquinhaCompletoDto casquinha);
    Optional<CasquinhaDto> atualizarCasquinhaPorId(String id, CasquinhaDto dto);
}
