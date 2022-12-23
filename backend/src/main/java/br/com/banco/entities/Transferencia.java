package br.com.banco.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = ("tb_transferencia"))
public class Transferencia implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private double valor;
	private String tipo;
	private String nome_operador_transacao;

	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate data_transferencia;

	public Transferencia() {
	}

	public Transferencia(long id, LocalDate data_transferencia, double valor, String tipo,
			String nome_operador_transacao) {
		this.id = id;
		this.data_transferencia = data_transferencia;
		this.valor = valor;
		this.tipo = tipo;
		this.nome_operador_transacao = nome_operador_transacao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getData_transferencia() {
		return data_transferencia;
	}

	public void setData_transferencia(LocalDate instant) {
		this.data_transferencia = instant;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome_operador_transacao() {
		return nome_operador_transacao;
	}

	public void setNome_operador_transacao(String nome_operador_transacao) {
		this.nome_operador_transacao = nome_operador_transacao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || (getClass() != obj.getClass()))
			return false;
		Transferencia other = (Transferencia) obj;
		return id == other.id;
	}

}
