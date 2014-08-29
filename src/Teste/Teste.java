package Teste;

import java.util.Random;

import Entrada.ArqEntrada;

public class Teste {
	static Random r= new Random();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ForcaBruta fb= new ForcaBruta();
//		fb.buscar("ara");
//		System.out.println(fb.getQtdComparacoes());
		ArqEntrada arq= new ArqEntrada();
		arq.imprimirTexto();
		System.out.println(arq.getQtdPadroes());
		arq.imprimirPadroes();
		
	}

}
