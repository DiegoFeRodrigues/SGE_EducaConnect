import model.Administrador;
import model.Aluno;
import model.Curso;
import model.CursoEAD;
import model.CursoPresencial;
import model.Professor;
import repository.ArmazTemporario;
import service.Avaliacao;
import service.Turma;
import ui.MenuRelatorios;

public class Main {
    
    public static void main(String[] args) {
        // bloco try - tenta validação na instancia de objetos:
        try {
            System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****\n");        
            System.out.println("------------------------------------------------------------------------");
            
            // CAMADA MODEL - instanciando objetos 
                
                // Administrador:
                Administrador adm = new Administrador("Admin","1234");
                
                // Alunos:
                Aluno aluno1 = new Aluno("Diego", 12345, "ADS", "D","123");
                Aluno aluno2 = new Aluno("Kuririn", 18, "Artes marciais", "marron", "98@k9Lç$");
                Aluno aluno3 = new Aluno("Kakarotto", 59, "Artes marciais", "Oozaru", "gohan");
                Aluno aluno4 = new Aluno("Yamcha", 7, "Artes marciais", "Yam", "pu@l");

                // curso EAD:
                Curso curso1 = new CursoEAD("ADS",54321, 2180f, "Studeo");
               
                // cursos Presenciais:
                Curso curso2 = new CursoPresencial("Artes marciais", 98765, 20000f, "Sala do tempo");
               
                // professores:
                Professor professor1 = new Professor("Mestre Kame", "Estilo da targatura", 1, "roshi", "jackiechun");
                Professor professor2 = new Professor("Flavio Ceci", "POO", 134679, "CeciFlavio", "FC12345");
            //
                
            // CAMADA SERVICE:
                
                // MANIPULANDO TURMAS:
                    // novas turmas:
                    Turma turma1 = new Turma(1, curso1, professor2);
                    Turma turma2 = new Turma(2, curso2, professor1);
                    
                    // adicionando alunos às turmas:
                    System.out.println("\nAlunos adicionados:");
                    
                    turma1.addAluno(aluno1, curso1, professor2);
                    
                    turma2.addAluno(aluno2, curso2, professor1);
                    turma2.addAluno(aluno3, curso2, professor1);
                    turma2.addAluno(aluno4, curso2, professor1);
                    
                    // removendo aluno de uma turma:
                    System.out.println("\n\nAlunos removidos:");
                    turma2.removeAluno(aluno4, curso2);
                //
                System.out.println("------------------------------------------------------------------------");
                
                // AUTENTICANDO USUÁRIOS:
                    System.out.println("\nUsuários logados:\n");

                    adm.autenticar("Admin", "1234");
                    
                    aluno1.autenticar("D", "123");
                    aluno2.autenticar("marron", "98@k9Lç$");
                    aluno3.autenticar("", "");
                    
                    professor1.autenticar("roshi","jackiechun");
                    professor2.autenticar("CeciFlavio","FC12345");
                //    
                System.out.println("------------------------------------------------------------------------");

                // AVALIAÇÕES 
                    // novas avaliações:
                    Avaliacao prova = new Avaliacao("Prova de POO.");
                    Avaliacao treino = new Avaliacao("Carregar caixas de leite.");
                    
                    //atribuindo notas e saída com resultados:
                    System.out.println("\nResultado das avaliações:\n");
                    
                    prova.atribuirNota(aluno1, turma1, 6f);
                    
                    treino.atribuirNota(aluno2, turma2, 8f);
                    treino.atribuirNota(aluno3, turma2, 10f);
                //
            //        
            System.out.println("------------------------------------------------------------------------");
            
            // CAMADA REPOSITORY - adicionando dados no armazenamento temporário em listas:    
                
                // instanciando objeto da classe ArmazTemporário:
                ArmazTemporario simuBDTemp = new ArmazTemporario();
                
                // adicionando dados - alunos:
                ArmazTemporario.listaAlunos.add(aluno1);
                ArmazTemporario.listaAlunos.add(aluno2);
                ArmazTemporario.listaAlunos.add(aluno3);
                
                // professores:
                ArmazTemporario.listaProf.add(professor1);
                ArmazTemporario.listaProf.add(professor2);
                
                // cursos:
                ArmazTemporario.listaCursos.add(curso1);
                ArmazTemporario.listaCursos.add(curso2);
                
                // turmas:
                ArmazTemporario.listaTurmas.add(turma1);
                ArmazTemporario.listaTurmas.add(turma2);
            //
                
            // CAMADA UI
                // novo menu de relatórios no Main:
                    MenuRelatorios menuRelatorios = new MenuRelatorios(simuBDTemp);
                    menuRelatorios.menuR();
                //
            //

        } // captura e tratamento de erros de objetos que não puderem ser instanciados: 
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("\nErro: "+npeouiae.getMessage());        
        }    
    } 
}
// saída com resumo das turmas:
// System.out.println(turma1.resumoTurma());
// System.out.println(turma2.resumoTurma());

// System.out.println("\nResultado avaliação da turma 1:");
                // System.out.println(prova.resultado(aluno1, turma1, prova));
                
                // atribuindo nota e saída com resultado - turma 2:
                // System.out.println("\nResultado avaliação da turma 2:");
                // System.out.println(treino.resultado(aluno2, turma2, treino));
                
                // treino.atribuirNota(aluno3, turma2, 10f);
                // System.out.println(treino.resultado(aluno3, turma2, treino));

// turma2.addAluno(aluno3, curso2, professor1);


// simuBDTemp.adicionaCurso("Química", 51379, 5300f, "Laboratório");