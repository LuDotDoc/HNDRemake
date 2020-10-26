package Week06.HotelBookingRemade;

import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week06.HotelBooking                          *
 *************************************************************************/

public class Customer {
    private String name;
    private String email;

    public Customer() {
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    /**
     * Outputs the contents of the object to the console.
     */
    public void display() {
        System.out.println("Email " + this.email);
        System.out.println("Name" + this.name);
    }

    /**
     * Set customer details by user input.
     */
    public void setByUserInput() {
        Scanner kboard = new Scanner(System.in);

        System.out.print("Please enter your contact email: ");
        this.email = kboard.nextLine();

        System.out.print("Please enter your contact name: ");
        this.name = kboard.nextLine();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
