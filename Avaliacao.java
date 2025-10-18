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
        if (nota >= 0 && nota <= 10) {
            return true;
        }else {
            return false;   
        } 
    }
    // getters nota e descrição:
    public float getNota() {
        return nota;
    }
    public String getDescricao() {
        return descricao;
    }
    
    @Override
    public String toString() {
        if (!this.testaNota()) {
            return "\nNota inválida para a avaliação "+
            this.descricao;
        } else {
            return "\nResultado da avaliação:"+
            "\nNome do Aluno: "+aluno.getNomeAlu()+
            "\nDescrição da avaliação: "+this.descricao+
            "\nNota: "+this.getNota();
        }
    }

}
