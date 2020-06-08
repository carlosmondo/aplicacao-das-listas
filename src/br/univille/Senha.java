package br.univille;

import java.util.Date;

public class Senha {

    private int numero;
    private Date data;
    private boolean prioritaria;

    public Senha(){}

    public Senha(int numero, Date data, boolean prioritaria){
        super();
        this.numero = numero;
        this.data = data;
        this.prioritaria = prioritaria;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public boolean isPrioritaria() {
        return prioritaria;
    }

    public void setPrioritaria(boolean prioritaria) {
        this.prioritaria = prioritaria;
    }
}
