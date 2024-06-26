package com.example.senac.view;
import javax.swing.JPanel;
import java.awt.CardLayout;
import com.example.senac.controller.UsuarioController;
import com.example.senac.controller.ReservaCyberStationController;
import com.example.senac.controller.CyberSnackController;

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
    private PagamentoView pagamentoView;
    private CreditoView creditoView;
    private DebitoView debitoView;
    private PixView pixView;

    private UsuarioController usuarioController;
    private ReservaCyberStationController reservaCyberStationController;
    private CyberSnackController cyberSnackController;

    /* Classe responsável por gerenciar todas as outras views. Uma instância dessa view é criada em App.java (main)
    E uma instância de todas as outras views são criadas aqui e gerenciadas por cardLayout. CardLayout dessa classe é
    utilizado para trocar de janela ao clicar em botões. */
    
    public AppView() {
        painel = new JPanel();
        cardLayout = new CardLayout();
        painel.setLayout(cardLayout);

        // Criação dos objetos controllers
        usuarioController = new UsuarioController();
        reservaCyberStationController = new ReservaCyberStationController();

        // O construtor das views passa o cardLayout e o painel para que elas possam trocar o card (conteúdo da janela) mostrado nos ActionListeners:
        loginView = new LoginView(cardLayout, painel, usuarioController); // Controller passado aqui
        criarContaView = new CriarContaView(cardLayout, painel, usuarioController);
        cyberStationView = new CyberStationView(cardLayout, painel, usuarioController, reservaCyberStationController);
        cyberSnacksView = new CyberSnacksView(cardLayout, painel, cyberSnackController);
        salgadosView = new SalgadosView(cardLayout, painel, cyberSnackController);
        docesView = new DocesView(cardLayout, painel, cyberSnackController);
        bebidasView = new BebidasView(cardLayout, painel, cyberSnackController);
        combosSemanaisView = new CombosSemanaisView(cardLayout, painel);
        confirmacaoPedidoView = new ConfirmacaoPedidoView(cardLayout, painel, reservaCyberStationController);
        pagamentoView = new PagamentoView(cardLayout, painel);
        creditoView = new CreditoView(cardLayout, painel);
        debitoView = new DebitoView(cardLayout, painel);
        pixView = new PixView(cardLayout, painel);

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
        painel.add(pagamentoView, "pagamento");
        painel.add(creditoView, "credito");
        painel.add(debitoView, "debito");
        painel.add(pixView, "pix");

        add(painel);
        cardLayout.show(painel, "login");
        // Esse é o método que é chamado para trocar o conteúdo da janela, também colocá-lo nos JButtons necessários
        // Se o nome do cardLayout estiver errado, ele abrirá login.
    }
}