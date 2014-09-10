package Busca;

import java.util.ArrayList;

public class BoyerMoore extends Busca {

	public BoyerMoore(ArrayList<String> texto) {
		super(texto);
	}

	/** Funcao para calcular o indice de padrao substring **/

	public int indexPadrao(char[] texto, char[] padrao) {

		if (padrao.length == 0) {

			return 0;
		}

		int charTable[] = criaTabelaChar(padrao);

		int offsetTable[] = criaTabelaSalto(padrao);

		for (int i = padrao.length - 1, j; i < texto.length;) {

			for (j = padrao.length - 1; padrao[j] == texto[i]; --i, --j) {

				if (j == 0) {
					qtdEncontrados++;
					return i;
				} else {
					qtdComparacoes++;
				}
			}

			// i += pattern.length - j; // For naive method

			i += Math.max(offsetTable[padrao.length - 1 - j],
					charTable[texto[i]]);

		}

		return -1;

	}

	/** Cria a tabela de salto com base nas informacoes de carater incompativeis **/

	private int[] criaTabelaChar(char[] padrao) {

		final int ALPHABET_SIZE = 256;

		int[] tabela = new int[ALPHABET_SIZE];

		for (int i = 0; i < tabela.length; ++i) {

			tabela[i] = padrao.length;
		}

		for (int i = 0; i < padrao.length - 1; ++i) {

			tabela[padrao[i]] = padrao.length;
		}

		return tabela;

	}

	/**
	 * Faz a tabela de salto com base na verificacao de deslocamento em que
	 * ocorre incompatibilidade.
	 **/

	private int[] criaTabelaSalto(char[] pattern) {

		int[] tabela = new int[pattern.length];

		int lastPrefixPosition = pattern.length;

		for (int i = pattern.length - 1; i >= 0; --i) {

			if (isPrefixo(pattern, i + 1))

				lastPrefixPosition = i + 1;

			tabela[pattern.length - 1 - i] = lastPrefixPosition - i
					+ pattern.length - 1;

		}

		for (int i = 0; i < pattern.length - 1; ++i) {

			int slen = tamanhoSufixo(pattern, i);

			tabela[slen] = pattern.length - 1 - i + slen;

		}

		return tabela;

	}

	/** funcao para verificar se [p: fim] e o prefixo padrao **/

	private boolean isPrefixo(char[] padrao, int p) {

		for (int i = p, j = 0; i < padrao.length; ++i, ++j) {

			if (padrao[i] != padrao[j]) {

				return false;
			}
		}
		return true;

	}

	/**
	 * Funcao que retorna o tamanho maximo da substring ends at p e se e sufixo
	 **/

	private int tamanhoSufixo(char[] pattern, int p) {

		int len = 0;

		for (int i = p, j = pattern.length - 1; i >= 0
				&& pattern[i] == pattern[j]; --i, --j) {

			len += 1;
		}

		return len;

	}

	/** Procurando Padrao **/

	public void procuraPadrao(String texto, String padrao) {

		char[] text = texto.toCharArray();

		char[] pad = padrao.toCharArray();

		int pos = indexPadrao(text, pad);

		if (pos == -1) {

			// Padrao nao encontrado
		}

		else {

			// Padrao encontrado
		}
	}

	@Override
	public void buscar(String padrao) {
		qtdComparacoes = 0;
		qtdEncontrados = 0;
		for (int i = 0; i < texto.size(); i++) {
			procuraPadrao(texto.get(i), padrao);
		}

	}

}
