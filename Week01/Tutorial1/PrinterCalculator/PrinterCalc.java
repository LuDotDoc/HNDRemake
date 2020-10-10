package Week01.Tutorial1.PrinterCalculator;

import java.util.Scanner;

public class PrinterCalc {

    public static String timeConvert(int time) {
        int hours = time / 60; //since both are ints, you get an int
        int minutes = time % 60;
        return (hours + " hours " + minutes + " minutes");

    }

    public static void main(String[] args) {
        float timeElapsed;
        float percentageCompleted;
        float timeRemains;
        float decimalizedPercentage;
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please input the time that has elapsed: ");
        timeElapsed = kboard.nextInt();
        System.out.print("Please input percentage completed: ");
        percentageCompleted = kboard.nextInt();

        decimalizedPercentage = percentageCompleted / 100;
        timeRemains = timeElapsed / decimalizedPercentage - timeElapsed;
        System.out.println("There is " + timeConvert((int) timeRemains) + " remaining of the print!");

    }
}
