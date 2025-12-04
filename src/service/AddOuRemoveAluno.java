
/*
    Classe para adicionar ou remover alunos de turmas
    Com input (scanner) de dados e usando métodos de apoio da classe ValidaDados.
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
        
        // tratando se usuário digita apenas as opções disponíveis (1 ou 2):
        String msg1 = "à opção desejada: ";
        String msg2 = "Digite 1 = Cadastrar curso EAD.\nDigite 2 = Cadastrar curso Presencial.";
        int addOuRemoveAluno = Apoio.validaMenu1ou2(scan, msg1, msg2);
        
        // turmas:
        System.out.println("\nLista de turmas:\n");
        repository.ArmazTemporario.mostraListaTurmas();  // mostra lista de turmas salvas no armazenamento temporário em lista
        String mensagem = "à turma que será alterada: ";
        // índice informado passa por método de apoio que evita que índice seja maior que a lista:
        int numTurma = Apoio.validaDadosArmazenados(mensagem, scan, ArmazTemporario.listaTurmas);
        // busca o objeto Turma do índice informado pelo usuário:
        Turma editarTurma = repository.ArmazTemporario.listaTurmas.get(numTurma);
        
        // alunos:
        System.out.println("\nLista de alunos:\n");
        repository.ArmazTemporario.mostraListaAlunos();  // mostra lista de alunos salvos no armazenamento temporário em lista
        // opção 1 = adicionar aluno:
        if (addOuRemoveAluno == 1) {
            // msg personalizada buscando nome do professor do número do objeto turma informado:
            String msg = "ao número do aluno que será associado à turma do professor "+repository.ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+": ";
            // índice informado passa por método de apoio que evita que índice seja maior que a lista:
            int numAlunoAdd = Apoio.validaDadosArmazenados(msg, scan, ArmazTemporario.listaAlunos); 
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
            int numAlunoRmve = Apoio.validaDadosArmazenados(msg, scan, ArmazTemporario.listaAlunos);
            // busca aluno pelo índice da lista informado:
            Aluno rmveAluno = repository.ArmazTemporario.listaAlunos.get(numAlunoRmve);
            // REMOVE aluno buscado na lista de armazenamento, da lista de alunos da turma:
            editarTurma.removeAluno(rmveAluno);
        }
    }
}
