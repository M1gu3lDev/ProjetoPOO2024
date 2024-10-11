package ufpb.dcx.mercado;

public class Lote {
        private String lote;
        private String data;
        private String local;
        private String codigoDeBarras;
        private int quantidade;


        public Lote(String data, int quantidade, String lote, String local, String CodigoDeBarras){
            this.data = data;
            this.codigoDeBarras = CodigoDeBarras;
            this.quantidade = quantidade;
            this.lote = lote;
            this.local = local;
        }
        public String getData(){
            return data;
        }
        public int getQuantidade(){
            return quantidade;
        }
        public void setData(String data){
            this.data = data;
        }
        public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
        }
        public String getLote(){
            return lote;
        }
        public void setLote(String lote){
            this.lote = lote;
        }
        public String getLocal(){
            return local;
        }
        public void setLocal(String local){
            this.local = local;
        }
        public String getCodigoDeBarras(){
            return codigoDeBarras;
        }
        public void setCodigoDeBarras(String codigoDeBarras){
            this.codigoDeBarras = codigoDeBarras;
        }
    }
