import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunnerQ2 {
   public static void main(String[] args) {

      Result result1 = JUnitCore.runClasses(TestQ2.class);

      for (Failure failure : result1.getFailures()) {
               System.out.println(failure.toString());
      }
      System.out.println("Iterator test result was :"+result1.wasSuccessful()+"\n\n");



   }
}
