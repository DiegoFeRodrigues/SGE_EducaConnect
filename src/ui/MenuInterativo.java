package ui;

import java.util.Scanner;

import model.Aluno;
import service.AddOuRemoveAluno;
import service.Avaliacao;
import service.ValidaDados;
import service.Turma;
import service.CadastraAluno;
import service.CadastraCurso;
import service.CadastraProfessor;
import service.CriaTurma;

public class MenuInterativo {
    
    public void Menu() {
              
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("*** Menu Interativo: ***");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar professor");
            System.out.println("3 - Cadastrar curso");
            System.out.println("4 - Criar turma");
            System.out.println("5 - Adicionar ou remover aluno de turma");
            System.out.println("6 - Registrar avaliação");
            System.out.println("7 - Gerar relatórios");
            System.out.println("8 - Encerrar sistema");
            System.out.print("Opção desejada: ");
            ValidaDados.validaNumeroMenu(scan);
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {

                case 1:
                    if (repository.ArmazTemporario.listaCursos.isEmpty()) {
                        System.out.println("\n\nErro: Não é possível cadastrar aluno.");
                        System.out.println("Nenhum curso foi cadastrado. Cadastre o curso primeiro.\n\n");
                        break;
                    }
                    CadastraAluno.cadastro();
                    break;
                    
                case 2:
                    CadastraProfessor.cadastro();
                    break;
                
                case 3:
                    CadastraCurso.cadastro();
                    break;
                
                case 4:
                    if (repository.ArmazTemporario.listaCursos.isEmpty() || repository.ArmazTemporario.listaProf.isEmpty()) {
                        System.out.println("\nErro: Não é possível criar turma.");
                        System.out.println("\nAcesse a opção de Gerar Relatórios no menu e confira se possui professores e cursos cadastrados.");
                        System.out.println("\nCaso professores ou cursos não estiverem cadastrados, cadastre-os primeiro.\n\n");
                        break;
                    }
                    CriaTurma.criar();
                    break;
                    
                case 5:
                    if (repository.ArmazTemporario.listaAlunos.isEmpty() || repository.ArmazTemporario.listaTurmas.isEmpty()) {
                        System.out.println("\nErro: Não é possível adicionar ou remover alunos.");
                        System.out.println("\nAcesse a opção de Gerar Relatórios no menu e confira se possui alunos e turmas cadastrados.");
                        System.out.println("\nCaso alunos ou turmas não estiverem cadastrados, cadastre-os primeiro.\n\n");
                        break;
                    }
                    AddOuRemoveAluno.adicionarOuRemover();
                    break;
                
                case 6:
                    System.out.println("\n\n** Avaliações **");
                    System.out.println("\nInforme os dados da avaliação: ");
                    System.out.print("Descrição: ");
                    String descricao = scan.nextLine();

                    Avaliacao avaliacao = new Avaliacao(descricao);

                    System.out.println("\nLista de alunos:");
                    repository.ArmazTemporario.mostraListaAlunos();
                    System.out.print("Número do aluno que receberá a nota: ");
                    int numAlunoAvaliado = scan.nextInt();
                    System.out.println("\nLista de turmas:");
                    repository.ArmazTemporario.mostraListaTurmas();
                    System.out.print("Número da turma do aluno: ");
                    int numTurmaAv = scan.nextInt();
                    
                    Aluno alunoAvaliacao = repository.ArmazTemporario.listaAlunos.get(numAlunoAvaliado);
                    Turma turmaAvaliacao = repository.ArmazTemporario.listaTurmas.get(numTurmaAv);
                    
                    System.out.print("Informe a nota do aluno "+alunoAvaliacao.getNome()+": ");
                    float notaAluno = scan.nextFloat();

                    avaliacao.atribuirNota(alunoAvaliacao, turmaAvaliacao, notaAluno);

                    System.out.println("Nota adicionada ao aluno "+alunoAvaliacao.getNome()+" na avaliação "+avaliacao.getDescricao()+".");
                    
                    repository.ArmazTemporario.listaAvaliacoes.add(avaliacao);
                    System.out.println("\nAvaliação registrada.\n");
                    break;
                
                case 7:
                    // CHAMANDa opção de RELATÓRIOS: no menu
                    MenuRelatorios menuRelatorios = new MenuRelatorios();
                    menuRelatorios.menuRelatorios();
                    break;

                case 8:
                    System.out.println("\nEncerrando...\n");
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");
            }
        } while (opcao != 8); 
        scan.close();
    }
}



                        
                        // System.out.println("\nLista de cursos: ");
                        // ArmazTemporario.mostraListaCursos();
                        // System.out.print("Informe o número do curso: ");
                        // int numCursoTurma = scan.nextInt();
                        // Curso cursoDessaTurma = ArmazTemporario.listaCursos.get(numCursoTurma);
