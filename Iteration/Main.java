package Iteration;
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
    Scanner stdin = new Scanner(System.in);
    System.out.print("Enter upper limit.\n? ");
    int upperLimit = stdin.nextInt();
    stdin.close();  

    for(int i = 2; i <= upperLimit; i++){
      collatz(i);
    }

    Integer largest = 1;
    Integer collarg = collatzLen.get(largest);
    for(int i = 2; i <= upperLimit; i++){
      if(collatzLen.get(i) > collarg){
        largest = i;
        collarg = collatzLen.get(i);
      }
    }

    System.out.println(collatzLen);
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