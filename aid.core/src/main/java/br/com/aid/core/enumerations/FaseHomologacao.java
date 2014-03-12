package br.com.aid.core.enumerations;

import java.io.Serializable;

public enum FaseHomologacao implements Serializable {
	Micro("Micro"), Macro("Macro"), Perifericos("Perif�ricos"), Estabilizador(
			"Estabilizador"), Impressora("Impressora");
	private String nome;

	private FaseHomologacao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
