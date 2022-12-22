package br.com.banco.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import br.com.banco.entities.Conta;
import br.com.banco.entities.Transferencia;

public class ContaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String nome_responsavel;

	private List<TransferenciaDTO> transferencias = new ArrayList<>();

	public ContaDTO() {

	}
	public ContaDTO(Conta entity, Set<Transferencia> transferencias) {
		this(entity);
		transferencias.forEach(tran -> this.transferencias.add(new TransferenciaDTO(tran)));

	}


	public List<TransferenciaDTO> getTransferencias() {
		return transferencias;
	}
	public void setTransferencias(List<TransferenciaDTO> transferencias) {
		this.transferencias = transferencias;
	}
	public ContaDTO(long id, String nome_responsavel) {
		this.id = id;
		this.nome_responsavel = nome_responsavel;

	}

	public ContaDTO(Conta entity) {

		this.id = entity.getId();
		this.nome_responsavel = entity.getNome_responsavel();

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome_responsavel() {
		return nome_responsavel;
	}

	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel = nome_responsavel;
	}



}
