//ManipulationString.java
//Creator: GuilhermeJSouza
//Date: 07/07/2023
//Description: Código para "Desafio de Código: Manipulação de Strings" do processo seletivo da empresa PWC para a vaga de estágio em Tecnologia.

import java.util.Scanner;

public class ManipulationString
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("""
        
        Digite o número correspondente à operação a ser realizada:

        1  Reverter ordem
        2  Remover duplicata
        3  Encontre Palíndromo
        4  Iniciais maiúsculas
        5  Anagrama""");

        int comando = input.nextInt();

        if (comando >= 1 && comando <= 5)
        {
            switch (comando)
            {
                case 1:
                    System.out.println("Digite a frase a ser revertida.");
                    String limpa = input.nextInt();
                    String frase = input.nextLine();
                    reverta(frase);
                    break;
            }
        }

        
    }

    public static String reverta(String fraseRevertida)
    {
        
        return fraseRevertida;
    }
}