package src;

import java.util.ArrayList;

public class DrinksMenu
{
    public static void main(String[] args)
    {
        TextUI ui = new TextUI();

        System.out.println("Welcome to the Drinks Menu!");

        System.out.print("Enter your age: ");
        int age = ui.promptInt();

        ArrayList<String> options = ui.getDrinkOptions(age);

        // Display the drinks BEFORE asking how many the user wants
        System.out.println("Available drinks:");
        for (int i = 0; i < options.size(); i++)
        {
            System.out.println((i + 1) + ") " + options.get(i));
        }

        System.out.print("How many drinks do you wish for: ");
        int numberOfDrinks = ui.promptInt();

        ArrayList<String> choices = ui.getDrinkChoices(options, numberOfDrinks);

        for (String choice : choices)
        {
            System.out.println("Here is your drink: " + choice);
        }
    }
}
