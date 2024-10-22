package ufpb.dcx.mercado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collection;

public class InterfaceMercado extends JFrame {
    private SistemaMercado sistema;

    public InterfaceMercado() {
        sistema = new SistemaMercado();


        setTitle("Sistema de Mercado");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon("C:\\Users\\migue\\IdeaProjects\\ProjetoPOO2024\\src\\main\\java\\ufpb\\dcx\\mercado\\logo.png");
        Image image = imageIcon.getImage(); // Converte para o tipo Image
        Image scaledImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Redimensiona para 200x200 pixels
        imageIcon = new ImageIcon(scaledImage); // Converte de volta para ImageIcon

        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBounds(50, 40, 100, 120); // Define o tamanho do JLabel
        add(imageLabel);


        JButton listarButton = new JButton("Listar Produtos");
        listarButton.setBounds(300, 170, 150, 30);
        add(listarButton);


        JButton cadastrarButton = new JButton("Cadastrar Produto");
        cadastrarButton.setBounds(300, 210, 150, 30);
        add(cadastrarButton);


        JButton removerButton = new JButton("Remover Produto");
        removerButton.setBounds(300, 250, 150, 30);
        add(removerButton);

        JButton adicionarButton = new JButton("Adicionar unidade");
        adicionarButton.setBounds(300, 290, 150, 30);
        add(adicionarButton);

        JButton removerUnidadeButton = new JButton("Remover Unidade");
        removerUnidadeButton.setBounds(300, 330, 150, 30);
        add(removerUnidadeButton);

        JButton buscaPorCodigoButton = new JButton("Buscar por Código");
        buscaPorCodigoButton.setBounds(300, 370, 150, 30);
        add(buscaPorCodigoButton);

        JButton buscaPorTipoButton = new JButton("Buscar por Tipo");
        buscaPorTipoButton.setBounds(300, 410, 150, 30);
        add(buscaPorTipoButton);



        listarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cadastrarProduto();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removerProduto();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        adicionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    adicionarUnidades();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        removerUnidadeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    removerUnidade();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        buscaPorCodigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { buscaPorCodigo();}
        });

        buscaPorTipoButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){buscaPorTipo();}
        });
    }




    private void listarProdutos() {
        Collection<Produto> produtos = sistema.listarProdutos();
        StringBuilder produtoList = new StringBuilder();
        for (Produto produto : produtos) {
            produtoList.append(produto.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, produtoList.toString(), "Produtos", JOptionPane.INFORMATION_MESSAGE);
    }

    private void cadastrarProduto() throws IOException {
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        String tipo = JOptionPane.showInputDialog(this, "Digite o tipo do produto:");
        String codigoDeBarras = JOptionPane.showInputDialog(this, "Digite o código de barras:");
        double preco = Double.parseDouble(JOptionPane.showInputDialog(this, "Digite o preço:"));
        Produto produto = new Produto(nome, tipo, codigoDeBarras, preco);
        boolean cadastrado = sistema.cadastrarProduto(produto);
        sistema.salvarDados();
        if(cadastrado) JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
    }

    private void removerProduto() throws IOException {
        String codigoDeBarras = JOptionPane.showInputDialog(this, "Digite o código de barras do produto a ser removido:");
        boolean removido = sistema.removerProduto(codigoDeBarras);
        if (!removido && codigoDeBarras != null) JOptionPane.showMessageDialog(this, "Produto removido com sucesso!", "Remover", JOptionPane.INFORMATION_MESSAGE);
        sistema.salvarDados();
    }

    private void adicionarUnidades() throws IOException {
        String codigoDebarras = JOptionPane.showInputDialog(this, "Digite o codigo do produto:");
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o quantidade:"));
        sistema.adicionarUnidade(codigoDebarras, quantidade);
        sistema.salvarDados();
    }
    private void removerUnidade() throws IOException {
        String codigoDebarras = JOptionPane.showInputDialog(this, "Digite o codigo do produto:");
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(this, "Digite o quantidade:"));
        sistema.removerUnidade(codigoDebarras, quantidade);
        sistema.salvarDados();
    }

    private void buscaPorCodigo(){

            String codigoDeBarras = JOptionPane.showInputDialog(this, "Digite o codigo: ");
            if (codigoDeBarras != null) {
                System.out.println("Código de barras lido: " + codigoDeBarras);
                JOptionPane.showMessageDialog(this,sistema.BuscarPorCodigo(codigoDeBarras).toString(), "Produto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Nenhum código de barras encontrado.");
            }
    }
    private void buscaPorTipo(){
        String tipo = JOptionPane.showInputDialog(this, "Digite o tipo: ");
        Collection<Produto> produtos = sistema.listarProdutosPorTipo(tipo);
        StringBuilder produtoList = new StringBuilder();
        for (Produto produto : produtos) {
            produtoList.append(produto.toString()).append("\n");
        }
        JOptionPane.showMessageDialog(this, produtoList.toString(), "Produtos", JOptionPane.INFORMATION_MESSAGE);
    }





        public static void main (String[]args){
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new InterfaceMercado().setVisible(true);
                }
            });
        }
    }

