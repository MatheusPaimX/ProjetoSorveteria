package br.com.tech4me.caixadesorvete.shared;

import java.util.List;

public class CaixaSorveteDto {
    private String id;
    private String sabor;
    private String tamanho;
    private String marca;
    private List<String> frutas;
    
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
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

    public String getMarca(){
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

}
