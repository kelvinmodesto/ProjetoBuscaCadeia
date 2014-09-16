package teste;

import relatorio.Relatorio;
import relatorio.RelatorioBarra;

public class TesteGrafico {
	
	public TesteGrafico(boolean barra) {
		if(barra)
			new RelatorioBarra();
		else
			new Relatorio();
	}
	
	public static void main(String[] args) {
		new TesteGrafico(true);
	}
		
}
