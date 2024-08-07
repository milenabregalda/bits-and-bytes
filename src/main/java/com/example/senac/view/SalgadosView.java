package com.example.senac.view;
import java.awt.CardLayout;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.example.senac.model.CyberSnack;

public class SalgadosView extends javax.swing.JPanel {
    
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CyberSnacksView cyberSnacksView;

    private ArrayList<CyberSnack> salgadosCyberSnacks;
    private ArrayList<Integer> qtdSalgados;
    public ArrayList<CyberSnack> salgadosSelecionados;
    public ArrayList<Integer>qtdsSelecionadas;

    public SalgadosView(CardLayout cardLayout, JPanel mainPanel) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.salgadosCyberSnacks = new ArrayList<>();
        this.qtdSalgados = new ArrayList<>();
        this.salgadosSelecionados = new ArrayList<>();
        this.qtdsSelecionadas = new ArrayList<>();
        initComponents();
    }
    
    public void setCyberSnacksView(CyberSnacksView cyberSnacksView) {
        this.cyberSnacksView = cyberSnacksView;
    }

    public void addSalgadoCyberSnack(CyberSnack salgadoCyberSnack) {
        salgadosCyberSnacks.add(salgadoCyberSnack);
    }

    private void obterQuantidades() {
        qtdSalgados.clear();

        qtdSalgados.add(Integer.parseInt((String) comboSalgadosPaoQueijo.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosPastelCarne.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosPastelQueijo.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosPastelFrango.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosPastelCoracao.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosCoxinha.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosEnroladinho.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosEmpadaFrango.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosEmpadaCalabresa.getSelectedItem()));
        qtdSalgados.add(Integer.parseInt((String) comboSalgadosEmpada.getSelectedItem()));
    }

    public void definirSalgadosSelecionados() {
        salgadosSelecionados.clear();
        qtdsSelecionadas.clear();
    
        for (int i = 0; i < salgadosCyberSnacks.size(); i++) {
            if (qtdSalgados.get(i) != 0) {
                salgadosSelecionados.add(salgadosCyberSnacks.get(i));
                qtdsSelecionadas.add(qtdSalgados.get(i));
            }
        }
    }

    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardSalgados = new javax.swing.JPanel();
        tituloSalgados = new javax.swing.JLabel();
        quadradoSalgados = new javax.swing.JPanel();
        comboSalgadosPaoQueijo = new javax.swing.JComboBox<>();
        comboSalgadosPastelCarne = new javax.swing.JComboBox<>();
        comboSalgadosPastelQueijo = new javax.swing.JComboBox<>();
        comboSalgadosPastelFrango = new javax.swing.JComboBox<>();
        comboSalgadosPastelCoracao = new javax.swing.JComboBox<>();
        comboSalgadosEmpada = new javax.swing.JComboBox<>();
        comboSalgadosCoxinha = new javax.swing.JComboBox<>();
        comboSalgadosEnroladinho = new javax.swing.JComboBox<>();
        comboSalgadosEmpadaCalabresa = new javax.swing.JComboBox<>();
        comboSalgadosEmpadaFrango = new javax.swing.JComboBox<>();
        textoSalgadosPaoQueijo = new javax.swing.JLabel();
        precoSalgadosPaoQueijo = new javax.swing.JLabel();
        textoSalgadosPastelCarne = new javax.swing.JLabel();
        textoSalgadosPastelQueijo = new javax.swing.JLabel();
        textoSalgadosPastelFrango = new javax.swing.JLabel();
        textoSalgadosCoxinha = new javax.swing.JLabel();
        textoSalgadosPastelCoracao = new javax.swing.JLabel();
        textoSalgadosEnroladinho = new javax.swing.JLabel();
        textoSalgadosEmpadaFrango = new javax.swing.JLabel();
        textoSalgadosEmpadaCalabresa = new javax.swing.JLabel();
        textoSalgadosEmpada = new javax.swing.JLabel();
        precoSalgadosPastelCarne = new javax.swing.JLabel();
        precoSalgadosPastelQueijo = new javax.swing.JLabel();
        precoSalgadosPastelFrango = new javax.swing.JLabel();
        precoSalgadosPastelCoracao = new javax.swing.JLabel();
        precoSalgadosCoxinha = new javax.swing.JLabel();
        precoSalgadosEnroladinho = new javax.swing.JLabel();
        precoSalgadosEmpadaFrango = new javax.swing.JLabel();
        precoSalgadosEmpadaCalabresa = new javax.swing.JLabel();
        precoSalgadosEmpada = new javax.swing.JLabel();
        botaoSalgadosVoltar = new javax.swing.JButton();
        botaoSalgadosFinalizarCompra = new javax.swing.JButton();
        botaoSalgadosAdicionarAoCarrinho = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardSalgados.setBackground(new java.awt.Color(36, 45, 65));

        tituloSalgados.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloSalgados.setForeground(new java.awt.Color(27, 137, 75));
        tituloSalgados.setText("Salgados");

        quadradoSalgados.setBackground(new java.awt.Color(50, 60, 83));

        comboSalgadosPaoQueijo.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosPaoQueijo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosPaoQueijo.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosPaoQueijo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosPastelCarne.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosPastelCarne.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosPastelCarne.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosPastelCarne.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosPastelQueijo.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosPastelQueijo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosPastelQueijo.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosPastelQueijo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosPastelFrango.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosPastelFrango.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosPastelFrango.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosPastelFrango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosPastelCoracao.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosPastelCoracao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosPastelCoracao.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosPastelCoracao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosEmpada.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosEmpada.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosEmpada.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosEmpada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosCoxinha.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosCoxinha.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosCoxinha.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosCoxinha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosEnroladinho.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosEnroladinho.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosEnroladinho.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosEnroladinho.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosEmpadaCalabresa.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosEmpadaCalabresa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosEmpadaCalabresa.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosEmpadaCalabresa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        comboSalgadosEmpadaFrango.setBackground(new java.awt.Color(217, 217, 217));
        comboSalgadosEmpadaFrango.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboSalgadosEmpadaFrango.setForeground(new java.awt.Color(75, 75, 75));
        comboSalgadosEmpadaFrango.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        
        

        textoSalgadosPaoQueijo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosPaoQueijo.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosPaoQueijo.setText("Pão de Queijo");

        precoSalgadosPaoQueijo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosPaoQueijo.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosPaoQueijo.setText("R$ 5.00");

        textoSalgadosPastelCarne.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosPastelCarne.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosPastelCarne.setText("Pastel de Carne");

        textoSalgadosPastelQueijo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosPastelQueijo.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosPastelQueijo.setText("Pastel de Queijo");

        textoSalgadosPastelFrango.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosPastelFrango.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosPastelFrango.setText("Pastel de Frango");

        textoSalgadosCoxinha.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosCoxinha.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosCoxinha.setText("Coxinha");

        textoSalgadosPastelCoracao.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosPastelCoracao.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosPastelCoracao.setText("Pastel de Coração");

        textoSalgadosEnroladinho.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosEnroladinho.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosEnroladinho.setText("Enroladinho");

        textoSalgadosEmpadaFrango.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosEmpadaFrango.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosEmpadaFrango.setText("Empada de Frango");

        textoSalgadosEmpadaCalabresa.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosEmpadaCalabresa.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosEmpadaCalabresa.setText("Empada de Calabresa");

        textoSalgadosEmpada.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        textoSalgadosEmpada.setForeground(new java.awt.Color(195, 195, 195));
        textoSalgadosEmpada.setText("Empada");

        precoSalgadosPastelCarne.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosPastelCarne.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosPastelCarne.setText("R$ 8.00");

        precoSalgadosPastelQueijo.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosPastelQueijo.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosPastelQueijo.setText("R$ 8.00");

        precoSalgadosPastelFrango.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosPastelFrango.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosPastelFrango.setText("R$ 8.00");

        precoSalgadosPastelCoracao.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosPastelCoracao.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosPastelCoracao.setText("R$ 8.00");

        precoSalgadosCoxinha.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosCoxinha.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosCoxinha.setText("R$ 8.00");

        precoSalgadosEnroladinho.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosEnroladinho.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosEnroladinho.setText("R$ 8.00");

        precoSalgadosEmpadaFrango.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosEmpadaFrango.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosEmpadaFrango.setText("R$ 8.00");
        

        precoSalgadosEmpadaCalabresa.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosEmpadaCalabresa.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosEmpadaCalabresa.setText("R$ 8.00");

        precoSalgadosEmpada.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        precoSalgadosEmpada.setForeground(new java.awt.Color(27, 137, 75));
        precoSalgadosEmpada.setText("R$ 8.00");

        javax.swing.GroupLayout quadradoSalgadosLayout = new javax.swing.GroupLayout(quadradoSalgados);
        quadradoSalgados.setLayout(quadradoSalgadosLayout);
        quadradoSalgadosLayout.setHorizontalGroup(
            quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comboSalgadosEmpada, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosEmpadaCalabresa, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosEmpadaFrango, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosEnroladinho, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosCoxinha, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosPastelCoracao, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosPastelFrango, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosPastelQueijo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosPastelCarne, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboSalgadosPaoQueijo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosPaoQueijo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosPaoQueijo))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosPastelCarne)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosPastelCarne))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosPastelQueijo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosPastelQueijo))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosPastelFrango)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosPastelFrango))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosCoxinha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosCoxinha))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosPastelCoracao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosPastelCoracao))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosEnroladinho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosEnroladinho))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosEmpadaFrango)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosEmpadaFrango))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosEmpadaCalabresa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosEmpadaCalabresa))
                    .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                        .addComponent(textoSalgadosEmpada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(precoSalgadosEmpada)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        quadradoSalgadosLayout.setVerticalGroup(
            quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoSalgadosLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosPaoQueijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosPaoQueijo)
                    .addComponent(precoSalgadosPaoQueijo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosPastelCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosPastelCarne)
                    .addComponent(precoSalgadosPastelCarne))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosPastelQueijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosPastelQueijo)
                    .addComponent(precoSalgadosPastelQueijo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosPastelFrango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosPastelFrango)
                    .addComponent(precoSalgadosPastelFrango))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosPastelCoracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosPastelCoracao)
                    .addComponent(precoSalgadosPastelCoracao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosCoxinha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosCoxinha)
                    .addComponent(precoSalgadosCoxinha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosEnroladinho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosEnroladinho)
                    .addComponent(precoSalgadosEnroladinho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosEmpadaFrango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosEmpadaFrango)
                    .addComponent(precoSalgadosEmpadaFrango))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosEmpadaCalabresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosEmpadaCalabresa)
                    .addComponent(precoSalgadosEmpadaCalabresa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(quadradoSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSalgadosEmpada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textoSalgadosEmpada)
                    .addComponent(precoSalgadosEmpada))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        botaoSalgadosVoltar.setBorderPainted(false);
        botaoSalgadosVoltar.setFocusPainted(false);
        botaoSalgadosVoltar.setBackground(new java.awt.Color(94, 34, 122));
        botaoSalgadosVoltar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoSalgadosVoltar.setForeground(new java.awt.Color(174, 174, 174));
        botaoSalgadosVoltar.setText("Voltar");
        botaoSalgadosVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalgadosVoltarActionPerformed(evt);
            }
        });

        botaoSalgadosFinalizarCompra.setBorderPainted(false);
        botaoSalgadosFinalizarCompra.setFocusPainted(false);
        botaoSalgadosFinalizarCompra.setBackground(new java.awt.Color(17, 137, 56));
        botaoSalgadosFinalizarCompra.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoSalgadosFinalizarCompra.setForeground(new java.awt.Color(174, 174, 174));
        botaoSalgadosFinalizarCompra.setText("Finalizar compra");
        botaoSalgadosFinalizarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalgadosFinalizarCompraActionPerformed(evt);
            }
        });

        botaoSalgadosAdicionarAoCarrinho.setBorderPainted(false);
        botaoSalgadosAdicionarAoCarrinho.setFocusPainted(false);
        botaoSalgadosAdicionarAoCarrinho.setBackground(new java.awt.Color(94, 34, 122));
        botaoSalgadosAdicionarAoCarrinho.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        botaoSalgadosAdicionarAoCarrinho.setForeground(new java.awt.Color(174, 174, 174));
        botaoSalgadosAdicionarAoCarrinho.setText("Adicionar ao carrinho");
        botaoSalgadosAdicionarAoCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalgadosAdicionarAoCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cardSalgadosLayout = new javax.swing.GroupLayout(cardSalgados);
        cardSalgados.setLayout(cardSalgadosLayout);
        cardSalgadosLayout.setHorizontalGroup(
            cardSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardSalgadosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tituloSalgados)
                .addGap(483, 483, 483))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cardSalgadosLayout.createSequentialGroup()
                .addGap(438, 438, 438)
                .addGroup(cardSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(quadradoSalgados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(cardSalgadosLayout.createSequentialGroup()
                        .addComponent(botaoSalgadosVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(botaoSalgadosFinalizarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoSalgadosAdicionarAoCarrinho)))
                .addGap(432, 432, 432))
        );
        cardSalgadosLayout.setVerticalGroup(
            cardSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardSalgadosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(tituloSalgados)
                .addGap(18, 18, 18)
                .addComponent(quadradoSalgados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(cardSalgadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSalgadosFinalizarCompra)
                    .addComponent(botaoSalgadosAdicionarAoCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoSalgadosVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(95, 95, 95))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardSalgados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardSalgados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botaoSalgadosVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalgadosVoltarActionPerformed
        cardLayout.show(mainPanel, "cyberSnacks");
    }//GEN-LAST:event_botaoSalgadosVoltarActionPerformed

    private void botaoSalgadosFinalizarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalgadosFinalizarCompraActionPerformed
        if (comboSalgadosEmpadaFrango.getSelectedItem()!="0" || comboSalgadosCoxinha.getSelectedItem()!="0" || comboSalgadosEmpada.getSelectedItem()!="0" || comboSalgadosEmpadaCalabresa.getSelectedItem()!="0" || comboSalgadosEnroladinho.getSelectedItem()!="0" || comboSalgadosPaoQueijo.getSelectedItem()!="0" || comboSalgadosPastelCarne.getSelectedItem()!="0" || comboSalgadosPastelCoracao.getSelectedItem()!="0" || comboSalgadosPastelFrango.getSelectedItem()!="0" || comboSalgadosPastelQueijo.getSelectedItem()!="0"){
            obterQuantidades();
            definirSalgadosSelecionados();
            cyberSnacksView.atualizarDadosCyberSnacks();
            cardLayout.show(mainPanel, "confirmacaoPedido");
        } else {
            JOptionPane.showMessageDialog(SalgadosView.this, 
            "Insira uma opção ou volte.", 
            "Erro", 
            JOptionPane.ERROR_MESSAGE);   
        }
           
    }//GEN-LAST:event_botaoSalgadosFinalizarCompraActionPerformed

    private void botaoSalgadosAdicionarAoCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {
        // Verifica se alguma combobox foi selecionada com quantidade diferente de "0"
        if (!"0".equals(comboSalgadosEmpadaFrango.getSelectedItem()) ||
            !"0".equals(comboSalgadosCoxinha.getSelectedItem()) ||
            !"0".equals(comboSalgadosEmpada.getSelectedItem()) ||
            !"0".equals(comboSalgadosEmpadaCalabresa.getSelectedItem()) ||
            !"0".equals(comboSalgadosEnroladinho.getSelectedItem()) ||
            !"0".equals(comboSalgadosPaoQueijo.getSelectedItem()) ||
            !"0".equals(comboSalgadosPastelCarne.getSelectedItem()) ||
            !"0".equals(comboSalgadosPastelCoracao.getSelectedItem()) ||
            !"0".equals(comboSalgadosPastelFrango.getSelectedItem()) ||
            !"0".equals(comboSalgadosPastelQueijo.getSelectedItem())) {
    
            obterQuantidades();
            definirSalgadosSelecionados();
            cyberSnacksView.atualizarDadosCyberSnacks();

            // Mostra a próxima tela
            cardLayout.show(mainPanel, "cyberSnacks");
        } else {
            JOptionPane.showMessageDialog(SalgadosView.this, 
                "Selecione pelo menos um salgado.", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoSalgadosAdicionarAoCarrinho;
    private javax.swing.JButton botaoSalgadosFinalizarCompra;
    private javax.swing.JButton botaoSalgadosVoltar;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JPanel cardSalgados;
    private javax.swing.JComboBox<String> comboSalgadosCoxinha;
    private javax.swing.JComboBox<String> comboSalgadosEmpada;
    private javax.swing.JComboBox<String> comboSalgadosEmpadaCalabresa;
    private javax.swing.JComboBox<String> comboSalgadosEmpadaFrango;
    private javax.swing.JComboBox<String> comboSalgadosEnroladinho;
    private javax.swing.JComboBox<String> comboSalgadosPaoQueijo;
    private javax.swing.JComboBox<String> comboSalgadosPastelCarne;
    private javax.swing.JComboBox<String> comboSalgadosPastelCoracao;
    private javax.swing.JComboBox<String> comboSalgadosPastelFrango;
    private javax.swing.JComboBox<String> comboSalgadosPastelQueijo;
    private javax.swing.JLabel precoSalgadosCoxinha;
    private javax.swing.JLabel precoSalgadosEmpada;
    private javax.swing.JLabel precoSalgadosEmpadaCalabresa;
    private javax.swing.JLabel precoSalgadosEmpadaFrango;
    private javax.swing.JLabel precoSalgadosEnroladinho;
    private javax.swing.JLabel precoSalgadosPaoQueijo;
    private javax.swing.JLabel precoSalgadosPastelCarne;
    private javax.swing.JLabel precoSalgadosPastelCoracao;
    private javax.swing.JLabel precoSalgadosPastelFrango;
    private javax.swing.JLabel precoSalgadosPastelQueijo;
    private javax.swing.JPanel quadradoSalgados;
    private javax.swing.JLabel textoSalgadosCoxinha;
    private javax.swing.JLabel textoSalgadosEmpada;
    private javax.swing.JLabel textoSalgadosEmpadaCalabresa;
    private javax.swing.JLabel textoSalgadosEmpadaFrango;
    private javax.swing.JLabel textoSalgadosEnroladinho;
    private javax.swing.JLabel textoSalgadosPaoQueijo;
    private javax.swing.JLabel textoSalgadosPastelCarne;
    private javax.swing.JLabel textoSalgadosPastelCoracao;
    private javax.swing.JLabel textoSalgadosPastelFrango;
    private javax.swing.JLabel textoSalgadosPastelQueijo;
    private javax.swing.JLabel tituloSalgados;
    // End of variables declaration//GEN-END:variables
}
