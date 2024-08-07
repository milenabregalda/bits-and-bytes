package com.example.senac.view;

import java.awt.CardLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

public class CreditoView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private CyberStationView cyberStationView;
    private PagamentoView pagamentoView;
    
    public CreditoView(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        initComponents();
    }

    // Método para converter uma string de parcelas em um inteiro
    public static int converterParcelasParaInt(String parcelas) {
        if (parcelas == null || parcelas.isEmpty()) {
            throw new IllegalArgumentException("O valor de parcelas não pode ser nulo ou vazio.");
        }

        try {
            // Remove o caractere 'x' do final e converte a string para inteiro
            return Integer.parseInt(parcelas.substring(0, parcelas.length() - 1));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("O valor de parcelas está em um formato inválido.", e);
        }
    }

    public void setCyberStationView(CyberStationView cyberStationView) {
        // Ao invés de adicionar no controller, adiciona tardiamente para limpeza de campos na outra view
        this.cyberStationView = cyberStationView;
    }

    public void setPagamentoView(PagamentoView pagamentoView) {
        this.pagamentoView = pagamentoView;
    }

    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardCredito = new javax.swing.JPanel();
        tituloCredito = new javax.swing.JLabel();
        quadradoCredito = new javax.swing.JPanel();
        textoNumCartao = new javax.swing.JLabel();
        campoNumCartao = new javax.swing.JTextField();
        textoParcelas = new javax.swing.JLabel();
        comboParcelas = new javax.swing.JComboBox<>();
        botaoVoltar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        botaoConcluir = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardCredito.setBackground(new java.awt.Color(36, 45, 65));
        cardCredito.setPreferredSize(new java.awt.Dimension(1366, 720));

        tituloCredito.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloCredito.setForeground(new java.awt.Color(27, 137, 75));
        tituloCredito.setText("Crédito");

        quadradoCredito.setBackground(new java.awt.Color(50, 60, 83));

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

        textoParcelas.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        textoParcelas.setForeground(new java.awt.Color(195, 195, 195));
        textoParcelas.setText("Parcelas");

        comboParcelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1x", "2x", "3x" }));

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

        javax.swing.GroupLayout quadradoCreditoLayout = new javax.swing.GroupLayout(quadradoCredito);
        quadradoCredito.setLayout(quadradoCreditoLayout);
        quadradoCreditoLayout.setHorizontalGroup(
            quadradoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCreditoLayout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(quadradoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoCreditoLayout.createSequentialGroup()
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(botaoCancelar)
                        .addGap(46, 46, 46)
                        .addComponent(botaoConcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoCreditoLayout.createSequentialGroup()
                        .addGroup(quadradoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(textoNumCartao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(campoNumCartao)
                                .addComponent(comboParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoCreditoLayout.createSequentialGroup()
                                .addComponent(textoParcelas)
                                .addGap(76, 76, 76)))
                        .addGap(144, 144, 144))))
        );
        quadradoCreditoLayout.setVerticalGroup(
            quadradoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCreditoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(textoNumCartao)
                .addGap(18, 18, 18)
                .addComponent(campoNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(textoParcelas)
                .addGap(18, 18, 18)
                .addComponent(comboParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addGroup(quadradoCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoCancelar)
                    .addComponent(botaoConcluir))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout cardCreditoLayout = new javax.swing.GroupLayout(cardCredito);
        cardCredito.setLayout(cardCreditoLayout);
        cardCreditoLayout.setHorizontalGroup(
            cardCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCreditoLayout.createSequentialGroup()
                .addGroup(cardCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardCreditoLayout.createSequentialGroup()
                        .addGap(401, 401, 401)
                        .addComponent(quadradoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardCreditoLayout.createSequentialGroup()
                        .addGap(507, 507, 507)
                        .addComponent(tituloCredito)))
                .addContainerGap(430, Short.MAX_VALUE))
        );
        cardCreditoLayout.setVerticalGroup(
            cardCreditoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCreditoLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(tituloCredito)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(quadradoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            int parcelasConvertidas = converterParcelasParaInt(comboParcelas.getSelectedItem().toString());
            pagamentoView.setQtdParcelas(parcelasConvertidas);

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
    private javax.swing.JPanel cardCredito;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JComboBox<String> comboParcelas;
    private javax.swing.JPanel quadradoCredito;
    private javax.swing.JLabel textoNumCartao;
    private javax.swing.JLabel textoParcelas;
    private javax.swing.JLabel tituloCredito;
    // End of variables declaration//GEN-END:variables
}
