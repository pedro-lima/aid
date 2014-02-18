package aid.core.main.enumerations;

import java.io.Serializable;

public enum TipoPeca implements Serializable {
	Gabinete("Gabinete"), Fonte("Fonto"), PlacaMae("Placa M�e"), Processador(
			"Processador"), HD("HD"), PlacaVideo("Placa de V�deo"), PlaceRede(
			"Placa de Rede"), Modem("Modem"), Fax("Fax"), CdRom("CD-Rom"), DvdRom(
			"DVD-Rom"), CaixaSom("Caixa de Som"), Teclado("Teclado"), Mouse(
			"Mouse"), Monitor("Monitor"), Estabilizador("Estabilizador"), Impressora(
			"Impressora");
	private String nome;

	private TipoPeca(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
