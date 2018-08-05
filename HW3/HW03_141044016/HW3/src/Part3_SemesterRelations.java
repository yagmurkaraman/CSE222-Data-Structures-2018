import java.util.LinkedList;

/**
 * Created by yagmur on 22.03.2018.
 */
public class Part3_SemesterRelations extends Course{

    private static class Node{

        private Course data;
        private Node next;

        /**
         * Node Constructor
         * @param dataItem course
         */
        private Node(Course dataItem)
        {
            data=dataItem;
            next=null;
        }

        /**
         * Node Constructor
         * @param dataItem course
         * @param nodeRef node
         */
        private Node(Course dataItem, Node nodeRef)
        {
            data=dataItem;
            next=nodeRef;
        }
    }
    public Node head=null;
    public Node nextHead;
    public int size=0;

    /**
     * Part3_SemesterRelations Constructor
     */
    public Part3_SemesterRelations(){
    }

    /**
     * This method add course to mylinkedlist
     * @param item course
     * @return added course
     */
    public Course add(Course item) {

        if(head == null) {
            return addFirst(item);
        }
        else {
            Node node=getNode(size-1);
            return addAfter(node,item);
        }
    }
    /**
     * This method add to head of list
     * @param item course
     * @return added course
     */
    public Course addFirst(Course item)
    {
        head=new Node(item,head);
        size++;
        return item;
    }
    /**
     * This method add course to after node
     * @param node node
     * @param item course
     * @return added course
     */
    public Course addAfter(Node node, Course item)
    {
        node.next=new Node(item,node.next);
        size++;
        return item;
    }
    /**
     * This method find next of the course
     * @param item course
     * @return next of the course
     */
    public Course next(Course item) {

        Node node=head;
        while(node != null) {
            if(node.data.equals(item)) {
                if(node.next == null)
                    return null;

                else
                    return node.next.data;
            }
            node = node.next;
        }
        return null; //eleman yok.
    }
    /**
     * This method find next same semester of the course
     * @param item course
     * @return next same semester of course
     */
    public Course nextInSemester(Course item) {

        Node node=head;
        Course result = new Course(0, null,null,0,0,null);
        boolean flag=false;
        while(!node.data.equals(item)) {
            node=node.next;
        }
        node = node.next;
        while(node != null) {

            if(node.data.getSemester() == item.getSemester()) {
                flag=true;
                result = node.data;
                break;
            }
            node = node.next;
        }
        Node node1=head;
        if(!flag) {
            while(node1 != null) {

                if(node1.data.getSemester() == item.getSemester()) {
                    result = node1.data;
                    break;
                }
                node1 = node1.next;
            }
        }
        return result;
    }
    /**
     * This method remove course from list
     * @param course course
     * @return removed course
     */
    public Course remove(Course course) {

        Node node=head;

        if(node.data == course) {
            head = head.next;
            return node.data;
        }
        while(node != null) {
            if(node.next.data.equals(course)) {
                removeAfter(node);
                return course;
            }
            node=node.next;
        }
        return null;
    }
    /**
     * This method remove course after node
     * @param node node
     * @return removed course
     */
    public Course removeAfter(Node node)
    {
        Node temp=node.next;
        if(temp!=null){
            node.next=temp.next;
            size--;
            return temp.data;
        }
        else
            return null;
    }
    /**
     * This method gets the course
     * @param index index of course
     * @return course
     */
    public Course get(int index)
    {
        if(index<0 || index>=size)
            throw new IndexOutOfBoundsException();

        Node node=getNode(index);
        return node.data;
    }
    /**
     * This method gets the node
     * @param index index of node
     * @return node
     */
    public Node getNode(int index)
    {
        int i;
        Node node=head;
        for(i=0; i<index && node!=null; ++i) {
            node=node.next;
        }
        return node;
    }
    /**
     * This method return size of nodes
     * @return size of nodes
     */
    public int size() {
        return size;
    }
    /**
     * This method prints all nodes
     */
    public void printList() {

        Node temphead = head;
        while(temphead != null) {

            System.out.println(temphead.data.getSemester() + " " + temphead.data.getCourseCode()
                    + " " + temphead.data.getCourseTitle() + " " +
                    temphead.data.getEctsCredit() + " " + temphead.data.getGtuCredit()
                    + " " + temphead.data.getHtl());

            temphead = head.next;
        }
    }
    /**
     * This method return string of couse
     * @param course course
     * @return string of course
     */
    public String toString(Course course) {

        if (course != null) {
            return course.getSemester() + " " + course.getCourseCode() + " " + course.getCourseTitle() + " " +
                    course.getEctsCredit() + " " + course.getGtuCredit() + " " + course.getHtl();
        } else
            return null;
    }
}
