
/*
    Classe para cadastro de alunos
    Com método polimórfico, input (scanner) de dados e usando métodos de apoio da classe TestaDados.
*/

package service;

import java.util.Scanner;
import model.Aluno;
import repository.ArmazTemporario;

public class CadastraAluno {
    
    // método polimórfico:
    public static void cadastro() {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n\n** Cadastro de aluno **");
        System.out.println("\nInforme os dados do aluno:");
        
        // nome:
        System.out.print("Nome: "); 
        String nomeAluno = scan.nextLine();
        
        // matricula:
        System.out.print("Matrícula: ");
        String testaMatricula = "a matrícula do aluno "+nomeAluno+": ";
        ValidaDados.validaNumeroDados(scan, testaMatricula);  // testa se valor de matrícula informada é número inteiro.
        int matricula = scan.nextInt();
        scan.nextLine();
        
        // curso:
        System.out.println("\nCursos cadastrados:\n");
        ArmazTemporario.mostraListaCursos();    // mostra lista de cursos salvos no armazenamento temporário em lista
        String mensagem = "ao curso do aluno "+nomeAluno+": ";
        // índice informado passa por método de apoio que evita que índice seja maior que a lista:
        int numeCurso = ValidaDados.validaDadosArmazenados(mensagem, scan, ArmazTemporario.listaCursos);
        // acessa nome do curso com base no número informado pelo usuário:
        String cursoAluno = ArmazTemporario.listaCursos.get(numeCurso).getNomeCurso();

        // login:
        System.out.print("\nLogin: ");
        String loginAluno = scan.nextLine();
        
        // senha:
        System.out.print("Senha: ");
        String senhaAluno = scan.nextLine();

        // testa a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Aluno:
        try {
            // instanciando objetos Aluno com dados informados e adicionando no armazenamento temporário em lista:
            Aluno aluno = new Aluno(nomeAluno, matricula, cursoAluno, loginAluno, senhaAluno);
            ArmazTemporario.listaAlunos.add(aluno);
            System.out.println("\nAluno "+aluno.getNome()+" foi cadastrado com sucesso.\n\n");
        } 
        // captura exceções lançadas na instancia de objetos:
        catch(NullPointerException | IllegalArgumentException npe) {
            System.err.println("\nFalha ao cadastrar aluno: "+npe+"\n\n");
        }
    }
}
