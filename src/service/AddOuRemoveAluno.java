
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
        String mensagem = "à turma que será alterada: ";

        // índice informado passa por método de apoio que evita que índice seja maior que a lista:
        int numTurma = TestaDados.testaDadosArmazenados(mensagem, scan, ArmazTemporario.listaTurmas);
        
        // busca do objeto Turma do índice informado pelo usuário:
        Turma editarTurma = repository.ArmazTemporario.listaTurmas.get(numTurma);
        
        // alunos:
        System.out.println("\nLista de alunos:\n");
        repository.ArmazTemporario.mostraListaAlunos();     // mostra lista de alunos salvos no armazenamento temporário em lista
        // opção 1 = adicionar aluno:
        if (addOuRemoveAluno == 1) {
            // msg personalizada buscando nome do professor do número do objeto turma informado:
            String msg = "ao número do aluno que será associado à turma do professor "+repository.ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+": ";
            
            // índice informado passa por método de apoio que evita que índice seja maior que a lista:
            int numAlunoAdd = TestaDados.testaDadosArmazenados(msg, scan, ArmazTemporario.listaAlunos); 
            
            // busca objeto aluno pelo índice da lista informado:
            Aluno addAluno = repository.ArmazTemporario.listaAlunos.get(numAlunoAdd);
            
            // ADICIONA aluno buscado na lista de armazenamento, na lista de alunos da turma:
            editarTurma.addAluno(addAluno); 
        } 
        // opção 2 = remove aluno:
        if (addOuRemoveAluno == 2) {    
            // msg personalizada buscando nome do professor do número do objeto turma informado:
            String msg = "ao número do aluno que será removido da turma do professor "+repository.ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+": ";
            
            // índice informado passa por método de apoio que evita que índice seja maior que a lista:
            int numAlunoRmve = TestaDados.testaDadosArmazenados(msg, scan, ArmazTemporario.listaAlunos);

            // busca aluno pelo índice da lista informado:
            Aluno rmveAluno = repository.ArmazTemporario.listaAlunos.get(numAlunoRmve);

            // REMOVE aluno buscado na lista de armazenamento, na lista de alunos da turma:
            editarTurma.removeAluno(rmveAluno);
        }
    }
}
