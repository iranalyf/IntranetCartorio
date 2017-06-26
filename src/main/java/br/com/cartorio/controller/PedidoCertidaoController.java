package br.com.cartorio.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cartorio.models.Certidao;
import br.com.cartorio.models.Cliente;
import br.com.cartorio.models.PedidoCertidao;
import br.com.cartorio.repository.CertidaoDAO;
import br.com.cartorio.repository.ClienteDAO;
import br.com.cartorio.repository.PedidoCertidaoDAO;
import br.com.cartorio.utils.UtilMensagens;

@ManagedBean
@ViewScoped
public class PedidoCertidaoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private PedidoCertidao pedidoCertidao;
	private UtilMensagens messages;
	private PedidoCertidao pedidoCertidaoSelecionado;

	private List<PedidoCertidao> pedidosCertidoes = new ArrayList<>();
	private List<Cliente> clientes = new ArrayList<>();
	private List<Certidao> certidoes = new ArrayList<>();

	private PedidoCertidaoDAO pedidoCertidaoDAO;
	private ClienteDAO clienteDAO;
	private CertidaoDAO certidaoDAO;

	public PedidoCertidaoController() {
		instances();
	}

	private void instances() {
		this.pedidoCertidao = new PedidoCertidao();
		this.pedidoCertidaoDAO = new PedidoCertidaoDAO();
		this.messages = new UtilMensagens();
		this.clienteDAO = new ClienteDAO();
		this.certidaoDAO = new CertidaoDAO();
	}

	public void salvar() {
		this.pedidoCertidaoDAO.saveOrUpdate(pedidoCertidao);
		this.messages.info("Pedido Realizado com Sucesso");
	}

	public void excluir() {
		this.pedidoCertidaoDAO.delete(pedidoCertidaoSelecionado);
		this.messages.info(String.format("Pedido do Cliente %s, excluído com sucesso",
				pedidoCertidaoSelecionado.getCliente().getNomeCompleto()));
	}

	public void inicializaPedidos() {
		this.pedidosCertidoes = this.pedidoCertidaoDAO.findAll();
	}

	public void inicializaClientes() {
		this.clientes = this.clienteDAO.findAll();
	}

	public void inicializaCertidoes() {
		this.certidoes = this.certidaoDAO.findAll();
	}

	public PedidoCertidao getPedidoCertidao() {
		return pedidoCertidao;
	}

	public void setPedidoCertidao(PedidoCertidao pedidoCertidao) {
		this.pedidoCertidao = pedidoCertidao;
	}

	public List<PedidoCertidao> getPedidosCertidoes() {
		return pedidosCertidoes;
	}

	public void setPedidosCertidoes(List<PedidoCertidao> pedidosCertidoes) {
		this.pedidosCertidoes = pedidosCertidoes;
	}

	public PedidoCertidao getPedidoCertidaoSelecionado() {
		return pedidoCertidaoSelecionado;
	}

	public void setPedidoCertidaoSelecionado(PedidoCertidao pedidoCertidaoSelecionado) {
		this.pedidoCertidaoSelecionado = pedidoCertidaoSelecionado;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Certidao> getCertidoes() {
		return certidoes;
	}

	public void setCertidoes(List<Certidao> certidoes) {
		this.certidoes = certidoes;
	}

}
