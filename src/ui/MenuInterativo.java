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
    // método para testar se valor digitado é número inteiro - usado em menus de opções:
    private void testaNumeroMenu(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("\nErro: Opção inválida.");
            System.out.print("Confira as opções acima e digite o NÚMERO correspondente à opção desejada: ");
            scan.nextLine();
        }
    }
    private boolean evitaAlunoDuplicado(int numero) {
        for (Aluno alunos : salvaDados.listaAlunos) {
            if (alunos.getMatricula() == numero) {
                System.out.println("\nErro: Não é possível cadastrar aluno.");
                System.out.println("\nJá existe aluno com a matrícula informada.\n\n");
                return false;
            }
        } 
        return true;
    }
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
            testaNumeroMenu(scan);
            opcao = scan.nextInt();
            switch (opcao) {

                case 1:
                    scan.nextLine();
                    if (salvaDados.listaCursos.isEmpty()) {
                        System.out.println("\n\nErro: Não é possível cadastrar aluno.");
                        System.out.println("Nenhum curso foi cadastrado. Cadastre o curso primeiro.\n\n");
                        break;
                    }
                    System.out.println("\n\n** Cadastro de aluno **");
                    System.out.println("\nInforme os dados do aluno:");
                    System.out.print("Nome: "); 
                    String nomeAluno = scan.nextLine();
                    System.out.print("Matrícula: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("\nErro: Número de matrícula não pode conter letras.");
                        System.out.print("Digite o número de matrícula do aluno "+nomeAluno+": ");
                        scan.nextLine();
                    }
                    int matricula = scan.nextInt();
                    if (!evitaAlunoDuplicado(matricula)) {
                        break;
                    }
                    scan.nextLine();
                    System.out.println("\nCursos disponíveis:\n");
                    salvaDados.mostraListaCursos();
                    System.out.print("\nInforme o número que corresponde ao curso do aluno "+nomeAluno+": ");
                    testaNumeroMenu(scan);
                    int numeCurso = scan.nextInt();
                    while (numeCurso >= salvaDados.listaCursos.size()) {
                        System.out.println("Erro: Opção inválida");
                        scan.nextLine();
                        System.out.print("Confira a lista acima e digite o número do curso do aluno "+nomeAluno+": ");
                        numeCurso = scan.nextInt();
                    }
                    scan.nextLine();
                    String cursoAluno = salvaDados.listaCursos.get(numeCurso).getNomeCurso();
                    System.out.print("Login: ");
                    String loginAluno = scan.nextLine();
                    System.out.print("Senha: ");
                    String senhaAluno = scan.nextLine();
                    try {
                        Aluno aluno = new Aluno(nomeAluno, matricula, cursoAluno, loginAluno, senhaAluno);
                        salvaDados.listaAlunos.add(aluno);
                        System.out.println("\nAluno "+aluno.getNome()+" foi cadastrado com sucesso.\n\n");
                    } catch(NullPointerException npe) {
                        System.err.println("\nFalha ao cadastrar aluno: "+npe+"\n\n");
                    } 
                    break;
                    
                case 2:
                    System.out.println("\n\n** Cadastro de professor **");
                    System.out.println("\nInforme os dados do professor:");
                    scan.nextLine();
                    System.out.print("Nome: "); 
                    String nomeProf = scan.nextLine();
                    System.out.print("Registro: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("Erro: Número de registro não pode conter letras.");
                        System.out.print("Informe o número de registro do professor "+nomeProf+": ");
                        scan.nextLine();
                    }
                    int registro = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Especialidade: ");
                    String especialidade = scan.nextLine();
                    System.out.print("Login: ");
                    String loginProf = scan.nextLine();
                    System.out.print("Senha: ");
                    String senhaProf = scan.nextLine();
                    try {
                        Professor professor = new Professor(nomeProf, especialidade, registro, loginProf, senhaProf);
                        salvaDados.listaProf.add(professor);
                        System.out.println("\nProfessor "+professor.getNome()+" foi cadastrado com sucesso.\n\n");
                    } catch (NullPointerException npe) {
                        System.err.println("Falha ao cadastrar professor: "+npe+"\n\n");
                    }
                    break;
                
                case 3:
                    System.out.println("\n\n** Cadastro de Curso **");
                    System.out.println("\nTipo do curso:");
                    System.out.println("1 - Curso EAD");
                    System.out.println("2 - Curso Presencial");
                    System.out.print("Informe o número que corresponde ao tipo de curso desejado: ");
                    scan.nextLine();
                    testaNumeroMenu(scan);
                    int tipoCurso = scan.nextInt();
                    while (tipoCurso <= 0 || tipoCurso > 2) {
                        System.out.println("\nErro: Opção inválida!");
                        scan.nextLine();
                        System.out.println("Digite 1 = Cadastrar curso EAD.");
                        System.out.println("Digite 2 = Cadastrar curso Presencial.");
                        System.out.print("Opção desejada: ");
                        tipoCurso = scan.nextInt();
                    }
                    scan.nextLine();
                    System.out.println("\nInforme os dados do curso:");
                    System.out.print("Nome do curso: "); 
                    String nomeCurso = scan.nextLine();
                    System.out.print("Código: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("\nCódigo do curso não pode conter letras.");
                        System.out.print("Informe o código do curso de "+nomeCurso+": ");
                        scan.nextLine();
                    }
                    int codigo = scan.nextInt();
                    scan.nextLine();
                    System.out.print("Carga horária: ");
                    while (!scan.hasNextFloat()) {
                        System.out.println("\nCarga horária não pode conter letras.");
                        System.out.print("Informe a carga horária do curso de "+nomeCurso+": ");
                        scan.nextLine();
                    }
                    float cargaHoraria = scan.nextFloat();
                    scan.nextLine();
                    try {
                        if (tipoCurso == 1) {
                            System.out.print("Plataforma EAD: ");
                            String plataforma = scan.nextLine();
                            Curso cursoEAD = new CursoEAD(nomeCurso, codigo, cargaHoraria, plataforma);
                            salvaDados.listaCursos.add(cursoEAD);
                            System.out.println("\nCurso EAD de "+cursoEAD.getNomeCurso()+" foi cadastrado com sucesso.\n\n");
                        } else if (tipoCurso == 2) {
                            System.out.print("Sala: ");
                            String sala = scan.nextLine();
                            Curso cursoPresencial = new CursoPresencial(nomeCurso, codigo, cargaHoraria, sala);
                            salvaDados.listaCursos.add(cursoPresencial);
                            System.out.println("\nCurso Presencial de "+cursoPresencial.getNomeCurso()+" foi cadastrado com sucesso.\n\n");
                        }
                    } catch (NullPointerException npe) {
                        System.err.println("\nFalha ao cadastrar curso: "+ npe+"\n\n");
                    }
                    break;
                
                case 4:
                    if (salvaDados.listaCursos.isEmpty() || salvaDados.listaProf.isEmpty()) {
                        System.out.println("\nErro: Não é possível criar turma.");
                        System.out.println("O sistema não possui cursos ou professores cadastrados.");
                        System.out.println("Cadastre curso e professor primeiro.\n\n");
                        break;
                    }
                    System.out.println("\n\n** Criação de turmas **");
                    System.out.println("\nInforme os dados da turma:");
                    System.out.print("Código da turma: ");
                    scan.nextLine();
                    while (!scan.hasNextInt()) {
                        System.out.println("\nErro: Código da turma não pode conter letras.");
                        System.out.print("Informe o código da turma: ");
                        scan.nextLine();
                    }
                    int codigoTurma = scan.nextInt();
                    
                    System.out.println("\nLista de cursos:\n");
                    salvaDados.mostraListaCursos();
                    System.out.print("\nInforme o número do curso dessa turma: ");
                    scan.nextLine();
                    testaNumeroMenu(scan);
                    int numCurso = scan.nextInt();
                    while (numCurso >= salvaDados.listaCursos.size()) {
                        System.out.println("\nErro: Opção inválida");
                        scan.nextLine();
                        System.out.print("Confira a lista de cursos acima e digite o número do curso que será lecionado na turma "+codigoTurma+": ");
                        testaNumeroMenu(scan);
                        numCurso = scan.nextInt();
                    }
                    System.out.println("\n\nCurso de "+salvaDados.listaCursos.get(numCurso).getNomeCurso()+" cadastrado na turma "+codigoTurma+".\n");
                    scan.nextLine();
                    
                    System.out.println("\nLista de professores:\n");
                    salvaDados.mostraListaProf();
                    System.out.print("\nInforme o número do professor dessa turma: ");
                    testaNumeroMenu(scan);
                    int numProf = scan.nextInt();
                    while (numProf >= salvaDados.listaProf.size()) {
                        System.out.println("\nErro: Opção inválida");
                        scan.nextLine();
                        System.out.print("Confira a lista de professores acima e digite o número do professor dará aulas para a turma "+codigoTurma+": ");
                        testaNumeroMenu(scan);
                        numProf = scan.nextInt();
                    }
                    System.out.println("\n\nProfessor "+salvaDados.listaProf.get(numCurso).getNome()+" cadastrado na turma "+codigoTurma+".\n");
                    
                    Curso cursoTurma = salvaDados.listaCursos.get(numCurso);
                    Professor profTurma = salvaDados.listaProf.get(numProf);
                    
                    Turma turma = new Turma(codigoTurma, cursoTurma, profTurma);
                    
                    salvaDados.listaTurmas.add(turma);
                    System.out.println("\nTurma do curso de "+cursoTurma.getNomeCurso()+" do professor "+profTurma.getNome()+" foi criada com sucesso.\n\n\n");
                    break;
                    
                case 5:
                    if (salvaDados.listaAlunos.isEmpty() || salvaDados.listaTurmas.isEmpty()) {
                        System.out.println("\nErro: Não é possível adicionar ou remover alunos.");
                        System.out.println("\nAcesse o menu de Gerar Relatórios e confira se possui alunos e turmas cadastrados.");
                        System.out.println("\nCaso alunos ou turmas não estiverem cadastrados, cadastre-os primeiro.\n\n");
                        break;
                    }
                    System.out.println("\n\n** Adicionar ou remover alunos em turmas **");
                    System.out.println("\n1 - Adicionar aluno");
                    System.out.println("2 - Remover aluno");
                    System.out.print("Informe o número da opção desejada: ");
                    scan.nextLine();
                    testaNumeroMenu(scan);
                    int addOuRemoveAluno = scan.nextInt();
                    while (addOuRemoveAluno <= 0 || addOuRemoveAluno > 2) {
                        System.out.println("\nErro: Opção inválida!");
                        scan.nextLine();
                        System.out.println("Digite 1 = Adicionar aluno em turma.");
                        System.out.println("Digite 2 = Remover aluno de turma.");
                        System.out.print("Opção desejada: ");
                        addOuRemoveAluno = scan.nextInt();
                    }

                    System.out.println("\nLista de turmas:");
                    salvaDados.mostraListaTurmas();
                    System.out.print("Informe o número da turma que será editada: ");
                    int numTurma = scan.nextInt();

                    Turma editarTurma = salvaDados.listaTurmas.get(numTurma);
                    
                    if (addOuRemoveAluno == 1) {
                        System.out.println("\nLista de alunos matriculados: ");
                        salvaDados.mostraListaAlunos();
                        
                        System.out.print("Informe o número do aluno que será associado à turma do professor "+salvaDados.listaTurmas.get(numTurma).getProfessorTurma().getNome()+":");
                        int numAlunoAdd = scan.nextInt();
                        Aluno addAluno = salvaDados.listaAlunos.get(numAlunoAdd);
                        
                        // System.out.println("\nLista de cursos: ");
                        // salvaDados.mostraListaCursos();
                        // System.out.print("Informe o número do curso: ");
                        // int numCursoTurma = scan.nextInt();
                        // Curso cursoDessaTurma = salvaDados.listaCursos.get(numCursoTurma);
                        
                        editarTurma.addAluno(addAluno);
                    }    
                    if (addOuRemoveAluno == 2) {
                        System.out.println("\nLista de alunos: ");
                        salvaDados.mostraListaAlunos();
                        
                        System.out.print("Informe o número do aluno que será removido da turma do professor "+salvaDados.listaTurmas.get(numTurma).getProfessorTurma().getNome()+":");
                        int numAlunoRmv = scan.nextInt();
                        Aluno rmveAluno = salvaDados.listaAlunos.get(numAlunoRmv);

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
                    salvaDados.mostraListaAlunos();
                    System.out.print("Número do aluno que receberá a nota: ");
                    int numAlunoAvaliado = scan.nextInt();
                    System.out.println("\nLista de turmas:");
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
