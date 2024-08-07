package com.example.senac.view;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class DebitoView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    
    private CyberStationView cyberStationView;
    private PagamentoView pagamentoView;

    public DebitoView(CardLayout cardLayout, JPanel mainPanel) {
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
        cardDebito = new javax.swing.JPanel();
        tituloDebito = new javax.swing.JLabel();
        quadradoDebito = new javax.swing.JPanel();
        textoNumCartao = new javax.swing.JLabel();
        campoNumCartao = new javax.swing.JTextField();
        botaoVoltar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoConcluir = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardDebito.setBackground(new java.awt.Color(36, 45, 65));
        cardDebito.setPreferredSize(new java.awt.Dimension(1366, 720));

        tituloDebito.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloDebito.setForeground(new java.awt.Color(27, 137, 75));
        tituloDebito.setText("Débito");

        quadradoDebito.setBackground(new java.awt.Color(50, 60, 83));

        textoNumCartao.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        textoNumCartao.setForeground(new java.awt.Color(195, 195, 195));
        textoNumCartao.setText("Número do Cartão");

        campoNumCartao.setText("                     Digite Aqui!");
        campoNumCartao.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (campoNumCartao.getText().equals("                     Digite Aqui!")) {
                    campoNumCartao.setText("");
                }
            }
        
            @Override
            public void focusLost(FocusEvent e) {
                if (campoNumCartao.getText().isEmpty()) {
                    campoNumCartao.setText("                     Digite Aqui!");
                }
            }
        });

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

        javax.swing.GroupLayout quadradoDebitoLayout = new javax.swing.GroupLayout(quadradoDebito);
        quadradoDebito.setLayout(quadradoDebitoLayout);
        quadradoDebitoLayout.setHorizontalGroup(
            quadradoDebitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoDebitoLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(quadradoDebitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoNumCartao)
                    .addComponent(campoNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoDebitoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(botaoCancelar)
                .addGap(46, 46, 46)
                .addComponent(botaoConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        quadradoDebitoLayout.setVerticalGroup(
            quadradoDebitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoDebitoLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(textoNumCartao)
                .addGap(18, 18, 18)
                .addComponent(campoNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(quadradoDebitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoConcluir))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout cardDebitoLayout = new javax.swing.GroupLayout(cardDebito);
        cardDebito.setLayout(cardDebitoLayout);
        cardDebitoLayout.setHorizontalGroup(
            cardDebitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardDebitoLayout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addGroup(cardDebitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(quadradoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cardDebitoLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(tituloDebito)))
                .addContainerGap(451, Short.MAX_VALUE))
        );
        cardDebitoLayout.setVerticalGroup(
            cardDebitoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardDebitoLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(tituloDebito)
                .addGap(33, 33, 33)
                .addComponent(quadradoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardDebito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (campoNumCartao.getText().trim().equals("Digite Aqui!")) {
            JOptionPane.showMessageDialog(null, "Informe o número do cartão para fazer o pagamento!");
        } else {
            pagamentoView.cadastrarDadosDoPedido();

            JOptionPane.showMessageDialog(null, "Seu pedido foi concluído com sucesso. Agradecemos por escolher o Bits & Bytes, volte sempre!");
            System.exit(0); // Fecha o programa
        }
    }//GEN-LAST:event_botaoConcluirActionPerformed

    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        JOptionPane.showMessageDialog(null, "Seu pedido foi cancelado.");
        cyberStationView.cancelarReservaCyberStation();
        System.exit(0); // Fecha o programa
    }//GEN-LAST:event_botaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JButton botaoConcluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JTextField campoNumCartao;
    private javax.swing.JPanel cardDebito;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JPanel quadradoDebito;
    private javax.swing.JLabel textoNumCartao;
    private javax.swing.JLabel tituloDebito;
    // End of variables declaration//GEN-END:variables
}
