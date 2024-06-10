package com.example.senac.model;

import javax.persistence.*;

@Entity
@Table(name = "cybersnacks")
public class CyberSnack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    @Column(name = "preco", nullable = false)
    private float preco;

    private static Long idContador = 0L;
    
    public CyberSnack() {
    }

    public CyberSnack(String nome, Tipo tipo, float preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.preco = preco;
        this.id = ++idContador; // Lógica que não é necessária com banco de dados
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "CyberSnack [id=" + id + ", nome=" + nome + ", tipo=" + tipo + ", preco=" + preco + "]";
    }

    public enum Tipo {
        SALGADO, DOCE, BEBIDA, COMBO
    }
}