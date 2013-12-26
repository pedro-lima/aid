package aid.core.main.enumerations;

public enum DiaSemana {
	Domingo("Domingo"), Segunda("Segunda"), Terca("Ter�a"), Quarta("Quarta"), Quinta(
			"Quinta"), Sexta("Sexta"), Sabado("S�bado");

	private String nome;

	private DiaSemana(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
