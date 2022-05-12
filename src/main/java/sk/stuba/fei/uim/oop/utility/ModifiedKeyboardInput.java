package sk.stuba.fei.uim.oop.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class ModifiedKeyboardInput {
    public static final String INPUT_FAILURE_TEXT = "Your input has failed. Please try again!";
    public static final int INFINITE_TRIES = Integer.MAX_VALUE;
    //MODIFIED:
    public static final String[] TRUE_INPUTS = {"yes"};
    //MODIFIED:
    public static final String[] FALSE_INPUTS = {"no"};


    public static char readChar(String promptText, int numberOfTries, String failureText) {
        printPrompt(promptText);
        return readChar(numberOfTries, failureText);
    }

    public static char readChar(String promptText, int numberOfTries) {
        printPrompt(promptText);
        return readChar(numberOfTries);
    }

    public static char readChar(int numberOfTries, String failureText) {
        return repeatInput(numberOfTries, failureText, c -> c == (char) 0, ModifiedKeyboardInput::readChar);
    }

    public static char readChar(int numberOfTries) {
        return readChar(numberOfTries, INPUT_FAILURE_TEXT);
    }

    public static char readChar(String promptText) {
        printPrompt(promptText);
        return readChar();
    }

    public static char readChar() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            return trimChar((char) inputStreamReader.read());
        } catch (IOException e) {
            e.printStackTrace();
            return (char) 0;
        }
    }


    public static String readString(String promptText, int numberOfTries, String failureText) {
        printPrompt(promptText);
        return readString(numberOfTries, failureText);
    }

    public static String readString(String promptText, int numberOfTries) {
        printPrompt(promptText);
        return readString(numberOfTries);
    }

    public static String readString(int numberOfTries, String failureText) {
        return repeatInput(numberOfTries, failureText, String::isEmpty, ModifiedKeyboardInput::readString);
    }

    public static String readString(int numberOfTries) {
        return readString(numberOfTries, INPUT_FAILURE_TEXT);
    }

    public static String readString(String promptText) {
        printPrompt(promptText);
        return readString();
    }

    public static String readString() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            return bufferedReader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }


    public static int readInt(String promptText, int numberOfTries, String failureText) {
        printPrompt(promptText);
        return readInt(numberOfTries, failureText);
    }

    //OWN METHOD:
    public static int readInt(String promptText, int beginOfInterval, int endOfInterval) {
        int num;
        Scanner reader = new Scanner(System.in);
        while (true) {
            System.out.print(promptText + ": ");
            if (reader.hasNextInt()) {
                num = reader.nextInt();
                if (num >= beginOfInterval && num <= endOfInterval)
                    break;
                System.out.println("Invalid value! Enter Integer between 2 and 8.");
            } else {
                System.out.println("Invalid value! Enter Integer between 2 and 8.");
                reader.next();
            }
        }
        return num;
    }

    public static int readInt(String promptText, int numberOfTries) {
        printPrompt(promptText);
        return readInt(numberOfTries, INPUT_FAILURE_TEXT);
    }

    public static int readInt(int numberOfTries, String failureText) {
        return repeatInput(numberOfTries, failureText, i -> i == Integer.MIN_VALUE, ModifiedKeyboardInput::readInt);
    }

    public static int readInt(int numberOfTries) {
        return readInt(numberOfTries, INPUT_FAILURE_TEXT);
    }

    public static int readInt(String promptText) {
        printPrompt(promptText);
        return readInt();
    }

    public static int readInt() {
        try {
            String s = readString();
            return s.isEmpty() ? Integer.MIN_VALUE : Integer.parseInt(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Integer.MIN_VALUE;
        }
    }


    public static double readDouble(String promptText, int numberOfTries, String failureText) {
        printPrompt(promptText);
        return readDouble(numberOfTries, failureText);
    }

    public static double readDouble(String promptText, int numberOfTries) {
        printPrompt(promptText);
        return readDouble(numberOfTries, INPUT_FAILURE_TEXT);
    }

    public static double readDouble(int numberOfTries, String failureText) {
        return repeatInput(numberOfTries, failureText, d -> d == Double.MIN_VALUE, ModifiedKeyboardInput::readDouble);
    }

    public static double readDouble(int numberOfTries) {
        return readDouble(numberOfTries, INPUT_FAILURE_TEXT);
    }

    public static double readDouble(String promptText) {
        printPrompt(promptText);
        return readDouble();
    }

    public static double readDouble() {
        try {
            String s = readString();
            return s.isEmpty() ? Double.MIN_VALUE : Double.parseDouble(s);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return Double.MIN_VALUE;
        }
    }

    public static boolean readBooleanOrElse(boolean defaultValue) {
        try {
            return readBoolean();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    public static boolean readBoolean() {
        String input = readString();
        if (input.isEmpty() || Arrays.stream(FALSE_INPUTS).anyMatch(s -> s.equalsIgnoreCase(input))) {
            return false;
        }
        if (Arrays.stream(TRUE_INPUTS).anyMatch(s -> s.equalsIgnoreCase(input))) {
            return true;
        } else {
            throw new IllegalArgumentException("Invalid boolean input! Input " + input + " cannot be parsed into boolean value.");
        }
    }

    //OWN METHOD:
    public static boolean readBoolean(String promptText) {
        while (true) {
            try {
                System.out.print(promptText + ": ");
                String input = readString();
                if (input.isEmpty() || Arrays.stream(FALSE_INPUTS).anyMatch(s -> s.equalsIgnoreCase(input))) {
                    return false;
                }
                if (Arrays.stream(TRUE_INPUTS).anyMatch(s -> s.equalsIgnoreCase(input))) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Invalid boolean input! Input " + input + " cannot be parsed into boolean value.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printPrompt(String prompt) {
        System.out.print(prompt + ": ");
    }

    private static char trimChar(char c) {
        String s = ("" + c).trim();
        return s.isEmpty() ? (char) 0 : s.charAt(0);
    }

    private static <T> T repeatInput(int repetition, String failureMessage, Predicate<T> predicate, Supplier<T> supplier) {
        T o = supplier.get();
        while (predicate.test(o) && repetition != 0) {
            System.out.println(failureMessage != null ? failureMessage : "");
            o = supplier.get();
            repetition--;
        }
        return o;
    }

}
