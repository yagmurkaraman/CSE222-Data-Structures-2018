package hotel;

/**
 * Created by yagmur on 23.02.2018.
 */
public class Room {

    protected int roomID;
    protected String guest;
    protected int roomSize;
    protected UserInterface bookGuest;
    protected int days;
    private static String roomPrice;

    /**
     * Room Constructor
     *
     * @param guest object of guest
     * @param roomID room id
     * @param roomSize room size
     */
    public Room(UserInterface guest, int roomID, int roomSize){

        this.roomID=roomID;
        this.bookGuest=guest;
        this.roomSize=roomSize;
    }

    /**
     * Room Constructor
     *
     * @param guest username of guest
     * @param roomID room id
     * @param roomSize room size
     */
    public Room(String  guest, int roomID, int roomSize){

        this.roomID=roomID;
        this.guest=guest;
        this.roomSize=roomSize;
    }

    /**
     * Room Constructor
     *
     * @param guest username of guest
     * @param roomID room id
     * @param roomSize room size
     * @param days days of user stay in room
     * @param price price of room reservation
     */
    public Room(String  guest, int roomID, int roomSize, int days, String price){

        this.roomID=roomID;
        this.guest=guest;
        this.roomSize=roomSize;
        this.days=days;
        this.roomPrice=price;
    }
    /**
     * Room constructor
     *
     * @param guest name of guest
     * @param roomID room id
     */
    public Room(String guest, int roomID){

        this.roomID=roomID;
        this.guest=guest;
    }
    /**
     * This methods gets guest name
     * @return guest name
     */
    public String getGuest(){
        return guest;
    }
    /**
     * This methods gets room id
     * @return room id
     */
    public int getRoomID() {
        return roomID;
    }
    /**
     * This methods gets room size
     * @return room size
     */
    public int getRoomSize() {
        return roomSize;
    }
    /**
     * This method gets days of guest stay in room
     * @return room days
     */
    public int getDays() { return days; }
    /**
     * This emthod gets price of room
     * @return price of room reservation
     */
    public String getPrice() { return roomPrice; }

    /**
     * This method setter for room id
     * @param roomID id no of room
     */
    public void setRoomID(int roomID) { this.roomID++; }
    /**
     * This method return the informations of room
     * @return information of room
     */
    @Override
    public String toString() {
        String msj = this.getGuest() + ", " + this.getRoomID() + ", " + this.getRoomSize()
                     + this.getDays() + ", " + this.getPrice();
        return msj;
    }

}
