package com.example.senac;

import java.awt.Container;
import javax.swing.JFrame;
import com.example.senac.view.AppView;

import com.example.senac.controller.CyberSnackController;
import com.example.senac.model.CyberSnack;
import com.example.senac.model.CyberSnack.Tipo;


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

        System.out.println("Bits & Bytes CyberCafé.");


// Instancia o controlador
CyberSnackController controller = new CyberSnackController();

// Cria um objeto CyberSnack
CyberSnack novoCyberSnack = controller.criarObjetoCyberSnack("Cyber Burger", Tipo.SALGADO, 12.99f);
System.out.println("Criou o objeto");

// Persiste o objeto no banco de dados
boolean sucesso = controller.criarCyberSnack(novoCyberSnack);

// Verifica se a operação foi bem-sucedida
if (sucesso) {
    System.out.println("CyberSnack cadastrado com sucesso!");
} else {
    System.out.println("Falha ao cadastrar o CyberSnack.");
}

// Fecha o EntityManager e o EntityManagerFactory
controller.fechar();
        
    }
}
