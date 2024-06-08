package com.example.senac;
import javax.persistence.*;
import java.awt.Container;
import java.util.List;

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
        Usuario novoUsuario = new Usuario(null, "João Silva", "teste2", "teste2", "senha123", "123456789");
        controller.criarUsuario(novoUsuario);

        Usuario novoUsuario2 = new Usuario(null, "João Silva", "testeList", "testeList", "senha123", "123456789");
        controller.criarUsuario(novoUsuario2);

        // Obter um usuário pelo ID
        Usuario usuario = controller.obterUsuario(novoUsuario.getId());
        System.out.println("Usuário encontrado: " + usuario.getNome());

        // Atualizar um usuário
        Usuario usuarioAtualizado = new Usuario(null, "João Souza", "att4", "att4", "novaSenha123", "123456789");
        controller.atualizarUsuario(novoUsuario.getId(), usuarioAtualizado);
        System.out.println("Usuário " + usuarioAtualizado.getNome() + " atualizado.");

        // Listar todos os usuários
        List<Usuario> usuarios = controller.listarUsuarios();
        if (usuarios != null) {
            System.out.println("Lista de usuários:");
            for (Usuario u : usuarios) {
                System.out.println("ID: " + u.getId() + ", Nome: " + u.getNome() + ", CPF: " + u.getCpf() + ", Email: " + u.getEmail());
            }
        } else {
            System.out.println("Erro ao listar os usuários.");
        }


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
