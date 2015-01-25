package main;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

import classes.Arquivo;
import classes.Ordenacao;

public class Main {
	
	public static void main(String args[]) throws IOException{
		int N[] = new int[13];
		int REPETICOES = 50;
		N[0] = 50;
		N[1] = 100;
		N[2] = 500;
		N[3] = 1000;
		N[4] = 1500;
		N[5] = 5000;
		N[6] = 10000;
		N[7] = 15000;
		N[8] = 20000;
		N[9] = 25000;
		N[10] = 50000;
		N[11] = 100000;
		N[12] = 500000;
		
		String casos[] = new String[3];
		casos[0] = "melhorCaso";
		casos[1] = "casoMedio";
		casos[2] = "piorCaso";
		float[] tempo = null;
		tempo = new float[39];
		for(int k = 0; k < 3; k++){
			Arquivo.setArquivo(casos[k]);
			for(int i = 0; i < 13; i++){
				long[] vet = new long[N[i]];
				Arquivo.abreArquivoLeitura();
				Arquivo.getElements(vet,N[i]);
				Arquivo.fechaArquivoLeitura();
				long start = System.currentTimeMillis();
				for(int j = 0; j < REPETICOES; j++){
					long[] temp = vet.clone();
					//Ordenacao.seletionSort(temp);
					//Ordenacao.bubbleSort(vet);
					//Ordenacao.bubbleSortSentinela(temp);

					
					
					
					//Ordenacao.insertionSort(temp);
					
					Ordenacao.quickSortPivotamentoInicial(vet, 0, vet.length-1);
					//Ordenacao.quickSortPivotamentoCentral(temp, 0, vet.length - 1);
					//Ordenacao.quickSortMedianaDeTres(temp, 0, vet.length - 1);
					//Ordenacao.heapSort(temp);
					//Ordenacao.mergeSort(temp, 0, temp.length - 1);
					//Ordenacao.shellSort(temp);
					
					
				}
				long finish = System.currentTimeMillis();
				tempo[k*13 + i] = ((finish - start)); 
				System.out.println(N[i]+":"+((finish - start)));
			}
		}
		String arquivo = "Quick Sort Pivotamento Inicial.csv"; //LINHA A SER ALTERADA 
		Arquivo.setArquivo(arquivo);
		Arquivo.abreArquivoEscrita();
		Arquivo.escreve("Quick Sort Pivotamento Inicial;"); //LINHA A SER ALTERADA 
		Arquivo.escreve("Melhor Caso;");
		int i = 0, j = 0;
		for(; i < 13; i++){
			String texto = N[i]+";"+tempo[i]/1000f+";";
			Arquivo.escreve(texto);
		}
		Arquivo.escreve("Caso Médio;");
		for(; i < 26; i++){
			String texto = N[i%13]+";"+tempo[i]/1000f+";";
			Arquivo.escreve(texto);
		}
		Arquivo.escreve("Pior Caso;");
		for(; i < 39; i++){
			String texto = N[i%26]+";"+tempo[i]/1000f+";";
			Arquivo.escreve(texto);
		}
		Arquivo.fechaArquivoEscrita();
	}

}
