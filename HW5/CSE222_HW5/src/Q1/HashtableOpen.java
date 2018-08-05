package Q1;

public class HashtableOpen<K, V> implements Map<K, V> {

    private Entry <K, V> [] table;
    private static final int START_CAPACITY = 31;
    private double LOAD_THRESHOLD = 0.75;
    private int numKeys;
    private int numDeletes;
    private final Entry<K, V> DELETED = new Entry <K, V> (null, null);

    public HashtableOpen() {
        table = new Entry[START_CAPACITY];
    }

    private static class Entry < K, V > {

        protected K key;
        protected V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }

        public V setValue(V val) {
            V oldVal = value;
            value = val;
            return oldVal;
        }
    }
    public int size() {
        return numKeys;
    }

    public boolean isEmpty() {
        return numKeys==0;
    }

    private int find(Object key) {

        int index = key.hashCode() % table.length;
        if (index < 0)
            index += table.length; // Make it positive.

        while((table[index] != null)
                && (!key.equals(table[index].key))) {
            index++;
            if (index >= table.length)
                index = 0;
        }
        return index;
    }
    public V get(Object key) {

        int index = find(key);
        if (table[index] != null)
            return table[index].value;
        else
            return null;
    }
    public V put(K key, V value) throws Exception {

        int index = find(key);
        System.out.print("<" + key + ", " + value + "> " + " -> Index: " + index);
        if (table[index] == null) {

            System.out.println(" -> Bu index null!");
            table[index] = new Entry<K, V>(key, value);
            numKeys++;
            double loadFactor = (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
        }
        else {
            System.out.println(" -> Index null değil, double hashing methodu çağrılır!");
            index = doubleHashing(key, value);
            System.out.println("Double hashing methodu ile null olan index bulundu!");
            System.out.println("Index: " + index);
            table[index] = new Entry<K, V>(key, value);
            numKeys++;
            double loadFactor = (double) (numKeys + numDeletes) / table.length;
            if (loadFactor > LOAD_THRESHOLD)
                rehash();
        }
        return value;
    }
    public int doubleHashing(K key, V value) {

        System.out.println("Double hashing için 11'e mod alınır!");
        int index = find(key);
        int hash = key.hashCode();
        while(table[index] != null) {
            index = (hash % 11) * 3 % table.length;

            if(table[index] != null)
                hash = index;
        }
        return index;
    }
    private void rehash() throws Exception {

        Entry < K, V > [] oldTable = table;
        table = new Entry[2 * oldTable.length + 1];

        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }
    public V remove(Object key) throws Exception {

        int index = find(key);
        System.out.println(index + ". index silindi!");
        if (table[index] == null)
            return null;
        V oldValue = table[index].value;
        table[index] = DELETED;
        numKeys--;
        return oldValue;
    }
    public void printTable() {
        for(int i=0; i<table.length; ++i) {

            System.out.print(i + ". ");
            if(table[i] == null)
                System.out.println("null");
            else
                System.out.println("<" + table[i].key + ", " + table[i].value + ">");
        }
    }
}