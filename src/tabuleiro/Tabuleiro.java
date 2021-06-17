package tabuleiro;

public class Tabuleiro {
    private int linhas;
    private int colunas;
    private Peca[][] pecas;

    public Tabuleiro(int linhas, int colunas) {
        if(linhas < 1 || colunas < 1){
            throw new TabuleiroException("Erro ao criar o tabuleiro: O tabuleiro deve ter ao menos 1 linha e 1 coluna");
        }
        this.linhas = linhas;
        this.colunas = colunas;
        pecas = new Peca[linhas][colunas];
    }

    public int getLinhas() {
        return linhas;
    }

    public int getColunas() {
        return colunas;
    }

    //Método para retornar linhas e colunas da peça
    public Peca peca(int linha, int coluna){
        if (!posicaoExistente(linha, coluna)){//Se essa posição não existir, lançar exception
            throw new TabuleiroException("Posição não existe no tabuleiro");
        }
        return pecas[linha][coluna];
    }

    //Método para retornar a posição das linhas e colunas da peça
    public Peca peca(Posicao posicao){
        if (!posicaoExistente(posicao)){//Se essa posição não existir, lançar exception
            throw new TabuleiroException("Posição não existe no tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }

    //Método responsável por colocar a peça na posição do tabuleiro
    public void colocarPeca(Peca peca, Posicao posicao){
        if (temUmaPeca(posicao)) {//Se tem uma peça nessa posição, lançar exception
            throw new TabuleiroException("Já existe uma peça na posição " + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }

    //Método auxiliar com a validação da existencia da posição
    public boolean posicaoExistente(int linha, int coluna){
        return linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas;
    }

    //Método que verifica se existe a posição escolhida pelo jogador
    public boolean posicaoExistente(Posicao posicao){
        return posicaoExistente(posicao.getLinha(), posicao.getColuna());
    }

    //Método que verifica se tem peça na posição escolhida pelo jogador
    public boolean temUmaPeca(Posicao posicao){
        if (!posicaoExistente(posicao)) {//Se não existir a posição no tabuleiro, lançar uma exception
            throw new TabuleiroException("Posição não existe no tabuleiro");
        }
        return peca(posicao) != null;
    }
}
