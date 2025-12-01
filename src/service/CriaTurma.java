
/*
    Classe para criação de turmas
    Com input (scanner) de dados e usando métodos de apoio da classe TestaDados.
*/

package service;

import java.util.Scanner;

import model.Curso;
import model.Professor;

public class CriaTurma {

    public static void criar() {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n** Criação de turmas **");
        System.out.println("\nInforme os dados da turma:");

        // código:
        System.out.print("Código da turma: ");
        String testaTurma = "o código da turma: ";
        TestaDados.testaNumeroDados(scan, testaTurma);      // testa se valor de código informado é número inteiro.
        int codigoTurma = scan.nextInt();
        scan.nextLine();

        // curso:
        int numCurso = 0;
        String mensagem = "da turma "+codigoTurma+": ";
        TestaDados.testaCursosArmazenados(scan, mensagem, numCurso);  // mostra lista de cursos e evita que número do índice informado seja maior que a lista

        // saída acessando nome do curso do índice informado pelo usuário:
        System.out.println("\n\nCurso de "+repository.ArmazTemporario.listaCursos.get(numCurso).getNomeCurso()+" cadastrado na turma "+codigoTurma+".\n");

        // professor:
        System.out.println("\nLista de professores:\n");
        repository.ArmazTemporario.mostraListaProf();   // mostra lista de cursos salvos no armazenamento temporário em lista
        
        System.out.print("\nInforme o número do professor dessa turma: ");
        TestaDados.testaNumeroMenu(scan);   // testa se valor digitado é número inteiro
        int numProf = scan.nextInt();

        // testa se número do índice do professor informado é maior que a lista:
        while (numProf >= repository.ArmazTemporario.listaProf.size()) {
            System.out.println("\nErro: Opção inválida");
            scan.nextLine();
            System.out.print("Confira a lista de professores acima e digite o número do professor que dará aulas para a turma "+codigoTurma+": ");
            TestaDados.testaNumeroMenu(scan);
            numProf = scan.nextInt();
        }
        // saída acessando nome do professor do índice informado pelo usuário:
        System.out.println("\n\nProfessor "+repository.ArmazTemporario.listaProf.get(numCurso).getNome()+" cadastrado na turma "+codigoTurma+".\n");
        
        // buscando objetos de Curso e Professor dos índices informados pelo usuário:
        Curso cursoTurma = repository.ArmazTemporario.listaCursos.get(numCurso);
        Professor profTurma = repository.ArmazTemporario.listaProf.get(numProf);
        
        // testa a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Turma:
        try {
            // instanciando objeto de Turma com objetos buscados e salvando no armazenamento temporário em lista:
            Turma turma = new Turma(codigoTurma, cursoTurma, profTurma);
            repository.ArmazTemporario.listaTurmas.add(turma);

            // saída de sucesso na criação da turma:
            System.out.println("\nTurma do curso de "+cursoTurma.getNomeCurso()+" do professor "+profTurma.getNome()+" foi criada com sucesso.\n\n\n");
        }
        // captura exceções lançadas na instancia de objetos:
        catch(NullPointerException npe) {
            System.err.println("Falha ao criar turma: "+npe);
        }
    }
}
