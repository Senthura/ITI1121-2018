import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out a matrix of <b>DotButton</b> (the actual game) and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame {


    /**
     * The board is a two dimensionnal array of DotButtons instances
     */
    private DotButton[][] board;

 
    /**
     * Reference to the model of the game
     */
    private GameModel  gameModel;
 

    /**
     * Reference to the JLabel label on which the current number of steps is written
     */
    private JLabel nbreOfStepsLabel;
    /**
     * Constructor used for initializing the Frame
     * 
     * @param gameModel
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel gameModel, GameController gameController) {
        super("MineSweeper -- the ITI 1121 version");

        this.gameModel = gameModel;
 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setBackground(Color.WHITE);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new GridLayout(gameModel.getHeigth(), gameModel.getWidth()));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 0, 20));
        board = new DotButton[gameModel.getWidth()][gameModel.getHeigth()];

        for (int j = 0; j < gameModel.getHeigth(); j++) {
            for (int i = 0; i < gameModel.getWidth(); i++) {
                board[i][j] = new DotButton(i, j, getIcon(i,j));
                board[i][j].addActionListener(gameController);
                panel.add(board[i][j]);
            }
        }
    	add(panel, BorderLayout.CENTER);

        JButton buttonReset = new JButton("Reset");
        buttonReset.setFocusPainted(false);
        buttonReset.addActionListener(gameController);

        JButton buttonExit = new JButton("Quit");
        buttonExit.setFocusPainted(false);
        buttonExit.addActionListener(gameController);


  
        JPanel control = new JPanel();
        control.setBackground(Color.WHITE);
        nbreOfStepsLabel = new JLabel();
        control.add(nbreOfStepsLabel);
        control.add(buttonReset);
        control.add(buttonExit);

        add(control, BorderLayout.SOUTH);


    	pack();
    	//setResizable(false);
    	setVisible(true);

    }

    /**
     * update the status of the board's DotButton instances based 
     * on the current game model, then redraws the view
     */

    public void update(){
        for(int i = 0; i < gameModel.getWidth(); i++){
            for(int j = 0; j < gameModel.getHeigth(); j++){
                board[i][j].setIconNumber(getIcon(i,j));
            }
        }
        nbreOfStepsLabel.setText("Number of steps: " + gameModel.getNumberOfSteps());
        repaint();
    }

    /**
     * returns the icon value that must be used for a given dot 
     * in the game
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the icon to use for the dot at location (i,j)
     */   
    private int getIcon(int i, int j){
        if(gameModel.isCovered(i, j)) {
            return DotButton.COVERED;
        } else if (gameModel.isMined(i, j)) {
            if(gameModel.hasBeenClicked(i,j)) {
                return DotButton.CLICKED_MINE;
            } else {
                return DotButton.MINED;
            }
        } else {
            return gameModel.getNeighbooringMines(i,j);
        }
    }


}
