public class Main {
    public static void main(String[] args) {
        // bloco try para tentar a validação na instancia de objetos:
        try {
            // instanciando objetos de Aluno, Professor e Curso:
            Aluno aluno = new Aluno("Diego Ferreira Rodrigues", "ADS", 12345);
            Professor professor = new Professor("Flavio Ceci", "POO", 98765);
            Curso curso = new Curso("ADS", 54321, 2180f);
            
            // saída para testar objetos instanciados:
            System.out.println("\nSaída com dados de Aluno, Professor e Curso:\n"+
            "\nDados do aluno:\n"+aluno.dadosAluno()+"\n\nDados do Professor:\n"+professor.dadosProf()+
            "\n\nDados do curso:\n"+curso.dadosCurso()+"\n");
        }
        // bloco catch para captura e saída de erros de objetos que não puderem ser instanciados:
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("Erro: "+npeouiae.getMessage());
        }
    }
}