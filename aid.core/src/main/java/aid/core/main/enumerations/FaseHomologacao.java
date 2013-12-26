package aid.core.main.enumerations;

public enum FaseHomologacao {
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
