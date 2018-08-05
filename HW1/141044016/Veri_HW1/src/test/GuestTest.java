package test;

import hotel.Receptionist;
import hotel.Room;
import org.junit.Assert;
import org.junit.Test;
import hotel.Guest;

/**
 * Created by yagmur on 05.03.2018.
 */
public class GuestTest {

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

    @Test
    public void roomReservation() throws Exception {
        Assert.assertEquals(true, guest.roomReservation(room));
        Assert.assertEquals(true, guest.roomReservation(room));
        receptionist.checkIn(room); // controlEat methodunun true donmesi icin check-in yapilmasi gerekir.
                                    // bu yuzden checkIn methodunu cagirdim
    }
    @Test
    public void controlEat() throws Exception {
        Assert.assertEquals(true, guest.controlEat(guest.getUsername()));
    }
    @Test
    public void eatSomething() throws Exception {
        Assert.assertEquals(15, guest.eatSomething("1"));
        Assert.assertEquals(10, guest.eatSomething("2"));
        Assert.assertEquals(5, guest.eatSomething("3"));
        Assert.assertEquals(20, guest.eatSomething("4"));
        Assert.assertEquals(10, guest.eatSomething("5"));
    }
}