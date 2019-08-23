package br.com.cvc.agendamento.client.page.handler;

import br.com.cvc.agendamento.client.page.CadastrarAgendamentoPage;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class LinkCadastrarAgendamentosClickHandler implements ClickHandler {

    @Override
    public void onClick(ClickEvent clickEvent) {
        HTMLPanel htmlPanelTituloPagina = new HTMLPanel("h1", "Cadastro de agendamentos de transferência");
        RootPanel.get("titulo-conteudo-id").clear();
        RootPanel.get("titulo-conteudo-id").add(htmlPanelTituloPagina);

        RootPanel.get("gwt-div-table").clear();
        RootPanel.get("container-fluid-id").clear();
        new CadastrarAgendamentoPage().carregarPagina();
    }
}
