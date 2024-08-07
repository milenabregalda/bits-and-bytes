package com.example.senac.view;

import java.awt.CardLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import com.example.senac.model.ReservaCyberStation;
import com.example.senac.model.ReservaCyberStation.Status;
import com.example.senac.model.Usuario;
import com.example.senac.controller.UsuarioController;
import com.example.senac.controller.ReservaCyberStationController;

public class CyberStationView extends javax.swing.JPanel {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private boolean[] seMesasCyberStationOcupadas = new boolean[15];
    private JButton[] botoesDasMesas = new JButton[15];
    private JButton botaoSelecionado = null;
    private boolean primeiraVez = true;
    private Long reservaId;

    private UsuarioController usuarioController;
    private ReservaCyberStationController reservaCyberStationController;
    private ConfirmacaoPedidoView confirmacaoPedidoView;

    int horasReservadas;

    public CyberStationView(CardLayout cardLayout, JPanel mainPanel, UsuarioController usuarioController, ReservaCyberStationController reservaCyberStationController, ConfirmacaoPedidoView confirmacaoPedidoView) {
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.usuarioController = usuarioController;
        this.reservaCyberStationController = reservaCyberStationController;
        this.confirmacaoPedidoView = confirmacaoPedidoView;
        initComponents();
        preencherVetorDeBotoesDeMesas();
        verificarSeMesasOcupadas();
        definirCorDosBotoesDeMesas();
    }

    public void verificarSeMesasOcupadas() {
        for (int i = 0; i < seMesasCyberStationOcupadas.length; i++) {
          seMesasCyberStationOcupadas[i] = false;
        }
    }

    // Método que define a cor de acordo com se as mesas estão ocupadas ou não:
    public void definirCorDosBotoesDeMesas() {
        for (int i = 0; i < seMesasCyberStationOcupadas.length; i++) {
          if (seMesasCyberStationOcupadas[i]) {
            definirBotoesComputadores('A', botoesDasMesas[i]);
          } else {
            definirBotoesComputadores('R', botoesDasMesas[i]);
          }
        }
    }

    // Método responsável por só o botão clicado e selecionado ser verde:
    public void verificarBotaoSelecionado(JButton botao) {
        if (botaoSelecionado != null) {
            botaoSelecionado.setBackground(new Color(94, 34, 122)); // Roxo
        }
        botao.setBackground(new Color(17, 137, 56)); // Verde
        botaoSelecionado = botao;
    }
    
    // Método que define cor dos botões de computadores e se são clicáveis
    public static void definirBotoesComputadores(char definidor, JButton botaoDefinido) {
        botaoDefinido.setBorderPainted(false);
        botaoDefinido.setFocusPainted(false);

        switch (definidor) {
            case 'V':
                botaoDefinido.setBackground(new Color(17, 137, 56)); // Verde
                botaoDefinido.setEnabled(true);
                break;
            case 'A':
                botaoDefinido.setBackground(new Color(73, 84, 111)); // Azul escuro
                botaoDefinido.setEnabled(false);
                break;
            case 'R':
                botaoDefinido.setBackground(new Color(94, 34, 122)); // Roxo
                botaoDefinido.setEnabled(true);
                break;
            default:
                break;
        }
        botaoDefinido.revalidate();
    }

    public static int calcularHorasReservadas(int horaInicio, int horaTermino) {
        int horasReservadas = horaTermino - horaInicio;
        return horasReservadas;
    }

    public int getHorasReservadas() {
        return horasReservadas;
    }

    // Adiciona botões a vetor para facilitar definição do estado dos botões:
    public void preencherVetorDeBotoesDeMesas() {
        botoesDasMesas[0] = botaoCyberStationMesa1;
        botoesDasMesas[1] = botaoCyberStationMesa2;
        botoesDasMesas[2] = botaoCyberStationMesa3;
        botoesDasMesas[3] = botaoCyberStationMesa4;
        botoesDasMesas[4] = botaoCyberStationMesa5;
        botoesDasMesas[5] = botaoCyberStationMesa6;
        botoesDasMesas[6] = botaoCyberStationMesa7;
        botoesDasMesas[7] = botaoCyberStationMesa8;
        botoesDasMesas[8] = botaoCyberStationMesa9;
        botoesDasMesas[9] = botaoCyberStationMesa10;
        botoesDasMesas[10] = botaoCyberStationMesa11;
        botoesDasMesas[11] = botaoCyberStationMesa12;
        botoesDasMesas[12] = botaoCyberStationMesa13;
        botoesDasMesas[13] = botaoCyberStationMesa14;
        botoesDasMesas[14] = botaoCyberStationMesa15;
      }

      public void cancelarReservaCyberStation() {
        if (reservaId != null) {
            // Verifica se o usuário atual possui uma reserva ativa
            ReservaCyberStation reserva = reservaCyberStationController.obterReservaCyberStation(reservaId);
            if (reserva != null) {
                // Exclui a reserva
                reservaCyberStationController.excluirReservaCyberStation(reservaId);
            } else {
                JOptionPane.showMessageDialog(CyberStationView.this, "Reserva não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(CyberStationView.this, "Nenhuma reserva ativa para cancelar.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initComponents() {

        cardLayoutPrincipal = new javax.swing.JPanel();
        cardCyberStation = new javax.swing.JPanel();
        tituloCyberStation = new javax.swing.JLabel();
        sloganCyberStation = new javax.swing.JLabel();
        quadradoCyberStation = new javax.swing.JPanel();
        textoCyberStationData = new javax.swing.JLabel();
        textoCyberStationHoraInicio = new javax.swing.JLabel();
        textoCyberStationHoraTermino = new javax.swing.JLabel();
        comboCyberStationHoraInicio = new javax.swing.JComboBox<>();
        comboCyberStationMes = new javax.swing.JComboBox<>();
        comboCyberStationAno = new javax.swing.JComboBox<>();
        comboCyberStationDia = new javax.swing.JComboBox<>();
        comboCyberStationHoraTermino = new javax.swing.JComboBox<>();
        botaoCyberStationReservar = new javax.swing.JButton();
        textoCyberStationEscolherMesa = new javax.swing.JLabel();
        botaoCyberStationMesa1 = new javax.swing.JButton();
        botaoCyberStationMesa3 = new javax.swing.JButton();
        botaoCyberStationMesa5 = new javax.swing.JButton();
        botaoCyberStationMesa2 = new javax.swing.JButton();
        botaoCyberStationMesa4 = new javax.swing.JButton();
        botaoCyberStationMesa6 = new javax.swing.JButton();
        botaoCyberStationMesa7 = new javax.swing.JButton();
        botaoCyberStationMesa8 = new javax.swing.JButton();
        botaoCyberStationMesa9 = new javax.swing.JButton();
        botaoCyberStationMesa10 = new javax.swing.JButton();
        botaoCyberStationMesa11 = new javax.swing.JButton();
        botaoCyberStationMesa12 = new javax.swing.JButton();
        botaoCyberStationMesa13 = new javax.swing.JButton();
        botaoCyberStationMesa14 = new javax.swing.JButton();
        botaoCyberStationMesa15 = new javax.swing.JButton();
        botaoCyberStationDisponivel = new javax.swing.JButton();
        textoCyberStationDisponivel = new javax.swing.JLabel();
        textoCyberStationIndisponivel = new javax.swing.JLabel();
        botaoCyberStationIndisponivel = new javax.swing.JButton();
        botaoCyberStationSelecionado = new javax.swing.JButton();
        textoCyberStationIndisponivel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1366, 720));

        cardLayoutPrincipal.setBackground(new java.awt.Color(61, 72, 99));

        cardCyberStation.setBackground(new java.awt.Color(36, 45, 65));

        tituloCyberStation.setFont(new java.awt.Font("Segoe UI", 0, 100)); // NOI18N
        tituloCyberStation.setForeground(new java.awt.Color(27, 137, 75));
        tituloCyberStation.setText("Cyber Station");

        sloganCyberStation.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        sloganCyberStation.setForeground(new java.awt.Color(195, 195, 195));
        sloganCyberStation.setText("Reserve aqui o seu momento Tech.");

        quadradoCyberStation.setBackground(new java.awt.Color(50, 60, 83));

        textoCyberStationData.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoCyberStationData.setForeground(new java.awt.Color(195, 195, 195));
        textoCyberStationData.setText("Data");

        textoCyberStationHoraInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoCyberStationHoraInicio.setForeground(new java.awt.Color(195, 195, 195));
        textoCyberStationHoraInicio.setText("Horário de início");

        textoCyberStationHoraTermino.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoCyberStationHoraTermino.setForeground(new java.awt.Color(195, 195, 195));
        textoCyberStationHoraTermino.setText("Horário de término");

        comboCyberStationHoraInicio.setBackground(new java.awt.Color(73, 84, 111));
        comboCyberStationHoraInicio.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCyberStationHoraInicio.setForeground(new java.awt.Color(174, 174, 174));
        comboCyberStationHoraInicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00" }));

        comboCyberStationMes.setBackground(new java.awt.Color(73, 84, 111));
        comboCyberStationMes.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCyberStationMes.setForeground(new java.awt.Color(174, 174, 174));
        comboCyberStationMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mês", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        comboCyberStationAno.setBackground(new java.awt.Color(73, 84, 111));
        comboCyberStationAno.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCyberStationAno.setForeground(new java.awt.Color(174, 174, 174));
        comboCyberStationAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024" }));

        comboCyberStationDia.setBackground(new java.awt.Color(73, 84, 111));
        comboCyberStationDia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCyberStationDia.setForeground(new java.awt.Color(174, 174, 174));
        comboCyberStationDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        comboCyberStationHoraTermino.setBackground(new java.awt.Color(73, 84, 111));
        comboCyberStationHoraTermino.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        comboCyberStationHoraTermino.setForeground(new java.awt.Color(174, 174, 174));
        comboCyberStationHoraTermino.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00" }));

        botaoCyberStationReservar.setBorderPainted(false);
        botaoCyberStationReservar.setFocusPainted(false);
        botaoCyberStationReservar.setBackground(new java.awt.Color(0, 150, 48));
        botaoCyberStationReservar.setFont(new java.awt.Font("Segoe UI", 1, 21)); // NOI18N
        botaoCyberStationReservar.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationReservar.setText("RESERVAR");
        botaoCyberStationReservar.setToolTipText("");
        botaoCyberStationReservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationReservarActionPerformed(evt);
            }
        });

        textoCyberStationEscolherMesa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        textoCyberStationEscolherMesa.setForeground(new java.awt.Color(195, 195, 195));
        textoCyberStationEscolherMesa.setText("Escolha a sua mesa");

        botaoCyberStationMesa1.setBackground(new java.awt.Color(73, 84, 111));
        botaoCyberStationMesa1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa1.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa1.setText("1");
        botaoCyberStationMesa1.setToolTipText("");
        botaoCyberStationMesa1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(174, 174, 174)));
        definirBotoesComputadores('A', botaoCyberStationMesa1);
        botaoCyberStationMesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa1ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa3.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberStationMesa3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa3.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa3.setText("3");
        botaoCyberStationMesa3.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa3);
        botaoCyberStationMesa3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa3ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa5.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberStationMesa5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa5.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa5.setText("5");
        botaoCyberStationMesa5.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa5);
        botaoCyberStationMesa5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa5ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa2.setBackground(new java.awt.Color(73, 84, 111));
        botaoCyberStationMesa2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa2.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa2.setText("2");
        botaoCyberStationMesa2.setToolTipText("");
        definirBotoesComputadores('A', botaoCyberStationMesa2);
        botaoCyberStationMesa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa2ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa4.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberStationMesa4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa4.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa4.setText("4");
        botaoCyberStationMesa4.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa4);
        botaoCyberStationMesa4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa4ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa6.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberStationMesa6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa6.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa6.setText("6");
        botaoCyberStationMesa6.setToolTipText("");
        botaoCyberStationMesa6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(174, 174, 174)));
        definirBotoesComputadores('R', botaoCyberStationMesa6);
        botaoCyberStationMesa6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa6ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa7.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberStationMesa7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa7.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa7.setText("7");
        botaoCyberStationMesa7.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa7);
        botaoCyberStationMesa7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa7ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa8.setBackground(new java.awt.Color(17, 137, 56));
        botaoCyberStationMesa8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa8.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa8.setText("8");
        botaoCyberStationMesa8.setToolTipText("");
        definirBotoesComputadores('V', botaoCyberStationMesa8);
        botaoCyberStationMesa8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa8ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa9.setBackground(new java.awt.Color(73, 84, 111));
        botaoCyberStationMesa9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa9.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa9.setText("9");
        botaoCyberStationMesa9.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa9);
        botaoCyberStationMesa9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa9ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa10.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberStationMesa10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa10.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa10.setText("10");
        botaoCyberStationMesa10.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa10);
        botaoCyberStationMesa10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa10ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa11.setBackground(new java.awt.Color(17, 137, 56));
        botaoCyberStationMesa11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa11.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa11.setText("11");
        botaoCyberStationMesa11.setToolTipText("");
        botaoCyberStationMesa11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(174, 174, 174)));
        definirBotoesComputadores('R', botaoCyberStationMesa11);
        botaoCyberStationMesa11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa11ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa12.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberStationMesa12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa12.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa12.setText("12");
        botaoCyberStationMesa12.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa12);
        botaoCyberStationMesa12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa12ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa13.setBackground(new java.awt.Color(73, 84, 111));
        botaoCyberStationMesa13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa13.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa13.setText("13");
        botaoCyberStationMesa13.setToolTipText("");
        definirBotoesComputadores('A', botaoCyberStationMesa13);
        botaoCyberStationMesa13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa13ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa14.setBackground(new java.awt.Color(73, 84, 111));
        botaoCyberStationMesa14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa14.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa14.setText("14");
        botaoCyberStationMesa14.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa14);
        botaoCyberStationMesa14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa14ActionPerformed(evt);
            }
        });

        botaoCyberStationMesa15.setBackground(new java.awt.Color(73, 84, 111));
        botaoCyberStationMesa15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationMesa15.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationMesa15.setText("15");
        botaoCyberStationMesa15.setToolTipText("");
        definirBotoesComputadores('R', botaoCyberStationMesa15);
        botaoCyberStationMesa15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationMesa15ActionPerformed(evt);
            }
        });

        botaoCyberStationDisponivel.setBorderPainted(false);
        botaoCyberStationDisponivel.setFocusPainted(false);
        botaoCyberStationDisponivel.setEnabled(false);
        botaoCyberStationDisponivel.setBackground(new java.awt.Color(94, 34, 122));
        botaoCyberStationDisponivel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationDisponivel.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationDisponivel.setToolTipText("");
        botaoCyberStationDisponivel.setMaximumSize(new java.awt.Dimension(40, 40));
        botaoCyberStationDisponivel.setMinimumSize(new java.awt.Dimension(40, 40));
        botaoCyberStationDisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationDisponivelActionPerformed(evt);
            }
        });

        textoCyberStationDisponivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoCyberStationDisponivel.setForeground(new java.awt.Color(174, 174, 174));
        textoCyberStationDisponivel.setText("Disponível");

        textoCyberStationIndisponivel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoCyberStationIndisponivel.setForeground(new java.awt.Color(174, 174, 174));
        textoCyberStationIndisponivel.setText("Indisponível");

        botaoCyberStationIndisponivel.setBorderPainted(false);
        botaoCyberStationIndisponivel.setFocusPainted(false);
        botaoCyberStationIndisponivel.setEnabled(false);
        botaoCyberStationIndisponivel.setBackground(new java.awt.Color(73, 84, 111));
        botaoCyberStationIndisponivel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationIndisponivel.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationIndisponivel.setToolTipText("");
        botaoCyberStationIndisponivel.setMaximumSize(new java.awt.Dimension(40, 40));
        botaoCyberStationIndisponivel.setMinimumSize(new java.awt.Dimension(40, 40));
        botaoCyberStationIndisponivel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationIndisponivelActionPerformed(evt);
            }
        });

        botaoCyberStationSelecionado.setBorderPainted(false);
        botaoCyberStationSelecionado.setFocusPainted(false);
        botaoCyberStationSelecionado.setEnabled(false);
        botaoCyberStationSelecionado.setBackground(new java.awt.Color(17, 137, 56));
        botaoCyberStationSelecionado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        botaoCyberStationSelecionado.setForeground(new java.awt.Color(174, 174, 174));
        botaoCyberStationSelecionado.setToolTipText("");
        botaoCyberStationSelecionado.setMaximumSize(new java.awt.Dimension(40, 40));
        botaoCyberStationSelecionado.setMinimumSize(new java.awt.Dimension(40, 40));
        botaoCyberStationSelecionado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCyberStationSelecionadoActionPerformed(evt);
            }
        });

        textoCyberStationIndisponivel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        textoCyberStationIndisponivel1.setForeground(new java.awt.Color(174, 174, 174));
        textoCyberStationIndisponivel1.setText("Selecionado");

        javax.swing.GroupLayout quadradoCyberStationLayout = new javax.swing.GroupLayout(quadradoCyberStation);
        quadradoCyberStation.setLayout(quadradoCyberStationLayout);
        quadradoCyberStationLayout.setHorizontalGroup(
            quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(botaoCyberStationReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                        .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboCyberStationHoraTermino, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textoCyberStationHoraTermino)
                            .addComponent(textoCyberStationData)
                            .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                                .addComponent(comboCyberStationDia, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboCyberStationMes, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(comboCyberStationAno, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textoCyberStationHoraInicio)
                            .addComponent(comboCyberStationHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoCyberStationEscolherMesa)
                            .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                                .addComponent(botaoCyberStationMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botaoCyberStationMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botaoCyberStationMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(botaoCyberStationMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(botaoCyberStationMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                                .addComponent(botaoCyberStationMesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botaoCyberStationMesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(botaoCyberStationMesa8, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)
                                .addComponent(botaoCyberStationMesa9, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(botaoCyberStationMesa10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, quadradoCyberStationLayout.createSequentialGroup()
                                    .addComponent(botaoCyberStationDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textoCyberStationDisponivel)
                                    .addGap(53, 53, 53)
                                    .addComponent(botaoCyberStationIndisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textoCyberStationIndisponivel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(botaoCyberStationSelecionado, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(textoCyberStationIndisponivel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, quadradoCyberStationLayout.createSequentialGroup()
                                    .addComponent(botaoCyberStationMesa11, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(botaoCyberStationMesa12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(26, 26, 26)
                                    .addComponent(botaoCyberStationMesa13, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(28, 28, 28)
                                    .addComponent(botaoCyberStationMesa14, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(botaoCyberStationMesa15, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(85, 85, 85))
        );
        quadradoCyberStationLayout.setVerticalGroup(
            quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                        .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                                .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textoCyberStationData)
                                    .addComponent(textoCyberStationEscolherMesa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(botaoCyberStationMesa2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboCyberStationMes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboCyberStationAno, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboCyberStationDia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoCyberStationMesa5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoCyberStationMesa4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoCyberStationMesa1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoCyberStationMesa3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(26, 26, 26)
                                .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(quadradoCyberStationLayout.createSequentialGroup()
                                        .addComponent(textoCyberStationHoraInicio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(comboCyberStationHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(botaoCyberStationMesa7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(botaoCyberStationMesa10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoCyberStationMesa9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoCyberStationMesa6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(botaoCyberStationMesa8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addComponent(textoCyberStationHoraTermino))
                            .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(botaoCyberStationMesa12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(botaoCyberStationMesa15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCyberStationMesa14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCyberStationMesa11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(botaoCyberStationMesa13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(quadradoCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboCyberStationHoraTermino, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textoCyberStationDisponivel)
                                .addComponent(botaoCyberStationDisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textoCyberStationIndisponivel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botaoCyberStationSelecionado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(textoCyberStationIndisponivel)
                    .addComponent(botaoCyberStationIndisponivel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(botaoCyberStationReservar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardCyberStationLayout = new javax.swing.GroupLayout(cardCyberStation);
        cardCyberStation.setLayout(cardCyberStationLayout);
        cardCyberStationLayout.setHorizontalGroup(
            cardCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCyberStationLayout.createSequentialGroup()
                .addGroup(cardCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cardCyberStationLayout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addComponent(sloganCyberStation, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cardCyberStationLayout.createSequentialGroup()
                        .addGap(348, 348, 348)
                        .addComponent(tituloCyberStation))
                    .addGroup(cardCyberStationLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(quadradoCyberStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        cardCyberStationLayout.setVerticalGroup(
            cardCyberStationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cardCyberStationLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(tituloCyberStation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sloganCyberStation)
                .addGap(18, 18, 18)
                .addComponent(quadradoCyberStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout cardLayoutPrincipalLayout = new javax.swing.GroupLayout(cardLayoutPrincipal);
        cardLayoutPrincipal.setLayout(cardLayoutPrincipalLayout);
        cardLayoutPrincipalLayout.setHorizontalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCyberStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        cardLayoutPrincipalLayout.setVerticalGroup(
            cardLayoutPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cardCyberStation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void botaoCyberStationMesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa1ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa1);
    }//GEN-LAST:event_botaoCyberStationMesa1ActionPerformed

    private void botaoCyberStationMesa3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa3ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa3);
    }//GEN-LAST:event_botaoCyberStationMesa3ActionPerformed

    private void botaoCyberStationMesa5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa5ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa5);
    }//GEN-LAST:event_botaoCyberStationMesa5ActionPerformed

    private void botaoCyberStationMesa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa2ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa2);
    }//GEN-LAST:event_botaoCyberStationMesa2ActionPerformed

    private void botaoCyberStationMesa4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa4ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa4);
    }//GEN-LAST:event_botaoCyberStationMesa4ActionPerformed

    private void botaoCyberStationMesa6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa6ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa6);
    }//GEN-LAST:event_botaoCyberStationMesa6ActionPerformed

    private void botaoCyberStationMesa7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa7ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa7);
    }//GEN-LAST:event_botaoCyberStationMesa7ActionPerformed

    private void botaoCyberStationMesa8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa8ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa8);
    }//GEN-LAST:event_botaoCyberStationMesa8ActionPerformed

    private void botaoCyberStationMesa9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa9ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa9);
    }//GEN-LAST:event_botaoCyberStationMesa9ActionPerformed

    private void botaoCyberStationMesa10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa10ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa10);
    }//GEN-LAST:event_botaoCyberStationMesa10ActionPerformed

    private void botaoCyberStationMesa11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa11ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa11);
    }//GEN-LAST:event_botaoCyberStationMesa11ActionPerformed

    private void botaoCyberStationMesa12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa12ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa12);
    }//GEN-LAST:event_botaoCyberStationMesa12ActionPerformed

    private void botaoCyberStationMesa13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa13ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa13);
    }//GEN-LAST:event_botaoCyberStationMesa13ActionPerformed

    private void botaoCyberStationMesa14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa14ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa14);
    }//GEN-LAST:event_botaoCyberStationMesa14ActionPerformed

    private void botaoCyberStationMesa15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationMesa15ActionPerformed
        verificarBotaoSelecionado(botaoCyberStationMesa15);
    }//GEN-LAST:event_botaoCyberStationMesa15ActionPerformed

    private void botaoCyberStationDisponivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationDisponivelActionPerformed
    }//GEN-LAST:event_botaoCyberStationDisponivelActionPerformed

    private void botaoCyberStationIndisponivelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationIndisponivelActionPerformed
    }//GEN-LAST:event_botaoCyberStationIndisponivelActionPerformed

    private void botaoCyberStationSelecionadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCyberStationSelecionadoActionPerformed
    }//GEN-LAST:event_botaoCyberStationSelecionadoActionPerformed

    private void botaoCyberStationReservarActionPerformed(java.awt.event.ActionEvent evt) {
        // Verifica se todos os campos estão preenchidos
        if (comboCyberStationDia.getSelectedIndex() == 0 ||
            comboCyberStationMes.getSelectedIndex() == 0 ||
            comboCyberStationHoraInicio.getSelectedIndex() == 0 ||
            comboCyberStationHoraTermino.getSelectedIndex() == 0 || botaoSelecionado == null) {
            JOptionPane.showMessageDialog(CyberStationView.this, 
                "Preencha todos os campos para fazer a sua reserva.", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);   
        } else {
            try {
                // Obtém os dados da reserva
                int mesaSelecionada = Integer.parseInt(botaoSelecionado.getText());
                int dia = Integer.parseInt((String) comboCyberStationDia.getSelectedItem());
                int mes = Integer.parseInt((String) comboCyberStationMes.getSelectedItem());
                int ano = Integer.parseInt((String) comboCyberStationAno.getSelectedItem());
                int horaInicio = Integer.parseInt(((String) comboCyberStationHoraInicio.getSelectedItem()).split(":")[0]);
                int minutoInicio = Integer.parseInt(((String) comboCyberStationHoraInicio.getSelectedItem()).split(":")[1]);
                int horaTermino = Integer.parseInt(((String) comboCyberStationHoraTermino.getSelectedItem()).split(":")[0]);
                int minutoTermino = Integer.parseInt(((String) comboCyberStationHoraTermino.getSelectedItem()).split(":")[1]);

                horasReservadas = calcularHorasReservadas(horaInicio, horaTermino);
        
                // Verifica se o horário de término é maior que o horário de início
                LocalTime inicio = LocalTime.of(horaInicio, minutoInicio);
                LocalTime termino = LocalTime.of(horaTermino, minutoTermino);
                
                if (!termino.isAfter(inicio)) {
                    JOptionPane.showMessageDialog(CyberStationView.this, 
                        "Você selecionou um horário inválido. O horário de término deve ser maior que o horário de início.", 
                        "Erro", 
                        JOptionPane.ERROR_MESSAGE);
                    return;
                }
                
                // Pega o usuário existente
                Usuario usuario = usuarioController.getObjetoUsuario();
        
                if (primeiraVez) {
                    // Cria uma nova reserva
                    if (usuario != null) {
                        ReservaCyberStation reserva = reservaCyberStationController.criarObjetoReservaCyberStation(
                            usuario,
                            LocalDate.of(ano, mes, dia),
                            LocalTime.of(horaInicio, minutoInicio),
                            LocalTime.of(horaTermino, minutoTermino),
                            mesaSelecionada,
                            Status.DISPONIVEL
                        );
        
                        // Cadastra a reserva
                        boolean sucesso = reservaCyberStationController.cadastrarReservaCyberStation(reserva);
                        if (sucesso) {
                            reservaId = reserva.getId();
                            primeiraVez = false;
                            confirmacaoPedidoView.atualizarDadosPedido();
                            cardLayout.show(mainPanel, "cyberSnacks");
                        }
                    }
                } else {
                    // Atualiza a reserva existente
                    if (usuario != null && reservaId != null) {
                        ReservaCyberStation reservaAtualizada = reservaCyberStationController.criarObjetoReservaCyberStation(
                            usuario,
                            LocalDate.of(ano, mes, dia),
                            LocalTime.of(horaInicio, minutoInicio),
                            LocalTime.of(horaTermino, minutoTermino),
                            mesaSelecionada,
                            Status.DISPONIVEL
                        );
                        reservaAtualizada.setId(reservaId); // Define o ID da reserva a ser atualizada
                        ReservaCyberStation reserva = reservaCyberStationController.atualizarReservaCyberStation(reservaId, reservaAtualizada);
                        if (reserva != null) {
                            confirmacaoPedidoView.atualizarDadosPedido();
                            // Troca para a tela de confirmação de pedido
                            cardLayout.show(mainPanel, "cyberSnacks");
                        }
                    }
                }
            } catch (DateTimeException e) {
                JOptionPane.showMessageDialog(CyberStationView.this, 
                "Data inválida. Por favor, selecione uma data válida.", 
                "Erro", 
                JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoCyberStationReservarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCyberStationDisponivel;
    private javax.swing.JButton botaoCyberStationIndisponivel;
    private javax.swing.JButton botaoCyberStationMesa1;
    private javax.swing.JButton botaoCyberStationMesa10;
    private javax.swing.JButton botaoCyberStationMesa11;
    private javax.swing.JButton botaoCyberStationMesa12;
    private javax.swing.JButton botaoCyberStationMesa13;
    private javax.swing.JButton botaoCyberStationMesa14;
    private javax.swing.JButton botaoCyberStationMesa15;
    private javax.swing.JButton botaoCyberStationMesa2;
    private javax.swing.JButton botaoCyberStationMesa3;
    private javax.swing.JButton botaoCyberStationMesa4;
    private javax.swing.JButton botaoCyberStationMesa5;
    private javax.swing.JButton botaoCyberStationMesa6;
    private javax.swing.JButton botaoCyberStationMesa7;
    private javax.swing.JButton botaoCyberStationMesa8;
    private javax.swing.JButton botaoCyberStationMesa9;
    private javax.swing.JButton botaoCyberStationReservar;
    private javax.swing.JButton botaoCyberStationSelecionado;
    private javax.swing.JPanel cardCyberStation;
    private javax.swing.JPanel cardLayoutPrincipal;
    private javax.swing.JComboBox<String> comboCyberStationAno;
    private javax.swing.JComboBox<String> comboCyberStationDia;
    private javax.swing.JComboBox<String> comboCyberStationHoraInicio;
    private javax.swing.JComboBox<String> comboCyberStationHoraTermino;
    private javax.swing.JComboBox<String> comboCyberStationMes;
    private javax.swing.JPanel quadradoCyberStation;
    private javax.swing.JLabel sloganCyberStation;
    private javax.swing.JLabel textoCyberStationData;
    private javax.swing.JLabel textoCyberStationDisponivel;
    private javax.swing.JLabel textoCyberStationEscolherMesa;
    private javax.swing.JLabel textoCyberStationHoraInicio;
    private javax.swing.JLabel textoCyberStationHoraTermino;
    private javax.swing.JLabel textoCyberStationIndisponivel;
    private javax.swing.JLabel textoCyberStationIndisponivel1;
    private javax.swing.JLabel tituloCyberStation;
    // End of variables declaration//GEN-END:variables
}
