public class Main {
    public static void main(String[] args) {
        // instanciando novos objetos:        
        Aluno aluno = new Aluno("Diego Ferreira Rodrigues", "ADS", 12345);
        Professor professor = new Professor("Flavio Ceci", "POO", 98765);
        Curso curso = new Curso("ADS", 54321, 2180f);
        
        // saída para testar intancias e validar atributos:
        System.out.println("\nSaída com dados de Aluno, Professor e Curso:\n"+
        "\nDados do aluno:\n"+aluno.dadosAluno()+"\n\nDados do Professor:\n"+professor.dadosProf()+
        "\n\nDados do curso:\n"+curso.dadosCurso()+"\n");
    }
}