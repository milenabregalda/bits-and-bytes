package com.example.senac.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import com.example.senac.model.ReservaCyberStation;
import com.example.senac.model.ReservaCyberStation.Status;
import com.example.senac.model.Usuario;
import java.util.ArrayList;

public class ReservaCyberStationController {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private List<ReservaCyberStation> reservas = new ArrayList<>();

    public ReservaCyberStationController() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("jpa");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public ReservaCyberStation criarObjetoReservaCyberStation(Usuario usuario, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaTermino, int mesa, Status status) {
        ReservaCyberStation reserva = new ReservaCyberStation(usuario, dataReserva, horaInicio, horaTermino, mesa, status);
        reservas.add(reserva);
        return reserva;
    }

    // Método para criar uma nova ReservaCyberStation
    public boolean cadastrarReservaCyberStation(ReservaCyberStation reserva) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(reserva);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    // Método para obter uma ReservaCyberStation pelo ID
    public ReservaCyberStation obterReservaCyberStation(Long id) {
        try {
            return entityManager.find(ReservaCyberStation.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para atualizar uma ReservaCyberStation existente
    public ReservaCyberStation atualizarReservaCyberStation(Long id, ReservaCyberStation reservaAtualizada) {
        try {
            entityManager.getTransaction().begin();
            ReservaCyberStation reserva = entityManager.find(ReservaCyberStation.class, id);
            if (reserva != null) {
                reserva.setUsuario(reservaAtualizada.getUsuario());
                reserva.setDataReserva(reservaAtualizada.getDataReserva());
                reserva.setHoraInicio(reservaAtualizada.getHoraInicio());
                reserva.setHoraTermino(reservaAtualizada.getHoraTermino());
                reserva.setMesa(reservaAtualizada.getMesa());
                reserva.setStatus(reservaAtualizada.getStatus());
                entityManager.merge(reserva);
            }
            entityManager.getTransaction().commit();
            return reserva;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    // Método para excluir uma ReservaCyberStation
    public String excluirReservaCyberStation(Long id) {
        try {
            entityManager.getTransaction().begin();
            ReservaCyberStation reserva = entityManager.find(ReservaCyberStation.class, id);
            if (reserva != null) {
                entityManager.remove(reserva);
                entityManager.getTransaction().commit();
                return "Reserva excluída com sucesso.";
            } else {
                entityManager.getTransaction().rollback();
                return "Reserva não encontrada.";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            return "Erro ao excluir a reserva.";
        }
    }

    public List<ReservaCyberStation> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaCyberStation> reservas) {
        this.reservas = reservas;
    }

    public List<ReservaCyberStation> listarReservas() {
        try {
            TypedQuery<ReservaCyberStation> query = entityManager.createQuery("SELECT r FROM ReservaCyberStation r ORDER BY r.id DESC", ReservaCyberStation.class);
            query.setMaxResults(1); // Limita para retornar apenas uma reserva (a mais recente)
            return query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); // Adicione para imprimir o erro completo no console
            return null;
        }
    }

    // Método para fechar o EntityManager
    public void fechar() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
