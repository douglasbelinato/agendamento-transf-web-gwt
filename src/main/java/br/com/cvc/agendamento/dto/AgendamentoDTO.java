package br.com.cvc.agendamento.dto;

import java.io.Serializable;

public class AgendamentoDTO implements Serializable {

	private static final long serialVersionUID = -8432047026593989800L;

	private Integer contaOrigem;
	
    private Integer contaDestino;

    private Double valor;

    private String dataTransferencia;

    public Integer getContaOrigem() {
        return contaOrigem;
    }

    public void setContaOrigem(Integer contaOrigem) {
        this.contaOrigem = contaOrigem;
    }

    public Integer getContaDestino() {
        return contaDestino;
    }

    public void setContaDestino(Integer contaDestino) {
        this.contaDestino = contaDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDataTransferencia() {
        return dataTransferencia;
    }

    public void setDataTransferencia(String dataTransferencia) {
        this.dataTransferencia = dataTransferencia;
    }

    @Override
    public String toString() {
        return "AgendamentoDTO{" +
                "contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                ", valor=" + valor +
                ", dataTransferencia='" + dataTransferencia + '\'' +
                '}';
    }
}
