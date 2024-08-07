package com.example.senac.view;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.example.senac.model.CyberSnack;

public class DocesView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CyberSnacksView cyberSnacksView;

    private ArrayList<CyberSnack> docesCyberSnacks;
    private ArrayList<Integer> qtdDoces;
    public ArrayList<CyberSnack> docesSelecionados;
    public ArrayList<Integer>qtdsSelecionadas;

    public DocesView(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.docesCyberSnacks = new ArrayList<>();
        this.qtdDoces = new ArrayList<>();
        this.docesSelecionados = new ArrayList<>();
        this.qtdsSelecionadas = new ArrayList<>();
        initComponents();
    }

    public void setCyberSnacksView(CyberSnacksView cyberSnacksView) {
        this.cyberSnacksView = cyberSnacksView;
    }

    public void addDoceCyberSnack(CyberSnack doceCyberSnack) {
        docesCyberSnacks.add(doceCyberSnack);
    }

    private void obterQuantidades() {
        qtdDoces.clear();
        
        qtdDoces.add(Integer.parseInt((String) comboDocesBrigadeiro.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesSonho.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesSorveteChocolate.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesSorveteMorango.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesSorveteMisto.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesMilkshakeChocolate.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesMilkshakeMorango.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesMilkshakeBaunilha.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesSaladaDeFrutas.getSelectedItem()));
        qtdDoces.add(Integer.parseInt((String) comboDocesCheesecake.getSelectedItem()));
    }

    public void definirDocesSelecionados() {
        docesSelecionados.clear();
        qtdsSelecionadas.clear();
    
        for (int i = 0; i < docesCyberSnacks.size(); i++) {
            if (qtdDoces.get(i) != 0) {
                docesSelecionados.add(docesCyberSnacks.get(i));
                qtdsSelecionadas.add(qtdDoces.get(i));
            }
        }
    }
    
    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardDoces = new javax.swing.JPanel();
        tituloDoces = new javax.swing.JLabel();
        quadradoDoces = new javax.swing.JPanel();
        comboDocesBrigadeiro = new javax.swing.JComboBox<>();
        comboDocesSonho = new javax.swing.JComboBox<>();
        comboDocesSorveteChocolate = new javax.swing.JComboBox<>();
        comboDocesSorveteMorango = new javax.swing.JComboBox<>();
        comboDocesSorveteMisto = new javax.swing.JComboBox<>();
        comboDocesCheesecake = new javax.swing.JComboBox<>();
        comboDocesMilkshakeChocolate = new javax.swing.JComboBox<>();
        comboDocesMilkshakeMorango = new javax.swing.JComboBox<>();
        comboDocesSaladaDeFrutas = new javax.swing.JComboBox<>();
        comboDocesMilkshakeBaunilha = new javax.swing.JComboBox<>();
        textoDocesBrigadeiro = new javax.swing.JLabel();
        precoDocesBrigadeiro = new javax.swing.JLabel();
        textoDocesSonho = new javax.swing.JLabel();
        textoDocesSorveteChocolate = new javax.swing.JLabel();
        textoDocesSorveteMorango = new javax.swing.JLabel();
        textoDocesMilkshakeChocolate = new javax.swing.JLabel();
        textoDocesSorveteMisto = new javax.swing.JLabel();
        textoDocesMilkshakeMorango = new javax.swing.JLabel();
        textoDocesMilkshakeBaunilha = new javax.swing.JLabel();
        textoDocesSaladaDeFrutas = new javax.swing.JLabel();
        textoDocesCheesecake = new javax.swing.JLabel();
        precoDocesSonho = new javax.swing.JLabel();
        precoDocesSorveteChocolate = new javax.swing.JLabel();
        precoDocesSorveteMorango = new javax.swing.JLabel();
        precoDocesSorveteMisto = new javax.swing.JLabel();
        precoDocesMilkshakeChocolate = new javax.swing.JLabel();
        precoDocesMilkshakeMorango = new javax.swing.JLabel();
        precoDocesMilkshakeBaunilha = new javax.swing.JLabel();
        precoDocesSaladaDeFrutas = new javax.swing.JLabel();
        precoDocesCheesecake = new javax.swing.JLabel();
        botaoDocesVoltar = new javax.swing.JButton();
        botaoDocesFinalizarCompra = new javax.swing.JButton();
        botaoDocesAdicionarAoCarrinho = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardDoces.setBackground(new java.awt.Color(36, 45, 65));

        tituloDoces.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloDoces.setForeground(new java.awt.Color(27, 137, 75));
        tituloDoces.setText("Doces");

        quadradoDoces.setBackground(new java.awt.Color(50, 60, 83));

        comboDocesBrigadeiro.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesBrigadeiro.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesBrigadeiro.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesBrigadeiro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesSonho.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesSonho.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesSonho.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesSonho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesSorveteChocolate.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesSorveteChocolate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesSorveteChocolate.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesSorveteChocolate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesSorveteMorango.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesSorveteMorango.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesSorveteMorango.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesSorveteMorango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesSorveteMisto.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesSorveteMisto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesSorveteMisto.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesSorveteMisto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesCheesecake.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesCheesecake.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesCheesecake.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesCheesecake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesMilkshakeChocolate.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesMilkshakeChocolate.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesMilkshakeChocolate.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesMilkshakeChocolate.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesMilkshakeMorango.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesMilkshakeMorango.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesMilkshakeMorango.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesMilkshakeMorango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesSaladaDeFrutas.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesSaladaDeFrutas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesSaladaDeFrutas.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesSaladaDeFrutas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboDocesMilkshakeBaunilha.setBackground(new java.awt.Color(217, 217, 217));
        comboDocesMilkshakeBaunilha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboDocesMilkshakeBaunilha.setForeground(new java.awt.Color(75, 75, 75));
        comboDocesMilkshakeBaunilha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        textoDocesBrigadeiro.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesBrigadeiro.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesBrigadeiro.setText("Brigadeiro");

        precoDocesBrigadeiro.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesBrigadeiro.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesBrigadeiro.setText("R$ 6.00");

        textoDocesSonho.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesSonho.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesSonho.setText("Sonho");

        textoDocesSorveteChocolate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesSorveteChocolate.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesSorveteChocolate.setText("Sorvete Chocolate");

        textoDocesSorveteMorango.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesSorveteMorango.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesSorveteMorango.setText("Sorvete de Morango");

        textoDocesMilkshakeChocolate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesMilkshakeChocolate.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesMilkshakeChocolate.setText("MilkShake de Chocolate");

        textoDocesSorveteMisto.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesSorveteMisto.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesSorveteMisto.setText("Sorvete Misto");

        textoDocesMilkshakeMorango.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesMilkshakeMorango.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesMilkshakeMorango.setText("MilkShake de Morango");

        textoDocesMilkshakeBaunilha.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesMilkshakeBaunilha.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesMilkshakeBaunilha.setText("MilkShake de Baunilha");

        textoDocesSaladaDeFrutas.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesSaladaDeFrutas.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesSaladaDeFrutas.setText("Salada de Frutas");

        textoDocesCheesecake.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoDocesCheesecake.setForeground(new java.awt.Color(195, 195, 195));
        textoDocesCheesecake.setText("Cheesecake");

        precoDocesSonho.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesSonho.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesSonho.setText("R$ 8.00");

        precoDocesSorveteChocolate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesSorveteChocolate.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesSorveteChocolate.setText("R$ 10.00");

        precoDocesSorveteMorango.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesSorveteMorango.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesSorveteMorango.setText("R$ 10.00");

        precoDocesSorveteMisto.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesSorveteMisto.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesSorveteMisto.setText("R$ 11.00");

        precoDocesMilkshakeChocolate.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesMilkshakeChocolate.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesMilkshakeChocolate.setText("R$ 21.00");

        precoDocesMilkshakeMorango.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesMilkshakeMorango.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesMilkshakeMorango.setText("R$ 21.00");

        precoDocesMilkshakeBaunilha.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesMilkshakeBaunilha.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesMilkshakeBaunilha.setText("R$ 21.00");

        precoDocesSaladaDeFrutas.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesSaladaDeFrutas.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesSaladaDeFrutas.setText("R$ 12.00");

        precoDocesCheesecake.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoDocesCheesecake.setForeground(new java.awt.Color(27, 137, 75));
        precoDocesCheesecake.setText("R$ 15.00");

        javax.swing.GroupLayout quadradoDocesLayout = new javax.swing.GroupLayout(quadradoDoces);
        quadradoDoces.setLayout(quadradoDocesLayout);
        quadradoDocesLayout.setHorizontalGroup(
            quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoDocesLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboDocesCheesecake, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesSaladaDeFrutas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesMilkshakeBaunilha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesMilkshakeMorango, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesMilkshakeChocolate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesSorveteMisto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesSorveteMorango, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesSorveteChocolate, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesSonho, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboDocesBrigadeiro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesBrigadeiro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesBrigadeiro))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesSonho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesSonho))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesSorveteChocolate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesSorveteChocolate))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesSorveteMorango)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesSorveteMorango))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesMilkshakeChocolate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesMilkshakeChocolate))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesSorveteMisto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesSorveteMisto))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesMilkshakeMorango)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesMilkshakeMorango))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesMilkshakeBaunilha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesMilkshakeBaunilha))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesSaladaDeFrutas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesSaladaDeFrutas))
                    .addGroup(quadradoDocesLayout.createSequentialGroup()
                        .addComponent(textoDocesCheesecake)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoDocesCheesecake)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        quadradoDocesLayout.setVerticalGroup(
            quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoDocesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesBrigadeiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesBrigadeiro)
                    .addComponent(precoDocesBrigadeiro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesSonho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesSonho)
                    .addComponent(precoDocesSonho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesSorveteChocolate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesSorveteChocolate)
                    .addComponent(precoDocesSorveteChocolate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesSorveteMorango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesSorveteMorango)
                    .addComponent(precoDocesSorveteMorango))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesSorveteMisto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesSorveteMisto)
                    .addComponent(precoDocesSorveteMisto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesMilkshakeChocolate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesMilkshakeChocolate)
                    .addComponent(precoDocesMilkshakeChocolate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesMilkshakeMorango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesMilkshakeMorango)
                    .addComponent(precoDocesMilkshakeMorango))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesMilkshakeBaunilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesMilkshakeBaunilha)
                    .addComponent(precoDocesMilkshakeBaunilha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesSaladaDeFrutas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesSaladaDeFrutas)
                    .addComponent(precoDocesSaladaDeFrutas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboDocesCheesecake, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoDocesCheesecake)
                    .addComponent(precoDocesCheesecake))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        botaoDocesVoltar.setBorderPainted(false);
        botaoDocesVoltar.setFocusPainted(false);
        botaoDocesVoltar.setBackground(new java.awt.Color(94, 34, 122));
        botaoDocesVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoDocesVoltar.setForeground(new java.awt.Color(174, 174, 174));
        botaoDocesVoltar.setText("Voltar");
        botaoDocesVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDocesVoltarActionPerformed(evt);
            }
        });

        botaoDocesFinalizarCompra.setBorderPainted(false);
        botaoDocesFinalizarCompra.setFocusPainted(false);
        botaoDocesFinalizarCompra.setBackground(new java.awt.Color(17, 137, 56));
        botaoDocesFinalizarCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoDocesFinalizarCompra.setForeground(new java.awt.Color(174, 174, 174));
        botaoDocesFinalizarCompra.setText("Finalizar compra");
        botaoDocesFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDocesFinalizarCompraActionPerformed(evt);
            }
        });

        botaoDocesAdicionarAoCarrinho.setBorderPainted(false);
        botaoDocesAdicionarAoCarrinho.setFocusPainted(false);
        botaoDocesAdicionarAoCarrinho.setBackground(new java.awt.Color(94, 34, 122));
        botaoDocesAdicionarAoCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoDocesAdicionarAoCarrinho.setForeground(new java.awt.Color(174, 174, 174));
        botaoDocesAdicionarAoCarrinho.setText("Adicionar ao carrinho");
        botaoDocesAdicionarAoCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDocesAdicionarAoCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardDocesLayout = new javax.swing.GroupLayout(cardDoces);
        cardDoces.setLayout(cardDocesLayout);
        cardDocesLayout.setHorizontalGroup(
            cardDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardDocesLayout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addGroup(cardDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quadradoDoces, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(cardDocesLayout.createSequentialGroup()
                        .addComponent(botaoDocesVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botaoDocesFinalizarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoDocesAdicionarAoCarrinho)))
                .addGap(432, 432, 432))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardDocesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloDoces)
                .addGap(541, 541, 541))
        );
        cardDocesLayout.setVerticalGroup(
            cardDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardDocesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tituloDoces)
                .addGap(18, 18, 18)
                .addComponent(quadradoDoces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cardDocesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoDocesFinalizarCompra)
                    .addComponent(botaoDocesAdicionarAoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoDocesVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardDoces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardDoces, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardLayoutPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardLayoutPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void botaoDocesVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDocesVoltarActionPerformed
        cardLayout.show(mainPanel, "cyberSnacks");
    }//GEN-LAST:event_botaoDocesVoltarActionPerformed

    private void botaoDocesFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDocesFinalizarCompraActionPerformed
        if(comboDocesBrigadeiro.getSelectedItem()!="0" || comboDocesCheesecake.getSelectedItem()!="0" || comboDocesMilkshakeBaunilha.getSelectedItem()!="0" || comboDocesMilkshakeChocolate.getSelectedItem()!="0" || comboDocesMilkshakeMorango.getSelectedItem()!="0" || comboDocesSaladaDeFrutas.getSelectedItem()!="0" || comboDocesSonho.getSelectedItem()!="0" || comboDocesSorveteChocolate.getSelectedItem()!="0" || comboDocesSorveteMisto.getSelectedItem()!="0" || comboDocesSorveteMorango.getSelectedItem()!="0"){
            obterQuantidades();
            definirDocesSelecionados();
            cyberSnacksView.atualizarDadosCyberSnacks();
            
            cardLayout.show(mainPanel, "confirmacaoPedido");
        } else {
            JOptionPane.showMessageDialog(DocesView.this, 
                "Insira uma opção ou volte.", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_botaoDocesFinalizarCompraActionPerformed

    private void botaoDocesAdicionarAoCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {
        // Verifica se alguma combobox foi selecionada com quantidade diferente de "0"
        if (!"0".equals(comboDocesBrigadeiro.getSelectedItem()) ||
            !"0".equals(comboDocesCheesecake.getSelectedItem()) ||
            !"0".equals(comboDocesMilkshakeBaunilha.getSelectedItem()) ||
            !"0".equals(comboDocesMilkshakeChocolate.getSelectedItem()) ||
            !"0".equals(comboDocesMilkshakeMorango.getSelectedItem()) ||
            !"0".equals(comboDocesSaladaDeFrutas.getSelectedItem()) ||
            !"0".equals(comboDocesSonho.getSelectedItem()) ||
            !"0".equals(comboDocesSorveteChocolate.getSelectedItem()) ||
            !"0".equals(comboDocesSorveteMisto.getSelectedItem()) ||
            !"0".equals(comboDocesSorveteMorango.getSelectedItem())) {

            obterQuantidades();
            definirDocesSelecionados();
            cyberSnacksView.atualizarDadosCyberSnacks();

            // Mostra a próxima tela
            cardLayout.show(mainPanel, "cyberSnacks");
        } else {
            JOptionPane.showMessageDialog(DocesView.this,
                "Selecione pelo menos um doce.",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoDocesAdicionarAoCarrinho;
    private javax.swing.JButton botaoDocesFinalizarCompra;
    private javax.swing.JButton botaoDocesVoltar;
    private javax.swing.JPanel cardDoces;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JComboBox<String> comboDocesBrigadeiro;
    private javax.swing.JComboBox<String> comboDocesCheesecake;
    private javax.swing.JComboBox<String> comboDocesMilkshakeBaunilha;
    private javax.swing.JComboBox<String> comboDocesMilkshakeChocolate;
    private javax.swing.JComboBox<String> comboDocesMilkshakeMorango;
    private javax.swing.JComboBox<String> comboDocesSaladaDeFrutas;
    private javax.swing.JComboBox<String> comboDocesSonho;
    private javax.swing.JComboBox<String> comboDocesSorveteChocolate;
    private javax.swing.JComboBox<String> comboDocesSorveteMisto;
    private javax.swing.JComboBox<String> comboDocesSorveteMorango;
    private javax.swing.JLabel precoDocesBrigadeiro;
    private javax.swing.JLabel precoDocesCheesecake;
    private javax.swing.JLabel precoDocesMilkshakeBaunilha;
    private javax.swing.JLabel precoDocesMilkshakeChocolate;
    private javax.swing.JLabel precoDocesMilkshakeMorango;
    private javax.swing.JLabel precoDocesSaladaDeFrutas;
    private javax.swing.JLabel precoDocesSonho;
    private javax.swing.JLabel precoDocesSorveteChocolate;
    private javax.swing.JLabel precoDocesSorveteMisto;
    private javax.swing.JLabel precoDocesSorveteMorango;
    private javax.swing.JPanel quadradoDoces;
    private javax.swing.JLabel textoDocesBrigadeiro;
    private javax.swing.JLabel textoDocesCheesecake;
    private javax.swing.JLabel textoDocesMilkshakeBaunilha;
    private javax.swing.JLabel textoDocesMilkshakeChocolate;
    private javax.swing.JLabel textoDocesMilkshakeMorango;
    private javax.swing.JLabel textoDocesSaladaDeFrutas;
    private javax.swing.JLabel textoDocesSonho;
    private javax.swing.JLabel textoDocesSorveteChocolate;
    private javax.swing.JLabel textoDocesSorveteMisto;
    private javax.swing.JLabel textoDocesSorveteMorango;
    private javax.swing.JLabel tituloDoces;
    // End of variables declaration//GEN-END:variables
}
