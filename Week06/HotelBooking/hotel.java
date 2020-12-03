package Week06.HotelBooking;
import java.util.Scanner;
/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week06.HotelBooking                          *
 *************************************************************************/

public class hotel
{
    private int hotelnumber;
    private String hotelname;
    private floor floors[] = new floor[4];

    public hotel(int nos, String name)
    {
        hotelnumber = nos;
        hotelname = name;
        floor f1 = new floor(1);
        floor f2 = new floor(2);
        floor f3 = new floor(3);
        floor f4 = new floor(4);
        floors[0] = f1;
        floors[1] = f2;
        floors[2] = f3;
        floors[3] = f4;

    }

    public void display()
    {
        System.out.println("Hotel Name: "+hotelname);
        for (int counter=0;counter <floors.length; counter++)
        {
            floors[counter].displayFloor();
        }
    }

    public void display(int floornos)
    {
        System.out.println("Hotel Name: "+hotelname);
        floors[floornos].displayFloor();
    }

    public void bookARoom()
    {
        Scanner kboard = new Scanner(System.in);
        int floorchoice;
        System.out.println("Which floor would you like to stay on?");
        floorchoice = kboard.nextInt();
        floors[floorchoice-1].findaRoomtoBook();
    }

    public void CancelARoom()
    {
        Scanner kboard = new Scanner(System.in);
        int floorchoice;
        System.out.println("Which floor are you staying stay on?");
        floorchoice = kboard.nextInt();
        floors[floorchoice-1].findaRoomtoCancel();
    }

}


                                                                           
