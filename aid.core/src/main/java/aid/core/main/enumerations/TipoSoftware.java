package aid.core.main.enumerations;

import java.io.Serializable;

public enum TipoSoftware implements Serializable {
	Aplicativo("Aplicativo"), AntiVirus("Antivírus"), Driver(
			"Driver"), SistemaOperacional("Sistema Operacional");
	private String nome;

	private TipoSoftware(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
