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
            System.out.println("\nErro: O valor digitado é inválido.");
            System.out.println("Digite apenas números inteiros. Não digite letras.");
            System.out.print("Informe "+dado);
            scan.nextLine();
            if (scan.hasNextInt()) {
                System.out.println("");
            }
        }
    }
    // mostra lista de cursos e seus índices e verifica se valor do índice informado é maior que o número de cursos no armazenamento em lista:
    public static void testaCursosArmazenados(Scanner scan, int numero) {
        System.out.println("\nCursos disponíveis:\n");
        ArmazTemporario.mostraListaCursos();    // mostra lista de cursos salvos no armazenamento temporário em lista
        System.out.print("\nInforme o número que corresponde ao curso do aluno: ");
        testaNumeroMenu(scan);  // testa se valor digitado é número inteiro
        numero = scan.nextInt();
        scan.nextLine();
        while (numero >= ArmazTemporario.listaCursos.size()) {
            System.out.println("\nErro: Opção inválida");
            System.out.print("Confira a lista acima e digite o número do curso: ");
            testaNumeroMenu(scan);  // testa se valor digitado é número inteiro
            numero = scan.nextInt();
            scan.nextLine();
        }
    }
    

}
