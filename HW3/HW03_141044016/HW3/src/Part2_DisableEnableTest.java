import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by yagmur on 27.03.2018.
 */
class Part2_DisableEnableTest {

    Part2_DisableEnable part2 = new Part2_DisableEnable();
    Course course = new Course(1,"CSE 555","Proje",2,1,"2+0+0");
    Course course1 = new Course(1,"CSE 556","Proje",2,1,"2+0+0");
    Course course2 = new Course(3,"CSE 557","Proje",2,1,"2+0+0");
    Course course3 = new Course(4,"CSE 558","Proje",2,1,"2+0+0");

    LinkedList<Course> list = new LinkedList<>();
    LinkedList<Course> disables = new LinkedList<>();

    @Test
    void disable() {

        list.add(course);
        list.add(course1);
        list.add(course2);
        list.add(course3);
        part2.setMylist(list);

        assertEquals(course, part2.disable(course));
        assertEquals(null, part2.disable(course)); // tekrar disable edilirse null döner.
    }
    @Test
    void enable() {

        list.add(course);
        list.add(course1);
        list.add(course2);
        list.add(course3);
        part2.setMylist(list);

        part2.disable(course);
        part2.disable(course1);

        assertEquals(course, part2.enable(course));
        assertEquals(null, part2.enable(course3)); // course3 zaten enable
    }
    @Test
    void showDisabled() {

        list.add(course);
        list.add(course1);
        list.add(course2);
        list.add(course3);
        part2.setMylist(list);

        part2.disable(course);
        part2.disable(course1);

        assertEquals(true, part2.showDisabled());

    }
    @Test
    void size() {

        list.add(course);
        list.add(course1);
        list.add(course2);
        list.add(course3);
        part2.setMylist(list);

        assertEquals(4, part2.size());

        part2.disable(course);
        part2.disable(course1);

        assertEquals(2, part2.size());
    }
    @Test
    void get() {

        list.add(course);   // 0
        list.add(course1);  // 1
        list.add(course2);  // 2
        list.add(course3);  // 3
        part2.setMylist(list);
        part2.disable(course);  // 0 disable
        part2.disable(course1); // 1 disable

        assertEquals(course2, part2.get(0)); // 0 disable, 2. index döner
    }
    @Test
    void set() {

        list.add(course);   // 0
        list.add(course1);  // 1
        list.add(course2);  // 2
        list.add(course3);  // 3
        part2.setMylist(list);
        part2.disable(course);  // 0 disable
        part2.disable(course1); // 1 disable

        assertEquals(course2, part2.set(0, course2));
    }
    @Test
    void remove() {

        list.add(course);   // 0
        list.add(course1);  // 1
        list.add(course2);  // 2
        list.add(course3);  // 3
        part2.setMylist(list);
        part2.disable(course);  // 0 disable
        part2.disable(course1); // 1 disable

        assertEquals(course2, part2.remove(0));
    }
    @Test
    void remove1() {

        list.add(course);   // 0
        list.add(course1);  // 1
        list.add(course2);  // 2
        list.add(course3);  // 3
        part2.setMylist(list);
        part2.disable(course);  // 0 disable
        part2.disable(course1); // 1 disable

        assertEquals(course2, part2.remove());

    }
    @Test
    void remove2() {

        list.add(course);   // 0
        list.add(course1);  // 1
        list.add(course2);  // 2
        list.add(course3);  // 3
        part2.setMylist(list);
        part2.disable(course);  // 0 disable
        part2.disable(course1); // 1 disable

        assertEquals(false, part2.remove(course));
        assertEquals(true, part2.remove(course2));
    }
    @Test
    void listIterator() {

        list.add(course);   // 0
        list.add(course1);  // 1
        list.add(course2);  // 2
        list.add(course3);  // 3
        part2.setMylist(list);
        part2.disable(course);  // 0 disable
        part2.disable(course1); // 1 disable

        assertEquals(true, part2.listIterator(0).hasNext());
        assertEquals(course2, part2.listIterator(0).next());
        assertEquals(true, part2.listIterator(3).hasPrevious());
        assertEquals(course2, part2.listIterator(3).previous());
        assertEquals(2, part2.listIterator(0).nextIndex());
        assertEquals(2, part2.listIterator(3).previousIndex());



    }
}