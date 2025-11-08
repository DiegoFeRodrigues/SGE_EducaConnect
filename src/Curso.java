public class Curso {
    // atributos curso:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    // constructor curso - valida e inicia atributos:
    public Curso(String nomeCurso, int codigo, float cargaHoraria) {
        if (nomeCurso == null) {
            throw new NullPointerException("Informe o nome do curso.\n");
        }
        if (codigo <= 0) {
            throw new IllegalArgumentException("Codigo do curso deve ser maior que 0.\n");
        }
        if (cargaHoraria <= 0) {
            throw new IllegalArgumentException("A carga horária do curso deve ser maior que 0.\n");
        }
        this.nomeCurso = nomeCurso;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }
    //getters  - usados em Turma, CursoEAD e CursoPresencial:
    public String getNomeCurso() {
        return nomeCurso;
    }
    public int getCodigo() {
        return codigo;
    }
    public float cargaHoraria() {
        return cargaHoraria;
    }
    // Método detalharCurso() - Será sobrescrito nas subclasses:
    public String detalharCurso() {
        return "\n\nDados curso:\nNome do curso: "+this.getNomeCurso()+
        "\nCódigo: "+this.codigo+"\nCarga horária: "+this.cargaHoraria;
    }    
}