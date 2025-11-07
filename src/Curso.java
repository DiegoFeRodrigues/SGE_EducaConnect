public class Curso {
    // atributos curso:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    // constructor curso - valida e inicia atributos:
    public Curso(String nomeCurso, int codigo, float cargaHoraria) {
        if (nomeCurso == null) {
            throw new NullPointerException("Informe o nome do curso.");
        }
        if (codigo <= 0) {
            throw new IllegalArgumentException("Codigo do curso deve ser maior que 0.");
        }
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("A carga horária do curso deve ser maior que 0.");
        }
        this.nomeCurso = nomeCurso;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }
    //getter nome do curso - usado em Turma:
    public String getNomeCurso() {
        return nomeCurso;
    }
    // método com dados - curso:
    public String dadosCurso() {
        return "\nCurso: " +this.nomeCurso+
        "\nCódigo: "+this.codigo+
        "\nCarga horária: "+this.cargaHoraria+"\n";
    }    
}