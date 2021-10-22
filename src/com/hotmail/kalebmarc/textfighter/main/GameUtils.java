package com.hotmail.kalebmarc.textfighter.main;

import java.util.List;

/*
* This is a Utility Class for modifying String
*/
public class GameUtils {

  /**
   * Prints to console
   * @param input string to be printed
   */
  public static void print(String input) {
    System.out.print(input);
  }

  /**
   * Prints to console, includes to move to the next time
   * @param input string to be printed
   */
  public static void println(String input) {
    print(input + "\n");
  }

  public static void showPopup(String header, String subheader, List<String> message, List<String> inputs) {
    Ui.cls();
    println(center(Constants.DASH_DIVIDER));
    if(!header.isEmpty()) {
      println(center(header));
    }

    if(!subheader.isEmpty()) {
      println(center(subheader));
      println(center(Constants.STAR_DIVIDER));
    }
    println(center(Constants.EMPTY_SPACE_BOX));

    for (int i = 0; i < message.size(); i++) {
      println(center(message.get(i)));
    }

    println(center(Constants.EMPTY_SPACE_BOX));

    for (int i = 0; i < inputs.size(); i++) {
      int input_num = i + 1; // This addition is because our switch case starts from Case 1 and not Case 0
      String input = input_num + "- " + inputs.get(i);
      println(leftAlign(input));
    }

    println(center(Constants.DASH_DIVIDER));
  }

  /**
   * Aligns text to the center
   * @param s string to be modified
   * @return modified string that is aligned to the center
   */
  public static String center(String s) {
    return center(s, 45, ' ');
  }
  /**
   * Aligns text to the left.
   * @param s string to be modified
   * @return modified string that is aligned to the left
   */
  public static String leftAlign(String s) {
    return leftAlign(s, 45, ' ');
  }
  /**
   * Aligns text to the center
   * @param input string to be modified 
   * @param size width of "text box"
   * @param pad padding around text
   * @return string that is aligned to the center.
   */
  public static String center(String input, int size, char pad) {
    if (input == null || size <= input.length())
      return input;

    StringBuilder output = new StringBuilder(size);
    output.append("|");
    output.append(String.valueOf(pad).repeat((size - input.length()) / 2));
    output.append(input);

    while (output.length() < size) {
      output.append(pad);
    }
    output.append("|");
    return output.toString();
  }
 /**
  * Aligns text to the left
  * @param input string to be modified 
  * @param size width of "text box"
  * @param pad padding around text
  * @return string that is aligned to the left.
  */
  public static String leftAlign(String input, int size, char pad) {
    if (input == null || size <= input.length())
      return input;

    StringBuilder output = new StringBuilder(size);
    output.append("|");
    output.append(String.valueOf(pad).repeat(10));
    output.append(input);

    while (output.length() < size) {
      output.append(pad);
    }
    output.append("|");
    return output.toString();
  }
}
