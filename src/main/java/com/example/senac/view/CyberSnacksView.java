package com.example.senac.view;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import com.example.senac.controller.CyberSnackController;
import com.example.senac.model.CyberSnack;

public class CyberSnacksView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private CyberSnackController cyberSnackController;
    private CyberStationView cyberStationView;
    private ConfirmacaoPedidoView confirmacaoPedidoView;

    private SalgadosView salgadosView;
    private BebidasView bebidasView;
    private DocesView docesView;
    private CombosSemanaisView combosSemanaisView;
    private ArrayList<CyberSnack> todosOsCyberSnacks;
    private ArrayList<CyberSnack>cyberSnacksSelecionados;
    private ArrayList<Integer>quantidadesSelecionadas;

    private double precoCyberSnacks = 0;

    public CyberSnacksView(CardLayout cardLayout, JPanel mainPanel, CyberSnackController cyberSnackController) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.cyberSnackController = cyberSnackController;
        this.todosOsCyberSnacks = new ArrayList<>(); // Inicializar a lista
        this.cyberSnacksSelecionados = new ArrayList<>();
        this.quantidadesSelecionadas = new ArrayList<>();
        initComponents();
    }

    public void setCyberStationView(CyberStationView cyberStationView) {
        this.cyberStationView = cyberStationView;
    }

    public void setSalgadosView(SalgadosView salgadosView) {
        this.salgadosView = salgadosView;
    }

    public void setBebidasView(BebidasView bebidasView) {
        this.bebidasView = bebidasView;
    }

    public void setDocesView(DocesView docesView) {
        this.docesView = docesView;
    }

    public void setCombosSemanaisView(CombosSemanaisView combosSemanaisView) {
        this.combosSemanaisView = combosSemanaisView;
    }

    public void setConfirmacaoPedidoView(ConfirmacaoPedidoView confirmacaoPedidoView) {
        this.confirmacaoPedidoView = confirmacaoPedidoView;
    }

    public double getPrecoCyberSnacks() {
        return precoCyberSnacks;
    }

    public static float converterStringPraNumero(String valorMonetario) {
        String numeroString = valorMonetario.replaceAll("[^0-9.]", "");
        float numero = Float.parseFloat(numeroString);
        return numero;
    }

    public void definirVetoresCyberSnacks() {
        // Obter todos os CyberSnacks do banco de dados
        List<CyberSnack> cyberSnacks = cyberSnackController.listarCyberSnacks();
    
        if (cyberSnacks != null) {
            // Limpar lista antes de adicionar novos itens
            todosOsCyberSnacks.clear();
    
            // Filtrar e adicionar CyberSnacks com ID de 1 a 35 no ArrayList
            for (CyberSnack cyberSnack : cyberSnacks) {
                if (cyberSnack.getId() >= 1 && cyberSnack.getId() <= 35) {
                    todosOsCyberSnacks.add(cyberSnack);
                }
    
                // Verifica se o tipo é COMBO e adiciona na lista específica
                if (cyberSnack.getTipo() == CyberSnack.Tipo.COMBO) {
                    combosSemanaisView.addComboCyberSnack(cyberSnack);
                }

                // Verifica se o tipo é SALGADO e adiciona na lista específica
                if (cyberSnack.getTipo() == CyberSnack.Tipo.SALGADO) {
                    salgadosView.addSalgadoCyberSnack(cyberSnack);
                }

                // Verifica se o tipo é BEBIDA e adiciona na lista específica
                if (cyberSnack.getTipo() == CyberSnack.Tipo.BEBIDA) {
                    bebidasView.addBebidaCyberSnack(cyberSnack);
                }

                // Verifica se o tipo é DOCE e adiciona na lista específica
                if (cyberSnack.getTipo() == CyberSnack.Tipo.DOCE) {
                    docesView.addDoceCyberSnack(cyberSnack);
                }
            }
            
        } else {
            //System.out.println("Erro ao encontrar os CyberSnacks.");
        }
        System.out.println("\n\n\n\n");
    }

    public void definirDadosCyberSnacksSelecionados() {
        cyberSnacksSelecionados.clear();
        quantidadesSelecionadas.clear();

        // Adiciona todos os tipos de cybersnacks selecionados para um arraylist só
        // (precisa estar na mesma ordem do debaixo):
        if (salgadosView.salgadosSelecionados != null) {
            for (int i = 0; i < salgadosView.salgadosSelecionados.size(); i++) {
                cyberSnacksSelecionados.add(salgadosView.salgadosSelecionados.get(i));
            }   
        }  

        if (docesView.docesSelecionados != null) {
            for (int i = 0; i < docesView.docesSelecionados.size(); i++) {
                cyberSnacksSelecionados.add(docesView.docesSelecionados.get(i));
            }   
        }

        if (bebidasView.bebidasSelecionadas != null) {
            for (int i = 0; i < bebidasView.bebidasSelecionadas.size(); i++) {
                cyberSnacksSelecionados.add(bebidasView.bebidasSelecionadas.get(i));
            }   
        }   

        if (combosSemanaisView.combosSelecionados != null) {
            for (int i = 0; i < combosSemanaisView.combosSelecionados.size(); i++) {
                cyberSnacksSelecionados.add(combosSemanaisView.combosSelecionados.get(i));
            }   
        }   
    
        // Adiciona as qtdsSelecionadas de todos os cybersnacks e adiciona para um arraylist só
        // (precisa estar na mesma ordem do de cima):
        if (salgadosView.qtdsSelecionadas != null) {
            for (int i = 0; i < salgadosView.qtdsSelecionadas.size(); i++) {
                quantidadesSelecionadas.add(salgadosView.qtdsSelecionadas.get(i));
            }
        }

        if (docesView.qtdsSelecionadas != null) {
            for (int i = 0; i < docesView.qtdsSelecionadas.size(); i++) {
                quantidadesSelecionadas.add(docesView.qtdsSelecionadas.get(i));
            }
        }

        if (bebidasView.qtdsSelecionadas != null) {
            for (int i = 0; i < bebidasView.qtdsSelecionadas.size(); i++) {
                quantidadesSelecionadas.add(bebidasView.qtdsSelecionadas.get(i));
            }
        }

        if (combosSemanaisView.qtdsSelecionadas != null) {
            for (int i = 0; i < combosSemanaisView.qtdsSelecionadas.size(); i++) {
                quantidadesSelecionadas.add(combosSemanaisView.qtdsSelecionadas.get(i));
            }
        }
    }

    // Método que define os dados dos CyberSnacks para mostrar na confirmação do pedido
    public String definirDadosCyberSnacks() {
        
        String dados = "\nCYBERSNACKS\n" +
                       "---------------------------------------\n";
        precoCyberSnacks = 0; // Por enquanto
    
        if (cyberSnacksSelecionados.isEmpty()) {
            dados += "Nenhum CyberSnack foi selecionado.\n\n";
        }

        else if (cyberSnacksSelecionados != null) {
            for (int i = 0; i < cyberSnacksSelecionados.size(); i++) {
                CyberSnack cyberSnack = cyberSnacksSelecionados.get(i);
                int quantidade = quantidadesSelecionadas.get(i);
                double precoCyberSnack = cyberSnack.getPreco() * quantidade;
                precoCyberSnacks += precoCyberSnack;
        
                dados += "Nome: " + cyberSnack.getNome() + "\n" +
                         "Tipo: " + cyberSnack.getTipo() + "\n" +
                         "Preço unitário: R$ " + String.format("%.2f", cyberSnack.getPreco()) + "\n" +
                         "Quantidade: " + quantidade + "\n\n";
            }
        }
        
        return dados;
    }

    public ArrayList<CyberSnack> getCyberSnacksSelecionados() {
        return cyberSnacksSelecionados;
    }

    public ArrayList<Integer> getQuantidadesSelecionadas() {
        return quantidadesSelecionadas;
    }

    public void atualizarDadosConfirmacaoPedido() {
        confirmacaoPedidoView.atualizarDadosPedido();
    }

    public void atualizarDadosCyberSnacks() {
        definirDadosCyberSnacksSelecionados();
        atualizarDadosConfirmacaoPedido();
    }
    
    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardCyberSnacks = new javax.swing.JPanel();
        tituloCyberSnacks = new javax.swing.JLabel();
        sloganCyberSnacksPt1 = new javax.swing.JLabel();
        sloganCyberSnacksPt2 = new javax.swing.JLabel();
        quadradoCyberSnacks = new javax.swing.JPanel();
        botaoCyberSnacksSalgados = new javax.swing.JButton();
        botaoCyberSnacksDoces = new javax.swing.JButton();
        botaoCyberSnacksBebidas = new javax.swing.JButton();
        botaoCyberSnacksSair = new javax.swing.JButton();
        botaoCyberSnacksCombosSemanais = new javax.swing.JButton();
        botaoCyberSnacksFinalizarCompra = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardCyberSnacks.setBackground(new java.awt.Color(36, 45, 65));

        tituloCyberSnacks.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloCyberSnacks.setForeground(new java.awt.Color(27, 137, 75));
        tituloCyberSnacks.setText("Cyber Snacks");

        sloganCyberSnacksPt1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        sloganCyberSnacksPt1.setForeground(new java.awt.Color(195, 195, 195));
        sloganCyberSnacksPt1.setText("Transforme seu momento digital em");

        sloganCyberSnacksPt2.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        sloganCyberSnacksPt2.setForeground(new java.awt.Color(195, 195, 195));
        sloganCyberSnacksPt2.setText("uma experiência gastronômica.");

        quadradoCyberSnacks.setBackground(new java.awt.Color(50, 60, 83));

        botaoCyberSnacksSalgados.setBorderPainted(false);
        botaoCyberSnacksSalgados.setFocusPainted(false);
        botaoCyberSnacksSalgados.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberSnacksSalgados.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCyberSnacksSalgados.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberSnacksSalgados.setText("SALGADOS");
        botaoCyberSnacksSalgados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberSnacksSalgadosActionPerformed(evt);
            }
        });

        botaoCyberSnacksDoces.setBorderPainted(false);
        botaoCyberSnacksDoces.setFocusPainted(false);
        botaoCyberSnacksDoces.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberSnacksDoces.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCyberSnacksDoces.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberSnacksDoces.setText("DOCES");
        botaoCyberSnacksDoces.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberSnacksDocesActionPerformed(evt);
            }
        });

        botaoCyberSnacksBebidas.setBorderPainted(false);
        botaoCyberSnacksBebidas.setFocusPainted(false);
        botaoCyberSnacksBebidas.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberSnacksBebidas.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCyberSnacksBebidas.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberSnacksBebidas.setText("BEBIDAS");
        botaoCyberSnacksBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberSnacksBebidasActionPerformed(evt);
            }
        });

        botaoCyberSnacksSair.setBorderPainted(false);
        botaoCyberSnacksSair.setFocusPainted(false);
        botaoCyberSnacksSair.setBackground(new java.awt.Color(165, 21, 21));
        botaoCyberSnacksSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCyberSnacksSair.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberSnacksSair.setText("Sair");
        botaoCyberSnacksSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberSnacksSairActionPerformed(evt);
            }
        });

        botaoCyberSnacksCombosSemanais.setBorderPainted(false);
        botaoCyberSnacksCombosSemanais.setFocusPainted(false);
        botaoCyberSnacksCombosSemanais.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberSnacksCombosSemanais.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCyberSnacksCombosSemanais.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberSnacksCombosSemanais.setText("COMBOS SEMANAIS");
        botaoCyberSnacksCombosSemanais.setToolTipText("");
        botaoCyberSnacksCombosSemanais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberSnacksCombosSemanaisActionPerformed(evt);
            }
        });

        botaoCyberSnacksFinalizarCompra.setBorderPainted(false);
        botaoCyberSnacksFinalizarCompra.setFocusPainted(false);
        botaoCyberSnacksFinalizarCompra.setBackground(new java.awt.Color(17, 137, 56));
        botaoCyberSnacksFinalizarCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCyberSnacksFinalizarCompra.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberSnacksFinalizarCompra.setText("Finalizar compra");
        botaoCyberSnacksFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberSnacksFinalizarCompraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout quadradoCyberSnacksLayout = new javax.swing.GroupLayout(quadradoCyberSnacks);
        quadradoCyberSnacks.setLayout(quadradoCyberSnacksLayout);
        quadradoCyberSnacksLayout.setHorizontalGroup(
            quadradoCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCyberSnacksLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addGroup(quadradoCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoCyberSnacksLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(quadradoCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoCyberSnacksSair, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoCyberSnacksFinalizarCompra)))
                    .addComponent(botaoCyberSnacksCombosSemanais)
                    .addGroup(quadradoCyberSnacksLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(quadradoCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botaoCyberSnacksBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoCyberSnacksDoces, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(138, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoCyberSnacksLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoCyberSnacksSalgados, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        quadradoCyberSnacksLayout.setVerticalGroup(
            quadradoCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoCyberSnacksLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(botaoCyberSnacksSalgados, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCyberSnacksDoces, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCyberSnacksBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCyberSnacksCombosSemanais, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoCyberSnacksFinalizarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoCyberSnacksSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout cardCyberSnacksLayout = new javax.swing.GroupLayout(cardCyberSnacks);
        cardCyberSnacks.setLayout(cardCyberSnacksLayout);
        cardCyberSnacksLayout.setHorizontalGroup(
            cardCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCyberSnacksLayout.createSequentialGroup()
                .addGroup(cardCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardCyberSnacksLayout.createSequentialGroup()
                        .addGap(376, 376, 376)
                        .addGroup(cardCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tituloCyberSnacks)
                            .addGroup(cardCyberSnacksLayout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(cardCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sloganCyberSnacksPt1)
                                    .addGroup(cardCyberSnacksLayout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(sloganCyberSnacksPt2))))))
                    .addGroup(cardCyberSnacksLayout.createSequentialGroup()
                        .addGap(429, 429, 429)
                        .addComponent(quadradoCyberSnacks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(408, Short.MAX_VALUE))
        );
        cardCyberSnacksLayout.setVerticalGroup(
            cardCyberSnacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCyberSnacksLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tituloCyberSnacks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sloganCyberSnacksPt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sloganCyberSnacksPt2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quadradoCyberSnacks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCyberSnacks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCyberSnacks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botaoCyberSnacksSalgadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberSnacksSalgadosActionPerformed
        cardLayout.show(mainPanel, "salgados");
    }//GEN-LAST:event_botaoCyberSnacksSalgadosActionPerformed

    private void botaoCyberSnacksDocesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberSnacksDocesActionPerformed
        cardLayout.show(mainPanel, "doces");
    }//GEN-LAST:event_botaoCyberSnacksDocesActionPerformed

    private void botaoCyberSnacksBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberSnacksBebidasActionPerformed
        cardLayout.show(mainPanel, "bebidas");
    }//GEN-LAST:event_botaoCyberSnacksBebidasActionPerformed

    private void botaoCyberSnacksSairActionPerformed(java.awt.event.ActionEvent evt) {
        cyberStationView.cancelarReservaCyberStation();
        System.exit(0);
    }

    private void botaoCyberSnacksCombosSemanaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberSnacksCombosSemanaisActionPerformed
        cardLayout.show(mainPanel, "combosSemanais");
    }//GEN-LAST:event_botaoCyberSnacksCombosSemanaisActionPerformed

    private void botaoCyberSnacksFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberSnacksFinalizarCompraActionPerformed
        //atualizarDadosCyberSnacks();
        
        cardLayout.show(mainPanel, "confirmacaoPedido");
    }//GEN-LAST:event_botaoCyberSnacksFinalizarCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCyberSnacksBebidas;
    private javax.swing.JButton botaoCyberSnacksCombosSemanais;
    private javax.swing.JButton botaoCyberSnacksDoces;
    private javax.swing.JButton botaoCyberSnacksFinalizarCompra;
    private javax.swing.JButton botaoCyberSnacksSair;
    private javax.swing.JButton botaoCyberSnacksSalgados;
    private javax.swing.JPanel cardCyberSnacks;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JPanel quadradoCyberSnacks;
    private javax.swing.JLabel sloganCyberSnacksPt1;
    private javax.swing.JLabel sloganCyberSnacksPt2;
    private javax.swing.JLabel tituloCyberSnacks;
    // End of variables declaration//GEN-END:variables
}
