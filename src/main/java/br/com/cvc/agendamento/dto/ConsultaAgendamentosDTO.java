package br.com.cvc.agendamento.dto;

import br.com.cvc.agendamento.model.Agendamento;

import java.io.Serializable;
import java.util.List;

public class ConsultaAgendamentosDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<Agendamento> agendamentos;

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    @Override
    public String toString() {
        return "ConsultaAgendamentosDTO{" +
                "agendamentos=" + agendamentos +
                '}';
    }
}
