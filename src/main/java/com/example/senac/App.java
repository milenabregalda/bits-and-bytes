package com.example.senac;
import javax.persistence.*;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import com.example.senac.view.AppView;
import com.example.senac.view.ConfirmacaoPedidoView;

import com.example.senac.controller.UsuarioController;
import com.example.senac.model.Usuario;
import com.example.senac.controller.CyberSnackController;
import com.example.senac.controller.PedidoController;
import com.example.senac.model.CyberSnack;
import com.example.senac.model.Pedido;
import com.example.senac.model.Pedido.TipoPagamento;
import com.example.senac.model.PedidoCyberSnack;

//import com.example.senac.model.seumodel;

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
        // Fazer a janela aparecer
        //new App(); - TIREI PARA FAZER OS TESTES DE CONTROLLER

        
        // - TESTANDO LÓGICA DE PEDIDO
        PedidoController controller = new PedidoController();

        // Criar um novo Usuario
        Usuario usuario = new Usuario("João Silva", "12345678901", "joao.silva@example.com", "senha123", "11987654321");

        // Criar um novo Pedido
        List<PedidoCyberSnack> itensPedido = new ArrayList<>();
        Pedido novoPedido = new Pedido(usuario, new Date(), 100.0f, TipoPagamento.CREDITO, 3, itensPedido);
        controller.criarPedido(novoPedido);

        // Obter um Pedido pelo ID
        Pedido pedido = controller.obterPedido(novoPedido.getId());
        if (pedido != null) {
            System.out.println("Pedido encontrado: " + pedido.getId());
        } else {
            System.out.println("Pedido não encontrado.");
        }

        // Atualizar um Pedido
        Pedido pedidoAtualizado = new Pedido(usuario, new Date(), 150.0f, TipoPagamento.DEBITO, 1, itensPedido);
        Pedido atualizado = controller.atualizarPedido(novoPedido.getId(), pedidoAtualizado);
        if (atualizado != null) {
            System.out.println("Pedido " + atualizado.getId() + " atualizado.");
        } else {
            System.out.println("Erro ao atualizar o pedido.");
        }

        // Listar todos os Pedidos
        List<Pedido> pedidos = controller.listarPedidos();
        if (pedidos != null) {
            System.out.println("Lista de Pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("ID: " + p.getId() + ", Valor Total: " + p.getValorTotal());
            }
        } else {
            System.out.println("Erro ao listar os pedidos.");
        }

        // Excluir um Pedido
        String resultado = controller.excluirPedido(novoPedido.getId());
        System.out.println(resultado);

        // Fechar o EntityManager
        controller.fechar();
    }
}
