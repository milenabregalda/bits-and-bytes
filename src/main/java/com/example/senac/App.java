package com.example.senac;

import java.awt.Container;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFrame;
import com.example.senac.view.AppView;
import com.example.senac.controller.*;
import com.example.senac.exception.UsuarioComCPFJaCadastradoException;
import com.example.senac.exception.UsuarioComEmailJaCadastradoException;
import com.example.senac.exception.UsuarioComNomeJaCadastradoException;
import com.example.senac.model.CyberSnack;
import com.example.senac.model.CyberSnack.Tipo;
import com.example.senac.model.Pedido.TipoPagamento;
import com.example.senac.model.Pedido;
import com.example.senac.model.PedidoCyberSnack;
import com.example.senac.model.Usuario;


public class App extends JFrame {

    public App() {
        super("Bits & Bytes CyberCafé");
        Container c = getContentPane();
        c.add(new AppView());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 720);
        setVisible(true);
    }

    public static void main(String[] args) {
        //new App(); // Faz a janela aparecer

        // Janela comentada para facilitar testes

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        PedidoController pedidoController = new PedidoController();
        PedidoCyberSnackController pedidoCyberSnackController = new PedidoCyberSnackController();
        UsuarioController usuarioController = new UsuarioController();
        CyberSnackController cyberSnackController = new CyberSnackController();

        try {
            em.getTransaction().begin();

            Usuario usuario = usuarioController.criarObjetoUsuario("Testando Usuário 19", "12345678919", "testandousuario19@email.com", "senha123", "(11) 91234-5678");
            usuarioController.cadastrarUsuario(usuario);

            // Obter os CyberSnacks do banco de dados pelo ID

            /*if (cyberSnack1 == null || cyberSnack2 == null) {
                throw new RuntimeException("CyberSnacks não encontrados.");
            }*/

            List<PedidoCyberSnack> itensPedido = new ArrayList<>();

            System.out.println("\n\n\n\n\n\nAté cadastrar os cybersnacks foi\n\n\n\n\n\n\n\n");
            // Criar o pedido e itens PedidoCyberSnack
            Pedido pedido = pedidoController.criarObjetoPedido(usuario, LocalDate.now(), 15.0f, TipoPagamento.PIX, 1, itensPedido);
            System.out.println("\n\n\n\n\n\nAté criar o pedido foi\n\n\n\n\n\n\n\n");

            CyberSnack cyberSnack1 = cyberSnackController.obterCyberSnack(1L);
            PedidoCyberSnack item1 = pedidoCyberSnackController.criarObjetoPedidoCyberSnack(pedido, cyberSnack1, 2, cyberSnack1.getPreco());
            System.out.println("\n\n\n\n\n\nAté cadastrar o primeiro pedidocybersnack foi\n\n\n\n\n\n\n\n");

            CyberSnack cyberSnack2 = cyberSnackController.obterCyberSnack(2L);
            PedidoCyberSnack item2 = pedidoCyberSnackController.criarObjetoPedidoCyberSnack(pedido, cyberSnack2, 1, cyberSnack2.getPreco());
            System.out.println("\n\n\n\n\n\nAté cadastrar o segundo pedidocybersnack foi\n\n\n\n\n\n\n\n");

            // Adicionar os itens ao pedido
            pedido.getItensPedido().add(item1);
            pedido.getItensPedido().add(item2);

            System.out.println("\n\n\n\n\n\nAté adicionar os itens no pedido foi\n\n\n\n\n\n\n\n");
            // Persistir o pedido e os itens na mesma transação
            pedidoController.cadastrarPedido(pedido);

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }
    }

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        CyberSnack cyberSnack1 = new CyberSnack("Nome do Snack 1", CyberSnack.Tipo.SALGADO, 10.0f);
        CyberSnack cyberSnack2 = new CyberSnack("Nome do Snack 2", CyberSnack.Tipo.DOCE, 5.0f);
        // Persistir os snacks
        em.getTransaction().begin();
        em.persist(cyberSnack1);
        em.persist(cyberSnack2);
        em.getTransaction().commit();


        UsuarioController usuarioController = new UsuarioController();
        Usuario usuario = usuarioController.criarObjetoUsuario("Testando Usuário 15", "12345678915", "testandousuario15@email.com", "senha123", "(11) 91234-5678");
        try {
            usuarioController.cadastrarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<PedidoCyberSnack> itensPedido = new ArrayList<>();


        System.out.println("\n\n\n\n\nComeça aqui lógica nova\n\n\n\n\n");
        PedidoController pedidoController = new PedidoController();
        // Passo 1: Criar e cadastrar o pedido
        Pedido pedido = pedidoController.criarObjetoPedido(usuario, LocalDate.now(), 10.0f, TipoPagamento.PIX, 1, itensPedido);
        boolean pedidoCadastrado = pedidoController.cadastrarPedido(pedido);

        if (pedidoCadastrado) {
            // Passo 2: Criar os itens PedidoCyberSnack
            PedidoCyberSnack item1 = new PedidoCyberSnack(pedido, cyberSnack1, 2, cyberSnack1.getPreco());
            PedidoCyberSnack item2 = new PedidoCyberSnack(pedido, cyberSnack2, 1, cyberSnack2.getPreco());

            List<PedidoCyberSnack> itens = Arrays.asList(item1, item2);

            // Passo 3: Adicionar os itens ao pedido existente
            pedidoController.adicionarItensAoPedido(pedido.getId(), itens);
        }
    }*/
    
}