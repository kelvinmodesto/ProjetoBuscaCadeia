package Relatorio;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import Busca.BoyerMoore;
import Busca.ForcaBruta;
import Busca.KMP;
import Entrada.ArqEntrada;

public class RelatorioBarra extends ApplicationFrame {
	private JFreeChart jfc;
	private ChartFactory factory;
	private ArqEntrada arqEntrada;
	private ForcaBruta fb;
	private KMP kmp;
	private BoyerMoore bm;
	private FileOutputStream fos;
	private OutputStream os;
	
	public RelatorioBarra(String title) {
		super(title);

	}
	
	public void iniciar() {
		arqEntrada = new ArqEntrada();
		fb = new ForcaBruta(arqEntrada.getTexto());
		kmp = new KMP(arqEntrada.getTexto());
		bm = new BoyerMoore(arqEntrada.getTexto());
	}

	private CategoryDataset createDataset() {

		// row keys...
		final String seriesKMP = "KMP";
		final String seriesBM = "Boyer-Moore";
		final String seriesFB = "Força Bruta";

		
		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		//Forca Bruta
		for(int i=0;i<arqEntrada.getPadroes().size();i++){
			fb.buscar(arqEntrada.getPadroes().get(i));
			dataset.addValue(fb.getQtdComparacoes() , seriesFB, arqEntrada.getPadroes().get(i));
		}
		//KMP
		for(int i=0;i<arqEntrada.getPadroes().size();i++){
			kmp.buscar(arqEntrada.getPadroes().get(i));
			dataset.addValue(kmp.getQtdComparacoes() , seriesKMP, arqEntrada.getPadroes().get(i));
		}
		//Boyer-Moore
		for(int i=0;i<arqEntrada.getPadroes().size();i++){
			bm.buscar(arqEntrada.getPadroes().get(i));
			dataset.addValue(bm.getQtdComparacoes() , seriesBM, arqEntrada.getPadroes().get(i));
		}
		return dataset;

	}
	
//	private JFreeChart(final CategoryDataset dataset){
//		
//	}
	

	
}
