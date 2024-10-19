package ufpb.dcx.mercado.test;

import org.junit.Before;
import org.junit.Test;
import ufpb.dcx.mercado.Lote;
import ufpb.dcx.mercado.LoteNaoEncontradoException;
import ufpb.dcx.mercado.Produto;
import ufpb.dcx.mercado.SistemaMercado;

import java.util.*;

import static org.junit.Assert.*;

public class SistemaMercadoTest {

    private SistemaMercado sistema;
    private Produto produto;
    private Lote lote;

    @Before
    /*
    * Inicializando o objeto SistemaMercado
    * Craindo instâncias de Produto e Lote
    **/
    public void setUp() {
        sistema = new SistemaMercado();
        produto = new Produto("Arroz", "Alimento", "001", 5.50);
        lote = new Lote("01/01/2025", 10, "001L", "Armazém Central", "001");
    }

    @Test
    public void testCadastrarProduto() {
        boolean cadastrado = sistema.cadastrarProduto(produto);
        assertTrue(cadastrado);
    }

    @Test
    public void testRemoverProduto() {
        sistema.cadastrarProduto(produto);
        boolean removido = sistema.removerProduto(produto.getCodigoDeBarras());
        assertFalse(removido);
    }

    @Test
    public void testAdicionarUnidade() {
        sistema.cadastrarProduto(produto);
        boolean adicionado = sistema.adicionarUnidade(produto.getCodigoDeBarras(), lote);
        assertTrue(adicionado);
    }

    @Test
    public void testRemoverUnidade() {
        sistema.cadastrarProduto(produto);
        sistema.adicionarUnidade(produto.getCodigoDeBarras(), lote);
        sistema.removerUnidade(produto.getCodigoDeBarras(), lote.getLote(), 5);
        assertEquals(5, lote.getQuantidade());
    }

    @Test(expected = LoteNaoEncontradoException.class)
    public void testBuscarProdutosPorLote() throws LoteNaoEncontradoException {
        sistema.cadastrarProduto(produto);
        sistema.adicionarUnidade(produto.getCodigoDeBarras(), lote);
        sistema.BuscarProdutosPorLote(produto.getCodigoDeBarras(), "002L");
    }

    @Test(expected = LoteNaoEncontradoException.class)
    public void testBuscarPorDataDeValidade() throws LoteNaoEncontradoException {
        sistema.cadastrarProduto(produto);
        sistema.adicionarUnidade(produto.getCodigoDeBarras(), lote);
        sistema.BuscarPorDataDeValidade("01/01/2024");
    }

    @Test
    public void testAlterarPreco() {
        sistema.cadastrarProduto(produto);
        sistema.alterarPreco(produto.getCodigoDeBarras(), 10);
        assertEquals(10.00, produto.getPreco(), 0.001);
    }

    @Test
    public void testAlterarNome() {
        sistema.cadastrarProduto(produto);
        sistema.alterarNome(produto.getCodigoDeBarras(), "Feijão");
        assertEquals("Feijão", produto.getNome());
    }

    @Test
    public void testAlterarCodigoDeBarras() {
        sistema.cadastrarProduto(produto);
        sistema.alterarCodigoDeBarras(produto.getCodigoDeBarras(), "002");
        assertEquals("002", produto.getCodigoDeBarras());
    }

    @Test
    public void testAlterarTipo() {
        sistema.cadastrarProduto(produto);
        sistema.alterarTipo(produto.getCodigoDeBarras(), "Grão");
        assertEquals("Grão", produto.getTipo());
    }
}
