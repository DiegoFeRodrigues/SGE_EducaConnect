public class Main {
    public static void main(String[] args) {
        // instanciando novos objetos - alunos:
        Aluno aluno1 = new Aluno("Diego", "ADS", 12345);
        Aluno aluno2 = new Aluno("Kuririn", "Artes marciais", 18);
        Aluno aluno3 = new Aluno("Kakarotto", "Artes marciais", 59);
        Aluno aluno4 = new Aluno("Yamcha", "Artes marciais", 7);
        // cursos:
        Curso curso1 = new Curso("ADS", 54321, 2180f);
        Curso curso2 = new Curso("Artes marciais", 98765, 3865.3f);
        // professores:
        Professor professor1 = new Professor("Flavio Ceci", "POO", 134679);
        Professor professor2 = new Professor("Mestre Kame", "Estilo da tartaruga", 00001);
        // turmas:
        Turma turma1 = new Turma(curso1, curso1, professor1);
        Turma turma2 = new Turma(curso2, curso2, professor2);
        // adicionando aluno em seus cursos:
        System.out.println("Alunos adicionados:");
        turma1.addAluno(aluno1, curso1);
        turma2.addAluno(aluno2, curso2);
        turma2.addAluno(aluno3, curso2);
        turma2.addAluno(aluno4, curso2);
        // removendo aluno:
        System.out.println("\nAlunos removidos:");
        turma2.removeAluno(aluno4, curso2);
        // saída com resumo das turmas:
        System.out.println(turma1.toString()+"\n"+turma2.toString());
        // instanciando nova avaliação:
        Avaliacao prova = new Avaliacao("Prova de POO.");
        // atribuindo nota e saída com resultado - turma 1:
        prova.atribuirNota(aluno1, 6f);
        System.out.println("\nResultado avaliação da turma 1:"
        +prova.avaliacao(aluno1, turma1, prova));
        // instanciando nova avaliação:
        Avaliacao treino = new Avaliacao("Carregar caixas de leite.");
        // atribuindo nota e saída com resultado - turma 2:
        treino.atribuirNota(aluno2, 7.5f);
        System.out.println("\nResultado avaliação da turma 2:"
        +treino.avaliacao(aluno2, turma2, treino));
        treino.atribuirNota(aluno3, 10f);
        System.out.println(treino.avaliacao(aluno3, turma2, treino));
        // instanciando novo curso presencial e saída com metódo sobrescrito:
        CursoPresencial artesMarciais = new CursoPresencial(curso2.getNomeCurso(), curso2.getCodigo(), curso2.getCarga());
        artesMarciais.setSala("Sala do tempo.");
        System.out.println(artesMarciais.detalharCurso());
    }
}