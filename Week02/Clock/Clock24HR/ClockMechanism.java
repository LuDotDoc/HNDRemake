package Week02.Clock.Clock24HR;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Clock24HR                                *
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

    public void update()    {
        System.out.println("The time is: " + hours + ":" + minutes + ":" + seconds);
    }

}

                                                                           
