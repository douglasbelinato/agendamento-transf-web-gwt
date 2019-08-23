package br.com.cvc.agendamento.client.page;

import br.com.cvc.agendamento.client.AgendamentosService;
import br.com.cvc.agendamento.client.AgendamentosServiceAsync;
import br.com.cvc.agendamento.client.Messages;
import br.com.cvc.agendamento.dto.ConsultaAgendamentosDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;

import java.math.BigDecimal;

/**
 * Página Listar Agendamentos
 */
public class ListarAgendamentosPage {

    private final Messages messages = GWT.create(Messages.class);
    private ConsultaAgendamentosDTO dto;

    /**
     * Carrega dados ao abrir a página.
     */
    public void carregarPagina() {
        getAgendamentosService().listarAgendamentos(getCallbackListarAgendamentos());
    }

    /**
     * Callback GWT.
     *
     * @return
     */
    public AsyncCallback<ConsultaAgendamentosDTO> getCallbackListarAgendamentos() {
        return new AsyncCallback<ConsultaAgendamentosDTO>() {

            @Override
            public void onFailure(Throwable throwable) {
                Window.alert(throwable.getMessage());
            }

            @Override
            public void onSuccess(ConsultaAgendamentosDTO consultaAgendamentosDTO) {
                dto = consultaAgendamentosDTO;

                FlexTable flexTable = new FlexTable();
                flexTable.setStyleName("table  table-hover");


                if (dto != null && dto.getAgendamentos() != null && !dto.getAgendamentos().isEmpty()) {
                    flexTable.setHTML(0, 0, "Conta Origem");
                    flexTable.getFlexCellFormatter().setStyleName(0, 0, "table-agendamentos-col-estilo");

                    flexTable.setHTML(0, 1, "Conta Destino");
                    flexTable.getFlexCellFormatter().setStyleName(0, 1, "table-agendamentos-col-estilo");

                    flexTable.setHTML(0, 2, "Valor");
                    flexTable.getFlexCellFormatter().setStyleName(0, 2, "table-agendamentos-col-estilo");

                    flexTable.setHTML(0, 3, "Data da transferência");
                    flexTable.getFlexCellFormatter().setStyleName(0, 3, "table-agendamentos-col-estilo");

                    flexTable.setHTML(0, 4, "Data do agendamento");
                    flexTable.getFlexCellFormatter().setStyleName(0, 4, "table-agendamentos-col-estilo");

                    flexTable.setHTML(0, 5, "Taxa");
                    flexTable.getFlexCellFormatter().setStyleName(0, 5, "table-agendamentos-col-estilo");


                    if (dto != null && dto.getAgendamentos() != null) {

                        for (int i = 0; i < dto.getAgendamentos().size(); i++) {
                            flexTable.setHTML(i + 1, 0, dto.getAgendamentos().get(i).getContaOrigem().toString());
                            flexTable.getFlexCellFormatter().setStyleName(i, 0, "table-agendamentos-col-estilo");

                            flexTable.setHTML(i + 1, 1, dto.getAgendamentos().get(i).getContaDestino().toString());
                            flexTable.getFlexCellFormatter().setStyleName(i, 1, "table-agendamentos-col-estilo");

                            BigDecimal valor = new BigDecimal(dto.getAgendamentos().get(i).getValor());
                            valor = valor.setScale(2, BigDecimal.ROUND_UP);
                            flexTable.setHTML(i + 1, 2, messages.msgSimboloMoedaReal() + valor.toString());
                            flexTable.getFlexCellFormatter().setStyleName(i, 2, "table-agendamentos-col-estilo");

                            flexTable.setHTML(i + 1, 3, messages.msgSimboloMoedaReal() + dto.getAgendamentos().get(i).getDataTransferencia().toString());
                            flexTable.getFlexCellFormatter().setStyleName(i, 3, "table-agendamentos-col-estilo");

                            flexTable.setHTML(i + 1, 4, messages.msgSimboloMoedaReal() + dto.getAgendamentos().get(i).getDataAgendamento().toString());
                            flexTable.getFlexCellFormatter().setStyleName(i, 4, "table-agendamentos-col-estilo");

                            BigDecimal taxa = new BigDecimal(dto.getAgendamentos().get(i).getTaxa());
                            taxa = taxa.setScale(2, BigDecimal.ROUND_UP);
                            flexTable.setHTML(i + 1, 5, messages.msgSimboloMoedaReal() + taxa.toString());
                            flexTable.getFlexCellFormatter().setStyleName(i, 5, "table-agendamentos-col-estilo");
                        }
                    }
                } else {
                    flexTable.setHTML(0, 0, "Não há agendamentos para consulta");
                    flexTable.getFlexCellFormatter().setStyleName(0, 0, "table-agendamentos-col-estilo");
                }


                RootPanel.get("gwt-div-table").add(flexTable);
            }
        };
    }

    /**
     * Geração do serviço Async através do proxy GWT.
     *
     * @return
     */
    private static AgendamentosServiceAsync getAgendamentosService() {
        return GWT.create(AgendamentosService.class);
    }

}
