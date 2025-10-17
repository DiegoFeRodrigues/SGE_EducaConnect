public class Avaliacao {
    private float nota;
    private String descricao;
    private Aluno aluno;
    
    public Avaliacao(String descrição) {
        this.descricao = descrição;
    }

    public void atribuirNota(Aluno aluno, float valor) {
        this.aluno = aluno;
        this.nota = valor;
    }
    
    private boolean testaNota() {
        if (nota >= 0 && nota <= 10) {
            return true;
        }else {
            return false;   
        } 
    }

    public float getNota() {
        return nota;
    }
    public String getDescricao() {
        return descricao;
    }

    public String avaliacao (Aluno alu, Avaliacao prova, Avaliacao descricao) {
        return "\nO aluno "+alu.getNomeAlu()+
        " tirou "+prova.getNota()+" na avaliação "+prova.getDescricao();
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
