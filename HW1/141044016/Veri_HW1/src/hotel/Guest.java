package hotel;

/**
 * Created by yagmur on 23.02.2018.
 */
public class Guest extends User {

    /**
     * hotel.Guest Constructor
     *
     * @param name name of guest
     * @param surname surname of guest
     * @param username username of guest
     * @param password password of guest
     */
    public Guest(String name, String surname, String username, String password) {

        super(name,surname,username,password);
    }
    /**
     * hotel.Guest Constructor
     *
     * @param username username of guest
     * @param password password of guest
     */
    public Guest(String username, String password) {

        super(username,password);
    }

    /**
     * This method take record of system and send to hotel.User class
     *
     * @param record informations for write to log file
     */
    public Guest(String record) {

        super(record);
    }
    /**
     * This method take and choice and return the price this choice
     *
     * @param choice choice of order
     * @return price of order
     */
    public int eatSomething(String choice) {

        if(choice.equals("1")) {
            return 15;
        } else if(choice.equals("2")) {
            return 10;
        } else if(choice.equals("3")) {
            return 5;
        } else if(choice.equals("4")) {
            return 20;
        } else if(choice.equals("5")) {
            return 10;
        } else { System.out.println("This choice is not valid!"); return 0; }

    }

    /**
     * This method take username of guest and check the guest is check-in or not
     *
     * @param username username of guest
     * @return boolean the guest is check-in or not
     */
    public boolean controlEat(String username) {

        for(Room rooms: User.checkinlist) {

            if(rooms.getGuest().equals(username)) {
                return true;
            }
        }
        return false;
    }
}

