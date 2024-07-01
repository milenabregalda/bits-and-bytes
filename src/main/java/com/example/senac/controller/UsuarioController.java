package com.example.senac.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import java.util.List;
import com.example.senac.model.Usuario;

public class UsuarioController {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private Usuario usuario;

    public UsuarioController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para criar o objeto Usuario com os dados inseridos na aplicação
    public Usuario criarObjetoUsuario(String nome, String cpf, String email, String senha, String telefone) {
        usuario = new Usuario(nome, cpf, email, senha, telefone);
        return usuario;
    }

    // Método para cadastrar o objeto Usuario no banco de dados
    public void cadastrarUsuario(Usuario usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método para obter um usuário pelo ID
    public Usuario obterUsuario(Long id) {
        try {
            return entityManager.find(Usuario.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para atualizar um usuário existente
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
        try {
            entityManager.getTransaction().begin();
            Usuario usuario = entityManager.find(Usuario.class, id);
            if (usuario != null) {
                usuario.setNome(usuarioAtualizado.getNome());
                usuario.setCpf(usuarioAtualizado.getCpf());
                usuario.setEmail(usuarioAtualizado.getEmail());
                usuario.setSenha(usuarioAtualizado.getSenha());
                usuario.setTelefone(usuarioAtualizado.getTelefone());
                entityManager.merge(usuario);
            }
            entityManager.getTransaction().commit();
            return usuario;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para excluir um usuário
    public String excluirUsuario(Long id) {
        try {
            entityManager.getTransaction().begin();
            Usuario usuario = entityManager.find(Usuario.class, id);
            if (usuario != null) {
                entityManager.remove(usuario);
                entityManager.getTransaction().commit();
                return "Usuário excluído com sucesso.";
            } else {
                entityManager.getTransaction().rollback();
                return "Usuário não encontrado.";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return "Erro ao excluir o usuário.";
        }
    }

    public Usuario getObjetoUsuario() {
        return usuario;
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        try {
            TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
            return query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método de login pelo nome e senha
    public Usuario login(String nome, String senha) {
        try {
            TypedQuery<Usuario> query = entityManager.createQuery(
                "SELECT u FROM Usuario u WHERE u.nome = :nome AND u.senha = :senha", Usuario.class);
            query.setParameter("nome", nome);
            query.setParameter("senha", senha);
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    // Método para fechar o EntityManager
    public void fechar() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
