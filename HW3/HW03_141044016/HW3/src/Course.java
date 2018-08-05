/**
 * Created by yagmur on 21.03.2018.
 */
public class Course {

    private int semester;
    private String courseCode;
    private String courseTitle;
    private int ectsCredit;
    private int gtuCredit;
    private String htl;
    private boolean enable;

    public Course() {}
    public Course(int semester, String courseCode, String courseTitle, int ectsCredit, int gtuCredit,
                  String htl) {

        this.semester = semester;
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.ectsCredit = ectsCredit;
        this.gtuCredit = gtuCredit;
        this.htl = htl;
        this.enable = true;
    }
    public int getSemester() {
        return semester;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public String getCourseTitle() {
        return courseTitle;
    }
    public int getEctsCredit() {
        return ectsCredit;
    }
    public int getGtuCredit() {
        return gtuCredit;
    }
    public String getHtl() {
        return htl;
    }
    public boolean getEnable() { return enable; }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
    public void setEctsCredit(int ectsCredit) {
        this.ectsCredit = ectsCredit;
    }
    public void setGtuCredit(int gtuCredit) {
        this.gtuCredit = gtuCredit;
    }
    public void setHtl(String htl) {
        this.htl = htl;
    }
    public void setEnable(boolean enable) {
        this.enable = enable;
    }

}
