public class CursoEAD extends Curso {
    // atributo plataforma - curso EAD:
    private String plataforma;
    // constructor - herda nome, codigo e cargahoraria da superclasse Curso:
    public CursoEAD(String nomeCurso, int codigo, float cargaHoraria, String plataforma) {
        if (plataforma == null) {
            throw new NullPointerException("Informe a plataforma do curso EAD.\n");
        }        
        super(nomeCurso, codigo, cargaHoraria);
        this.plataforma = plataforma;
    }
    // sobrescrevendo método gerarRelatorio() da superclasse Curso:
    @Override
    public String gerarRelatorio() {
        return "\nCurso: "+this.getNomeCurso()+
        "\nCódigo: "+this.getCodigo()+
        "\nCarga horária: "+this.cargaHoraria()+
        "\nPlataforma: "+this.plataforma;
    }
}
