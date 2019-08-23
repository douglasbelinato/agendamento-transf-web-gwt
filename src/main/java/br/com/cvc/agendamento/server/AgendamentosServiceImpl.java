package br.com.cvc.agendamento.server;

import br.com.cvc.agendamento.client.AgendamentosService;
import br.com.cvc.agendamento.dto.AgendamentoDTO;
import br.com.cvc.agendamento.dto.ConsultaAgendamentosDTO;
import br.com.cvc.agendamento.integration.utils.RestClientUtils;
import com.google.gson.GsonBuilder;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.apache.oltu.oauth2.client.response.OAuthResourceResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

public class AgendamentosServiceImpl extends RemoteServiceServlet implements AgendamentosService {

    @Override
    public ConsultaAgendamentosDTO listarAgendamentos() {
        RestClientUtils restClientUtils = new RestClientUtils();
        GsonBuilder gsonBuilder = new GsonBuilder();

        try {
            OAuthResourceResponse oAuthResourceResponse = restClientUtils.get("/agendamentos");

            if (oAuthResourceResponse.getResponseCode() >= 200 && oAuthResourceResponse.getResponseCode() < 300) {
                return gsonBuilder.create().fromJson(oAuthResourceResponse.getBody(), ConsultaAgendamentosDTO.class);
            } else {
                System.out.println("Erro na chamada JSON");
                return null;
            }
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        } catch (OAuthProblemException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void incluirAgendamento(AgendamentoDTO dto) {
        System.out.println(dto.toString());

        RestClientUtils restClientUtils = new RestClientUtils();
        GsonBuilder gsonBuilder = new GsonBuilder();

        OAuthResourceResponse oAuthResourceResponse = null;
        try {
            oAuthResourceResponse = restClientUtils.post("/agendamentos", gsonBuilder.create().toJson(dto));

            if (oAuthResourceResponse.getResponseCode() >= 200 && oAuthResourceResponse.getResponseCode() < 300) {
                //return gsonBuilder.create().fromJson(oAuthResourceResponse.getBody(), NovoAgendamentoDTO.class);
            } else {
                System.out.println("Erro na chamada JSON");
            }
        } catch (OAuthSystemException e) {
            e.printStackTrace();
        } catch (OAuthProblemException e) {
            e.printStackTrace();
        }
    }
}
