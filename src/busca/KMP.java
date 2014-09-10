package busca;

import java.util.ArrayList;

public class KMP extends Busca {

	public KMP(ArrayList<String> texto) {
		super(texto);
	}

	private int[] preProcessamento(String padrao) {
		int m = padrao.length();
		int[] prefixos = new int[m];
		prefixos[0] = -1;
		for (int i = 1, s = -1; i < m; i++) {
			qtdComparacoes++;
			while (s > -1 && padrao.charAt(s + 1) != padrao.charAt(i))
				s = prefixos[s];
			if (padrao.charAt(s + 1) == padrao.charAt(i))
				s++;
			prefixos[i] = s;
		}
		return prefixos;
	}

	private void buscarPorLinha(String padrao, String linha) {
		int n = linha.length();
		int m = padrao.length();
		int s = -1;
		int[] prefixos = preProcessamento(padrao);
		for (int i = 0; i < n; i++) {
			qtdComparacoes++;
			while (s > -1 && padrao.charAt(s + 1) != linha.charAt(i)) {
				qtdComparacoes++;
				s = prefixos[s];
			}
			if (padrao.charAt(s + 1) == linha.charAt(i))
				s++;
			if (s == m - 1) {
				s = prefixos[s];
				qtdEncontrados++;
			}
		}
	}

	@Override
	public void buscar(String padrao) {
		qtdComparacoes = 0;
		qtdEncontrados = 0;
		for (int i = 0; i < texto.size(); i++) {
			buscarPorLinha(padrao, texto.get(i));
		}
	}

}
