package com.example.senac;
import javax.persistence.*;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

import com.example.senac.view.AppView;
import com.example.senac.view.ConfirmacaoPedidoView;

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
        new App();

        // Lógica de JPA (configuraremos depois):
        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();*/
    }
}
