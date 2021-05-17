// MyList.java
public class MyList {
    private Node first; // Riferimento al primo nodo della lista

    public MyList() {
        this.first = null;
    }

    public void insert(int elem) {
        first = new Node(elem, first);
    }

    public String toString() {
        String res = "";
        for (Node p = first; p != null; p = p.getNext()) {
            res += p.getElem();
            if (p.getNext() != null)
                res += ", ";
        }
        return res;
    }

    public void modifica() {
        int sum = 0;
        for (Node p = first; p != null; p = p.getNext()) {
            sum += p.getElem();
            p.setElem(sum);
        }
    }

    public void pushSomma() {
        int sum = 0;
        for (Node p = first; p != null; p = p.getNext()) {
            sum += ((p.getElem() > 0) ? p.getElem() : 0);
        }
        insert(sum);
    }

    public static void main(String[] args) {
        MyList l = new MyList();
        l.insert(5);
        l.insert(3);
        l.insert(1);
        l.insert(-5);
        System.out.println(l.toString());
        l.modifica();
        System.out.println(l.toString());
        l.pushSomma();
        System.out.println(l.toString());
    }

}
