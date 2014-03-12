package br.com.aid.core.cryptography;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import br.com.aid.core.interfaces.Criptografia;

public class AESCriptografiaBusiness implements Criptografia {

	public static final String criptografiaTipo = "AES";
	public static final String cifraInstancia = "AES/ECB/NoPadding";
	private String chave;

	public AESCriptografiaBusiness() {
		super();
	}

	public String codificar(String mensagem) {
		return this.crifar(mensagem, Cipher.ENCRYPT_MODE);
	}

	public String decodificar(String mensagem) {
		return this.crifar(mensagem, Cipher.DECRYPT_MODE);
	}

	private String crifar(String mensagem, int tipoCifra) {
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(chave.getBytes(),
					criptografiaTipo);
			Cipher cipher = Cipher.getInstance(cifraInstancia);
			cipher.init(tipoCifra, skeySpec);
			byte[] crypted = cipher.doFinal(mensagem.getBytes());
			return new String(crypted);
		} catch (InvalidKeyException | IllegalBlockSizeException
				| BadPaddingException | NoSuchAlgorithmException
				| NoSuchPaddingException e) {
			return null;
		}
	}
}
