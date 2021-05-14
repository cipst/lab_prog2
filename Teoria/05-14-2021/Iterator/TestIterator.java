import java.util.*;

class Node {
    private int elem;
    private Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }// Node constructor

    public int getElem() {
        return this.elem;
    }// getter elem

    public Node getNext() {
        return this.next;
    }// getter next

    public void setElem(int elem) {
        this.elem = elem;
    }// setter elem

    public void setNext(Node next) {
        this.next = next;
    }// setter next

    @Override
    public String toString() {
        return this.elem + " " + ((this.next != null) ? this.next : "");
    }
}

class Interval implements Iterable<Integer> {
    private Node first, last;

    public Interval(Node first, Node last) {
        this.first = first;
        this.last = last;
    }// Interval constructor

    public IntervalIterator iterator() {
        return new IntervalIterator(first, last);
    }
}

class IntervalIterator implements Iterator<Integer> {
    private Node first, last;

    public IntervalIterator(Node first, Node last) {
        this.first = first;
        this.last = last;
    }

    public boolean hasNext() {
        return first != last && first != null;
    }

    public Integer next() {
        int elem = first.getElem();
        first = first.getNext();
        return elem;
    }
}

public class TestIterator {
    public static void main(String[] args) {
        Node p = new Node(1, new Node(2, new Node(3, new Node(4, null)))); // [ 1 2 3 4 ]
        System.out.println("p = [ " + p.toString() + "]");
        Node q = p.getNext().getNext().getNext(); // [ 4 ]
        System.out.println("q = [ " + q.toString() + "]");
        System.out.println();
        
        Interval interval = new Interval(p, q); // first == p; last == q; --> p\q == [ 1 2 3 ]
        System.out.print("p\\q = [ ");
        for (Integer n : interval) {
            System.out.print(n + " ");
        }
        System.out.println("]");
        System.out.println();

        Interval interval2 = new Interval(p, null); //first == p; last == null; --> p\null == p == [ 1 2 3 4 ]
        System.out.print("p\\null = [ ");
        for (Integer n : interval2) {
            System.out.print(n + " ");
        }
        System.out.println("]");
        System.out.println();

        Interval interval3 = new Interval(p, p); //first == p; last == p; --> p\p == [ ]
        System.out.print("p\\p = [ ");
        for (Integer n : interval3) {
            System.out.print(n + " ");
        }
        System.out.println("]");
        System.out.println();
    }// main
}// Test Iterator