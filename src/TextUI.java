package src;

import java.util.ArrayList;
import java.util.Scanner;

public class TextUI
{
    // Instance of Scanner for reading user input
    private Scanner scan = new Scanner(System.in);

    // Prompts the user for a line of text and returns it.
    public String promptString()
    {
        return scan.nextLine();
    }

    // Prompts the user to enter a non-negative integer.
    public int promptInt()
    {
        int num = -1;
        while (num < 0)
        {
            String input = scan.nextLine();

            try
            {
                num = Integer.parseInt(input);
                if (num < 0)
                {
                    System.out.println("Please enter a non-negative number.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input, enter a number.");
            }
        }
        return num;
    }

    // Displays a menu of options and prompts the user to pick one
    public int promptInt(ArrayList<String> menuOptions)
    {
        int choice = -1;

        while (choice < 1 || choice > menuOptions.size())
        {
            for (int i = 0; i < menuOptions.size(); i++)
            {
                System.out.println((i + 1) + ") " + menuOptions.get(i));
            }

            System.out.print("Enter choice (1-" + menuOptions.size() + "): ");
            String input = scan.nextLine();

            try
            {
                choice = Integer.parseInt(input);
                if (choice < 1 || choice > menuOptions.size())
                {
                    System.out.println("Invalid choice, try again.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input, enter a number.");
            }
        }

        return choice;
    }

    // Asks the user to input a number with a message
    public int promptNumeric(String msg)
    {
        System.out.println(msg);
        int num = -1;
        while (num < 0)
        {
            String input = scan.nextLine();
            try
            {
                num = Integer.parseInt(input);
                if (num < 0)
                {
                    System.out.println("Please enter a non-negative number.");
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Invalid input, enter a number.");
            }
        }
        return num;
    }

    // Asks the user for text input and returns it
    public String promptText(String msg)
    {
        System.out.println(msg);
        return scan.nextLine();
    }

    // Displays a list of items with a header text
    public void displayList(String header, ArrayList<String> list)
    {
        System.out.println(header);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println((i + 1) + ") " + list.get(i));
        }
    }

    // Asks the user to choose a specific number of drinks from the available options
    public ArrayList<Integer> promptChoice(String msg, ArrayList<String> options, int limit)
    {
        System.out.println(msg);

        ArrayList<Integer> choices = new ArrayList<>();
        displayList("Drinks menu:", options);

        while (choices.size() < limit)
        {
            int choice = promptNumeric("Choose drink " + (choices.size() + 1) + " of " + limit + ":");

            if (choice >= 1 && choice <= options.size())
            {
                choices.add(choice - 1); // store zero-based index
                System.out.println("You chose: " + options.get(choice - 1));
            }
            else
            {
                System.out.println("Invalid choice, try again.");
            }
        }

        return choices;
    }

    // Returns a list of drink options based on the user's age
    public ArrayList<String> getDrinkOptions(int age)
    {
        ArrayList<String> options = new ArrayList<>();

        if (age >= 18)
        {
            options.add("Bloody Mary");
            options.add("Beer");
            options.add("Vodka");
            options.add("Wine");
            options.add("Mojito");
        }
        else
        {
            options.add("Juice");
            options.add("Soda");
            options.add("Milk");
            options.add("Water");
            options.add("Sparkling Water");
        }

        return options;
    }

    // Asks the user to choose a specific number of drinks from the available options (string-based version)
    public ArrayList<String> getDrinkChoices(ArrayList<String> options, int numberOfDrinks)
    {
        ArrayList<String> choices = new ArrayList<>();

        System.out.println("Available drinks:");
        while (choices.size() < numberOfDrinks)
        {
            int choiceNum = promptInt(options); // use menu-based prompt
            String chosenDrink = options.get(choiceNum - 1);
            choices.add(chosenDrink);
            System.out.println("You chose: " + chosenDrink);
        }

        return choices;
    }
}
