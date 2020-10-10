package Week02.Clock.Clock12HR;


/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               PACKAGE_NAME                             *
 *************************************************************************/

public class DriverMain {
    public static void main(String[] args) {

        ClockMechanism c = new ClockMechanism();

        while (true)    {
            c.tick();
            c.update();
        }
    }
}

                                                                           
