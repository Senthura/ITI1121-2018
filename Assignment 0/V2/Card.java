

public class Card implements Comparable<Card>{

	public static final char MASK = '*';


	private boolean unveiled;
	private char face;


 	public  Card(char face){
 		this.face = face;
 		unveiled = false;
 	}

 	public char getFace(){
 		return face; 
 	}

 	public void setUnveiled(boolean unveiled){
 		this.unveiled = unveiled;
 	}

 	public boolean getUnveiled(){
 		return unveiled;
 	}

	public int compareTo(Card o) {

		if(getFace() < o.getFace()) {
			return -1;
		} else if (getFace() == o.getFace()) {
			return 0;
		} else {
			return 1;
		}
	}

 	public String toString(){
 		if (getUnveiled()) {
 			return Character.toString(face);
 		} else {
 			return Character.toString(MASK);
 		}
 	}
 }
