import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // Instantiate game model
        TicTacToeModel model = new TicTacToeModel();

        // Create game board
        JFrame frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tic Tac Toe");
        frame.setVisible(true);

        JPanel topPanel = new JPanel();
        frame.add(topPanel, BorderLayout.NORTH);
        JButton clearBoardButton = new JButton("Clear Board");
        topPanel.setLayout(new FlowLayout());
        topPanel.add(clearBoardButton);

        JPanel gameGrid = new JPanel();
        frame.add(gameGrid, BorderLayout.CENTER);
        gameGrid.setLayout(new GridLayout(3, 3));

        JLabel statusBar = new JLabel(model.getCurrentPlayer() + "'s turn");
        frame.add(statusBar, BorderLayout.SOUTH);

        JButton[][] buttons = new JButton[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton("");
                gameGrid.add(button);
                buttons[i][j] = button;
                button.setBackground(Color.WHITE);
                button.setFont(new Font("Arial", Font.PLAIN, 70));
            }
        }

        buttons[0][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(0,0,buttons,statusBar,model);
            }
        });

        buttons[0][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(0,1,buttons,statusBar,model);
            }
        });

        buttons[0][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(0,2,buttons,statusBar,model);
            }
        });

        buttons[1][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(1,0,buttons,statusBar,model);
            }
        });

        buttons[1][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(1,1,buttons,statusBar,model);
            }
        });

        buttons[1][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(1,2,buttons,statusBar,model);
            }
        });

        buttons[2][0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(2,0,buttons,statusBar,model);
            }
        });

        buttons[2][1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(2,1,buttons,statusBar,model);
            }
        });

        buttons[2][2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionSetter(2,2,buttons,statusBar,model);
            }
        });

        clearBoardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        buttons[k][l].setText("");
                    }
                }
                model.newGame();
                JOptionPane.showMessageDialog(null, "Click OK to Start", "New Game", JOptionPane.INFORMATION_MESSAGE);
                statusBar.setText(model.getCurrentPlayer() + "'s turn");
            }
        });

    }
    public static void actionSetter(int i, int j, JButton[][] buttons, JLabel statusBar, TicTacToeModel model) {

                if (model.spotIsEmpty(i, j)) {
                    model.storeMove(i, j);
                    buttons[i][j].setText(String.valueOf(model.getCurrentPlayer()));
                } else {
                    JOptionPane.showMessageDialog(null, "That spot is taken\nPick a different spot", "Oops...", JOptionPane.INFORMATION_MESSAGE);
                    //System.exit(0);
                }

                if (model.isGameOver()) {
                    if (!model.isATie()) {
                        statusBar.setText(model.getCurrentPlayer() + " wins");
                        JOptionPane.showMessageDialog(null, model.getCurrentPlayer() + " wins", "Mazal Tov!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        statusBar.setText("It's a tie");
                        JOptionPane.showMessageDialog(null, "It's a tie", "Cat's game", JOptionPane.INFORMATION_MESSAGE);
                    }
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            buttons[k][l].setText("");
                        }
                    }
                    model.newGame();
                    statusBar.setText(model.getCurrentPlayer() + "'s turn");
                }
                else {
                    model.changeCurrentPlayer();
                    statusBar.setText(model.getCurrentPlayer() + "'s turn");
                }
    }
}
