package service;

import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import model.Curso;
import model.Professor;

public class Turma {
   
    // atributos turma:
    private int codigo;
    private Curso curso;
    private Professor professor;
    private List<Aluno> listaAlunos;
    private List<String> listaNomeAlunos;    
    
    public Turma(int codigo, Curso curso, Professor professor) {
        if (codigo <= 0) {
            throw new IllegalArgumentException("Código da turma deve ser maior que 0.");
        }
        if (curso == null) {
            throw new NullPointerException("Informe o objeto curso desejado.");
        }
        if (professor == null) {
            throw new NullPointerException("Informe o objeto professor desejado.");
        }
        this.codigo = codigo;
        this.curso = curso;
        this.professor = professor;
        this.listaAlunos = new ArrayList<>();
        this.listaNomeAlunos = new ArrayList<>();   
    }
    // método adiciona aluno:
    public void addAluno(Aluno aluno, Curso curso, Professor prof) {
        if (aluno.getCursoAluno().equals(curso.getNomeCurso())) {
            listaAlunos.add(aluno);
            listaNomeAlunos.add(aluno.getNome());
            System.out.println("\n"+aluno.getNome()+" foi adicionado ao curso de "+curso.getNomeCurso());
        }
    }
    // método remove aluno:
    public void removeAluno(Aluno aluno, Curso curso) {
        listaAlunos.remove(aluno);
        listaNomeAlunos.remove(aluno.getNome());
        System.out.println("\n"+aluno.getNome()+" foi removido do curso de "+curso.getNomeCurso()+".");
    }
    // getter codigo - usado em Avaliacao:
    public int getCodigoTurma() {
        return codigo;
    }
    // método com resumo da turma:
    public String resumoTurma() {
        return "Dados da turma do curso de "+this.curso.getNomeCurso()+":"+
        "\nCódigo da turma: "+this.codigo+
        "\nProfessor: "+this.professor.getNome()+
        "\nQuantidade de alunos: "+listaAlunos.size()+" - "+listaNomeAlunos+"\n";
    }
}


// this.dadosSalvos = new ArmazTemporario();    

// private ArmazTemporario dadosSalvos;

//     public Turma(ArmazTemporario dados) {
//         this.dadosSalvos = dados;
//     }

// // método adiciona aluno: 
    // public static void criaTurmas() {
    //     List<Aluno> lAlunos = dadosSalvos.getListaAlunos();
    //     if (aluno.getCursoAluno().equals(curso.getNomeCurso())) {
    //         listaAlunos.add(aluno);
    //         listaNomeAlunos.add(aluno.getNome());
    //         System.out.println("Aluno adicionado ao curso de "+curso.getNomeCurso());  
    //     // List<Curso> lCursos = dadosSalvos.getListaCursos();
    //     // Aluno aluno = dadosSalvos.encontraAluno(matricula);
    //     // Curso cursos = dadosSalvos.encontraCurso(curso); 
    //     for (Aluno aluno : lAlunos) {
    //         for (Curso curso : lCursos) {
    //             }
    //         }
    //     }
    // }
    //          BACKUP
    // // método adiciona aluno: 
    // public static void criaTurmas(List<Aluno> lAlunos, List<Curso> lCursos) {
    //     // lAlunos = dadosSalvos.getListaAlunos();
    //     // Aluno aluno = dadosSalvos.encontraAluno(matricula);
    //     // Curso cursos = dadosSalvos.encontraCurso(curso); 
    //     for (Aluno aluno : lAlunos) {
    //         for (Curso curso : lCursos) {
    //             if (aluno.getCursoAluno().equals(curso.getNomeCurso())) {
    //                 listaAlunos.add(aluno);
    //                 listaNomeAlunos.add(aluno.getNome());
    //                 System.out.println("Aluno adicionado ao curso de "+curso.getNomeCurso());  
    //             }
    //         }
    //     }
    // }