package com.example.senac.view;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.util.List;
import javax.swing.JOptionPane;

import com.example.senac.controller.ReservaCyberStationController;
import com.example.senac.model.ReservaCyberStation;

public class ConfirmacaoPedidoView extends javax.swing.JPanel {

    /**
     * Creates new form Interface
     */

     String dadosPedidoPlaceHolder = "RESERVAS CYBERSTATION\n" +
        "----------------------------------------\n" +
        "ID: 1\n" +
        "Usuário: Usuário\n" +
        "Data: 2024-06-11\n" +
        "Hora de Início: 13:00\n" +
        "Hora de Término: 14:00\n" +
        "Status: DISPONIVEL\n" +
        "Preço (R$ 10.00/hora): R$ 10.00\n\n\n" +
        
        "CYBERSNACKS\n" +
        "---------------------------------------\n" +
        "Quantidade: 2\n" +
        "Nome: Pão de Queijo\n" +
        "Tipo: SALGADO\n" +
        "Preço: 2x de R$ 10.00\n\n" +

        "Quantidade: 1\n" +
        "Nome: Sorvete Misto\n" +
        "Tipo: DOCE\n" +
        "Preço: R$ 11.00\n\n" +

        "Quantidade: 1\n" +
        "Nome: Café com Leite\n" +
        "Tipo: BEBIDA\n" +
        "Preço: R$ 10.00\n\n" +

        "Quantidade: 1\n" +
        "Nome: COMBO TERÇA-FEIRA SABOROSA\n" +
        "Tipo: COMBO\n" +
        "Preço: R$ 23.40\n\n" +

        "\nTOTAL\n---------------------------------------\n" +
        "R$ 74.40\n";

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private ReservaCyberStationController reservaCyberStationController;
    List<ReservaCyberStation> reservas;

    public ConfirmacaoPedidoView(CardLayout cardLayout, JPanel mainPanel, ReservaCyberStationController reservaCyberStationController) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.reservaCyberStationController = reservaCyberStationController;
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardConfirmacaoPedido = new javax.swing.JPanel();
        tituloConfirmacaoPedido = new javax.swing.JLabel();
        quadradoConfirmacaoPedido = new javax.swing.JPanel();
        textoConfirmacaoPedidoDadosPedido = new javax.swing.JLabel();
        barraAreaConfirmacaoPedido = new javax.swing.JScrollPane();
        areaConfirmacaoPedidoTexto = new javax.swing.JTextArea();
        botaoConfirmacaoPedidoVoltar = new javax.swing.JButton();
        botaoConfirmacaoPedidoPersonalizar = new javax.swing.JButton();
        botaoConfirmacaoPedidoConcluir = new javax.swing.JButton();
        botaoConfirmacaoPedidoCancelar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardConfirmacaoPedido.setBackground(new java.awt.Color(36, 45, 65));

        tituloConfirmacaoPedido.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloConfirmacaoPedido.setForeground(new java.awt.Color(27, 137, 75));
        tituloConfirmacaoPedido.setText("O pedido está correto?");

        quadradoConfirmacaoPedido.setBackground(new java.awt.Color(50, 60, 83));

        textoConfirmacaoPedidoDadosPedido.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        textoConfirmacaoPedidoDadosPedido.setForeground(new java.awt.Color(195, 195, 195));
        textoConfirmacaoPedidoDadosPedido.setText("Dados do pedido");

        barraAreaConfirmacaoPedido.setBackground(new java.awt.Color(50, 60, 83));
        barraAreaConfirmacaoPedido.setForeground(new java.awt.Color(50, 60, 83));

        areaConfirmacaoPedidoTexto.setBackground(new java.awt.Color(50, 60, 83));
        areaConfirmacaoPedidoTexto.setColumns(20);
        areaConfirmacaoPedidoTexto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        areaConfirmacaoPedidoTexto.setForeground(new java.awt.Color(174, 174, 174));
        areaConfirmacaoPedidoTexto.setRows(5);
        //areaConfirmacaoPedidoTexto.setText("Aqui vão ficar os dados do pedido\n(de computadores e de comidas).\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n\nAqui vão ficar os dados do pedido.\n");
        areaConfirmacaoPedidoTexto.setText(dadosPedidoPlaceHolder);
        areaConfirmacaoPedidoTexto.setBorder(null);
        barraAreaConfirmacaoPedido.setViewportView(areaConfirmacaoPedidoTexto);

        javax.swing.GroupLayout quadradoConfirmacaoPedidoLayout = new javax.swing.GroupLayout(quadradoConfirmacaoPedido);
        quadradoConfirmacaoPedido.setLayout(quadradoConfirmacaoPedidoLayout);
        quadradoConfirmacaoPedidoLayout.setHorizontalGroup(
            quadradoConfirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoConfirmacaoPedidoLayout.createSequentialGroup()
                .addGroup(quadradoConfirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoConfirmacaoPedidoLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(textoConfirmacaoPedidoDadosPedido))
                    .addGroup(quadradoConfirmacaoPedidoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(barraAreaConfirmacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        quadradoConfirmacaoPedidoLayout.setVerticalGroup(
            quadradoConfirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoConfirmacaoPedidoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(textoConfirmacaoPedidoDadosPedido)
                .addGap(18, 18, 18)
                .addComponent(barraAreaConfirmacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        botaoConfirmacaoPedidoVoltar.setBorderPainted(false);
        botaoConfirmacaoPedidoVoltar.setFocusPainted(false);
        botaoConfirmacaoPedidoVoltar.setBackground(new java.awt.Color(94, 34, 122));
        botaoConfirmacaoPedidoVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoConfirmacaoPedidoVoltar.setForeground(new java.awt.Color(174, 174, 174));
        botaoConfirmacaoPedidoVoltar.setText("Voltar");
        botaoConfirmacaoPedidoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmacaoPedidoVoltarActionPerformed(evt);
            }
        });

        botaoConfirmacaoPedidoPersonalizar.setBorderPainted(false);
        botaoConfirmacaoPedidoPersonalizar.setFocusPainted(false);
        botaoConfirmacaoPedidoPersonalizar.setBackground(new java.awt.Color(94, 34, 122));
        botaoConfirmacaoPedidoPersonalizar.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        botaoConfirmacaoPedidoPersonalizar.setForeground(new java.awt.Color(174, 174, 174));
        botaoConfirmacaoPedidoPersonalizar.setText("Personalizar pedido");
        botaoConfirmacaoPedidoPersonalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmacaoPedidoPersonalizarActionPerformed(evt);
            }
        });

        botaoConfirmacaoPedidoConcluir.setBorderPainted(false);
        botaoConfirmacaoPedidoConcluir.setFocusPainted(false);
        botaoConfirmacaoPedidoConcluir.setBackground(new java.awt.Color(17, 137, 56));
        botaoConfirmacaoPedidoConcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoConfirmacaoPedidoConcluir.setForeground(new java.awt.Color(174, 174, 174));
        botaoConfirmacaoPedidoConcluir.setText("Concluir");
        botaoConfirmacaoPedidoConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmacaoPedidoConcluirActionPerformed(evt);
            }
        });

        botaoConfirmacaoPedidoCancelar.setBorderPainted(false);
        botaoConfirmacaoPedidoCancelar.setFocusPainted(false);
        botaoConfirmacaoPedidoCancelar.setBackground(new java.awt.Color(165, 21, 21));
        botaoConfirmacaoPedidoCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoConfirmacaoPedidoCancelar.setForeground(new java.awt.Color(174, 174, 174));
        botaoConfirmacaoPedidoCancelar.setText("Cancelar pedido");
        botaoConfirmacaoPedidoCancelar.setToolTipText("");
        botaoConfirmacaoPedidoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConfirmacaoPedidoCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardConfirmacaoPedidoLayout = new javax.swing.GroupLayout(cardConfirmacaoPedido);
        cardConfirmacaoPedido.setLayout(cardConfirmacaoPedidoLayout);
        cardConfirmacaoPedidoLayout.setHorizontalGroup(
            cardConfirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardConfirmacaoPedidoLayout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(tituloConfirmacaoPedido)
                .addGap(171, 171, 171))
            .addGroup(cardConfirmacaoPedidoLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addGroup(cardConfirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardConfirmacaoPedidoLayout.createSequentialGroup()
                        .addComponent(botaoConfirmacaoPedidoPersonalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(quadradoConfirmacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardConfirmacaoPedidoLayout.createSequentialGroup()
                        .addComponent(botaoConfirmacaoPedidoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(botaoConfirmacaoPedidoCancelar)
                        .addGap(35, 35, 35)
                        .addComponent(botaoConfirmacaoPedidoConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cardConfirmacaoPedidoLayout.setVerticalGroup(
            cardConfirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardConfirmacaoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloConfirmacaoPedido)
                .addGap(32, 32, 32)
                .addGroup(cardConfirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quadradoConfirmacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardConfirmacaoPedidoLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(botaoConfirmacaoPedidoPersonalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(cardConfirmacaoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoConfirmacaoPedidoConcluir)
                    .addComponent(botaoConfirmacaoPedidoVoltar)
                    .addComponent(botaoConfirmacaoPedidoCancelar))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardConfirmacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardConfirmacaoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botaoConfirmacaoPedidoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmacaoPedidoVoltarActionPerformed
        cardLayout.show(mainPanel, "cyberSnacks");
    }//GEN-LAST:event_botaoConfirmacaoPedidoVoltarActionPerformed

    private void botaoConfirmacaoPedidoPersonalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmacaoPedidoPersonalizarActionPerformed
        cardLayout.show(mainPanel, "cyberStation");
    }//GEN-LAST:event_botaoConfirmacaoPedidoPersonalizarActionPerformed

    private void botaoConfirmacaoPedidoConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmacaoPedidoConcluirActionPerformed
        cardLayout.show(mainPanel, "pagamento");
    }//GEN-LAST:event_botaoConfirmacaoPedidoConcluirActionPerformed

    private void botaoConfirmacaoPedidoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConfirmacaoPedidoCancelarActionPerformed
        JOptionPane.showMessageDialog(null, "Seu pedido foi cancelado.");
        // TALVEZ AQUI REMOVER DO BANCO OU SÓ GRAVAR NO BOTÃO CONCLUIR
        System.exit(0); // Fecha o programa
    }//GEN-LAST:event_botaoConfirmacaoPedidoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaConfirmacaoPedidoTexto;
    private javax.swing.JScrollPane barraAreaConfirmacaoPedido;
    private javax.swing.JButton botaoConfirmacaoPedidoCancelar;
    private javax.swing.JButton botaoConfirmacaoPedidoConcluir;
    private javax.swing.JButton botaoConfirmacaoPedidoPersonalizar;
    private javax.swing.JButton botaoConfirmacaoPedidoVoltar;
    private javax.swing.JPanel cardConfirmacaoPedido;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JPanel quadradoConfirmacaoPedido;
    private javax.swing.JLabel textoConfirmacaoPedidoDadosPedido;
    private javax.swing.JLabel tituloConfirmacaoPedido;
    // End of variables declaration//GEN-END:variables
}
