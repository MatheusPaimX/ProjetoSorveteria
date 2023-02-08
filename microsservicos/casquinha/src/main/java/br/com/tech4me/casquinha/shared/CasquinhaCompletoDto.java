package br.com.tech4me.casquinha.shared;

import jakarta.validation.constraints.Positive;

public class CasquinhaCompletoDto {
    private String id;
    private String nomeCliente;
    private String idCaixa;
    @Positive
    private Double valor;
    
    public String getIdCaixa() {
        return idCaixa;
    }
    public void setIdCaixa(String idCaixa) {
        this.idCaixa = idCaixa;
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    
}
