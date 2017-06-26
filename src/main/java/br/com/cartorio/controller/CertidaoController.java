package br.com.cartorio.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.cartorio.models.Certidao;
import br.com.cartorio.models.TipoCertidao;
import br.com.cartorio.repository.CertidaoDAO;
import br.com.cartorio.utils.UtilMensagens;

@ManagedBean
@ViewScoped
public class CertidaoController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Certidao certidao;
	private CertidaoDAO certidaoDAO;
	private UtilMensagens mensagens;
	private List<Certidao> certidoes;
	private Certidao certidaoSelecionada;

	public CertidaoController() {
		instances();
	}

	private void instances() {
		this.certidao = new Certidao();
		this.certidaoDAO = new CertidaoDAO();
		this.mensagens = new UtilMensagens();
	}

	public void salvar() {
		this.certidaoDAO.saveOrUpdate(certidao);
		this.mensagens.info(
				String.format("Certidao do Tipo %s Cadastrada com Sucesso", certidao.getTipoCertidao().getDescricao()));
	}

	public void excluir() {

	}

	public void inicializaCertidoes() {
		this.certidoes = this.certidaoDAO.findAll();
	}

	public TipoCertidao[] getTiposCertidoes() {
		return TipoCertidao.values();
	}

	public List<Certidao> getCertidoes() {
		return certidoes;
	}

	public void setCertidoes(List<Certidao> certidoes) {
		this.certidoes = certidoes;
	}

	public Certidao getCertidao() {
		return certidao;
	}

	public void setCertidao(Certidao certidao) {
		this.certidao = certidao;
	}

	public Certidao getCertidaoSelecionada() {
		return certidaoSelecionada;
	}

	public void setCertidaoSelecionada(Certidao certidaoSelecionada) {
		this.certidaoSelecionada = certidaoSelecionada;
	}

}
