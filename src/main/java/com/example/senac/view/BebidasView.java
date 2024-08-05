package com.example.senac.view;

import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import com.example.senac.model.CyberSnack;

public class BebidasView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CyberSnacksView cyberSnacksView;
    
    private ArrayList<CyberSnack> bebidasCyberSnacks;
    private ArrayList<Integer> qtdBebidas;
    public ArrayList<CyberSnack> bebidasSelecionadas;
    public ArrayList<Integer>qtdsSelecionadas;
    
    public BebidasView(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.bebidasCyberSnacks = new ArrayList<>();
        this.qtdBebidas = new ArrayList<>();
        this.bebidasSelecionadas = new ArrayList<>();
        this.qtdsSelecionadas = new ArrayList<>();
        initComponents();
    }
    
    public void setCyberSnacksView(CyberSnacksView cyberSnacksView) {
        this.cyberSnacksView = cyberSnacksView;
    }

    public void addBebidaCyberSnack(CyberSnack bebidaCyberSnack) {
        bebidasCyberSnacks.add(bebidaCyberSnack);
    }

    private void obterQuantidades() {
        qtdBebidas.clear();

        qtdBebidas.add(Integer.parseInt((String) comboBebidasEspresso.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasCafePreto.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasCafeComLeite.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasCappuccinoBaunilha.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasCappuccinoCaramelo.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasMoccha.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasCafeGeladoCremoso.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasCafeGeladoFrutasVermelhas.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasSmoothieRefrescante.getSelectedItem()));
        qtdBebidas.add(Integer.parseInt((String) comboBebidasLimonadaFresca.getSelectedItem()));
    }

    public void definirBebidasSelecionadas() {
        bebidasSelecionadas.clear();
        qtdsSelecionadas.clear();
    
        for (int i = 0; i < bebidasCyberSnacks.size(); i++) {
            if (qtdBebidas.get(i) != 0) {
                bebidasSelecionadas.add(bebidasCyberSnacks.get(i));
                qtdsSelecionadas.add(qtdBebidas.get(i));
            }
        }
    }

    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardBebidas = new javax.swing.JPanel();
        tituloBebidas = new javax.swing.JLabel();
        quadradoBebidas = new javax.swing.JPanel();
        comboBebidasEspresso = new javax.swing.JComboBox<>();
        comboBebidasCafePreto = new javax.swing.JComboBox<>();
        comboBebidasCafeComLeite = new javax.swing.JComboBox<>();
        comboBebidasCappuccinoBaunilha = new javax.swing.JComboBox<>();
        comboBebidasCappuccinoCaramelo = new javax.swing.JComboBox<>();
        comboBebidasLimonadaFresca = new javax.swing.JComboBox<>();
        comboBebidasMoccha = new javax.swing.JComboBox<>();
        comboBebidasCafeGeladoCremoso = new javax.swing.JComboBox<>();
        comboBebidasSmoothieRefrescante = new javax.swing.JComboBox<>();
        comboBebidasCafeGeladoFrutasVermelhas = new javax.swing.JComboBox<>();
        textoBebidasEspresso = new javax.swing.JLabel();
        precoBebidasEspresso = new javax.swing.JLabel();
        textoBebidasCafePreto = new javax.swing.JLabel();
        textoBebidasCafeComLeite = new javax.swing.JLabel();
        textoBebidasCappuccinoBaunilha = new javax.swing.JLabel();
        textoBebidasMoccha = new javax.swing.JLabel();
        textoBebidasCappuccinoCaramelo = new javax.swing.JLabel();
        textoBebidasCafeGeladoCremoso = new javax.swing.JLabel();
        textoBebidasCafeGeladoFrutasVermelhas = new javax.swing.JLabel();
        textoBebidasSmoothieRefrescante = new javax.swing.JLabel();
        textoBebidasLimonadaFresca = new javax.swing.JLabel();
        precoBebidasCafePreto = new javax.swing.JLabel();
        precoBebidasCafeComLeite = new javax.swing.JLabel();
        precoBebidasCappuccinoBaunilha = new javax.swing.JLabel();
        precoBebidasCappuccinoCaramelo = new javax.swing.JLabel();
        precoBebidasMoccha = new javax.swing.JLabel();
        precoBebidasCafeGeladoCremoso = new javax.swing.JLabel();
        precoBebidasCafeGeladoFrutasVermelhas = new javax.swing.JLabel();
        precoBebidasSmoothieRefrescante = new javax.swing.JLabel();
        precoBebidasLimonadaFresca = new javax.swing.JLabel();
        botaoBebidasVoltar = new javax.swing.JButton();
        botaoBebidasFinalizarCompra = new javax.swing.JButton();
        botaoBebidasAdicionarAoCarrinho = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardBebidas.setBackground(new java.awt.Color(36, 45, 65));

        tituloBebidas.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloBebidas.setForeground(new java.awt.Color(27, 137, 75));
        tituloBebidas.setText("Bebidas");

        quadradoBebidas.setBackground(new java.awt.Color(50, 60, 83));

        comboBebidasEspresso.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasEspresso.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasEspresso.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasEspresso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasCafePreto.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasCafePreto.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasCafePreto.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasCafePreto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasCafeComLeite.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasCafeComLeite.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasCafeComLeite.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasCafeComLeite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasCappuccinoBaunilha.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasCappuccinoBaunilha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasCappuccinoBaunilha.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasCappuccinoBaunilha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasCappuccinoCaramelo.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasCappuccinoCaramelo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasCappuccinoCaramelo.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasCappuccinoCaramelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasLimonadaFresca.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasLimonadaFresca.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasLimonadaFresca.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasLimonadaFresca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasMoccha.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasMoccha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasMoccha.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasMoccha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasCafeGeladoCremoso.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasCafeGeladoCremoso.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasCafeGeladoCremoso.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasCafeGeladoCremoso.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasSmoothieRefrescante.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasSmoothieRefrescante.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasSmoothieRefrescante.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasSmoothieRefrescante.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboBebidasCafeGeladoFrutasVermelhas.setBackground(new java.awt.Color(217, 217, 217));
        comboBebidasCafeGeladoFrutasVermelhas.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboBebidasCafeGeladoFrutasVermelhas.setForeground(new java.awt.Color(75, 75, 75));
        comboBebidasCafeGeladoFrutasVermelhas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        textoBebidasEspresso.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasEspresso.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasEspresso.setText("Espresso");

        precoBebidasEspresso.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasEspresso.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasEspresso.setText("R$ 6.00");

        textoBebidasCafePreto.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasCafePreto.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasCafePreto.setText("Café Preto");

        textoBebidasCafeComLeite.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasCafeComLeite.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasCafeComLeite.setText("Café com Leite");

        textoBebidasCappuccinoBaunilha.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasCappuccinoBaunilha.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasCappuccinoBaunilha.setText("Cappuccino Cremoso de Baunilha");

        textoBebidasMoccha.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasMoccha.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasMoccha.setText("Mocha de Chocolate Quente");

        textoBebidasCappuccinoCaramelo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasCappuccinoCaramelo.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasCappuccinoCaramelo.setText("Cappuccino de Canela e Caramelo");

        textoBebidasCafeGeladoCremoso.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasCafeGeladoCremoso.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasCafeGeladoCremoso.setText("Café Gelado Cremoso");

        textoBebidasCafeGeladoFrutasVermelhas.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasCafeGeladoFrutasVermelhas.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasCafeGeladoFrutasVermelhas.setText("Chá Gelado de Frutas Vermelhas");

        textoBebidasSmoothieRefrescante.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasSmoothieRefrescante.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasSmoothieRefrescante.setText("Smoothie Refrescante");

        textoBebidasLimonadaFresca.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoBebidasLimonadaFresca.setForeground(new java.awt.Color(195, 195, 195));
        textoBebidasLimonadaFresca.setText("Limonada Fresca");

        precoBebidasCafePreto.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasCafePreto.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasCafePreto.setText("R$ 8.00");

        precoBebidasCafeComLeite.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasCafeComLeite.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasCafeComLeite.setText("R$ 10.00");

        precoBebidasCappuccinoBaunilha.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasCappuccinoBaunilha.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasCappuccinoBaunilha.setText("R$ 10.00");

        precoBebidasCappuccinoCaramelo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasCappuccinoCaramelo.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasCappuccinoCaramelo.setText("R$ 11.00");

        precoBebidasMoccha.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasMoccha.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasMoccha.setText("R$ 21.00");

        precoBebidasCafeGeladoCremoso.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasCafeGeladoCremoso.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasCafeGeladoCremoso.setText("R$ 21.00");

        precoBebidasCafeGeladoFrutasVermelhas.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasCafeGeladoFrutasVermelhas.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasCafeGeladoFrutasVermelhas.setText("R$ 21.00");

        precoBebidasSmoothieRefrescante.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasSmoothieRefrescante.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasSmoothieRefrescante.setText("R$ 12.00");

        precoBebidasLimonadaFresca.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoBebidasLimonadaFresca.setForeground(new java.awt.Color(27, 137, 75));
        precoBebidasLimonadaFresca.setText("R$ 15.00");

        javax.swing.GroupLayout quadradoBebidasLayout = new javax.swing.GroupLayout(quadradoBebidas);
        quadradoBebidas.setLayout(quadradoBebidasLayout);
        quadradoBebidasLayout.setHorizontalGroup(
            quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoBebidasLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboBebidasLimonadaFresca, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasSmoothieRefrescante, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasCafeGeladoFrutasVermelhas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasCafeGeladoCremoso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasMoccha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasCappuccinoCaramelo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasCappuccinoBaunilha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasCafeComLeite, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasCafePreto, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBebidasEspresso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasEspresso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasEspresso))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasCafePreto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasCafePreto))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasCafeComLeite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasCafeComLeite))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasCappuccinoBaunilha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasCappuccinoBaunilha))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasMoccha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasMoccha))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasCappuccinoCaramelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasCappuccinoCaramelo))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasCafeGeladoCremoso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasCafeGeladoCremoso))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasCafeGeladoFrutasVermelhas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasCafeGeladoFrutasVermelhas))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasSmoothieRefrescante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasSmoothieRefrescante))
                    .addGroup(quadradoBebidasLayout.createSequentialGroup()
                        .addComponent(textoBebidasLimonadaFresca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoBebidasLimonadaFresca)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        quadradoBebidasLayout.setVerticalGroup(
            quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoBebidasLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasEspresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasEspresso)
                    .addComponent(precoBebidasEspresso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasCafePreto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasCafePreto)
                    .addComponent(precoBebidasCafePreto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasCafeComLeite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasCafeComLeite)
                    .addComponent(precoBebidasCafeComLeite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasCappuccinoBaunilha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasCappuccinoBaunilha)
                    .addComponent(precoBebidasCappuccinoBaunilha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasCappuccinoCaramelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasCappuccinoCaramelo)
                    .addComponent(precoBebidasCappuccinoCaramelo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasMoccha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasMoccha)
                    .addComponent(precoBebidasMoccha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasCafeGeladoCremoso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasCafeGeladoCremoso)
                    .addComponent(precoBebidasCafeGeladoCremoso))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasCafeGeladoFrutasVermelhas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasCafeGeladoFrutasVermelhas)
                    .addComponent(precoBebidasCafeGeladoFrutasVermelhas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasSmoothieRefrescante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasSmoothieRefrescante)
                    .addComponent(precoBebidasSmoothieRefrescante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboBebidasLimonadaFresca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoBebidasLimonadaFresca)
                    .addComponent(precoBebidasLimonadaFresca))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        botaoBebidasVoltar.setBorderPainted(false);
        botaoBebidasVoltar.setFocusPainted(false);
        botaoBebidasVoltar.setBackground(new java.awt.Color(94, 34, 122));
        botaoBebidasVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoBebidasVoltar.setForeground(new java.awt.Color(174, 174, 174));
        botaoBebidasVoltar.setText("Voltar");
        botaoBebidasVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBebidasVoltarActionPerformed(evt);
            }
        });

        botaoBebidasFinalizarCompra.setBorderPainted(false);
        botaoBebidasFinalizarCompra.setFocusPainted(false);
        botaoBebidasFinalizarCompra.setBackground(new java.awt.Color(17, 137, 56));
        botaoBebidasFinalizarCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoBebidasFinalizarCompra.setForeground(new java.awt.Color(174, 174, 174));
        botaoBebidasFinalizarCompra.setText("Finalizar compra");
        botaoBebidasFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBebidasFinalizarCompraActionPerformed(evt);
            }
        });

        botaoBebidasAdicionarAoCarrinho.setBorderPainted(false);
        botaoBebidasAdicionarAoCarrinho.setFocusPainted(false);
        botaoBebidasAdicionarAoCarrinho.setBackground(new java.awt.Color(94, 34, 122));
        botaoBebidasAdicionarAoCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoBebidasAdicionarAoCarrinho.setForeground(new java.awt.Color(174, 174, 174));
        botaoBebidasAdicionarAoCarrinho.setText("Adicionar ao carrinho");
        botaoBebidasAdicionarAoCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBebidasAdicionarAoCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardBebidasLayout = new javax.swing.GroupLayout(cardBebidas);
        cardBebidas.setLayout(cardBebidasLayout);
        cardBebidasLayout.setHorizontalGroup(
            cardBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardBebidasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloBebidas)
                .addGap(510, 510, 510))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardBebidasLayout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addGroup(cardBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quadradoBebidas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(cardBebidasLayout.createSequentialGroup()
                        .addComponent(botaoBebidasVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botaoBebidasFinalizarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoBebidasAdicionarAoCarrinho)))
                .addGap(432, 432, 432))
        );
        cardBebidasLayout.setVerticalGroup(
            cardBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardBebidasLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tituloBebidas)
                .addGap(18, 18, 18)
                .addComponent(quadradoBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cardBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoBebidasFinalizarCompra)
                    .addComponent(botaoBebidasAdicionarAoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoBebidasVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botaoBebidasFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBebidasFinalizarCompraActionPerformed
        if (comboBebidasCafeComLeite.getSelectedItem()!="0" || comboBebidasCafeGeladoCremoso.getSelectedItem()!="0" || comboBebidasCafeGeladoFrutasVermelhas.getSelectedItem()!="0" || comboBebidasCafePreto.getSelectedItem()!="0" || comboBebidasCappuccinoBaunilha.getSelectedItem()!="0" || comboBebidasCappuccinoCaramelo.getSelectedItem()!="0" || comboBebidasEspresso.getSelectedItem()!="0" || comboBebidasLimonadaFresca.getSelectedItem()!="0" || comboBebidasMoccha.getSelectedItem()!="0" || comboBebidasSmoothieRefrescante.getSelectedItem()!="0") {
            obterQuantidades();
            definirBebidasSelecionadas();
            cyberSnacksView.atualizarDadosCyberSnacks();
            cardLayout.show(mainPanel, "confirmacaoPedido");
        } else {
            JOptionPane.showMessageDialog(BebidasView.this, 
            "Insira uma opção ou volte.", 
            "Erro", 
            JOptionPane.ERROR_MESSAGE);   
        }
        
    }//GEN-LAST:event_botaoBebidasFinalizarCompraActionPerformed

    private void botaoBebidasVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBebidasVoltarActionPerformed
        cardLayout.show(mainPanel, "cyberSnacks");
    }//GEN-LAST:event_botaoBebidasVoltarActionPerformed

    private void botaoBebidasAdicionarAoCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {
        // Verifica se alguma combobox foi selecionada com quantidade diferente de "0"
        if (!"0".equals(comboBebidasCafeComLeite.getSelectedItem()) ||
            !"0".equals(comboBebidasCafeGeladoCremoso.getSelectedItem()) ||
            !"0".equals(comboBebidasCafeGeladoFrutasVermelhas.getSelectedItem()) ||
            !"0".equals(comboBebidasCafePreto.getSelectedItem()) ||
            !"0".equals(comboBebidasCappuccinoBaunilha.getSelectedItem()) ||
            !"0".equals(comboBebidasCappuccinoCaramelo.getSelectedItem()) ||
            !"0".equals(comboBebidasEspresso.getSelectedItem()) ||
            !"0".equals(comboBebidasLimonadaFresca.getSelectedItem()) ||
            !"0".equals(comboBebidasMoccha.getSelectedItem()) ||
            !"0".equals(comboBebidasSmoothieRefrescante.getSelectedItem())) {

            obterQuantidades();
            definirBebidasSelecionadas();
            cyberSnacksView.atualizarDadosCyberSnacks();
            cardLayout.show(mainPanel, "cyberSnacks");
        } else {
            JOptionPane.showMessageDialog(BebidasView.this,
                    "Selecione pelo menos uma bebida.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoBebidasAdicionarAoCarrinho;
    private javax.swing.JButton botaoBebidasFinalizarCompra;
    private javax.swing.JButton botaoBebidasVoltar;
    private javax.swing.JPanel cardBebidas;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JComboBox<String> comboBebidasCafeComLeite;
    private javax.swing.JComboBox<String> comboBebidasCafeGeladoCremoso;
    private javax.swing.JComboBox<String> comboBebidasCafeGeladoFrutasVermelhas;
    private javax.swing.JComboBox<String> comboBebidasCafePreto;
    private javax.swing.JComboBox<String> comboBebidasCappuccinoBaunilha;
    private javax.swing.JComboBox<String> comboBebidasCappuccinoCaramelo;
    private javax.swing.JComboBox<String> comboBebidasEspresso;
    private javax.swing.JComboBox<String> comboBebidasLimonadaFresca;
    private javax.swing.JComboBox<String> comboBebidasMoccha;
    private javax.swing.JComboBox<String> comboBebidasSmoothieRefrescante;
    private javax.swing.JLabel precoBebidasCafeComLeite;
    private javax.swing.JLabel precoBebidasCafeGeladoCremoso;
    private javax.swing.JLabel precoBebidasCafeGeladoFrutasVermelhas;
    private javax.swing.JLabel precoBebidasCafePreto;
    private javax.swing.JLabel precoBebidasCappuccinoBaunilha;
    private javax.swing.JLabel precoBebidasCappuccinoCaramelo;
    private javax.swing.JLabel precoBebidasEspresso;
    private javax.swing.JLabel precoBebidasLimonadaFresca;
    private javax.swing.JLabel precoBebidasMoccha;
    private javax.swing.JLabel precoBebidasSmoothieRefrescante;
    private javax.swing.JPanel quadradoBebidas;
    private javax.swing.JLabel textoBebidasCafeComLeite;
    private javax.swing.JLabel textoBebidasCafeGeladoCremoso;
    private javax.swing.JLabel textoBebidasCafeGeladoFrutasVermelhas;
    private javax.swing.JLabel textoBebidasCafePreto;
    private javax.swing.JLabel textoBebidasCappuccinoBaunilha;
    private javax.swing.JLabel textoBebidasCappuccinoCaramelo;
    private javax.swing.JLabel textoBebidasEspresso;
    private javax.swing.JLabel textoBebidasLimonadaFresca;
    private javax.swing.JLabel textoBebidasMoccha;
    private javax.swing.JLabel textoBebidasSmoothieRefrescante;
    private javax.swing.JLabel tituloBebidas;
    // End of variables declaration//GEN-END:variables
}
