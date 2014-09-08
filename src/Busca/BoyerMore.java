package Busca;

import java.util.ArrayList;

//CLASSE INCOMPLETA
@SuppressWarnings("unused")
public class BoyerMore extends Busca {
	private int tamAlfabeto;
	private int[] last;
	private int[] match;
	private int[] sufixo;
	
	public BoyerMore(ArrayList<String> texto) {	
		super(texto);
		}
	
	//Incompleto
	public void computeMatch(String padrao){
		
		for(int j=0;j<match.length;j++){
			match[j]=match.length;
		}
		
		computaSufixo(padrao);
		for(int i=0;i<match.length;i++){
			int j=sufixo[i+1]-1;
			if(sufixo[i]>j){
				match[j]= j-1;
			}else{
				match[j]= Math.min(j-1 + match[i], match[j]);
			}
		}
		
		if (sufixo[0] < padrao.length()) {
		      for (int j = sufixo[0] - 1; j >= 0; j--) {
		        if (sufixo[0] < match[j]) { match[j] = sufixo[0]; }
		      }
		      int j = sufixo[0];
		      for (int k = sufixo[j]; k < padrao.length(); k = sufixo[k]) {
		        while (j < k) {
		          if (match[j] > k) match[j] = k;
		          j++;
		        }       
		      }
		    }
	}

	public void computaSufixo(String padrao){
		sufixo[sufixo.length -1]= sufixo.length;
		int j=sufixo.length -1;
		for(int i=sufixo.length-2;i>=0;i--){
			while(j<sufixo.length - 1 && padrao.charAt(j) != padrao.charAt(i) ){
				j=sufixo[j+1]-1;
			}
			if(padrao.charAt(j)== padrao.charAt(i)){
				j--;
			}
			sufixo[i]=j+1;
		}
	}
	
	@Override
	public void buscar(String padrao) {
		}

}