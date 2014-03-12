package br.com.aid.core.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.aid.core.interfaces.Gerenciador;

@Entity
public class Administrador extends AbstracModel implements Gerenciador {
	
	private static final long serialVersionUID = -4158243306123461371L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Usuario usuario;

	public Administrador() {
		super();
	}

	public Administrador(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
