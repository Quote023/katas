package lists;

import lists.implementations.CircularList;
import lists.interfaces.ListDAT;


/**
 *<strong>Description</strong>
 * <p>
 * for a given ferris wheel filled with one person in each capsule and a given number of spins this algorithm should tell who's gonna come out at the start after the spins.
 * </p>
 * <br/>
 *<strong>Input Format:</strong>
 *<p>
 *   names: <font color="#54BED8">String</font> (space separated) in order.<br/>
 *   spins: <font color="#54BED8">int</font>
 *</p>
 *<strong>Output Format:</strong>
 *<p>name:  <font color="#54BED8">String</font></p>
 *<br/>
 *<strong>Constraints:</strong>
 *<ul>
 *    <li>You're not allowed to use any special data-structure implementation from the stdlib;</li>
 *    <li>You're not allowed to access the data structure attributes directly from outside of it;</li>
 *</ul>
 *<br/>
 *<strong>Sample Inputs:</strong>
 * <font color="#91D37A">
 * <ol>
 *  <li>"Andrea Cecilia Bento", <font color="#54BED8">2</font></li>
 *  <li>"Julia Sara Rebeca Camilla", <font color="#54BED8">10</font></li>
 *</ol>
 *</font>
 *<br/>
 *<strong>Sample Outputs:</strong>
 * <font color="#91D37A">
 * <ol>
 *  <li>"Bento"</li>
 *  <li>"Rebeca"</li>
 *  </ol>
 *</font>
 */
public class FerrisWheel {

  static ListDAT<String> ferrisWheel = new CircularList<>();

  public static void fillUp(String nameList){
    ferrisWheel.appendEnd(nameList.split(" "));
  }

  public static String SpinWheel(int spinCount){
    return ferrisWheel.getAt(spinCount);
  }

  public static void main(String[] args) {
    String[] textCases = {
      "Andrea Cecilia Bento",
      "Julia Sara Rebeca Camilla",
    };

    int[] spinInput = {2,10};

    String[] expectedResults = {"Bento", "Rebeca"};

    for (int i = 0, textCasesLength = textCases.length; i < textCasesLength; i++) {
      ferrisWheel.clear();

      String input = textCases[i];
      int spinCount = spinInput[i];

      FerrisWheel.fillUp(input);
      String result = FerrisWheel.SpinWheel(spinCount);

      String status = result.equals(expectedResults[i]) ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";

      System.out.println(input + " ["+ spinCount + "]: " +  result + status);
    }
  }
}
