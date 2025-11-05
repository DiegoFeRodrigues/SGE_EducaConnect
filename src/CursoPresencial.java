public class CursoPresencial extends Curso {
    // atributo sala - curso presencial:
    private String sala;
    // constructor - herda construtor vazio da superclasse Curso:
    public CursoPresencial(String sala) {
        super();
        this.sala = sala;
    }
    // constructor - herda construtor apenas nome da superclasse Curso:
    public CursoPresencial(String nomeCurso, String sala) {
        super(nomeCurso);
        this.sala = sala;
    }
    // sobrescrita do método detalharCurso() da superclasse Curso:
    @Override
    public String detalharCurso() {
        if (this.getNomeCurso() == null) {
            return "\nDetalhes do curso presencial:"+
            "\nSala: "+this.sala+".";
        }
        return "\nDetalhes do curso presencial:"+
        "\nCurso: "+this.getNomeCurso()+
        "\nSala: "+this.sala+".";
    }
}

