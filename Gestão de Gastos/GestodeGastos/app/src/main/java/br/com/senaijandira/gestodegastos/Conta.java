package br.com.senaijandira.gestodegastos;

import android.widget.RadioButton;

import java.util.Date;

/**
 * Created by 17170083 on 27/03/2018.
 */

public class Conta {
    private String titulo;
    private String valor;
    private Date data;
    private String categoria;
    private RadioButton opcao;


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date dt) {
        this.data = data;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public RadioButton getOpcao() {
        return opcao;
    }

    public void setOpcao(RadioButton opcao) {
        this.opcao = opcao;
    }
}
