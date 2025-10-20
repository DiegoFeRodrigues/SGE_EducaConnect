package src;

public class CursoPresencial extends Curso {
    public CursoPresencial(String nome, int codigo, float carga) {
        super(nome, codigo, carga);
    }

    @Override
    public String detalharCurso() {
        return "\nLocal do curso de "+this.getNomeCurso()+
        " é presencial.";
    }
}
