package classes;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luciano
 */
public class Ordenacao {
    
	public static void bubbleSort(long vetor[]) {
		for(int i=0;i<vetor.length-1;i++)
			for(int j=0;j<vetor.length-i-1;j++)
				if(vetor[j]>vetor[j+i]){
					long aux=vetor[j];
					vetor[j]=vetor[j+1];
					vetor[j+1]=aux;
				}
	}
	
	public static void bubbleSortSentinela(long vetor[]) {
		boolean sentinela=true;
		
	 for(int i=0;(i<vetor.length-1) && (sentinela);i++){ 
	    sentinela = false;
		for(int j=0;j<vetor.length-i-1;j++)
			if(vetor[j]>vetor[j+i]){
				long aux=vetor[j];
				vetor[j]=vetor[j+1];
				vetor[j+1]=aux;
				sentinela = true;
			}
	  }	
	}
	
	public static void quickSortPivotamentoInicial(long vetor[], int Ini, int Fim){
		int i=Ini+1;
		int j=Fim;
		long pivo;
		long aux;
		
		if(Ini<Fim){
			pivo = vetor[Ini];
			
		  //Partição	
			while(i<=j){
				while(vetor[i]<=pivo)i++;
				while(vetor[j]>pivo)j--;
				if(i<=j){
				 aux=vetor[i];
				 vetor[i]=vetor[j];
				 vetor[j]=aux;
				 j--;
				 i++;
				}
			}
			vetor[Ini] = vetor[j];
		    vetor[j] = pivo;
		    //chamada recursiva
		    quickSortPivotamentoInicial(vetor,Ini,j-1);
		    quickSortPivotamentoInicial(vetor,j+1,Fim);
		}
		
	}
	
	public static void quickSortPivotamentoCentral(long vetor[], int Ini, int Fim){
		int i=Ini;
		int j=Fim-1;
		long pivo;
		long aux;
		
		if(Ini<Fim){
			pivo = vetor[Fim];
			
		  //Partição	
			while(i<=j){
				while(vetor[i]<=pivo)i++;
				while(vetor[j]>pivo)j--;
				if(i<=j){
				 aux=vetor[i];
				 vetor[i]=vetor[j];
				 vetor[j]=aux;
				 j--;
				 i++;
				}
			}	
			vetor[Fim] = vetor[j];
		    vetor[j] = pivo;
		    //chamada recursiva
		    quickSortPivotamentoInicial(vetor,Ini,j-1);
		    quickSortPivotamentoInicial(vetor,j+1,Fim);
		}
	}
	
	public static void quickSortMedianaDeTres(long vetor[]){
	}
	
	public static void insertionSort(long vetor[]){
	}
	
	public static void shellSort(long vetor[]){
	}
	
	public static void seletionSort(long vetor[]){
	}
	
	public static void heapSort(long vetor[]){
	}
	
	public static void mergeSort(long vetor[]){
	}
	
}
