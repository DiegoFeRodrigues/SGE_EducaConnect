public class CursoPresencial extends Curso {
    // atributo sala - curso presencial:
    private String sala;
    // constructor - herda construtor vazio da superclasse Curso:
    public CursoPresencial(String sala) {
        super();
        if (sala == null) {
            throw new NullPointerException("Informe a sala do curso presencial.");
        }
        this.sala = sala;
    }
    // constructor - herda construtor apenas nome da superclasse Curso:
    public CursoPresencial(String nomeCurso, String sala) {
        if (nomeCurso == null) {
            throw new NullPointerException("Informe o nome do curso presencial.");
        }
        if (sala == null) {
            throw new NullPointerException("Informe a sala do curso presencial.");
        }
        super(nomeCurso);
        this.sala = sala;
    }
    // CONSTRUCTOR - TUDO JUNTO!!!!!!!!!!
    public CursoPresencial(String nomeCurso, int codigo, float cargaHoraria, String sala) {
        super(nomeCurso, codigo, cargaHoraria);
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

