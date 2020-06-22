import edu.duke.*;
import java.util.*;

public class MarkovFour {
    private String myText;
	private Random myRandom;
	
	public MarkovFour() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
	StringBuffer sb = new StringBuffer();
	int index = myRandom.nextInt(myText.length()-4);
        String key = myText.substring(index, index+4);
        sb.append(key);
	for (int i=0; i<numChars-4; i++){	
         ArrayList<String> follows = getFollows(key);
         if (follows.size()==0) {
             break;
            }
         int indexfollows = myRandom.nextInt(follows.size());
         String next = follows.get(indexfollows);
         sb.append(next);
         key= key.substring(1) + next;
	}
	return sb.toString();
      }
	
	public ArrayList<String> getFollows(String key){
        ArrayList<String> follows = new ArrayList<String>();
        //String phrase = "this is a test yes this is a test.";
        int pos = 0;
        while(pos<myText.length()){
            int start = myText.indexOf(key,pos);
            if(start == -1){
                break;
            }
            if(start+key.length() >= myText.length()){
                break;
            }
            String next = myText.substring(start+key.length(),start+key.length()+1);
            follows.add(next);
            pos = start+key.length();
        }
        return follows;
    }
}
