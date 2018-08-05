import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yagmur on 27.03.2018.
 */
class Part1_GTUCSECourseTest {

    Part1_GTUCSECourse part1 = new Part1_GTUCSECourse();
    Course course = new Course(1,"CSE 555","Proje",2,1,"2+0+0");
    Course course1 = new Course(1,"CSE 556","Proje",2,1,"2+0+0");
    Course course2 = new Course(3,"CSE 557","Proje",2,1,"2+0+0");
    Course course3 = new Course(4,"CSE 558","Proje",2,1,"2+0+0");

    LinkedList<Course> courselist = new LinkedList<>();
    LinkedList<Course> semesterlist = new LinkedList<>();
    LinkedList<Course> rangelist = new LinkedList<>();

    @Test
    void add() {
        assertEquals(course, part1.add(course));
        assertEquals(course1, part1.add(course1));
        assertEquals(course2, part1.add(course2));
        assertEquals(course3, part1.add(course3));
    }
    @Test
    void getByCode() throws NoSuchFieldException {

        LinkedList<Course> codelist = new LinkedList<>();

        courselist.add(course);
        courselist.add(course1);
        courselist.add(course2);
        courselist.add(course3);
        part1.setCourselist(courselist);

        codelist.add(course);
        System.out.println("getByCode");
        assertEquals(codelist, part1.getByCode("CSE 555"));
    }
    @Test
    void listSemesterCourses() throws NoSuchFieldException {

        LinkedList<Course> codelist = new LinkedList<>();

        semesterlist.add(course);
        semesterlist.add(course1);
        semesterlist.add(course2);
        semesterlist.add(course3);
        part1.setCourselist(semesterlist);

        codelist.add(course); // 1. semester
        codelist.add(course1); // 1. semester

        System.out.println("\nlistSemesterCourses");
        assertEquals(codelist, part1.listSemesterCourses(1));
    }
    @Test
    void getByRange() throws NoSuchFieldException {

        LinkedList<Course> codelist = new LinkedList<>();

        rangelist.add(course);
        rangelist.add(course1);
        rangelist.add(course2);
        rangelist.add(course3);
        part1.setCourselist(rangelist);

        codelist.add(course);
        codelist.add(course1);
        codelist.add(course2);

        System.out.println("\ngetByRange");
        assertEquals(codelist, part1.getByRange(0,2));
    }
}