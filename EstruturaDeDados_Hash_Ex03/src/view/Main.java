package view;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import controller.CtrlPessoas;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CtrlPessoas controle=new CtrlPessoas();
		
		Map<Integer, List<String>> pessoasList=new HashMap<>();
		System.out.println("Qnt de nomes para armazenar: ");
		int tamanhoMatriz=sc.nextInt();
		int qntNomesNaLista=tamanhoMatriz;
		for(int i=1;i<=tamanhoMatriz;i++) {
			controle.inserirNome(pessoasList);
		}
		
		
		int opcao=1;
		String msg;
		String controleNome;
		while(opcao>0 && opcao<6) {
	    	System.out.println("Selecione:\r\n"
	    			+ "1)inserir um novo nome na estrutura de dados\r\n"
		    		+ "2)pesquisar se um determinado nome consta na estrutura de dados\r\n"
		    		+ "3)remover um dado nome da estrutura de dados\r\n"
		    		+ "4)verificar se a estrutura de dados está cheia\r\n"
		    		+ "5)imprimir todos os dados da estrutura de dados\r\n"
		    		+ "qualquer numero)Fim");
		    opcao=sc.nextInt();
		    switch (opcao) {
			case 1:
				if(tamanhoMatriz>qntNomesNaLista) {
					controle.inserirNome(pessoasList); 
					qntNomesNaLista+=1;
				}else {
					System.out.println("O hash esta cheio!!!");
				}
				 break;
			case 2:
				System.out.println("Nome que deseja pesquisar?");
				controleNome=sc.next();
				System.out.println(CtrlPessoas.pesquisarNome(pessoasList, controleNome)); 
				break;
			case 3:
				System.out.println("Nome que deseja retirar:");
				controleNome=sc.next();
				msg=controle.remover(pessoasList,controleNome);
				System.out.println(msg);
				if(msg.equals("Nome removido!")) {
					qntNomesNaLista-=1;
				}
				break;
			case 4:
				System.out.println(controle.verificarCheia(qntNomesNaLista,tamanhoMatriz)); break;
			case 5:
				controle.imprimir(pessoasList); break;
			default:
				break;
			}
	    }
	}
}
