import repository.ArmazTemporario;
import ui.MenuInterativo;
import ui.MenuRelatorios;

public class Main {
    public static void main(String[] args) {

        ArmazTemporario dadosSalvos = new ArmazTemporario();

        MenuInterativo menuI = new MenuInterativo(dadosSalvos);
        menuI.Menu();

        // CHAMANDO MENU DE RELATÓRIOS NO MAIN:
        MenuRelatorios menuRelatorios = new MenuRelatorios(dadosSalvos);
        menuRelatorios.menuR();
    }
}