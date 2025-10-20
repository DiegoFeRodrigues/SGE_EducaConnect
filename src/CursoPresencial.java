package src;
public class CursoPresencial extends Curso {
    // atributo sala:
    private String sala;
    // constructor herdando os atributos de curso:
    public CursoPresencial(String nome, int codigo, float carga) {
        super(nome, codigo, carga);
    }
    // getter e setter sala:
    public void setSala(String sala) {
        this.sala = sala;
    }
    public String getSala() {
        return sala;
    }
    // sobrescrevendo o método detalharCurso da classe Curso:
    @Override
    public String detalharCurso() {
        return "\nSala do curso de "+this.getNomeCurso()+
        ": "+this.getSala();
    }
}
