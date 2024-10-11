package ufpb.dcx.mercado;


import java.util.Collection;

public interface MercadoInterface {
    public boolean cadastrarProduto(Produto produto);
    public Collection<Produto> listarProdutos();
    public boolean removerProduto(String id);
    public boolean adicionarUnidade(String id, Lote lote);
    public void removerUnidade(String id, String lote, int quantidade) throws LoteNaoEncontradoException;
    public Lote BuscarProdutosPorLote(String id, String lote) throws LoteNaoEncontradoException;
    public Collection<Lote> BuscarPorDataDeValidade(String dataDeValidade) throws LoteNaoEncontradoException;
    public void alterarPreco(String id, int preco);

}
