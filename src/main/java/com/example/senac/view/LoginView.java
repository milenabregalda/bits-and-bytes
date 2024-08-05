package com.example.senac.view;


import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.example.senac.controller.UsuarioController;
import com.example.senac.model.Usuario;
import javax.swing.JOptionPane;

public class LoginView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private UsuarioController usuarioController;
    private CriarContaView criarContaView;

    boolean primeiraVez = true;

    public LoginView(CardLayout cardLayout, JPanel mainPanel, UsuarioController usuarioController) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.usuarioController = usuarioController;
        initComponents();
    }

    public void setCriarContaView(CriarContaView criarContaView) {
        // Ao invés de adicionar no controller, adiciona tardiamente para limpeza de campos na outra view
        this.criarContaView = criarContaView;
    }

    public void reiniciarCamposDeTextoLogin() {
        campoLoginCPFEmail.setText("  CPF ou e-mail");
        campoLoginSenha.setText("");
    }

    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardLogin = new javax.swing.JPanel();
        tituloLoginBitsBytes = new javax.swing.JLabel();
        sloganLoginBitsBytes = new javax.swing.JLabel();
        quadradoLogin = new javax.swing.JPanel();
        textoLoginUsuario = new javax.swing.JLabel();
        campoLoginCPFEmail = new javax.swing.JTextField();
        textoLoginSenha = new javax.swing.JLabel();
        campoLoginSenha = new javax.swing.JPasswordField();
        textoLoginAindaNaoConta = new javax.swing.JLabel();
        botaoLoginCriarConta = new javax.swing.JButton();
        botaoLoginEntrar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardLogin.setBackground(new java.awt.Color(36, 45, 65));

        tituloLoginBitsBytes.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloLoginBitsBytes.setForeground(new java.awt.Color(27, 137, 75));
        tituloLoginBitsBytes.setText("Bits & Bytes");

        sloganLoginBitsBytes.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        sloganLoginBitsBytes.setForeground(new java.awt.Color(195, 195, 195));
        sloganLoginBitsBytes.setText("Bytes de sabor, Bits de Diversão ");

        quadradoLogin.setBackground(new java.awt.Color(50, 60, 83));

        textoLoginUsuario.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        textoLoginUsuario.setForeground(new java.awt.Color(195, 195, 195));
        textoLoginUsuario.setText("Usuário");

        campoLoginCPFEmail.setBackground(new java.awt.Color(73, 84, 111));
        campoLoginCPFEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoLoginCPFEmail.setForeground(new java.awt.Color(174, 174, 174));
        campoLoginCPFEmail.addFocusListener(new FocusAdapter() {

            @Override
            public void focusGained(FocusEvent e) {
                if (primeiraVez) {
                    campoLoginCPFEmail.setText("  CPF ou e-mail");
                    primeiraVez = false;
                } else {
                    if (campoLoginCPFEmail.getText().equals("  CPF ou e-mail")) {
                        campoLoginCPFEmail.setText("");
                    }
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (campoLoginCPFEmail.getText().isEmpty()) {
                    campoLoginCPFEmail.setText("  CPF ou e-mail");
                }
            }
        });
        
        campoLoginCPFEmail.setText("  CPF ou e-mail");
        campoLoginCPFEmail.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_TAB) {
                    campoLoginSenha.requestFocus();
                    e.consume();  // Evitar que o tab padrão ocorra
                }
            }
        });
        campoLoginCPFEmail.setToolTipText("CPF ou e-mail"); // Quando o usuário passa o mouse sobre o campo, aparece isso aqui
        campoLoginCPFEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 90, 90)));
        campoLoginCPFEmail.setCaretColor(new java.awt.Color(73, 84, 111));
        campoLoginCPFEmail.setSelectedTextColor(new java.awt.Color(73, 84, 111));
        campoLoginCPFEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLoginCPFEmailActionPerformed(evt);
            }
        });

        textoLoginSenha.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        textoLoginSenha.setForeground(new java.awt.Color(195, 195, 195));
        textoLoginSenha.setText("Senha");

        campoLoginSenha.setBackground(new java.awt.Color(73, 84, 111));
        campoLoginSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        campoLoginSenha.setToolTipText("Digite sua senha"); // Quando o usuário passa o mouse sobre o campo, aparece isso aqui
        campoLoginSenha.setForeground(new java.awt.Color(174, 174, 174));
        campoLoginSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(90, 90, 90)));
        campoLoginSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoLoginSenhaActionPerformed(evt);
            }
        });

        textoLoginAindaNaoConta.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        textoLoginAindaNaoConta.setForeground(new java.awt.Color(195, 195, 195));
        textoLoginAindaNaoConta.setText("Ainda não tem uma conta?");

        botaoLoginCriarConta.setBackground(new java.awt.Color(50, 60, 83));
        botaoLoginCriarConta.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        botaoLoginCriarConta.setForeground(new java.awt.Color(84, 182, 133));
        botaoLoginCriarConta.setText("Criar conta");
        botaoLoginCriarConta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botaoLoginCriarConta.setBorderPainted(false);
        botaoLoginCriarConta.setFocusPainted(false);
        botaoLoginCriarConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginCriarContaActionPerformed(evt);
            }
        });

        botaoLoginEntrar.setBorderPainted(false);
        botaoLoginEntrar.setFocusPainted(false);
        botaoLoginEntrar.setBackground(new java.awt.Color(94, 34, 122));
        botaoLoginEntrar.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        botaoLoginEntrar.setForeground(new java.awt.Color(174, 174, 174));
        botaoLoginEntrar.setText("ENTRAR");
        botaoLoginEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoLoginEntrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout quadradoLoginLayout = new javax.swing.GroupLayout(quadradoLogin);
        quadradoLogin.setLayout(quadradoLoginLayout);
        quadradoLoginLayout.setHorizontalGroup(
            quadradoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoLoginLayout.createSequentialGroup()
                .addGroup(quadradoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoLoginLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(botaoLoginEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(quadradoLoginLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(textoLoginAindaNaoConta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botaoLoginCriarConta, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, quadradoLoginLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(quadradoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textoLoginSenha, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoLoginCPFEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(textoLoginUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoLoginSenha))
                .addGap(32, 32, 32))
        );
        quadradoLoginLayout.setVerticalGroup(
            quadradoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoLoginLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(textoLoginUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoLoginCPFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(textoLoginSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(campoLoginSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(botaoLoginEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(quadradoLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textoLoginAindaNaoConta)
                    .addComponent(botaoLoginCriarConta))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLoginLayout = new javax.swing.GroupLayout(cardLogin);
        cardLogin.setLayout(cardLoginLayout);
        cardLoginLayout.setHorizontalGroup(
            cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLoginLayout.createSequentialGroup()
                .addContainerGap(417, Short.MAX_VALUE)
                .addGroup(cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLoginLayout.createSequentialGroup()
                        .addComponent(tituloLoginBitsBytes)
                        .addGap(425, 425, 425))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardLoginLayout.createSequentialGroup()
                        .addGroup(cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sloganLoginBitsBytes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(quadradoLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(466, 466, 466))))
        );
        cardLoginLayout.setVerticalGroup(
            cardLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardLoginLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(tituloLoginBitsBytes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sloganLoginBitsBytes)
                .addGap(34, 34, 34)
                .addComponent(quadradoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void campoLoginCPFEmailActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void campoLoginSenhaActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void botaoLoginEntrarActionPerformed(java.awt.event.ActionEvent evt) {
        String cpfOuEmail = campoLoginCPFEmail.getText().trim();
        String senha = new String(((JPasswordField) campoLoginSenha).getPassword());

        if (cpfOuEmail.isEmpty() || senha.isEmpty()) {
            JOptionPane.showMessageDialog(LoginView.this, "Preencha todos os campos para fazer login.", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Usuario usuario = usuarioController.login(cpfOuEmail, senha);
            if (usuario != null) {
                cardLayout.show(mainPanel, "cyberStation");
            } else {
                JOptionPane.showMessageDialog(LoginView.this, "CPF, email ou senha incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void botaoLoginCriarContaActionPerformed(java.awt.event.ActionEvent evt) {
        criarContaView.reiniciarCamposDeTextoCriarConta();
        cardLayout.show(mainPanel, "criarConta");
    }

    private javax.swing.JButton botaoLoginCriarConta;
    private javax.swing.JButton botaoLoginEntrar;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JPanel cardLogin;
    public static javax.swing.JTextField campoLoginCPFEmail;
    public javax.swing.JPasswordField campoLoginSenha;
    private javax.swing.JPanel quadradoLogin;
    private javax.swing.JLabel sloganLoginBitsBytes;
    private javax.swing.JLabel textoLoginAindaNaoConta;
    private javax.swing.JLabel textoLoginSenha;
    private javax.swing.JLabel textoLoginUsuario;
    private javax.swing.JLabel tituloLoginBitsBytes;
}
