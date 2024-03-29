package Pilhas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class mainPilhaListLigada {

	public static void main(String[] args) {
		long milisInicial = System.currentTimeMillis();
		Integer[] executados = new Integer[1000000];
		Integer[] tarefas = ler();
		Stack<Integer> lista = new NodeStack<Integer>();
		int s = 0;
		for(int i = 0; tarefas[i] != null; i++) {
			if(tarefas[i] != -1) {
				lista.push(tarefas[i]);
			}else {
				executados[s] = lista.pop();
				s++;
			}
		}
		
		File saida = new File("saida.txt");
		try {
			saida.createNewFile();
		} catch (IOException ex) {
			
		}
		try {
		FileWriter out = new FileWriter(saida);
		BufferedWriter buffwrite = new BufferedWriter(out);

		for(int i = 0; i < executados.length && executados[i] != null; i++) {
			String impresso = String.valueOf(executados[i]);
			buffwrite.write(impresso);
			buffwrite.newLine();
			buffwrite.flush();
		}
		buffwrite.close();
		out.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		long milisFinal = System.currentTimeMillis();
		System.out.println(milisFinal - milisInicial);
	}

private static Integer[] ler(){
	Integer[] pegaValores = new Integer[1000000];
	try {
		FileReader arquivo = new FileReader("C:\\Users\\Daniel\\eclipse-workspace\\AEDI(2020)-EP1\\src\\entradas\\tarefas1000.txt");
		BufferedReader buffread = new BufferedReader(arquivo);
	 
		String linha;
		int j = 0;
		while ((linha = buffread.readLine()) != null) {
			if(linha.trim().length() != 0) {
				int num = Integer.parseInt(linha);
				pegaValores[j] = num;
				j++;
			}else {
				pegaValores[j] = -1;
				j++;
			}
		}
		buffread.close();
		arquivo.close();
	} catch (FileNotFoundException ex) {
		ex.printStackTrace();
	} catch (IOException ex) {
		ex.printStackTrace();
	}
	return pegaValores;
}
}