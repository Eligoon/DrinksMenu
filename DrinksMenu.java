import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Scanner;

class DrinksMenu{
	static private TextUI ui;

  public static void main(String[] args) {



       ui = new TextUI();

       String myquestion = "Hvor gammel er du?";
       int age = ui.getNumericInput("Hvor gammel er du?");



    /*
    Vi vil nu sammensætte en drinksmenu der afhænger af brugerens alder
    Vi placerer valgmulighederne i en liste - så kan den genbruges et andet sted i systemet.
    */


      ArrayList<String> options = new ArrayList<String>();

      if (age >= 18) {
          options.add("Gin&Tonic");
          options.add("Martini");
          options.add("Gin&Hass");

      } else {
          options.add("Milk");
          options.add("Juice");
          options.add("Saftevand");

      }
      options.add("vand");
      

      /* 
      Vi viser listen til brugeren
      */

      ui.diplayMenu(options);



  
      /*
      Vi spørger om antal af drinks, så vi ved mange gange vi skal prompte i while loopet længere nede.
      Hvert valg placerer vi i en liste, så vi kan udskrive bestillingen tilsidst.
      */


      //TODO: anvend TextUI's getNumericInput metode, i stedet for disse to linjer

     int numberOfDrinks = ui.getNumericInput("Hvor mange drinks vil du bestille?");

      ArrayList<String> choices = new ArrayList<String>();  //Lave en beholder til at gemme brugerens valg
    

      while(choices.size() < numberOfDrinks){             //tjekke om brugeren skal vælge flere drinks
        //TODO: Reducer dette til en linje ved at anvende TextUI metoden getChoice(options) i stedet for

         String choice =  ui.getChoice(options, "Vælg en drink fra listen: " );
       	   choices.add(choice);
   		}



      /* 
      Vi viser listen til brugeren
      */
      //TODO: Genbrug TextUI metoden displayList(choices) i stedet for
   	  System.out.println("Du har bestilt flg.: ");    
      for(String choice: choices){
      System.out.println(choice);
    }



   /* Mulige forbedringer af denne dialog:
    1. Valgmulighederne printes med et tal, så man bare taster et tal for en bestemt drink - hvor kan vi ændre på det og hvordan?
    2. Validering af at det der er blevet lagt ind i choices rent faktisk findes i menuen - som det er nu kan man bestille hvad somhelst.
    3. Refaktorering: det hele bør ikke ligge inde i main. 
       a. Vi bør refaktorere for at minimere gentagelser (DRY) fx. visning af lister, 
       b. men vi bør også refaktorere for at kunne genbruge dialog mønsteret i et helt andet projekt, hvor det ikke nødvendigvis handler om drinks, men om en anden slags menu. 
    */



  }

}