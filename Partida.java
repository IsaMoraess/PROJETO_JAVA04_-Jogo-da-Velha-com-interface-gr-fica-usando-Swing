// CLASSE QUE GERENCIA A LOGICA DA PARTIDA
public class Partida {
    private Tabuleiro tabuleiro; // TABULEIRO DA PARTIDA
    private Jogador jogador1; // JOGADOR 1
    private Jogador jogador2; // JOGADOR 2
    private Jogador jogadorAtual; // JOGADOR DA VEZ

    public Partida() {
        tabuleiro = new Tabuleiro();
        jogador1 = new Jogador("Jogador 1", "X");
        jogador2 = new Jogador("Jogador 2", "O");
        jogadorAtual = jogador1; // JOGADOR 1 COMEÇA
    }

    // FAZ UMA JOGADA NA POSICAO ESPECIFICADA
    public boolean fazerJogada(int linha, int coluna) {
        if (tabuleiro.posicaoVazia(linha, coluna)) {
            tabuleiro.definirPosicao(linha, coluna, jogadorAtual.getSimbolo());
            trocarJogador();
            return true;
        }
        return false; // A POSICAO NAO ESTA VAZIA
    }

    // TROCA O JOGADOR ATUAL
    private void trocarJogador() {
        jogadorAtual = (jogadorAtual == jogador1) ? jogador2 : jogador1;
    }

    // RETORNA O JOGADOR ATUAL
    public Jogador getJogadorAtual() {
        return jogadorAtual;
    }

    // VERIFICA SE HA UM VENCEDOR
    public String verificarVencedor() {
        String[][] t = tabuleiro.getTabuleiro();

        // VERIFICA LINHAS
        for (int i = 0; i < 3; i++) {
            if (!t[i][0].isEmpty() && t[i][0].equals(t[i][1]) && t[i][1].equals(t[i][2])) {
                return t[i][0];
            }
        }

        // VERIFICA COLUNAS
        for (int i = 0; i < 3; i++) {
            if (!t[0][i].isEmpty() && t[0][i].equals(t[1][i]) && t[1][i].equals(t[2][i])) {
                return t[0][i];
            }
        }

        // VERIFICA DIAGONAIS
        if (!t[0][0].isEmpty() && t[0][0].equals(t[1][1]) && t[1][1].equals(t[2][2])) {
            return t[0][0];
        }
        if (!t[0][2].isEmpty() && t[0][2].equals(t[1][1]) && t[1][1].equals(t[2][0])) {
            return t[0][2];
        }

        return null; // SEM VENCEDOR
    }

    // VERIFICA SE O TABULEIRO ESTA CHEIO
    public boolean tabuleiroCheio() {
        return tabuleiro.tabuleiroCheio();
    }

    // REINICIA A PARTIDA
    public void reiniciar() {
        tabuleiro.limparTabuleiro();
        jogadorAtual = jogador1;
    }
}
