package br.com.cvc.agendamento.client.page;

import br.com.cvc.agendamento.client.page.handler.LinkCadastrarAgendamentosClickHandler;
import br.com.cvc.agendamento.client.page.handler.LinkListarAgendamentosClickHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class MenuLateralEsquerdoPage {

    public void carregarPagina() {
        linkCadastrarAgendamentos();
        linkListarAgendamentos();
    }

    private void linkListarAgendamentos() {
        HTMLPanel htmlPanelListar = new HTMLPanel("a href=\"#\"", "Listar agendamentos");
        LinkListarAgendamentosClickHandler linkListarAgendamentosClickHandler = new LinkListarAgendamentosClickHandler();

        htmlPanelListar.addDomHandler(linkListarAgendamentosClickHandler, ClickEvent.getType());
        RootPanel.get("menu-esq-link-cadastro").add(htmlPanelListar);
    }

    private void linkCadastrarAgendamentos() {
        HTMLPanel htmlPanelCadastro = new HTMLPanel("a href=\"#\"", "Cadastro de agendamentos");
        LinkCadastrarAgendamentosClickHandler linkListarAgendamentosClickHandler = new LinkCadastrarAgendamentosClickHandler();

        htmlPanelCadastro.addDomHandler(linkListarAgendamentosClickHandler, ClickEvent.getType());
        RootPanel.get("menu-esq-link-cadastro").add(htmlPanelCadastro);
    }
}
