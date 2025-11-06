public class CursoEAD extends Curso {
    // atributo plataforma:
    private String plataforma;
    // constructor - herda construtor vazio da superclasse Curso:
    public CursoEAD (String plataforma) {
        super();
        if (plataforma == null) {
            throw new NullPointerException("\nInforme a plataforma do curso EAD.");
        }
        this.plataforma = plataforma;
    }
    // constructor - herda construtor apenas nome da superclasse Curso:
    public CursoEAD (String nomeCurso, String plataforma) {
        if (nomeCurso == null) {
            throw new NullPointerException("Informe o nome do curso EAD.");
        }
        if (plataforma == null) {
            throw new NullPointerException("Informe a plataforma do curso EAD.");
        }        
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
