public class CursoPresencial extends Curso {
    // atributo sala - curso presencial:
    private String sala;
    // constructor - herda nome, codigo e cargahoraria da superclasse Curso:
    public CursoPresencial(String nomeCurso, int codigo, float cargaHoraria, String sala) {
        if (sala == null) {
            throw new NullPointerException("Informe a sala do curso presencial.\n");
        }        
        super(nomeCurso, codigo, cargaHoraria);
        this.sala = sala;
    }
    // sobrescrita do método detalharCurso() da superclasse Curso:
    @Override
    public String detalharCurso() {
        return "\nCurso: "+this.getNomeCurso()+
        "\nCódigo: "+this.getCodigo()+
        "\nCarga horária: "+this.cargaHoraria()+
        "\nSala: "+this.sala;
    }
}