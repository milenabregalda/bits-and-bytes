package com.example.senac.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

@Embeddable // Dado embutido em outra classe (PedidoCyberCafe)
public class PedidoCyberSnackId implements Serializable {

    @Column(name = "pedido_id")
    private Long pedidoId;

    @Column(name = "cybersnacks_id")
    private Long cyberSnacksId;

    public PedidoCyberSnackId() {
    }

    public PedidoCyberSnackId(Long pedidoId, Long cyberSnacksId) {
        this.pedidoId = pedidoId;
        this.cyberSnacksId = cyberSnacksId;
    }

    // Comparar dois objetos dessa classe e verificar se eles representam a mesma combinação de pedido e cybersnack
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidoCyberSnackId that = (PedidoCyberSnackId) o;
        return pedidoId.equals(that.pedidoId) && cyberSnacksId.equals(that.cyberSnacksId);
    }

    /* Para gerar um código hash único para cada objeto dessa classe.
    Este código hash é usado pelo JPA para armazenar e recuperar objetos de forma eficiente
    em coleções como HashMap e HashSet. */
    @Override
    public int hashCode() {
        return Objects.hash(pedidoId, cyberSnacksId);
    }
}
