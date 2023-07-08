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
            }
        }

    }

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

    public static String RemoveDuplicata(String frase2) {
        ArrayList<String> letras = new ArrayList<String>(); // Cria um arraylist para as letras da frase

        for (int w = 0; w < frase2.length(); w++) // Coloca cada letra da frase no vetor
        {
            letras.add(frase2.substring(w, w + 1));
        }

        for (int x = 0; x < letras.size() - 1; x++) {
            // System.out.printf("%n X %s", letras.get(x)); // teste

            for (int y = x + 1; y < letras.size(); y++) {
                // System.out.printf(" Y %s", letras.get(y)); // teste

                if (letras.get(y).equals(letras.get(x))) {
                    if (!letras.get(y).equals(" ")) {
                        letras.remove(y);
                    }
                }
            }

        }

        // System.out.println(letras); // teste

        String fraseSemDuplicata = "";

        for (String letra : letras) {
            fraseSemDuplicata += letra;
        }

        return fraseSemDuplicata;
    }
}