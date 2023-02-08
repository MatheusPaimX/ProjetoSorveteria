package br.com.tech4me.casquinha.model;

import java.util.List;

public class CaixaSorvete{
    private String sabor;
    private String marca;
    private List<String> frutas;
    
    public String getSabor(){
        return sabor;
    }

    public void setSabor(String sabor){
        this.sabor = sabor;
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
