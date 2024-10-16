package ufpb.dcx.mercado;

import java.util.*;

public class SistemaMercado implements MercadoInterface{
    private Map<String,Produto> produtos;

    public SistemaMercado() {
        produtos = new HashMap<String,Produto>();
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
    public boolean adicionarUnidade(String id, Lote lote) {
        produtos.get(id).lote.put(lote.getLote(), lote);
        return produtos.get(id).lote.containsKey(lote.getLote());

    }

    @Override
    public void removerUnidade(String id, String lote, int quantidade) {
        produtos.get(id).lote.get(lote).setQuantidade( produtos.get(id).lote.get(lote).getQuantidade() - quantidade);
    }

    @Override
    public Lote BuscarProdutosPorLote(String id, String lote) throws LoteNaoEncontradoException {
        produtos.get(id).lote.get(lote);
        throw new LoteNaoEncontradoException("Lote não encontrado");
    }

    @Override
    public Collection<Lote> BuscarPorDataDeValidade(String dataDeValidade) throws LoteNaoEncontradoException {
        Collection<Lote> produtosDaValidade = new ArrayList<>();
        for (Produto produto : produtos.values()) {
                for (Lote lote : produto.lote.values()) {
                    if (lote.getData().equals(dataDeValidade)) {
                        produtosDaValidade.add(lote);
                    }
                }
        }
        throw new LoteNaoEncontradoException("Lote não encontrado");
    }

    @Override
    public void alterarPreco(String id, int preco) {
        produtos.get(id).setPreco(preco);
    }
    public void alterarNome(String nome, int id) {
        produtos.get(id).setNome(nome);
    }
    public void alterarCodigoDeBarras(String codigoDeBarras, int id) {
        produtos.get(id).setCodigoDeBarras(codigoDeBarras);
    }
    public void alterarTipo(String tipo, int id) {
        produtos.get(id).setTipo(tipo);
    }
}
