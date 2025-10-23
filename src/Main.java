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
        // instanciando novo curso presencial - construtor apenas nome 
        CursoPresencial artesMarciais = new CursoPresencial(curso2.getNomeCurso());
        artesMarciais.setSala("Sala do tempo");
        // saída com metódo sobrescrito:
        System.out.println(artesMarciais.detalharCurso());

        // instanciando novo curso ead com construtor "hibrido", sem setter:
        CursoEAD poo = new CursoEAD(curso1.getNomeCurso(), "Studeo");
        System.out.println(poo.detalharCurso());

        // instanciando novo objeto da classe Administrador pra testar FaseCinco:
        Administrador adm = new Administrador("adm", "000");
        adm.autenticar("adm", "000");

        // Aluno alu10 = new Aluno("Anna", "Letras", 593150, "Anninha", "98@k9Lç$");
        // alu10.autenticar("Anninha", "98@k9Lç$");
        
        // System.out.println(alu10.toString(null, null));
        
        // System.out.println(adm.toString());
        

        // Aluno aluno5 = new Aluno(null, null);
        // aluno5.autenticar(null, null);

        // Aluno aluno6 = new Aluno("Diego", "ADS", 1904, "Dirod", "SPEORAKSDFJAS");
        // aluno6.autenticar("Dirod", "SPEORAKSDFJAS");

        // System.out.println(aluno6.toString());
    }
}