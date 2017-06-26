package br.com.cartorio.models;

public enum TipoCertidao {

	CASAMENTO("Casamento"), NASCIMENTO("Nascimento"), OBITO("Óbito");

	private String descricao;

	TipoCertidao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
