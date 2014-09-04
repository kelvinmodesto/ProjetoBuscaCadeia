package Busca;

public abstract class Busca {
	protected int qtdComparacoes;
	protected int qtdEncontrados;

	public Busca() {
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
