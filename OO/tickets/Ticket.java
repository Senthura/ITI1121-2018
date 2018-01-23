public class Ticket {

    private static int lastSerialNumber = 0;
    private int serialNumber;

    public Ticket() {
        lastSerialNumber++;
        serialNumber = lastSerialNumber ;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public static int getLastSerialNumber() {
        return lastSerialNumber;
    }
}


