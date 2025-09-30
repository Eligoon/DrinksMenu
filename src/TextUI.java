package src;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI
{
    private static Scanner scan = new Scanner(System.in);

    public static int promptInt(String message)
    {
        System.out.print(message);
        String input = scan.nextLine();

        try
        {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a fitting number.");
            return promptInt(message);  // recursion
        }
    }

    public static ArrayList<String> getDrinkOptions(int age)
    {
        ArrayList<String> options = new ArrayList<>();

        if (age >= 18) {
            options.add("Bloody Mary");
            options.add("Beer");
            options.add("Vodka");
            options.add("Wine");
            options.add("Mojito");
        } else {
            options.add("Juice");
            options.add("Soda");
            options.add("Milk");
            options.add("Water");
            options.add("Sparkling Water");
        }

        return options;
    }

    public static void displayOptions(ArrayList<String> options)
    {
        System.out.println("Available drinks:");
        for (int i = 0; i < options.size(); i++)
        {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public static ArrayList<String> getDrinkChoices(ArrayList<String> options, int numberOfDrinks)
    {
        ArrayList<String> choices = new ArrayList<>();

        while (choices.size() < numberOfDrinks)
        {
            int choiceNum = promptInt("Pick a drink by number from the list: ");

            if (choiceNum >= 1 && choiceNum <= options.size())
            {
                choices.add(options.get(choiceNum - 1));
            } else {
                System.out.println("Invalid choice. Please pick a fitting number.");
            }
        }

        return choices;
    }
}
