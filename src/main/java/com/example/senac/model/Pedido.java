package com.example.senac.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuario;

    @Column(name = "data_pedido", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataPedido;

    @Column(name = "valor_total", nullable = false)
    private float valorTotal;

    @Column(name = "tipo_pagamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Column(name = "parcelas")
    private int parcelas;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<PedidoCyberSnack> itensPedido;
    
    public Pedido() {
    }

    public Pedido(Usuario usuario, Date dataPedido, float valorTotal, TipoPagamento tipoPagamento, int parcelas,
            List<PedidoCyberSnack> itensPedido) {
        this.usuario = usuario;
        this.dataPedido = dataPedido;
        this.valorTotal = valorTotal;
        this.tipoPagamento = tipoPagamento;
        this.parcelas = parcelas;
        this.itensPedido = itensPedido;
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

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

    public List<PedidoCyberSnack> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<PedidoCyberSnack> itensPedido) {
        this.itensPedido = itensPedido;
    }

    @Override
    public String toString() {
        return "Pedido [id=" + id + ", usuario=" + usuario + ", dataPedido=" + dataPedido + ", valorTotal=" + valorTotal
                + ", tipoPagamento=" + tipoPagamento + ", parcelas=" + parcelas + ", itensPedido=" + itensPedido + "]";
    }

    public enum TipoPagamento {
        DEBITO, CREDITO, PIX
    }
}