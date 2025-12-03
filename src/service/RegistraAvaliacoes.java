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
        String msg1 = "à turma do aluno que receberá a nota: ";
        int numTurmaAv = ValidaDados.validaDadosArmazenados(msg1, scan, ArmazTemporario.listaTurmas);
        
        // aluno:
        System.out.println("\n\nLista de alunos:\n");
        ArmazTemporario.mostraListaAlunos();
        String msg2 = "ao aluno que receberá a nota: ";
        int numAlunoAvaliado = ValidaDados.validaDadosArmazenados(msg2, scan, ArmazTemporario.listaAlunos);
        
        // busca objetos de turma e aluno do índice informado:
        Aluno alunoAvaliacao = repository.ArmazTemporario.listaAlunos.get(numAlunoAvaliado);
        Turma turmaAvaliacao = repository.ArmazTemporario.listaTurmas.get(numTurmaAv);
        
        // nota:
        System.out.print("\n\nInforme a nota do aluno "+alunoAvaliacao.getNome()+": ");
        while (!scan.hasNextFloat()) {
            System.out.println("\nValor de nota incorreto!");
            System.out.print("Informe a nota do aluno "+alunoAvaliacao.getNome()+": ");
            scan.nextLine();
            if (scan.hasNextFloat()) {
                System.out.println("");
            }
        }
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
