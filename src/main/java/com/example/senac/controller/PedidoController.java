package com.example.senac.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.util.List;
import com.example.senac.model.Pedido;
import com.example.senac.model.PedidoCyberSnack;
import com.example.senac.model.Usuario;

public class PedidoController {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PedidoController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // Método para criar o objeto Pedido com os dados inseridos na aplicação
    public Pedido criarObjetoPedido(Usuario usuario, LocalDate dataPedido, float valorTotal, Pedido.TipoPagamento tipoPagamento, int parcelas, List<PedidoCyberSnack> itensPedido) {
        Pedido pedido = new Pedido(usuario, dataPedido, valorTotal, tipoPagamento, parcelas, itensPedido);
        return pedido;
    }

    // Método para cadastrar Pedido no banco de dados
    public boolean cadastrarPedido(Pedido pedido) {
        try {
            entityManager.getTransaction().begin();
            // Persistir o Pedido
            entityManager.persist(pedido);
    
            // Garantir que os itens do pedido estejam anexados
            for (PedidoCyberSnack item : pedido.getItensPedido()) {
                // O pedido e o CyberSnack já devem estar gerenciados
                if (!entityManager.contains(item.getPedido())) {
                    item.setPedido(entityManager.merge(item.getPedido()));
                }
                if (!entityManager.contains(item.getCyberSnack())) {
                    item.setCyberSnack(entityManager.merge(item.getCyberSnack()));
                }
                entityManager.persist(item);
            }
    
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            return false;
        }
    }

    // Método para obter um Pedido pelo ID
    public Pedido obterPedido(Long id) {
        try {
            return entityManager.find(Pedido.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para atualizar um Pedido existente
    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        try {
            entityManager.getTransaction().begin();
            Pedido pedido = entityManager.find(Pedido.class, id);
            if (pedido != null) {
                pedido.setUsuario(pedidoAtualizado.getUsuario());
                pedido.setDataPedido(pedidoAtualizado.getDataPedido());
                pedido.setValorTotal(pedidoAtualizado.getValorTotal());
                pedido.setTipoPagamento(pedidoAtualizado.getTipoPagamento());
                pedido.setParcelas(pedidoAtualizado.getParcelas());
                pedido.setItensPedido(pedidoAtualizado.getItensPedido());
                entityManager.merge(pedido);
            }
            entityManager.getTransaction().commit();
            return pedido;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para excluir um Pedido
    public String excluirPedido(Long id) {
        try {
            entityManager.getTransaction().begin();
            Pedido pedido = entityManager.find(Pedido.class, id);
            if (pedido != null) {
                entityManager.remove(pedido);
                entityManager.getTransaction().commit();
                return "Pedido excluído com sucesso.";
            } else {
                entityManager.getTransaction().rollback();
                return "Pedido não encontrado.";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return "Erro ao excluir o pedido.";
        }
    }

    // Método para listar todos os Pedidos
    public List<Pedido> listarPedidos() {
        try {
            TypedQuery<Pedido> query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);
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