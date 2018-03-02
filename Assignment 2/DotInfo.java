
/**
 * The class <b>DotInfo</b> is a simple helper class to store 
 * the state (e.g. clicked, mined, number of neighbooring mines...) 
 * at the dot position (x,y)
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class DotInfo {

    /**
     * The x coordinate of this DotInfo.
     */
    private int x;

    /**
     * The x coordinate of this DotInfo.
     */
    private int y;

    /**
     * The number of neighbooring mines
     */
    private int neighbooringMines;

    /**
     * Is that location mined ?
     */
    private boolean mined;

    /**
     * Is that location uncovered ?
     */
    private boolean covered;

    /**
     * As this location been clicked on by the user ?
     */
    private boolean wasClicked;


    /**
     * Constructor, used to initialize the instance variables
     * 
     * @param x
     *            the x coordinate
     * @param y
     *            the y coordinate
     */
    public DotInfo(int x, int y){
        this.x = x;
        this.y = y;
        covered = true;
        mined = false;
        wasClicked = false;
        neighbooringMines = 0;
    }

    /**
     * Getter method for the attribute x.
     * 
     * @return the value of the attribute x
     */
    public int getX(){
        return x;
    }
    
    /**
     * Getter method for the attribute y.
     * 
     * @return the value of the attribute y
     */
    public int getY(){
        return y;
    }
    
 
    /**
     * Setter for mined
     */
    public void setMined() {
        mined = true;
    }

    /**
     * Getter for mined
     *
     * @return mined
     */
    public boolean isMined() {
        return mined;
    }


    /**
     * Setter for covered
     */
    public void uncover() {
        covered = false;
    }

    /**
     * Getter for covered
     *
     * @return covered
     */
    public boolean isCovered(){
        return covered;
    }



    /**
     * Setter for wasClicked
     */
    public void click() {
        wasClicked = true;
    }


    /**
     * Getter for wasClicked
     *
     * @return wasClicked
     */
    public boolean hasBeenClicked() {
        return wasClicked;
    }


    /**
     * Setter for neighbooringMines
     *
     * @param neighbooringMines
     *          number of neighbooring mines
     */
    public void setNeighbooringMines(int neighbooringMines) {
        this.neighbooringMines = neighbooringMines;
    }

    /**
     * Get for neighbooringMines
     *
     * @return neighbooringMines
     */
    public int getNeighbooringMines() {
        return neighbooringMines;
    }

 }
