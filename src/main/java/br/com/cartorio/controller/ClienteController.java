package br.com.cartorio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cartorio.models.Cliente;
import br.com.cartorio.models.Endereco;
import br.com.cartorio.models.Estado;
import br.com.cartorio.models.Sexo;
import br.com.cartorio.repository.ClienteDAO;
import br.com.cartorio.utils.UtilMensagens;

@ManagedBean
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private ClienteDAO clienteDAO;
	private UtilMensagens messages;
	private List<Cliente> clientes;
	private Cliente clienteSelecionado;

	public ClienteController() {
		instances();
	}

	public void instances() {
		this.cliente = new Cliente();
		this.clienteDAO = new ClienteDAO();
		this.messages = new UtilMensagens();
		this.cliente.setEndereco(new Endereco());
	}

	public void salvar() {
		this.clienteDAO.saveOrUpdate(cliente);
		this.messages.info(String.format("Cliente %s Cadastrado com Sucesso", cliente.getNomeCompleto()));
	}

	public void excluir() {
		this.clienteDAO.delete(clienteSelecionado);
		this.messages.info(String.format("Cliente %s excluído com Sucesso", clienteSelecionado.getNomeCompleto()));
	}

	public void inicializaClientes() {
		this.clientes = this.clienteDAO.findAll();
	}

	public Sexo[] getSexos() {
		return Sexo.values();
	}

	public Estado[] getEstados() {
		return Estado.values();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

}
