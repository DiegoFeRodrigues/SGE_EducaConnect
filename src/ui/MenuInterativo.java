package ui;

import java.util.Scanner;

import model.Aluno;
import repository.ArmazTemporario;

public class MenuInterativo {
    
    private ArmazTemporario salvaDados;

    public MenuInterativo(ArmazTemporario dados) {
        this.salvaDados = dados;
    }

    public void Menu() {
              
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Menu Interativo:");
            System.out.println("1 - Cadastrar aluno");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Nome do aluno:");
                    String nomeAluno = scanner.nextLine();
                    System.out.println("Matrícula:");
                    int matricula = scanner.nextInt();
                    System.out.println("Curso:");
                    String cursoAluno = scanner.nextLine();
                    scanner.nextLine();
                    System.out.println("Login:");
                    String login = scanner.nextLine();
                    System.out.println("Senha:");
                    String senha = scanner.nextLine();
                    Aluno aluno = new Aluno(nomeAluno, matricula, cursoAluno, login, senha);
                    salvaDados.listaAlunos.add(aluno);
                    break;
                    
                }
            } while (opcao != 4); 
        
        // System.out.println("getLista da classe MenuInterativo: "+ armazenaAluno.getListaAlunos());

            
            
    }
}
