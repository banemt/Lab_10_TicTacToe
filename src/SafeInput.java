import java.util.Scanner;

public class SafeInput {

    /**
     *
     * @param pipe   a Scanner opened to read from System.in
     * @param prompt prompt for the user
     * @return a String response that is not zero length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do {
            System.out.print("\n" + prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        } while (retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                valid = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + " is not an int!");
            }
            pipe.nextLine(); // clear the buffer
        } while (!valid);
        return value;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double value = 0.0;
        boolean valid = false;

        do {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                valid = true;
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input: " + trash + " is not a double!");
            }
            pipe.nextLine(); // clear the buffer
        } while (!valid);
        return value;
    }

    public static int getRangeInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                if (value >= low && value <= high) {
                    valid = true;
                } else {
                    System.out.println("Number is not in range [" + low + " - " + high + "].");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input " + trash + "is not a valid integer!");
            }
        } while (!valid);
        return value;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double value = 0.0;
        boolean valid = false;

        do {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine(); // clear the buffer
                if (value >= low && value <= high) {
                    valid = true;
                } else {
                    System.out.println("Double is not in range [" + low + " - " + high + "].");
                }
            } else {
                String trash = pipe.nextLine();
                System.out.println("Invalid input " + trash + "is not a valid double!");
            }
        } while (!valid);
        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean valid = false;

        do {
            System.out.print(prompt + " [Y,N]: ");
            response = pipe.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                return true;
            } else if (response.equalsIgnoreCase("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N!");
            }
        } while (!valid);
        return false;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        String returnString = "";
        boolean valid = false;
        do {
            System.out.print(prompt);
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                returnString = response;
                valid = true;
            } else {
                System.out.println("Invalid input. Please enter a valid expression!");
            }
        } while (!valid);
        return returnString;
    }

    public static void prettyHeader(String msg) {
        final int width = 60;
        int paddingTotal = 0;
        int paddingRight = 0;
        int paddingLeft = 0;

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();

        paddingTotal = width - 6 - msg.length();
        paddingLeft = paddingTotal / 2;
        paddingRight = paddingTotal - paddingLeft;

        System.out.print("***");
        for (int i = 0; i < paddingLeft; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < paddingRight; i++) {
            System.out.print(" ");
        }
        System.out.println("***");

        for (int i = 0; i < width; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
