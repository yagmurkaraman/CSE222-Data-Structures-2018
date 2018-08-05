package test;

import hotel.Guest;
import hotel.Receptionist;
import hotel.Room;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by yagmur on 05.03.2018.
 */
public class UserTest {

    String Name = "nameTest";
    String Surname= "surnameTest";
    String Username = "usernameTest";
    String Password= "passwordTest";
    String Rusername = "admin";
    String Rpassword = "1";
    int roomID = 300;

    Guest guest = new Guest(Name, Surname, Username, Password);
    Receptionist receptionist = new Receptionist(Rusername, Rpassword);
    Room room = new Room(guest.getUsername(), roomID);
    Room room4 = new Room(guest.getUsername(), roomID+3);

    @Test
    public void roomReservation() throws Exception {
        Assert.assertEquals(true, guest.roomReservation(room));
        Assert.assertEquals(true, receptionist.roomReservation(room4));
        receptionist.updateRoomData();
    }
    @Test
    public void countReserve() throws Exception {
        Guest guest = new Guest(Name, Surname, Username, Password);
        Room room2 = new Room(guest.getUsername(), roomID+1);
        Room room3 = new Room(guest.getUsername(), roomID+2);
        guest.roomReservation(room2);
        guest.roomReservation(room3);
        Assert.assertEquals(2, receptionist.countReserve(guest.getUsername()));
    }
    @Test
    public void cancelReserve() throws Exception {
        Assert.assertEquals(false, guest.cancelReserve(room));
    }
}