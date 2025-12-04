
/*
    Classe para cadastro de alunos
    Com método polimórfico, input (scanner) de dados e usando métodos de apoio da classe ValidaDados.
*/

package service;

import java.util.Scanner;
import model.Aluno;
import repository.ArmazTemporario;

public class CadastraAluno {
    
    // método polimórfico:
    public static void cadastro(int numero) {
        
        Scanner scan = new Scanner(System.in);
        
        // nome:
        System.out.print("\nNome do aluno: "); 
        String nomeAluno = scan.nextLine();
        
        // matricula:
        int matricula = numero; // matricula recebe valor informado e validado ainda no MenuInterativo
        
        // curso:
        System.out.println("\nCurso do aluno "+nomeAluno+":\n");
        ArmazTemporario.mostraListaCursos();    // mostra lista de cursos salvos no armazenamento temporário em lista
        String texto2 = "ao curso do aluno "+nomeAluno+": ";
        // índice informado passa por método de apoio que evita que índice seja maior que a lista:
        int numeCurso = Apoio.validaDadosArmazenados(texto2, scan, ArmazTemporario.listaCursos);
        // acessa nome do curso com base no número informado pelo usuário:
        String cursoAluno = ArmazTemporario.listaCursos.get(numeCurso).getNomeCurso();

        // login:
        System.out.print("\nLogin: ");
        String loginAluno = scan.nextLine();
        
        // senha:
        System.out.print("Senha: ");
        String senhaAluno = scan.nextLine();

        // tenta a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Aluno:
        try {
            // instanciando objetos Aluno com dados informados e adicionando no armazenamento temporário em lista:
            Aluno aluno = new Aluno(nomeAluno, matricula, cursoAluno, loginAluno, senhaAluno);
            ArmazTemporario.listaAlunos.add(aluno);
            System.out.println("\nAluno "+aluno.getNome()+" foi cadastrado com sucesso.\n\n");
        } 
        // captura exceções lançadas na instancia de objetos:
        catch(NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println("\nFalha ao cadastrar aluno: "+npeOUiae+"\n\n");
        }
    }
}
