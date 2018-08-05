package Q2;

/**
 * Created by yagmur on 05.05.2018.
 */
public interface Set<E> {

    boolean add(E obj) throws Exception;
    boolean contains(Object obj);
    boolean isEmpty();
    boolean remove(Object obj);
    int size();
}
