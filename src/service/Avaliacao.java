package service;

import model.Aluno;

public class Avaliacao {
    // atributos:
    private float nota;
    private String descricao;
    private Aluno aluno;
    // constructor:
    public Avaliacao(String descrição) {
        this.descricao = descrição;
    }
    // metodo atribuir nota:
    public void atribuirNota(Aluno aluno, float valor) {
        this.aluno = aluno;
        this.nota = valor;
    }
    // metodo testa nota:
    private boolean testaNota() {
        if (nota >= 0 && nota <= 10) {return true;}
        else {return false;} 
    }
    // getter nota:
    public float getNota() {
        return nota;
    }

    // saída com resumo da avaliação:
    public String avaliacao(Aluno aluno, Turma turma, Avaliacao nota) {
        if (!this.testaNota()) {
            return "\nNota inválida para a avaliação "+
            this.descricao;
        } else {
            return "\nNome do Aluno: "+this.aluno.getNomeAlu()+
            "\nDescrição da avaliação: "+this.descricao+
            "\nNota: "+this.getNota();
        }
    }
}
