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
        new App(); // Faz a janela aparecer

        /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        PedidoController pedidoController = new PedidoController();
        PedidoCyberSnackController pedidoCyberSnackController = new PedidoCyberSnackController();
        UsuarioController usuarioController = new UsuarioController();
        CyberSnackController cyberSnackController = new CyberSnackController();

        // TESTES PARA FAZER O CADASTRO DE PEDIDOS E PEDIDOS_CYBERSNACKS:
        try {
            em.getTransaction().begin();

            // Cria-se usuário para testes (no uso real, ele já vai existir)
            Usuario usuario = usuarioController.criarObjetoUsuario("Testando Usuário 30", "12345678930", "testandousuario30@email.com", "senha123", "(11) 91234-5678");
            usuarioController.cadastrarUsuario(usuario);

            // Cria itensPedido (em branco para construir objeto)
            List<PedidoCyberSnack> itensPedido = new ArrayList<>();

            // Cria o pedido e cadastra no banco de dados
            Pedido pedido = pedidoController.criarObjetoPedido(usuario, LocalDate.now(), 10.0f, TipoPagamento.PIX, 1, itensPedido);
            boolean pedidoCadastrado = pedidoController.cadastrarPedido(pedido);

            // Pega cybersnack do banco de dados (no uso real, dos que forem selecionados) e cria PedidoCyberSnack com ele e com o pedido
            CyberSnack cyberSnack = cyberSnackController.obterCyberSnack(3L);
            em.merge(cyberSnack);
            PedidoCyberSnack pedidoCyberSnack1 = pedidoCyberSnackController.criarObjetoPedidoCyberSnack(pedido, cyberSnack, 2, cyberSnack.getPreco());
            pedidoCyberSnackController.criarPedidoCyberSnack(pedidoCyberSnack1);

            // Mesma coisa do de cima
            CyberSnack cyberSnack2 = cyberSnackController.obterCyberSnack(5L);
            em.merge(cyberSnack2);
            PedidoCyberSnack pedidoCyberSnack2 = pedidoCyberSnackController.criarObjetoPedidoCyberSnack(pedido, cyberSnack2, 2, cyberSnack.getPreco());
            boolean sucesso = pedidoCyberSnackController.criarPedidoCyberSnack(pedidoCyberSnack2);

            // Se a criação do segundo PedidoCyberSnack for bem-sucedida, faz o commit para as alterações no banco persistirem (pode ser assim ou não depois)
            if (sucesso) {
                em.getTransaction().commit();
            } else {
                em.getTransaction().rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
            emf.close();
        }*/
    }
}