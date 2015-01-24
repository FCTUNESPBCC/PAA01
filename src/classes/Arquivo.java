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
		for(int i = 0; i < maxElem; i++)
				if(buffReader.ready())
				vetor[i] = Long.parseLong(readLine());	
		fechaArquivoLeitura();
	}
	
	public static void escreve(String text) throws IOException{
		buffWrite.write(text+"\n");
	}
	
	public static String readLine() throws IOException{
		if(buffReader.ready())
			return buffReader.readLine();
		return "";
	}
	
	public static void geraDisplay() throws IOException{
		buffWrite.write("library ieee;\n"
				+ "use ieee.std_logic_1164.all;\n"
				+ "\n"
				+ "entity dec8b is\n"
				+ "\tport(\ta\t\t\t: in std_logic_vector( 7 downto 0);\n"
				+ "\t\t\tx\t\t\t: out std_logic_vector( 20 downto 0)\n"
				+ "\t\t);\n"
				+ "end dec8b;\n"
				+ "\n"
				+ "architecture dec8bBehave of dec8b is\n"
				+ "begin\n"
				+ "\n"
				+ "\n"
				+ "\t x <=\n"
				+ "\n"
				+ "\n");
		int i;
		for(i = 0; i < 256; i++)
			buffWrite.write("\""+getCodigo(i/128)+getCodigo(i/16)+getCodigo(i%16)+"\" when (a = \""+getBin(i)+"\") else\n");
		buffWrite.write("END dec8bBehave;");
	}
	
	private static String getBin(int i){
		String saida = Integer.toString(i, 2);
		while(saida.length()<8)
			saida = "0"+saida;
		return saida;
	}
	
	private static String getCodigo(int valor){
		switch(valor){
		case 0:
			return "0000001";
		case 1:
			return "1001111";
		case 2:
			return "0010010";
		case 3:
			return "0000110";
		case 4:
			return "1001100";
		case 5:
			return "0100100";
		case 6:
			return "0100000";
		case 7:
			return "0001111";
		case 8:
			return "0000000";
		case 9:
			return "0000100";
		case 10:
			return "0001000";
		case 11:
			return "1100000";
		case 12:
			return "0110001";
		case 13:
			return "1000010";
		case 14:
			return "0110000";
		case 15:
			return "0111000";
		}
		return "";
	}
	
}
