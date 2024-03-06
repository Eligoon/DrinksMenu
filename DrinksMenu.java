import java.util.ArrayList;
import java.util.Scanner;

class DrinksMenu{
	

  public static void main(String[] args) {


      Scanner scan = new Scanner(System.in);


      System.out.println("Hvor gammel er du?");//Stille brugeren et spørgsmål

      String input = scan.nextLine();          //Give brugere et sted at placere sit svar og vente på svaret
      int age = Integer.parseInt(input);       //Konvertere svaret til et tal


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
      for (String option : options) {
          System.out.println(option);
      }

     /*
     Vi spørger om antal af drinks, så vi ved hvor mange gange vi skal prompte i while loopet længere nede.
     */
      System.out.println("Hvor mange drinks vil du bestille?");  //Stille brugeren et spørgsmål
      int numberOfDrinks = Integer.parseInt(scan.nextLine());    //Give brugere et sted at placere sit svar og vente på svaret
      // Alternative:
      // int numberOfDrinks = scan.nextInt();
      /* ...the above is ok, but BEWARE OF THE SCANNERBU: When using nextInt() right before nextLine(): the nextLine call will be skipped...
       fix this by simply calling nextLine() once before you actually need it
       Another fix: read it as string, then parse it*/

      /* Vi laver en beholder til at gemme brugerens valg, som han foretager nede i while loopet*/
      ArrayList<String> choices = new ArrayList<String>();
    
      /* Vi tjekker om brugeren skal vælge flere drinks*/
      while(choices.size() < numberOfDrinks){

        System.out.println("Vælg en drink fra listen: ");
       	String choice = scan.nextLine();
        /*  Hvert valg placerer vi i en liste, så vi kan udskrive bestillingen til sidst.*/
       	choices.add(choice);
   		}



      /* 
      Vi viser listen til brugeren
      */

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