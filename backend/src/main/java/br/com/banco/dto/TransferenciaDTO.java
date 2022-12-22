package br.com.banco.dto;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.banco.entities.Transferencia;

public class TransferenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String tipo;
	private double valor;
	private String nome_operador_transacao;
	private LocalDate data_transferencia;

	public TransferenciaDTO() {
	}

	public TransferenciaDTO(long id, String tipo, double valor, String nome_operador_transacao,
			LocalDate data_transferencia) {
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.nome_operador_transacao = nome_operador_transacao;
		this.data_transferencia = data_transferencia;
	}

	public TransferenciaDTO(Transferencia entity) {
		this.id = entity.getId();
		this.tipo = entity.getTipo();
		this.valor = entity.getValor();
		this.nome_operador_transacao = entity.getNome_operador_transacao();
		this.data_transferencia = entity.getData_transferencia();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getNome_operador_transacao() {
		return nome_operador_transacao;
	}

	public void setNome_operador_transacao(String nome_operador_transacao) {
		this.nome_operador_transacao = nome_operador_transacao;
	}

	public LocalDate getData_transferencia() {
		return data_transferencia;
	}

	public void setData_transferencia(LocalDate data_transferencia) {
		this.data_transferencia = data_transferencia;
	}

}
