package Week02.Tutorial1ClassesAndObjects.Problem2;

import java.text.DecimalFormat;
import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Problem2                                 *
 *************************************************************************/
public class Circle {
    public double Radius;

    private Scanner kboard = new Scanner(System.in);
    private DecimalFormat df = new DecimalFormat("#.##");

    public Circle() {
        this.inputRadius();
    }

    public void inputRadius()   {
        System.out.print("Please enter the radius: ");
        this.Radius = this.kboard.nextDouble();
    }

    public double calculateArea()   {
        double area = Math.PI * Math.pow(this.Radius,2);                //java functions for both PI and squaring
        return area;
    }

    public void displayInformation()    {
        System.out.println("Radius: " + this.Radius);
        System.out.println("Area: " + df.format(this.calculateArea()));
    }


}

                                                                           
