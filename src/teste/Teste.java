package teste;

import busca.BoyerMoore;
import busca.ForcaBruta;
import busca.KMP;
import entrada.ArqEntrada;

public class Teste {

	private ArqEntrada arqEntrada;
	private ForcaBruta forcaBruta;
	private KMP kmp;
	private BoyerMoore bmoore;
	
	public Teste() {
		arqEntrada = new ArqEntrada();
		forcaBruta = new ForcaBruta(arqEntrada.getTexto());
		kmp = new KMP(arqEntrada.getTexto());
		bmoore = new BoyerMoore(arqEntrada.getTexto());
	}
	
	private void buscarPorKMP(String padrao) {
		System.out.println("Buscando o padrao: " + padrao);
		kmp.buscar(padrao);
		System.out.println("Qtd de Comparacoes: "
				+ kmp.getQtdComparacoes());
		System.out.println("Qtd de Encontrados: "
				+ kmp.getQtdEncontrados());
	}

	private void buscarPorForcaBruta(String padrao) {
		System.out.println("Buscando o padrao: " + padrao);
		forcaBruta.buscar(padrao);
		System.out.println("Qtd de Comparacoes: "
				+ forcaBruta.getQtdComparacoes());
		System.out.println("Qtd de Encontrados: "
				+ forcaBruta.getQtdEncontrados());
	}
	
	private void buscarPorBoyerMoore(String padrao) {
		System.out.println("Buscando o padrao: " + padrao);
		bmoore.buscar(padrao);
		System.out.println("Qtd de Comparacoes: "
				+ bmoore.getQtdComparacoes());
		System.out.println("Qtd de Encontrados: "
				+ bmoore.getQtdEncontrados());
	}

	private void gerarPadroes() {
		System.out.println("--------------Texto--------------");
		arqEntrada.imprimirTexto();
		System.out.println("----------Fim do Texto-----------");
		System.out.println("Qtd de Padroes: " + arqEntrada.getQtdPadroes());
		System.out.println("-------------Padroes--------------");
		arqEntrada.imprimirPadroes();
	}

	public void buscarPadroes() {
		gerarPadroes();
		System.out.println("-------Buscando os Padroes--------");
		System.out.println("---------Por Forca Bruta----------");
		for (int i = 0; i < arqEntrada.getQtdPadroes(); i++) {
			buscarPorForcaBruta(arqEntrada.getPadrao(i));			
			System.out.println();
		}
		System.out.println("-------------Por KMP--------------");
		for (int i = 0; i < arqEntrada.getQtdPadroes(); i++) {
			buscarPorKMP(arqEntrada.getPadrao(i));
			System.out.println();
		}
		System.out.println("---------Por Boyer Moore----------");
		for (int i = 0; i < arqEntrada.getQtdPadroes(); i++) {
			buscarPorBoyerMoore(arqEntrada.getPadrao(i));
			System.out.println();
		}
		System.out.println("----------Fim das Buscas----------");
	}

	public static void main(String[] args) {
		new Teste().buscarPadroes();
	}

}
