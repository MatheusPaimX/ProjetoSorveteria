package br.com.tech4me.caixadesorvete.shared;

import java.util.List;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CaixaSorveteCompletoDto{
    
    private String id;
    @Positive(message="Valor deve ser informado")
    private Double valor;
    private String sabor;
    @Size(min=3, max=3, message="Informe Peq, Med ou Grd")
    private String tamanho;
    private String marca;
    private List<String> frutas;
    
    public String getId(){
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

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
