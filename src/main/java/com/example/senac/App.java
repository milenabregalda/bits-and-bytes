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
    }
}