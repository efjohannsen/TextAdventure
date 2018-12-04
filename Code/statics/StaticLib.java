package statics;

import java.util.Scanner;
import java.io.IOException;
import java.lang.InterruptedException;

public class StaticLib {

    private static Scanner input = new Scanner(System.in);

    public static String getInput() {
      System.out.print("> ");
      return input.nextLine();
    }

    public static int closestNumberDivisibleByX(int number, int divisibleBy) {
      return (number / divisibleBy + 1) * divisibleBy;
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

    // Returns 0 if not numerical or not positive
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

    public static void clearScreen() {
      if (System.getProperty("os.name") == "Windows") {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (IOException | InterruptedException e) {}
      }
      else {  // Works for macOS and Linux
        String ansiClear = "\033[H\033[2J";
        System.out.print(ansiClear);
        System.out.flush();
        //Runtime.getRuntime().exec("clear");
      }
    }

    // TODO: Handle system language
    public static void print(String argument, boolean newline) {
      if (newline) System.out.println(argument);
      else System.out.print(argument);
    }
}
