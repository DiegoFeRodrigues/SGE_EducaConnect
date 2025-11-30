
/*
    Classe para cadastro de alunos
    Com input (scanner) de dados e usando métodos de apoio da classe TestaDados para testar e validar dados informados. 
*/

package service;

import java.util.Scanner;
import model.Aluno;
import repository.ArmazTemporario;

public class CadastraAluno {
    
    public static void cadastraAluno() {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n\n** Cadastro de aluno **");
        System.out.println("\nInforme os dados do aluno:");
        
        // nome:
        System.out.print("Nome: "); 
        String nomeAluno = scan.nextLine();
        
        // matricula:
        System.out.print("Matrícula: ");
        String testaMatricula = "a matrícula do aluno: ";
        TestaDados.testaNumeroDados(scan, testaMatricula);  // -> testa se valor informado é número inteiro.
        int matricula = scan.nextInt();
        scan.nextLine();
        
        // curso:
        TestaDados.testaCursosArmazenados(scan);    // -> mostra lista de cursos e evita que número informado seja maior que a lista
        int numeCurso = scan.nextInt();
        scan.nextLine();
        // acessa nome do curso com base no número informado pelo usuário:
        String cursoAluno = ArmazTemporario.listaCursos.get(numeCurso).getNomeCurso();

        // login:
        System.out.print("Login: ");
        String loginAluno = scan.nextLine();
        
        // senha:
        System.out.print("Senha: ");
        String senhaAluno = scan.nextLine();

        // testa a validação dos dados informados conforme exceções tratadas no construtor 
        try {
            Aluno aluno = new Aluno(nomeAluno, matricula, cursoAluno, loginAluno, senhaAluno);
            ArmazTemporario.listaAlunos.add(aluno);
            System.out.println("\nAluno "+aluno.getNome()+" foi cadastrado com sucesso.\n\n");
        } 
        // captura exceções:
        catch(NullPointerException npe) {
            System.err.println("\nFalha ao cadastrar aluno: "+npe+"\n\n");
        }
    }
}
