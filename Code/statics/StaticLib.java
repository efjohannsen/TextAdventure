package statics;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.lang.InterruptedException;

public class StaticLib {

  private static Scanner input = new Scanner(System.in);

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public static void pressEnterToContinue() {
    System.out.println("PRESS ENTER TO CONTINUE");
    input.nextLine();
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public static String getInput() {
    System.out.print("> ");
    return input.nextLine();
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public static boolean isNumericalValue(String input) {
    for (int i = 0; i < input.length(); i++) {
      if (!Character.isDigit(input.charAt(i))) {
        return false;
      }
    }
    return true;
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public static int getNumericalInputLoop() {
    int value = 0;

    while (true) {
      String input = getInput();

      if (input.length() > 0 && isNumericalValue(input)) {
        value = Integer.parseInt(input);
        break;
      }
      else {
        System.out.println("You need to input a numerical value!");
      }
    }

    return value;
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  // Returns -1 if not numerical or not positive
  public static int checkNumericalPositiveInput(String input) {
    int value = -1;

    if (input.length() > 0 && isNumericalValue(input)) {
      int number = Integer.parseInt(input);
      if (number > 0) value = number;
    }
    else {
      System.out.println("You need to input a numerical value!");
    }

    return value;
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  public static int getNumericalInputRangeLoop(int min, int max) {
    int value = getNumericalInputLoop();

    while (value < min || value > max) {

      System.out.println("Numerical value must be in the range of (" + min + ", " + max + ")");
      value = getNumericalInputLoop();    
    }
    return value;
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  // Cross platform screen clearing
  public static void clearScreen() {
    if (System.getProperty("os.name").toLowerCase().indexOf("win") != -1) {
      try {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      }
      catch (IOException | InterruptedException e) {}
    }
    else {  // Works for Linux and macOS
      String ansiClear = "\033[H\033[2J";
      System.out.print(ansiClear);
      System.out.flush();
      //Runtime.getRuntime().exec("clear");
    }
  }

  /**
   *
   * @param  name desc
   * @param  name desc
   * @return      desc
   */
  // Used for ASCII images
  public static void printFilePath(String path) {
    File file = new File(path);
    printFile(file);
  }

  /**
   * Reads a file line by line and prints it to the terminal.
   * @param  file The file that should be printed to screen.
   */
  public static void printFile(File file) {
    try {
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine()) {
        System.out.println( scanner.nextLine());
      }
    }
    catch (IOException e) { System.out.println(e); }
  }

}
