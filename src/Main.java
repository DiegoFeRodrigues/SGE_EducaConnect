public class Main {
    public static void main(String[] args) {
        // bloco try - tenta validação de instancia de objetos:
        try {

            System.out.println("=== EduConnect - Sistema de Gestão Educacional (SGC) ===");

            // instanciando Cursos - EAD:
            CursoEAD cyberSec = new CursoEAD("Cybersegurança", 513, 2500f, "Studeo");
            CursoEAD ads = new CursoEAD("ADS", 12345, 2180f, "Studeo");
            
            // saída com métodos detalharCurso() sobrescritos - CursoEAD:
            System.out.println("\nCursos à distância disponíveis:");
            System.out.println(cyberSec.detalharCurso());
            System.out.println(ads.detalharCurso());
            
            // instanciando Cursos - Presencial:
            CursoPresencial medicina = new CursoPresencial("Medicina", 7865, 8300, "12");
            CursoPresencial artesMarciais = new CursoPresencial("Artes Marciais", 54321, 20000f, "Sala do tempo");
            
            // saída com métodos detalharCurso() sobrescritos - CursoPresencial:
            System.out.println("\n\nCursos presenciais disponíveis:");
            System.out.println(medicina.detalharCurso());
            System.out.println(artesMarciais.detalharCurso()+"\n");

        }  
        // bloco catch para captura e saída de erros de objetos que não puderem ser instanciados: 
        catch (NullPointerException | IllegalArgumentException npeouiae) {
            System.err.println("\nErro: "+npeouiae.getMessage());
        }
    }    
}