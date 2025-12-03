package service;

import java.util.Scanner;

import model.Aluno;
import repository.ArmazTemporario;

public class RegistraAvaliacoes {
    public static void registrar() {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n** Avaliações **");
        System.out.println("\nInforme os dados da avaliação: ");
        System.out.print("Descrição da avaliação: ");
        String descricao = scan.nextLine();

        
        // turma:
        System.out.println("\n\nLista de turmas:\n");
        ArmazTemporario.mostraListaTurmas();
        String texto1 = "à turma do aluno que receberá a nota: ";
        int numTurmaAv = ValidaDados.validaDadosArmazenados(texto1, scan, ArmazTemporario.listaTurmas);
        
        // aluno:
        System.out.println("\n\nLista de alunos:\n");
        ArmazTemporario.mostraListaAlunos();
        String texto2 = "ao aluno que receberá a nota: ";
        int numAlunoAvaliado = ValidaDados.validaDadosArmazenados(texto2, scan, ArmazTemporario.listaAlunos);
        
        // busca objetos de turma e aluno do índice informado:
        Aluno alunoAvaliacao = repository.ArmazTemporario.listaAlunos.get(numAlunoAvaliado);
        Turma turmaAvaliacao = repository.ArmazTemporario.listaTurmas.get(numTurmaAv);
        
        // nota:
        String texto3 = "a nota do aluno "+alunoAvaliacao.getNome()+": ";
        ValidaDados.validaNumeroReal(scan, texto3); // valida número real digitado, não permitindo letras
        float notaAluno = scan.nextFloat();

        try {
            Avaliacao avaliacao = new Avaliacao(descricao);
            // método atribuirNota recebe objetos buscados e nota:
            avaliacao.atribuirNota(alunoAvaliacao, turmaAvaliacao, notaAluno);
            repository.ArmazTemporario.listaAvaliacoes.add(avaliacao);

            System.out.println("\n\nAvaliação registrada.\n");
            System.out.println("\nNota adicionada ao aluno "+alunoAvaliacao.getNome()+" na avaliação "+avaliacao.getDescricao()+".\n\n");
        }

        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println("\nFalha ao registrar avaliação: "+npeOUiae);
        }
    }
}
