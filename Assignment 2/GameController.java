import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 * The class <b>GameController</b> is the controller of the game. It is a listener
 * of the view, and has a method <b>play</b> which computes the next
 * step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */


public class GameController implements ActionListener {

    /**
     * Reference to the view of the board
     */
    private GameView gameView;
    /**
     * Reference to the model of the game
     */
    private GameModel gameModel;
 
    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param width
     *            the width of the board on which the game will be played
     * @param height
     *            the height of the board on which the game will be played
     * @param numberOfMines
     *            the number of mines hidden in the board
     */
    public GameController(int width, int height, int numberOfMines) {
        gameModel = new GameModel(width, height, numberOfMines);
        gameView = new GameView(gameModel, this);
        gameView.update();
//        System.out.println(gameModel);
    }


    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */

    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() instanceof DotButton) {
            play(((DotButton)(e.getSource())).getColumn(), ((DotButton)(e.getSource())).getRow());
//            System.out.println(gameModel);
        } else if (e.getSource() instanceof JButton) {
            JButton clicked = (JButton)(e.getSource());

            if (clicked.getText().equals("Quit")) {
                 System.exit(0);
             } else if (clicked.getText().equals("Reset")){
                reset();
             }
        } 
    }

    /**
     * resets the game
     */
    private void reset(){
        gameModel.reset();
        gameView.update();
    }

    /**
     * <b>play</b> is the method called when the user clicks on a square.
     * If that square is not already clicked, then it applies the logic
     * of the game to uncover that square, and possibly end the game if
     * that square was mined, or possibly uncover some other squares. 
     * It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives to options: start a new game, or exit
     * @param width
     *            the selected column
     * @param heigth
     *            the selected line
     */
    private void play(int width, int heigth){
        if(gameModel.isCovered(width,heigth)) {
            gameModel.step();
            gameModel.click(width,heigth);
            if(gameModel.isMined(width,heigth)) {
                gameModel.uncoverAll();
                gameView.update();
                Object[] options = {"Play Again",
                                "Quit"};
                int n = JOptionPane.showOptionDialog(gameView,
                        "Aouch, you lost in " + gameModel.getNumberOfSteps() 
                            +" steps!\n Would you like to play again?",
                        "Boom!",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                if(n == 0){
                    reset();
                } else{
                    System.exit(0);
                }   
            } else {
                if(gameModel.isBlank(width,heigth)) {
                    clearZone(gameModel.get(width, heigth));
                } else {
                    gameModel.uncover(width,heigth);
                }
                gameView.update();

                if(gameModel.isFinished()) {
                    gameModel.uncoverAll();
                    gameView.update();
                    Object[] options = {"Play Again",
                                "Quit"};
                    int n = JOptionPane.showOptionDialog(gameView,
                            "Congratulations, you won in " + gameModel.getNumberOfSteps() 
                                +" steps!\n Would you like to play again?",
                            "Won",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            options[0]);
                    if(n == 0){
                        reset();
                    } else{
                        System.exit(0);
                    }             
                }   
            }
        }     
    }

   /**
     * <b>clearZone</b> is the method that computes which new dots should be ``uncovered'' 
     * when a new square with no mine in its neighborood has been selected
     * @param initialDot
     *      the DotInfo object corresponding to the selected DotButton that
     * had zero neighbouring mines
     */
    private void clearZone(DotInfo initialDot) {


        Stack<DotInfo>  stack = new GenericArrayStack<DotInfo>(gameModel.getWidth()*gameModel.getHeigth());
        stack.push(initialDot);

        DotInfo dotInfo;
        while(!stack.isEmpty()){
            dotInfo = stack.pop();
            for(int i = Math.max(dotInfo.getX()-1, 0); i <= Math.min(dotInfo.getX()+1, gameModel.getWidth()-1); i++) {
                for(int j = Math.max(dotInfo.getY()-1, 0); j <= Math.min(dotInfo.getY()+1, gameModel.getHeigth()-1); j++) {
                    if(gameModel.isCovered(i,j)) {
                        gameModel.uncover(i,j);
                        if(gameModel.isBlank(i,j)) {
                            stack.push(gameModel.get(i, j));
                        }
                    }
                }
            }
        }
    }



}
