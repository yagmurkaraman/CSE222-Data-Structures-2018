import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yagmur on 28.03.2018.
 */
class Part3_SemesterRelationsTest {

    Part3_SemesterRelations part3 = new Part3_SemesterRelations();
    Course course = new Course(1,"CSE 555","Proje",2,1,"2+0+0");
    Course course1 = new Course(1,"CSE 556","Proje",2,1,"2+0+0");
    Course course2 = new Course(3,"CSE 557","Proje",2,1,"2+0+0");
    Course course3 = new Course(4,"CSE 558","Proje",2,1,"2+0+0");

    @Test
    void add() {
        assertEquals(course, part3.add(course));
        assertEquals(course1, part3.add(course1));
        assertEquals(course2, part3.add(course2));
        assertEquals(course3, part3.add(course3));
    }
    @Test
    void next() {

        add();
        assertEquals(course1, part3.next(course));
        assertEquals(course2, part3.next(course1));
        assertEquals(course3, part3.next(course2));
    }

    @Test
    void nextInSemester() {
        add();
        assertEquals(course1, part3.nextInSemester(course));
        assertEquals(course, part3.nextInSemester(course1));
    }
    @Test
    void remove() {
        add();
        assertEquals(course, part3.remove(course));
    }
    @Test
    void size() {
        add();
        assertEquals(4, part3.size());
    }

}