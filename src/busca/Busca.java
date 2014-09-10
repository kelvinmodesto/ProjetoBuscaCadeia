package busca;

import java.util.ArrayList;

public abstract class Busca {
	protected ArrayList<String> texto;
	protected int qtdComparacoes;
	protected int qtdEncontrados;

	public Busca(ArrayList<String> texto) {
		this.texto = texto;
		this.qtdComparacoes = 0;
		this.qtdEncontrados = 0;
	}

	public abstract void buscar(String padrao);

	public int getQtdComparacoes() {
		return qtdComparacoes;
	}

	public int getQtdEncontrados() {
		return qtdEncontrados;
	}

	public void setQtdComparacoes(int qtdComparacoes) {
		this.qtdComparacoes = qtdComparacoes;
	}

	public void setQtdEncontrados(int qtdEncontrados) {
		this.qtdEncontrados = qtdEncontrados;
	}
}
