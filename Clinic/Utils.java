public class Utils {
	
	public static void say(String msg) {
		System.out.println(msg);
	}

	public static void say(String msg, int n) {

		if((n < 0) || (n >= 10)) {
			say("bad call, bad call");
		} else {

/*
			for(int i =0; i < n ; i++) {
				say(msg);
			}
*/
			while(n > 0) {
				say(msg);
				n=n-1;
			}
		}

	}

	public static void say(String[] msgs){

		for(int i = 0; i < msgs.length ; i++) {
			if(i!=0) {
				System.out.print(" ");
			}
			System.out.print(msgs[i]);
		}
		System.out.println();

	}

	public static String concat(String[] msgs){

		String result;
		result = "";

		for(int i = 0; i < msgs.length ; i++) {
			if(i!=0) {
				result += " ";
			}
			result += msgs[i];
		}

		return result;
	}

}
