package ufpb.dcx.mercado;


import java.util.Collection;

public interface MercadoInterface {
    public boolean cadastrarProduto(Produto produto);
    public Collection<Produto> listarProdutos();
    public boolean removerProduto(String id);
    public void adicionarUnidade(String id, int quantidade);
    public void removerUnidade(String id, int quantidade) throws LoteNaoEncontradoException;
    public void alterarPreco(String id, double preco);

}
