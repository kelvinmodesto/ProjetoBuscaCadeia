package Busca;

import java.util.ArrayList;

public class BoyerMoore extends Busca {

	public BoyerMoore(ArrayList<String> texto) {
		super(texto);
	}

	/** Procurando Padr�o **/

	public void procuraPadrao(String texto, String padraop) {

		char[] text = texto.toCharArray();

		char[] pattern = padraop.toCharArray();

		int pos = indexOf(text, pattern);

		if (pos == -1)

			System.out.println("Padr�o n�o encontrado!!");

		else

			System.out.println("Padr�o encontrado na Posi��o : " + pos);

	}

	/** Fun��o para calcular o �ndice de padr�o substring **/

	public int indexOf(char[] text, char[] pattern) {

		if (pattern.length == 0)

			return 0;

		int charTable[] = makeCharTable(pattern);

		int offsetTable[] = makeOffsetTable(pattern);

		for (int i = pattern.length - 1, j; i < text.length;) {

			for (j = pattern.length - 1; pattern[j] == text[i]; --i, --j)

				if (j == 0) {
					qtdEncontrados++;
					return i;
				}
				else
					qtdComparacoes++;

			// i += pattern.length - j; // For naive method

			i += Math.max(offsetTable[pattern.length - 1 - j],
					charTable[text[i]]);

		}

		return -1;

	}

	/** Faz a tabela de salto com base nas informa��es de car�ter incompat�veis **/

	private int[] makeCharTable(char[] pattern) {

		final int ALPHABET_SIZE = 256;

		int[] table = new int[ALPHABET_SIZE];

		for (int i = 0; i < table.length; ++i)

			table[i] = pattern.length;

		for (int i = 0; i < pattern.length - 1; ++i)

			table[pattern[i]] = pattern.length - 1 - i;

		return table;

	}

	/**
	 * Faz a tabela de salto com base na verifica��o de deslocamento em que
	 * ocorre incompatibilidade.
	 **/

	private static int[] makeOffsetTable(char[] pattern) {

		int[] table = new int[pattern.length];

		int lastPrefixPosition = pattern.length;

		for (int i = pattern.length - 1; i >= 0; --i) {

			if (isPrefix(pattern, i + 1))

				lastPrefixPosition = i + 1;

			table[pattern.length - 1 - i] = lastPrefixPosition - i
					+ pattern.length - 1;

		}

		for (int i = 0; i < pattern.length - 1; ++i) {

			int slen = suffixLength(pattern, i);

			table[slen] = pattern.length - 1 - i + slen;

		}

		return table;

	}

	/** fun��o para verificar se [p: fim] � o prefixo padr�o **/

	private static boolean isPrefix(char[] pattern, int p) {

		for (int i = p, j = 0; i < pattern.length; ++i, ++j)

			if (pattern[i] != pattern[j])

				return false;

		return true;

	}

	/**
	 * Fun��o que retorna o tamanho m�ximo da substring ends at p e se � sufixo
	 **/

	private static int suffixLength(char[] pattern, int p) {

		int len = 0;

		for (int i = p, j = pattern.length - 1; i >= 0
				&& pattern[i] == pattern[j]; --i, --j)

			len += 1;

		return len;

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
