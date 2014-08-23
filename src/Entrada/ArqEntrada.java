package Entrada;

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
	private static final String NOME_ARQUIVO="entrada.txt";
	private int qtdPadroes;
	private ArrayList<String> texto= new ArrayList<String>();
	
	public ArqEntrada(){
		this.calcularPadroes();
		this.read();
	}
	
	void read() {
		File f = new File(NOME_ARQUIVO);
		InputStream is;
		BufferedReader br;
		try {
			is = new FileInputStream(f);
			br = new BufferedReader(new InputStreamReader(is));
			while(br.ready()){
				texto.add(br.readLine());
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//Incompleto
	public void calcularPadroes(){
		Random r= new Random();
		qtdPadroes=1+ r.nextInt(20);
		}
	public ArrayList<String> getTexto() {
		return texto;
	}
	public int getQtdPadroes() {
		return qtdPadroes;
	}
}
