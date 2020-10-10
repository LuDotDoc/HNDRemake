package Week05.inhertitanceTut.cat;

import java.io.IOException;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               inhertitancetut.cat                          *
 *************************************************************************/

public class driverMain {
    public static void main(String[] args) throws IOException {
        Cat c1 = new Cat("Hamish" , "Fat White" , 3);
        Cat c2 = new Cat("Tango" , "Striped Orange" , 10);
        Cat c3 = new Cat("Mindy", "Huge Gray Striped", 10);

        c1.displayDetails();
        c2.displayDetails();
        c3.displayDetails();

    }
}

                                                                           
