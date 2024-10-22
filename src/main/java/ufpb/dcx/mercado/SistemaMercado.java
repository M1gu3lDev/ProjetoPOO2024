package ufpb.dcx.mercado;
import java.io.IOException;
import java.util.*;

public class SistemaMercado implements MercadoInterface{
    private HashMap<String,Produto> produtos;
    private GravadorDeDados gravador;

    public SistemaMercado() {
        try {
          gravador = new GravadorDeDados();
          this.produtos =  gravador.lerProdutos();
        }catch(IOException e){
            this.produtos = new HashMap<String,Produto>();
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Collection<Produto> listarProdutos() {
        return produtos.values();
    }

    @Override
    public boolean cadastrarProduto(Produto produto) {
        produtos.put(produto.getCodigoDeBarras(), produto);
        return produtos.containsKey(produto.getCodigoDeBarras());
    }

    @Override
    public boolean removerProduto(String id) {
        produtos.remove(id);
        return produtos.containsKey(id);
    }

    @Override
    public void adicionarUnidade(String id, int quantidade) {
        produtos.get(id).setQuantidade(quantidade);

    }

    @Override
    public void removerUnidade(String id,int quantidade) {
        produtos.get(id).setQuantidade(produtos.get(id).getQuantidade() - quantidade);
    }
    public Collection<Produto> listarProdutosPorTipo(String tipo) {
        return produtos.values().stream()
                .filter(produto -> produto.getTipo().equals(tipo))
                .toList();
    }


    public Produto BuscarPorCodigo(String codigo) {
        return produtos.get(codigo);
    }

    @Override
    public void alterarPreco(String id, int preco) {
        produtos.get(id).setPreco(preco);
    }

    public void alterarNome(String codigoDeBarras,String nome) {
        Produto produto = produtos.get(codigoDeBarras);
        if (produto != null) {
            produto.setNome(nome);
        }
    }
    public void alterarCodigoDeBarras(String codigoAtual, String novoCodigoDeBarras) {
        Produto produto = produtos.get(codigoAtual);
        if (produto != null) {
            produto.setCodigoDeBarras(novoCodigoDeBarras);
            produtos.remove(codigoAtual); // Remove o produto do antigo código de barras
            produtos.put(novoCodigoDeBarras, produto); // Adiciona com o novo código de barras
        }
    }
    public void alterarTipo(String codigoDeBarras, String tipo) {
        Produto produto = produtos.get(codigoDeBarras);
        if (produto != null) {
            produto.setTipo(tipo);
        }
    }
    public void salvarDados() throws IOException {
        gravador.salvarProdutos(this.produtos);
    }
}
