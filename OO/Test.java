public class Test {

  Counter counter, otherCounter;


  public static void main(String[] args){


   

    counter = new Counter();

    counter.increment();


  }
}































/*
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
      
      Counter counter2 = new Counter();
      System.out.println(counter2.getValue());
    
       counter.reset();
       System.out.println(counter.getValue());
       counterish(counter);
       System.out.println(counter.getValue());
 
  }
}

*/






















/*
public class Test {

  public static void oneCounter(){
      Counter counter = new Counter();
      System.out.println("counter value is " + counter.getValue());
      for(int i =0; i < 10; i++){
        counter.increment();
        System.out.println("counter value is " + counter.getValue());
      }
      counter.reset();
      System.out.println("After reset, counter value is " + counter.getValue());
  }


  public static void twoCounters(){
      Counter counter = new Counter();
      Counter counter2 = new Counter();
      System.out.println("counter value is " + counter.getValue() + ", counter2 value is " + counter2.getValue());
      for(int i =0; i < 10; i++){
        counter.increment();
        System.out.println("counter value is " + counter.getValue() + ", counter2 value is " + counter2.getValue());
      }

    while ( counter2.getValue() < counter.getValue() ) {
          counter2.increment();
        System.out.println("counter value is " + counter.getValue() + ", counter2 value is " + counter2.getValue());
    }
  }

  public static void illegalAccess(){
      Counter counter = new Counter();
    counter.value = 5;
  }

   public static void main(String[] args){

      int counter = 0;
      counter++;

      int otherCounter = 0;

      int[] fiveCounters = new int[5];
      
      oneCounter();
      twoCounters();
//      illegalAccess();

    }
}

*/
