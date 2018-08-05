package hotel;

import java.io.*;
import java.util.Scanner;

/**
 * Created by yagmur on 23.02.2018.
 */
public class Receptionist extends User {

    /**
     * Receptionist Constructor
     *
     * @param username username of receptionist
     * @param password password of receptionist
     */
    public Receptionist(String username, String password) {

        super(username,password);
    }
    /**
     * This method read ReservedRoom.csv file to roomlist arraylist when execute the program
     *
     * @return true when file is read
     * @throws Exception exception
     */
    public static boolean updateRoomData() throws Exception {
        File file = null;
        Scanner filescan = null;
        roomlist.clear();
        file = new File("src/files/ReservedRooms.csv");
        filescan = new Scanner(file);
        Room newroom;

        while (filescan.hasNext()) {

            String line = filescan.next();
            String seperated[] = line.split(";");

            newroom = new Room(seperated[0], Integer.parseInt(seperated[1]), Integer.parseInt(seperated[2]),
                    Integer.parseInt(seperated[3]), seperated[4]);

            roomlist.add(newroom);
        }
        filescan.close();
        return true;
    }

    /**
     * This method read CheckIn.csv file to checkinlist arraylist when execute the program
     *
     * @return true when file is read
     * @throws Exception exception
     */
    public boolean updateCheckInData() throws Exception {
        File file = null;
        Scanner filescan = null;
        checkinlist.clear();
        file = new File("src/files/CheckIn.csv");
        filescan = new Scanner(file);
        Room newuser;

        while (filescan.hasNext()){

            String line = filescan.next();
            String seperated[] = line.split(";");

            newuser = new Room(seperated[0], Integer.parseInt(seperated[1]), Integer.parseInt(seperated[2]),
                    Integer.parseInt(seperated[3]),seperated[4]);

            checkinlist.add(newuser);
        }
        filescan.close();
        return true;
    }

    /**
     * This method read Guests.csv file to userlist arraylist when execute the program
     *
     * @return true when file is read
     * @throws Exception exception
     */
    public boolean updateUserData() throws Exception {
        
        File file = null;
        Scanner filescan = null;
        userlist.clear();
        file = new File("src/files/Guests.csv");
        filescan = new Scanner(file);
        Guest newuser;

        while (filescan.hasNext()) {
            String line = filescan.next();
            String seperated[] = line.split(";");

            newuser = new Guest(seperated[0], seperated[1], seperated[2],seperated[3]);

            userlist.add(newuser);
        }
        filescan.close();
        return true;
    }

    /**
     * This method read SystemsRecords.log file to loglist arraylist when the program execute
     *
     * @throws FileNotFoundException exception
     */
    public void getRecords() throws FileNotFoundException {

        File file = null;
        Scanner filescan = null;
        loglist.clear();
        file = new File("src/files/SystemRecords.log");
        filescan = new Scanner(file);
        String line;

        while (filescan.hasNextLine()) {

            line = filescan.nextLine();
            Guest record = new Guest(line);
            loglist.add(record);
        }
        filescan.close();
    }
    /**
     * This method add guest to system
     *
     * @param user User object for add new user to system
     * @return boolean the user can added to system or not
     * @throws IOException exception
     */
    public boolean addUser(User user) throws IOException {

        PrintWriter output = null;
        output = new PrintWriter(new FileWriter("src/files/Guests.csv", true));

        for(int i = 0; i < userlist.size(); ++i)
        {
            if(user.getUsername().equals(userlist.get(i).getUsername())){

                System.out.println("This username already registered!");
                System.out.println("Please try another username!\n");
                output.close();
                return false;
            }
        }
        output.printf("%s;%s;%s;%s\n", user.getName(),user.getSurname(), user.getUsername(),
                user.getPassword());
        output.close();
        System.out.println("Successfully added!\n");
        return (userlist.add(user));

    }
    /**
     * This method search user has reservations or not
     *
     * @param username username of guest
     * @return boolean value
     */
    public boolean searchUserReserve(String username) {

        for (int i=0; i<roomlist.size(); ++i) {

            if (roomlist.get(i).getGuest().equals(username))
                return true;
        }
        return false;
    }

    /**
     * This method take username of guest and search this username in userlist or not
     *
     * @param username username of guest
     * @return boolean value of search result
     */
    public boolean searchUserRegister(String username) {


        for (int i=0; i<userlist.size(); ++i) {

            if (userlist.get(i).getUsername().equals(username))
                return true;
        }
        return false;
    }

    /**
     * This method take username of guest and search this username in check in or not
     *
     * @param username username of guest
     * @return boolean value of search result
     */
    public boolean searchUserCheckIn(String username) {

        for (int i=0; i<checkinlist.size(); ++i) {

            if (checkinlist.get(i).getGuest().equals(username))
                return true;
        }
        return false;
    }
    /**
     * This method find reservations of guest
     *
     * @param username username of guest
     * @return the guest has how many reservations
     */
    public int countReserve(String username){

        int count=0;
        for(int i=0; i<roomlist.size(); ++i){

            if(roomlist.get(i).getGuest().equals(username)) {

                ++count;
                System.out.println("Room " + roomlist.get(i).getRoomID());
            }
        }
        return count;
    }

    /**
     * This method make check-in of guest
     *
     * @param room Room object for check-in
     * @return boolean room has been check in or not
     * @throws IOException exception
     */
    public boolean checkIn(Room room) throws Exception {

        boolean flag=true;
        PrintWriter output = null;
        output = new PrintWriter(new FileWriter("src/files/CheckIn.csv", true));

        for(Room rooms: roomlist) {

            if(room.getGuest().equals(rooms.getGuest()) && (room.getRoomID() == (rooms.getRoomID()))) {

                flag=false;
                PrintWriter output1 = null;
                output1 = new PrintWriter(new FileWriter("src/files/ReservedRooms.csv"));

                checkinlist.add(rooms);
                output.printf("%s;%d;%d;%d;%s\n", rooms.getGuest(), rooms.getRoomID(), rooms.getRoomSize(), rooms.getDays(), room.getPrice());
                output.close();

                roomlist.remove(rooms);
                for (int i = 0; i < roomlist.size(); i++) {
                    Room nbook = roomlist.get(i);
                    output1.printf("%s;%d;%d;%d;%s\n", nbook.getGuest(),nbook.getRoomID(), nbook.getRoomSize(),
                            nbook.getDays(), nbook.getPrice());
                }
                System.out.println("Check-in done...You can go to your room...Good Days!\n");
                output1.close();
                updateRoomData();
                return true;
            }
        }
        if(flag==true)
            System.out.println("This room not reserved by you!\n");

        output.close();
        return false;
    }

    /**
     * This method take username of guest and find the guest has how many check in
     *
     * @param username username of guest
     * @return count of check in of user
     */
    public int countCheckIn(String username){

        int count=0;
        for(int i=0; i<checkinlist.size(); ++i){

            if(checkinlist.get(i).getGuest().equals(username)) {

                ++count;
                System.out.println("Room " + checkinlist.get(i).getRoomID());
            }
        }
        return count;
    }
    /**
     * This method make check-out the user can check-out or not
     *
     * @param room username of guest
     * @return boolean room has been check out or not
     * @throws IOException exception
     */

    public boolean checkOut(Room room) throws IOException {

        int flag=0;

        for(Room rooms: checkinlist) {

            if(rooms.getGuest().equals(room.getGuest()) && (rooms.getRoomID() == room.getRoomID())) {
                flag=1;

                PrintWriter output = null;
                output = new PrintWriter(new FileWriter("src/files/CheckIn.csv"));

                System.out.println("You had check-out...Good Bye!...\n");

                checkinlist.remove(rooms);

                for (int i = 0; i < checkinlist.size(); i++) {
                    Room nbook = checkinlist.get(i);
                    output.printf("%s;%d;%d;%d;%s\n", nbook.getGuest(),nbook.getRoomID(),nbook.getRoomSize(),
                            nbook.getDays(), nbook.getPrice());
                }
                output.close();
                return true;
            }
        }
        if(flag == 0) {
            System.out.println("You have not any check-in!\n");
        }
        return false;
    }

    /**
     * This method print the menu for user register
     *
     * @return new Guest object
     * @throws IOException exception
     */
    public Guest printUserInfo() throws IOException {
        Scanner in = new Scanner(System.in);

        System.out.print("Name: ");
        String name = in.next();
        System.out.print("Surname: ");
        String surname = in.next();
        System.out.print("Username: ");
        String username = in.next();
        System.out.print("Password: ");
        String password = in.next();

        Guest newu = new Guest(name, surname, username, password);

        return newu;
    }
    /**
     * This method search user in system
     *
     * @param username username of user
     * @param password password of user
     * @return User is registered in system
     * @throws Exception exception
     */
    public UserInterface searchUser(String username, String password) throws Exception {

        for (int i = 0; i < userlist.size(); i++) {
            String temp = userlist.get(i).getUsername();
            String temp2 = userlist.get(i).getPassword();
            if (temp.equals(username) && temp2.equals(password)) {
                return userlist.get(i);

            }
        }
        return null;
    }

    /**
     * This method search user in system
     *
     * @param username username of user
     * @return User is registered in system
     * @throws Exception exception
     */
    public UserInterface searchUser(String username) throws Exception {

        for (int i = 0; i < userlist.size(); i++) {
            String temp = userlist.get(i).getUsername();

            if (temp.equals(username)) {
                return userlist.get(i);

            }
        }
        return null;
    }

    /**
     * This method write to SystemRecords.log file records of system
     *
     * @param username username of user
     * @param jobTitle job name of user is done
     * @param date date of job is done
     * @throws IOException exception
     */
    public void writeRecords(String username, String jobTitle, String date) throws IOException {

        PrintWriter output = null;
        output = new PrintWriter(new FileWriter("src/files/SystemRecords.log", true));

        output.printf("%s - %s - %s\n", username, jobTitle, date);

        output.close();
    }

}