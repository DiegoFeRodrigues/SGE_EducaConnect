public class Curso {
    // atributos curso:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    //constructor:
    public Curso(String nomeCur, int codigo, float carga) {
        this.nomeCurso = nomeCur;
        this.codigo = codigo;
        this.cargaHoraria = carga;
    }
    //getters nome curso - usados em Turma:
    public String getNomeCurso() {
        return nomeCurso;
    }
    public int getCodigo() {
        return codigo;
    }
}