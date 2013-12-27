package aid.core.main.enumerations;

import java.io.Serializable;

public enum TipoSoftware implements Serializable{
	SistemaOperacional("Sistema Operacional"), AntiVirus("Antivírus"), Driver(
			"Driver"), Aplicativo("Aplicativo");
	private String nome;

	private TipoSoftware(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
