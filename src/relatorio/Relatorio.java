package relatorio;

import java.awt.BasicStroke;
import java.awt.Color;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import busca.BoyerMoore;
import busca.ForcaBruta;
import busca.KMP;
import entrada.ArqEntrada;

public class Relatorio extends ApplicationFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArqEntrada arqEntrada;
	private ForcaBruta fb;
	private KMP kmp;
	private BoyerMoore bm;

	public Relatorio() {
		super("Grafico em Linha");
		iniciar();
		criarPainel();
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	private void iniciar() {
		arqEntrada = new ArqEntrada();
		fb = new ForcaBruta(arqEntrada.getTexto());
		kmp = new KMP(arqEntrada.getTexto());
		bm = new BoyerMoore(arqEntrada.getTexto());
	}

	private void criarPainel() {
		ChartPanel painel = new ChartPanel(criarJFreeChart());
		painel.setSize(900, 300);
		this.setContentPane(painel);
	}

	private JFreeChart criarJFreeChart() {
		JFreeChart chart = ChartFactory.createBarChart(
				"Comparativo FB x KMP x BM", "Padrões", "Qtd de Comparações",
				criarDataset(), PlotOrientation.VERTICAL, true, true, false);
		CategoryPlot plot = (CategoryPlot) chart.getPlot();
		plot.setBackgroundPaint(Color.lightGray);
		plot.setRangeGridlinePaint(Color.white);
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		rangeAxis.setAutoRangeIncludesZero(true);
		LineAndShapeRenderer renderer = new LineAndShapeRenderer();
		renderer.setSeriesStroke(0, new BasicStroke(2.0f,
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 10.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(1, new BasicStroke(2.0f,
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 6.0f, 6.0f }, 0.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f,
				BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1.0f,
				new float[] { 2.0f, 6.0f }, 0.0f));
		plot.setRenderer(renderer);
		return chart;
	}

	private CategoryDataset criarDataset() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		String padrao;
		for (int i = 0; i < arqEntrada.getQtdPadroes(); i++) {
			padrao = arqEntrada.getPadrao(i);
			fb.buscar(padrao);
			kmp.buscar(padrao);
			bm.buscar(padrao);
			dataset.addValue(fb.getQtdComparacoes(), "Força Bruta", padrao);
			dataset.addValue(kmp.getQtdComparacoes(), "KMP", padrao);
			dataset.addValue(bm.getQtdComparacoes(), "Boyer-Moore", padrao);
		}
		return dataset;
	}
}
