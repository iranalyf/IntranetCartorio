package br.com.cartorio.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Certidao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCertidao;

	@NotEmpty(message = "Nome do Solicitante deve ser Informado")
	@Column(nullable = false)
	private String nome;
	private Date data;

	@NotNull(message = "Tipo da Certidão deve ser Informado")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_certidao", nullable = false)
	private TipoCertidao tipoCertidao;

	public Long getIdCertidao() {
		return idCertidao;
	}

	public void setIdCertidao(Long idCertidao) {
		this.idCertidao = idCertidao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoCertidao getTipoCertidao() {
		return tipoCertidao;
	}

	public void setTipoCertidao(TipoCertidao tipoCertidao) {
		this.tipoCertidao = tipoCertidao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCertidao == null) ? 0 : idCertidao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Certidao other = (Certidao) obj;
		if (idCertidao == null) {
			if (other.idCertidao != null)
				return false;
		} else if (!idCertidao.equals(other.idCertidao))
			return false;
		return true;
	}

}
