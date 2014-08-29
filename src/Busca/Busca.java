package Busca;

import java.util.ArrayList;

import Entrada.ArqEntrada;

public abstract class Busca {
	private int qtdComparacoes;
	private int qtdPadroesEncontrados;
	private ArqEntrada entrada;
	private ArrayList<String> texto = new ArrayList<String>();

	public Busca() {
		this.entrada = new ArqEntrada();
		this.lerTexto();
		this.qtdComparacoes = 0;
		this.qtdPadroesEncontrados = 0;
	}

	public abstract void buscar(String padrao);
	public int incQtdComparacoes(){
		return qtdComparacoes+1;
	}
	public int incQtdPadroesEncontrados(){
		return qtdPadroesEncontrados+1;
	}
	public void lerTexto() {
		this.texto = entrada.getTexto();
	}

	public int getQtdComparacoes() {
		return qtdComparacoes;
	}

	public int getQtdPadroesEncontrados() {
		return qtdPadroesEncontrados;
	}

	public void setQtdComparacoes(int qtdComparacoes) {
		this.qtdComparacoes = qtdComparacoes;
	}

	public void setQtdPadroesEncontrados(int qtdPadroesEncontrados) {
		this.qtdPadroesEncontrados = qtdPadroesEncontrados;
	}

	public ArrayList<String> getTexto() {
		return texto;
	}
}
