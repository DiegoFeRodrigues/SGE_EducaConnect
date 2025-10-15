public class Turma {
    // atributos:
    private Curso codigo;
    private Curso nomeCurso;
    private Professor professor;
    
    public Turma(Curso codigo, Curso nomeCurso, Professor professor) {
        this.codigo = codigo;
        this.nomeCurso = nomeCurso;
        this.professor = professor;
    }
    
    // get e set codigo - Talvez seja removido:
    public Curso getCodigoTur() {
        return codigo;
    }
    public void setCodigoTur(Curso codigo) {
        this.codigo = codigo;
    }
    
    @Override
    public boolean equals(Object tur) {
        return ((Turma)tur).codigo == this.codigo;
    }
    
    // saída turma:
    @Override
    public String toString() {
        return "\n\nDados da turma:"+
        "\nProfessor: "+this.professor.getNomeProf()+
        "\nCurso: "+this.nomeCurso.getNomeCurso()+
        "\nQuantidade de alunos: VER LISTAS!!!";
    }
}