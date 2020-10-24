package Week06.HotelBookingRemade;

import java.util.ArrayList;
import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week06.HotelBooking                          *
 *************************************************************************/

public class Floor {
    public static String totalOccupants;
    private int floornumber;
    private Room[] rooms;

    public Floor(int nos)
    {
        this.floornumber = nos;

        this.rooms    = new Room[4];
        this.rooms[0] = new Room(1);
        this.rooms[1] = new Room(2);
        this.rooms[2] = new Room(3);
        this.rooms[3] = new Room(4);
    }

    public void displayFloors()
    {
        ArrayList<String> freeRooms = new ArrayList<String>();
        ArrayList<String> takenRooms = new ArrayList<String>();

        for (int i = 0; i < rooms.length; i++) {
            //rooms[i].display();
            if (this.rooms[i].isFree()) {
                freeRooms.add(String.valueOf(this.rooms[i].getRoomNumber()));
            } else {
                takenRooms.add(String.valueOf(this.rooms[i].getRoomNumber()));
            }
        }

        System.out.println("Floor  : " + this.floornumber);
        if (freeRooms.size() > 0) {
            System.out.println("   Free: " + String.join(", ", freeRooms));
        }

        if (takenRooms.size() > 0) {
            System.out.println("  Taken: " + String.join(", ", takenRooms));
        }
    }

    public void totalOccupants() {
      ArrayList<Integer> freeRooms = new ArrayList<Integer>();
      ArrayList<Integer> takenRooms = new ArrayList<Integer>();
      int takenRoom = 0;
        for (int i = 0; i < rooms.length; i++) {
            //rooms[i].display();
            if (this.rooms[i].isFree()) {
                freeRooms.add(this.rooms[i].getRoomNumber());
            } else {
                takenRooms.add(this.rooms[i].getRoomNumber());
                takenRoom++; //TODO THis is probably bullshit.
            }
        }

        System.out.println(takenRoom);

    }

//    public void findaRoomtoBook()
//    {
//        Scanner kboard = new Scanner(System.in);
//        int nos; int counter=0; boolean found = false;
//        System.out.println("Please enter room number: ");
//        nos = kboard.nextInt();
//        for (counter=0; counter < rooms.length; counter++)
//        {
//            if (nos == rooms[counter].getRoomNumber())
//            {
//                found = true;
//                rooms[counter].bookRoom();
//                break;
//            }
//        }
//        if (found == false) System.out.println("No such room number");
//    }

    public void findaRoomtoBook(int passedRoomNumber) {


        rooms[passedRoomNumber].bookRoom();


    }

//    public void findaRoomtoCancel()
//    {
//        Scanner kboard = new Scanner(System.in);
//        int nos; int counter=0; boolean found = false;
//        System.out.println("Please enter room number: ");
//        nos = kboard.nextInt();
//        for (counter=0; counter < rooms.length; counter++)
//        {
//            if (nos == rooms[counter].getRoomNumber())
//            {
//                found = true;
//                rooms[counter].cancelRoom();
//                break;
//            }
//        }
//        if (found == false) System.out.println("No such room number");
//    }

    public void findaRoomtoCancel(int passedRoomNumber) {
        rooms[passedRoomNumber].cancelRoom();
    }

    public Room getRoom(int roomNumber) {
        return this.rooms[roomNumber];
    }

    public Room[] getRooms() {
        return this.rooms;
    }

}

                                                                           
