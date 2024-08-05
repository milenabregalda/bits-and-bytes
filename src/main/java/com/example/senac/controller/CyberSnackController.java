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

    // Método para verificar se o banco está vazio e adicionar itens predefinidos se necessário
    public void inicializarDados() {
        if (listarCyberSnacks().isEmpty()) {
            adicionarCyberSnacksPredefinidos();
        } else {
            //System.out.println("CyberSnacks já estavam cadastrados.");
        }
    }

    private void adicionarCyberSnacksPredefinidos() {
        criarCyberSnack(new CyberSnack("Pão de Queijo", Tipo.SALGADO, 5.00f));
        criarCyberSnack(new CyberSnack("Pastel de Carne", Tipo.SALGADO, 8.00f));
        criarCyberSnack(new CyberSnack("Pastel de Queijo", Tipo.SALGADO, 8.00f));
        criarCyberSnack(new CyberSnack("Pastel de Frango", Tipo.SALGADO, 8.00f));
        criarCyberSnack(new CyberSnack("Pastel de Coração", Tipo.SALGADO, 8.00f));
        criarCyberSnack(new CyberSnack("Coxinha", Tipo.SALGADO, 8.00f));
        criarCyberSnack(new CyberSnack("Enroladinho", Tipo.SALGADO, 8.00f));
        criarCyberSnack(new CyberSnack("Empada de Frango", Tipo.SALGADO, 8.00f));
        criarCyberSnack(new CyberSnack("Empada de Calabresa", Tipo.SALGADO, 8.00f));
        criarCyberSnack(new CyberSnack("Empada", Tipo.SALGADO, 8.00f));

        criarCyberSnack(new CyberSnack("Brigadeiro", Tipo.DOCE, 6.00f));
        criarCyberSnack(new CyberSnack("Sonho", Tipo.DOCE, 8.00f));
        criarCyberSnack(new CyberSnack("Sorvete Chocolate", Tipo.DOCE, 10.00f));
        criarCyberSnack(new CyberSnack("Sorvete de Morango", Tipo.DOCE, 10.00f));
        criarCyberSnack(new CyberSnack("Sorvete Misto", Tipo.DOCE, 11.00f));
        criarCyberSnack(new CyberSnack("MilkShake de Chocolate", Tipo.DOCE, 21.00f));
        criarCyberSnack(new CyberSnack("MilkShake de Morango", Tipo.DOCE, 21.00f));
        criarCyberSnack(new CyberSnack("MilkShake de Baunilha", Tipo.DOCE, 21.00f));
        criarCyberSnack(new CyberSnack("Salada de Frutas", Tipo.DOCE, 12.00f));
        criarCyberSnack(new CyberSnack("Cheesecake", Tipo.DOCE, 15.00f));

        criarCyberSnack(new CyberSnack("Espresso", Tipo.BEBIDA, 6.00f));
        criarCyberSnack(new CyberSnack("Café Preto", Tipo.BEBIDA, 8.00f));
        criarCyberSnack(new CyberSnack("Café com Leite", Tipo.BEBIDA, 10.00f));
        criarCyberSnack(new CyberSnack("Capuccino Cremoso de Baunilha", Tipo.BEBIDA, 10.00f));
        criarCyberSnack(new CyberSnack("Cappuccino de Canela e Caramelo", Tipo.BEBIDA, 11.00f));
        criarCyberSnack(new CyberSnack("Mocha de Chocolate Quente", Tipo.BEBIDA, 21.00f));
        criarCyberSnack(new CyberSnack("Café Gelado Cremoso", Tipo.BEBIDA, 21.00f));
        criarCyberSnack(new CyberSnack("Chá Gelado de Frutas Vermelhas", Tipo.BEBIDA, 21.00f));
        criarCyberSnack(new CyberSnack("Smoothie Refrescante", Tipo.BEBIDA, 12.00f));
        criarCyberSnack(new CyberSnack("Limonada Fresca", Tipo.BEBIDA, 15.00f));

        criarCyberSnack(new CyberSnack("COMBO SEGUNDA-FEIRA ESPECIAL", Tipo.COMBO, 15.30f));
        criarCyberSnack(new CyberSnack("COMBO TERÇA-FEIRA SABOROSA", Tipo.COMBO, 23.40f));
        criarCyberSnack(new CyberSnack("COMBO QUARTA-FEIRA QUENTE", Tipo.COMBO, 27.00f));
        criarCyberSnack(new CyberSnack("COMBO QUINTA-FEIRA GELADA", Tipo.COMBO, 35.10f));
        criarCyberSnack(new CyberSnack("COMBO SEXTA-FEIRA DELÍCIA", Tipo.COMBO, 31.50f));
    }

    // Método para fechar o EntityManager
    public void fechar() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
