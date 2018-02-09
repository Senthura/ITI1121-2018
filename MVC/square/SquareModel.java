public class SquareModel {

    private long value;

    public SquareModel(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public void square() {
        if(value >= Math.sqrt(Long.MAX_VALUE)){
            value = Long.MAX_VALUE;
        } else {
            value = value * value;
        }
    }
    
    public String toString() {
        if(value == Long.MAX_VALUE) {
            return "Maximum value reached: more than " + Long.MAX_VALUE;
        }
        return "The current value is " + value;
    }
}
