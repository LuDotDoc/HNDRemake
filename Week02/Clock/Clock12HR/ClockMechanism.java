package Week02.Clock.Clock12HR;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               PACKAGE_NAME                          *
 *************************************************************************/

public class ClockMechanism {

    private int seconds;
    private int minutes;
    private int hours;

    public void tick()  {
        seconds = seconds +1;
        minutes = minutes + seconds / 60;
        hours = hours + minutes / 60;
        seconds = seconds %60;
        minutes = minutes %60;
        hours = hours % 24;
    }


    public void amOrPM()    {
        if (hours > 12) {
            hours = hours % 12;
        }
    }
    public void update()    {
        System.out.println("The time is: " + hours + ":" + minutes + ":" + seconds);
    }

}

                                                                           
