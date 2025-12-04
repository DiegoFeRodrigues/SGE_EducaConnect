package ui;

import repository.ArmazTemporario;
import service.AddOuRemoveAluno;
import service.Apoio;
import service.CadastraAluno;
import service.CadastraCurso;
import service.CadastraProfessor;
import service.CriaTurma;
import service.RegistraAvaliacoes;

import java.util.Scanner;

public class MenuInterativo {
    
    public void Menu() {
              
        Scanner scan = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("*** Menu Interativo: ***");
            System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Cadastrar professor");
            System.out.println("3 - Cadastrar aluno");
            System.out.println("4 - Criar turma");
            System.out.println("5 - Adicionar ou remover aluno de turma");
            System.out.println("6 - Registrar avaliação");
            System.out.println("7 - Gerar relatórios");
            System.out.println("8 - Encerrar sistema");
            System.out.print("Opção desejada: ");
            Apoio.validaNumeroMenu(scan);
            opcao = scan.nextInt();
            scan.nextLine();
            
            switch (opcao) {

                case 1:
                    System.out.println("\n\n** Cadastro de Curso **");
                    System.out.println("\nInforme os dados do curso:");
                    
                    // código do curso - atributo de controle p/ permitir ou não permitir cadastro de curso:
                    System.out.print("\nCódigo do curso: ");
                    String texto2 = "o código do novo curso: ";
                    Apoio.validaNumeroDados(scan, texto2);     // valida se valor no buffer é número inteiro.
                    int codigoCurso = scan.nextInt();
                    scan.nextLine();

                    // método de apoio percorre a lista. Se código de curso informado já existir, não permite cadastro:
                    if (!Apoio.evitaNumeroDuplicado(codigoCurso, ArmazTemporario.listaCursos)) {
                        System.out.println("\n\nNão é possível cadastrar curso.");
                        System.out.println("\nO código de curso informado já foi cadastrado.\n\n");
                    } else {    // se código informado não existir, continua cadastro no método da classe CadastraCurso levando código informado:
                        CadastraCurso.cadastro(codigoCurso);
                    }
                    break;
                    
                case 2:
                    System.out.println("\n\n** Cadastro de professor **");
                    System.out.println("\nInforme os dados do professor:");
                    
                    // registro - atributo de controle p/ permitir ou não permitir cadastro de professor:
                    System.out.print("\nNúmero de registro: ");
                    String texto1 = "o NÚMERO de registro do novo professor: "; 
                    Apoio.validaNumeroDados(scan, texto1);    // valida se valor no buffer é número inteiro.
                    int registro = scan.nextInt();
                    scan.nextLine();
                    
                    // método de apoio percorre a lista. Se número de registro informado já existir, não permite cadastro:
                    if (!Apoio.evitaNumeroDuplicado(registro, ArmazTemporario.listaProf)) {
                        System.out.println("\n\nNão é possível cadastrar professor.");
                        System.out.println("\nO número de registro informado já foi cadastrado.\n\n");
                    } else {    // se registro informado não existir, continua cadastro no método da classe CadastraProfessor levando registro informado:
                        CadastraProfessor.cadastro(registro);
                    }
                    break;
                
                case 3:
                    // Não é possível cadastrar aluno se nenhum curso tiver sido cadastrado:
                    if (repository.ArmazTemporario.listaCursos.isEmpty()) {
                        System.out.println("\n\nErro: Não é possível cadastrar aluno.");
                        System.out.println("Nenhum curso foi cadastrado. Cadastre o curso primeiro.\n\n");
                        break;
                    }
                    System.out.println("\n\n** Cadastro de aluno **");
                    System.out.println("\nInforme os dados do aluno:");
                    
                    // matrícula - atributo de controle p/ permitir ou não permitir cadastro de aluno:
                    System.out.print("\nNúmero de matrícula: ");
                    String texto = "o NÚMERO da matricula do novo aluno: ";
                    Apoio.validaNumeroDados(scan, texto); // valida se valor no buffer é número inteiro
                    int matricula = scan.nextInt();
                    scan.nextLine();
                    
                    // método de apoio percorre a lista. Se número de matrícula informado já existir, não permite cadastro:
                    if (!Apoio.evitaNumeroDuplicado(matricula, ArmazTemporario.listaAlunos)) {
                        System.out.println("\n\nNão é possível cadastrar aluno.");
                        System.out.println("\nO número de matrícula informado já foi cadastrado.\n\n");
                    } else {    // se matrícula informada não existir, continua cadastro no método da classe CadastraAluno levando matricula informada
                        CadastraAluno.cadastro(matricula);
                    }
                    break;
                
                case 4:
                    if (repository.ArmazTemporario.listaCursos.isEmpty() || repository.ArmazTemporario.listaProf.isEmpty()) {
                        System.out.println("\nErro: Não é possível criar turma.");
                        System.out.println("\nAcesse a opção de Gerar Relatórios no menu e confira se possui professores e cursos cadastrados.");
                        System.out.println("\nCaso professores ou cursos não estiverem cadastrados, cadastre-os primeiro.\n\n");
                        break;
                    }
                    // código da turma - atributo de controle p/ permitir ou não permitir a criação de turma:
                    System.out.print("\nCódigo da turma: ");
                    String texto3 = "o código da turma: ";
                    Apoio.validaNumeroDados(scan, texto3);  // testa se valor no buffer é número inteiro.
                    int codigoTurma = scan.nextInt();
                    scan.nextLine();

                    // método de apoio percorre a lista. Se código de turma informado já existir, não permite criar turma:
                    if (!Apoio.evitaNumeroDuplicado(codigoTurma, ArmazTemporario.listaTurmas)) {
                        System.out.println("\n\nNão é possível criar turma.");
                        System.out.println("\nO código de turma informado já foi cadastrado.\n\n");
                    } else {    // se código informado não existir, continua cadastro no método da classe CriaTurma levando código informado:
                        CriaTurma.criar(codigoTurma);
                    }
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
                    if (ArmazTemporario.listaAlunos.isEmpty() || ArmazTemporario.listaTurmas.isEmpty()) {
                        System.out.println("\nErro: Não é possível registrar avaliação.");
                        System.out.println("\nAcesse a opção de Gerar Relatórios no menu e confira se possui alunos e turmas cadastrados.");
                        System.out.println("\nCaso alunos ou turmas não estiverem cadastrados, cadastre-os primeiro.\n\n");
                        break;
                    } else {
                        RegistraAvaliacoes.registrar();
                    }
                    break;
                
                case 7:
                    // instanciano menu de relatorios e chamando método menuRelatorios
                    MenuRelatorios menu = new MenuRelatorios();
                    menu.menuRelatorios();
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