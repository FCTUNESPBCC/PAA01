package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {

	private static File arquivo;
	private static BufferedWriter buffWrite;
	private static BufferedReader buffReader;
	
	public static void abreArquivoEscrita() throws IOException{
		if(!arquivo.exists())
			arquivo.createNewFile();
		buffWrite = new BufferedWriter(new FileWriter(arquivo.getAbsoluteFile()));
	}
	
	public static void fechaArquivoEscrita() throws IOException{
		buffWrite.close();
	}
	
	public static void abreArquivoLeitura() throws IOException{
		if(!arquivo.exists())
			arquivo.createNewFile();
		buffReader = new BufferedReader(new FileReader(arquivo.getAbsoluteFile()));
	}
	
	public static void fechaArquivoLeitura() throws IOException{
		buffReader.close();
	}
	
	public static void setArquivo(String arquivo){
		Arquivo.arquivo = new File(arquivo);
	}
	
	public static void getElements(long vetor[], int maxElem) throws IOException{
		abreArquivoLeitura();
		for(int j = 0; j < 10; j++)
			for(int i = 0; i < 50000; i++)
				vetor[j*50000+i] = Long.parseLong(readLine());	
		fechaArquivoLeitura();
	}
	
	public static void escreve(String text) throws IOException{
		buffWrite.write(text);
	}
	
	public static String readLine() throws IOException{
		if(buffReader.ready())
			return buffReader.readLine();
		return "";
	}
	
}
