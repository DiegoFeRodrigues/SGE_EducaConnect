/*
    Classe de apoio com métodos auxiliares
    Forçando a digitação de números inteiros ou reais nas opções de menus e/ou testando se número informado
    é maior que as opções mostradas e/ou auxiliando com listas de objetos.
*/

package service;

import java.util.List;
import java.util.Scanner;

public class Apoio {

    // método que valida se valor do buffer é número inteiro - usado em menus de opções e seleção de índices:
    public static void validaNumeroMenu(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.println("\nErro: Opção inválida.");
            System.out.print("Confira as opções acima e digite o NÚMERO correspondente à opção desejada: ");
            scan.nextLine();
        }
    }
    // método que valida se valor do buffer é número inteiro - usado em cadastro de dados (matrículas, registros e códigos):
    public static void validaNumeroDados(Scanner scan, String texto) {
        while (!scan.hasNextInt()) {
            System.out.println("\nErro: O valor do buffer é inválido.");
            System.out.println("Digite apenas números inteiros.");
            System.out.println("Não digite letras nem símbolos especiais.");
            System.out.print("\nInforme "+texto);
            scan.nextLine();
            if (scan.hasNextInt()) {
                System.out.println("");
            }
        }
    }
    // método que valida se valor do buffer é número real (ponto flutuante) - usado em carga horária de curso e registrar avaliações:
    public static void validaNumeroReal(Scanner scan, String texto) {
        System.out.print(texto);
        while (!scan.hasNextFloat()) {
            System.out.println("\nErro: O valor do buffer é inválido.");
            System.out.print("\nInforme "+texto);
            scan.nextLine();
            if (scan.hasNextFloat()) {
                System.out.println("");
            }
        }
    }
    // método que valida números digitados em menus com apenas duas opções (1 ou 2):
    public static int validaMenu1ou2(Scanner scan, String texto1, String texto2) {
        System.out.print("Informe o número que corresponde "+texto1);
        Apoio.validaNumeroMenu(scan);   // testa se valor do buffer é número inteiro.
        int numero = scan.nextInt();
        scan.nextLine();
        while (numero <= 0 || numero > 2) {
            System.out.println("\nErro: Opção inválida!");
            System.out.println(texto2);
            System.out.print("Digite opção: ");
            Apoio.validaNumeroMenu(scan);   // testa se valor do buffer é número inteiro.
            numero = scan.nextInt();
            scan.nextLine();
        }
        return numero;
    }
    // método que valida se valor do índice informado é maior que os índices das listas no armazenamento:
    public static int validaDadosArmazenados(String texto, Scanner scan, List lista) {
        System.out.print("\nInforme o número que corresponde "+texto);
        validaNumeroMenu(scan);  // testa se valor do buffer é número inteiro
        int numero = scan.nextInt();
        scan.nextLine();
        // evita que número de índice digitado seja maior que os índices da lista:
        while (numero >= lista.size()) {
            System.out.println("\nErro: Opção inválida.");
            System.out.print("Confira a lista acima.");
            System.out.print("\nDigite o número que corresponde "+texto);
            validaNumeroMenu(scan);  // testa se valor do buffer é número inteiro
            numero = scan.nextInt();
            scan.nextLine();
        }
        return numero;
    }
    /* Generics: método com objeto genérico, implementa a interface NumeroCadastroObjetos para acessar
       números de cadastro (matricula, registro ou código) utilizei essa opção para evitar 
       ter que criar um foreach para cada tipo de objeto como fiz no MenuRelatorios: */
    public static <T extends NumeroObjetoCadastro> boolean evitaNumeroDuplicado(int numero, List<T> lista) {
        for (T objeto : lista) {
            if (numero == objeto.getNumero()) {
                return false;
            } 
        } 
        return true;
    }

}
