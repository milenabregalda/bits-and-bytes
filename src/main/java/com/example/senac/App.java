package com.example.senac;
import javax.persistence.*;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

import com.example.senac.controller.UsuarioController;
import com.example.senac.model.Usuario;
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
        //new App(); - TIREI PARA FAZER OS TESTES DE CONTROLLER


        
        // - TESTANDO LÓGICA DE USUÁRIO
        UsuarioController controller = new UsuarioController();

        // Criar um novo usuário
        Usuario novoUsuario = new Usuario(null, "João Silva", "teste4", "teste4", "senha123", "123456789");
        controller.criarUsuario(novoUsuario);

        // Obter um usuário pelo ID
        Usuario usuario = controller.obterUsuario(novoUsuario.getId());
        System.out.println("Usuário encontrado: " + usuario.getNome());

        // Atualizar um usuário
        Usuario usuarioAtualizado = new Usuario(null, "João Souza", "att4", "att4", "novaSenha123", "123456789");
        controller.atualizarUsuario(novoUsuario.getId(), usuarioAtualizado);
        System.out.println("Usuário " + usuarioAtualizado.getNome() + " atualizado.");

        // Excluir um usuário
        String resultado = controller.excluirUsuario(novoUsuario.getId());
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
