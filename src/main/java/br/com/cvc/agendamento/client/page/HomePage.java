package br.com.cvc.agendamento.client.page;

import br.com.cvc.agendamento.client.Messages;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.RootPanel;

/***
 * Página inicial
 */
public class HomePage {

    private final Messages messages = GWT.create(Messages.class);

    /**
     * Carrega dados ao abrir a página.
     */
    public void carregarPagina() {
        RootPanel.get(messages.cssTituloConteudoId()).clear();
        HTMLPanel htmlPanelTituloPagina = new HTMLPanel(messages.htmlH1(), messages.msgTituloPaginaHomePage());
        RootPanel.get(messages.cssTituloConteudoId()).add(htmlPanelTituloPagina);
    }
}
