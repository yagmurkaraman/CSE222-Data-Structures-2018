package Q1;

/**
 * Created by yagmur on 03.05.2018.
 */
public class MainTest {
    public static void main(String args[]) throws Exception {

        HashtableOpen hashtableOpen = new HashtableOpen();

        hashtableOpen.put(0, 13);
        hashtableOpen.put("Erdi", "Yagmur");
        hashtableOpen.put(12.5, 3.7);
        hashtableOpen.put("a", "b");
        hashtableOpen.put(10, 56);
        hashtableOpen.put("z", "22");
        hashtableOpen.put(14, 4);
        hashtableOpen.put(5, 4);
        hashtableOpen.put(60, "Erdogan");
        hashtableOpen.put("cse222", "hw5");
        hashtableOpen.put(8, "c");
        hashtableOpen.put(9, 565);
        hashtableOpen.put(11, 565);
        hashtableOpen.put(12, 565);
        hashtableOpen.put(13, 565);
        hashtableOpen.put(14, 565);
        System.out.println("---------------------------");
        System.out.println("     AFTER PUT PAIRS");
        System.out.println("---------------------------");
        hashtableOpen.printTable();

        System.out.println("---------------------------");
        System.out.println("     AFTER REMOVE PAIRS");
        System.out.println("---------------------------");
        hashtableOpen.remove(0);
        hashtableOpen.remove("cse222");
        System.out.print("\n");
        hashtableOpen.printTable();

        System.out.println("\nNew Hash Table!\n");
        HashtableOpen hashtableOpen2 = new HashtableOpen();
        hashtableOpen2.put(12,1);
        hashtableOpen2.put("a",1);
        hashtableOpen2.put("b",1);
        hashtableOpen2.put("abc",1);
        hashtableOpen2.put("y",1);
        hashtableOpen2.put("yagmur",1);
        hashtableOpen2.put(6,1);
        hashtableOpen2.put(7,1);
        hashtableOpen2.put("www",1);
        hashtableOpen2.put("cse",1);
        hashtableOpen2.put(10,1);
        hashtableOpen2.put("asasa",12);
        hashtableOpen2.put("q",1);
        hashtableOpen2.put("qq",1);
        hashtableOpen2.put("qw",1);
        hashtableOpen2.put("qe",1);
        hashtableOpen2.put("qt",15);
        hashtableOpen2.put("rr",10);
        System.out.println("---------------------------");
        System.out.println("     AFTER PUT PAIRS");
        System.out.println("---------------------------");
        hashtableOpen2.printTable();


    }
}
