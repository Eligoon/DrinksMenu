import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {

    private Scanner scan = new Scanner(System.in);

    public void displayList(ArrayList<String> list, String msg){
        System.out.println(msg);
        for (String option : list) {
            System.out.println(option);
        }

    }
    public String promptText(String msg){
        System.out.println(msg);
        String input = scan.nextLine();
        return input;
    }
    public int promptNumeric(String msg){

        String input = promptText(msg);         //Give brugere et sted at placere sit svar og vente på svaret
        int number = Integer.parseInt(input);       //Konvertere svaret til et tal
        return number;
    }
    public String promptChoice(ArrayList<String> optionslist){//["Gin&Tonic", "Beer","Vine" ]

        displayList(optionslist, "");
        int input = promptNumeric("");//1
        return optionslist.get(input-1);

    }



}
