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
    // constructor vazio - herdado em CursoEAD e CursoPresencial:
    public Curso () {
    }
    // constructor apenas nome - herdado em CursoEAD e CursoPresencial:
    public Curso (String nome) {
        this.nomeCurso = nome;
    }
    //getter nome do curso - usado em Turma:
    public String getNomeCurso() {
        return nomeCurso;
    }
    // Método detalharCurso() - Será sobrescrito nas subclasses:
    public String detalharCurso() {
        return "\n\nDados curso:\nNome do curso: "+this.getNomeCurso()+
        "\nCódigo: "+this.codigo+"\nCarga horária: "+this.cargaHoraria;
    }    
}