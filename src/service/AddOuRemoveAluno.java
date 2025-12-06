
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
        System.out.println("\n1 - Adicionar aluno(a)");
        System.out.println("2 - Remover aluno(a)");
        
        // Trata se valor digitado está entre as opções disponíveis (1 ou 2) e retorna valor:
        String msg1 = "à opção desejada: ";
        String msg2 = "Digite 1 = Adicionar aluno(a).\nDigite 2 = Remover aluno(a).";
        int addOuRemoveAluno = Apoio.validaMenu1ou2(scan, msg1, msg2);
        
        // turmas:
        System.out.println("\nLista de turmas:\n");
        ArmazTemporario.mostraListaTurmas();  // mostra lista de turmas salvas no armazenamento temporário em lista
        String mensagem = "à turma que será alterada: ";
        // índice informado passa por método de apoio que evita que índice seja maior que a lista, retornando valor:
        int numTurma = Apoio.validaDadosArmazenados(mensagem, scan, ArmazTemporario.listaTurmas);
        // busca o objeto Turma do índice informado pelo usuário:
        Turma editarTurma = ArmazTemporario.listaTurmas.get(numTurma);
        
        // alunos:
        System.out.println("\nLista de alunos:\n");
        ArmazTemporario.mostraListaAlunos();  // mostra lista de alunos salvos no armazenamento temporário em lista
        // opção 1 = adicionar aluno:
        if (addOuRemoveAluno == 1) {
            // msg personalizada buscando nome do professor do número do objeto turma informado:
            String msg = "ao número do(a) aluno(a) que será associado à turma do professor "+ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+": ";
            // índice informado passa por método de apoio que evita que índice seja maior que a lista, retornando valor:
            int numAlunoAdd = Apoio.validaDadosArmazenados(msg, scan, ArmazTemporario.listaAlunos); 
            // busca objeto aluno pelo índice da lista informado:
            Aluno addAluno = ArmazTemporario.listaAlunos.get(numAlunoAdd);
            // ADICIONA aluno buscado na lista de armazenamento, na lista de alunos da turma:
            editarTurma.addAluno(addAluno); 
        } 
        // opção 2 = remove aluno:
        if (addOuRemoveAluno == 2) {    
            // msg personalizada buscando nome do professor do número do objeto turma informado:
            String msg = "ao número do(a) aluno(a) que será removido da turma do professor "+ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+": ";
            // índice informado passa por método de apoio que evita que índice seja maior que a lista, retornando valor:
            int numAlunoRmve = Apoio.validaDadosArmazenados(msg, scan, ArmazTemporario.listaAlunos);
            // busca aluno pelo índice da lista informado:
            Aluno rmveAluno = ArmazTemporario.listaAlunos.get(numAlunoRmve);
            // REMOVE aluno buscado na lista de armazenamento, da lista de alunos da turma:
            editarTurma.removeAluno(rmveAluno);
        }
    }
}
