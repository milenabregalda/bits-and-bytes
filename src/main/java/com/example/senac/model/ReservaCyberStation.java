package com.example.senac.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas_cyberstation")
public class ReservaCyberStation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuario;

    @Column(name = "data_reserva", nullable = false)
    private LocalDate dataReserva;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_termino", nullable = false)
    private LocalTime horaTermino;

    @Column(name = "mesa", nullable = false)
    private int mesa;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    private static Long idContador = 0L;

    public ReservaCyberStation() {
    }

    public ReservaCyberStation(Usuario usuario, LocalDate dataReserva, LocalTime horaInicio, LocalTime horaTermino, int mesa,
            Status status) {
        this.usuario = usuario;
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.mesa = mesa;
        this.status = status;
        this.id = ++idContador; // Lógica que não é necessária com banco de dados
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(LocalTime horaTermino) {
        this.horaTermino = horaTermino;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ReservaCyberStation [id=" + id + ", usuario=" + usuario + ", dataReserva=" + dataReserva
                + ", horaInicio=" + horaInicio + ", horaTermino=" + horaTermino + ", mesa=" + mesa + ", status="
                + status + "]";
    }

    public enum Status {
        DISPONIVEL, INDISPONIVEL
    }
}
