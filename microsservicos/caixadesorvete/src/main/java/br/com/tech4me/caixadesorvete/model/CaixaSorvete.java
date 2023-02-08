package br.com.tech4me.caixadesorvete.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("caixas")
public class CaixaSorvete {
    @Id
    private String id;
    private Double valor;
    private String sabor;
    private String tamanho;
    private String marca;
    private List<String> frutas;
    
    public Double getValor(){
        return valor;
    }

    public void setValor(Double valor){
        this.valor = valor;
    }

    public String getSabor(){
        return sabor;
    }

    public void setSabor(String sabor){
        this.sabor = sabor;
    }

    public String getTamanho(){
        return tamanho;
    }

    public void setTamanho(String tamanho){
        this.tamanho = tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public List<String> getFrutas(){
        return frutas;
    }

    public void setFrutas(List<String> frutas){
        this.frutas = frutas;
    }

    public String getId(){
        return id;
    }
      
    public void setId(String id){
        this.id = id;
    } 
    
}
