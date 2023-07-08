//ManipulationString.java
//Creator: GuilhermeJSouza
//Date: 07/07/2023
//Description: Código para "Desafio de Código: Manipulação de Strings" do processo seletivo da empresa PWC para a vaga de estágio em Tecnologia.

//Página 474 - Manipulação de String
//Página 226 - ArrayList

import java.util.Scanner;
import java.util.ArrayList;

public class ManipulationString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Inicia o objeto Scanner.

        System.out.println("""

                Digite o número correspondente à operação a ser realizada:

                1  Reverter ordem
                2  Remover duplicata
                3  Encontre Palíndromo
                4  Iniciais maiúsculas
                5  Anagrama"""); // Apresenta ao usuário as opções de comando

        int comando = input.nextInt(); // recebe a entrada do usuário em relação ao comando selecionado
        String limpa = input.nextLine(); // limpa a entrada de dados para aguardar a String

        if (comando >= 1 && comando <= 5) // Analisa qual a operação selecionada pelo comando do usuário
        {
            switch (comando) // Escolhe a execução de acordo com o comando do usuário
            {
                case 1: // Comando reverter ordem

                    System.out.println("Digite a frase a ser revertida."); // Comunica ao usuário o próximo comando

                    String frase = input.nextLine(); // Lê a entrada do usuário

                    String fraseNova = reverta(frase); // Executa o comando especificado

                    System.out.println(fraseNova);

                    break;

                case 2: // Comando remover duplicata

                    System.out.println("Digite a frase para remover caracteres duplicados."); // Comunica ao usuário o
                                                                                              // próximo comando

                    String frase2 = input.nextLine(); // Lê a entrada do usuário

                    String fraseNova2 = RemoveDuplicata(frase2); // Executa o comando especificado

                    System.out.println(fraseNova2);

                    break;

                case 3:

                    System.out.println("Digite a frase para encontrar o palíndromo");

                    String frase3 = input.nextLine();

                    String fraseNova3 = Palindromo(frase3);

                    System.out.println(fraseNova3);

                    break;

                case 4:

                    System.out.println("Digite a frase para colocar maiúsculas.");

                    String frase4 = input.nextLine();

                    String fraseNova4 = Maiuscula(frase4);

                    System.out.println(fraseNova4);

                    break;

                /*
                 * case 5:
                 * 
                 * System.out.println("Digite a frase para colocar maiúsculas.");
                 * 
                 * String frase5 = input.nextLine();
                 * 
                 * String fraseNova5 = Anagrama(frase5);
                 * 
                 * System.out.println(fraseNova5);
                 * 
                 * break;
                 */
            }
        }

    }

    // #####################################################################################################################//#endregion

    // Comando Reverter a String
    public static String reverta(String frase) {
        ArrayList<Integer> separadores = new ArrayList<Integer>(); // Declaração do Array para as posições onde tem
                                                                   // espaço na String
        separadores.add(0); // Inicia o array

        ArrayList<String> palavras = new ArrayList<String>(); // Declaração do Array para guardar palavras
        palavras.add("vazia"); // Inicia o array

        String fraseRevertida = "";

        // LOCALIZAÇÃO DOS ESPAÇOS
        separadores.set(0, frase.indexOf(" ")); // adiciona na posição zero a posição do primeiro retorno de espaço

        for (int x = frase.indexOf(" ") + 1; x < frase.length(); x++) // Iteração para encontrar todos os espaços da
                                                                      // frase
        {
            if (frase.substring(x, x + 1).equals(" ")) {
                separadores.add(frase.indexOf(" ", x));
            }
        }

        // PALAVRAS QUE COMPÕEM A FRASE
        palavras.set(0, frase.substring(0, separadores.get(0))); // Insere a primeira palavra

        for (int y = 1; y < separadores.size(); y++) { // Insere as palavras do meio
            palavras.add(frase.substring(separadores.get(y - 1) + 1, separadores.get(y)));
        }

        palavras.add(frase.substring(separadores.get(separadores.size() - 1) + 1, frase.length())); // Insere a última
                                                                                                    // palavra

        for (int z = palavras.size(); z > 0; z--) { // Concatena as palavras
            fraseRevertida += palavras.get(z - 1) + " ";
        }

        return fraseRevertida;
    }

    // #################################################################################################################//#endregion

    public static String RemoveDuplicata(String frase2) {
        ArrayList<String> letras = new ArrayList<String>(); // Cria um arraylist para as letras da frase

        for (int w = 0; w < frase2.length(); w++) // Coloca cada letra da frase no ArrayList
        {
            letras.add(frase2.substring(w, w + 1));
        }

        for (int x = 0; x < letras.size() - 1; x++) { // Faz varredura no ArrayList comparando os elementos

            for (int y = x + 1; y < letras.size(); y++) {

                if (letras.get(y).equals(letras.get(x))) {
                    if (!letras.get(y).equals(" ")) {
                        letras.remove(y);
                    }
                }
            }
        }

        String fraseSemDuplicata = ""; // Declara e inicializa a a string do return

        for (String letra : letras) {
            fraseSemDuplicata += letra; // Concatena as letras para formar string novamente
        }

        return fraseSemDuplicata;
    }

    // ####################################################################################################################//#endregion

    public static String Palindromo(String frase3) {

        boolean palindromo = false;

        frase3.trim(); // Tirar os espaços da frase

        ArrayList<String> substrings = new ArrayList<String>();

        String frasePalindromo = ""; // Declaração e inicialização da string de saida

        if (frase3.length() > 2) // Divisão das strings em partes de três letras
        {
            for (int x = 0; x < frase3.length(); x++) {
                try {
                    substrings.add(frase3.substring(x, x + 3));
                } catch (Exception e) {
                    break;
                }
            }
        }
        System.out.println(substrings); // Teste

        // for (String sub : substrings) {
        for (int y = 0; y < substrings.size(); y++) // Varredura pelas substrings
        {
            palindromo = true;
            int inicio = 0;
            int fim = substrings.get(y).length() - 1;

            while (inicio < fim) {
                if (substrings.get(y).charAt(inicio) != substrings.get(y).charAt(fim)) {
                    palindromo = false;
                    break;
                }
                inicio++;
                fim--;
            }

            if (palindromo) {
                System.out.println("É um palíndromo."); // teste
            } else {
                substrings.remove(y);
                System.out.println("Não é um palíndromo."); // teste
            }
        }

        System.out.println(substrings);

        return frasePalindromo;
    }

    // ####################################################################################################################//#endregion

    public static String Maiuscula(String frase4) {
        Scanner input = new Scanner(System.in); // Declaração do objeto Scanner

        ArrayList<String> letras = new ArrayList<String>(); // Array com as letras da frase ou palavra

        for (int x = 0; x < frase4.length(); x++) // Coloca cada letra da frase no ArrayList
        {
            letras.add(frase4.substring(x, x + 1));
        }

        letras.set(0, letras.get(0).toUpperCase()); // Coloca Maiúscula na primeira letra

        for (int y = 0; y < letras.size(); y++) { // Varredura para encontrar sinais de final de frase

            if (letras.get(y).equals(".") || letras.get(y).equals("!")) {
                if (y != letras.size() - 1) // condição de não ser o último da frase
                {
                    letras.set(y + 2, letras.get(y + 2).toUpperCase()); // substituição por maiúscula
                }
            }
        }

        String fraseMaiuscula = ""; // Declara e inicializa a a string do return

        for (String letra : letras) {
            fraseMaiuscula += letra; // Concatena as letras para formar string novamente
        }

        return fraseMaiuscula;
    }
    // ########################################################################################//#endregion

}