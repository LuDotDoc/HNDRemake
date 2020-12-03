package Week06.HotelBooking;

import java.util.Scanner;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week06.HotelBooking                          *
 *************************************************************************/

public class floor {
    private int floornumber;
    room rooms[] = new room[4];

    public floor(int nos)
    {
        floornumber = nos;
        room r1 = new room(1);
        room r2  = new room(2);
        room r3 = new room(3);
        room r4 = new room(4);

        rooms[0] = r1; rooms[1] = r2; rooms[2] = r3; 	rooms[3] = r4;
    }

    public void displayFloor()
    {
        for(int counter=0;counter<rooms.length;counter++)
            rooms[counter].display();
    }

    public void findaRoomtoBook()
    {
        Scanner kboard = new Scanner(System.in);
        int nos; int counter=0; boolean found = false;
        System.out.println("Please enter room number: ");
        nos = kboard.nextInt();
        for (counter=0; counter < rooms.length; counter++)
        {
            if (nos == rooms[counter].returnRoomNos())
            {
                found = true;
                rooms[counter].bookroom();
                break;
            }
        }
        if (found == false) System.out.println("No such room number");
    }

    public void findaRoomtoCancel()
    {
        Scanner kboard = new Scanner(System.in);
        int nos; int counter=0; boolean found = false;
        System.out.println("Please enter room number: ");
        nos = kboard.nextInt();
        for (counter=0; counter < rooms.length; counter++)
        {
            if (nos == rooms[counter].returnRoomNos())
            {
                found = true;
                rooms[counter].cancelRoom();
                break;
            }
        }
        if (found == false) System.out.println("No such room number");
    }

}

                                                                           
