package hotel;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by yagmur on 22.02.2018.
 */
public abstract class User implements UserInterface {

    protected static ArrayList<Room> roomlist = new ArrayList<>();
    protected static ArrayList<UserInterface> userlist = new ArrayList<>();
    protected static ArrayList<Room> checkinlist = new ArrayList<>();
    protected static ArrayList<UserInterface> loglist = new ArrayList<>();

    protected static int TOTAL_USER_ID = 1;

    protected String name=null;
    protected String surname=null;
    protected String username;
    protected String password;
    protected int userID;
    protected String record;

    /**
     * User Constructor
     *
     * @param name name of user
     * @param surname surname of user
     * @param username username of user
     * @param password password of user
     */
    public User(String name, String surname, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.password = password;
        this.userID = TOTAL_USER_ID;
        ++TOTAL_USER_ID;
    }
    /**
     * User Constructor
     *
     * @param username username of user
     * @param password password of user
     */
    public User(String username, String password) {

        this.username = username;
        this.password = password;

    }

    /**
     * User Constructor
     *
     * @param record record of system
     */
    public User(String record) {

        this.record = record;
    }
    /**
     * This methods gets user name
     * @return user name
     */
    public String getName() {
        return name;
    }

    /**
     * This methods gets user surname
     * @return user surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This methods gets user surname
     * @return user surname
     */
    public String getUsername() {
        return username;
    }
    /**
     * This methods gets user surname
     * @return user surname
     */
    public String getPassword() {
        return password;
    }


    /**
     * This method gets user ID
     * @return userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     * This methods sets user name
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method set user surname
     * @param surname new user surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }
    /**
     * This methods sets user name
     * @param username new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method set user surname
     * @param password new user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method reserve room
     *
     * @param room Room object that want to reserve
     * @return boolean room can reserve or not
     * @throws IOException exception
     */
    public boolean roomReservation(Room room) throws IOException {

        PrintWriter output = null;
        output = new PrintWriter(new FileWriter("src/files/ReservedRooms.csv", true));

        output.printf("%s;%d;%d;%d;%s\n", room.getGuest(), room.getRoomID(), room.getRoomSize(), room.getDays(), room.getPrice());
        roomlist.add(room);
        output.close();

        return true;
    }
    /**
     * This method cancel reservation
     *
     * @param room Room object that want to cancel reservation
     * @return boolean that reserve canceled or not
     * @throws Exception exception
     */
    public boolean cancelReserve(Room room) throws Exception {

        boolean flag=true;
        for(Room rooms: roomlist) {
            if(rooms.getGuest().equals(room.getGuest()) &&
                    (rooms.getRoomID() == (room.getRoomID()))){

                flag=false;
                PrintWriter output = null;
                output = new PrintWriter(new FileWriter("src/files/ReservedRooms.csv"));

                roomlist.remove(rooms);
                for (int i = 0; i < roomlist.size(); i++) {
                    Room room1 = roomlist.get(i);
                    output.printf("%s;%d;%d;%d;%s\n", room1.getGuest(), room1.getRoomID(), room1.getRoomSize(),
                            room1.getDays(), room1.getPrice());
                }
                System.out.println("Your reservation canceled!...Good Days!..\n");
                output.close();
                Receptionist.updateRoomData();
                return true;
            }
        }
        if(flag==true)
            System.out.println("This room not reserved by you!\n");

        return false;
    }
    /**
     * This method find guest has how many reservations
     *
     * @param username username of guest
     * @return count of reservations
     */
    public int countReserve(String username){

        int count=0;
        for(int i=0; i<roomlist.size(); ++i){

            if(roomlist.get(i).guest.equals(username)) {

                ++count;
                System.out.println("Room ID: " + roomlist.get(i).roomID);
            }
        }
        return count;
    }
    /**
     * This method find valid room for user
     *
     * @return room id
     */
    public int searchRoom() {

        if(roomlist.size() == 0)
            return 300;

        return roomlist.get(roomlist.size()-1).getRoomID()+1;
    }
    /**
     * This method take room size and room days, find price of room
     *
     * @param roomSize number of people in room
     * @param days number of days stay in room
     * @return price of room reservation
     */
    public int getRoomPrice(int roomSize, int days) {

        return ((roomSize-1)*40+50)*days;
    }
    /**
     * This methods compares two user objects.
     *
     * @param obj Compare object
     * @return result of comparation
     */
    @Override
    public boolean equals(Object obj) {

        if(this.getUserID() == ((User)obj).getUserID())
            return true;
        return false;
    }
    /**
     * This method return name and surname of guest
     *
     * @return String information of object
     */
    @Override
    public String toString() {
        return String.format("Name :" + getName() + "; " + "Surname: " + getSurname()
        + "; " + " Username: " + getUsername() + "; " + " Password: " + getPassword());
    }
    /**
     * This method find a hash code
     *
     * @return hash code for each user
     */
    @Override
    public int hashCode() { return getUserID(); }

}
