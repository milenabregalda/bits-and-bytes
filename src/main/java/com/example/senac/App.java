package com.example.senac;

import java.awt.Container;
import java.time.LocalDate;
import java.util.ArrayList;
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
        new App(); // Faz a janela aparecer

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        CyberSnack cyberSnack1 = new CyberSnack("Nome do Snack 1", CyberSnack.Tipo.SALGADO, 10.0f);
        CyberSnack cyberSnack2 = new CyberSnack("Nome do Snack 2", CyberSnack.Tipo.DOCE, 5.0f);
        // Persistir os snacks
        em.persist(cyberSnack1);
        em.persist(cyberSnack2);

        UsuarioController usuarioController = new UsuarioController();
        Usuario usuario = usuarioController.criarObjetoUsuario("Testando Usuário 11", "12345678911", "testandousuario11@email.com", "senha123", "(11) 91234-5678");
        try {
            usuarioController.cadastrarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<PedidoCyberSnack> itensPedido = new ArrayList<>();

        PedidoController pedidoController = new PedidoController();
        // Passo 1: Criar e cadastrar o pedido
        Pedido pedido = pedidoController.criarObjetoPedido(usuario, LocalDate.now(), 10.0f, TipoPagamento.PIX, 1, itensPedido);

        boolean pedidoCadastrado = pedidoController.cadastrarPedido(pedido);


        /*  org.hibernate.PersistentObjectException: detached entity passed to persist: com.example.senac.model.Pedido

        

        // Criar controladores
        UsuarioController usuarioController = new UsuarioController();
        PedidoController pedidoController = new PedidoController();
        PedidoCyberSnackController pedidoCyberSnackController = new PedidoCyberSnackController();

        // Criar e cadastrar usuário
        Usuario usuario = usuarioController.criarObjetoUsuario("Testando Usuário 10", "12345678910", "testandousuario10@email.com", "senha123", "(11) 91234-5678");
        try {
            usuarioController.cadastrarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Método para criar e persistir CyberSnack
CyberSnack cyberSnack = new CyberSnack("Cybersnack", Tipo.SALGADO, 10.0f);
try {
    em.getTransaction().begin();
    em.persist(cyberSnack);
    em.getTransaction().commit();
} catch (Exception e) {
    e.printStackTrace();
    em.getTransaction().rollback();
}

// Antes de criar PedidoCyberSnack, buscar o CyberSnack do banco para garantir que ele está anexado
CyberSnack managedCyberSnack = em.find(CyberSnack.class, cyberSnack.getId());

if (managedCyberSnack != null) {
    // Criar pedido e persistir
    List<PedidoCyberSnack> itensPedido = new ArrayList<>();
    Pedido pedido = pedidoController.criarObjetoPedido(usuario, LocalDate.now(), 150.00f, Pedido.TipoPagamento.CREDITO, 3, itensPedido);
    pedido = pedidoController.cadastrarPedido(pedido); // Receba o pedido gerenciado

    // Criar e cadastrar PedidoCyberSnack com o objeto CyberSnack gerenciado
    PedidoCyberSnack pedidoCyberSnack = pedidoCyberSnackController.criarObjetoPedidoCyberSnack(pedido, managedCyberSnack, 2, 20.00f);
    pedidoCyberSnackController.criarPedidoCyberSnack(pedidoCyberSnack);

        }
        */
    }
    
}
