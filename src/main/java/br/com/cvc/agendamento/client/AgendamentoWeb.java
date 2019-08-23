package br.com.cvc.agendamento.client;

import br.com.cvc.agendamento.client.page.HomePage;
import br.com.cvc.agendamento.client.page.MenuLateralEsquerdoPage;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;

public class AgendamentoWeb implements EntryPoint {

    @Override
    public void onModuleLoad() {
        new HomePage().carregarPagina();
        new MenuLateralEsquerdoPage().carregarPagina();
    }
}
