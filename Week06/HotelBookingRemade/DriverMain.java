package Week06.HotelBookingRemade;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week06.HotelBooking                          *
 *************************************************************************/

public class DriverMain
{
    public static void main(String[] args)
    {
        Hotel hotel = new Hotel(101,"The Grand");

        Menu menu = new Menu(hotel);
        menu.run();

    }
}
