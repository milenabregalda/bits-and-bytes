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

        // Criar controladores
        UsuarioController usuarioController = new UsuarioController();
        PedidoController pedidoController = new PedidoController();
        PedidoCyberSnackController pedidoCyberSnackController = new PedidoCyberSnackController();

        // Criar e cadastrar usuário
        Usuario usuario = usuarioController.criarObjetoUsuario("Testando Usuário 4", "12345678904", "testandousuario4@email.com", "senha123", "(11) 91234-5678");
        try {
            usuarioController.cadastrarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Criar pedido
        List<PedidoCyberSnack> itensPedido = new ArrayList<>();
        Pedido pedido = pedidoController.criarObjetoPedido(usuario, LocalDate.now(), 150.00f, Pedido.TipoPagamento.CREDITO, 3, itensPedido);
        pedidoController.cadastrarPedido(pedido);

        // Criar e cadastrar PedidoCyberSnack
        CyberSnack cyberSnack = new CyberSnack(); // Preencha conforme necessário
        PedidoCyberSnack pedidoCyberSnack = pedidoCyberSnackController.criarObjetoPedidoCyberSnack(pedido, cyberSnack, 2, 20.00f);
        pedidoCyberSnackController.criarPedidoCyberSnack(pedidoCyberSnack);

        em.close();
        emf.close();
    }
}
