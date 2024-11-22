// CLASSE QUE REPRESENTA O TABULEIRO DO JOGO
public class Tabuleiro {
    private String[][] tabuleiro; // MATRIZ QUE REPRESENTA O TABULEIRO

    public Tabuleiro() {
        tabuleiro = new String[3][3];
        limparTabuleiro();
    }

    // LIMPA O TABULEIRO (DEFINE TODAS AS POSIÇÕES COMO VAZIAS)
    public void limparTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabuleiro[i][j] = "";
            }
        }
    }

    // VERIFICA SE UMA POSICAO ESTA VAZIA
    public boolean posicaoVazia(int linha, int coluna) {
        return tabuleiro[linha][coluna].isEmpty();
    }

    // DEFINE O SIMBOLO EM UMA POSICAO ESPECIFICA
    public void definirPosicao(int linha, int coluna, String simbolo) {
        tabuleiro[linha][coluna] = simbolo;
    }

    // OBTEM O SIMBOLO EM UMA POSICAO
    public String getSimbolo(int linha, int coluna) {
        return tabuleiro[linha][coluna];
    }

    // VERIFICA SE O TABULEIRO ESTA CHEIO
    public boolean tabuleiroCheio() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    // RETORNA A MATRIZ DO TABULEIRO
    public String[][] getTabuleiro() {
        return tabuleiro;
    }
}
