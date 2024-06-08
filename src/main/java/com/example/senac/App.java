package com.example.senac;
import javax.persistence.*;
import java.awt.Container;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import com.example.senac.view.AppView;
import com.example.senac.view.ConfirmacaoPedidoView;

import com.example.senac.controller.UsuarioController;
import com.example.senac.model.Usuario;
import com.example.senac.controller.CyberSnackController;
import com.example.senac.model.CyberSnack;

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


        
        // - TESTANDO LÓGICA DE CYBERSNACK
        CyberSnackController controller = new CyberSnackController();

        // Criar um novo CyberSnack
        CyberSnack novoCyberSnack = new CyberSnack("Batata Frita", CyberSnack.Tipo.SALGADO, 12.50f);
        controller.criarCyberSnack(novoCyberSnack);

        CyberSnack novoCyberSnack2 = new CyberSnack("Coca-Cola", CyberSnack.Tipo.BEBIDA, 5.00f);
        controller.criarCyberSnack(novoCyberSnack2);

        // Obter um CyberSnack pelo ID
        CyberSnack cyberSnack = controller.obterCyberSnack(novoCyberSnack.getId());
        if (cyberSnack != null) {
            System.out.println("CyberSnack encontrado: " + cyberSnack.getNome());
        } else {
            System.out.println("CyberSnack não encontrado.");
        }

        // Atualizar um CyberSnack
        CyberSnack cyberSnackAtualizado = new CyberSnack("Batata Doce Frita", CyberSnack.Tipo.SALGADO, 15.00f);
        CyberSnack atualizado = controller.atualizarCyberSnack(novoCyberSnack.getId(), cyberSnackAtualizado);
        if (atualizado != null) {
            System.out.println("CyberSnack " + atualizado.getNome() + " atualizado.");
        } else {
            System.out.println("Erro ao atualizar o CyberSnack.");
        }

        // Listar todos os CyberSnacks
        List<CyberSnack> cyberSnacks = controller.listarCyberSnacks();
        if (cyberSnacks != null) {
            System.out.println("Lista de CyberSnacks:");
            for (CyberSnack c : cyberSnacks) {
                System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", Tipo: " + c.getTipo() + ", Preço: " + c.getPreco());
            }
        } else {
            System.out.println("Erro ao listar os CyberSnacks.");
        }

        // Excluir um CyberSnack
        String resultado = controller.excluirCyberSnack(novoCyberSnack.getId());
        System.out.println(resultado);

        // Fechar o EntityManager
        controller.fechar();

        // Lógica de JPA (configuraremos depois):
        /*EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();*/
    }
}
