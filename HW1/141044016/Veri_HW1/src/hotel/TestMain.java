package test;

import hotel.Guest;
import hotel.Receptionist;
import hotel.Room;

public class TestMain {

    public static void main(String[] args) throws Exception {

        System.out.println("*******************************");
        System.out.println("***  TEST FOR RECEPTIONIST  ***");
        System.out.println("*******************************");
        Receptionist receptionist = new Receptionist("admin", "1");

        // dosyadaki veriler okunur, arraylistler doldurulur.
        receptionist.updateUserData();
        receptionist.updateRoomData();
        receptionist.updateCheckInData();
        receptionist.getRecords();

        ///////////////////////// ADD GUEST
        System.out.println("ADD GUEST:");

        // Su an sistemde kayitli hic kimse yok
        Guest guest1 = new Guest("erdogan","sevilgen","esevilgen",  "123");
        Guest guest2 = new Guest("fatmanur","esirci","fesirci",  "111");
        Guest guest3 = new Guest("yagmur","karaman","ykaraman",  "123");
        Guest guest4 = new Guest("erdi","erkmen","eerkmen",  "123");
        Guest guest5 = new Guest("fatma","esirci","fesirci",  "123");

        // sistemdeki musterilerin konrolunu yaparken username bilgisini kullaniyorum, username hepsi icin unique
        // sisteme daha once kayitli username ile yeni kayit olusturulamaz
        // bunun testi icin de guest2 ve guest5 musterilerinin username iceriklerini ayni yaptim(fesirci)

        // esevilgen eklendi
        if(receptionist.searchUser(guest1.getUsername()) == null) // daha once bu username'e sahip bir kullanici
            receptionist.addUser(guest1);                  // olmadigi icin ekleme yapar.

        // fesirci eklendi
        if(receptionist.searchUser(guest2.getUsername()) == null)
            receptionist.addUser(guest2);

        // ykaraman eklendi
        if(receptionist.searchUser(guest3.getUsername()) == null)
            receptionist.addUser(guest3);

        // eerkmen eklendi
        if(receptionist.searchUser(guest4.getUsername()) == null)
            receptionist.addUser(guest4);

        // fesirci username'e sahip kullanici 2. adimda eklendigi icin tekrar eklenemez.
        if(receptionist.searchUser(guest5.getUsername()) != null)
            System.out.println(guest5.getUsername() + " is already added!");

        ///////////////////////// BOOK ROOM
        System.out.println("-------------------------");
        System.out.println("BOOK ROOM:");

        // constructor parametreleri sirayla;
        // Username, Room no, Odada kalacak kisi sayisi, Odada kac gun kalinacagi, Odanin reserve fiyati
        //
        Room room4 = new Room(guest4.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        Room room5 = new Room("ahmet", receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");



        // once searchUser(String username) methodu ile bu kullanici isimlerinin sisteme kayitli olup olmadigini
        // kontrol ettim. room4'te kullanilan guest4 onceden eklenmisti, ama room5'teki "ahmet" isimli username
        // eklenmemisti.

        Room room1 = new Room(guest1.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        //  bir musteri birden fazla oda reserve edebilir. guest1 -> room1 ve room6
        // esevilgen rezervasyon yapti guest1->room1
        if(receptionist.searchUser(guest1.getUsername()) != null) {
            receptionist.roomReservation(room1);
            System.out.println(guest1.getUsername() + ": Room " + room1.getRoomID() + " Reserve is added!");
        }
        //////////
        Room room6 = new Room(guest1.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        // esevilgen rezervasyon yapti guest1->room6
        if(receptionist.searchUser(guest1.getUsername()) != null) {
            receptionist.roomReservation(room6);
            System.out.println(guest1.getUsername() + ": Room " + room6.getRoomID() + " Reserve is added!");
        }
        ///////////
        Room room2 = new Room(guest2.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        // fesirci rezervasyon yapti guest2->room2
        if(receptionist.searchUser(guest2.getUsername()) != null) {
            receptionist.roomReservation(room2);
            System.out.println(guest2.getUsername() + ": Room " + room2.getRoomID() + " Reserve is added!");
        }
        ///////////
        Room room3 = new Room(guest3.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        // ykaraman rezervasyon yapti guest3->room3
        if(receptionist.searchUser(guest3.getUsername()) != null) {
            receptionist.roomReservation(room3);
            System.out.println(guest3.getUsername() + ": Room " + room3.getRoomID() + " Reserve is added!");
        }

        // ahmet sisteme kayitli olmadıgı icin rezervasyon yapamaz. if'e girmez
        if(receptionist.searchUser("ahmet") != null) {
            receptionist.roomReservation(room5);
            System.out.println(guest5.getUsername() + ": Room " + room5.getRoomID() + " Reserve is added!");
        }

        // ahmet sisteme kayitli olmadigi icin hata mesaji basar. if'e girer
        if((receptionist.searchUser("ahmet")) == null) {
            System.out.println("ahmet" + ": This username is not registered in system!");
        }
        ////////////////////////// CANCEL RESERVE
        System.out.println("-------------------------");
        System.out.println("CANCEL RESERVATION:");

        // guest1->esevilgen room1 ve room6 icin reservation yapmisti
        // o yuzden room1 icin rezervasyonu oldugundan iptal edebilir. if'e girer
        if(receptionist.searchUserReserve(guest1.getUsername())){
            receptionist.cancelReserve(room1);
            System.out.println(guest1.getUsername() + ": Room " + room1.getRoomID() + " Reservation canceled!");
        }
        // guest2->fesirci room2 icin reservation yapmisti
        // o yuzden room2 icin rezervasyonu oldugundan iptal edebilir. if'e girer
        if(receptionist.searchUserReserve(guest2.getUsername())){
            receptionist.cancelReserve(room2);
            System.out.println(guest2.getUsername() + ": Room " + room2.getRoomID() + " Reservation canceled!");
        }
        // guest4->eerkmen herhangi bir reservation yapmamisti, bunu test edebilmek icin
        // boyle bir kontrol yaptim ve if'e girdi, yani rezervasyon bulamadi
        if(!(receptionist.searchUserReserve(guest4.getUsername()))){
            System.out.println(guest4.getUsername() +": This username has not reservation!");        }

        /////////////////////// CHECK-IN
        System.out.println("-------------------------");
        System.out.println("CHECK-IN:");

        // guest1->esevilgen icin room1 rezervasyonunu az once iptal etmistik,
        // ama baska room6 icin rezervasyonu vardı, buyüzden ilk durum true geldi
        // checkIn methodu cagrildi ve bu odaya rezervasyonu olmadigi icin hata mesajı basti.
        if(receptionist.searchUserReserve(guest1.getUsername()) && receptionist.checkIn(room1)){
            System.out.println(guest1.getUsername() + ": Room " + room1.getRoomID() + " Reservation check-in!");
        }
        // guest3->ykaraman room3 icin rezervasyon yapmisti, bu yuzden check-in yapabildi
        if(receptionist.searchUserReserve(guest3.getUsername())  && receptionist.checkIn(room3)){
            System.out.println(guest3.getUsername() + ": Room " + room3.getRoomID() + " Reservation check-in!");
        }
        // guest4->eerkmen herhangi bir rezervasyon yapmamisti, bu yuzden ilk condition false geldi,
        // checkIn methodunu cagirmaya gerek kalmadi, if'e girmedi
        if(receptionist.searchUserReserve(guest4.getUsername())  && receptionist.checkIn(room4)){
            System.out.println(guest4.getUsername() + ": Room " + room4.getRoomID() + " Reservation check-in!");
        }
        // guest4->eerkmen herhangi bir reservation yapmamisti, bu yüzden ilk condition false geldi,
        // sonuc false oldu, ! isaretinden dolayi if'e girdi ve rezervasyonu olmadigi mesaji verildi.
        if(!(receptionist.searchUserReserve(guest4.getUsername())  && receptionist.checkIn(room4))){
            System.out.println(guest4.getUsername() + ": This username has not reservation for this room!");
        }
        //////////////////////////////////// CHECK-OUT

        System.out.println("-------------------------");
        System.out.println("CHECK-OUT:");

        // guest3->ykaraman az once room3 icin check-in yapmisti, bu yuzden check-out yapabilir
        // if'e girer
        if(receptionist.searchUserCheckIn(guest3.getUsername())) {
            receptionist.checkOut(room3);
            System.out.println(guest3.getUsername() + ": Room " + room3.getRoomID() + " Check-out is done!");
        }
        // guest2->fesirci icin room2 rezervasyonu cancel edilmisti, bu yuzden check-in yoktu, check-out yapamaz
        // if'e girmez
        if(receptionist.searchUserCheckIn(guest2.getUsername())) {
            receptionist.checkOut(room2);
            System.out.println(guest2.getUsername() + ": Room " + room2.getRoomID() + " Check-out is done!");
        }
        // guest4->eerkmen icin rezervasyon kaydi yoktu, bu yuzden check-in yapamadi, check-out yapamaz
        // if'e girmez
        if(receptionist.searchUserCheckIn(guest4.getUsername())) {
            receptionist.checkOut(room4);
            System.out.println(guest4.getUsername() + ": Room " + room4.getRoomID() + " Check-out is done!");
        }

        System.out.println("\n******************************");
        System.out.println("******  TEST FOR GUEST  ******");
        System.out.println("******************************");

        Guest guest0=new Guest("ayse","yilmaz","ayilmaz","123");

        // guest1->esevilgen username'e sahip musteri öncede eklenmisti, if'e girmez
        if(receptionist.searchUser(guest1.getUsername()) == null) {
            System.out.println(guest1.getUsername() + ": This username has not registered!");
        }
        // guest0->ayilmaz username'e sahip musteri öncede eklenmemisti
        // bu yuzden null doner, if'e girer
        if(receptionist.searchUser(guest0.getUsername()) == null) {
            System.out.println(guest0.getUsername() + ": This username has not registered!");
        }
        // guest2->fesirci username'e sahip musteri öncede eklenmisti, if'e girmez
        if(receptionist.searchUser(guest2.getUsername()) == null) {
            System.out.println(guest2.getUsername() + ": This username has not registered!");
        }
        // esevilgen username bulunur, if'e girer
        if(receptionist.searchUser(guest1.getUsername()) != null) {
            System.out.println("Welcome " + guest1.getUsername());
        }
        // ayilmaz username bulunamaz, if'e girmez
        if(receptionist.searchUser(guest0.getUsername()) != null) {
            System.out.println("Welcome " + guest0.getUsername());
        }
        // fesirci username bulunur, if'e girer
        if(receptionist.searchUser(guest2.getUsername()) != null) {
            System.out.println("Welcome " + guest2.getUsername());
        }

        // BOOK ROOM ve CANCEL RESERVATION icin yapilan testler yukarida Receptionist icin yapilan testlerle ayni.
        // Onlar dogru calistiysa bunlar da calisir.
        ///////////////////////// BOOK ROOM
        System.out.println("-------------------------");
        System.out.println("BOOK ROOM:");

        // constructor parametreleri sirayla;
        // Username, Room no, Odada kalacak kisi sayisi, Odada kac gun kalinacagi, Odanin reserve fiyati
        //
        room4 = new Room(guest4.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        room5 = new Room("ahmet", receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");


        // once searchUser(String username) methodu ile bu kullanici isimlerinin sisteme kayitli olup olmadigini
        // kontrol ettim. room4'te kullanilan guest4 onceden eklenmisti, ama room5'teki "ahmet" isimli username
        // eklenmemisti.

        room1 = new Room(guest1.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        //  bir musteri birden fazla oda reserve edebilir. guest1 -> room1 ve room6
        // esevilgen rezervasyon yapti guest1->room1
        if(receptionist.searchUser(guest1.getUsername()) != null) {
            receptionist.roomReservation(room1);
            System.out.println(guest1.getUsername() + ": Room " + room1.getRoomID() + " Reserve is added!");
        }
        //////////
        room6 = new Room(guest1.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        // esevilgen rezervasyon yapti guest1->room6
        if(receptionist.searchUser(guest1.getUsername()) != null) {
            receptionist.roomReservation(room6);
            System.out.println(guest1.getUsername() + ": Room " + room6.getRoomID() + " Reserve is added!");
        }
        ///////////
        room2 = new Room(guest2.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        // fesirci rezervasyon yapti guest2->room2
        if(receptionist.searchUser(guest2.getUsername()) != null) {
            receptionist.roomReservation(room2);
            System.out.println(guest2.getUsername() + ": Room " + room2.getRoomID() + " Reserve is added!");
        }
        ///////////
        room3 = new Room(guest3.getUsername(), receptionist.searchRoom(),
                2, 2, receptionist.getRoomPrice(2,2)+"$");

        // ykaraman rezervasyon yapti guest3->room3
        if(receptionist.searchUser(guest3.getUsername()) != null) {
            receptionist.roomReservation(room3);
            System.out.println(guest3.getUsername() + ": Room " + room3.getRoomID() + " Reserve is added!");
        }

        // ahmet sisteme kayitli olmadıgı icin rezervasyon yapamaz. if'e girmez
        if(receptionist.searchUser("ahmet") != null) {
            receptionist.roomReservation(room5);
            System.out.println(guest5.getUsername() + ": Room " + room5.getRoomID() + " Reserve is added!");
        }

        // ahmet sisteme kayitli olmadigi icin hata mesaji basar. if'e girer
        if((receptionist.searchUser("ahmet")) == null) {
            System.out.println("ahmet" + ": This username is not registered in system!");
        }
        ////////////////////////// CANCEL RESERVE
        System.out.println("-------------------------");
        System.out.println("CANCEL RESERVATION:");

        // guest1->esevilgen room1 ve room6 icin reservation yapmisti
        // o yuzden room1 icin rezervasyonu oldugundan iptal edebilir. if'e girer
        if(receptionist.searchUserReserve(guest1.getUsername())){
            receptionist.cancelReserve(room1);
            System.out.println(guest1.getUsername() + ": Room " + room1.getRoomID() + " Reservation canceled!");
        }
        // guest2->fesirci room2 icin reservation yapmisti
        // o yuzden room2 icin rezervasyonu oldugundan iptal edebilir. if'e girer
        if(receptionist.searchUserReserve(guest2.getUsername())){
            receptionist.cancelReserve(room2);
            System.out.println(guest2.getUsername() + ": Room " + room2.getRoomID() + " Reservation canceled!");
        }
        // guest4->eerkmen herhangi bir reservation yapmamisti, bunu test edebilmek icin
        // boyle bir kontrol yaptim ve if'e girdi, yani rezervasyon bulamadi
        if(!(receptionist.searchUserReserve(guest4.getUsername()))){
            System.out.println(guest4.getUsername() +": This username has not reservation!");        }

        ///////////////////////// ORDER SOMETHING
        System.out.println("-------------------------");
        System.out.println("ORDER SOMETHING:");

        // Order Something icin true sonuc veren ornek olsun diye bir adet check-in ekledim
        // guest1->esevilgen, room6 icin rezervasyonu vardi. check-in yaptim

        if(receptionist.searchUserReserve(guest1.getUsername()) && receptionist.checkIn(room6)){
            System.out.println(guest1.getUsername() + ": Room " + room6.getRoomID() + " Reservation check-in!");
        }
        System.out.println("-------------------------");

        // guest1->esevilgen check-in yaptigi icin siparis verebilir, if'e girer.
        if(guest1.controlEat(guest1.getUsername())) {
            guest1.eatSomething("1");
            System.out.println(guest1.getUsername() + ": This user eat something!");
        }
        // guest2->fesirci check-in sahibi olmadigi icin if'e girmez
        if(guest2.controlEat(guest2.getUsername())) {
            guest2.eatSomething("2");
            System.out.println(guest2.getUsername() + ": This user eat something!");
        }
        // guest2->fesirci check-in sahibi olmadigi icin ! isaretinden dolayi if'e girer
        // hata mesaji verir
        if(!guest2.controlEat(guest2.getUsername())) {
            System.out.println(guest2.getUsername() + ": This user has not check-in!");
        }
    }
}