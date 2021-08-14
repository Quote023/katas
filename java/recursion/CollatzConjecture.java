package recursion;

/**
 *<strong>Description</strong>
 * <p>
 * <a href="https://en.wikipedia.org/wiki/Collatz_conjecture">The Collatz Conjecture</a><br/>
 * A recursive algorithm that takes an integer and returns a string composed as <br/>
 * <font color="#91D37A">"{iterations}: {n1} {separator} {n2} {separator} {n3} {...} {separator} 1"</font><br/>
 * Between n(i) and n(i+1) the separator should be defined as follows:
 * <ul>
 *   <li>if n(i) is divisible by 4 or 5: <font color="#91D37A">"<-->"</font></li>
 *   <li>if n(i) is divisible by only 4: <font color="#91D37A">"-->"</font></li>
 *   <li>if n(i) is divisible by only 5: <font color="#91D37A">"<->"</font></li>
 *   <li>if n(i) is divisible by neither: <font color="#91D37A">"->"</font></li>
 * </ul>
 * </p>
 * <br/>
 *<strong>Input Format:</strong>
 *<p>number: <font color="#54BED8">int</font></p>
 *<strong>Output Format:</strong>
 *<p>sequence:  <font color="#91D37A">"{iterations}: {n1} {separator} {n2} {separator} {n3} {...} {separator} 1"</font></p>
 *<br/>
 *<strong>Constraints:</strong>
 *<ul>
 *    <li>the input <i>number</i> should always be an non-negative integer;</li>
 *    <li>You're not allowed to use any special data-structure implementation from the stdlib;</li>
 *    <li>The solution should be entirely recursive;</li>
 *</ul>
 *<br/>
 *<strong>Sample Inputs:</strong>
 * <ol>
 *  <li>2</li>
 *  <li>4</li>
 *  <li>5</li>
 *  <li>20</li>
 *  </ol>
 *<br/>
 *<strong>Sample Outputs:</strong>
 * <font color="#91D37A">
 * <ol>
 *  <li>"1: 2 -> 1"</li>
 *  <li>"2: 4 --> 2 -> 1"</li>
 *  <li>"5: 5 <-> 16 --> 8 --> 4 --> 2 -> 1"</li>
 *  <li>"7: 20 <--> 10 <-> 5 <-> 16 --> 8 --> 4 --> 2 -> 1"</li>
 *  </ol>
 *</font>
 */
public class CollatzConjecture {

  private static String getSeparator(int valorCalculado){
    if (valorCalculado % (4 * 5) == 0) return " <--> ";
    if (valorCalculado % 4 == 0)
      return " --> ";
    if (valorCalculado % 5 == 0)
      return " <-> ";
    else
      return " -> ";
  }

  private static int nextNumber(int number){
    if (number % 2 == 0) return number / 2;
      return (number * 3) + 1;

  }
  public static String conjectureCollaz(int number) {
    if (number <= 1)  return "0: " + number;

    int next        = nextNumber(number);
    String formated = number + getSeparator(number) + next;

    return collatzConjectureRec(1,formated,next);
  }

  private static String collatzConjectureRec(int count,String sequence, int number){

    if (number <= 1)  return count + ": " + sequence;

    int next            = nextNumber(number);
    int newCount        = count + 1;
    String newSequence  = sequence + getSeparator(number) + next;

    return collatzConjectureRec(newCount,newSequence,next);
  }

  public static void main(String[] args) {
    int[] inputs = {
      2,
      4,
      5,
      20
    };

    String[] expectedResults = {
        "1: 2 -> 1",
        "2: 4 --> 2 -> 1",
        "5: 5 <-> 16 --> 8 --> 4 --> 2 -> 1",
        "7: 20 <--> 10 <-> 5 <-> 16 --> 8 --> 4 --> 2 -> 1",
    };

    for (int i = 0, inputsLength = inputs.length; i < inputsLength; i++) {
      int input = inputs[i];
      String result = conjectureCollaz(input);
      String status = result.equals(expectedResults[i]) ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";

      System.out.println(input + ": " +  result + status);
    }
  }
}
