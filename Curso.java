public class Curso {

    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    
    public Curso(String nome, int codigo, float carga) {
        this.nomeCurso = nome;
        this.codigo = codigo;
        this.cargaHoraria = carga;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }
    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public float getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(float cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
