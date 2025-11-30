
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
        TestaDados.testaNumeroDados(scan, testaTurma);      // -> testa se valor de código informado é número inteiro.
        int codigoTurma = scan.nextInt();
        scan.nextLine();
        
        int numCurso = scan.nextInt();
        TestaDados.testaCursosArmazenados(scan, numCurso);
        
        // System.out.println("\nLista de cursos:\n");
        // repository.ArmazTemporario.mostraListaCursos();
        // System.out.print("\nInforme o número do curso dessa turma: ");
        // TestaDados.testaNumeroMenu(scan);
        // int numCurso = scan.nextInt();
        // while (numCurso >= repository.ArmazTemporario.listaCursos.size()) {
        //     System.out.println("\nErro: Opção inválida");
        //     scan.nextLine();
        //     System.out.print("Confira a lista de cursos acima e digite o número do curso que será lecionado na turma "+codigoTurma+": ");
        //     TestaDados.testaNumeroMenu(scan);
        //     numCurso = scan.nextInt();
        // }
        System.out.println("\n\nCurso de "+repository.ArmazTemporario.listaCursos.get(numCurso).getNomeCurso()+" cadastrado na turma "+codigoTurma+".\n");
        scan.nextLine();
        
        System.out.println("\nLista de professores:\n");
        repository.ArmazTemporario.mostraListaProf();
        System.out.print("\nInforme o número do professor dessa turma: ");
        TestaDados.testaNumeroMenu(scan);
        int numProf = scan.nextInt();
        while (numProf >= repository.ArmazTemporario.listaProf.size()) {
            System.out.println("\nErro: Opção inválida");
            scan.nextLine();
            System.out.print("Confira a lista de professores acima e digite o número do professor dará aulas para a turma "+codigoTurma+": ");
            TestaDados.testaNumeroMenu(scan);
            numProf = scan.nextInt();
        }
        System.out.println("\n\nProfessor "+repository.ArmazTemporario.listaProf.get(numCurso).getNome()+" cadastrado na turma "+codigoTurma+".\n");
        
        Curso cursoTurma = repository.ArmazTemporario.listaCursos.get(numCurso);
        Professor profTurma = repository.ArmazTemporario.listaProf.get(numProf);
        
        Turma turma = new Turma(codigoTurma, cursoTurma, profTurma);
        
        repository.ArmazTemporario.listaTurmas.add(turma);
        System.out.println("\nTurma do curso de "+cursoTurma.getNomeCurso()+" do professor "+profTurma.getNome()+" foi criada com sucesso.\n\n\n");
    }
}
