package br.com.banco.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = ("tb_conta"))
public class Conta implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nome_responsavel;

	@ManyToMany
	@JoinTable(name = "tb_movimentos_conta", joinColumns = @JoinColumn(name = "conta_id"), inverseJoinColumns = @JoinColumn(name = "transferencia_id"))

	Set<Transferencia> transferencias = new HashSet<>();

	public Conta() {

	}

	public Conta(long id, String nome_responsavel) {
		this.id = id;
		this.nome_responsavel = nome_responsavel;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nome_responsavel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Conta other = (Conta) obj;
		return id == other.id && Objects.equals(nome_responsavel, other.nome_responsavel);
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

	public Set<Transferencia> getTransferencias() {
		return transferencias;
	}

	public void SetTransferencias(Set<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}

}
