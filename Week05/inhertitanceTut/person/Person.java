package Week05.inhertitanceTut.person;

import java.io.IOException;
import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               inhertitancetut.person                          *
 *************************************************************************/

public class Person {
    static Scanner kboard = new Scanner(System.in);
    private String personsName;
    private String personsAddress;
    int personsAge;

    public Person(String personsName, String personsAddress, int personsAge) {
        this.personsName = personsName;
        this.personsAddress = personsAddress;
        this.personsAge = personsAge;
    }

    public void getPersonName(String gName) {
        personsName = gName;
    }

    public void getPersonAddress(String gAddress) {
        personsAddress = gAddress;
    }

    public void getPersonAge(int gAge) {
        personsAge = gAge;
    }

    public void displayDetails() throws IOException {
        System.out.println("Person's name is : " + personsName);
        System.out.println("Person's address is : " + personsAddress);
        System.out.println("Person's age is : " + personsAge);
    }

    public int returnAge() {
        int newAge;
        System.out.print("Please enter updated age : ");
        newAge = kboard.nextInt();
        return newAge;
    }

    void changeAge(int cAge) {
        personsAge = cAge;
    }
}


