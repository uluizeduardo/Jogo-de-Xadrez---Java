package application;

import xadrez.PartidaDeXadrez;
import xadrez.PecaDeXadrez;
import xadrez.PosicaoDoXadrez;
import xadrez.XadrezException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        PartidaDeXadrez partidaDeXadrez = new PartidaDeXadrez();

        while(true){
            try {
                UI.clearScreen();
                UI.printTabuleiro(partidaDeXadrez.getPecas());
                System.out.println();
                System.out.println("Origem: ");
                PosicaoDoXadrez origem = UI.lerPosicaoDoXadrez(scan);

                System.out.println();
                System.out.println("Destino: ");
                PosicaoDoXadrez destino = UI.lerPosicaoDoXadrez(scan);

                PecaDeXadrez pecaCapiturada = partidaDeXadrez.movimentarPeca(origem, destino);
            }
            catch (XadrezException ex){
                System.out.println(ex.getMessage());
                scan.nextLine();
            }
            catch (InputMismatchException ex){
                System.out.println(ex.getMessage());
                scan.nextLine();
            }
        }
    }
}