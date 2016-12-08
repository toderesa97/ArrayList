import java.util.*;
import java.util.function.Predicate;


public class ArrayLista<E> implements Lista<E>{
    private  Object[] array;
    private Comparator<E> comparator = null;

    public ArrayLista(){
        array = new Object[0];
    }


    @Override
    public int hashCode() {
        int result = Arrays.hashCode(array);
        result = 31 * result + (comparator != null ? comparator.hashCode() : 0);
        return result;
    }

    public ArrayLista(Comparator<E> comparator){
        this.comparator = comparator;
        array = new Object[0];
    }

    E elementData(int index){
        return (E)this.array[index];
    }
    @Override
    public boolean add(Object o) {
        this.array = Arrays.copyOf(array, array.length+1);
        array[array.length-1] = o;
        if(comparator != null) {
            this.sort(comparator);
        }
        return true;
    }

    @Override
    public void add(int index, Object o) {
        if(index < array.length){
            array[index] = o;
        }
        array = Arrays.copyOf(array, array.length+index);
        array[index] = o;

        if(comparator != null) {
            this.sort(comparator);
        }

    }

    @Override
    public boolean addAll(Lista c) {
        if(c instanceof ArrayLista){
            ArrayLista<E> lista = (ArrayLista)c;
            this.array = new Object[0];
            for (int i = 0; i < lista.size(); i++) {
                this.add(lista.get(i));
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear() {
        array = new Object[0];
    }

    @Override
    public boolean contains(Object obj) {
        for(Object object:array){
            if(object.equals(obj)) return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        return index >=0 && index<array.length ? this.elementData(index) : null;
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < array.length; i++) {
            if(array[i].equals(obj)) return i;
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }

    @Override
    public E remove(int index) {
        if(index <0 && index>=array.length) return null;
        Object[] auxliar = new Object[0];
        E obj = null;
        for (int i = 0; i < array.length; i++) {
            if(i==index) {
                obj = (E)array[i];
                continue;
            }
            auxliar = Arrays.copyOf(auxliar, auxliar.length+1);
            auxliar[auxliar.length-1] = array[i];
        }
        this.array = auxliar;
        return obj;
    }

    @Override
    public boolean remove(Object obj) {
        if(!this.contains(obj)) return false;
        Object[] auxiliar = new Object[0];

        for (int i = 0; i < array.length; i++) {
            Object object = array[i];
            if(!object.equals(obj)){
                auxiliar = Arrays.copyOf(auxiliar, auxiliar.length+1);
                auxiliar[auxiliar.length -1] = object;
            }
        }
        this.array = auxiliar;
        return true;
    }


    @Override
    public boolean set(int index, Object element) {
        if(index >=0 && index<array.length){
            this.array[index] = element;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public void sort(Comparator c) {
        Boolean AllSorted = false;

        while (!AllSorted){
            AllSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if(c.compare((E)array[i],(E)array[i+1]) > 0){
                    Object aux = array[i];
                    array[i] = array[i+1];
                    array[i+1] = aux;
                    AllSorted = false;
                }
            }
        }
    }

    @Override
    public Lista subList(int fromIndex, int toIndex) {
        Lista<E> ls = new ArrayLista<>();
        if(fromIndex > toIndex){
            return null;
        }
        if(!(fromIndex >=0 && fromIndex<array.length)){
            return null;
        }
        if(!(toIndex >=0 && toIndex<array.length)){
            return null;
        }
        for (int i = fromIndex; i <toIndex ; i++) {
            ls.add((E)array[i]);
        }
        return ls;
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }



    @Override
    public boolean equals(Object obj){
        ArrayLista arrL = ((ArrayLista)obj);
        if(arrL.array.length != array.length) return false;
        for (int i = 0; i < array.length ; i++) {
            if(!Objects.equals((E)arrL.array[i],(E) array[i])){
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString(){
        String string = "[";
        int counter = 10;
        for (int i = 0; i < array.length; i++) {
            if(counter > i){
                string += array[i] +",";
            }else{
                string+="\n"+array[i]+",";
                counter+=10;
            }
        }
        return string.substring(0, string.length()-1)+"]";
    }
    @Override
    public String toString(int k){
        String string = "[";
        int counter = k;
        for (int i = 0; i < array.length; i++) {
            if(counter > i){
                string += array[i] +",";
            }else{
                string+="\n"+array[i]+",";
                counter+=k;
            }
        }
        return string.substring(0, string.length()-1)+"]";
    }

    @Override
    public void concat(Lista c) {
        ArrayLista lista = (ArrayLista)c;
        for (int i = 0; i < lista.size(); i++) {
            this.add(lista.get(i));
        }
    }

    @Override
    public ArrayLista<E> filter(Predicate<E> predicate){
        Lista<E> lista = new ArrayLista<E>();

        for (int i = 0; i < array.length; i++) {
            if(predicate.test((E)array[i])) lista.add((E)array[i]);
        }
        return (ArrayLista<E>) lista;
    }
}

