/* Dialog til bestilling af drinks.
  Den viste drinksmenu tilpasses på baggrund af brugerens indtastede alder.

  Emner: Scanner, ArrayList,  for-each, while, Integer.parseInt

  Forbedringer
 1. Validering af at det der er blevet lagt ind i choices rent faktisk findes i menuen - som det er nu kan man skrive et hvilket som helst tal
 2. Refactoring: det hele bør ikke ligge inde i main. Vi bør refaktorere for at...
    a. minimere gentagelser (DRY) fx. visning af lister,
    b. kunne genbruge dialog mønsteret i et helt andet projekt, hvor det ikke nødvendigvis handler om drinks, men om en anden slags menu.
 */



import java.util.ArrayList;
import java.util.Scanner;

class DrinksMenu{
   static TextUI ui = new TextUI();

  public static void main(String[] args) {

      Scanner scan = new Scanner(System.in);

   /*
   Vi beder om brugerens alder
   */



          int age=  ui.promptNumeric("Hvor gammel er du?");
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


     ui.displayList(options, "");



    /*
    Vi spørger om antal af drinks, så vi ved mange gange vi skal prompte i while loopet længere nede.
    Hvert valg placerer vi i en liste, så vi kan udskrive bestillingen til sidst.
    */


      int numberOfDrinks = ui.promptNumeric("Hvor mange drinks vil du bestille?");





      ArrayList<String> choices = ui.promptChoice(options, numberOfDrinks,"Vælg en drink fra listen: ");





      String name = ui.promptText("Når dine drinks er klar, vil dit navn blive råbet op.\n Indtast dit navn: ");

      /*
      Vi viser brugerens bestilling
      */
      //TODO 7: Anvend  TextUI metoden displayList() i stedet for

    //  ui.displayList( choices,name+", du har bestilt flg.: " );


      System.out.println("Når du hører dit navn, kan du hente dine drinks i baren! ");


  }

}