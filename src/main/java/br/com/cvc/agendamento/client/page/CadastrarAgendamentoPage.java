package br.com.cvc.agendamento.client.page;

import br.com.cvc.agendamento.client.AgendamentosService;
import br.com.cvc.agendamento.client.AgendamentosServiceAsync;
import br.com.cvc.agendamento.client.page.handler.NumberFieldKeyPressHandler;
import br.com.cvc.agendamento.dto.AgendamentoDTO;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DateBox;

/**
 * Página Cadastrar Agendamentos
 */
public class CadastrarAgendamentoPage {

    private static final String MOEDA = "R$ ";

    /**
     * Carrega dados ao abrir a página.
     */
    public void carregarPagina() {
        onLoadPage();
    }

    /**
     * Callback GWT.
     *
     * @return
     */
    public static AgendamentosServiceAsync getAgendamentosService() {
        return GWT.create(AgendamentosService.class);
    }

    public AsyncCallback<Void> getCallbackCadastrarAgendamento() {
        return new AsyncCallback() {

            @Override
            public void onFailure(Throwable throwable) {
                Window.alert("Erro ao cadastrar");
            }

            @Override
            public void onSuccess(Object s) {
                Window.alert("Cadastro realizado com sucesso");
            }
        };
    }

    private void onLoadPage() {
        // Conta Origem
        HTMLPanel contaOrigemLabel = new HTMLPanel("label", "Conta Origem");
        contaOrigemLabel.addStyleName("control-label");

        IntegerBox contaOrigemInput = new IntegerBox();
        contaOrigemInput.setStyleName("form-control  js-numero-conta");
        contaOrigemInput.getElement().setAttribute("autocomplete", "off");
        contaOrigemInput.getElement().setAttribute("maxlength", "6");
        contaOrigemInput.getElement().setAttribute("placeholder", "000000");
        contaOrigemInput.addKeyPressHandler(new NumberFieldKeyPressHandler());

        FlowPanel divContaOrigem = new FlowPanel();
        divContaOrigem.add(contaOrigemLabel);
        divContaOrigem.add(contaOrigemInput);
        divContaOrigem.addStyleName("col-sm-2  form-group  bw-required");

        FlowPanel divLinhaContaOrigem = new FlowPanel();
        divLinhaContaOrigem.addStyleName("row");
        divLinhaContaOrigem.add(divContaOrigem);

        // Conta Destino
        HTMLPanel contaDestinoLabel = new HTMLPanel("label", "Conta Destino");
        contaDestinoLabel.addStyleName("control-label");

        IntegerBox contaDestinoInput = new IntegerBox();
        contaDestinoInput.setStyleName("form-control  js-numero-conta");
        contaDestinoInput.getElement().setAttribute("autocomplete", "off");
        contaDestinoInput.getElement().setAttribute("maxlength", "6");
        contaDestinoInput.getElement().setAttribute("placeholder", "000000");
        contaDestinoInput.addKeyPressHandler(new NumberFieldKeyPressHandler());

        FlowPanel divContaDestino = new FlowPanel();
        divContaDestino.add(contaDestinoLabel);
        divContaDestino.add(contaDestinoInput);
        divContaDestino.addStyleName("col-sm-2  form-group  bw-required");

        FlowPanel divLinhaContaDestino = new FlowPanel();
        divLinhaContaDestino.addStyleName("row");
        divLinhaContaDestino.add(divContaDestino);

        // Valor
        HTMLPanel valorLabel = new HTMLPanel("label", "Valor");
        valorLabel.addStyleName("control-label");

        TextBox valorInput = new TextBox();
        valorInput.setStyleName("form-control  js-decimal");
        valorInput.getElement().setAttribute("autocomplete", "off");
        valorInput.addKeyPressHandler(new NumberFieldKeyPressHandler());
        valorInput.getElement().setAttribute("placeholder", "00.000,00");

        FlowPanel divSimboloMoeda = new FlowPanel();
        divSimboloMoeda.addStyleName("input-group-addon");
        divSimboloMoeda.getElement().setInnerText(MOEDA);

        FlowPanel divAgrupamentoMoeda = new FlowPanel();
        divAgrupamentoMoeda.addStyleName("input-group");
        divAgrupamentoMoeda.add(divSimboloMoeda);
        divAgrupamentoMoeda.add(valorInput);

        FlowPanel divValor = new FlowPanel();
        divValor.add(valorLabel);
        divValor.add(divAgrupamentoMoeda);
        divValor.addStyleName("col-sm-2  form-group  bw-required");

        FlowPanel divLinhaValor = new FlowPanel();
        divLinhaValor.addStyleName("row");
        divLinhaValor.add(divValor);

        // Data da transferência
        HTMLPanel dataTransferenciaLabel = new HTMLPanel("label", "Data da transferência");
        dataTransferenciaLabel.addStyleName("control-label");
        dataTransferenciaLabel.getElement().setAttribute("placeholder", "DD/MM/YYYY");

        DateTimeFormat dateFormat = DateTimeFormat.getFormat("dd/MM/yyyy");
        DateBox dateBox = new DateBox();
        dateBox.setFormat(new DateBox.DefaultFormat(dateFormat));
        dateBox.setStyleName("control-label");
        dateBox.getElement().setAttribute("placeholder", "DD/MM/YYYY");

        TextBox dataTransferenciaInput = new TextBox();
        dataTransferenciaInput.setStyleName("form-control");
        dataTransferenciaInput.getElement().setAttribute("autocomplete", "off");

        FlowPanel divDataTransferencia = new FlowPanel();
        divDataTransferencia.add(dataTransferenciaLabel);
        divDataTransferencia.add(dateBox);
        //divDataTransferencia.add(dataTransferenciaInput);
        divDataTransferencia.addStyleName("col-sm-2  form-group  bw-required");

        FlowPanel divLinhaDataTransferencia = new FlowPanel();
        divLinhaDataTransferencia.addStyleName("row");
        divLinhaDataTransferencia.add(divDataTransferencia);

        // Botao
        HTMLPanel botaoSalvar = new HTMLPanel("button", "Salvar");
        botaoSalvar.addStyleName("btn  btn-primary");
        botaoSalvar.getElement().setAttribute("type", "submit");

        Button botao = new Button("Salvar");
        botao.addStyleName("btn  btn-primary");
        botao.removeStyleName("gwt-Button");

        FlowPanel divLinhaBotaoSalvar = new FlowPanel();
        divLinhaBotaoSalvar.addStyleName("form-group");
        divLinhaBotaoSalvar.add(botao);

        RootPanel.get("container-fluid-id").add(divLinhaContaOrigem);
        RootPanel.get("container-fluid-id").add(divLinhaContaDestino);
        RootPanel.get("container-fluid-id").add(divLinhaValor);
        RootPanel.get("container-fluid-id").add(divLinhaDataTransferencia);
        RootPanel.get("container-fluid-id").add(divLinhaBotaoSalvar);

        botao.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (contaOrigemInput.getText() != null && !contaOrigemInput.getText().isEmpty() &&
                        contaDestinoInput.getText() != null && !contaDestinoInput.getText().isEmpty() &&
                        valorInput.getText() != null && !valorInput.getText().isEmpty() &&
                        dateBox.getValue() != null) {
                    AgendamentoDTO dto = new AgendamentoDTO();
                    dto.setContaOrigem(Integer.valueOf(contaOrigemInput.getText()));
                    dto.setContaDestino(Integer.valueOf(contaDestinoInput.getText()));
                    dto.setValor(Double.valueOf(valorInput.getText()));
                    dto.setDataTransferencia(dateBox.getTextBox().getText());

                    getAgendamentosService().incluirAgendamento(dto, getCallbackCadastrarAgendamento());
                    limparDadosCadastroAgendamentosPage(contaOrigemInput, contaDestinoInput, valorInput, dateBox);
                } else {
                    Window.alert("Dados inválidos. Preencha todos os campos corretamente.");
                }

            }
        });

        ScriptInjector.fromUrl("static/javascripts/brewer.js").inject();
    }

    /**
     * Limpa os campos na tela de cadastro.
     *
     * @param contaOrigemInput
     * @param contaDestinoInput
     * @param valorInput
     * @param dateBox
     */
    private void limparDadosCadastroAgendamentosPage(IntegerBox contaOrigemInput, IntegerBox contaDestinoInput, TextBox valorInput, DateBox dateBox) {
        contaOrigemInput.setText("");
        contaDestinoInput.setText("");
        valorInput.setText("");
        dateBox.setValue(null);
    }

}
