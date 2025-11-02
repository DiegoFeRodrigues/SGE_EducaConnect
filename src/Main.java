public class Main {
    public static void main(String[] args) {
        // instanciando novos objetos - alunos:
        Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
        Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
        Aluno aluno3 = new Aluno("Kakarotto", "Artes marciais", 59);
        // cursos:
        Curso curso1 = new Curso("ADS", 54321, 2180f);
        Curso curso2 = new Curso("Artes marciais", 98765, 3865.3f);
        // professores:
        Professor professor1 = new Professor("Flavio Ceci", "POO", 134679);
        Professor professor2 = new Professor("Mestre Kame", "Estilo da tartaruga", 00001);
        // turmas:
        Turma turma1 = new Turma(curso1, curso1, professor1);
        Turma turma2 = new Turma(curso2, curso2, professor2);

        // instanciando nova avaliação:
        Avaliacao prova = new Avaliacao("Prova de POO.");

        // atribuindo nota e saída com resultado - turma 1:
        prova.atribuirNota(aluno1, turma1, 6f);
        System.out.println("\nResultado avaliação da turma 1:"+prova.avaliacao(aluno1, prova));

        // instanciando nova avaliação:
        Avaliacao treino = new Avaliacao("Carregar caixas de leite.");

        // atribuindo notas e saída com resultados - turma 2:
        treino.atribuirNota(aluno2, turma2, 8f);
        System.out.println("\nResultado avaliação da turma 2:"+treino.avaliacao(aluno2, treino));
        treino.atribuirNota(aluno3, turma2, 10f);
        System.out.println(treino.avaliacao(aluno3, treino)+"\n");
    }
}