package com.example.senac.view;

import java.awt.CardLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

import com.example.senac.controller.CyberSnackController;
import com.example.senac.controller.PedidoController;
import com.example.senac.controller.PedidoCyberSnackController;
import com.example.senac.controller.UsuarioController;
import com.example.senac.model.CyberSnack;
import com.example.senac.model.Pedido;
import com.example.senac.model.Pedido.TipoPagamento;
import com.example.senac.model.PedidoCyberSnack;
import com.example.senac.model.Usuario;

public class PagamentoView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private TipoPagamento tipoPagamento;
    public int qtdParcelas;

    private CyberStationView cyberStationView;
    private ConfirmacaoPedidoView confirmacaoPedidoView;
    private CyberSnacksView cyberSnacksView;

    private UsuarioController usuarioController;
    private PedidoController pedidoController;
    private CyberSnackController cyberSnackController;
    private PedidoCyberSnackController pedidoCyberSnackController;

    public PagamentoView(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        initComponents();
    }

    public void setCyberStationView(CyberStationView cyberStationView) {
        this.cyberStationView = cyberStationView;
    }

    public void setConfirmacaoPedidoView(ConfirmacaoPedidoView confirmacaoPedidoView) {
        this.confirmacaoPedidoView = confirmacaoPedidoView;
    }

    public void setCyberSnacksView(CyberSnacksView cyberSnacksView) {
        this.cyberSnacksView = cyberSnacksView;
    }

    public void setUsuarioController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    public void setPedidoController(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    public void setCyberSnackController(CyberSnackController cyberSnackController) {
        this.cyberSnackController = cyberSnackController;
    }

    public void setPedidoCyberSnackController(PedidoCyberSnackController pedidoCyberSnackController) {
        this.pedidoCyberSnackController = pedidoCyberSnackController;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setQtdParcelas(int qtdParcelas) {
        this.qtdParcelas = qtdParcelas;
    }

    public int getQtdParcelas() {
        return qtdParcelas;
    }

    public void cadastrarDadosDoPedido() {    
        try {
            // Obtém os dados necessários
            float precoTotal = (float) confirmacaoPedidoView.getPrecoTotal();
            ArrayList<CyberSnack> cyberSnacks = cyberSnacksView.getCyberSnacksSelecionados();
            ArrayList<Integer> quantidades = cyberSnacksView.getQuantidadesSelecionadas();
    
            // Pega o usuário existente
            Usuario usuario = usuarioController.getObjetoUsuario();
            List<PedidoCyberSnack> itensPedido = new ArrayList<>();
    
            // Cria o pedido e cadastra no banco de dados
            Pedido pedido = pedidoController.criarObjetoPedido(usuario, LocalDate.now(), precoTotal, tipoPagamento, qtdParcelas, itensPedido);
            pedidoController.cadastrarPedido(pedido);
    
            // Se tiverem cyberSnacks selecionados, eles são cadastrados no banco de dados com as suas quantidades
            if (cyberSnacks != null && quantidades != null) {
                for (int i = 0; i < cyberSnacks.size(); i++) {
                    CyberSnack cybersnack = cyberSnacks.get(i); // Pega o CyberSnack do loop
                    Integer quantidade = quantidades.get(i); // Pega a quantidade que está relacionada
    
                    Long cyberSnackId = cybersnack.getId();
                    CyberSnack cyberSnackPersistence = cyberSnackController.obterCyberSnack(cyberSnackId);
                    // Pega o CyberSnack do banco de dados para que a persistência funcione
    
                    // Cria o pedido_cybersnack e cadastra no banco de dados
                    PedidoCyberSnack pedidoCyberSnack = pedidoCyberSnackController.criarObjetoPedidoCyberSnack(pedido, cyberSnackPersistence, quantidade, precoTotal);
                    pedidoCyberSnackController.criarPedidoCyberSnack(pedidoCyberSnack);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void atualizarPreco(String preco) {
        areaValorTotal.setText("R$ "+ preco);   
    }

    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardPagamento = new javax.swing.JPanel();
        tituloPagamento = new javax.swing.JLabel();
        quadradoPagamento = new javax.swing.JPanel();
        textoValorTotal = new javax.swing.JLabel();
        barraValorTotal = new javax.swing.JScrollPane();
        areaValorTotal = new javax.swing.JTextArea();
        botaoVoltar = new javax.swing.JButton();
        botaoCancelarPedido = new javax.swing.JButton();
        botaoFinalizarPagamento = new javax.swing.JButton();
        botaoCredito = new javax.swing.JButton();
        botaoDebito = new javax.swing.JButton();
        botaoPix = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardPagamento.setBackground(new java.awt.Color(36, 45, 65));
        cardPagamento.setPreferredSize(new java.awt.Dimension(1366, 720));

        tituloPagamento.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloPagamento.setForeground(new java.awt.Color(27, 137, 75));
        tituloPagamento.setText("Forma de Pagamento");

        quadradoPagamento.setBackground(new java.awt.Color(50, 60, 83));

        textoValorTotal.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        textoValorTotal.setForeground(new java.awt.Color(195, 195, 195));
        textoValorTotal.setText("Valor Total");

        barraValorTotal.setBackground(new java.awt.Color(50, 60, 83));
        barraValorTotal.setForeground(new java.awt.Color(50, 60, 83));

        areaValorTotal.setBackground(new java.awt.Color(50, 60, 83));
        areaValorTotal.setColumns(20);
        areaValorTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        areaValorTotal.setForeground(new java.awt.Color(174, 174, 174));
        areaValorTotal.setRows(5);
        //areaValorTotal.setText("Aqui fica o valor total.");
        areaValorTotal.setText("");
        areaValorTotal.setBorder(null);
        barraValorTotal.setViewportView(areaValorTotal);

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

        botaoCancelarPedido.setBorderPainted(false);
        botaoCancelarPedido.setFocusPainted(false);
        botaoCancelarPedido.setBackground(new java.awt.Color(165, 21, 21));
        botaoCancelarPedido.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCancelarPedido.setForeground(new java.awt.Color(174, 174, 174));
        botaoCancelarPedido.setText("Cancelar pedido");
        botaoCancelarPedido.setToolTipText("");
        botaoCancelarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarPedidoActionPerformed(evt);
            }
        });

        botaoFinalizarPagamento.setBorderPainted(false);
        botaoFinalizarPagamento.setFocusPainted(false);
        botaoFinalizarPagamento.setBackground(new java.awt.Color(17, 137, 56));
        botaoFinalizarPagamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoFinalizarPagamento.setForeground(new java.awt.Color(174, 174, 174));
        botaoFinalizarPagamento.setText("Finalizar ");
        botaoFinalizarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarPagamentoActionPerformed(evt);
            }
        });

        botaoCredito.setBorderPainted(false);
        botaoCredito.setFocusPainted(false);
        botaoCredito.setBackground(new java.awt.Color(94, 34, 122));
        botaoCredito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoCredito.setForeground(new java.awt.Color(174, 174, 174));
        botaoCredito.setText("Crédito");
        botaoCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCreditoActionPerformed(evt);
            }
        });

        botaoDebito.setBorderPainted(false);
        botaoDebito.setFocusPainted(false);
        botaoDebito.setBackground(new java.awt.Color(94, 34, 122));
        botaoDebito.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoDebito.setForeground(new java.awt.Color(174, 174, 174));
        botaoDebito.setText("Débito");
        botaoDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDebitoActionPerformed(evt);
            }
        });

        botaoPix.setBorderPainted(false);
        botaoPix.setFocusPainted(false);
        botaoPix.setBackground(new java.awt.Color(94, 34, 122));
        botaoPix.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoPix.setForeground(new java.awt.Color(174, 174, 174));
        botaoPix.setText("PIX");
        botaoPix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoPixActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout quadradoPagamentoLayout = new javax.swing.GroupLayout(quadradoPagamento);
        quadradoPagamento.setLayout(quadradoPagamentoLayout);
        quadradoPagamentoLayout.setHorizontalGroup(
            quadradoPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoPagamentoLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(quadradoPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoPagamentoLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(quadradoPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoPix, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(quadradoPagamentoLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(textoValorTotal))
                    .addGroup(quadradoPagamentoLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(barraValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(quadradoPagamentoLayout.createSequentialGroup()
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addComponent(botaoCancelarPedido)
                        .addGap(63, 63, 63)
                        .addComponent(botaoFinalizarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        quadradoPagamentoLayout.setVerticalGroup(
            quadradoPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoPagamentoLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(botaoCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoPix, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(textoValorTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(barraValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(quadradoPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoVoltar)
                    .addComponent(botaoCancelarPedido)
                    .addComponent(botaoFinalizarPagamento))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardPagamentoLayout = new javax.swing.GroupLayout(cardPagamento);
        cardPagamento.setLayout(cardPagamentoLayout);
        cardPagamentoLayout.setHorizontalGroup(
            cardPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardPagamentoLayout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addGroup(cardPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardPagamentoLayout.createSequentialGroup()
                        .addComponent(quadradoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(386, 386, 386))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardPagamentoLayout.createSequentialGroup()
                        .addComponent(tituloPagamento)
                        .addGap(169, 169, 169))))
        );
        cardPagamentoLayout.setVerticalGroup(
            cardPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardPagamentoLayout.createSequentialGroup()
                .addComponent(tituloPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(quadradoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLayoutPrincipalLayout.createSequentialGroup()
                .addComponent(cardPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLayoutPrincipalLayout.createSequentialGroup()
                .addComponent(cardPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        cardLayout.show(mainPanel, "confirmacaoPedido");
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoFinalizarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarPagamentoActionPerformed
        tipoPagamento = TipoPagamento.CREDITO;
        cardLayout.show(mainPanel, "credito");
    }//GEN-LAST:event_botaoFinalizarPagamentoActionPerformed

    private void botaoCancelarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarPedidoActionPerformed
        JOptionPane.showMessageDialog(null, "Seu pedido foi cancelado.");
        cyberStationView.cancelarReservaCyberStation();
        System.exit(0); // Fecha o programa
    }//GEN-LAST:event_botaoCancelarPedidoActionPerformed

    private void botaoCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCreditoActionPerformed
        tipoPagamento = TipoPagamento.CREDITO;
        cardLayout.show(mainPanel, "credito");
    }//GEN-LAST:event_botaoCreditoActionPerformed

    private void botaoDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDebitoActionPerformed
        tipoPagamento = TipoPagamento.DEBITO;
        qtdParcelas = 1;
        cardLayout.show(mainPanel, "debito");
    }//GEN-LAST:event_botaoDebitoActionPerformed

    private void botaoPixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoPixActionPerformed
        tipoPagamento = TipoPagamento.PIX;
        qtdParcelas = 1;
        cardLayout.show(mainPanel, "pix");
    }//GEN-LAST:event_botaoPixActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaValorTotal;
    private javax.swing.JScrollPane barraValorTotal;
    private javax.swing.JButton botaoCancelarPedido;
    private javax.swing.JButton botaoCredito;
    private javax.swing.JButton botaoDebito;
    private javax.swing.JButton botaoFinalizarPagamento;
    private javax.swing.JButton botaoPix;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JPanel cardPagamento;
    private javax.swing.JPanel quadradoPagamento;
    private javax.swing.JLabel textoValorTotal;
    private javax.swing.JLabel tituloPagamento;
    // End of variables declaration//GEN-END:variables
}
