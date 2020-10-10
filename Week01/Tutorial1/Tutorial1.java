package Week01.Tutorial1;

import java.util.Scanner;

public class Tutorial1 {
    public static void main(String[] args) {
        Scanner kboard = new Scanner(System.in);
        String choice;
        int card1 = 0;
        int card2 = 0;
        int newCard;
        int total;



        for (int x=0;x<1;x++) {
            card1 = (int) (Math.random() * 10) + 1;
//            System.out.println(card1);
        }

        for (int x=0;x<1;x++)   {
            card2 = (int)(Math.random()*10) + 1;
//            System.out.println(card2);
        }

        total = card1 + card2;
        System.out.println("The Object of the game is to score between 19 and 21");
        System.out.print("You have " + total + "," + " do you want another card y/n? ");
        choice = kboard.next();
        while (choice.equalsIgnoreCase("y"))
        {
            for (int x=0;x<1;x++) {
                newCard = (int) (Math.random() * 10) + 1;
                System.out.println(newCard);
                total = total + newCard;
                System.out.print("You have " + total + "," + " do you want another card y/n? ");
                choice = kboard.next();
            }
        }

        if (total >= 19 && total <= 21)   {
            System.out.println("You have won!");
        }else{
            System.out.println("You have lost, please try again");
        }
    }
}



