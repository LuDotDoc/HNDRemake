package Week06.HotelBookingRemade;

/*************************************************************************
 *                           Luke Docwra 17019043                         *
 *                             2020 HND Tutorial                          *
 *                               Week06.HotelBooking                          *
 *************************************************************************/

public class Hotel {
    private int number;
    private String name;
    private Floor[] floors;

    public Hotel(int nos, String name) {
        this.number = nos;
        this.name = name;

        this.floors = new Floor[4];
        this.floors[0] = new Floor(1);
        this.floors[1] = new Floor(2);
        this.floors[2] = new Floor(3);
        this.floors[3] = new Floor(4);
    }

    public void display() {
        System.out.println("Hotel Name: " + this.name);

//        for (int counter=0;counter <floors.length; counter++)
//        {
//            floors[counter].displayFloors();
//        }

        for (Floor floor : this.floors) {
            floor.displayFloors();
        }
    }

    public void display(int floornos) {
        System.out.println("Hotel Name: " + this.name);
        this.floors[floornos].displayFloors();
    }

//    public void bookRoom() {
//        Scanner kboard = new Scanner(System.in);
//        int floorchoice;
//        System.out.println("Which floor would you like to stay on?");
//        floorchoice = kboard.nextInt();
//        this.floors[floorchoice - 1].findaRoomtoBook();
//    }

    public void bookRoom(int passedFloorChoice, int passedRoomNumber) {
        int floorChoice = passedFloorChoice;
        int roomChoice = passedRoomNumber;
        this.floors[floorChoice].findaRoomtoBook(roomChoice);
    }

    public void displayRoomOccupant(int passedFloorChoice, int passedRoomNumber)    {
        this.floors[passedFloorChoice].displayRoomStatus(passedRoomNumber);
    }

//    public void cancelRoom() {
//        Scanner kboard = new Scanner(System.in);
//        int floorchoice;
//        System.out.println("Which floor are you staying stay on?");
//        floorchoice = kboard.nextInt();
//        this.floors[floorchoice - 1].findaRoomtoCancel();
//    }

    public void cancelRoom(int passedFloorChoice, int passedRoomNumber) {
        int floorChoice = passedFloorChoice;
        int roomChoice = passedRoomNumber;
        this.floors[floorChoice].findaRoomtoCancel(roomChoice);
    }

    public int totalOccupantsInHotel() {
        int takenRooms = 0;

        for(int i = 0; i < this.floors.length; i++)   {
            takenRooms += this.floors[i].totalOccupants();
        }

        return takenRooms;
    }



    public Floor getFloor(int floorNumber) {
        return this.floors[floorNumber];
    }

    public Floor[] getFloors() {
        return this.floors;
    }

    public String getName() {
        return this.name;
    }
}
