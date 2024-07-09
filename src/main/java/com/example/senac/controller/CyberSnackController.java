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

    public CyberSnackController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para criar o objeto CyberSnack
    public CyberSnack criarObjetoCyberSnack(String nome, Tipo tipo, float preco) {
        CyberSnack snack = new CyberSnack(nome, tipo, preco);
        cyberSnacks.add(snack);
        return snack;
    }

    // Método para criar um novo CyberSnack no banco de dados
    public boolean criarCyberSnack(CyberSnack cyberSnack) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cyberSnack);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
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

    public List<CyberSnack> getObjetosCyberSnacks() {
        return cyberSnacks;
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
