package Busca;

import java.util.ArrayList;

public class ForcaBruta extends Busca {

	private ArrayList<String> texto;

	public ForcaBruta(ArrayList<String> texto) {
		super(texto);
	}

	private void buscaPorLinha(String padrao, String linha) {
		int n = linha.length();
		int m = padrao.length();
		for (int i = 0; i < n - (m - 1); i++) {
			int j = 0;
			qtdComparacoes++;
			while (j < m && padrao.charAt(j) == linha.charAt(i + j)) {
				j++;
					qtdComparacoes++;
			}
			if (j == m)
				qtdEncontrados++;
		}
	}

	@Override
	public void buscar(String padrao) {
		qtdComparacoes = 0;
		qtdEncontrados = 0;
		for (int i = 0; i < texto.size(); i++) {
			buscaPorLinha(padrao, texto.get(i));
		}
	}
}
