package xadrez;

import tabuleiro.Posicao;
import tabuleiro.Tabuleiro;
import xadrez.pecas.Rei;
import xadrez.pecas.Torre;

public class PartidaDeXadrez {//Essa Classe é responsável pelas regras do jogo de xadrez

    private Tabuleiro tabuleiro;

    //Construtor padrão com uma instância do tabuleiro (Tamanho do tabuleiro)
    public PartidaDeXadrez(){
        tabuleiro = new Tabuleiro(8, 8);
        inicioDoJogo();
    }

    //Método que retorna uma matriz do tipo PecaDeXadrez correspondente a essa partida
    public PecaDeXadrez[][] getPecas(){
        PecaDeXadrez[][] mat = new PecaDeXadrez[tabuleiro.getLinhas()][tabuleiro.getColunas()];
        for (int i = 0; i < tabuleiro.getLinhas(); i++) {
            for (int j = 0; j < tabuleiro.getColunas(); j++) {
                mat[i][j] = (PecaDeXadrez) tabuleiro.peca(i, j);
            }
        }
        return mat;
    }

    //Método responsável por iniciar a partida de xadrez, colocando as peças no tabuleiro
    private void inicioDoJogo(){
        tabuleiro.colocarPeca(new Torre(tabuleiro, Cor.BRANCO), new Posicao(2, 1));
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(0, 4));
        tabuleiro.colocarPeca(new Rei(tabuleiro, Cor.PRETO), new Posicao(7, 4));
    }
}
