package com.example.senac.model;

import javax.persistence.*;
import java.util.Date;
import java.sql.Time;

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
    @Temporal(TemporalType.DATE)
    private Date dataReserva;

    @Column(name = "hora_inicio", nullable = false)
    @Temporal(TemporalType.TIME)
    private Time horaInicio;

    @Column(name = "hora_termino", nullable = false)
    @Temporal(TemporalType.TIME)
    private Time horaTermino;

    @Column(name = "mesa", nullable = false)
    private int mesa;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    public ReservaCyberStation() {
    }

    public ReservaCyberStation(Usuario usuario, Date dataReserva, Time horaInicio, Time horaTermino, int mesa,
            Status status) {
        this.usuario = usuario;
        this.dataReserva = dataReserva;
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;
        this.mesa = mesa;
        this.status = status;
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

    public Date getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(Date dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraTermino() {
        return horaTermino;
    }

    public void setHoraTermino(Time horaTermino) {
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
