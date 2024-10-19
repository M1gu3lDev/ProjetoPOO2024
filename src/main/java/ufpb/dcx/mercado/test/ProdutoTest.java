package ufpb.dcx.mercado.test;

import org.junit.Before;
import org.junit.Test;
import ufpb.dcx.mercado.Lote;
import ufpb.dcx.mercado.Produto;

import java.util.Collection;
import static org.junit.Assert.*;

public class ProdutoTest {

    private Produto produto;
    private Lote lote;

    @Before
    public void setUp() {
        /*
        * Criação de um produto para os testes
        **/
        produto = new Produto("Arroz", "Alimento", "001", 5.50);

        /*
        * Criação de um lote associado ao produto
        **/
        lote = new Lote("01/01/2025", 10, "001L", "Armazém Central", "001");
    }

    @Test
    public void testGetNome() {
        assertEquals("Arroz", produto.getNome());
    }

    @Test
    public void testSetNome() {
        produto.setNome("Feijão");
        assertEquals("Feijão", produto.getNome());
    }

    @Test
    public void testGetTipo() {
        assertEquals("Alimento", produto.getTipo());
    }

    @Test
    public void testSetTipo() {
        produto.setTipo("Grão");
        assertEquals("Grão", produto.getTipo());
    }

    @Test
    public void testGetPreco() {
        assertEquals(5.50, produto.getPreco(), 0.001);
    }

    @Test
    public void testSetPreco() {
        produto.setPreco(6.00);
        assertEquals(6.00, produto.getPreco(), 0.001);
    }

    @Test
    public void testGetCodigoDeBarras() {
        assertEquals("001", produto.getCodigoDeBarras());
    }

    @Test
    public void testSetCodigoDeBarras() {
        produto.setCodigoDeBarras("002");
        assertEquals("002", produto.getCodigoDeBarras());
    }

    @Test
    public void testGetQuantidade() {
        assertEquals(0, produto.getQuantidade());
    }

    @Test
    public void testSetQuantidade() {
        produto.setQuantidade(100);
        assertEquals(100, produto.getQuantidade());
    }

    @Test
    public void testSetLote() {
        produto.setLote(lote);
        Collection<Lote> lotes = produto.getLote();
        assertTrue(lotes.contains(lote));
    }

    @Test
    public void testGetLote() {
        produto.setLote(lote);
        Collection<Lote> lotes = produto.getLote();
        assertEquals(1, lotes.size());
        assertTrue(lotes.contains(lote));
    }

    @Test
    public void testToString() {
        produto.setQuantidade(50);
        String expected = "Nome: ArrozTipo: AlimentoPreco: 5.5Quantidade: 50";
        assertEquals(expected, produto.toString()); // Verifica se o método toString gera a string correta
    }
}
