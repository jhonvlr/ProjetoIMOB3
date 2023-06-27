package com.imob.model.domain;

public class Imobiliaria extends PessoaJuridica {

    private int id_Imobiliaria;
    private int id_Codigo_imobiliaria;
    private int numero_Creci;

    public Imobiliaria(int id_Imobiliaria, int id_Codigo_imobiliaria, int numero_Creci) {
        this.id_Imobiliaria = id_Imobiliaria;
        this.id_Codigo_imobiliaria = id_Codigo_imobiliaria;
        this.numero_Creci = numero_Creci;
    }

    public int getId_Imobiliaria() {
        return id_Imobiliaria;
    }

    public void setId_Imobiliaria(int id_Imobiliaria) {
        this.id_Imobiliaria = id_Imobiliaria;
    }

    public int getId_Codigo_imobiliaria() {
        return id_Codigo_imobiliaria;
    }

    public void setId_Codigo_imobiliaria(int id_Codigo_imobiliaria) {
        this.id_Codigo_imobiliaria = id_Codigo_imobiliaria;
    }

    public int getNumero_Creci() {
        return numero_Creci;
    }

    public void setNumero_Creci(int numero_Creci) {
        this.numero_Creci = numero_Creci;
    }
}
