public class Main {
    public static void main(String[] args) {
        // bloco try para tentar a validação na instancia de objetos:
        try {
            System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****");

            // instanciando objetos de Aluno, Professor e Curso:
            Aluno aluno = new Aluno("Diego Ferreira Rodrigues", "ADS", 12345);
            Professor professor = new Professor("Flavio Ceci", "POO", 98765);
            Curso curso = new Curso("Análise e Desenvolvimento de Sistemas", 54321, 2180f);
            
            // saída com retorno dos dados dos objetos instanciados:
            System.out.println("\nAlunos matriculados:");
            System.out.println(aluno.dadosAluno());

            System.out.println("\nProfessores registrados:");
            System.out.println(professor.dadosProf());
            
            System.out.println("\nCursos disponíveis:");
            System.out.println(curso.dadosCurso());
        }
        // bloco catch para captura e saída de erros de objetos que não puderem ser instanciados:
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("Erro: "+npeouiae.getMessage());
        }
    }
}