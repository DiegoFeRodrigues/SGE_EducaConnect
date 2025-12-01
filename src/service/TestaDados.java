/*
    Classe de apoio com métodos que verifica dados informados pelo usuário (input - scanner)
    Forçando a digitação de números inteiros nas opções de menus e/ou testando se número informado
    é maior que as opções mostradas.
*/

package service;

import java.util.List;
import java.util.Scanner;

public class TestaDados {

    // método para testar se valor digitado é número inteiro - usado em menus de opções e seleção de índices:
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
            System.out.println("\nErro: O valor digitado é inválido.");
            System.out.println("Digite apenas números inteiros. Não digite letras.");
            System.out.print("Informe "+dado);
            scan.nextLine();
            if (scan.hasNextInt()) {
                System.out.println("");
            }
        }
    }
    // verifica se valor do índice informado é maior que os índices da lista no armazenamento:
    public static void testaDadosArmazenados(String mensagem, Scanner scan, int numero, List lista) {
        System.out.print("\nInforme o número que corresponde "+mensagem);
        testaNumeroMenu(scan);  // testa se valor digitado é número inteiro
        numero = scan.nextInt();
        scan.nextLine();
        // evita que número de índice digitado seja maior que os índices da lista:
        while (numero >= lista.size()) {
            System.out.println("\nErro: Opção inválida.");
            System.out.print("Confira a lista acima.");
            System.out.print("Digite o número que corresponde "+mensagem);
            testaNumeroMenu(scan);  // testa se valor digitado é número inteiro
            numero = scan.nextInt();
            scan.nextLine();
        }
    }
}
