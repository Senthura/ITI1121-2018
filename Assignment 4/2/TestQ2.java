import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;
import org.junit.*;

public class TestQ2 {



    @BeforeClass
    public static void beforeClass() {
        String before = "******************************************************************";
        System.out.println(before);
        System.out.println("Running tests for Iterator for correct output...");
    }

    @AfterClass
    public static void afterClass() {
        String after = "******************************************************************";
        System.out.println(after);
    }


    @Test
    public void testCons1() {
        LinkedList<String> alphabet;
        alphabet = new LinkedList<String>();

        alphabet.addFirst("alpha");
        alphabet.addFirst("bravo");
        alphabet.addFirst("charlie");
        alphabet.addFirst("delta");
        alphabet.addFirst("echo");

        Iterator<String> i = alphabet.iterator();


        try{
            assertEquals(0, i.nextIndex());
            assertEquals("echo", i.next());
            assertEquals(1, i.nextIndex());
            assertEquals("delta", i.next());
            assertEquals(2, i.nextIndex());
            assertEquals("charlie", i.next());
            assertEquals(3, i.nextIndex());
            assertEquals("bravo", i.next());
            assertEquals(4, i.nextIndex());
            assertEquals("alpha", i.next());
            assertEquals(5, i.nextIndex());
          }catch(AssertionError e){
              System.out.println("Error in listIterator/nextIndex.");
                assertEquals(0, i.nextIndex());
                assertEquals("echo", i.next());
                assertEquals(1, i.nextIndex());
                assertEquals("delta", i.next());
                assertEquals(2, i.nextIndex());
                assertEquals("charlie", i.next());
                assertEquals(3, i.nextIndex());
                assertEquals("bravo", i.next());
                assertEquals(4, i.nextIndex());
                assertEquals("alpha", i.next());
                assertEquals(5, i.nextIndex());

    }
    }

    @Test
    public void testCons2() {
        LinkedList<String> alphabet;
        alphabet = new LinkedList<String>();

        alphabet.addFirst("alpha");
        alphabet.addFirst("bravo");
        alphabet.addFirst("charlie");
        alphabet.addFirst("delta");
        alphabet.addFirst("echo");

        Iterator<String> i = alphabet.iterator(1);


        try{
            assertEquals(1, i.nextIndex());
            assertEquals("delta", i.next());
            assertEquals(2, i.nextIndex());
            assertEquals("charlie", i.next());
            assertEquals(3, i.nextIndex());
            assertEquals("bravo", i.next());
            assertEquals(4, i.nextIndex());
            assertEquals("alpha", i.next());
            assertEquals(5, i.nextIndex());
        } catch(AssertionError e) {
              System.out.println("Error in constructor Iterator(int nextIndex).");
              assertEquals(1, i.nextIndex());
              assertEquals("delta", i.next());
              assertEquals(2, i.nextIndex());
              assertEquals("charlie", i.next());
              assertEquals(3, i.nextIndex());
              assertEquals("bravo", i.next());
              assertEquals(4, i.nextIndex());
              assertEquals("alpha", i.next());
              assertEquals(5, i.nextIndex());
          }
  }

  @Test
  public void testCons3() {
      LinkedList<String> alphabet;
      alphabet = new LinkedList<String>();

      alphabet.addFirst("alpha");
      alphabet.addFirst("bravo");
      alphabet.addFirst("charlie");
      alphabet.addFirst("delta");
      alphabet.addFirst("echo");

      Iterator<String> j = alphabet.iterator(2);
      Iterator<String> i = alphabet.iterator(j);


      try{
          assertEquals(2, i.nextIndex());
          assertEquals("charlie", i.next());
          assertEquals(3, i.nextIndex());
          assertEquals("bravo", i.next());
          assertEquals(4, i.nextIndex());
          assertEquals("alpha", i.next());
          assertEquals(5, i.nextIndex());
      } catch(AssertionError e) {
            System.out.println("Error in constructor Iterator(Iterator<E> other).");
            assertEquals(2, i.nextIndex());
            assertEquals("charlie", i.next());
            assertEquals(3, i.nextIndex());
            assertEquals("bravo", i.next());
            assertEquals(4, i.nextIndex());
            assertEquals("alpha", i.next());
            assertEquals(5, i.nextIndex());
        }
}





}
