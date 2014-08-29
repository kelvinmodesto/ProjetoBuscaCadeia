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
	private ArrayList<String> padroes= new ArrayList<String>();
	private ArrayList<String> texto= new ArrayList<String>();
	
	public ArqEntrada(){
		this.read();
		this.calcularPadroes();
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
	public int sortear(int inicio,int limite){
		Random r= new Random();
		return inicio + r.nextInt(limite);
	}
	public void calcularNumPadroes(){
		Random r= new Random();
		qtdPadroes=sortear(1,20);
		}
	public void calcularPadroes(){
		calcularNumPadroes();
		for(int qtd=0;qtd<qtdPadroes;qtd++){
			int linha= sortear(0,texto.size());
			ArrayList<String> listaLinha= new ArrayList<String>();
			String[] lista= texto.get(linha).split(" ");
			int elem= sortear(0,lista.length);
			padroes.add(lista[elem]);
		}
	}
	public ArrayList<String> getTexto() {
		return texto;
	}
	public int getQtdPadroes() {
		return qtdPadroes;
	}
	public void imprimirTexto(){
		for(int i=0;i<texto.size();i++){
			System.out.println(texto.get(i));
		}
	}
	public void imprimirPadroes(){
		for(int i=0;i<padroes.size();i++){
			System.out.println(padroes.get(i));
		}
	}
}
