public class Avaliacao {
    // atributos avaliação:
    private float nota;
    private String descricao;
    private Aluno aluno;
    private Turma turma;
    // constructor:
    public Avaliacao(String descrição) {
        this.descricao = descrição;
    }
    // metodo atribuir nota associando alunos em turmas:
    public void atribuirNota(Aluno aluno, Turma turma, float valor) {
        this.aluno = aluno;
        this.turma = turma;
        this.nota = valor;
    }
    // metodo testa nota:
    private boolean testaNota() {
        if (nota <= 0 || nota > 10) {
            return false;
        }
        return true; 
    }
    // saída com resumo da avaliação:
    public String avaliacao(Aluno aluno, Avaliacao nota) {
        if (!this.testaNota()) {
            return "\nNota inválida para a avaliação "+
            this.descricao;
        }
        return "\nNome do Aluno: "+this.aluno.getNomeAlu()+
        "\nDescrição da avaliação: "+this.descricao+
        "\nNota: "+this.nota;
    }
}
