import model.Administrador;
import model.Aluno;
import model.Curso;
import model.Professor;
import repository.ArmazTemporario;
import service.Avaliacao;
import service.CursoEAD;
import service.CursoPresencial;
import service.Turma;
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