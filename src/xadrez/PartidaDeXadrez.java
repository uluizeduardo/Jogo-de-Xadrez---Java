package xadrez;

import tabuleiro.Tabuleiro;

public class PartidaDeXadrez {//Essa Classe é responsável pelas regras do jogo de xadrez

    private Tabuleiro tabuleiro;

    //Construtor padrão com uma instância do tabuleiro (Tamanho do tabuleiro)
    public PartidaDeXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
    }

    //Método que retorna uma matriz de PecaDeXadrez correspondente a essa partida
    public PecaDeXadrez[][] getPecas(){
        PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }
}
