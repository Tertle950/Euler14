//n → n/2 (n is even)
//n → 3n + 1 (n is odd)

// Import the HashMap class
import java.util.*;

public class Main {
  // Create a HashMap object for 
  static HashMap<Integer, Integer> collatzLen;
  public static void main(String[] args) {
    collatzLen = new HashMap<Integer, Integer>();

    // Add keys and values (Number, Length)
    collatzLen.put(1, 1);

    
    // Time to solve
    for(int i = 2; i <= 100; i++){
      collatz(i);
    }

    Integer largest = 1;
    Integer collarg = collatzLen.get(largest);
    for(int i = 2; i <= 100; i++){
      if(collatzLen.get(i) > collarg){
        largest = i;
        collarg = collatzLen.get(i);
      }
    }

    System.out.println(largest + " wins with " + collarg);
  }

  public static Integer collatz(int x) {
    Integer returner = collatzLen.get(x);
    if(returner == null){
      if(x % 2 == 0){
        // Even
        returner = collatz(x / 2) + 1;
      }else{
        // Odd
        returner = collatz((3*x) + 1) + 1;
      }

      collatzLen.put(x, returner);
    }

    return returner;
  }
}