package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class LerArquivo {
	public static void main(String[] args) {
		
		Pilha pilha = new Pilha();

	    try {
	    	
	      FileReader arq = new FileReader("prog.txt");
	      BufferedReader lerArq = new BufferedReader(arq);      
	      String validacao="";
	      String linha = lerArq.readLine();
	      FileWriter arqW = new FileWriter("prog-check.txt");
	      PrintWriter gravarArq = new PrintWriter(arqW);
	     
	      while (linha != null) {
	    	  
	    	  int tamlinha=linha.length();
	    	  
	    	  for(int i=0;i<tamlinha;i++)
	    	  {
	    		  if(linha.charAt(i)=='(' || linha.charAt(i)=='{' || linha.charAt(i)=='[' ||linha.charAt(i)=='<')
	    		  {
	    			  pilha.empilhar(linha.charAt(i));	
	    		  }
	    		  else if(pilha.pilhaVazia()==false)
	    		  {
	    			  if(linha.charAt(i)==')' && pilha.exibeUltimoValor()=='(')
	    			  {
	    				  pilha.desempilhar();
	    			  }
		    		  else if(linha.charAt(i)=='}' && pilha.exibeUltimoValor()=='{')
		    		  {
		    			  pilha.desempilhar();
		    		  }
		    		  else if(linha.charAt(i)==']' && pilha.exibeUltimoValor()=='[')
		    		  {
		    			  pilha.desempilhar();
		    		  }
		    		  else if(linha.charAt(i)=='>' && pilha.exibeUltimoValor()=='<')
		    		  {
		    			  pilha.desempilhar();
		    		  }
		    		  else
		    		  {
		    			  validacao=" - Inválido";
		    			  pilha.limparPilha();
		    			  break;
		    		  }
	    		  }
	    		  else
	    		  {
	    			  validacao=" - Inválido";
	    			  pilha.limparPilha();
	    			  break;
	    		  }
	    		
	    		  if(i==tamlinha-1 && pilha.pilhaVazia()==true)
	    		  {
	    			  validacao=" - OK";	    	
	    		  }
	    		  if(i==tamlinha-1 && pilha.pilhaVazia()==false)
	    		  {
	    			  validacao=" - Inválido";	    	
	    		  }	    		  	    		  
	    		  
	    	  }
	    	  
	    	  gravarArq.printf(linha+validacao+"%n");   	  
	    	  pilha.limparPilha();
	    	  linha = lerArq.readLine();
	        
	      }
	      System.out.print("concluido");
	      arq.close();
	      arqW.close();
	      
	    } catch (IOException e) {
	        System.err.printf("Erro na abertura do arquivo: %s.\n",
	          e.getMessage());
	    }

	    System.out.println();
	    
	  }

}
