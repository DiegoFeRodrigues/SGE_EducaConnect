/*
    Classe de apoio com métodos que verifica dados informados pelo usuário (input - scanner)
    Forçando a digitação de números inteiros nas opções de menus e/ou testando se número informado
    é maior que as opções mostradas.
*/

package service;

import java.util.List;
import java.util.Scanner;

public class TestaDados {

    // método que valida se valor digitado é número inteiro - usado em menus de opções e seleção de índices:
    public static void testaNumeroMenu(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("\nErro: Opção inválida.");
            System.out.print("Confira as opções acima e digite o NÚMERO correspondente à opção desejada: ");
            scan.nextLine();
        }
    }
    // método que valida se valor digitado é número inteiro - usado em cadastro de dados (matrículas, registros e códigos):
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
    // método que valida opção digitada em menus com duas opções (1 ou 2): 
    public static int testaMenu1ou2(Scanner scan, String mensagem, String msg) {
        System.out.print("Informe o número que corresponde "+mensagem);
        TestaDados.testaNumeroMenu(scan);   // testa se valor de menu informado é número inteiro.
        int numero = scan.nextInt();
        scan.nextLine();
        while (numero <= 0 || numero > 2) {
            System.out.println("\nErro: Opção inválida!");
            System.out.println(msg);
            System.out.print("Digite opção: ");
            TestaDados.testaNumeroMenu(scan);   // testa se valor de menu informado é número inteiro.
            numero = scan.nextInt();
            scan.nextLine();
        }
        return numero;
    }
    // método que valida se valor do índice informado é maior que os índices da lista no armazenamento:
    public static int testaDadosArmazenados(String mensagem, Scanner scan, List lista) {
        System.out.print("\nInforme o número que corresponde "+mensagem);
        testaNumeroMenu(scan);  // testa se valor digitado é número inteiro
        int numero = scan.nextInt();
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
        return numero;
    }
}
