package src;

import java.util.ArrayList;


class DrinksMenu {
    public static void main(String[] args) {
        ArrayList<String> options = new ArrayList<>();
        ArrayList<String> choices = new ArrayList<>();

        int age = TextUI.promptInt("Enter your age: ");

        if (age >= 18) {
            options.add("Bloody Mary");
            options.add("Beer");
            options.add("Vodka");
            options.add("Wine");
            options.add("Mojito");
        } else
            options.add("Juice");
            options.add("Soda");
            options.add("Milk");
            options.add("Water");
            options.add("Sparkling Water");


        System.out.println("Available drinks:");

        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }

        int numberOfDrinks = TextUI.promptInt("How many drinks do you wish for: ");

        while (choices.size() < numberOfDrinks) {
            int choiceNum = TextUI.promptInt("Pick a drink by number from the list: ");

            if (choiceNum >= 1 && choiceNum <= options.size()) {
                choices.add(options.get(choiceNum - 1));
            } else {
                System.out.println("Invalid choice. Please pick a fitting number.");
            }
        }

        for (String choice : choices) {
            System.out.println("Here is your drink: " + choice);
        }
    }
}