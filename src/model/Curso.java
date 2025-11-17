package model;

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
    // Método gerarRelatorio() - Será sobrescrito nas subclasses:
    public String gerarRelatorio() {
        return "\nDados curso:\nNome do curso: "+this.nomeCurso+        
        "\nCódigo: "+this.codigo+"\nCarga horária: "+this.cargaHoraria;
    }
}