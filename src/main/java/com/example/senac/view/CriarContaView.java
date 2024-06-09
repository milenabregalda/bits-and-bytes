package com.example.senac.view;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.example.senac.controller.UsuarioController;
import com.example.senac.model.Usuario;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class CriarContaView extends javax.swing.JPanel {

    /**
     * Creates new form Interface
     */

    private CardLayout cardLayout;
    private JPanel mainPanel;

    private UsuarioController usuarioController;
    /*private static boolean primeiroClique = true;
    
    private static void limparNoPrimeiroClique(JTextField campo) {
        boolean primeiroClique = true;
        if (primeiroClique) {
            campo.setText(""); // Limpa o texto
                primeiroClique = false; // Define para false para que isso não aconteça novamente
        }
    }*/

    public CriarContaView(CardLayout cardLayout, JPanel mainPanel, UsuarioController usuarioController) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.usuarioController = usuarioController;
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardCriarConta = new javax.swing.JPanel();
        tituloCriarConta = new javax.swing.JLabel();
        quadradoCriarConta = new javax.swing.JPanel();
        campoCriarContaEmail = new javax.swing.JTextField();
        campoCriarContaNome = new javax.swing.JTextField();
        campoCriarContaCPF = new javax.swing.JTextField();
        campoCriarContaTelefone = new javax.swing.JTextField();
        senhaCriarConta = new javax.swing.JPasswordField();
        confirmarSenhaCriarConta = new javax.swing.JPasswordField();
        caixaCriarContaConcordaTermos = new javax.swing.JCheckBox();
        caixaCriarContaGostariaEmails = new javax.swing.JCheckBox();
        botaoCriarContaConcordaTermos = new javax.swing.JButton();
        botaoCriarContaCadastrarSe = new javax.swing.JButton();
        textoLoginJaPossuiConta = new javax.swing.JLabel();
        botaoCriarContaEntrar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardCriarConta.setBackground(new java.awt.Color(36, 45, 65));

        tituloCriarConta.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloCriarConta.setForeground(new java.awt.Color(27, 137, 75));
        tituloCriarConta.setText("Criar conta");

        quadradoCriarConta.setBackground(new java.awt.Color(50, 60, 83));

        campoCriarContaEmail.setBackground(new java.awt.Color(73, 84, 111));
        campoCriarContaEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCriarContaEmail.setForeground(new java.awt.Color(174, 174, 174));
        campoCriarContaEmail.setText("  E-mail");
        campoCriarContaEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 90, 90)));
        campoCriarContaEmail.setCaretColor(new java.awt.Color(73, 84, 111));
        campoCriarContaEmail.setSelectedTextColor(new java.awt.Color(73, 84, 111));
        campoCriarContaEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCriarContaEmailActionPerformed(evt);
            }
        });

        campoCriarContaNome.setBackground(new java.awt.Color(73, 84, 111));
        campoCriarContaNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCriarContaNome.setForeground(new java.awt.Color(174, 174, 174));
        campoCriarContaNome.setText("  Nome completo");
        campoCriarContaNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 90, 90)));
        campoCriarContaNome.setCaretColor(new java.awt.Color(73, 84, 111));
        campoCriarContaNome.setSelectedTextColor(new java.awt.Color(73, 84, 111));
        campoCriarContaNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCriarContaNomeActionPerformed(evt);
            }
        });

        campoCriarContaCPF.setBackground(new java.awt.Color(73, 84, 111));
        campoCriarContaCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCriarContaCPF.setForeground(new java.awt.Color(174, 174, 174));
        campoCriarContaCPF.setText("  CPF");
        campoCriarContaCPF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 90, 90)));
        campoCriarContaCPF.setCaretColor(new java.awt.Color(73, 84, 111));
        campoCriarContaCPF.setSelectedTextColor(new java.awt.Color(73, 84, 111));
        campoCriarContaCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCriarContaCPFActionPerformed(evt);
            }
        });

        campoCriarContaTelefone.setBackground(new java.awt.Color(73, 84, 111));
        campoCriarContaTelefone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoCriarContaTelefone.setForeground(new java.awt.Color(174, 174, 174));
        campoCriarContaTelefone.setText("  Número de telefone");
        campoCriarContaTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 90, 90)));
        campoCriarContaTelefone.setCaretColor(new java.awt.Color(73, 84, 111));
        campoCriarContaTelefone.setSelectedTextColor(new java.awt.Color(73, 84, 111));
        campoCriarContaTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoCriarContaTelefoneActionPerformed(evt);
            }
        });

        senhaCriarConta.setBackground(new java.awt.Color(73, 84, 111));
        senhaCriarConta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        senhaCriarConta.setForeground(new java.awt.Color(174, 174, 174));
        senhaCriarConta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 90, 90)));
        senhaCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaCriarContaActionPerformed(evt);
            }
        });

        confirmarSenhaCriarConta.setBackground(new java.awt.Color(73, 84, 111));
        confirmarSenhaCriarConta.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        confirmarSenhaCriarConta.setForeground(new java.awt.Color(174, 174, 174));
        confirmarSenhaCriarConta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 90, 90)));
        confirmarSenhaCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarSenhaCriarContaActionPerformed(evt);
            }
        });

        caixaCriarContaConcordaTermos.setFocusPainted(false);
        caixaCriarContaConcordaTermos.setBackground(new java.awt.Color(50, 60, 83));
        caixaCriarContaConcordaTermos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        caixaCriarContaConcordaTermos.setForeground(new java.awt.Color(189, 189, 189));
        caixaCriarContaConcordaTermos.setText(" Eu concordo com os ");
        caixaCriarContaConcordaTermos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaCriarContaConcordaTermosActionPerformed(evt);
            }
        });

        caixaCriarContaGostariaEmails.setFocusPainted(false);
        caixaCriarContaGostariaEmails.setBackground(new java.awt.Color(50, 60, 83));
        caixaCriarContaGostariaEmails.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        caixaCriarContaGostariaEmails.setForeground(new java.awt.Color(189, 189, 189));
        caixaCriarContaGostariaEmails.setText(" Eu gostaria de receber e-mails de novidades e ofertas (opcional)");
        caixaCriarContaGostariaEmails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caixaCriarContaGostariaEmailsActionPerformed(evt);
            }
        });

        botaoCriarContaConcordaTermos.setBackground(new java.awt.Color(50, 60, 83));
        botaoCriarContaConcordaTermos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        botaoCriarContaConcordaTermos.setForeground(new java.awt.Color(84, 182, 133));
        botaoCriarContaConcordaTermos.setText("Termos de uso e a Política de Privacidade");
        botaoCriarContaConcordaTermos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoCriarContaConcordaTermos.setBorderPainted(false);
        botaoCriarContaConcordaTermos.setFocusPainted(false);
        botaoCriarContaConcordaTermos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarContaConcordaTermosActionPerformed(evt);
            }
        });

        botaoCriarContaCadastrarSe.setBorderPainted(false);
        botaoCriarContaCadastrarSe.setFocusPainted(false);
        botaoCriarContaCadastrarSe.setBackground(new java.awt.Color(94, 34, 122));
        botaoCriarContaCadastrarSe.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        botaoCriarContaCadastrarSe.setForeground(new java.awt.Color(174, 174, 174));
        botaoCriarContaCadastrarSe.setText("CADASTRAR-SE");
        botaoCriarContaCadastrarSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarContaCadastrarSeActionPerformed(evt);
            }
        });

        textoLoginJaPossuiConta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textoLoginJaPossuiConta.setForeground(new java.awt.Color(195, 195, 195));
        textoLoginJaPossuiConta.setText("Já possui conta?");

        botaoCriarContaEntrar.setBackground(new java.awt.Color(50, 60, 83));
        botaoCriarContaEntrar.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        botaoCriarContaEntrar.setForeground(new java.awt.Color(84, 182, 133));
        botaoCriarContaEntrar.setText("Entrar");
        botaoCriarContaEntrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoCriarContaEntrar.setBorderPainted(false);
        botaoCriarContaEntrar.setFocusPainted(false);
        botaoCriarContaEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCriarContaEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout quadradoCriarContaLayout = new javax.swing.GroupLayout(quadradoCriarConta);
        quadradoCriarConta.setLayout(quadradoCriarContaLayout);
        quadradoCriarContaLayout.setHorizontalGroup(
            quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCriarContaLayout.createSequentialGroup()
                .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoCriarContaLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(quadradoCriarContaLayout.createSequentialGroup()
                                .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(campoCriarContaTelefone)
                                    .addComponent(campoCriarContaCPF, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(campoCriarContaNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(campoCriarContaEmail)
                                        .addComponent(senhaCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(confirmarSenhaCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(caixaCriarContaGostariaEmails)
                            .addGroup(quadradoCriarContaLayout.createSequentialGroup()
                                .addComponent(caixaCriarContaConcordaTermos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoCriarContaConcordaTermos, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(quadradoCriarContaLayout.createSequentialGroup()
                        .addGap(381, 381, 381)
                        .addComponent(botaoCriarContaCadastrarSe, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoCriarContaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(textoLoginJaPossuiConta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoCriarContaEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(334, 334, 334))
        );
        quadradoCriarContaLayout.setVerticalGroup(
            quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCriarContaLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoCriarContaNome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCriarContaEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(campoCriarContaCPF)
                    .addComponent(senhaCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCriarContaTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarSenhaCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(caixaCriarContaConcordaTermos)
                    .addComponent(botaoCriarContaConcordaTermos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(caixaCriarContaGostariaEmails)
                .addGap(18, 18, 18)
                .addComponent(botaoCriarContaCadastrarSe, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoLoginJaPossuiConta)
                    .addComponent(botaoCriarContaEntrar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardCriarContaLayout = new javax.swing.GroupLayout(cardCriarConta);
        cardCriarConta.setLayout(cardCriarContaLayout);
        cardCriarContaLayout.setHorizontalGroup(
            cardCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCriarContaLayout.createSequentialGroup()
                .addGroup(cardCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardCriarContaLayout.createSequentialGroup()
                        .addGap(430, 430, 430)
                        .addComponent(tituloCriarConta))
                    .addGroup(cardCriarContaLayout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(quadradoCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        cardCriarContaLayout.setVerticalGroup(
            cardCriarContaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCriarContaLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(tituloCriarConta)
                .addGap(18, 18, 18)
                .addComponent(quadradoCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void campoCriarContaEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCriarContaEmailActionPerformed
        //limparNoPrimeiroClique(campoCriarContaEmail);
    }//GEN-LAST:event_campoCriarContaEmailActionPerformed

    private void campoCriarContaNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCriarContaNomeActionPerformed
        //limparNoPrimeiroClique(campoCriarContaNome);
    }//GEN-LAST:event_campoCriarContaNomeActionPerformed

    private void campoCriarContaCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCriarContaCPFActionPerformed
        //limparNoPrimeiroClique(campoCriarContaCPF);
    }//GEN-LAST:event_campoCriarContaCPFActionPerformed

    private void campoCriarContaTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoCriarContaTelefoneActionPerformed
        //limparNoPrimeiroClique(campoCriarContaTelefone);
    }//GEN-LAST:event_campoCriarContaTelefoneActionPerformed

    private void senhaCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaCriarContaActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_senhaCriarContaActionPerformed

    private void confirmarSenhaCriarContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarSenhaCriarContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmarSenhaCriarContaActionPerformed

    private void caixaCriarContaGostariaEmailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaCriarContaGostariaEmailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaCriarContaGostariaEmailsActionPerformed

    private void caixaCriarContaConcordaTermosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caixaCriarContaConcordaTermosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_caixaCriarContaConcordaTermosActionPerformed

    private void botaoCriarContaConcordaTermosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarContaConcordaTermosActionPerformed
        String termosDeUsoEPoliticaDePrivacidade = "\n1. Termos de Uso\n\n" +
            "Ao utilizar nossos serviços, você concorda com os seguintes termos. Se não concordar, por favor, não utilize nossos serviços.\n\n" +
            "1.1 Uso dos Computadores\n\n" +
            "Você pode reservar computadores via CyberStation. O uso deve ser legal e ético, e a segurança de suas informações é sua responsabilidade.\n\n" +
            "1.2 Compras de Alimentos e Bebidas\n\n" +
            "Adquira salgados, doces, combos e bebidas pelo Cybersnacks. Todos os itens devem ser consumidos no local.\n\n" +
            "1.3 Conduta no Cybercafé\n\n" +
            "Mantenha um comportamento respeitoso. Danos aos equipamentos serão cobrados.\n\n" +
            "2. Política de Privacidade\n\n" +
            "Coletamos informações para melhorar nossos serviços. Não compartilhamos suas informações sem sua permissão.\n\n" +
            "3. Contato\n\n" +
            "Dúvidas? Entre em contato conosco pelo e-mail contato@bitsbytescybercafe.com.\n\n";
            
        JOptionPane.showMessageDialog(null, termosDeUsoEPoliticaDePrivacidade, "Termos de uso e Política de Privacidade", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_botaoCriarContaConcordaTermosActionPerformed

    private void botaoCriarContaCadastrarSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarContaCadastrarSeActionPerformed
        
        if (campoCriarContaNome.getText().equals("  Nome completo") ||
            campoCriarContaCPF.getText().equals("  CPF") ||
            campoCriarContaTelefone.getText().equals("  Número de telefone") ||
            campoCriarContaEmail.getText().equals("  E-mail") ||
            !caixaCriarContaConcordaTermos.isSelected()) {
                    
                JOptionPane.showMessageDialog(CriarContaView.this, 
                "Preencha todos os campos e concorde com os termos para criar a conta.", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        } else {
                //Criação do objeto usuário com dados inseridos
                String nome = campoCriarContaNome.getText();
                String cpf = campoCriarContaCPF.getText();
                String telefone = campoCriarContaTelefone.getText();
                String email = campoCriarContaEmail.getText();
                String senha = new String(senhaCriarConta.getPassword());

                // Criar um novo usuário com os dados fornecidos
                try {
                    usuarioController.criarObjetoUsuario(nome, cpf, email, senha, telefone);
                    Usuario usuario = usuarioController.getObjetoUsuario();
                    System.out.println(usuario.toString());
                    cardLayout.show(mainPanel, "cyberStation");
                } catch (Exception e) {
                    // Exibe uma mensagem de erro em um JOptionPane
                    JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado. Contate um funcionário do Bits & Bytes para mais informações.", "Erro", JOptionPane.ERROR_MESSAGE);
                    // Imprime o stack trace da exceção para depuração
                    e.printStackTrace();
                }
        } 
    }//GEN-LAST:event_botaoCriarContaCadastrarSeActionPerformed

    private void botaoCriarContaEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCriarContaEntrarActionPerformed
        cardLayout.show(mainPanel, "login");
    }//GEN-LAST:event_botaoCriarContaEntrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCriarContaCadastrarSe;
    private javax.swing.JButton botaoCriarContaConcordaTermos;
    private javax.swing.JButton botaoCriarContaEntrar;
    private javax.swing.JCheckBox caixaCriarContaConcordaTermos;
    private javax.swing.JCheckBox caixaCriarContaGostariaEmails;
    private javax.swing.JTextField campoCriarContaCPF;
    private javax.swing.JTextField campoCriarContaEmail;
    private javax.swing.JTextField campoCriarContaNome;
    private javax.swing.JTextField campoCriarContaTelefone;
    private javax.swing.JPanel cardCriarConta;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JPasswordField confirmarSenhaCriarConta;
    private javax.swing.JPanel quadradoCriarConta;
    private javax.swing.JPasswordField senhaCriarConta;
    private javax.swing.JLabel textoLoginJaPossuiConta;
    private javax.swing.JLabel tituloCriarConta;
    // End of variables declaration//GEN-END:variables
}
