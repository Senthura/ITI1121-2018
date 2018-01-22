public class Test {


    public static void counterish(Counter c) {
        
        System.out.println(c.getValue());
        c.increment();
        System.out.println(c.getValue());

    }

    public static void main(String[] args){

      int oneCounter = 0;
      oneCounter++;

      int otherCounter = 0;

      int[] fiveCounters = new int[5];
      
      Counter counter;

      counter = new Counter();


      System.out.println(counter.getValue());
      counter.increment();
      System.out.println(counter.getValue());
      
      ////illegal access
      //counter.val = 0;

      Counter counter2 = new Counter();
      System.out.println(counter2.getValue());
    
       counter.reset();
       System.out.println(counter.getValue());
       counterish(counter);
       System.out.println(counter.getValue());
 
  }
}
