// CLASSE QUE REPRESENTA UM JOGADOR NO JOGO
public class Jogador {
    private String nome; // NOME DO JOGADOR
    private String simbolo; // SIMBOLO QUE O JOGADOR UTILIZA (X OU O)

    public Jogador(String nome, String simbolo) {
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public String getNome() {
        return nome;
    }

    public String getSimbolo() {
        return simbolo;
    }
}
