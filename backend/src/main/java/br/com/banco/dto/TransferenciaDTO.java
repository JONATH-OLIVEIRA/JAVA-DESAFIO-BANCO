package br.com.banco.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;

public class TransferenciaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String tipo;
	private double valor;
	private String nome_operador_transacao;
	private Instant data_transferencia;

	private List<ContaDTO> contas = new ArrayList<>();

	public TransferenciaDTO() {
	}

	public TransferenciaDTO(long id, String tipo, double valor, String nome_operador_transacao,
			Instant data_transferencia) {
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

	public TransferenciaDTO(Transferencia entity, Set<Conta> contas) {
		this(entity);
		contas.forEach(cont -> this.contas.add(new ContaDTO(cont)));

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

	public Instant getData_transferencia() {
		return data_transferencia;
	}

	public void setData_transferencia(Instant data_transferencia) {
		this.data_transferencia = data_transferencia;
	}

	public List<ContaDTO> getContas() {
		return contas;
	}

	public void setContas(List<ContaDTO> contas) {
		this.contas = contas;
	}

}
