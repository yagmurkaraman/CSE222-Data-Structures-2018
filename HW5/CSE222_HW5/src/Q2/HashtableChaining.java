package Q2;

/**
 * Created by yagmur on 06.05.2018.
 */
public class HashtableChaining<E> implements Set<E> {

    private Table<E> [] table;
    private int numKeys;
    private static final int CAPACITY=101;
    private static final double LOAD_THRESHOLD=3.0;

    /**
     * Inner class
     * @param <E> generic
     */
    public static  class Table<E> {
        public E data;
        public Table[] next;

        /**
         * Constructor
         * @param obj key
         */
        public Table(E obj) {
            this.data=obj;
            next=null;
        }
    }

    /**
     * Constructor
     */
    public HashtableChaining() {
        table=new Table[CAPACITY];
    }

    /**
     * This method add obj to set
     * @param obj element
     * @return true or false
     */
    @Override
    public boolean add(E obj) {

        int index=obj.hashCode() % table.length;
        if(index<0)
            index+=table.length;

        if(table[index]==null) {
            table[index] = new Table<E>(obj);
            numKeys++;
            if(numKeys> (LOAD_THRESHOLD * table.length))
                rehash();
            return true;

        }
        else {
            table[index].next = new Table[CAPACITY];
            table=table[index].next;
            return add(obj);
        }
    }
    /**
     * This method resize the table and insert the same values to table
     */
    private void rehash()  {
        Table<E>[] oldTable=table;
        table=new Table[2*oldTable.length + 1];
        numKeys=0;
        for(int i=0; i<oldTable.length; ++i) {
            if(oldTable[i] != null)
                add(oldTable[i].data);
        }
    }

    /**
     * This method checks the obj is in the table or not
     * @param obj element for search
     * @return the element is in table or not
     */
    @Override
    public boolean contains(Object obj) {

        int index=obj.hashCode() % table.length;
        if(index<0)
            index+=table.length;

        if(table[index].equals(obj))
            return false;
        else
            return true;
    }

    /**
     * This method checks the table is empty or not
     * @return true if table is empty, false not empty
     */
    @Override
    public boolean isEmpty() {

        return numKeys==0;
    }

    /**
     * This method remove element from table
     * @param obj element for remove
     * @return true if element removed, false if not
     */
    @Override
    public boolean remove(Object obj) {

        int index=obj.hashCode() % table.length;
        if(index<0)
            index+=table.length;

        if(table[index]!=null) {
            table[index] = null;
            --numKeys;
            return true;
        }
        return false;
    }

    /**
     * This method returns size of table
     * @return size
     */
    @Override
    public int size() {

        return numKeys;
    }
}
