package com.example.senac.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.List;
import com.example.senac.model.CyberSnack;
import com.example.senac.model.CyberSnack.Tipo;

public class CyberSnackController {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    private List<CyberSnack> cyberSnacks = new ArrayList<>();

    public void criarObjetoCyberSnack(String nome, Tipo tipo, float preco) {
        CyberSnack snack = new CyberSnack(nome, tipo, preco);
        cyberSnacks.add(snack);
    }

    public List<CyberSnack> getObjetosCyberSnacks() {
        return cyberSnacks;
    }

    // LÓGICA PARA BANCO DE DADOS - POR ENQUANTO, NÃO SERÁ UTILIZADA

    public CyberSnackController() {
        //this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        //this.entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para criar um novo CyberSnack
    public CyberSnack criarCyberSnack(CyberSnack cyberSnack) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cyberSnack);
            entityManager.getTransaction().commit();
            return cyberSnack;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para obter um CyberSnack pelo ID
    public CyberSnack obterCyberSnack(Long id) {
        try {
            return entityManager.find(CyberSnack.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para atualizar um CyberSnack existente
    public CyberSnack atualizarCyberSnack(Long id, CyberSnack cyberSnackAtualizado) {
        try {
            entityManager.getTransaction().begin();
            CyberSnack cyberSnack = entityManager.find(CyberSnack.class, id);
            if (cyberSnack != null) {
                cyberSnack.setNome(cyberSnackAtualizado.getNome());
                cyberSnack.setTipo(cyberSnackAtualizado.getTipo());
                cyberSnack.setPreco(cyberSnackAtualizado.getPreco());
                entityManager.merge(cyberSnack);
            }
            entityManager.getTransaction().commit();
            return cyberSnack;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para excluir um CyberSnack
    public String excluirCyberSnack(Long id) {
        try {
            entityManager.getTransaction().begin();
            CyberSnack cyberSnack = entityManager.find(CyberSnack.class, id);
            if (cyberSnack != null) {
                entityManager.remove(cyberSnack);
                entityManager.getTransaction().commit();
                return "CyberSnack excluído com sucesso.";
            } else {
                entityManager.getTransaction().rollback();
                return "CyberSnack não encontrado.";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return "Erro ao excluir o CyberSnack.";
        }
    }

    // Método para listar todos os CyberSnacks
    public List<CyberSnack> listarCyberSnacks() {
        try {
            TypedQuery<CyberSnack> query = entityManager.createQuery("SELECT c FROM CyberSnack c", CyberSnack.class);
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
