package br.com.tech4me.casquinha.shared;

import br.com.tech4me.casquinha.model.CaixaSorvete;

public class CasquinhaDto {
    private String nomeCliente;
    private String idCaixa;
    private CaixaSorvete dadosCaixa;
    private Double valor;
    
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getIdCaixa() {
        return idCaixa;
    }
    public void setIdCaixa(String idCaixa) {
        this.idCaixa = idCaixa;
    }
    public CaixaSorvete getDadosCaixa() {
        return dadosCaixa;
    }
    public void setDadosCaixa(CaixaSorvete dadosCaixa) {
        this.dadosCaixa = dadosCaixa;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
    
   
    

}