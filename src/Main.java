public class Main {
    public static void main(String[] args) {
        // bloco try - tenta validação de métodos e instancia de objetos:
        try {

        // instanciando novo Curso EAD - APENAS PLATAFORMA:
        CursoEAD poo = new CursoEAD("Studeo");
        // saída com método detalharCurso() sobrescrito:
        System.out.println(poo.detalharCurso());

        // instanciando novo Curso Presencial - APENAS SALA:
        CursoPresencial quimica = new CursoPresencial("Laboratório de química");
        // saída com método detalharCurso() sobrescrito:
        System.out.println(quimica.detalharCurso());
        
        // instanciando novo Curso EAD - CURSO E PLATAFORMA:
        CursoEAD ads = new CursoEAD("ADS", "Studeo");
        // saída com método detalharCurso() sobrescrito:
        System.out.println(ads.detalharCurso());
        
        // instanciando novo Curso presencial - CURSO E SALA:
        CursoPresencial artesMarciais = new CursoPresencial("Artes Marciais", "Sala do tempo");
        System.out.println(artesMarciais.detalharCurso()+"\n");
    }
        // bloco catch para captura e saída de erros em métodos e/ou objetos que não puderem ser instanciados: 
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("Erro: "+npeouiae.getMessage());
        }  
    }  
}