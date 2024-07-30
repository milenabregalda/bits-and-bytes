package com.example.senac.controller;

import javax.swing.JOptionPane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.example.senac.model.PedidoCyberSnackId;

public class PedidoCyberSnackIdController {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PedidoCyberSnackIdController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para criar um novo PedidoCyberSnackId
    public boolean criarPedidoCyberSnackId(PedidoCyberSnackId pedidoCyberSnackId) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pedidoCyberSnackId);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    // Método para obter um PedidoCyberSnackId pelo ID
    public PedidoCyberSnackId obterPedidoCyberSnackId(Long id) {
        try {
            return entityManager.find(PedidoCyberSnackId.class, id);
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
