import java.util.*;
import edu.duke.*;
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tester {
public void testGetFollows() {
    MarkovOne mo = new MarkovOne();
    String test = "this is a test yes this is a test.";
    mo.setTraining(test);
    ArrayList<String> testing = mo.getFollows("t.");
     System.out.println(testing);
    //MarkovOne object, set the training text as “this is a test yes this is a test.”. 
    //Then have it call getFollows and print out the resulting ArrayList and also its size.
    //Be sure to test it on the three examples above and also on the Strings “.” 
    //and “t.”, which occur at the end of the String.
}

public void testGetFollowsWithFile() {
    MarkovOne mo = new MarkovOne();
    FileResource fr = new FileResource(); 
    String st = fr.asString();
    mo.setTraining(st);
    ArrayList<String> testing = mo.getFollows("he");
     System.out.println(testing);
     System.out.println("Size is: " + testing.size());
}
}
