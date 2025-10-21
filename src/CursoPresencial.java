public class CursoPresencial extends Curso {
    // atributo sala:
    private String sala;
    // constructor herdando o atributo nome de curso:
    public CursoPresencial(String nome) {
        super(nome);
    }
    // getter e setter sala:
    public void setSala(String sala) {
        this.sala = sala;
    }
    public String getSala() {
        return sala;
    }
    // sobrescrita do método detalharCurso da classe Curso:
    @Override
    public String detalharCurso() {
        return "\nDetalhes do curso:"+
        "\nCurso de "+this.getNomeCurso()+"."+
        "\nSala: "+this.getSala()+".";
    }
}