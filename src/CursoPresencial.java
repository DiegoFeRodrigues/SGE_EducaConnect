public class CursoPresencial extends Curso {
    // constructor herdando o atributo nome de curso:
    public CursoPresencial(String nome) {
        super(nome);
    }
    // sobrescrita do método detalharCurso da classe Curso:
    @Override
    public String detalharCurso() {
        return "\nDetalhes do curso:"+
        "\nCurso de "+this.getNomeCurso()+"."+
        "\nSala: "+this.getSala()+".";
    }
}