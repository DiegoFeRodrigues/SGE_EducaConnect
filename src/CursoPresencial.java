package src;

public class CursoPresencial extends Curso{
    private String nome;
    public CursoPresencial(String nome) {
        super("", 0, 0);
        this.nome = nome;
    }

    @Override
    public String detalharCurso() {
        return "O curso "+this.nome+
        " é presencial.";
    }
}
