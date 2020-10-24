package Week06.HotelBookingRemade;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                            Week06.HotelBooking                         *
 *************************************************************************/

public class Room {

    private int roomNos;
    private Customer occupier;
    private boolean status;

    public Room(int rnos) {
        roomNos = rnos;
        status = true; //free
    }

    public void display() {
        System.out.println("Room number: " + roomNos);
        if (status) {
            System.out.println("Room is free");
        } else {
            occupier.display();
        }
    }

    public void bookRoom(Customer newperson) {
        if (status) {
            status = false;
            occupier = newperson;
        } else {
            System.out.println("Sorry room booked");
        }
    }

    public void bookRoom() {
        System.out.println("Room " + roomNos);
        if (status) {                                // checks to see if room is free
            Customer newCustomer = new Customer();   // this line creates an instance of customer
            newCustomer.setByUserInput();            // then we get the details

            status = false;                          // makes sure nobody else can too the room
            occupier = newCustomer;                  // attaches the new customers details to the room
        } else {
            System.out.println("Sorry room booked.");
        }
    }


    public void cancelRoom() {
        status = true;
        occupier = null;
        System.out.println("Room cancelled");
    }

    public int getRoomNumber() {
        return this.roomNos;
    }

    public boolean isFree() {
        return this.status;
    }

}

                                                                           
