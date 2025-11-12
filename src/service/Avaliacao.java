package service;

import model.Aluno;

public class Avaliacao {
    // atributos avaliação:
    private float nota;
    private String descricao;
    private Aluno aluno;
    private Turma turma;
    // constructor avaliação - valida e inicia atributo descrição:
    public Avaliacao(String descricao) {
        if (descricao == null) {
            throw new NullPointerException("Informe a descrição da avaliação.");
        }
        this.descricao = descricao;
    }    
    // metodo atribuir nota associando alunos em turmas e validando dados informados:
    public void atribuirNota(Aluno aluno, Turma turma, float nota) {
        if (aluno == null) {
            throw new NullPointerException("Informe o objeto aluno desejado.");
        }
        if (turma == null) {
            throw new NullPointerException("Informe o objeto turma desejado.");
        }
        if (nota < 0 || nota > 10) { // valida se nota está entre 0 e 10
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
        }
        this.aluno = aluno;
        this.turma = turma;
        this.nota = nota;
    }
    // saída com resultado da avaliação:
    public String resultado(Aluno aluno, Turma turma, Avaliacao nota) {
        return "Nome do Aluno: "+this.aluno.getNomeAluno()+
        "\nCódigo da turma: "+this.turma.getCodigoTurma()+
        "\nDescrição da avaliação: "+this.descricao+
        "\nNota: "+this.nota+"\n";        
    }
}
