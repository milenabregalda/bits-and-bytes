package com.example.senac.view;
import javax.swing.JPanel;

import java.awt.CardLayout;
import com.example.senac.controller.UsuarioController;
import com.example.senac.controller.ReservaCyberStationController;
import com.example.senac.controller.CyberSnackController;
import com.example.senac.controller.PedidoController;
import com.example.senac.controller.PedidoCyberSnackController;

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
    private PedidoController pedidoController;
    private PedidoCyberSnackController pedidoCyberSnackController;

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
        cyberSnackController = new CyberSnackController();
        pedidoController = new PedidoController();
        pedidoCyberSnackController = new PedidoCyberSnackController();

        // O construtor das views passa o cardLayout e o painel para que elas possam trocar o card (conteúdo da janela) mostrado nos ActionListeners:
        loginView = new LoginView(cardLayout, painel, usuarioController); // Controller passado aqui
        criarContaView = new CriarContaView(cardLayout, painel, usuarioController);
        cyberSnacksView = new CyberSnacksView(cardLayout, painel, cyberSnackController);
        salgadosView = new SalgadosView(cardLayout, painel);
        docesView = new DocesView(cardLayout, painel);
        bebidasView = new BebidasView(cardLayout, painel);
        combosSemanaisView = new CombosSemanaisView(cardLayout, painel);
        confirmacaoPedidoView = new ConfirmacaoPedidoView(cardLayout, painel, reservaCyberStationController);
        cyberStationView = new CyberStationView(cardLayout, painel, usuarioController, reservaCyberStationController, confirmacaoPedidoView);
        // Construtor de cyberStationView fica abaixo de confirmacaoPedidoView por ele ser um parâmetro
        pagamentoView = new PagamentoView(cardLayout, painel);
        creditoView = new CreditoView(cardLayout, painel);
        debitoView = new DebitoView(cardLayout, painel);
        pixView = new PixView(cardLayout, painel);
        
        // Como as referências de algumas dessas views são cruzadas, elas são adicionadas tardiamente para evitar problemas:
        loginView.setCriarContaView(criarContaView);
        criarContaView.setLoginView(loginView);
        cyberSnacksView.setCyberStationView(cyberStationView);

        confirmacaoPedidoView.setCyberStationView(cyberStationView);
        pagamentoView.setCyberStationView(cyberStationView);
        creditoView.setCyberStationView(cyberStationView);
        debitoView.setCyberStationView(cyberStationView);
        pixView.setCyberStationView(cyberStationView);

        cyberSnacksView.setSalgadosView(salgadosView);
        cyberSnacksView.setBebidasView(bebidasView);
        cyberSnacksView.setDocesView(docesView);
        cyberSnacksView.setCombosSemanaisView(combosSemanaisView);

        salgadosView.setCyberSnacksView(cyberSnacksView);
        bebidasView.setCyberSnacksView(cyberSnacksView);
        docesView.setCyberSnacksView(cyberSnacksView);
        combosSemanaisView.setCyberSnacksView(cyberSnacksView);
        confirmacaoPedidoView.setCyberSnacksView(cyberSnacksView);
        cyberSnacksView.setConfirmacaoPedidoView(confirmacaoPedidoView);
        confirmacaoPedidoView.setPagamentoView(pagamentoView);

        creditoView.setPagamentoView(pagamentoView);
        debitoView.setPagamentoView(pagamentoView);
        pixView.setPagamentoView(pagamentoView);

        pagamentoView.setConfirmacaoPedidoView(confirmacaoPedidoView);
        pagamentoView.setCyberSnacksView(cyberSnacksView);
        pagamentoView.setUsuarioController(usuarioController);
        pagamentoView.setCyberSnackController(cyberSnackController);
        pagamentoView.setPedidoController(pedidoController);
        pagamentoView.setPedidoCyberSnackController(pedidoCyberSnackController);

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

        // Esse é o método que é chamado para trocar o conteúdo da janela, também colocá-lo nos JButtons necessários
        // Se o nome do cardLayout estiver errado, ele abrirá login.
        add(painel);
        cardLayout.show(painel, "login");

        // Lógica responsável por inicializar dados de CyberSnacks no banco de dados
        cyberSnackController.inicializarDados();
        cyberSnacksView.definirVetoresCyberSnacks();
    }
}