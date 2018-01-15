public class Test {
	
	public static void main(String[] args){


		Utils.say("Live from Ottawa");	

		Utils.say("Hi five",5);	

		Utils.say("Hi five",-1);	

		Utils.say("Hi five",10);	

		String[] msgs;
		msgs = new String[3];

		msgs[0] = "I";
		msgs[1] = "am";
		msgs[2]= "hungry";
		Utils.say(msgs);

		Utils.say(Utils.concat(msgs));	
	}
}