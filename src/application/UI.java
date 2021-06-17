package application;

import xadrez.PecaDeXadrez;

public class UI {

    //Método para imprimir o tabuleiro
    public static void printTabuleiro(PecaDeXadrez[][] pecas){
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printPeca(pecas[i][j]);
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }

    //Método auxiliar que imprime apenas uma peça de xadrez
    private static void printPeca(PecaDeXadrez peca){
        if (peca == null){
            System.out.print("-");
        }
        else {
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
