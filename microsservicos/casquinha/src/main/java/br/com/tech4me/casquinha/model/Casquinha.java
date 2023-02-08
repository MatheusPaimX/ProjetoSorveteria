package br.com.tech4me.casquinha.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("casquinhas")
public class Casquinha{
    @Id
    private String id;
    private String nomeCliente;
    private String idCaixa;
    private Double valor;
    
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente){
        this.nomeCliente = nomeCliente;
    }

    public String getIdCaixa(){
        return idCaixa;
    }

    public void setIdCaixa(String idCaixa){
        this.idCaixa = idCaixa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }
    
}
