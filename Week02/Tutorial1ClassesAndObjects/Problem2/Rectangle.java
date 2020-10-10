package Week02.Tutorial1ClassesAndObjects.Problem2;



import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *************************************************************************/
public class Rectangle {
    public int Height;
    public int Width;

    private Scanner kboard = new Scanner(System.in);

    public Rectangle()  {
        this.inputHeight();
        this.inputWidth();
    }

    public void inputHeight()  {
        System.out.print("Please enter height: ");
        this.Height = this.kboard.nextInt();
    }

    public void inputWidth()  {
        System.out.print("Please enter Width: ");
        this.Width = this.kboard.nextInt();
    }

    public int calculateArea()  {
        int area = this.Height * this.Width;
        return area;
    }

    public boolean isSquare()   {
       boolean isSquare = this.Height == this.Width;

       return isSquare;
    }

    public void displayInformation()    {

        System.out.print("Height: " + this.Height);
        System.out.print(" Width: " + this.Width);
        System.out.println(" Area: " + calculateArea());

        if(!isSquare()){
            System.out.println("Shape is not a square");
        }else   {
            System.out.println("Shape is a square");
        }

    }

}

                                                                           
