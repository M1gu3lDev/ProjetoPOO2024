package ufpb.dcx.mercado.test;

import org.junit.Before;
import org.junit.Test;
import ufpb.dcx.mercado.Lote;

import static org.junit.Assert.*;

public class LoteTest {

    private Lote lote;

    @Before
    public void setUp() {
        /*
        * Criação de um lote para os testes
        **/
        lote = new Lote("01/01/2025", 100, "001L", "Armazém Central", "001");
    }

    @Test
    public void testGetData() {
        assertEquals("01/01/2025", lote.getData());
    }

    @Test
    public void testSetData() {
        lote.setData("02/02/2026");
        assertEquals("02/02/2026", lote.getData());
    }

    @Test
    public void testGetQuantidade() {
        assertEquals(100, lote.getQuantidade());
    }

    @Test
    public void testSetQuantidade() {
        lote.setQuantidade(200);
        assertEquals(200, lote.getQuantidade());
    }

    @Test
    public void testGetLote() {
        assertEquals("001L", lote.getLote());
    }

    @Test
    public void testSetLote() {
        lote.setLote("002L");
        assertEquals("002L", lote.getLote());
    }

    @Test
    public void testGetLocal() {
        assertEquals("Armazém Central", lote.getLocal());
    }

    @Test
    public void testSetLocal() {
        lote.setLocal("Novo Armazém");
        assertEquals("Novo Armazém", lote.getLocal());
    }

    @Test
    public void testGetCodigoDeBarras() {
        assertEquals("001", lote.getCodigoDeBarras());
    }

    @Test
    public void testSetCodigoDeBarras() {
        lote.setCodigoDeBarras("002");
        assertEquals("002", lote.getCodigoDeBarras());
    }
}
