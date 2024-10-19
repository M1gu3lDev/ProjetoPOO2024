package ufpb.dcx.mercado;

import java.io.*;
import java.util.HashMap;


public class GravadorDeDados {

    public static final String ARQUIVO = "produtos.dat";

    public HashMap<String, Produto> lerProdutos() throws IOException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            return (HashMap<String, Produto>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    public void salvarProdutos(HashMap<String, Produto> produtos) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            out.writeObject(produtos);
        }
    }

}