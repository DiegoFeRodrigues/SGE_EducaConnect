package ui;

import java.util.Scanner;

import model.Aluno;
import model.CursoEAD;
import model.CursoPresencial;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import service.Avaliacao;
import service.Turma;

public class MenuInterativo {
    
    private ArmazTemporario salvaDados;

    public MenuInterativo(ArmazTemporario dados) {
        this.salvaDados = dados;
    }

    public void Menu() {
              
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("\n*** Menu Interativo: ***");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar professor");
            System.out.println("3 - Cadastrar curso");
            System.out.println("4 - Criar turma");
            System.out.println("5 - Adicionar ou remover aluno de uma turma");
            System.out.println("6 - Registrar avaliação");
            System.out.println("7 - Gerar relatórios");
            System.out.println("8 - Encerrar sistema");
            System.out.print("Opção desejada: ");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("\n\n** Cadastro de aluno **");
                    System.out.println("\nInforme os dados do aluno:");
                    System.out.print("Nome: "); 
                    String nomeAluno = scan.nextLine();
                    System.out.print("Matrícula: ");
                    int matricula = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Curso: ");
                    String cursoAluno = scan.nextLine();
                    System.out.print("Login: ");
                    String loginAluno = scan.nextLine();
                    System.out.print("Senha: ");
                    String senhaAluno = scan.nextLine();
                    Aluno aluno = new Aluno(nomeAluno, matricula, cursoAluno, loginAluno, senhaAluno);
                    salvaDados.listaAlunos.add(aluno);
                    System.out.println("\nAluno cadastrado.\n");
                    break;
                    
                case 2:
                    System.out.println("\n\n** Cadastro de professor **");
                    System.out.println("\nInforme os dados do professor:");
                    System.out.print("Nome: "); 
                    String nomeProf = scan.nextLine();
                    System.out.print("Registro: ");
                    int registro = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = scan.nextLine();
                    System.out.print("Login: ");
                    String loginProf = scan.nextLine();
                    System.out.print("Senha: ");
                    String senhaProf = scan.nextLine();
                    Professor professor = new Professor(nomeProf, especialidade, registro, loginProf, senhaProf);
                    salvaDados.listaProf.add(professor);
                    System.out.println("\nProfessor cadastrado.\n");
                    break;
                
                case 3:
                    System.out.println("\n** Cadastro de Curso **");
                    System.out.println("\nTipo do curso:");
                    System.out.println("1 - Curso EAD");
                    System.out.println("2 - Curso Presencial");
                    System.out.print("Informe o número que corresponde ao tipo desejado: ");
                    int tipoCurso = scan.nextInt();
                    scan.nextLine();
                    System.out.println("\nInforme os dados do curso:");
                    System.out.print("Nome do curso: "); 
                    String nomeCurso = scan.nextLine();
                    System.out.print("Código: ");
                    int codigo = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Carga horária: ");
                    float cargaHoraria = scan.nextFloat();
                    scan.nextLine();
                    if (tipoCurso == 1) {
                        System.out.print("Plataforma EAD: ");
                        String plataforma = scan.nextLine();
                        Curso cursoEAD = new CursoEAD(nomeCurso, codigo, cargaHoraria, plataforma);
                        salvaDados.listaCursos.add(cursoEAD);
                    } else if (tipoCurso == 2) {
                        System.out.print("Sala: ");
                        String sala = scan.nextLine();
                        Curso cursoPresencial = new CursoPresencial(nomeCurso, codigo, cargaHoraria, sala);
                        salvaDados.listaCursos.add(cursoPresencial);
                    }
                    System.out.println("\nCurso cadastrado.\n");
                    break;
                
                case 4:
                    // int addOuRemove = scan.nextInt();

                    System.out.println("\n** Criação de turmas **");
                    System.out.println("\nInforme os dados da turma:");
                    System.out.print("Código da turma: ");
                    int codigoTurma = scan.nextInt();
                    
                    System.out.println("\nLista de cursos:\n");
                    salvaDados.mostraListaCursos();
                    System.out.print("\nInforme o número do curso dessa turma: ");
                    int numCurso = scan.nextInt();
                    
                    System.out.println("\nLista de professores:\n");
                    salvaDados.mostraListaProf();
                    System.out.print("\nInforme o número do professor dessa turma: ");
                    int numProf = scan.nextInt();
                    
                    
                    Curso cursoTurma = salvaDados.listaCursos.get(numCurso);
                    Professor profTurma = salvaDados.listaProf.get(numProf);
                    
                    Turma turma = new Turma(codigoTurma, cursoTurma, profTurma);
                    
                    salvaDados.listaTurmas.add(turma);
                    System.out.println("\nTurma criada.\n");
                    break;
                    
                case 5:
                    System.out.println("\n** Adicionar ou remover alunos em turmas **");
                    System.out.println("\n1 - Adicionar aluno");
                    System.out.println("2 - Remover aluno");
                    System.out.print("Informe o número da opção desejada: ");
                    int addOuRemoveAluno = scan.nextInt();

                    System.out.println("\nLista de turmas:");
                    salvaDados.mostraListaTurmas();
                    System.out.print("Informe o número da turma que será editada: ");
                    int numTurma = scan.nextInt();

                    Turma editarTurma = salvaDados.listaTurmas.get(numTurma);
                    
                    if (addOuRemoveAluno == 1) {
                        System.out.println("\nLista de alunos matriculados: ");
                        salvaDados.mostraListaAlunos();
                        
                        System.out.print("Informe o número do aluno que será associado à turma "+numTurma+":");
                        int numAlunoAdd = scan.nextInt();
                        Aluno addAluno = salvaDados.listaAlunos.get(numAlunoAdd);
                        
                        System.out.println("Lista de cursos: ");
                        salvaDados.mostraListaCursos();
                        System.out.print("Informe o número do curso: ");
                        int numCursoTurma = scan.nextInt();
                        Curso cursoDessaTurma = salvaDados.listaCursos.get(numCursoTurma);
                        
                        editarTurma.addAluno(addAluno, cursoDessaTurma);
                    }    
                    if (addOuRemoveAluno == 2) {
                        System.out.println("\nLista de alunos: ");
                        salvaDados.mostraListaAlunos();
                        
                        System.out.print("Informe o número do aluno que será removido da turma "+numTurma+":");
                        int numAlunoRmv = scan.nextInt();
                        Aluno rmveAluno = salvaDados.listaAlunos.get(numAlunoRmv);

                        editarTurma.removeAluno(rmveAluno);
                    }
                    break;
                
                case 6:
                    System.out.println("\n** Avaliações **");
                    System.out.println("\nInforme os dados da avaliação: ");
                    System.out.print("Descrição: ");
                    String descricao = scan.nextLine();

                    Avaliacao avaliacao = new Avaliacao(descricao);

                    System.out.println("Lista de alunos:");
                    salvaDados.mostraListaAlunos();
                    System.out.print("Número do aluno que receberá a nota: ");
                    int numAlunoAvaliado = scan.nextInt();
                    System.out.println("Lista de turmas:");
                    salvaDados.mostraListaTurmas();
                    System.out.print("Número da turma do aluno: ");
                    int numTurmaAv = scan.nextInt();
                    
                    Aluno alunoAvaliacao = salvaDados.listaAlunos.get(numAlunoAvaliado);
                    Turma turmaAvaliacao = salvaDados.listaTurmas.get(numTurmaAv);
                    
                    System.out.print("Informe a nota do aluno "+alunoAvaliacao.getNome()+": ");
                    float notaAluno = scan.nextFloat();

                    avaliacao.atribuirNota(alunoAvaliacao, turmaAvaliacao, notaAluno);

                    System.out.println("Nota adicionada ao aluno "+alunoAvaliacao.getNome()+" na avaliação "+avaliacao.getDescricao()+".");
                    
                    salvaDados.listaAvaliacoes.add(avaliacao);
                    System.out.println("\nAvaliação registrada.\n");
                    break;
                
                case 7:
                    // CHAMANDO MENU DE RELATÓRIOS:
                    MenuRelatorios menuRelatorios = new MenuRelatorios(salvaDados);
                    menuRelatorios.menuRelatorios();
                    break;

                case 8:
                    System.out.println("\nEncerrando...\n");
                    break;

                default:
                    System.out.println("\nOpção inválida!\n");
            }
        } while (opcao != 8); 
    }
}
