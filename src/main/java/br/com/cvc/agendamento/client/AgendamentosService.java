package br.com.cvc.agendamento.client;

import br.com.cvc.agendamento.dto.AgendamentoDTO;
import br.com.cvc.agendamento.dto.ConsultaAgendamentosDTO;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("agendamentos")
public interface AgendamentosService extends RemoteService {

    public ConsultaAgendamentosDTO listarAgendamentos();

    public void incluirAgendamento(AgendamentoDTO dto);

}
