package com.example.senac.view;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class PixView extends javax.swing.JPanel {

    String qrCode = 
        "███████████████████████████████\n" +
        "██ ▄▄▄▄▄ ██▀▄▀█▀ █▀▄▀██ ▄▄▄▄▄ ██\n" +
        "██ █   █ ██ ▀█ ▀ █▀ ▀██ █   █ ██\n" +
        "██ █▄▄▄█ ██ █▀ █▀█▄▀███ █▄▄▄█ ██\n" +
        "██▄▄▄▄▄█ ██▄▀▄█▄▀▄▀ █▄██▄▄▄▄▄█ ██\n" +
        "██▄▄ ▄▄▀██▀▄ █ ▄▀█ █▀▄█ █▄█ ▄█ ██\n" +
        "██▄▄▀██▄██▄▀▀ ▄█▄▀▀▄▀█▄▀▀▄█▄█▄███\n" +
        "██████▀▄██▀█ ▄▀▄▀ ▀▄▀██▀▀ ▀ █▄██\n" +
        "██▄▄▄▄▄▄▄▄ ▀▄█▀█▀█ ▀▀ ▀ ▄▄█▄▄▄▄█\n" +
        "██ ▄▄▄▄▄ ██▀ █▀██▄█▄ ▀▀▄█▀ █▄▀██\n" +
        "██ █   █ ██▄▀█▄▀▄▀▀ ▄▀▀▄▄█ ▀ ▀██\n" +
        "██ █▄▄▄█ ██▄█▄▄█▄▀▄█▀▀▀▄█ ▀██▄██\n" +
        "██▄▄▄▄▄▄▄██▄▄▄██▄█▄█▄▄▄█▄██▄████\n" +
        "███████████████████████████████";
    
    private CardLayout cardLayout;
    private JPanel mainPanel;

    private CyberStationView cyberStationView;
    private PagamentoView pagamentoView;
    
    public PixView(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        initComponents();
    }

    public void setCyberStationView(CyberStationView cyberStationView) {
        this.cyberStationView = cyberStationView;
    }

    public void setPagamentoView(PagamentoView pagamentoView) {
        this.pagamentoView = pagamentoView;
    }
    
    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardPix = new javax.swing.JPanel();
        tituloPix = new javax.swing.JLabel();
        quadradoPix = new javax.swing.JPanel();
        textoQRCode = new javax.swing.JLabel();
        botaoVoltar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoConcluir = new javax.swing.JButton();
        areaQRCode = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardPix.setBackground(new java.awt.Color(36, 45, 65));
        cardPix.setPreferredSize(new java.awt.Dimension(1366, 720));

        tituloPix.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloPix.setForeground(new java.awt.Color(27, 137, 75));
        tituloPix.setText("PIX");

        quadradoPix.setBackground(new java.awt.Color(50, 60, 83));

        textoQRCode.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        textoQRCode.setForeground(new java.awt.Color(195, 195, 195));
        textoQRCode.setText("QR CODE");

        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setFocusPainted(false);
        botaoVoltar.setBackground(new java.awt.Color(94, 34, 122));
        botaoVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoVoltar.setForeground(new java.awt.Color(174, 174, 174));
        botaoVoltar.setText("Voltar");
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoCancelar.setBorderPainted(false);
        botaoCancelar.setFocusPainted(false);
        botaoCancelar.setBackground(new java.awt.Color(165, 21, 21));
        botaoCancelar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCancelar.setForeground(new java.awt.Color(174, 174, 174));
        botaoCancelar.setText("Cancelar pedido");
        botaoCancelar.setToolTipText("");
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        botaoConcluir.setBorderPainted(false);
        botaoConcluir.setFocusPainted(false);
        botaoConcluir.setBackground(new java.awt.Color(17, 137, 56));
        botaoConcluir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoConcluir.setForeground(new java.awt.Color(174, 174, 174));
        botaoConcluir.setText("Concluir");
        botaoConcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoConcluirActionPerformed(evt);
            }
        });

        areaQRCode.setColumns(20);
        areaQRCode.setRows(5);
        areaQRCode.setText("Aqui fica o QR Code executando.");
        areaQRCode.setText(qrCode);

        javax.swing.GroupLayout quadradoPixLayout = new javax.swing.GroupLayout(quadradoPix);
        quadradoPix.setLayout(quadradoPixLayout);
        quadradoPixLayout.setHorizontalGroup(
            quadradoPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoPixLayout.createSequentialGroup()
                .addGap(0, 17, Short.MAX_VALUE)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(botaoCancelar)
                .addGap(46, 46, 46)
                .addComponent(botaoConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(quadradoPixLayout.createSequentialGroup()
                .addGroup(quadradoPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoPixLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(textoQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(quadradoPixLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(areaQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        quadradoPixLayout.setVerticalGroup(
            quadradoPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoPixLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(textoQRCode)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(areaQRCode, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(quadradoPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoConcluir))
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout cardPixLayout = new javax.swing.GroupLayout(cardPix);
        cardPix.setLayout(cardPixLayout);
        cardPixLayout.setHorizontalGroup(
            cardPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPixLayout.createSequentialGroup()
                .addGap(391, 391, 391)
                .addGroup(cardPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quadradoPix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardPixLayout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(tituloPix)))
                .addContainerGap(470, Short.MAX_VALUE))
        );
        cardPixLayout.setVerticalGroup(
            cardPixLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPixLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(tituloPix)
                .addGap(18, 18, 18)
                .addComponent(quadradoPix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardPix, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        cardLayout.show(mainPanel, "pagamento");
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoConcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoConcluirActionPerformed
        pagamentoView.cadastrarDadosDoPedido();
        
        JOptionPane.showMessageDialog(null, "Seu pedido foi concluído com sucesso. Agradecemos por escolher o Bits & Bytes, volte sempre!");
        System.exit(0); // Fecha o programa
    }//GEN-LAST:event_botaoConcluirActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        JOptionPane.showMessageDialog(null, "Seu pedido foi cancelado.");
        cyberStationView.cancelarReservaCyberStation();
        System.exit(0); // Fecha o programa
    }//GEN-LAST:event_botaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaQRCode;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConcluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JPanel cardPix;
    private javax.swing.JPanel quadradoPix;
    private javax.swing.JLabel textoQRCode;
    private javax.swing.JLabel tituloPix;
    // End of variables declaration//GEN-END:variables
}
