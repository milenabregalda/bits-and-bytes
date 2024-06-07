package com.example.senac.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import com.example.senac.model.Usuario;

public class UsuarioController {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public UsuarioController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para criar um novo usuário
    public Usuario criarUsuario(Usuario usuario) {
        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        return usuario;
    }

    // Método para obter um usuário pelo ID
    public Usuario obterUsuario(Long id) {
        return entityManager.find(Usuario.class, id);
    }

    // Método para atualizar um usuário existente
    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
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
    }

    // Método para excluir um usuário
    public String excluirUsuario(Long id) {
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
    }

    // Método para listar todos os usuários
    public List<Usuario> listarUsuarios() {
        TypedQuery<Usuario> query = entityManager.createQuery("SELECT u FROM Usuario u", Usuario.class);
        return query.getResultList();
    }

    // Método para fechar o EntityManager
    public void fechar() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
