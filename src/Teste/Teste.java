package Teste;

import Busca.ForcaBruta;
import Entrada.ArqEntrada;

public class Teste {

	private ArqEntrada arqEntrada;
	private ForcaBruta forcaBruta;

	public Teste() {
		arqEntrada = new ArqEntrada();
		forcaBruta = new ForcaBruta(arqEntrada.getTexto());
	}

	private void buscarPorForcaBruta(String padrao) {
		System.out.println("Buscando o padrao: " + padrao);
		forcaBruta.buscar(padrao);
		System.out.println("Qtd de Comparacoes: "
				+ forcaBruta.getQtdComparacoes());
		System.out.println("Qtd de Encontrados: "
				+ forcaBruta.getQtdEncontrados());
	}

	private void gerarPadroes() {
		System.out.println("--------------Texto--------------");
		arqEntrada.imprimirTexto();
		System.out.println("Qtd de Padroes: " + arqEntrada.getQtdPadroes());
		System.out.println("-------------Padroes--------------");
		arqEntrada.imprimirPadroes();
	}

	public void buscarPadroes() {
		gerarPadroes();
		System.out.println("-------Buscando os Padroes--------");
		for (int i = 0; i < arqEntrada.getQtdPadroes(); i++) {
			buscarPorForcaBruta(arqEntrada.getPadrao(i));
			System.out.println();
		}
		System.out.println("----------Fim das Buscas----------");
	}

	public static void main(String[] args) {
		new Teste().buscarPadroes();
	}

}
