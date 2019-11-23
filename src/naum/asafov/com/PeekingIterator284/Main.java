package naum.asafov.com.PeekingIterator284;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> i = new ArrayList<Integer>();
        i.add(5);
        i.add(6);
        i.add(7);
        i.add(8);
        PeekingIterator p = new PeekingIterator(i.iterator());
        System.out.println(p.next());
        System.out.println(p.hasNext());
        System.out.println(p.peek());
        System.out.println(p.next());
        System.out.println(p.next());
        System.out.println(p.hasNext());
        System.out.println(p.next());
        System.out.println(p.next());


    }
}
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iter;
    private Integer next;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        iter = iterator;
        if (iter.hasNext()){
            next = iter.next();
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (next==null){
            return null;
        }
        Integer i = next;
        next = iter.hasNext() ? iter.next() : null;
        return i;
    }

    @Override
    public boolean hasNext() {
        if (next==null){
            return false;
        }else {
            return true;
        }
    }
}
