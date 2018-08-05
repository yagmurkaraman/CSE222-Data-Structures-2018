import java.util.LinkedList;

/**
 * Created by yagmur on 21.03.2018.
 */
public class Part1_GTUCSECourse extends Course {

    protected static LinkedList<Course> courselist = new LinkedList<Course>();

    /**
     * Default constructor
     */
    public Part1_GTUCSECourse() {  }

    /**
     * Constructor
     *
     * @param semester semester number of course
     * @param courseCode code of course
     * @param courseTitle title of course
     * @param ectsCredit ects credit of course
     * @param gtuCredit gtu credit of course
     * @param htl htl of course
     */
    public Part1_GTUCSECourse(int semester, String courseCode, String courseTitle, int ectsCredit, int gtuCredit, String htl) {
        super(semester, courseCode, courseTitle, ectsCredit, gtuCredit, htl);
    }

    /**
     * This method sets the courselist
     *
     * @param courselist list of courses
     */
    public void setCourselist(LinkedList<Course> courselist) {
        this.courselist = courselist;
    }

    /**
     * This method add course to courselist
     *
     * @param course course for add
     * @return added course
     */
    public Course add(Course course) { courselist.add(course);
        return course;
    }

    /**
     * This method takes a course code and return the list of course with same codes
     *
     * @param code code of course
     * @return list of courses same code
     * @throws NoSuchFieldException Exception
     */
    public LinkedList<Course> getByCode(String code) throws NoSuchFieldException {

        LinkedList<Course> codeCourses = new LinkedList<Course>();

        for(int i=0; i<courselist.size(); ++i) {

            if(courselist.get(i).getCourseCode().equals(code))
                codeCourses.add(courselist.get(i));
        }
        if(codeCourses.size() == 0)
            System.out.println("This code is not in this list!");

        for(int i=0; i<codeCourses.size(); ++i) {

            System.out.println(codeCourses.get(i).getSemester() + " " + codeCourses.get(i).getCourseCode()
                    + " " + codeCourses.get(i).getCourseTitle() + " " +
                    codeCourses.get(i).getEctsCredit() + " " + codeCourses.get(i).getGtuCredit()
                    + " " + codeCourses.get(i).getHtl());
        }
        if(codeCourses.size() == 0) {
            throw new NoSuchFieldException();
        }
        return codeCourses;
    }

    /**
     * This method takes semester number and return list of course in same semester
     *
     * @param semester semester number of course
     * @return list of courses in same semester
     * @throws NoSuchFieldException  Exception
     */
    public LinkedList<Course> listSemesterCourses(int semester) throws NoSuchFieldException {

        LinkedList<Course> semesterCourses = new LinkedList<Course>();

        for(int i=0; i<courselist.size(); ++i) {

            if(courselist.get(i).getSemester() == semester)
                semesterCourses.add(courselist.get(i));
        }
        if(semesterCourses.size() == 0)
            System.out.println("This semester is not in this list!");

        for(int i=0; i<semesterCourses.size(); ++i) {

            System.out.println(semesterCourses.get(i).getSemester() + " " + semesterCourses.get(i).getCourseCode()
                    + " " + semesterCourses.get(i).getCourseTitle() + " " +
                    semesterCourses.get(i).getEctsCredit() + " " + semesterCourses.get(i).getGtuCredit()
                    + " " + semesterCourses.get(i).getHtl());
        }
        if(semesterCourses.size() == 0) {
            throw new NoSuchFieldException();
        }
        return semesterCourses;
    }

    /**
     * This method take start and last index of range, returns list of courses between given range
     *
     * @param start_index start index of range
     * @param last_index last index of range
     * @return list of courses in given range
     * @throws NoSuchFieldException  Exception
     */
    public LinkedList<Course> getByRange(int start_index, int last_index) throws NoSuchFieldException {

        LinkedList<Course> rangeCourses = new LinkedList<Course>();

        if(start_index<0 || last_index>=courselist.size()) {
            throw new IndexOutOfBoundsException();
        }
        for(int i=start_index; i<=last_index; ++i) {
            rangeCourses.add(courselist.get(i));
        }
        for(int i=0; i<rangeCourses.size(); ++i) {

            System.out.println(rangeCourses.get(i).getSemester() + " " + rangeCourses.get(i).getCourseCode()
                    + " " + rangeCourses.get(i).getCourseTitle() + " " +
                    rangeCourses.get(i).getEctsCredit() + " " + rangeCourses.get(i).getGtuCredit()
                    + " " + rangeCourses.get(i).getHtl());
        }
        if(rangeCourses.size() == 0) {
            throw new NoSuchFieldException();
        }
        return rangeCourses;
    }

    /**
     * This method return size of courselist
     *
     * @return size of list
     */
    public int size() { return courselist.size(); }

    /**
     * This method override method of toString for course
     *
     * @return string of message
     */
    @Override
    public String toString() {
        return getSemester() + " " + getCourseCode() + " " + getCourseTitle() + " " +
            getEctsCredit() + " " + getGtuCredit() + " " + getHtl();
    }
}