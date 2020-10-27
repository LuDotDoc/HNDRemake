package Week06.HotelBookingRemade;

import Week06.HotelBooking.floor;

import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                         Week06.HotelBookingRemade                      *
 *************************************************************************/

public class Menu {

    private Scanner kboard;

    private Hotel hotel;
    private int currentFloor;
    private int currentRoom;

    public enum States {
        EXIT,
        MAIN,
        FLOOR,
        ROOM
    }

    private States state;

    public Menu(Hotel hotel) {
        this.kboard = new Scanner(System.in);

        this.hotel = hotel;
        this.currentFloor = 0;
        this.currentRoom = 0;

        this.state = States.MAIN;
    }

    /**
     * Corrects the discrepancy between index value and real world value so it's easier for the user to understand
     * Allows the menu to only display the correct number of floors in relation to the hotel object. You cannot get less than 0 or more than available floors
     * @param newfloor
     */
    public void setCurrentFloor(int newfloor) {
        //newfloor = newfloor - 1;
        newfloor--; // Make sure newfloor is an index rather than floor number

        if (newfloor < 0) {
            newfloor = 0; // Cannot be less than zero
        }

        if ( newfloor > this.hotel.getFloors().length ) {
            newfloor = this.hotel.getFloors().length - 1; // Cannot be greater than available floors
        }

        this.currentFloor = newfloor;
    }

    /**
     * Same as above but with room numbers instead of floors.
     * @param newRoom
     */
    public void setCurrentRoom(int newRoom) {
        newRoom--; // Make index rather than room number

        if (newRoom < 0) {
            newRoom = 0; // Cannot be less than zero
        }

        if ( newRoom > this.hotel.getFloor(this.currentFloor).getRooms().length) {
            newRoom = this.hotel.getFloors().length - 1; // Cannot be greater than available rooms
        }

        this.currentRoom = newRoom;
    }

    /**
     * A simple way to pause the menu interaction to allow the user to read the details on screen before progressing
     */
    public void advancePrompt() {
        System.out.print("[Press Enter to Continue]");
        //kboard.nextLine();
        try {
            int read = System.in.read(new byte[2]);
        } catch (Exception e) {
            // Ignore it
        }
    }

    /**
     * Main menu containing the first level of switch statement to navigate the program
     */
    public void mainMenu() {
        System.out.println("================================================");
        System.out.println("  Welcome to the "+ this.hotel.getName());
        System.out.println("================================================");
        System.out.println("There are currently " + this.hotel.totalOccupantsInHotel() +  " guests at this hotel");
        System.out.println("1. Display Overall Booking Status");
        System.out.println("2. Floor menu");
        System.out.println("");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Please input selection number: ");

        switch (kboard.nextInt()) {
            case 0:
                this.state = States.EXIT;
                break;
            case 1:
                hotel.display();
                this.advancePrompt();
                break;
            case 2:
                this.state = States.FLOOR;
                break;
            default:
                // do nothing
                break;
        }
    }

    /**
     * Floor menu, the second level of switch statements.
     */
    public void floorMenu() {
        System.out.println("==================");
        System.out.println("=== Floor Menu ===");
        System.out.println("==================");
        System.out.println("Floor: " + (this.currentFloor + 1) + "/" + this.hotel.getFloors().length);
        System.out.println("1. Display Room Availability");
        System.out.println("2. Change Floor");
        System.out.println("3. ROOM Menu");
        System.out.println("");
        System.out.println("9. Back to MAIN menu");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Please input selection number: ");

        switch (kboard.nextInt()) {
            case 0:
                this.state = States.EXIT;
                break;
            case 1:
                this.hotel.getFloors()[this.currentFloor].displayFloors();
                this.advancePrompt();
                break;
            case 2:
                System.out.print("> Input Floor Number: ");
                this.setCurrentFloor(kboard.nextInt());
                break;
            case 3:
                this.state = States.ROOM;
                break;
            case 9:
                this.currentFloor = 0;
                this.state = States.MAIN;
        }
    }

    /**
     * Room menu as above but for rooms
     */
    public void roomMenu() {
        int totalRooms = this.hotel.getFloors()[this.currentFloor].getRooms().length;

        System.out.println("========================");
        System.out.println(" Room (" + (this.currentRoom + 1) + "/" + totalRooms + ") Menu");
        System.out.println("======================");
        System.out.println("1. Change ROOM");
        System.out.println("2. Book");
        System.out.println("3. Cancel");
        System.out.println("4. Display current occupier");
        System.out.println("");
        System.out.println("9. Back to FLOOR menu");
        System.out.println("0. Exit");
        System.out.println("");
        System.out.print("Please input selection number: ");

        switch (kboard.nextInt()) {
            case 0:
                this.state = States.EXIT;
                break;
            case 1:
                System.out.print("> Input ROOM Number: ");
                this.setCurrentRoom(kboard.nextInt());
                break;
            case 2:
                this.hotel.bookRoom(this.currentFloor, (this.currentRoom));
                break;
            case 3:
                this.hotel.cancelRoom(this.currentFloor, (this.currentRoom));
                break;
            case 4:
                this.hotel.displayRoomOccupant(this.currentFloor, this.currentRoom);
                break;
            case 9:
                this.currentRoom = 0;
                this.state = States.FLOOR;
        }
    }

    /**
     * Basic menu functionality tying the enums providing to the menu they relate to MAIN to the main menu for example.
     */
    public void menuControl() {
        switch (this.state) {
            case MAIN:
                this.mainMenu();
                break;
            case FLOOR:
                this.floorMenu();
                break;
            case ROOM:
                this.roomMenu();
                break;
            default:
                System.out.println("I have a certain set of skills...");
                System.out.println("I Don't know how you got here.. but you shouldn't be here.");
                System.exit(1);
                break;
        }
    }

    /**
     * A method allowing the user to read a nice message upon exiting the software.
     */
    public void run() {
        while (true) {
            if (this.state == States.EXIT) {
                System.out.println("Farewell!");
                break;
            }

            menuControl();
        }
    }
}
