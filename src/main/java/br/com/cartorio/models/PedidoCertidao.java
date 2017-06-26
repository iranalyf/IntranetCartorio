package br.com.cartorio.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Pedido_Certidao")
public class PedidoCertidao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPedidoCertidao;

	@NotNull(message = "Data deve ser Informado")
	private Date data;

	@NotNull(message = "Certidão deve ser Informado")
	@ManyToOne
	@JoinColumn(name = "certidao_id")
	private Certidao certidao;

	@NotNull(message = "Cliente deve ser Informado")
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	private String observacao;

	public Long getIdPedidoCertidao() {
		return idPedidoCertidao;
	}

	public void setIdPedidoCertidao(Long idPedidoCertidao) {
		this.idPedidoCertidao = idPedidoCertidao;
	}

	public Certidao getCertidao() {
		return certidao;
	}

	public void setCertidao(Certidao certidao) {
		this.certidao = certidao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPedidoCertidao == null) ? 0 : idPedidoCertidao.hashCode());
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
		PedidoCertidao other = (PedidoCertidao) obj;
		if (idPedidoCertidao == null) {
			if (other.idPedidoCertidao != null)
				return false;
		} else if (!idPedidoCertidao.equals(other.idPedidoCertidao))
			return false;
		return true;
	}

}
