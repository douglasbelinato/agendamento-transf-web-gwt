package br.com.cvc.agendamento.client.page;

import br.com.cvc.agendamento.client.Messages;
import br.com.cvc.agendamento.client.page.handler.LinkCadastrarAgendamentosClickHandler;
import br.com.cvc.agendamento.client.page.handler.LinkListarAgendamentosClickHandler;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Menu Lateral Esquerdo
 */
public class MenuLateralEsquerdoPage {

    private final Messages messages = GWT.create(Messages.class);

    /**
     * Carrega dados ao abrir o menu.
     */
    public void carregarPagina() {
        linkCadastrarAgendamentos();
        linkListarAgendamentos();
    }

    /**
     * Monta o link para listar agendamentos.
     */
    private void linkListarAgendamentos() {
        HTMLPanel htmlPanelListar = new HTMLPanel(messages.htmlAHrefSemLink(), messages.msgTituloPaginaListarAgendamentos());
        LinkListarAgendamentosClickHandler linkListarAgendamentosClickHandler = new LinkListarAgendamentosClickHandler();

        htmlPanelListar.addDomHandler(linkListarAgendamentosClickHandler, ClickEvent.getType());
        RootPanel.get(messages.cssMenuEsquerdoLinkListarId()).add(htmlPanelListar);
    }

    /**
     * Monta o link para cadastrar agendamentos.
     */
    private void linkCadastrarAgendamentos() {
        HTMLPanel htmlPanelCadastro = new HTMLPanel(messages.htmlAHrefSemLink(), messages.msgTituloPaginaCadastrarAgendamentos());
        LinkCadastrarAgendamentosClickHandler linkListarAgendamentosClickHandler = new LinkCadastrarAgendamentosClickHandler();

        htmlPanelCadastro.addDomHandler(linkListarAgendamentosClickHandler, ClickEvent.getType());
        RootPanel.get(messages.cssMenuEsquerdoLinkCadastrarId()).add(htmlPanelCadastro);
    }
}
