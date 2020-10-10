package Week05.inhertitanceTut.person;

import java.io.IOException;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               inhertitancetut.person                          *
 *************************************************************************/

public class DriverMain {
    public static void main(String[] args) throws IOException {
        Person p1 = new Person("Fred Bloggs","10 King Street Perth",34);
        Person p2 = new Person("Anne Smith", "6 High Street Inverness", 35);

        p1.displayDetails();
        p2.displayDetails();

        p2.changeAge(p2.returnAge());

        p2.displayDetails();

    }
}

                                                                           
