import java.util.Random;

/**
 * The class <b>GameModel</b> holds the model, the state of the systems. 
 * It stores the following information:
 * - the state of all the ``dots'' on the board (mined or not, clicked
 * or not, number of neighbooring mines...)
 * - the size of the board
 * - the number of steps since the last reset
 *
 * The model provides all of this informations to the other classes trough 
 *  appropriate Getters. 
 * The controller can also update the model through Setters.
 * Finally, the model is also in charge of initializing the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class GameModel {




    

    /**
     * The number of column of the game.
     */
    private  int widthOfGame;
 
    /**
     * The number of lines of the game.
     */
    private  int heigthOfGame;
 
    /**
     * A 2 dimentionnal array of widthOfGame*heigthOfGame 
     * recording the state of each dot
     */
	private DotInfo[][] model;


   /**
     * The number of steps played since the last reset
     */
	private int numberOfSteps;
 
   /**
     * The number of uncovered dots
     */
    private int numberUncovered;


   /**
     * The number of mines in the model
     */
    private int numberOfMines;


   /**
     * Random generator
     */
	private Random generator;

    /**
     * Constructor to initialize the model to a given size of board.
     * 
     * @param width
     *            the width of the board
     * 
     * @param heigth
     *            the heigth of the board
     * 
     * @param numberOfMines
     *            the number of mines to hide in the board
     */
    public GameModel(int width, int heigth, int numberOfMines) {
        generator = new Random();
        widthOfGame = width;
        heigthOfGame = heigth;
        this.numberOfMines = numberOfMines;
        reset();
    }


 
    /**
     * Resets the model to (re)start a game. The previous game (if there is one)
     * is cleared up . 
     */
    public void reset(){

    	model = new DotInfo[widthOfGame][heigthOfGame];

    	for(int i = 0; i < widthOfGame; i++){
		   	for(int j = 0; j < heigthOfGame; j++){
    			model[i][j] = new DotInfo(i,j);
    		}
    	}

        // add mines randomly into the board
        int numberToAdd = numberOfMines;
        while(numberToAdd > 0) {
            int i = generator.nextInt(widthOfGame);
            int j = generator.nextInt(heigthOfGame);
            if(!model[i][j].isMined()){
                model[i][j].setMined();
                numberToAdd--;
            }
        }

    	// compute the number of mines around each dots.
        for(int i = 0; i < widthOfGame; i++){
            for(int j = 0; j < heigthOfGame; j++){
                int total = 0;
                for(int k = Math.max(i-1, 0); k <= Math.min(i+1, widthOfGame-1); k++) {
                    for(int l = Math.max(j-1, 0); l <= Math.min(j+1, heigthOfGame-1); l++) {
                        if(model[k][l].isMined()) {
                            total++;
                        }
                    }
                }
                model[i][j].setNeighbooringMines(total);
            }
        }


    	numberOfSteps = 0;
        numberUncovered = 0;

    }


    /**
     * Getter method for the heigth of the game
     * 
     * @return the value of the attribute heigthOfGame
     */   
    public int getHeigth(){
        return heigthOfGame;
    }

    /**
     * Getter method for the width of the game
     * 
     * @return the value of the attribute widthOfGame
     */   
    public int getWidth(){
        return widthOfGame;
    }



    /**
     * returns true if the dot at location (i,j) is mined, false otherwise
    * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isMined(int i, int j){
        return model[i][j].isMined();
    }

    /**
     * returns true if the dot  at location (i,j) has 
     * been clicked, false otherwise
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean hasBeenClicked(int i, int j){
        return model[i][j].hasBeenClicked();
    }

  /**
     * returns true if the dot  at location (i,j) has zero mined 
     * neighboor, false otherwise
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isBlank(int i, int j){
        return model[i][j].getNeighbooringMines() == 0;
    }
    /**
     * returns true if the dot is covered, false otherwise
    * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the status of the dot at location (i,j)
     */   
    public boolean isCovered(int i, int j){
        return model[i][j].isCovered();
    }

    /**
     * returns the number of neighbooring mines os the dot  
     * at location (i,j)
     *
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     * @return the number of neighbooring mines at location (i,j)
     */   
    public int getNeighbooringMines(int i, int j){
        return model[i][j].getNeighbooringMines();
    }


    /**
     * Sets the status of the dot at location (i,j) to uncovered
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */   
    public void uncover(int i, int j){
 		model[i][j].uncover();
        numberUncovered++;
    }

    /**
     * Sets the status of the dot at location (i,j) to clicked
     * 
     * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     */   
    public void click(int i, int j){
        model[i][j].click();
    }
     /**
     * Uncover all remaining covered dot
     */   
    public void uncoverAll(){
        for(int i = 0; i < widthOfGame; i++){
            for(int j = 0; j < heigthOfGame; j++){
                if(isCovered(i,j)) {
                    uncover(i,j);
                }
            }
        }
    }

 

    /**
     * Getter method for the current number of steps
     * 
     * @return the current number of steps
     */   
    public int getNumberOfSteps(){
    	return numberOfSteps;
    }

  

    /**
     * Getter method for the model's dotInfo reference
     * at location (i,j)
     *
      * @param i
     *            the x coordinate of the dot
     * @param j
     *            the y coordinate of the dot
     *
     * @return model[i][j]
     */   
    public DotInfo get(int i, int j) {
        return model[i][j];
    }


   /**
     * The metod <b>step</b> updates the number of steps. It must be called 
     * once the model has been updated after the payer selected a new square.
     */
     public void step(){
        numberOfSteps++;
    }
 
   /**
     * The metod <b>isFinished</b> returns true iff the game is finished, that
     * is, all the nonmined dots are uncovered.
     *
     * @return true if the game is finished, false otherwise
     */
    public boolean isFinished(){
        return numberUncovered + numberOfMines == widthOfGame*heigthOfGame;
    }


   /**
     * Builds a String representation of the model
     *
     * @return String representation of the model
     */
    public String toString(){
        StringBuffer b = new StringBuffer();
        for(int j = 0; j < heigthOfGame; j++){
            for(int i = 0; i < widthOfGame; i++){
                if(model[i][j].isMined()) {
                    b.append("* ");
                } else {
                    b.append(model[i][j].getNeighbooringMines() + " ");
                }
            }
            b.append("\n");
        }
        return b.toString();
    }
}
