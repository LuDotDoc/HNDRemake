package Week02.Tutorial1ClassesAndObjects.Problem1;

import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *************************************************************************/

public class Person {

    public String forename;
    public String surname;
    public String email;
    public String mobile;
    public int age;

    private Scanner kboard = new Scanner(System.in);

    public Person() {

//        this.forename = "Gill";
//        this.surname = "Blue";
//        this.email = "g.b@gmial.com";
//        this.mobile = "0798783022";
//        this.age = 22;

        this.inputForename();
        this.inputSurname();
        this.inputEmail();
        this.inputAge();
        this.inputMobile();
    }


    public Person(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }

    public Person(String forename, String surname, int age) {
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }

    public void displayPerson() {
        System.out.println("Person{" +
                "forename='" + forename + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", mobile='" + mobile + '\'' +
                ", age=" + age +
                '}'
        );

    }

    public void inputForename() {
        System.out.print("Please enter forename: ");
        this.forename = this.kboard.next();
    }

    public void inputSurname() {
        System.out.print("Please enter surname: ");
        this.surname = this.kboard.next();
    }

    public void inputEmail() {
        System.out.print("Please enter Email: ");
        this.email = this.kboard.next();
    }

    private boolean checkAge(int age) {
        boolean oldEnough = age >= 18;

        if (!oldEnough) {
            System.out.println("You are not old enough.");
        }

        return oldEnough;
    }

    public void inputAge() {
//        System.out.print("Please enter Age: ");
//        this.age = this.kboard.nextInt();

        int age = 0;
        do {
            System.out.print("Please enter Age: ");
            age = this.kboard.nextInt();
        } while (!this.checkAge(age));                  //If age is less than 18, the loop repeats. The check is at the end so the error message is display after failing

        this.age = age;
    }

    public void inputMobile() {
        System.out.print("Please enter mobile: ");
        this.mobile = this.kboard.next();
    }


}

                                                                           
