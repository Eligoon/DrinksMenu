import java.util.ArrayList;
import java.util.Scanner;

class DrinksMenu{
	static TextUI textui;

  public static void main(String[] args) {


      Scanner scan = new Scanner(System.in);
      textui = new TextUI();

     int age =  textui.promptNumeric("Hvor gammel er du?");

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
      textui.displayList(options, "Her er en aldersvarende menu til dig!");



    /*
    Vi spørger om antal af drinks, så vi ved mange gange vi skal prompte i while loopet længere nede. 
    Hvert valg placerer vi i en liste, så vi kan udskrive bestillingen tilsidst.
    */


      // int numberOfDrinks = scan.nextInt();
      // This is ok, but BEWARE OF THE SCANNERBU: When using nextInt() right before nextLine(): the nextLine call will be skipped...           
      // fix this by simply calling nextLine() once before you actually need it
      // Another fix: read it as string, then parse it

      int numberOfDrinks= textui.promptNumeric("Hvor mange drinks vil du bestille?");

      ArrayList<String> choices = new ArrayList<String>();  //Lave en beholder til at gemme brugerens valg
    

        while(choices.size() < numberOfDrinks){             //tjekke om brugeren skal vælge flere drinks
        //TODO: Reducer to linjer til en linje ved at anvende TextUI metoden promptChoice(options) i stedet for
        //System.out.println("Vælg en drink fra listen: ");
       	//String choice = scan.nextLine();

            String choice = textui.promptChoice(options) ;
            choices.add(choice);
   		}



      /* 
      Vi viser listen til brugeren
      */
      //TODO: Genbrug TextUI metoden displayList(choices) i stedet for
   	  textui.displayList(choices, "Du har bestilt flg.: ");




   /* Mulige forbedringer af denne dialog:
    1. Valgmulighederne printes med et tal, så man bare taster et tal for en bestemt drink - hvor kan vi ændre på det og hvordan?
    2. Validering af at det der er blevet lagt ind i choices rent faktisk findes i menuen - som det er nu kan man bestille hvad somhelst.
    3. Refaktorering: det hele bør ikke ligge inde i main. 
       a. Vi bør refaktorere for at minimere gentagelser (DRY) fx. visning af lister, 
       b. men vi bør også refaktorere for at kunne genbruge dialog mønsteret i et helt andet projekt, hvor det ikke nødvendigvis handler om drinks, men om en anden slags menu. 
    */



  }

}





/*

 System.out.println("Hvor mange drinks vil du bestille?");  //Stille brugeren et spørgsmål
      int numberOfDrinks = Integer.parseInt(scan.nextLine());    //Give brugere et sted at placere sit svar og vente på svaret

 */

