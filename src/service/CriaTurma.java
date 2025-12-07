
/*
    Classe para criação de turmas
    Com input (scanner) de dados e usando métodos de apoio da classe Apoio.
*/

package service;

import java.util.Scanner;

import model.Curso;
import model.Professor;
import repository.ArmazTemporario;

public class CriaTurma {

    public static void criar(int numero) {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n** Criação de turmas **");
        System.out.println("\nInforme os dados da turma:");

        // código:
        int codigoTurma = numero;

        // curso:
        System.out.println("\n\nCurso da turma:\n");
        ArmazTemporario.mostraListaCursos();    // mostra lista de cursos salvos no armazenamento temporário em lista
        String mensagem = "ao curso da Turma "+codigoTurma+": ";
        // índice informado passa por método de apoio que evita que índice seja maior que a lista, retornando valor:
        int numCurso = Apoio.validaDadosArmazenados(mensagem, scan, ArmazTemporario.listaCursos);
        // saída de sucesso acessando nome do curso do índice informado pelo usuário:
        System.out.println("\n\nCurso de "+repository.ArmazTemporario.listaCursos.get(numCurso).getNomeCurso()+" cadastrado na turma "+codigoTurma+".\n");
        
        // professor:
        System.out.println("\nLista de professores:\n");
        ArmazTemporario.mostraListaProf();   // mostra lista de professores salvos no armazenamento temporário em lista
        String msg = "ao professor da Turma "+codigoTurma+": ";
        // índice informado passa por método de apoio que evita que índice seja maior que a lista, retornando valor:
        int numProf = Apoio.validaDadosArmazenados(msg, scan, ArmazTemporario.listaProf);
        // saída acessando nome do professor do índice informado pelo usuário:
        System.out.println("\n\nProfessor "+repository.ArmazTemporario.listaProf.get(numProf).getNome()+" cadastrado na turma "+codigoTurma+".\n");
        
        // busca de objetos de Curso e Professor dos índices informados pelo usuário:
        Curso cursoTurma = ArmazTemporario.listaCursos.get(numCurso);
        Professor profTurma = ArmazTemporario.listaProf.get(numProf);
        
        // testa a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Turma:
        try {
            // instanciando objeto de Turma com objetos buscados e salvando no armazenamento temporário em lista:
            Turma turma = new Turma(codigoTurma, cursoTurma, profTurma);
            ArmazTemporario.listaTurmas.add(turma);
            // saída de sucesso na criação da turma:
            System.out.println("\n\nTurma do curso de "+cursoTurma.getNomeCurso()+" do professor "+profTurma.getNome()+" foi criada com sucesso.\n");
        }
        // captura exceções lançadas na instancia de objetos:
        catch(NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println("Falha ao criar turma: "+npeOUiae);
        }
    }
}