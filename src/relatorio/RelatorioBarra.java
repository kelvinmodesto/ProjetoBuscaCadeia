package relatorio;

import java.awt.Dimension;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import busca.BoyerMoore;
import busca.ForcaBruta;
import busca.KMP;
import entrada.ArqEntrada;

public class RelatorioBarra extends ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArqEntrada arqEntrada;
	private ForcaBruta fb;
	private KMP kmp;
	private BoyerMoore bm;

	public RelatorioBarra() {
		super("Grafico em Barra");
		iniciar();
	}

	private void iniciar() {
		arqEntrada = new ArqEntrada();
		fb = new ForcaBruta(arqEntrada.getTexto());
		kmp = new KMP(arqEntrada.getTexto());
		bm = new BoyerMoore(arqEntrada.getTexto());

		final CategoryDataset dataset = createDataset();
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(500, 270));
		setContentPane(chartPanel);
		pack();
		setVisible(true);
	}

	private CategoryDataset createDataset() {

		// row keys...
		final String seriesFB = "Força Bruta";
		final String seriesKMP = "KMP";
		final String seriesBM = "Boyer-Moore";

		// create the dataset...
		final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// Forca Bruta
		for (int i = 0; i < arqEntrada.getQtdPadroes(); i++) {
			fb.buscar(arqEntrada.getPadrao(i));
			dataset.addValue(fb.getQtdComparacoes(), seriesFB,
					arqEntrada.getPadrao(i));
		}
		// KMP
		for (int i = 0; i < arqEntrada.getQtdPadroes(); i++) {
			kmp.buscar(arqEntrada.getPadrao(i));
			dataset.addValue(kmp.getQtdComparacoes(), seriesKMP,
					arqEntrada.getPadrao(i));
		}
		// Boyer-Moore
		for (int i = 0; i < arqEntrada.getQtdPadroes(); i++) {
			bm.buscar(arqEntrada.getPadrao(i));
			dataset.addValue(bm.getQtdComparacoes(), seriesBM,
					arqEntrada.getPadrao(i));
		}
		return dataset;

	}

	private JFreeChart createChart(CategoryDataset dataset) {
		final JFreeChart chart = ChartFactory.createBarChart(
				"Comparativo FB x KMP x BM", // chart title
				"Busca por padrões", // domain axis label
				"Qtda comparações", // range axis label
				dataset, // data
				PlotOrientation.VERTICAL, // orientation
				true, // include legend
				true, // tooltips?
				false // URLs?
				);
		return chart;
	}

}
