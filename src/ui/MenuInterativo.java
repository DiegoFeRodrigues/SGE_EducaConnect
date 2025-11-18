package ui;

import java.util.Scanner;

import model.Aluno;
import model.CursoEAD;
import model.CursoPresencial;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
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
            System.out.println("Menu Interativo:");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Cadastrar professor");
            System.out.println("3 - Cadastrar curso");
            System.out.println("4 - Criar turma");
            System.out.print("Opção desejada: ");
            opcao = scan.nextInt();
            scan.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: "); 
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
                    break;
                    
                case 2:
                    System.out.print("Nome do professor: "); 
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
                    break;
                
                case 3:
                    System.out.println("Tipo do curso:");
                    System.out.println("1 - Curso EAD");
                    System.out.println("2 - Curso Presencial");
                    System.out.print("Informe o tipo: ");
                    int tipoCurso = scan.nextInt();
                    scan.nextLine();
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
                    break;
                
                case 4:
                    System.out.print("Código da turma: ");
                    int codigoTurma = scan.nextInt();
                    
                    System.out.println("Lista de cursos:");
                    ArmazTemporario.mostraListaCursos();
                    System.out.print("Informe o número do curso dessa turma: ");
                    int numCurso = scan.nextInt();
                    
                    System.out.println("Lista de professores: ");
                    ArmazTemporario.mostraListaProf();
                    System.out.print("Informe o número do professor dessa turma: ");
                    int numProf = scan.nextInt();
                    
                    System.out.println("Lista de alunos: ");
                    ArmazTemporario.mostraListaAlunos();
                    System.out.print("Informe o número do aluno que será associado à turma: ");
                    int numAluno = scan.nextInt();
                    
                    Curso cursoTurma = ArmazTemporario.listaCursos.get(numCurso);
                    Professor profTurma = ArmazTemporario.listaProf.get(numProf);
                    Aluno AlunoTurma = ArmazTemporario.listaAlunos.get(numAluno);
                    
                    Turma turma = new Turma(codigoTurma, cursoTurma, profTurma);
                    turma.addAluno(AlunoTurma, cursoTurma, profTurma);

                    salvaDados.listaTurmas.add(turma);
                    System.out.println(AlunoTurma+" foi entrou na turma "+codigoTurma+" "+" do curso de "+cursoTurma);
                }
            } while (opcao != 4); 
        
        // System.out.println("getLista da classe MenuInterativo: "+ armazenaAluno.getListaAlunos());

            
            
    }
}
