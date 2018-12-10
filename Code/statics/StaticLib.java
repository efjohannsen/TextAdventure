package statics;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.lang.InterruptedException;

/**
  *
  * @param  name desc
  * @param  name desc
  * @return      desc
  */
public class StaticLib {

  // How the different objects are displayed on the map/print out
  //public static final char PLAYER   = '\u2b24';
  //public static final char NPC      			= '\u26f9';
  //public static final char BUILDING 			= '\u25a0';
  public static final char WONDERLAND 		= '\u2b1b';
  public static final char ITEM    			  = '\u2b4d';
  public static final char EMPTY    			= '\u00b7';
  public static final char BONEKING       = '\u2020';
  //public static final char EASTER         = '\u1F47B';
  // The above characters are better but the symbols are apparently not part of the default font used in cmd in Windows, hence these replacements
  public static final char PLAYER         = 'X';
  public static final char NPC      			= '\u00a7';
  public static final char BUILDING 			= '\u25a0';
  

  private static Scanner input = new Scanner(System.in);

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  public static void pressEnterToContinue() {
    print("PRESS ENTER TO CONTINUE", true);
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
        print("You need to input a numerical value!", true);
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
      print("You need to input a numerical value!", true);
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

    while (true) {
      if (value >= min && value <= max) {
        break;
      }

      print("Numerical value must be in the range of (" + min + ", " + max + ")", true);
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
        print( scanner.nextLine(), true );
      }
    }
    catch (IOException e) { System.out.println(e); }
  }

  /**
    *
    * @param  name desc
    * @param  name desc
    * @return      desc
    */
  // TODO: Handle system language
  public static void print(String argument, boolean newline) {
    if (newline) System.out.println(argument);
    else System.out.print(argument);
  }
}
