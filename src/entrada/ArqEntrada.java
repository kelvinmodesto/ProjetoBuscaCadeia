package entrada;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class ArqEntrada {
	private int qtdPadroes;
	private ArrayList<String> padroes;
	private ArrayList<String> texto;

	public ArqEntrada() {
		padroes = new ArrayList<String>();
		texto = new ArrayList<String>();
		lerArquivo();
		calcularPadroes();
	}

	public ArrayList<String> getTexto() {
		return texto;
	}

	public String getPadrao(int ind) {
		return padroes.get(ind);
	}

	private void lerArquivo() {
		File f = new File("entrada.txt");
		InputStream is;
		BufferedReader br;
		try {
			is = new FileInputStream(f);
			br = new BufferedReader(new InputStreamReader(is));
			while (br.ready()) {
				texto.add(br.readLine());
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private int sortear(int inicio, int limite) {
		Random r = new Random();
		return inicio + r.nextInt(limite);
	}

	private void calcularNumPadroes() {
		qtdPadroes = sortear(1, 20);
	}

	private String filtrarPadrao(String padrao) {
		String regex = "[^A-Za-zÀ-ú0-9'-]+";
		String [] aux;
		aux = padrao.split(regex);
		for (int i = 0; i < aux.length; i++) {
			padrao = aux[i];
			if(!padrao.equals(""))
				return padrao;
		}
		return "";
	}
	
	private void calcularPadroes() {
		calcularNumPadroes();
		String padrao;
		int linha, elem;
		String[] lista;
		int qtd = 0;
		while (qtd < qtdPadroes) {
			linha = sortear(0, texto.size());
			lista = texto.get(linha).split(" ");
			elem = sortear(0, lista.length);
			padrao = lista[elem];
			padrao = filtrarPadrao(padrao);
			if (!padrao.equals("")&&!padroes.contains(padrao)) {
				padroes.add(padrao);
				qtd++;
			}
		}
	}

	public int getQtdPadroes() {
		return qtdPadroes;
	}

	public void imprimirTexto() {
		for (int i = 0; i < texto.size(); i++) {
			System.out.println(texto.get(i));
		}
	}

	public void imprimirPadroes() {
		for (int i = 0; i < padroes.size(); i++) {
			System.out.println(padroes.get(i));
		}
	}

	public ArrayList<String> getPadroes() {
		return this.padroes;
	}
}
