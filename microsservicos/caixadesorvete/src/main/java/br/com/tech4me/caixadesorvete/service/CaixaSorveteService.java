package br.com.tech4me.caixadesorvete.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.caixadesorvete.shared.CaixaSorveteCompletoDto;
import br.com.tech4me.caixadesorvete.shared.CaixaSorveteDto;

public interface CaixaSorveteService{
    List<CaixaSorveteCompletoDto> obterTodas();
    Optional<CaixaSorveteDto> obterPorId(String id);
    void excluirPorId(String id);
    CaixaSorveteCompletoDto cadastrar(CaixaSorveteCompletoDto dto); 
    Optional<CaixaSorveteCompletoDto> atualizarPorId(String id, CaixaSorveteCompletoDto dto);
}
