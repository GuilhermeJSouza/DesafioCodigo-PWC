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
                case 1: // Comando REVERTER

                    System.out.println("Digite a frase a ser revertida."); // Comunica ao usuário o próximo comando

                    String frase = input.nextLine(); // Lê a entrada do usuário

                    String fraseNova = reverta(frase); // Executa o comando especificado

                    System.out.println(fraseNova);

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
        palavras.set(0, frase.substring(0, separadores.get(0)));

        for (int y = 1; y < separadores.size(); y++) {
            palavras.add(frase.substring(separadores.get(y - 1) + 1, separadores.get(y)));
        }

        palavras.add(frase.substring(separadores.get(separadores.size() - 1) + 1, frase.length()));

        for (int z = palavras.size(); z > 0; z--) {
            fraseRevertida += palavras.get(z - 1) + " ";
        }

        return fraseRevertida;
    }
}