public class CursoEAD extends Curso {
    // atributo plataforma:
    private String plataforma;
    // constructor - herda construtor vazio da superclasse Curso:
    public CursoEAD (String plataforma) {
        super();
        this.plataforma = plataforma;
    }
    // constructor - herda construtor apenas nome da superclasse Curso:
    public CursoEAD (String nomeCurso, String plataforma) {
        super(nomeCurso);
        this.plataforma = plataforma;
    }

    // sobrescrevendo método detalharCurso() da superclasse Curso:
    @Override
    public String detalharCurso() {
        if (this.getNomeCurso() == null) {
            return "\nDetalhes do curso EAD:"+
            "\nPlataforma: "+this.plataforma+".";
        }
        return "\nDetalhes do curso EAD:"+
        "\nCurso: "+this.getNomeCurso()+
        "\nPlataforma: "+this.plataforma+".";
    }
}
