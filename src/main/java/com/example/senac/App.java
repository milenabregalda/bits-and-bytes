package com.example.senac;

import java.awt.Container;
import javax.swing.JFrame;
import com.example.senac.view.AppView;

import com.example.senac.controller.CyberSnackController;


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
    }
}
