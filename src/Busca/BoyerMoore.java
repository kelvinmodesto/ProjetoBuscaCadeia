package Busca;

import java.util.ArrayList;

public class BoyerMoore extends Busca {

	private final int alf = 256;

	public BoyerMoore(ArrayList<String> texto) {
		super(texto);
	}

	private int[] gerarArrayDePulo(String padrao) {
		int[] tabela = new int[alf];
		for (int i = 0; i < alf; i++)
			tabela[i] = -1;
		for (int i = 0; i < padrao.length(); i++)
			tabela[padrao.charAt(i)] = i;
		return tabela;
	}

	private void buscarPorLinha(String padrao, String linha) {
		int[] arrayDePulo = gerarArrayDePulo(padrao);
		int m = padrao.length();
		int n = linha.length();
		int pulo = 0;
		for (int i = 0; i < n - m; i += pulo) {
			pulo = 0;
			qtdComparacoes++;
			for (int j = m - 1; j >= 0; j--) {
				qtdComparacoes++;
				if (padrao.charAt(j) != linha.charAt(i + j)) {
					pulo = Math.max(1, j - arrayDePulo[linha.charAt(i + j)]);
					break;
				}
			}
			if (pulo == 0) {
				qtdEncontrados++;
				pulo = 1;
			}
		}
	}

	@Override
	public void buscar(String padrao) {
		qtdComparacoes = 0;
		qtdEncontrados = 0;
		for (int i = 0; i < texto.size(); i++) {
			buscarPorLinha(padrao,texto.get(i));
		}
	}
}
