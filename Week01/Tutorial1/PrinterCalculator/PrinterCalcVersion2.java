package Week01.Tutorial1.PrinterCalculator;

import java.util.Scanner;

public class PrinterCalcVersion2 {

    public static String timeConvertMinutesToHoursAndMinutes(int time) {
        int hours = time / 60; //since both are ints, you get an int
        int minutes = time % 60;
        return (hours + " hours " + minutes + " minutes");
    }

    public static int timeConvertHoursAndMinutesToMinutes(int givenHours, int givenMinutes) {
        int hours = givenHours * 60; //since both are ints, you get an int
        int minutes = givenMinutes;
        return (hours + minutes);
    }

    public static void main(String[] args) {
        float timeElapsed;
        int elapsedHours;
        int elapsedMinutes;
        float percentageCompleted;
        float timeRemains;
        float decimalizedPercentage;
        Scanner kboard = new Scanner(System.in);

        System.out.println("Please input the time that has elapsed");
        System.out.print("Please enter the amount of hours: ");
        elapsedHours = kboard.nextInt();
        System.out.print("Please enter the amount of minutes: ");
        elapsedMinutes = kboard.nextInt();
        timeElapsed = timeConvertHoursAndMinutesToMinutes(elapsedHours,elapsedMinutes);

        System.out.print("Please input percentage completed: ");
        percentageCompleted = kboard.nextInt();

        decimalizedPercentage = percentageCompleted / 100;
        timeRemains = timeElapsed / decimalizedPercentage - timeElapsed;
        System.out.println("There is " + timeConvertMinutesToHoursAndMinutes((int) timeRemains) + " remaining of the print!");

    }
}
