package ui;

import java.util.Scanner;

import model.Aluno;
import model.Curso;
import model.Professor;
import service.Avaliacao;
import service.TestaDados;
import service.Turma;
import service.CadastraAluno;
import service.CadastraCurso;
import service.CadastraProfessor;

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
            TestaDados.testaNumeroMenu(scan);
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
                    System.out.println("\n\n** Criação de turmas **");
                    System.out.println("\nInforme os dados da turma:");
                    System.out.print("Código da turma: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("\nErro: Código da turma não pode conter letras.");
                        System.out.print("Informe o código da turma: ");
                        scan.nextLine();
                    }
                    int codigoTurma = scan.nextInt();
                    
                    System.out.println("\nLista de cursos:\n");
                    repository.ArmazTemporario.mostraListaCursos();
                    System.out.print("\nInforme o número do curso dessa turma: ");
                    scan.nextLine();
                    TestaDados.testaNumeroMenu(scan);
                    int numCurso = scan.nextInt();
                    while (numCurso >= repository.ArmazTemporario.listaCursos.size()) {
                        System.out.println("\nErro: Opção inválida");
                        scan.nextLine();
                        System.out.print("Confira a lista de cursos acima e digite o número do curso que será lecionado na turma "+codigoTurma+": ");
                        TestaDados.testaNumeroMenu(scan);
                        numCurso = scan.nextInt();
                    }
                    System.out.println("\n\nCurso de "+repository.ArmazTemporario.listaCursos.get(numCurso).getNomeCurso()+" cadastrado na turma "+codigoTurma+".\n");
                    scan.nextLine();
                    
                    System.out.println("\nLista de professores:\n");
                    repository.ArmazTemporario.mostraListaProf();
                    System.out.print("\nInforme o número do professor dessa turma: ");
                    TestaDados.testaNumeroMenu(scan);
                    int numProf = scan.nextInt();
                    while (numProf >= repository.ArmazTemporario.listaProf.size()) {
                        System.out.println("\nErro: Opção inválida");
                        scan.nextLine();
                        System.out.print("Confira a lista de professores acima e digite o número do professor dará aulas para a turma "+codigoTurma+": ");
                        TestaDados.testaNumeroMenu(scan);
                        numProf = scan.nextInt();
                    }
                    System.out.println("\n\nProfessor "+repository.ArmazTemporario.listaProf.get(numCurso).getNome()+" cadastrado na turma "+codigoTurma+".\n");
                    
                    Curso cursoTurma = repository.ArmazTemporario.listaCursos.get(numCurso);
                    Professor profTurma = repository.ArmazTemporario.listaProf.get(numProf);
                    
                    Turma turma = new Turma(codigoTurma, cursoTurma, profTurma);
                    
                    repository.ArmazTemporario.listaTurmas.add(turma);
                    System.out.println("\nTurma do curso de "+cursoTurma.getNomeCurso()+" do professor "+profTurma.getNome()+" foi criada com sucesso.\n\n\n");
                    break;
                    
                case 5:
                    if (repository.ArmazTemporario.listaAlunos.isEmpty() || repository.ArmazTemporario.listaTurmas.isEmpty()) {
                        System.out.println("\nErro: Não é possível adicionar ou remover alunos.");
                        System.out.println("\nAcesse a opção de Gerar Relatórios no menu e confira se possui alunos e turmas cadastrados.");
                        System.out.println("\nCaso alunos ou turmas não estiverem cadastrados, cadastre-os primeiro.\n\n");
                        break;
                    }
                    System.out.println("\n\n** Adicionar ou remover alunos em turmas **");
                    System.out.println("\n1 - Adicionar aluno");
                    System.out.println("2 - Remover aluno");
                    System.out.print("Informe o número da opção desejada: ");
                    TestaDados.testaNumeroMenu(scan);
                    int addOuRemoveAluno = scan.nextInt();
                    while (addOuRemoveAluno <= 0 || addOuRemoveAluno > 2) {
                        System.out.println("\nErro: Opção inválida!");
                        scan.nextLine();
                        System.out.println("Digite 1 = Adicionar aluno em turma.");
                        System.out.println("Digite 2 = Remover aluno de turma.");
                        System.out.print("Opção desejada: ");
                        TestaDados.testaNumeroMenu(scan);
                        addOuRemoveAluno = scan.nextInt();
                    }
                    
                    scan.nextLine();
                    System.out.println("\nLista de turmas:");
                    repository.ArmazTemporario.mostraListaTurmas();
                    System.out.print("Informe o número da turma que será alterada: ");
                    TestaDados.testaNumeroMenu(scan);
                    int numTurma = scan.nextInt();
                    scan.nextLine();
                    
                    while (numTurma >= repository.ArmazTemporario.listaTurmas.size()) {
                        System.out.println("\nErro: Opção inválida!");
                        System.out.println("Confira a lista de turmas acima.");
                        System.out.print("Digite o número correspondente da turma do aluno: ");
                        TestaDados.testaNumeroMenu(scan);
                        numTurma = scan.nextInt();
                        scan.nextLine();
                    }

                    Turma editarTurma = repository.ArmazTemporario.listaTurmas.get(numTurma);
                    
                    System.out.println("\nLista de alunos matriculados: ");
                    repository.ArmazTemporario.mostraListaAlunos();

                    
                    if (addOuRemoveAluno == 1) {
                        System.out.print("Informe o número do aluno que será associado à turma do professor "+repository.ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+":");
                        TestaDados.testaNumeroMenu(scan);
                        int numAlunoAdd = scan.nextInt();
                        scan.nextLine();
                        while (numAlunoAdd > repository.ArmazTemporario.listaAlunos.size()) {
                            System.out.println("\nErro: Opção inválida!");
                            System.out.println("Confira a lista de alunos acima.");
                            System.out.print("Digite o número correspondente ao aluno que será associado à turma: ");
                            TestaDados.testaNumeroMenu(scan);
                            numAlunoAdd = scan.nextInt();
                            scan.nextLine();
                        }
                        Aluno addAluno = repository.ArmazTemporario.listaAlunos.get(numAlunoAdd);
                        
                        editarTurma.addAluno(addAluno);
                    }    
                    if (addOuRemoveAluno == 2) {
                        
                        System.out.print("Informe o número do aluno que será removido da turma do professor "+repository.ArmazTemporario.listaTurmas.get(numTurma).getProfessorTurma().getNome()+":");
                        int numAlunoRmv = scan.nextInt();
                        Aluno rmveAluno = repository.ArmazTemporario.listaAlunos.get(numAlunoRmv);

                        editarTurma.removeAluno(rmveAluno);
                    }
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
