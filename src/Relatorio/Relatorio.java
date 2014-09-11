package Relatorio;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

import Busca.BoyerMoore;
import Busca.ForcaBruta;
import Busca.KMP;
import Entrada.ArqEntrada;


public class Relatorio {
	private JFreeChart jfc;
	private ChartFactory factory;
	private ArqEntrada arqEntrada;
	private ForcaBruta fb;
	private KMP kmp;
	private BoyerMoore bm;
	
	public Relatorio(){
		iniciar();
		
	}
	
	public void iniciar(){
		arqEntrada= new ArqEntrada();
		fb= new ForcaBruta(arqEntrada.getTexto());
		kmp = new KMP(arqEntrada.getTexto());
		bm= new BoyerMoore(arqEntrada.getTexto());		
	}
	
	public void criarGrafico(){
		
	}
	
	
	
	public static void main(String[] args) {
		
	}

}
