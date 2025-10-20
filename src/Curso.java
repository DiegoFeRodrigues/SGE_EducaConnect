package src;
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
    //getters nome curso:
    public String getNomeCurso() {
        return nomeCurso;
    }
    public int getCodigo() {
        return codigo;
    }
    public float getCarga() {
        return cargaHoraria;
    }
    // saída curso:
    public String detalharCurso() {
        return "\n\nDados curso:\nNome do curso: "+getNomeCurso()+
        "\nCódigo: "+this.codigo+"\nCarga horária: "+this.cargaHoraria;
    }
}