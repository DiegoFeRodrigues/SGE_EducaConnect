
/*
    Classe para cadastro de alunos
    Com método polimórfico, input (scanner) de dados e usando métodos de apoio da classe Apoio.
*/

package service;

import java.util.Scanner;
import model.Aluno;
import repository.ArmazTemporario;

public class CadastraAluno {
    
    // método polimórfico:
    public static void cadastro(int numero) {
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("\n\n****  Cadastro de aluno(a)  ****");
        System.out.println("---------------------------------------");        

        // nome:
        System.out.print("\nNome do(a) aluno(a): "); 
        String nomeAluno = scan.nextLine();
        
        // matricula:
        int matricula = numero; // matricula recebe valor informado e validado ainda no MenuInterativo
        
        // curso:
        System.out.println("\n\nCursos disponíveis para matrícula:\n");
        ArmazTemporario.mostraListaCursos();    // mostra lista de cursos salvos no armazenamento temporário em lista
        String texto2 = "ao curso desejado: ";
        // índice informado passa por método de apoio que evita que índice seja maior que a lista, retornando valor:
        int numeCurso = Apoio.validaDadosArmazenados(texto2, scan, ArmazTemporario.listaCursos);
        // acessa nome do curso com base no número informado pelo usuário:
        String cursoAluno = ArmazTemporario.listaCursos.get(numeCurso).getNomeCurso();

        // login:
        System.out.println("\n\n** Dados de login: **");
        System.out.print("\nDigite o Login: ");
        String loginAluno = scan.nextLine();
        
        // senha:
        System.out.print("\nDigite a Senha: ");
        String senhaAluno = scan.nextLine();

        // tenta a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Aluno:
        try {
            // instanciando objetos Aluno com dados informados e adicionando no armazenamento temporário em lista:
            Aluno aluno = new Aluno(nomeAluno, matricula, cursoAluno, loginAluno, senhaAluno);
            ArmazTemporario.listaAlunos.add(aluno);
            System.out.println("\n\nAluno(a) cadastrado com sucesso.");
            System.out.println("\nBem vindo(a) "+aluno.getNome()+".\n\n");
        } 
        // captura exceções lançadas na instancia de objetos:
        catch(NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println("\nFalha ao cadastrar aluno(a): "+npeOUiae+"\n\n");
        }
    }
}
