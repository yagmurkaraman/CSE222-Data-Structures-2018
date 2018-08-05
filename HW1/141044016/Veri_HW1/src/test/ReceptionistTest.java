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
public class ReceptionistTest {

    String Name = "nameTest";
    String Surname= "surnameTest";
    String Username = "usernameTest";
    String Password= "passwordTest";
    String Rusername = "admin";
    String Rpassword = "1";
    int roomID = 400;

    Receptionist receptionist = new Receptionist(Rusername, Rpassword);
    Guest guest = new Guest(Name, Surname, Username, Password);
    Room room = new Room(guest.getUsername(), roomID);
    Room room2 = new Room(guest.getUsername(), roomID+1);

    @Test
    public void addUser() throws Exception {
        Assert.assertEquals(true, receptionist.addUser(guest));
        receptionist.roomReservation(room); // checkIn methodunun true donmesi icin reservation ekledim.
    }
    @Test
    public void checkIn() throws Exception {
        Assert.assertEquals(true, receptionist.checkIn(room));
        // room2 icin reservation yapılmadigindan checkIn false doner.
        Assert.assertEquals(false, receptionist.checkIn(room2));
    }
    @Test
    public void checkOut() throws Exception {
        Assert.assertEquals(true, receptionist.checkOut(room));
    }
    @Test
    public void updateRoomData() throws Exception {
        Assert.assertEquals(true, receptionist.updateRoomData());
    }
    @Test
    public void updateCheckInData() throws Exception {
        Assert.assertEquals(true, receptionist.updateCheckInData());
    }
    @Test
    public void updateUserData() throws Exception {
        Assert.assertEquals(true, receptionist.updateUserData());
    }
}