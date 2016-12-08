import java.util.Comparator;

/**
 * Created by tdrs on 6/12/16.
 */
public interface Lista<E> {

    boolean add(E e);

    void add(int index, E e);

    boolean addAll(Lista<? extends E> c);

    void clear();

    boolean contains(Object obj);

    boolean equals(Object obj);

    E get(int index);

    int hashCode();

    int indexOf(Object obj);

    boolean isEmpty();

    E remove(int index);

    boolean remove(Object obj);

    boolean set(int index, E element);

    int size();

    void sort(Comparator<? super E> c);

    Lista<E> subList(int fromIndex, int toIndex);

    Object[] toArray();

    String toString(int k);

}
