package Week01.Tutorial1;

import java.util.Scanner;

public class Tutorial1c {
    public static Scanner kboard = new Scanner(System.in);



    public static int getRandomNumber() {
        return (int) (Math.random() * 10) + 1;
    }

    public static int calcTotal(int x, int y)  {
        int total;
        return total = x + y;
    }

    public static boolean getResult(int z)  {
        if (z >= 19 && z <= 21)   {
            return true;
        }else{
            return false;
        }
    }

    public static boolean busted(int z) {
        if (z > 21) {
            return true;
        }
        else    {
            return false;
        }
    }

    public static int houseDraw()   {
        int min = 16;
        int max = 30;
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void main(String[] args) {
        String choice;
        int card1 = 0;
        int card2 = 0;
        int newCard;
        int total;

        card1 = getRandomNumber();
        card2 = getRandomNumber();
        total = calcTotal(card1, card2);

        System.out.println("The Object of the game is to score between 19 and 21");
        System.out.print("You have " + total + "," + " do you want another card y/n? ");
        choice = kboard.next();
        while (choice.equalsIgnoreCase("y"))
        {
            newCard = getRandomNumber();
            total = total + newCard;
            System.out.print("You have " + total + "," + " do you want another card y/n? ");
            choice = kboard.next();
        }

        if (getResult(total))   {
            System.out.println("You win with " + total + " house had: " + houseDraw());
        }else if (busted(total)){
            System.out.println("You are bust with "  + total + " house had: " + houseDraw());
        }else   {
            System.out.println("You lose with "  + total + " house had: " + houseDraw());
        }







    }
}




