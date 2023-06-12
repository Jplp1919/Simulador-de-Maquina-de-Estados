package com.mycompany.simuladorcompteo;

public class Registrador {
  
    String nomeEntrada;
    String nomeEntrada2;
    String nomeSaida;
    int valor;
    Operations operation;
    RegistradorType registradorType;

    
    public RegistradorType getRegistradorType() {
        return registradorType;
    }

    public void setRegistradorType(RegistradorType registradorType) {
        this.registradorType = registradorType;
    }
   

    public String getNomeEntrada2() {
        return nomeEntrada2;
    }

    public void setNomeEntrada2(String nomeEntrada2) {
        this.nomeEntrada2 = nomeEntrada2;
    }
    
    public String getNomeEntrada() {
        return nomeEntrada;
    }

    public void setNomeEntrada(String nomeEntrada) {
        this.nomeEntrada = nomeEntrada;
    }

    public String getNomeSaida() {
        return nomeSaida;
    }

    public void setNomeSaida(String nomeSaida) {
        this.nomeSaida = nomeSaida;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Operations getOperation() {
        return operation;
    }

    public void setOperation(Operations operation) {
        this.operation = operation;
    }
    
    
 
}
