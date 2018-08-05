import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by yagmur on 21.03.2018.
 */
public class Part2_DisableEnable extends LinkedList {

    private LinkedList<Course> mylist = new LinkedList();
    private LinkedList<Course> disables = new LinkedList(); // showDisabled icin tutuldu.
    /**
     * This method add new course to list
     *
     * @param course new course
     */
    public void add(Course course) { mylist.add(course); }

    /**
     * This method make disable the item if it is enable and return
     *
     * @param item course for disable
     * @return disable course
     */
    public Course disable(Course item) {

        if(item.getEnable()) {
            item.setEnable(false);
            disables.add(item);
            return item;
        }
        return null;
    }
    /**
     * This method make enable the item if it is disable and return
     *
     * @param item course for enable
     * @return enable course
     */
    public Course enable(Course item) {

        if(!item.getEnable()) {
            item.setEnable(true);
            disables.remove(item);
            return item;
        }
        return null;
    }

    /**
     * This method prints the disable items
     *
     * @return true if list is not empty
     */
    public boolean showDisabled() {

        if(disables.size() == 0) {
            System.out.println("There are no any disabled items!");
            return false;
        }
        for(int i=0; i<mylist.size(); ++i) {
            if(mylist.get(i) != null) {
                if(!mylist.get(i).getEnable())  {
                    System.out.println(i + ". Index: " + mylist.get(i).getSemester() + " " + mylist.get(i).getCourseCode()
                            + " " + mylist.get(i).getCourseTitle() + " " +
                            mylist.get(i).getEctsCredit() + " " + mylist.get(i).getGtuCredit()
                            + " " + mylist.get(i).getHtl());
                }
            }
        }
        return true;
    }

    /**
     * This method take index of course and return its iterator
     * @param index index of course
     * @return listIterator of course
     */
    @Override
    public ListIterator listIterator(int index) {
        ListIterator myIter = new ListIterator() {

            /**
             * This method checks the course has next or not
             * @return boolean course has next or not
             */
            @Override
            public boolean hasNext() {

                if(index<0 || index>=size())
                    throw new IndexOutOfBoundsException();

                else if(index < size()) {
                    return true;
                }
                return  false;
            }

            /**
             * This method checks the course has next or not, if has next then return the next course
             * @return next course of given index
             */
            @Override
            public Object next() {

                if(index<0 || index>=size())
                    throw new IndexOutOfBoundsException();

                for(int i=index+1; i<mylist.size(); ++i) {
                    if(mylist.get(i).getEnable()) {
                        return mylist.get(i);
                    }
                }
                return null;
            }

            /**
             * This method checks the course has previous, if has return true, if not return false
             * @return boolean of course has previous or not
             */
            @Override
            public boolean hasPrevious() {

                if(index<0 || index>=mylist.size())
                    throw new IndexOutOfBoundsException();

                else if(index == 0) {
                    return false;
                }
                else
                    return true;
            }

            /**
             * This method checks the course has previous, if has return previous course
             * @return previous course of given course
             */
            @Override
            public Object previous() {

                if(index<0 || index>=mylist.size())
                    throw new IndexOutOfBoundsException();

                else if(index == 0) {
                    return null;
                }
                else {
                    for(int i=index-1; i>=0; --i) {
                        if(mylist.get(i).getEnable()) {
                            return mylist.get(i);
                        }
                    }
                }
                return null;
            }

            /**
             * This method checks the index is has next or not
             * @return next index
             */
            @Override
            public int nextIndex() {

                if(index<0 || index>=size())
                    throw new IndexOutOfBoundsException();

                else if(index == size()-1)
                    return 0;

                else {
                    for(int i=index+1; i<mylist.size(); ++i) {
                        if(mylist.get(i).getEnable()) {
                            return i;
                        }
                    }
                }
                return 0;
            }

            /**
             * This method checks the course has previous, if has return previous index
             * @return previous index of course
             */
            @Override
            public int previousIndex() {

                if(index<0 || index>=mylist.size())
                    throw new IndexOutOfBoundsException();

                else if(index == 0) {
                    return 0;
                }
                else {
                    for(int i=index-1; i>=0; --i) {
                        if(mylist.get(i).getEnable()) {
                            return i;
                        }
                    }
                }
                return 0;
            }

            /**
             * This method remove course from list
             */
            @Override
            public void remove() {
                if(index<0 || index>=size())
                    throw new IndexOutOfBoundsException();

                else {
                    for(int i=index; i<mylist.size(); ++i) {
                        if(mylist.get(i).getEnable()) {
                            mylist.remove(i);
                        }
                    }
                }
            }
            /**
             * This method set course to list
             * @param o course for set
             */
            @Override
            public void set(Object o) {

                if(index<0 || index>=size())
                    throw new IndexOutOfBoundsException();

                mylist.get(index).setSemester(((Course) o).getSemester());
                mylist.get(index).setCourseCode(((Course) o).getCourseCode());
                mylist.get(index).setCourseTitle(((Course) o).getCourseTitle());
                mylist.get(index).setEctsCredit(((Course) o).getEctsCredit());
                mylist.get(index).setGtuCredit(((Course) o).getGtuCredit());
                mylist.get(index).setHtl(((Course) o).getHtl());
            }

            /**
             * This method add new course to list
             * @param o course for add
             */
            @Override
            public void add(Object o) {

                if(index<0 || index>=size())
                    throw new IndexOutOfBoundsException();

                mylist.add(index, (Course) o);
            }
        };
        return myIter;
    }

    /**
     * This method return size of enable items in list
     *
     * @return size of enable items in list
     */
    @Override
    public int size() {
        return mylist.size()-disables.size();
    }

    /**
     * This method take index and return the course if it is not disable
     *
     * @param index index of item
     * @return course
     */
    @Override
    public Course get(int index) {

        if(index<0 || index>=mylist.size())
            throw new IndexOutOfBoundsException();

        for(int i=index; i<mylist.size(); ++i) {
            if(mylist.get(i).getEnable())
                return mylist.get(i);
        }
        return null;
    }
    /**
     * This method takes an index and course, set course to index if this index enable
     *
     * @param index index of course
     * @param course course
     * @return setted course
     */
    public Course set(int index, Course course) {

        for(int i=index; i<mylist.size(); ++i) {
            if(mylist.get(i).getEnable()) {
                return mylist.set(i, course);
            }
        }
        return null;
    }

    /**
     * This method take index and remove if this index is enable
     *
     * @param index index of item
     * @return course
     */
    @Override
    public Course remove(int index) {

        for(int i=index; i<mylist.size(); ++i) {
            if(mylist.get(i).getEnable()) {
                return mylist.remove(i);
            }
        }
        return null;
    }

    /**
     * This method take index and remove if this index is enable
     *
     * @return course
     */
    @Override
    public Course remove() {

        for(int i=0; i<mylist.size(); ++i) {
            if(mylist.get(i).getEnable())
                return mylist.remove(i);
        }
        return null;
    }
    /**
     * This method take index and remove if this index is enable
     *
     * @param course course for remove
     * @return boolean course removed or not
     */
    public boolean remove(Course course) {

        if(course.getEnable()) {
            mylist.remove(course);
            return true;
        }
        return false;
    }
    /**
     * This method return disable courses
     *
     * @return course list of disable items
     */
    public LinkedList<Course> getDisables() { return disables; }

    /**
     * This method set disable list
     *
     * @param disables list of disable courses
     */
    public void setDisables(LinkedList<Course> disables) {
        this.disables = disables;
    }

    /**
     * This method returns list
     *
     * @return list of all courses
     */
    public LinkedList<Course> getMylist() { return mylist; }

    /**
     * This method sets list
     *
     * @param mylist list of all courses
     */
    public void setMylist(LinkedList<Course> mylist) {
        this.mylist = mylist;
    }

    /**
     * This method prints the courses of list
     */
    public void printList() {
        for (int i = 0; i < mylist.size(); ++i) {

            if(mylist.get(i).getEnable()) {
                System.out.print("*Enable* ");
            }
            else
                System.out.print("*Disable*");

            System.out.println(mylist.get(i).getSemester() + " " + mylist.get(i).getCourseCode()
                    + " " + mylist.get(i).getCourseTitle() + " " +
                    mylist.get(i).getEctsCredit() + " " + mylist.get(i).getGtuCredit()
                    + " " + mylist.get(i).getHtl());

        }
    }

    /**
     * This method return string of course
     *
     * @param course course
     * @return string of course
     */
    public String toString(Course course) {

        if(course != null) {
            return course.getSemester() + " " + course.getCourseCode() + " " + course.getCourseTitle() + " " +
                    course.getEctsCredit() + " " + course.getGtuCredit() + " " + course.getHtl();
        }
        else
            return null;
    }
}