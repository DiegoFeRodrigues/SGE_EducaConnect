public class Curso {
    // atributos:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    // constructor:
    public Curso(String nomeCur, int codigo, float carga) {
        this.nomeCurso = nomeCur;
        this.codigo = codigo;
        this.cargaHoraria = carga;
    }
    // getters e setters - curso:
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
    public float getCargaH() {
        return cargaHoraria;
    }
    public void setCarga(float carga) {
        this.cargaHoraria = carga;
    }
    // método saída:
    public String dadosCurso() {
        return "Curso: " +getNomeCurso()+
        "\nCódigo: "+getCodigo()+
        "\nCarga horária: "+getCargaH();
    }
}