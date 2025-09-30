package src;

import java.util.List;

public class DrinksMenu
{
    public static void main(String[] args)
    {
        int age = TextUI.promptInt("Enter your age: ");
        List<String> options = TextUI.getDrinkOptions(age);

        TextUI.displayOptions(options);

        int numberOfDrinks = TextUI.promptInt("How many drinks do you wish for: ");
        List<String> choices = TextUI.getDrinkChoices(options, numberOfDrinks);

        for (String choice : choices)
        {
            System.out.println("Here is your drink: " + choice);
        }
    }
}
