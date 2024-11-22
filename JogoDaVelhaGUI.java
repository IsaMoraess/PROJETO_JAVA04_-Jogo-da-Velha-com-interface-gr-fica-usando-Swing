import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JogoDaVelhaGUI {
    private JFrame frame;
    private JButton[][] buttons;
    private Partida partida;

    public JogoDaVelhaGUI() {
        partida = new Partida();
        frame = new JFrame("Jogo da Velha");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 3));

        buttons = new JButton[3][3];
        inicializarTabuleiro();

        frame.setVisible(true);
    }

    private void inicializarTabuleiro() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                button.setFont(new Font("Arial", Font.BOLD, 40));
                button.setFocusPainted(false);
                int linha = i;
                int coluna = j;

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (partida.fazerJogada(linha, coluna)) {
                            button.setText(partida.getJogadorAtual().getSimbolo());
                            verificarFimDeJogo();
                        }
                    }
                });

                buttons[i][j] = button;
                frame.add(button);
            }
        }
    }

    private void verificarFimDeJogo() {
        String vencedor = partida.verificarVencedor();
        if (vencedor != null) {
            JOptionPane.showMessageDialog(frame, "O jogador " + vencedor + " venceu!");
            reiniciarJogo();
        } else if (partida.tabuleiroCheio()) {
            JOptionPane.showMessageDialog(frame, "Empate!");
            reiniciarJogo();
        }
    }

    private void reiniciarJogo() {
        partida.reiniciar();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        new JogoDaVelhaGUI();
    }
}
