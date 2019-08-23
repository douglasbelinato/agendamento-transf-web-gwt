package br.com.cvc.agendamento.client.page;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;

public class HomePage {

    public void carregarPagina() {
        RootPanel.get("titulo-conteudo-id").clear();
        HTMLPanel htmlPanelTituloPagina = new HTMLPanel("h1", "Bem vindo!");
        RootPanel.get("titulo-conteudo-id").add(htmlPanelTituloPagina);
    }
}
