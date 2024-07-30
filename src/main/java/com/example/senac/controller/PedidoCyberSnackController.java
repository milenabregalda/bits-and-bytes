package com.example.senac.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;

import com.example.senac.model.CyberSnack;
import com.example.senac.model.Pedido;
import com.example.senac.model.PedidoCyberSnack;
import com.example.senac.model.PedidoCyberSnackId;

public class PedidoCyberSnackController {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private List<PedidoCyberSnack> pedidosCyberSnacks = new ArrayList<>();

    public PedidoCyberSnackController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para criar o objeto PedidoCyberSnack
    public PedidoCyberSnack criarObjetoPedidoCyberSnack(Pedido pedido, CyberSnack cyberSnack, int quantidade, float preco) {
        // Garantir que o Pedido e o CyberSnack estão anexados ao EntityManager
        if (!entityManager.contains(pedido)) {
            pedido = entityManager.merge(pedido);
        }
        if (!entityManager.contains(cyberSnack)) {
            cyberSnack = entityManager.merge(cyberSnack);
        }
        
        PedidoCyberSnackId id = new PedidoCyberSnackId(pedido.getId(), cyberSnack.getId());
        PedidoCyberSnack pedidoCyberSnack = new PedidoCyberSnack(pedido, cyberSnack, quantidade, preco);
        pedidoCyberSnack.setId(id);
    
        pedidosCyberSnacks.add(pedidoCyberSnack);
        return pedidoCyberSnack;
    }

    /*// Antes de 30/07/24 - Método para criar o objeto PedidoCyberSnack
    public PedidoCyberSnack criarObjetoPedidoCyberSnack(Pedido pedido, CyberSnack cyberSnack, int quantidade, float preco) {
        PedidoCyberSnackId id = new PedidoCyberSnackId(pedido.getId(), cyberSnack.getId());
        PedidoCyberSnack pedidoCyberSnack = new PedidoCyberSnack(pedido, cyberSnack, quantidade, preco);
        pedidoCyberSnack.setId(id);

        pedidosCyberSnacks.add(pedidoCyberSnack);
        return pedidoCyberSnack;
    }*/

    /*// Método para criar um novo PedidoCyberSnack no banco de dados
    public boolean criarPedidoCyberSnack(PedidoCyberSnack pedidoCyberSnack) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(pedidoCyberSnack);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }*/

    public boolean criarPedidoCyberSnack(PedidoCyberSnack pedidoCyberSnack) {
        try {
            // Garantir que o CyberSnack está anexado ao EntityManager
            CyberSnack cyberSnack = pedidoCyberSnack.getCyberSnack();
            if (!entityManager.contains(cyberSnack)) {
                cyberSnack = entityManager.merge(cyberSnack);
                pedidoCyberSnack.setCyberSnack(cyberSnack);
            }
    
            entityManager.getTransaction().begin();
            entityManager.persist(pedidoCyberSnack);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
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
