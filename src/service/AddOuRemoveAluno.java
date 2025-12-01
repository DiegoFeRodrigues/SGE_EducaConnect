
/*
    Classe para adicionar ou remover alunos de turmas
    Com input (scanner) de dados e usando métodos de apoio da classe TestaDados.
*/

package service;

import java.util.Scanner;
import model.Aluno;
import repository.ArmazTemporario;

public class AddOuRemoveAluno {
    public static void adicionarOuRemover() {

        Scanner scan = new Scanner(System.in);

        System.out.println("\n\n** Adicionar ou remover alunos em turmas **");
        System.out.println("\n1 - Adicionar aluno");
        System.out.println("2 - Remover aluno");
        System.out.print("Informe o número da opção desejada: ");
        TestaDados.testaNumeroMenu(scan);   // testa se valor de menu informado é número inteiro.
        int addOuRemoveAluno = scan.nextInt();
        scan.nextLine();

        // testa se valor informado é maior que as opções disponíveis (1 ou 2):
        while (addOuRemoveAluno <= 0 || addOuRemoveAluno > 2) {
            System.out.println("\nErro: Opção inválida!");
            System.out.println("Digite 1 = Adicionar aluno em turma.");
            System.out.println("Digite 2 = Remover aluno de turma.");
            System.out.print("Opção desejada: ");
            TestaDados.testaNumeroMenu(scan);
            addOuRemoveAluno = scan.nextInt();
            scan.nextLine();
        }
        // turmas:
        System.out.println("\nLista de turmas:\n");
        repository.ArmazTemporario.mostraListaTurmas();     // mostra lista de turmas salvas no armazenamento temporário em lista
        int numTurma = 0;
        String mensagem = "à turma que será alterada: ";
        TestaDados.testaDadosArmazenados(mensagem, scan, numTurma, ArmazTemporario.listaTurmas);
        // busca do objeto Turma do índice informado pelo usuário:
        Turma editarTurma = repository.ArmazTemporario.listaTurmas.get(numTurma);
        
        // alunos:
        System.out.println("\nLista de alunos:\n");
        repository.ArmazTemporario.mostraListaAlunos();     // mostra lista de alunos salvos no armazenamento temporário em lista
        // opção 1 = adicionar aluno:
        if (addOuRemoveAluno == 1) {
            // busca nome do professor do número do objeto turma informado p/ msg personalizada:
            String msg = "ao número do aluno que será associado à turma do professor "+repository.ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+": ";
            int numAlunoAdd = 0;
            // mostra lista de alunos e seus índices e evita que índice informado seja maior que a lista: 
            TestaDados.testaDadosArmazenados(msg, scan, numAlunoAdd, ArmazTemporario.listaAlunos); 
            // busca objeto aluno pelo índice da lista informado:
            Aluno addAluno = repository.ArmazTemporario.listaAlunos.get(numAlunoAdd);
            // ADICIONA aluno buscado na lista de armazenamento, na lista de alunos da turma:
            editarTurma.addAluno(addAluno); 
        } else if (addOuRemoveAluno == 2) {    // opção 2 = remove aluno:
            // busca nome do professor do número do objeto turma informado p/ msg personalizada:
            String msg = "ao número do aluno que será removido da turma do professor "+repository.ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+": ";
            int numAlunoRmve = 0;
            // mostra lista de alunos e seus índices e evita que índice informado seja maior que a lista: 
            TestaDados.testaDadosArmazenados(msg, scan, numAlunoRmve, ArmazTemporario.listaAlunos);
            // busca aluno pelo índice da lista informado:
            Aluno rmveAluno = repository.ArmazTemporario.listaAlunos.get(numAlunoRmve);
            // REMOVE aluno buscado na lista de armazenamento, na lista de alunos da turma:
            editarTurma.removeAluno(rmveAluno);
        }
    }
}
