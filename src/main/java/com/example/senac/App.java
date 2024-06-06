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

        // Criação do CardLayout e do JPanel principal
        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Adição dos diferentes cards ao mainPanel
        JPanel card1 = new JPanel(); // Este é o painel anterior, por exemplo
        ConfirmacaoPedidoView card2 = new ConfirmacaoPedidoView(cardLayout, mainPanel); // Este é o painel de confirmação de pedido
        JPanel card3 = new JPanel(); // Adicione o painel para o botão de concluir
        JPanel card4 = new JPanel(); // Adicione o painel para o botão de cancelar

        mainPanel.add(card1, "cyberSnacks"); // Nomeie como "cardAnterior" ou algo que descreva o conteúdo do painel
        mainPanel.add(card2, "cyberStation");
        mainPanel.add(card3, "cardConcluir"); // Nomeie como "cardConcluir"
        mainPanel.add(card4, "cardCancelar"); // Nomeie como "cardCancelar")

        // Configurações da JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1366, 720);

        // Mostre o card inicial
        cardLayout.show(mainPanel, "cyberSnacks"); // Mostre o cartão anteriormente definido

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
