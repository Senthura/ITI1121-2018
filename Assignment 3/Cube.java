public class Cube {

    public static final int UP = 0;
    public static final int FRONT = 1;
    public static final int RIGHT = 2;
    public static final int BACK = 3;
    public static final int LEFT = 4;
    public static final int DOWN = 5;

    private static final int ID = 0;
    private static final int ROT = 1;
    private static final int RROLL = 2;
    private static final int LROLL = 3;
    private static final int FROLL = 4;

    private Color[] faces, initFaces;

    private int currentTransformation;

    private int[] allTransformations = getAllTransformations();

    // Up, Front, Right, Back, Left, Down

    public Cube(Color[] faces) {

        if (faces == null) {
            throw new NullPointerException();
        }

        if (faces.length != 6) {
            throw new IllegalArgumentException("6 colours expected");
        }

        this.faces = new Color[faces.length];
        initFaces = new Color[faces.length];
        for(int i =0 ; i < faces.length; i++) {
            this.faces[i] = faces[i];
            initFaces[i] = faces[i];
        }
        reset();
    }

    public Cube(Cube cube) {

        if (cube == null) {
            throw new NullPointerException();
        }

        faces = new Color[cube.faces.length];
        initFaces = cube.initFaces;
        for(int i =0 ; i < faces.length; i++) {
            faces[i] = cube.faces[i];
        }
        currentTransformation = cube.currentTransformation;
        allTransformations = cube.allTransformations;
    }

    public Cube copy(){
        return new Cube(this);
    }

    public void setFirst(boolean isFirst){
        if (isFirst) {
            allTransformations = getAllBasicTransformations();
        } else {
            allTransformations = getAllTransformations();
        }
        reset();
    }

    public void reset(){
        currentTransformation = -1;
    }

    public boolean hasNext(){
        return currentTransformation < (allTransformations.length-1);
    }

    public void next(){
        if(!hasNext()){
            throw new IllegalStateException("No next transformation");
        }
        currentTransformation++;
        transform(allTransformations[currentTransformation]);
    }

    public Color getUp() {
        return faces[UP];
    }

    public Color getFront() {
        return faces[FRONT];
    }

    public Color getRight() {
        return faces[RIGHT];
    }

    public Color getBack() {
        return faces[BACK];
    }

    public Color getLeft() {
        return faces[LEFT];
    }

    public Color getDown() {
        return faces[DOWN];
    }

    private void rotate(){

        Color[] currentVals = new Color[faces.length];

        for(int i = 0; i < currentVals.length ; i++){
            currentVals[i] = faces[i];
        }

        faces[FRONT] = currentVals[LEFT];
        faces[LEFT]  = currentVals[BACK];
        faces[BACK]  = currentVals[RIGHT];
        faces[RIGHT] = currentVals[FRONT];

    }

    private void rightRoll(){

        Color[] currentVals = new Color[faces.length];

        for(int i = 0; i < currentVals.length ; i++){
            currentVals[i] = faces[i];
        }

        faces[UP] = currentVals[LEFT];
        faces[RIGHT] = currentVals[UP];
        faces[DOWN] = currentVals[RIGHT];
        faces[LEFT] = currentVals[DOWN];

    }

    private void leftRoll(){

        Color[] currentVals = new Color[faces.length];

        for(int i = 0; i < currentVals.length ; i++){
            currentVals[i] = faces[i];
        }

        faces[UP] = currentVals[RIGHT];
        faces[LEFT] = currentVals[UP];
        faces[DOWN] = currentVals[LEFT];
        faces[RIGHT] = currentVals[DOWN];

    }

    private void frontRoll(){

        Color[] currentVals = new Color[faces.length];

        for(int i = 0; i < currentVals.length ; i++){
            currentVals[i] = faces[i];
        }

        faces[UP] = currentVals[FRONT];
        faces[FRONT] = currentVals[DOWN];
        faces[DOWN] = currentVals[BACK];
        faces[BACK] = currentVals[UP];

    }

    private void transform(int type){
        switch(type) {
            case ID :
            for(int i =0 ; i < faces.length; i++) {
                faces[i] = initFaces[i];
            }
            break;
            case ROT :
            rotate();
            break;
            case RROLL :
            rightRoll();
            break;
            case LROLL :
            leftRoll();
            break;
            case FROLL :
            frontRoll();
            break;
            default:
            System.out.println("Unknow type: " + type);
        }
    }

    private static int[] getAllTransformations() {
        return new int[]{ID,ROT,ROT,ROT,RROLL,ROT,ROT,ROT,RROLL,ROT,ROT,ROT,
            LROLL,ROT,ROT,ROT,LROLL,ROT,ROT,ROT,RROLL,ROT,ROT,ROT};
    }

    private static int[] getAllBasicTransformations() {
        return new int[]{ID,FROLL,RROLL,FROLL,RROLL,FROLL};
    }

    public String toString() {
        String out;
        out = "[";
        for (int i=0; i<faces.length; i++) {
            if (i>0) {
                out = out + ", ";
            }
            out = out + faces[i];
        }

        out = out + "]";
        return out;
    }

}
