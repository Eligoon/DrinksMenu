package src;

import java.util.Scanner;

class TextUI
{
    private static Scanner scan = new Scanner(System.in);

    public static int promptInt(String message)
    {
        System.out.print(message);
        String input = scan.nextLine();

        try
        {
            return Integer.parseInt(input);
        } catch (NumberFormatException e)
        {
            System.out.println("Invalid input. Please enter a fitting number.");
            return promptInt(message);  // recursion
        }
    }
}