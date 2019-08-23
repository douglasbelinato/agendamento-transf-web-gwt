package br.com.cvc.agendamento.client;

import com.google.gwt.i18n.client.LocalizableResource.Generate;

@Generate(format = "com.google.gwt.i18n.server.PropertyCatalogFactory")
public interface Messages extends com.google.gwt.i18n.client.Messages {

    // ################################################################
    // # Commons
    // ################################################################
    String msgSimboloMoedaReal();

    // ################################################################
    // # Home Page
    // ################################################################
    String msgTituloPaginaHomePage();

    // ################################################################
    // # Funcionalidade - Listar agendamentos
    // ################################################################
    String msgTituloPaginaListarAgendamentos();


    // ################################################################
    // # Funcionalidade - Cadastrar agendamentos
    // ################################################################
    String msgTituloPaginaCadastrarAgendamentos();

    // ################################################################
    // # CSS
    // ################################################################
    String cssTituloConteudoId();
    String cssMenuEsquerdoLinkCadastrarId();
    String cssMenuEsquerdoLinkListarId();

    // ################################################################
    // # HTML
    // ################################################################
    String htmlH1();
    String htmlAHrefSemLink();

}
