package aid.core.main.enumerations;

import java.io.Serializable;

public enum Curso implements Serializable {
	RD("Rede de Computadores", "Tecn�logo em Rede de Computadores"), TSI(
			"Sistemas para Internet", "Tecn�logo em Sistemas para Internet"), GTI(
			"Gest�o da Tecnologia da Informa��o",
			"Tecn�logo em Gest�o da Tecnologia da Informa��o"), CC(
			"Ci�ncia da Computa��o", "Bacharelado em Ci�ncia da Computa��o");
	private String nome;
	private String nomeCompleto;

	private Curso(String nome, String nomeCompleto) {
		this.nome = nome;
		this.nomeCompleto = nomeCompleto;
	}

	public String getNome() {
		return nome;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

}
