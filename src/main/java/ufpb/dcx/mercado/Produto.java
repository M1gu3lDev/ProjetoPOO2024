package ufpb.dcx.mercado;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Produto implements Serializable {


    private String nome;
    private String tipo;
    private double preco;
    private String codigoDeBarras;
    private int quantidade;


    public Produto(String nome,String tipo, String codigoDeBarras, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.codigoDeBarras = codigoDeBarras;
        this.quantidade = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }
    public void setCodigoDeBarras(String codigoDeBarras) {
        this.codigoDeBarras = codigoDeBarras;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    @Override
    public String toString() {
        return "Nome: "+nome+" \nTipo: "+tipo+" \nPreco: "+preco+" \nQuantidade: "+quantidade;
    }
}
