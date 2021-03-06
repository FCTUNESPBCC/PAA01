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
        long aux;
        for(int j = 0; j < vetor.length - 1; j++) {
            for (int i = 0; i < vetor.length - 1 - j; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                }
            }
        }
	}
	
	public static void bubbleSortSentinela(long vetor[]) {
		boolean troca = true;
        long aux;
        while (troca) {
            troca = false;
            for (int i = 0; i < vetor.length - 1; i++) {
                if (vetor[i] > vetor[i + 1]) {
                    aux = vetor[i];
                    vetor[i] = vetor[i + 1];
                    vetor[i + 1] = aux;
                    troca = true;
                }
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
			
		  //Parti��o	
			while(i<=j){
				if(vetor[i]<=pivo)i++;
				else{
				 if(vetor[j]>pivo)j--;
				 else
				   if(i<j){
				   aux=vetor[i];
				   vetor[i]=vetor[j];
				   vetor[j]=aux;
				   j--;
				   i++;
				}
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
		int i, j;
		long x, y;
		i = Ini;
		j = Fim;
		x = vetor[(i+j) / 2];

		while(i <= j)
		{
			while(vetor[i] < x && i < Fim)
			{
				i++;
			}
			while(vetor[j] > x && j > Ini)
			{
				j--;
			}
			if(i <= j)
			{
				y = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = y;
				i++;
				j--;
			}
		}
		if(j > Ini)
		{
			quickSortPivotamentoCentral(vetor, Ini, j);
		}
		if(i < Fim)
		{
			quickSortPivotamentoCentral(vetor, i, Fim);
		}
	}
	
	public static void quickSortMedianaDeTres(long vetor[], int ini, int fim){
	  if(ini<=fim){
		//achando a mediana
		long mediana = 0;  
	    int meio=(ini+fim)/2;
	    int i=ini,j=fim;
	    long aux[] = new long[3];
	    if(vetor[ini] >= vetor[meio]){
	    	if(vetor[ini] >= vetor[fim]){
	    		aux[2] = vetor[ini];
	    		if(vetor[meio]>vetor[fim]){
	    			aux[1] = vetor[meio]; aux[0] = vetor[fim];
	    		}
	    		else{
	    			aux[1] = vetor[fim]; aux[0] = vetor[meio];
	    		}
	    	}
	    	else{
	    		aux[2] = vetor[fim];
	    		aux[1] = vetor[ini];
	    		aux[0] = vetor[meio];
	    	}
	    }
	    else{
	    	if(vetor[meio] >= vetor[fim]){
	    		aux[2] = vetor[meio];
	    		if(vetor[ini]>vetor[fim]){
	    			aux[1] = vetor[ini]; aux[0] = vetor[fim];
	    		}
	    		else{
	    			aux[1] = vetor[fim]; aux[0] = vetor[ini];
	    		}
	    	}
	    	else{
	    		aux[2] = vetor[fim];
	    		aux[1] = vetor[meio];
	    		aux[0] = vetor[ini];
	    	}
	    }
	    mediana = aux[1];
	    
	   // FINAL DA PROCURA DA MEDIANA
	   long auxi; 
	   while(i<=j){
			if(vetor[i]<mediana)i++;
			else{
			   if(vetor[j]>mediana)j--;
			   else{
			    if(i<=j){
			     auxi=vetor[i];
			     vetor[i]=vetor[j];
			     vetor[j]=auxi;
			     j--;
			     i++;
			   }
		      }	
	       }
		}	
		
	   //chamadas recursivas 
	   if(j > ini);
	   	quickSortMedianaDeTres(vetor, ini, j);
	   if(i > fim);
	   	quickSortMedianaDeTres(vetor, i, fim);
	  }
		
}
	
	public static void insertionSort(long vetor[]){
		 int j,i;
		 long key;
		   for(j = 1; j < vetor.length; j++){
		      key = vetor[j];
		      i = j - 1;
		      while(i >= 0 && vetor[i] > key){
		         vetor[i + 1] = vetor[i];
		         i = i - 1;
		      }
		      vetor[i + 1] = key;
		   }
	}
		
	public static void shellSort(long[] nums) {
	    int h = 1;
	    int n = nums.length;
	    while(h < n)
	            h = h * 3 + 1;
	    h = h / 3;
	    long c;
	    int j;
	    while (h > 0) {
	        for (int i = h; i < n; i++) {
	            c = nums[i];
	            j = i;
	            while (j >= h && nums[j - h] > c) {
	                nums[j] = nums[j - h];
	                j = j - h;
	            }
	            nums[j] = c;
	        }
	        h = h / 2;
	    }
	}
	
	public static void seletionSort(long vetor[]){
		long menor;
		int posmenor;
		for(int i=0;i<vetor.length;i++){
			menor=vetor[i];
			posmenor=i;
			for(int j=i+1;j<vetor.length;j++){
				if(vetor[j]<menor){
					menor=vetor[j];
					posmenor=j;
				}
			}
			vetor[posmenor]=vetor[i];
			vetor[i]=menor;
		}
	}
	//FUNC�ES PARA CONSTRU��O DO HEAPSORT
	public static void heapSort(long vetor[]){
		constroiHeapMax(vetor);
		int n = vetor.length - 1;
		
		for(int i = vetor.length - 1;i>0;i--){
			//troca
			long aux = vetor[i];
			vetor[i]=vetor[0];
			vetor[0]=aux;
			maxHeapify(vetor,0,n--);
		}
		
	}
	
	private static void constroiHeapMax(long vetor[]){
		for(int i = (vetor.length/2)-1;i>=0;i--){
			maxHeapify(vetor,i , vetor.length);
		}
	}
	
	private static void maxHeapify(long vetor[],int  posi, int n){
		int maxi;
		int esq = 2*posi+1;
		int direita = 2*posi+2;
		
		if((esq<n) && (vetor[esq]>vetor[posi])){
			maxi = esq;
		}
		else maxi=posi;
		
		if((direita< n) && (vetor[direita]>vetor[maxi])){
			maxi=direita;
		}
		if(maxi != posi){
		  long aux;
			//troca
			  aux=vetor[posi];
			  vetor[posi]=vetor[maxi];
			  vetor[maxi]=aux;
			  maxHeapify(vetor, maxi, n);
		}

	}
	//
	public static void mergeSort(long vetor[], int ini, int fim){
		System.out.println(ini+","+fim);
		if(fim<=ini){
			return;
		}
		
		int meio=(ini+fim)/2;
		
		mergeSort(vetor,ini,meio);
		mergeSort(vetor,meio+1,fim);
		
		long [] tempA = new long[meio-ini+1];
		long [] tempB = new long[fim-meio];
		
		for(int i=0;i <= (meio - ini);i++){
			tempA[i]=vetor[ini+i];
		}
		for(int i=0;i<=fim-meio-1;i++){
			tempB[i]=vetor[meio+1+i];
		}
		
		int i=0;
		int j=0;
		
		for(int k=ini;k<=fim;k++){
			if(i< tempA.length && j< tempB.length){
				if(tempA[i]<tempB[j]){
					vetor[k] = tempA[i++];
				}
				else{
					vetor[k] = tempB[j++];
				}
			}
			else { if(i<tempA.length){
				    vetor[k] = tempA[i++];
			       }
			       else{ if(j<tempB.length){
			    	   vetor[k] = tempB[j++];
			       }
			    	   
			      }
				      
			}
			
		}
		
	}
	public static void verificaOrdenacao(long[] vetor){
		for(int i = 0; i < vetor.length - 2; i++)
			if(vetor[i] > vetor[i+1]){
				System.out.println("N�o Ordenado");
				return;
			}
		System.out.println("Ordenado");
	}
}

