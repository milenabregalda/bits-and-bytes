package com.example.senac.view;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class AppView extends JPanel {
    private JPanel painel;
    private CardLayout cardLayout;
    private LoginView loginView;
    private CriarContaView criarContaView;
    private CyberStationView cyberStationView;
    private CyberSnacksView cyberSnacksView;
    private SalgadosView salgadosView;
    private DocesView docesView;
    private BebidasView bebidasView;
    private CombosSemanaisView combosSemanaisView;
    private ConfirmacaoPedidoView confirmacaoPedidoView;

    /* Classe responsável por gerenciar todas as outras views. Uma instância dessa view é criada em App.java (main)
    E uma instância de todas as outras views são criadas aqui e gerenciadas por cardLayout. CardLayout dessa classe é
    utilizado para trocar de janela ao clicar em botões. */
    
    public AppView() {
        painel = new JPanel();
        cardLayout = new CardLayout();
        painel.setLayout(cardLayout);

        // O construtor das views passa o cardLayout e o painel para que elas possam trocar o card (conteúdo da janela) mostrado nos ActionListeners:
        loginView = new LoginView(cardLayout, painel);
        criarContaView = new CriarContaView(cardLayout, painel);
        cyberStationView = new CyberStationView(cardLayout, painel);
        cyberSnacksView = new CyberSnacksView(cardLayout, painel);
        salgadosView = new SalgadosView(cardLayout, painel);
        docesView = new DocesView(cardLayout, painel);
        bebidasView = new BebidasView(cardLayout, painel);
        combosSemanaisView = new CombosSemanaisView(cardLayout, painel);
        confirmacaoPedidoView = new ConfirmacaoPedidoView(cardLayout, painel);

        // Painéis são adicionados ao cardLayout com um nome (String)
        painel.add(loginView, "login");
        painel.add(criarContaView, "criarConta");
        painel.add(cyberStationView, "cyberStation");
        painel.add(cyberSnacksView, "cyberSnacks");
        painel.add(salgadosView, "salgados");
        painel.add(docesView, "doces");
        painel.add(bebidasView, "bebidas");
        painel.add(combosSemanaisView, "combosSemanais");
        painel.add(confirmacaoPedidoView, "confirmacaoPedido");

        add(painel);
        cardLayout.show(painel, "criarConta");
        // ATENÇÃO: Trocar o nome "login" pela janela em que você está mexendo para mostrá-la direto na execução enquanto desenvolve,
        // mas a versão o final começa com login
        // Esse é o método que é chamado para trocar o conteúdo da janela, também colocá-lo nos JButtons necessários
    }
}
