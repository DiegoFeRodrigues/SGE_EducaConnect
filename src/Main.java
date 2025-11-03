public class Main {
    public static void main(String[] args) {
        // bloco try - tenta validação de métodos e instancia de objetos:
        try {
            // instanciando objetos - alunos:
            Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
            Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
            Aluno aluno3 = new Aluno("Kakarotto", "Artes marciais", 59);
            // cursos:
            Curso curso1 = new Curso("ADS", 54321, 2180f);
            Curso curso2 = new Curso("Artes marciais", 98765, 10000f);
            // professores:
            Professor professor1 = new Professor("Flavio Ceci", "POO", 134679);
            Professor professor2 = new Professor("Mestre Kame", "Estilo da tartaruga", 00001);
            // turmas:
            Turma turma1 = new Turma(12345, curso1, professor1);
            Turma turma2 = new Turma(54321, curso2, professor2);
    
            // instanciando nova avaliação:
            Avaliacao prova = new Avaliacao("Prova de POO.");
    
            // turma1 - atribuindo nota e saída com resultadoda avaliação PROVA:
            System.out.println("Resultado da avaliação - Turma de "+turma1.getCursoTurma().getNomeCurso()+":");
            
            prova.atribuirNota(aluno1, turma1, 6f);
            System.out.println(prova.resultado(aluno1, turma1, prova));
    
            // instanciando nova avaliação:
            Avaliacao treino = new Avaliacao("Carregar caixas de leite.");
    
            // turma2 - atribuindo notas e saída com resultados da avaliação TREINO:
            System.out.println("Resultado da avaliação - Turma de "+turma2.getCursoTurma().getNomeCurso()+":");
            
            treino.atribuirNota(aluno2, turma2, 8f);
            System.out.println(treino.resultado(aluno2, turma2, treino));

            treino.atribuirNota(aluno3, turma2, 10f);
            System.out.println(treino.resultado(aluno3, turma2, treino));
        }
        // bloco catch para captura e saída de erros em métodos e/ou objetos que não puderem ser instanciados: 
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("Erro: "+npeouiae.getMessage());
        }
    }
}