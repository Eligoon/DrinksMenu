/* Dialog til bestilling af drinks.
  Den viste drinksmenu tilpasses på baggrund af brugerens indtastede alder.

  Emner: Scanner, ArrayList,  for-each, while, Integer.parseInt

  Forbedringer
 1. Validering af at det der er blevet lagt ind i choices rent faktisk findes i menuen - som det er nu kan man skrive et hvilket som helst tal
 2. Refactoring: det hele bør ikke ligge inde i main. Vi bør refaktorere for at...
    a. minimere gentagelser (DRY) fx. visning af lister,
    b. kunne genbruge dialog mønsteret i et helt andet projekt, hvor det ikke nødvendigvis handler om drinks, men om en anden slags menu.
 */

package src;

import java.util.ArrayList;
import java.util.Scanner;

class DrinksMenu{


  public static void main(String[] args) {

      // TODO 1: Skriv en TextUI klasse og tilføj en instans af TextUI her, som til sidst skal erstatte direkte brug af Scanner objektet i denne klasse.
      Scanner scan = new Scanner(System.in);

   /*
   Vi beder om brugerens alder
   */

      // TODO 2: Anvend TextUI metoden promptNumeric() i stedet for
      System.out.println("Hvor gammel er du?");//Stille brugeren et spørgsmål
      String input = scan.nextLine();          //Give brugere et sted at placere sit svar og vente på svaret
      int age = Integer.parseInt(input);       //Konvertere svaret til et tal


    /*
    Vi vil nu sammensætte en drinksmenu der afhænger af brugerens alder
    Vi placerer valgmulighederne i en liste - så kan den genbruges et andet sted i systemet.
    */


      ArrayList<String> options = new ArrayList<>();

      if (age >= 18) {
          options.add("Gin&Tonic");
          options.add("Martini");
          options.add("Beer");

      } else {
          options.add("Milk");
          options.add("Juice");
          options.add("Lemonade");

      }
      options.add("Water");


    /*
     Vi viser listen til brugeren
     */

      //TODO 3: Anvend TextUI metoden displayList() i stedet for
      for (int i = 0; i < options.size();i++) {
          System.out.println(i+1+". "+options.get(i));
      }



    /*
    Vi spørger om antal af drinks, så vi ved mange gange vi skal prompte i while loopet længere nede.
    Hvert valg placerer vi i en liste, så vi kan udskrive bestillingen til sidst.
    */

      // TODO 4: Anvend TextUI metoden promptNumeric() i stedet for
      System.out.println("Hvor mange drinks vil du bestille?");  //Stille brugeren et spørgsmål
      int numberOfDrinks = Integer.parseInt(scan.nextLine());    //Give brugere et sted at placere sit svar og vente på svaret


      //TODO 5:  Anvend TextUI metoden promptChoice() i stedet for
      ArrayList<Integer> choices = new ArrayList<>();  //Lave en beholder til at gemme brugerens valg
        while(choices.size() < numberOfDrinks){             //tjekke om brugeren skal vælge flere drinks
            System.out.println("Vælg en drink fra listen: ");
       	    int choice = scan.nextInt();
            choices.add(choice);
   		}
      //TODO 6: Anvend  TextUI metoden promptText() i stedet for
      scan.nextLine();//flush
      System.out.println("Når dine drinks er klar, vil dit navn blive råbet op.\n Indtast dit navn: ");
      String name = scan.nextLine();

      /*
      Vi viser brugerens bestilling
      */
      //TODO 7: Anvend  TextUI metoden displayList() i stedet for
   	  System.out.println(name+", du har bestilt flg.: ");
      for(int choice: choices){
          System.out.println(choice + ". " + options.get(choice-1));
      }

      System.out.println("Når du hører dit navn, kan du hente dine drinks i baren! ");


  }

}