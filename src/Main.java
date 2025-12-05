public class Main {
    public static void main(String[] args) {
        // bloco try - tenta validação de métodos e instancia de objetos:
        try {
            System.out.println("\n*** EduConnect - Sistema de Gestão Educacional (SGE) ***");

            // alunos:
            Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
            Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
            Aluno aluno3 = new Aluno("Kakarotto", "Artes marciais", 59);
            // cursos:
            Curso curso1 = new Curso("Artes marciais", 98765, 20000f);
            Curso curso2 = new Curso("ADS", 54321, 2180f);
            // professores:
            Professor professor1 = new Professor("Mestre Kame", "Estilo da tartaruga", 00001);
            Professor professor2 = new Professor("Flavio Ceci", "POO", 134679);
            // turmas:
            Turma turma1 = new Turma(54321, curso1, professor1);
            Turma turma2 = new Turma(12345, curso2, professor2);
    
            // instanciando novas avaliações:
            Avaliacao prova = new Avaliacao("Prova de POO.");
            Avaliacao treino = new Avaliacao("Carregar caixas de leite.");
    
            System.out.println("\n\nResultado de avaliações:");
            
            // turma2 - atribuindo nota e saída com resultado da avaliação PROVA:
            System.out.println("\nTurma de "+turma2.getCursoTurma().getNomeCurso()+":");

            prova.atribuirNota(aluno1, turma2, 6f);
            System.out.println(prova.resultado(aluno1, turma2, prova));
            
            // turma1 - atribuindo notas e saída com resultados da avaliação TREINO:
            System.out.println("\n\nTurma de "+turma1.getCursoTurma().getNomeCurso()+":");

            treino.atribuirNota(aluno2, turma1, 8.5f);
            System.out.println(treino.resultado(aluno2, turma1, treino));

            treino.atribuirNota(aluno3, turma1, 10f);
            System.out.println(treino.resultado(aluno3, turma1, treino)+"\n");
        }
        // bloco catch para captura e saída de erros em métodos e/ou objetos que não puderem ser instanciados: 
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("Erro: "+npeouiae.getMessage());
        }
    }
}