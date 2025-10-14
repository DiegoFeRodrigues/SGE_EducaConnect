public class Turma {
    // atributos:
    private Curso codigo;
    private Curso nomeCurso;
    private Professor professor;
    
    public Curso getCodigoTur() {
        return codigo;
    }
    
    public void setCodigoTur(Curso codigo) {
        this.codigo = codigo;
    }
    
    public Curso getNomeCurso() {
        return nomeCurso;
    }
    
    public void setNomeCurso(Curso nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    
    public Professor getProfessor() {
        return professor;
    }
    
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    @Override
    public boolean equals(Object tur) {
        return ((Turma)tur).codigo == this.codigo;
    }

    // saída turma:
    @Override
    public String toString() {
        return "\nDados da turma:"+
            "\nProfessor: "+this.getProfessor().getNomeProf()+
            "\nCurso: "+this.getNomeCurso().getNomeCurso()+
            "\nQuantidade de alunos: VER LISTAS!!!";

    }
}
