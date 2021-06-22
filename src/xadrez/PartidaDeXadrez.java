package xadrez;

import tabuleiro.Peca;
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

    //Método para movimentar literalmente as peças
    public PecaDeXadrez movimentarPeca(PosicaoDoXadrez posicaoDeOrigem, PosicaoDoXadrez posicaoDeDestino){
        Posicao origem = posicaoDeOrigem.toPosicao();
        Posicao destino = posicaoDeDestino.toPosicao();
        validarPosicaoDeOrigem(origem);
        Peca capiturarPeca = fazMover(origem, destino);
        return (PecaDeXadrez) capiturarPeca;
    }

    //Método auxiliar para mover peças
    private Peca fazMover(Posicao origem, Posicao destino){
        Peca p = tabuleiro.removePeca(origem);
        Peca pecaCapiturada = tabuleiro.removePeca(destino);
        tabuleiro.colocarPeca(p, destino);
        return pecaCapiturada;
    }

    //Validação da posição de origem
    private void validarPosicaoDeOrigem(Posicao posicao){
        if (!tabuleiro.posicaoExistente(posicao)){
            throw new XadrezException("Não existe peça na posição de origem");
        }
    }

    private void colocarNovaPeca(char coluna, int linha, PecaDeXadrez peca){
        tabuleiro.colocarPeca(peca, new PosicaoDoXadrez(coluna, linha).toPosicao());//.toPosicao para converter para uma posição da matriz
    }

    //Método responsável por iniciar a partida de xadrez, colocando as peças no tabuleiro
    private void inicioDoJogo(){
        colocarNovaPeca('b', 6, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 8, new Rei(tabuleiro, Cor.PRETO));
        colocarNovaPeca('c', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('c', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 2, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('e', 1, new Torre(tabuleiro, Cor.BRANCO));
        colocarNovaPeca('d', 1, new Rei(tabuleiro, Cor.BRANCO));

        colocarNovaPeca('c', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('c', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 7, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('e', 8, new Torre(tabuleiro, Cor.PRETO));
        colocarNovaPeca('d', 8, new Rei(tabuleiro, Cor.PRETO));
    }
}
