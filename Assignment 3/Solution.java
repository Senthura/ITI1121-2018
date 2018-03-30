public class Solution {

    private static int calls = 0;

    private Cube[] cubes;

    private int numberOfCubes;

    public Solution(Cube[] cubes) {

        if (cubes == null) {
            throw new NullPointerException();
        }

        if (cubes.length < 1 || cubes.length > 4) {
            throw new IllegalArgumentException("cubes.length = " + cubes.length);
        }

        numberOfCubes = cubes.length;

        this.cubes = new Cube[numberOfCubes];
        for(int i = 0 ; i < numberOfCubes ; i++){
            this.cubes[i] = cubes[i].copy();
        }

    }

    public Solution(Solution other, Cube c) {

        if (c == null) {
            throw new NullPointerException();
        }

        if(other == null) {
            numberOfCubes = 1;
        } else {
            numberOfCubes = other.numberOfCubes+1;
        }
        cubes = new Cube[numberOfCubes];
        for(int i = 0 ; i < numberOfCubes - 1 ; i++){
            cubes[i] = other.cubes[i].copy();
        }
        cubes[numberOfCubes - 1] = c.copy();

    }

    public int size() {
        return numberOfCubes;
    }

    public Cube getCube(int pos) {

        if (pos<0 || pos >= cubes.length) {
            throw new IndexOutOfBoundsException(Integer.toString(pos));
        }

        return cubes[pos];
    }

    public boolean isValid() {

        calls++;
        for (int i=0; i<numberOfCubes-1; i++) {
            for (int j=i+1; j<numberOfCubes; j++) {
                if (cubes[i].getFront() == cubes[j].getFront() ||
                    cubes[i].getRight() == cubes[j].getRight() ||
                    cubes[i].getBack()  == cubes[j].getBack()  ||
                    cubes[i].getLeft()  == cubes[j].getLeft()) {
                    return false;
                }
            }
        }
        return true;

    }

    // called on a valid solution

    public boolean isValid(Cube next) {

        if (next==null) {
            throw new NullPointerException();
        }

        calls++;

        for (int i=0; i<numberOfCubes; i++) {
            if ((cubes[i].getFront() == next.getFront()) ||
                (cubes[i].getRight() == next.getRight()) ||
                (cubes[i].getBack()  == next.getBack())  ||
                (cubes[i].getLeft()  == next.getLeft())) {
                return false;
            }
        }
        return true;
    }

    public static int getNumberOfCalls() {
        return calls;
    }

    public static void resetNumberOfCalls() {
        calls = 0;
    }

    public String toString() {
        String out;
        out = "[";

        for (int i=0; i<numberOfCubes; i++) {
            if (i>0) {
                out = out + ", ";
            }
            out = out + cubes[i];
        }
        out = out + "]";

        return out;
    }

}
