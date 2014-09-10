package relatorio;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.Dataset;

import busca.BoyerMoore;
import busca.ForcaBruta;
import busca.KMP;
import entrada.ArqEntrada;


@SuppressWarnings("unused")
public class Relatorio {
	private JFreeChart jfc;
	private ChartFactory factory;
	private ArqEntrada arqEntrada;
	private ForcaBruta fb;
	private KMP kmp;
	private BoyerMoore bm;

	public Relatorio() {
		iniciar();
	}

	public void iniciar() {
		arqEntrada = new ArqEntrada();
		fb = new ForcaBruta(arqEntrada.getTexto());
		kmp = new KMP(arqEntrada.getTexto());
		bm = new BoyerMoore(arqEntrada.getTexto());
	}

	public void criarGrafico() {

	}

	public static void main(String[] args) {

	}

}
