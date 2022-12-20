package br.com.banco.dto;

import java.io.Serializable;
import br.com.banco.entities.Conta;

public class ContaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String nome_responsavel;

	public ContaDTO() {

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
