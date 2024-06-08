package com.example.senac.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import java.util.List;
import com.example.senac.model.PedidoCyberSnack;
import com.example.senac.model.PedidoCyberSnackId;

public class PedidoCyberSnackController {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PedidoCyberSnackController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para criar um novo PedidoCyberSnack
    public PedidoCyberSnack criarPedidoCyberSnack(PedidoCyberSnack pedidoCyberSnack) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pedidoCyberSnack);
            entityManager.getTransaction().commit();
            return pedidoCyberSnack;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para obter um PedidoCyberSnack pelo ID
    public PedidoCyberSnack obterPedidoCyberSnack(PedidoCyberSnackId id) {
        try {
            return entityManager.find(PedidoCyberSnack.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para atualizar um PedidoCyberSnack existente
    public PedidoCyberSnack atualizarPedidoCyberSnack(PedidoCyberSnackId id, PedidoCyberSnack pedidoCyberSnackAtualizado) {
        try {
            entityManager.getTransaction().begin();
            PedidoCyberSnack pedidoCyberSnack = entityManager.find(PedidoCyberSnack.class, id);
            if (pedidoCyberSnack != null) {
                pedidoCyberSnack.setPedido(pedidoCyberSnackAtualizado.getPedido());
                pedidoCyberSnack.setCyberSnack(pedidoCyberSnackAtualizado.getCyberSnack());
                pedidoCyberSnack.setQuantidade(pedidoCyberSnackAtualizado.getQuantidade());
                pedidoCyberSnack.setPreco(pedidoCyberSnackAtualizado.getPreco());
                entityManager.merge(pedidoCyberSnack);
            }
            entityManager.getTransaction().commit();
            return pedidoCyberSnack;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para excluir um PedidoCyberSnack
    public String excluirPedidoCyberSnack(PedidoCyberSnackId id) {
        try {
            entityManager.getTransaction().begin();
            PedidoCyberSnack pedidoCyberSnack = entityManager.find(PedidoCyberSnack.class, id);
            if (pedidoCyberSnack != null) {
                entityManager.remove(pedidoCyberSnack);
                entityManager.getTransaction().commit();
                return "PedidoCyberSnack excluído com sucesso.";
            } else {
                entityManager.getTransaction().rollback();
                return "PedidoCyberSnack não encontrado.";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return "Erro ao excluir o PedidoCyberSnack.";
        }
    }

    // Método para listar todos os PedidoCyberSnacks
    public List<PedidoCyberSnack> listarPedidoCyberSnacks() {
        try {
            TypedQuery<PedidoCyberSnack> query = entityManager.createQuery("SELECT p FROM PedidoCyberSnack p", PedidoCyberSnack.class);
            return query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para fechar o EntityManager
    public void fechar() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
