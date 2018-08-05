import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

/**
 * Created by yagmur on 21.03.2018.
 */
public class MainTest {

    public static void main(String[] args) throws Exception {

        Part1_GTUCSECourse system1 = new Part1_GTUCSECourse(); // part1 objesi
        Part2_DisableEnable system2 = new Part2_DisableEnable(); // part2 objesi
        Part3_SemesterRelations system3 = new Part3_SemesterRelations(); // part3 objesi
        LinkedList<Course> parameterList = new LinkedList(); // methodlara parametre gonderip test edebilmek icin main'de olusturdum.

        String DELIMITER = ";";
        BufferedReader filescan = null;
        filescan = new BufferedReader(new FileReader("src/Courses(CSV)(Updated).csv"));
        Course course;

        String line = "";
        filescan.readLine();
        while ((line = filescan.readLine()) != null) {

            String seperated[] = line.split(DELIMITER);

            course = new Course(Integer.parseInt(seperated[0]), seperated[1], seperated[2],
                    Integer.parseInt(seperated[3]), Integer.parseInt(seperated[4]), seperated[5]);

            system1.add(course); // part1
            system2.add(course); // part2
            system3.add(course); // part3
            parameterList.add(course); // main listesi, test icin
        }
        filescan.close();
        /*******************PART 1******************/
        System.out.println("******************************************************************");
        System.out.println("***********    PART 1          PART 1        PART 1    ***********");
        System.out.println("******************************************************************");
        System.out.println("\n.........Test of getByCode......");
        System.out.println("getByCode(XXX XXX):"); // XXX XXX toplam 9 tane var.
        system1.getByCode("XXX XXX");
/*
        System.out.println("getByCode(CSE 545):"); // boyle bir code yok, excetion fırlatır.
        system1.getByCode("CSE 545");              // programın bitmemesi icin yoruma aldım.
*/
        System.out.println("\ngetByCode(CSE 241):"); // CSE 241 sadece 1 tane var.
        system1.getByCode("CSE 241");
        /*
        System.out.println("\ngetByCode(CSE 333):"); // CSE 333 kodlu bir course yok. exception fırlatır.
        system1.getByCode("CSE 333");*/              // programın kapanmaması icin yoruma aldım

        System.out.println("\n.....Test of listSemesterCourses.......");
        System.out.println("listSemesterCourses(3): ");
        system1.listSemesterCourses(3); // 3. semesterda olan courseları print eder.

        System.out.println("\nlistSemesterCourses(6): ");
        system1.listSemesterCourses(6); // 6. semesterda olan courseları print eder.
/*
        System.out.println("\nlistSemesterCourses(10): "); // 10. semester yok, exception fırlatır.
        system1.listSemesterCourses(10);                   // programın kapanmaması icin yoruma aldım
*/
        System.out.println("\n.........getByRange...........");
        System.out.println("getByRange(2,6): ");
        system1.getByRange(2,6); // 2 ile 6 index arasındaki courseları print eder.

        System.out.println("\ngetByRange(37,37): ");
        system1.getByRange(37,37); // 37. indexteki course'u print eder.
/*
        System.out.println("\ngetByRange(48,size()+3): "); // indexler invalid oldugu icin exception fırlatır.
        system1.getByRange(48,system1.size()+3);           // programın kapanmaması icin yoruma aldım

        /******************PART 2*******************/
        System.out.println("\n******************************************************************");
        System.out.println("***********    PART 2          PART 2        PART 2    ***********");
        System.out.println("******************************************************************");
        //system2.printList();
        System.out.println(".......Test disable......");
        //system2.printList(); // onceki

        // Dosyadan okunan tüm veriler class icindeki mylist isimli listede bulunmaktadır.
        // Disable olan elemanları listeden silmedim. size() methodu gibi bazı işlemlerin daha kolay
        // olması icin disables isimli linkedlist tuttum ve disable olan elemanları oraya da ekledim.
        // mylist'in size() methodunu override ettim, sadece enable olan verilerin size'ını döndürür.
        System.out.println("Size(onceki): " + system2.size()); // sizeof mylist
        System.out.println("2. Index Disable: " + system2.toString(system2.disable(parameterList.get(2))));
        System.out.println("3. Index Disable: " + system2.toString(system2.disable(parameterList.get(3))));
        System.out.println("4. Index Disable: " + system2.toString(system2.disable(parameterList.get(4))));
        System.out.println("5. Index Disable: " + system2.toString(system2.disable(parameterList.get(5))));
        System.out.println("8. Index Disable: " + system2.toString(system2.disable(parameterList.get(8))));
        System.out.println("34. Index Disable: " + system2.toString(system2.disable(parameterList.get(34))));
        System.out.println("35. Index Disable: " + system2.toString(system2.disable(parameterList.get(35))));
        System.out.println("Son Eleman Disable: " + system2.toString(system2.disable(parameterList.get(parameterList.size()-1))));
        System.out.println("Toplam " + system2.getDisables().size() + " eleman disable oldu.");
        System.out.println("Size(sonraki): " + system2.size()); // size of mylist

        System.out.println("\n.....Test showDisabled.....");
        system2.showDisabled();

        System.out.println("\n.....Test enable.....");
        System.out.println("3. Index Enable: " + system2.toString(system2.enable(parameterList.get(3))));
        System.out.println("4. Index Enable: " + system2.toString(system2.enable(parameterList.get(4))));
        // 14. indexteki elemanı yukarıda disable yapmadık. Bu yüzden hala enable. Null döndürür.
        System.out.println("14. Index Enable: " + system2.toString(system2.enable(parameterList.get(14))));
        System.out.println("Size after enable: " + system2.size());

        System.out.println("\n.....showDisabled.....");
        system2.showDisabled(); // yukarıda 2 tane disable elemanı enable yaptık.
                                // bu elemanlar disables listinden silinir.

        // disable elemanlar üzerinde get, set, size, remove ve listIterator methodlarını soyutlamam gerekli.
        System.out.println("\n.....Test get.....");
        System.out.println("2. Index get: " + system2.toString(system2.get(2))); // 2. index disable oldugundan 3. index dondurur
        System.out.println("34. Index get: " + system2.toString(system2.get(34))); // 34. ve 35. index disable oldugundan 36. index dondurur
        System.out.println("24. Index get: " + system2.toString(system2.get(24))); // 24. index enable oldugu icin sorun yok.

        System.out.println("\n.....showDisabled.....");
        system2.showDisabled();

        System.out.println("\n.....Test set.....");
        // 5. index disable oldugu icin 6. indexi döndürür.
        System.out.println("5. Index set: " + system2.toString(system2.set(5, parameterList.get(9))));
        // 8. index disable oldugu icin 9. indexi döndürür.
        System.out.println("8. Index set: " + system2.toString(system2.set(8, parameterList.get(32))));

        System.out.println("\n.....showDisabled.....");
        system2.showDisabled();

        System.out.println("\n.....Test remove.....");
        System.out.println("Size before remove: " + system2.size());
        System.out.println("5. Index remove: " + system2.toString(system2.remove(5))); // 5. index disable oldugundan 6. index silinir
        System.out.println("7. Index remove: " + system2.toString(system2.remove(7))); // 7. index enable oldugundan silinir
        System.out.println("Size after remove: " + system2.size());

        System.out.println("\n.....showDisabled.....");
        system2.showDisabled();

        System.out.println("\n.....Test listIterator.....");
        system2.listIterator(0).hasNext();
        system2.listIterator(system2.size()-2).hasNext();
        System.out.println("......next().....");
        System.out.println("2. index: " + system2.toString(parameterList.get(2)));
        System.out.println("2. index için next(): " + system2.toString((Course) system2.listIterator(2).next()));

        System.out.println("\n......hasNext().....");
        System.out.println("0. index: " + system2.toString(system2.get(0)));
        System.out.println("0. index için hasNext(): " + system2.toString((Course) system2.listIterator(0).next()));

        System.out.println("\n......hasPrevious().....");
        System.out.println("0. index: " + system2.toString(system2.get(0)));
        System.out.println("0. index için hasNext(): " + system2.listIterator(0).hasPrevious());

        System.out.println("\n......previous().....");
        System.out.println("3. index: " + system2.toString(system2.get(3)));
        // 2. index disable oldugu icin 1. index print edilir
        System.out.println("3. index için previous(): " + system2.toString((Course) system2.listIterator(3).previous()));

        System.out.println("\n......nextIndex().....");
        System.out.println("1. index: " + system2.toString(system2.get(1)));
        // 2. index disable oldugu icin 3 print edilir
        System.out.println("1. index için nextIndex(): " + system2.listIterator(1).nextIndex());

        System.out.println("\n......previousIndex().....");
        System.out.println("3. index: " + system2.toString(system2.get(3)));
        // 2. index disable oldugu icin 1. index print edilir
        System.out.println("3. index için previousIndex(): " + system2.listIterator(3).previousIndex());

        System.out.println("\nremove, set ve get methodları void olduğu için test edip gösteremedim, " +
                "class içindeki implementine bakabilirsiniz.");

        /******************PART 3*******************/
        System.out.println("\n******************************************************************");
        System.out.println("***********    PART 3          PART 3        PART 3    ***********");
        System.out.println("******************************************************************");
        course = new Course(1,"a","b",2,3,"c");

        System.out.println(".....Test add.......");
        System.out.println("Size before add: " + system3.size());

        System.out.println("Add: " + system3.toString(system3.add(parameterList.get(5))));
        System.out.println("Add: " + system3.toString(system3.add(course)));
        System.out.println("Size after add: " + system3.size());

        System.out.println("\n.....Test remove.......");
        System.out.println("Remove: " + system3.toString(system3.remove(parameterList.get(1))));
        System.out.println("Remove: " + system3.toString(system3.remove(parameterList.get(2))));
        System.out.println("Remove: " + system3.toString(system3.remove(parameterList.get(5))));
        System.out.println("Size after remove: " + system3.size());

        //system3.printList();
        System.out.println("\n.....Test next.......");
        System.out.println("current1: " + system3.toString(parameterList.get(10)));
        System.out.println("next1: " + system3.toString(system3.next(parameterList.get(10))));
        System.out.print("\n");
        System.out.println("current2: " + system3.toString(parameterList.get(system3.size())));
        System.out.println("next2: " + system3.toString(system3.next(parameterList.get(system3.size()))));
        System.out.print("\n");
        System.out.println("current3: " + system3.toString(parameterList.get(12)));
        System.out.println("next3: " + system3.toString(system3.next(parameterList.get(12))));


        System.out.println("\n.....Test nextInSemester.......");
        System.out.println("currentSemester: " + system3.toString(parameterList.get(system3.size() -1)));
        System.out.println("nextInSemester: " + system3.toString(system3.nextInSemester(parameterList.get(system3.size() -1))));
        System.out.print("\n");
        System.out.println("currentSemester: " + system3.toString(parameterList.get(4)));
        System.out.println("nextInSemester: " +system3.toString(system3.nextInSemester(parameterList.get(4))));
        System.out.print("\n");
        System.out.println("currentSemester: " + system3.toString(parameterList.get(12)));
        System.out.println("nextInSemester: " +system3.toString(system3.nextInSemester(parameterList.get(12))));
    }
}