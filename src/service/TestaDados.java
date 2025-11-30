/*
    Classe de apoio com métodos que verifica dados informados pelo usuário (input - scanner)
    Forçando a digitação de números inteiros nas opções de menus e/ou testando se número informado
    é maior que as opções mostradas.
*/

package service;

import java.util.Scanner;
import repository.ArmazTemporario;

public class TestaDados {

        // método para testar se valor digitado é número inteiro - usado em menus de opções:
    public static void testaNumeroMenu(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("\nErro: Opção inválida.");
            System.out.print("Confira as opções acima e digite o NÚMERO correspondente à opção desejada: ");
            scan.nextLine();
        }
    }
    // método para testar se valor digitado é número inteiro - usado em cadastro de dados (matrículas, registros e códigos):
    public static void testaNumeroDados(Scanner scan, String dado) {
        while (!scan.hasNextInt()) {
            System.out.println("\nErro: O número digitado é inválido.");
            System.out.println("Digite apenas números inteiros, sem letras.");
            System.out.print("Informe "+dado);
            scan.nextLine();
            if (scan.hasNextInt()) {
                System.out.println("");
            }
        }
    }
    // método que verifica se valor informado é maior que o número de cursos no armazenamento em lista:
    public static void testaCursosArmazenados(Scanner scan) {
        System.out.println("\nCursos disponíveis:\n");
        ArmazTemporario.mostraListaCursos();
        System.out.print("\nInforme o número que corresponde ao curso do aluno: ");
        testaNumeroMenu(scan);
        while (scan.nextInt() >= ArmazTemporario.listaCursos.size()) {
            System.out.println("\nErro: Opção inválida");
            System.out.print("Confira a lista acima e digite o número do curso: ");
            scan.nextLine();
        }
    }

}
