public class CursoEAD extends Curso {
    // atributo:
    private String plataforma;
    // constructor herdando atributo nome de curso:
    public CursoEAD(String nome) {
        super(nome);
    }
    // setter e getter plataforma:
    public void setPlataforma (String p) {
        this.plataforma = p;
    }
    public String getPlataforma() {
        return plataforma;
    }
    // sobrescrevendo método detalharCurso da classe curso:
    @Override
    public String detalharCurso() {
        return "\nDetalhes do curso:"+
        "\nDisciplina: "+this.getNomeCurso()+"."+
        "\nPlataforma: "+this.plataforma+".";
    }
}
