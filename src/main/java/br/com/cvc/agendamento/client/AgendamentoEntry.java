package br.com.cvc.agendamento.client;

import br.com.cvc.agendamento.client.page.HomePage;
import br.com.cvc.agendamento.client.page.MenuLateralEsquerdoPage;
import com.google.gwt.core.client.EntryPoint;

public class AgendamentoEntry implements EntryPoint {

    @Override
    public void onModuleLoad() {
        new HomePage().carregarPagina();
        new MenuLateralEsquerdoPage().carregarPagina();
    }
}
