package com.example.senac.view;

import java.awt.CardLayout;
import javax.swing.JPanel;

import com.example.senac.model.CyberSnack;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Calendar;

public class CombosSemanaisView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CyberSnacksView cyberSnacksView;
    private ArrayList<CyberSnack> combosCyberSnacks;
    private ArrayList<Integer> qtdCombos;
    public ArrayList<CyberSnack> combosSelecionados;
    public ArrayList<Integer>qtdsSelecionadas;

    public CombosSemanaisView(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.combosCyberSnacks = new ArrayList<>();
        this.qtdCombos = new ArrayList<>();
        this.combosSelecionados = new ArrayList<>();
        this.qtdsSelecionadas = new ArrayList<>();

        initComponents();
        habilitarComboDoDia();
    }

    public void setCyberSnacksView(CyberSnacksView cyberSnacksView) {
        this.cyberSnacksView = cyberSnacksView;
    }
    
    // Método que pega o dia de hoje e só habilita o combo desse dia para ser adicionado ao carrinho
    private void habilitarComboDoDia() {
        comboCombosSemanaisSegunda.setEnabled(false);
        comboCombosSemanaisTerca.setEnabled(false);
        comboCombosSemanaisQuarta.setEnabled(false);
        comboCombosSemanaisQuinta.setEnabled(false);
        comboCombosSemanaisSexta.setEnabled(false);
        Calendar cal = Calendar.getInstance();
        int diaDaSemana = cal.get(Calendar.DAY_OF_WEEK);
    
        switch (diaDaSemana) {
            case Calendar.MONDAY:
                comboCombosSemanaisSegunda.setEnabled(true);
                break;
            case Calendar.TUESDAY:
                comboCombosSemanaisTerca.setEnabled(true);
                break;
            case Calendar.WEDNESDAY:
                comboCombosSemanaisQuarta.setEnabled(true);
                break;
            case Calendar.THURSDAY:
                comboCombosSemanaisQuinta.setEnabled(true);
                break;
            case Calendar.FRIDAY:
                comboCombosSemanaisSexta.setEnabled(true);
                break;
            default:
                // Se for sábado ou domingo, nenhum comboBox é habilitado
                break;
        }
    }

    public void addComboCyberSnack(CyberSnack comboCyberSnack) {
        combosCyberSnacks.add(comboCyberSnack);
    }

    private void obterQuantidades() {
        qtdCombos.clear();

        qtdCombos.add(Integer.parseInt((String) comboCombosSemanaisSegunda.getSelectedItem()));
        qtdCombos.add(Integer.parseInt((String) comboCombosSemanaisTerca.getSelectedItem()));
        qtdCombos.add(Integer.parseInt((String) comboCombosSemanaisQuarta.getSelectedItem()));
        qtdCombos.add(Integer.parseInt((String) comboCombosSemanaisQuinta.getSelectedItem()));
        qtdCombos.add(Integer.parseInt((String) comboCombosSemanaisSexta.getSelectedItem()));
    }

    public void definirCombosSelecionados() {
        combosSelecionados.clear();
        qtdsSelecionadas.clear();
    
        for (int i = 0; i < combosCyberSnacks.size(); i++) {
            if (qtdCombos.get(i) != 0) {
                combosSelecionados.add(combosCyberSnacks.get(i));
                qtdsSelecionadas.add(qtdCombos.get(i));
            }
        }
    }

    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardCombosSemanais = new javax.swing.JPanel();
        tituloCombosSemanais = new javax.swing.JLabel();
        quadradoCombosSemanais = new javax.swing.JPanel();
        comboCombosSemanaisSegunda = new javax.swing.JComboBox<>();
        tituloCombosSemanaisSegunda = new javax.swing.JLabel();
        textoCombosSemanaisSegunda = new javax.swing.JLabel();
        comboCombosSemanaisTerca = new javax.swing.JComboBox<>();
        tituloCombosSemanaisTerca = new javax.swing.JLabel();
        textoCombosSemanaisTerca = new javax.swing.JLabel();
        comboCombosSemanaisQuarta = new javax.swing.JComboBox<>();
        tituloCombosSemanaisQuarta = new javax.swing.JLabel();
        textoCombosSemanaisQuarta = new javax.swing.JLabel();
        comboCombosSemanaisQuinta = new javax.swing.JComboBox<>();
        tituloCombosSemanaisQuinta = new javax.swing.JLabel();
        textoCombosSemanaisQuinta = new javax.swing.JLabel();
        comboCombosSemanaisSexta = new javax.swing.JComboBox<>();
        tituloCombosSemanaisSexta = new javax.swing.JLabel();
        textoCombosSemanaisSexta = new javax.swing.JLabel();
        botaoCombosSemanaisVoltar = new javax.swing.JButton();
        botaoCombosSemanaisFinalizarCompra = new javax.swing.JButton();
        botaoCombosSemanaisAdicionarAoCarrinho = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardCombosSemanais.setBackground(new java.awt.Color(36, 45, 65));

        tituloCombosSemanais.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloCombosSemanais.setForeground(new java.awt.Color(27, 137, 75));
        tituloCombosSemanais.setText("Combos Semanais");

        quadradoCombosSemanais.setBackground(new java.awt.Color(50, 60, 83));

        comboCombosSemanaisSegunda.setBackground(new java.awt.Color(217, 217, 217));
        comboCombosSemanaisSegunda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCombosSemanaisSegunda.setForeground(new java.awt.Color(75, 75, 75));
        comboCombosSemanaisSegunda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));

        tituloCombosSemanaisSegunda.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        tituloCombosSemanaisSegunda.setForeground(new java.awt.Color(195, 195, 195));
        tituloCombosSemanaisSegunda.setText("COMBO SEGUNDA-FEIRA ESPECIAL - R$ 15.30");

        textoCombosSemanaisSegunda.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textoCombosSemanaisSegunda.setForeground(new java.awt.Color(195, 195, 195));
        textoCombosSemanaisSegunda.setText("Pão de Queijo + Espresso + Brigadeiro");

        comboCombosSemanaisTerca.setBackground(new java.awt.Color(217, 217, 217));
        comboCombosSemanaisTerca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCombosSemanaisTerca.setForeground(new java.awt.Color(75, 75, 75));
        comboCombosSemanaisTerca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));

        tituloCombosSemanaisTerca.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        tituloCombosSemanaisTerca.setForeground(new java.awt.Color(195, 195, 195));
        tituloCombosSemanaisTerca.setText("COMBO TERÇA-FEIRA SABOROSA - R$ 23.40");

        textoCombosSemanaisTerca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textoCombosSemanaisTerca.setForeground(new java.awt.Color(195, 195, 195));
        textoCombosSemanaisTerca.setText("Coxinha + Café com Leite + Sonho");

        comboCombosSemanaisQuarta.setBackground(new java.awt.Color(217, 217, 217));
        comboCombosSemanaisQuarta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCombosSemanaisQuarta.setForeground(new java.awt.Color(75, 75, 75));
        comboCombosSemanaisQuarta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));

        tituloCombosSemanaisQuarta.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        tituloCombosSemanaisQuarta.setForeground(new java.awt.Color(195, 195, 195));
        tituloCombosSemanaisQuarta.setText("COMBO QUARTA-FEIRA QUENTE - R$ 27.00");

        textoCombosSemanaisQuarta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textoCombosSemanaisQuarta.setForeground(new java.awt.Color(195, 195, 195));
        textoCombosSemanaisQuarta.setText("Enroladinho + Cappuccino Cremoso de Baunilha + Salada de Frutas");

        comboCombosSemanaisQuinta.setBackground(new java.awt.Color(217, 217, 217));
        comboCombosSemanaisQuinta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCombosSemanaisQuinta.setForeground(new java.awt.Color(75, 75, 75));
        comboCombosSemanaisQuinta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));

        tituloCombosSemanaisQuinta.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        tituloCombosSemanaisQuinta.setForeground(new java.awt.Color(195, 195, 195));
        tituloCombosSemanaisQuinta.setText("COMBO QUINTA-FEIRA GELADA - R$ 35.10");

        textoCombosSemanaisQuinta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textoCombosSemanaisQuinta.setForeground(new java.awt.Color(195, 195, 195));
        textoCombosSemanaisQuinta.setText("Empada de Frango + Chá Gelado de Frutas Vermelhas + Sorvete de Chocolate");

        comboCombosSemanaisSexta.setBackground(new java.awt.Color(217, 217, 217));
        comboCombosSemanaisSexta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCombosSemanaisSexta.setForeground(new java.awt.Color(75, 75, 75));
        comboCombosSemanaisSexta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5" }));

        tituloCombosSemanaisSexta.setFont(new java.awt.Font("Segoe UI", 1, 19)); // NOI18N
        tituloCombosSemanaisSexta.setForeground(new java.awt.Color(195, 195, 195));
        tituloCombosSemanaisSexta.setText("COMBO SEXTA-FEIRA DELÍCIA - R$ 31.50");

        textoCombosSemanaisSexta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textoCombosSemanaisSexta.setForeground(new java.awt.Color(195, 195, 195));
        textoCombosSemanaisSexta.setText("Pastel de Queijo + Smoothie Refrescante + Cheesecake");

        javax.swing.GroupLayout quadradoCombosSemanaisLayout = new javax.swing.GroupLayout(quadradoCombosSemanais);
        quadradoCombosSemanais.setLayout(quadradoCombosSemanaisLayout);
        quadradoCombosSemanaisLayout.setHorizontalGroup(
            quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCombosSemanaisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoCombosSemanaisLayout.createSequentialGroup()
                        .addComponent(comboCombosSemanaisQuarta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCombosSemanaisQuarta)
                            .addComponent(tituloCombosSemanaisQuarta)))
                    .addGroup(quadradoCombosSemanaisLayout.createSequentialGroup()
                        .addComponent(comboCombosSemanaisTerca, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCombosSemanaisTerca)
                            .addComponent(tituloCombosSemanaisTerca)))
                    .addGroup(quadradoCombosSemanaisLayout.createSequentialGroup()
                        .addComponent(comboCombosSemanaisSegunda, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCombosSemanaisSegunda)
                            .addComponent(tituloCombosSemanaisSegunda)))
                    .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, quadradoCombosSemanaisLayout.createSequentialGroup()
                            .addComponent(comboCombosSemanaisSexta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textoCombosSemanaisSexta)
                                .addComponent(tituloCombosSemanaisSexta)))
                        .addGroup(quadradoCombosSemanaisLayout.createSequentialGroup()
                            .addComponent(comboCombosSemanaisQuinta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textoCombosSemanaisQuinta)
                                .addComponent(tituloCombosSemanaisQuinta)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        quadradoCombosSemanaisLayout.setVerticalGroup(
            quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCombosSemanaisLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCombosSemanaisSegunda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCombosSemanaisSegunda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCombosSemanaisSegunda)
                .addGap(18, 18, 18)
                .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCombosSemanaisTerca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCombosSemanaisTerca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCombosSemanaisTerca)
                .addGap(18, 18, 18)
                .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCombosSemanaisQuarta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCombosSemanaisQuarta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCombosSemanaisQuarta)
                .addGap(18, 18, 18)
                .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCombosSemanaisQuinta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCombosSemanaisQuinta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCombosSemanaisQuinta)
                .addGap(18, 18, 18)
                .addGroup(quadradoCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCombosSemanaisSexta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tituloCombosSemanaisSexta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoCombosSemanaisSexta)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        botaoCombosSemanaisVoltar.setBorderPainted(false);
        botaoCombosSemanaisVoltar.setFocusPainted(false);
        botaoCombosSemanaisVoltar.setBackground(new java.awt.Color(94, 34, 122));
        botaoCombosSemanaisVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCombosSemanaisVoltar.setForeground(new java.awt.Color(174, 174, 174));
        botaoCombosSemanaisVoltar.setText("Voltar");
        botaoCombosSemanaisVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCombosSemanaisVoltarActionPerformed(evt);
            }
        });

        botaoCombosSemanaisFinalizarCompra.setBorderPainted(false);
        botaoCombosSemanaisFinalizarCompra.setFocusPainted(false);
        botaoCombosSemanaisFinalizarCompra.setBackground(new java.awt.Color(17, 137, 56));
        botaoCombosSemanaisFinalizarCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCombosSemanaisFinalizarCompra.setForeground(new java.awt.Color(174, 174, 174));
        botaoCombosSemanaisFinalizarCompra.setText("Finalizar compra");
        botaoCombosSemanaisFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCombosSemanaisFinalizarCompraActionPerformed(evt);
            }
        });

        botaoCombosSemanaisAdicionarAoCarrinho.setBorderPainted(false);
        botaoCombosSemanaisAdicionarAoCarrinho.setFocusPainted(false);
        botaoCombosSemanaisAdicionarAoCarrinho.setBackground(new java.awt.Color(94, 34, 122));
        botaoCombosSemanaisAdicionarAoCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCombosSemanaisAdicionarAoCarrinho.setForeground(new java.awt.Color(174, 174, 174));
        botaoCombosSemanaisAdicionarAoCarrinho.setText("Adicionar ao carrinho");
        botaoCombosSemanaisAdicionarAoCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCombosSemanaisAdicionarAoCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardCombosSemanaisLayout = new javax.swing.GroupLayout(cardCombosSemanais);
        cardCombosSemanais.setLayout(cardCombosSemanaisLayout);
        cardCombosSemanaisLayout.setHorizontalGroup(
            cardCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCombosSemanaisLayout.createSequentialGroup()
                .addContainerGap(285, Short.MAX_VALUE)
                .addGroup(cardCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardCombosSemanaisLayout.createSequentialGroup()
                        .addComponent(tituloCombosSemanais)
                        .addGap(271, 271, 271))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardCombosSemanaisLayout.createSequentialGroup()
                        .addGroup(cardCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(cardCombosSemanaisLayout.createSequentialGroup()
                                .addComponent(botaoCombosSemanaisVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(botaoCombosSemanaisFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(botaoCombosSemanaisAdicionarAoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12))
                            .addComponent(quadradoCombosSemanais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(347, 347, 347))))
        );
        cardCombosSemanaisLayout.setVerticalGroup(
            cardCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCombosSemanaisLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tituloCombosSemanais)
                .addGap(18, 18, 18)
                .addComponent(quadradoCombosSemanais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cardCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoCombosSemanaisFinalizarCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(cardCombosSemanaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(botaoCombosSemanaisAdicionarAoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoCombosSemanaisVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(121, 121, 121))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCombosSemanais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCombosSemanais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botaoCombosSemanaisVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCombosSemanaisVoltarActionPerformed
        cardLayout.show(mainPanel, "cyberSnacks");
    }//GEN-LAST:event_botaoCombosSemanaisVoltarActionPerformed

    private void botaoCombosSemanaisFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCombosSemanaisFinalizarCompraActionPerformed
        if (comboCombosSemanaisQuarta.getSelectedItem()!="0" || comboCombosSemanaisQuinta.getSelectedItem()!="0" || comboCombosSemanaisSegunda.getSelectedItem()!="0" || comboCombosSemanaisSexta.getSelectedItem()!="0" || comboCombosSemanaisTerca.getSelectedItem()!="0"){
            combosSelecionados.clear();
            qtdsSelecionadas.clear();
            obterQuantidades();
            definirCombosSelecionados();
            cyberSnacksView.atualizarDadosCyberSnacks();
            cardLayout.show(mainPanel, "confirmacaoPedido");
        } else {
            JOptionPane.showMessageDialog(CombosSemanaisView.this, 
                "Insira uma opção ou volte.", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);   
      }
    }//GEN-LAST:event_botaoCombosSemanaisFinalizarCompraActionPerformed

    private void botaoCombosSemanaisAdicionarAoCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {
        // Verifica se alguma combobox foi selecionada com quantidade diferente de "0"
        if (!"0".equals(comboCombosSemanaisSegunda.getSelectedItem()) ||
            !"0".equals(comboCombosSemanaisTerca.getSelectedItem()) ||
            !"0".equals(comboCombosSemanaisQuarta.getSelectedItem()) ||
            !"0".equals(comboCombosSemanaisQuinta.getSelectedItem()) ||
            !"0".equals(comboCombosSemanaisSexta.getSelectedItem())) {

            // Mostra a próxima tela
            cardLayout.show(mainPanel, "cyberSnacks");
        } else {
            JOptionPane.showMessageDialog(CombosSemanaisView.this,
                "Selecione pelo menos um combo semanal.",
                "Erro",
                JOptionPane.ERROR_MESSAGE);
        }

        combosSelecionados.clear();
        qtdsSelecionadas.clear();
        obterQuantidades();
        definirCombosSelecionados();
        cyberSnacksView.atualizarDadosCyberSnacks();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCombosSemanaisAdicionarAoCarrinho;
    private javax.swing.JButton botaoCombosSemanaisFinalizarCompra;
    private javax.swing.JButton botaoCombosSemanaisVoltar;
    private javax.swing.JPanel cardCombosSemanais;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JComboBox<String> comboCombosSemanaisQuarta;
    private javax.swing.JComboBox<String> comboCombosSemanaisQuinta;
    private javax.swing.JComboBox<String> comboCombosSemanaisSegunda;
    private javax.swing.JComboBox<String> comboCombosSemanaisSexta;
    private javax.swing.JComboBox<String> comboCombosSemanaisTerca;
    private javax.swing.JPanel quadradoCombosSemanais;
    private javax.swing.JLabel textoCombosSemanaisQuarta;
    private javax.swing.JLabel textoCombosSemanaisQuinta;
    private javax.swing.JLabel textoCombosSemanaisSegunda;
    private javax.swing.JLabel textoCombosSemanaisSexta;
    private javax.swing.JLabel textoCombosSemanaisTerca;
    private javax.swing.JLabel tituloCombosSemanais;
    private javax.swing.JLabel tituloCombosSemanaisQuarta;
    private javax.swing.JLabel tituloCombosSemanaisQuinta;
    private javax.swing.JLabel tituloCombosSemanaisSegunda;
    private javax.swing.JLabel tituloCombosSemanaisSexta;
    private javax.swing.JLabel tituloCombosSemanaisTerca;
    // End of variables declaration//GEN-END:variables
}
