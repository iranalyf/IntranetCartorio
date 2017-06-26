package br.com.cartorio.models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Logradouro deve ser informado")
	private String logradouro;

	@NotEmpty(message = "Número deve ser Informado")
	private String numero;

	private String complemento;

	@NotEmpty(message = "Bairro deve ser Informado")
	private String bairro;

	@NotNull(message = "Estado deve ser Selecionado")
	@Enumerated(EnumType.STRING)
	private Estado estado;

	@NotEmpty(message = "Cidade deve ser Informado")
	private String cidade;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
