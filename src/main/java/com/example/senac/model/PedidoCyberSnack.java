package com.example.senac.model;

import javax.persistence.*;

@Entity
@Table(name = "pedidos_cybersnacks")
public class PedidoCyberSnack {

    // Colunas de Id:
    @EmbeddedId
    private PedidoCyberSnackId id; // Por causa de pedido_id e cybersnacks_id

    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @MapsId("cybersnacksId")
    @JoinColumn(name = "cybersnacks_id", nullable = false)
    private CyberSnack cyberSnack;

    // Outras colunas:
    @Column(name = "quantidade", nullable = false)
    private int quantidade;

    @Column(name = "preco", nullable = false)
    private float preco;

    public PedidoCyberSnack() {
    }

    public PedidoCyberSnack(Pedido pedido, CyberSnack cyberSnack, int quantidade, float preco) {
        this.pedido = pedido;
        this.cyberSnack = cyberSnack;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public PedidoCyberSnackId getId() {
        return id;
    }

    public void setId(PedidoCyberSnackId id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public CyberSnack getCyberSnack() {
        return cyberSnack;
    }

    public void setCyberSnack(CyberSnack cyberSnack) {
        this.cyberSnack = cyberSnack;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "PedidoCyberSnack [id=" + id + ", pedido=" + pedido + ", cyberSnack=" + cyberSnack + ", quantidade="
                + quantidade + ", preco=" + preco + "]";
    }
}