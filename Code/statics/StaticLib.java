package statics;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.lang.InterruptedException;

public class StaticLib {

    // How the different objects are displayed on the map/print out
    // public static final char PLAYER   = '\u058E';
    // public static final char PLAYER   = '\u1699';
    public static final char PLAYER   			= 'X';
    public static final char NPC      			= '\u00a7';
    public static final char BUILDING 			= '\u25a0';
    public static final char ITEM    			  = 'O';
    public static final char EMPTY    			= '\u00b7';
    //public static final char EASTER         = '\u1F47B';

    private static Scanner input = new Scanner(System.in);

    public static void pressEnterToContinue() {
      print("Press Enter to continue", true);
      input.nextLine();
    }

    public static String getInput() {
      System.out.print("> ");
      return input.nextLine();
    }

    public static boolean isNumericalValue(String input) {
      for (int i = 0; i < input.length(); i++) {
        if (!Character.isDigit(input.charAt(i))) {
          return false;
        }
      }
      return true;
    }

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

    // Used for ASCII images
    public static void printFilePath(String path) {
        File file = new File(path);
        printFile(file);
    }

    public static void printFile(File file) {
      try {
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
          print( scanner.nextLine(), true );
        }
      }
      catch (IOException e) { System.out.println(e); }
    }

    // TODO: Handle system language
    public static void print(String argument, boolean newline) {
      if (newline) System.out.println(argument);
      else System.out.print(argument);
    }
}
