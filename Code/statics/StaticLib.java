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

    public static boolean isNumericalValue(String input) {
      for (int i = 0; i < input.length(); i++) {
          if (!Character.isDigit(input.charAt(i))) {
              return false;
          }
      }
      return true;
    }

    public static int getNumericalInput() {
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

    public static int getNumericalInputRange(int min, int max) {
      int value = getNumericalInput();

      while (true) {
        if (value >= min && value <= max) {
            break;
        }

        System.out.println("Numerical value must be in the range of (" + min + ", " + max + ")");
        value = getNumericalInput();    
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
}
