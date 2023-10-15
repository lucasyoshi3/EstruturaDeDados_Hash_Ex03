package controller;
import java.util.*;

public class CtrlPessoas {
	
	public static int qntDeLetras(String nome){
		return (nome.toCharArray()).length;
	}
	
	public static void addPessoa(Map<Integer, List<String>> pessoa,String nome, int id) {
		List<String> pessoaList=pessoa.getOrDefault(id, new ArrayList<>());
		pessoaList.add(nome);
		pessoa.put(id,pessoaList);
	}
	
	public void inserirNome(Map<Integer, List<String>> pessoasList) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Inserir nome no hash:");
		String nome=sc.next();
		addPessoa(pessoasList, nome, qntDeLetras(nome));
	}

	public static String pesquisarNome(Map<Integer, List<String>> pessoasList, String nome) {
		// TODO Auto-generated method stub
		int id=qntDeLetras(nome);
		List<String> pesquisar;
		if(pessoasList.get(id)!=null) {
			pesquisar=pessoasList.get(id);	
		}else {
			return "O nome nao esta na lista";
		}
		
		if(pesquisar.contains(nome)) {
			return "O nome esta na lista";
		}else {
			return "O nome nao esta na lista";
		}
	}

	public static String remover(Map<Integer, List<String>> pessoasList, String nome) {
		// TODO Auto-generated method stub
		int id=qntDeLetras(nome);
		List<String>listaComNomeRemovido;
		if(pessoasList.get(id)!=null) {
			listaComNomeRemovido=pessoasList.get(id);
		}else {
			return"Nao existe esse nome na lista";
		}
		
		if(!listaComNomeRemovido.contains(nome)) {
			return"Nao existe esse nome na lista";
		}
		
		listaComNomeRemovido.remove(nome);
		if(listaComNomeRemovido.isEmpty()) {
			pessoasList.remove(id);
		}else {
			pessoasList.put(id,listaComNomeRemovido);
		}	
		return "Nome removido!";
	}

	public String verificarCheia(int qntDeNomes, int tamanhoDaMatriz) {
		// TODO Auto-generated method stub
		if(qntDeNomes==tamanhoDaMatriz) return "A matriz esta cheia";
		return "A matriz nao esta cheia";
	}

	public void imprimir(Map<Integer, List<String>> pessoasList) {
		// TODO Auto-generated method stub
		System.out.println(pessoasList);
	}

}
