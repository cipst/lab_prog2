public class Set<T> {

    private Node<T> first;
    private int size;

    public Set() {
        first = null;
        size = 0;
    }// Set

    public int size() {
        return this.size;
    }// size

    public boolean empty() {
        return this.size == 0;
    }// empty

    public void add(T elem) {
        assert !contains(elem) : elem + " e' gia' presente nella lista!";
        first = new Node<T>(elem, first);
        size++;
    }// add

    public boolean remove(T elem) {
        assert !empty() : "Impossibile rimuovere elementi di una lista vuota!";
        Node<T> tmp = first;

        if (tmp.getElem().equals(elem)) {
            first = first.getNext();
            size--;
            return true;
        }

        while (tmp.getNext() != null) {
            if (tmp.getNext().getElem().equals(elem)) {
                tmp.setNext(tmp.getNext().getNext());
                size--;
                return true;
            }
            tmp = tmp.getNext();
        }

        return false;
    }// remove

    public boolean contains(T elem) {
        for (Node<T> p = first; p != null; p = p.getNext())
            if (p.getElem().equals(elem))
                return true;
        return false;
    }// contains

    public boolean subsetOf(Set<T> s) {
        if (this.size > s.size)
            return false;

        Node<T> tmp = s.first;
        Node<T> n = this.first;
        while (tmp != null && n != null) {
            if (tmp.getElem().equals(n.getElem())) {
                n = n.getNext();
                tmp = s.first;
            } else
                tmp = tmp.getNext();
        }

        // se this è contenuno in s ==> n alla fine del ciclo sarà null
        return n == null;
    }// subsetOf

    public boolean equalTo(Set<T> s) {
        if (this.size != s.size)
            return false;

        Node<T> tmp = s.first;
        Node<T> n = this.first;
        while (tmp != null && n != null) {
            if (tmp.getElem().equals(n.getElem())) {
                n = n.getNext();
                tmp = tmp.getNext();
            } else
                return false;
        }

        return true;
    }// equalTo

    public Set<T> union(Set<T> s) {
        assert !this.empty() && !s.empty() : "Impossibile unire due liste vuote!";
        Set<T> newSet = new Set<T>();
        for (Node<T> tmp = this.first; tmp != null; tmp = tmp.getNext()) {
            newSet.add(tmp.getElem());
        }
        for (Node<T> tmp = s.first; tmp != null; tmp = tmp.getNext()) {
            newSet.add(tmp.getElem());
        }
        return newSet;
    }// union

    public Set<T> intersection(Set<T> s) {
        Set<T> newSet = new Set<T>();
        if (this.size > s.size) {
            Node<T> tmp = s.first;
            while (tmp != null) {
                if (this.contains(tmp.getElem())) {
                    newSet.add(tmp.getElem());
                }
                tmp = tmp.getNext();
            }
        } else {
            Node<T> tmp = this.first;
            while (tmp != null) {
                if (s.contains(tmp.getElem())) {
                    newSet.add(tmp.getElem());
                }
                tmp = tmp.getNext();
            }
        }

        return newSet;
    }// intersection

    public void print() {
        for (Node<T> n = this.first; n != null; n = n.getNext()) {
            System.out.println("- " + n.getElem() + " \\");
        }
    }// print
}// class