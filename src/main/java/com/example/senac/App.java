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

        System.out.println("Teste se funciona.");

        
        /*// - TESTES DE CONTROLLERS SÃO AQUI
        PedidoController controller = new PedidoController();

        // Fechar o EntityManager
        controller.fechar(); */
    }
}
