import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ufpb.dcx.mercado.Produto;
import ufpb.dcx.mercado.SistemaMercado;

import java.io.IOException;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaMercadoTest {

    private SistemaMercado sistema;
    private Produto produto;

    @BeforeEach
    public void setUp() {
        sistema = new SistemaMercado();
        produto = new Produto("Arroz", "Alimento", "123456", 5.0);
    }

    @Test
    public void testCadastrarProduto() {
        assertTrue(sistema.cadastrarProduto(produto));
        assertEquals(produto, sistema.BuscarPorCodigo("123456"));
    }

    @Test
    public void testRemoverProduto() {
        sistema.cadastrarProduto(produto);
        assertTrue(sistema.removerProduto("123456"));
        assertFalse(sistema.removerProduto("123456"));
    }



    @Test
    public void testListarProdutos() {
        sistema.cadastrarProduto(produto);
        Collection<Produto> produtos = sistema.listarProdutos();
        assertTrue(produtos.contains(produto));
    }

    @Test
    public void testAlterarPreco() {
        sistema.cadastrarProduto(produto);
        sistema.alterarPreco("123456", 10.0);
        assertEquals(10.0, sistema.BuscarPorCodigo("123456").getPreco());
    }

    @Test
    public void testAdicionarUnidade() {
        sistema.cadastrarProduto(produto);
        sistema.adicionarUnidade("123456", 20);
        assertEquals(20, sistema.BuscarPorCodigo("123456").getQuantidade());
    }

    @Test
    public void testRemoverUnidade() {
        sistema.cadastrarProduto(produto);
        sistema.adicionarUnidade("123456", 10);  // Adiciona 10 unidades antes de remover
        sistema.removerUnidade("123456", 5);
        assertEquals(5, sistema.BuscarPorCodigo("123456").getQuantidade());
    }

    @Test
    public void testListarProdutosPorTipo() {
        sistema.cadastrarProduto(produto);
        Collection<Produto> alimentos = sistema.listarProdutosPorTipo("Alimento");
        assertTrue(alimentos.contains(produto));
    }

    @Test
    public void testAlterarNome() {
        sistema.cadastrarProduto(produto);
        sistema.alterarNome("123456", "Feijão");
        assertEquals("Feijão", sistema.BuscarPorCodigo("123456").getNome());
    }

    @Test
    public void testAlterarCodigoDeBarras() {
        sistema.cadastrarProduto(produto);
        sistema.alterarCodigoDeBarras("123456", "654321");
        assertNull(sistema.BuscarPorCodigo("123456"));
        assertNotNull(sistema.BuscarPorCodigo("654321"));
    }

    @Test
    public void testAlterarTipo() {
        sistema.cadastrarProduto(produto);
        sistema.alterarTipo("123456", "Grão");
        assertEquals("Grão", sistema.BuscarPorCodigo("123456").getTipo());
    }

    @Test
    public void testSalvarDados() throws IOException {
        sistema.cadastrarProduto(produto);
        assertDoesNotThrow(() -> sistema.salvarDados());
    }
}
