package service;

import java.util.Scanner;

import model.Aluno;
import repository.ArmazTemporario;

public class RegistraAvaliacoes {
    public static void registrar() {

        Scanner scan = new Scanner(System.in);

        // descrição:
        System.out.println("\n\n** Avaliações **");
        System.out.println("\nInforme os dados da avaliação: ");
        System.out.print("Descrição da avaliação: ");
        String descricao = scan.nextLine();

        // turma:
        System.out.println("\n\nLista de turmas:\n");
        ArmazTemporario.mostraListaTurmas();
        String texto1 = "à turma do aluno que receberá a nota: ";
        int numTurmaAv = Apoio.validaDadosArmazenados(texto1, scan, ArmazTemporario.listaTurmas);
        
        // aluno:
        System.out.println("\n\nLista de alunos:\n");
        ArmazTemporario.mostraListaAlunos();
        String texto2 = "ao aluno que receberá a nota: ";
        int numAlunoAvaliado = Apoio.validaDadosArmazenados(texto2, scan, ArmazTemporario.listaAlunos);
        
        // busca objetos de turma e aluno dos índices informados:
        Aluno alunoAvaliacao = repository.ArmazTemporario.listaAlunos.get(numAlunoAvaliado);
        Turma turmaAvaliacao = repository.ArmazTemporario.listaTurmas.get(numTurmaAv);
        
        // nota:
        String texto3 = "a nota do aluno "+alunoAvaliacao.getNome()+": ";
        Apoio.validaNumeroReal(scan, texto3); // valida número real digitado, não permitindo letras
        float notaAluno = scan.nextFloat();

        // tenta a validação dos dados informados (atributos) conforme exceções tratadas no construtor da classe Avaliacao:
        try {
            Avaliacao avaliacao = new Avaliacao(descricao);
            // método atribuirNota recebe objetos buscados e nota:
            avaliacao.atribuirNota(alunoAvaliacao, turmaAvaliacao, notaAluno);
            
            // adiciona avaliação no armazenamento temporário em lista.
            repository.ArmazTemporario.listaAvaliacoes.add(avaliacao);

            System.out.println("\n\nAvaliação registrada.\n");
            System.out.println("\nNota adicionada ao aluno "+alunoAvaliacao.getNome()+" na avaliação "+avaliacao.getDescricao()+".\n\n");
        }
        // captura exceções lançadas na instancia de objetos:
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println("\nFalha ao registrar avaliação: "+npeOUiae);
        }
    }
}
