import ui.MenuInterativo;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("\n**** EduConnect - Sistema de Gestão Educacional (SGC) ****\n\n");
    
            MenuInterativo menuI = new MenuInterativo();
            menuI.Menu();        
        }
        catch (NullPointerException | IllegalArgumentException npeOUiae) {
            System.err.println(npeOUiae);
        }
    }
}