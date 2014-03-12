package br.com.aid.admin.interfaces;

import java.io.Serializable;
import java.util.List;

public interface LazyCollection<T> extends Serializable {

	public List<T> pesquisar();
}
