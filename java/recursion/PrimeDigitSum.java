package recursion;

/**
 *<strong>Description</strong>
 * <p>
 * A recursive algorithm that takes a non-negative integer and returns the sum of all it's prime digits<br/>
 * <u>if the number doesn't have any prime digit it should return 0</u>
 * </p>
 * <br/>
 *<strong>Input Format:</strong>
 *<p>number: <font color="#54BED8">int</font></p>
 *<strong>Output Format:</strong>
 *<p>sum:  <font color="#54BED8">int</font></p>
 *<br/>
 *<strong>Constraints:</strong>
 *<ul>
 *    <li>You're not allowed to use any special data-structure implementation from the stdlib;</li>
 *    <li>The solution should be entirely recursive;</li>
 *</ul>
 *<br/>
 *<strong>Sample Inputs:</strong>
 * <ol>
 *  <li>257</li>
 *  <li>113</li>
 *  <li>464</li>
 *  <li>96</li>
 *</ol>
 *<br/>
 *<strong>Sample Outputs:</strong>
 *
 * <ol>
 *  <li>14</li>
 *  <li>13</li>
 *  <li>0</li>
 *  <li>0</li>
 *  </ol>
 */
public class PrimeDigitSum {

  public static int digitSum(int number) {
    // Base case:
    if (number == 0) return 0;

    int digit = number % 10;
    return (isPrime(digit) ? digit : 0) + digitSum(number / 10);
  }

  public static boolean isPrime(int number) { return isPrime(number, 3); }

  private static boolean isPrime(int number, int iteration) {
    // Base cases:
    if (number < 2) return false; // 0,1
    if (number % 2 == 0) return (number == 2); // even numbers
    if (Math.pow(iteration, 2) > number) return true; //case the number doesn't have a divisor lower than it's square root
    if (number % iteration == 0) return false;
    return isPrime(number, iteration + 2);
  }


  public static void main(String[] args) {
    int[] inputs          = { 257, 113, 464, 96 };
    int[] expectedResults = { 14 , 3  , 0  ,0 };

    for (int i = 0, inputsLength = inputs.length; i < inputsLength; i++) {
      int input = inputs[i];
      int result = digitSum(input);

      String status = result == expectedResults[i] ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";
      System.out.println(input + ": " +  result + status);
    }
  }
}
