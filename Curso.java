public class Curso {
    // atributos:
    private String nomeCurso;
    private int codigo;
    private float cargaHoraria;
    //constructor:
    public Curso(String nomeCur, int codigo, float carga) {
        this.nomeCurso = nomeCur;
        this.codigo = codigo;
        this.cargaHoraria = carga;
    }
    //getters e setters nome e código:
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

    // saída curso:
    public String toString() {
        return "\n\nDados curso:\nNome do curso: "+getNomeCurso()+
        "\nCódigo: "+getCodigo()+"\nCarga horária: "+this.cargaHoraria;
    }
}