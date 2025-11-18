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
              
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("Menu Interativo:");
            System.out.println("1 - Cadastrar aluno");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = scan.nextLine();
                    System.out.print("Matrícula: ");
                    int matricula = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Curso: ");
                    String cursoAluno = scan.nextLine();
                    System.out.print("Login: ");
                    String login = scan.nextLine();
                    System.out.print("Senha: ");
                    String senha = scan.nextLine();
                    Aluno aluno = new Aluno(nomeAluno, matricula, cursoAluno, login, senha);
                    salvaDados.listaAlunos.add(aluno);
                    break;
                    
                }
            } while (opcao != 4); 
        
        // System.out.println("getLista da classe MenuInterativo: "+ armazenaAluno.getListaAlunos());

            
            
    }
}
