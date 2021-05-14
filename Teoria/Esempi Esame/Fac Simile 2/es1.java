class Node {
    public int elem;
    public Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    @Override
    public String toString() {
        return this.elem + " " + this.next;
    }
}

public class es1 {
    public static Node diff(Node p, Node q) {
        if (p != null && q != null) {
            if (q.elem > p.elem) {
                return new Node(p.elem, diff(p.next, q));
            } else if (q.elem == p.elem) {
                return diff(p.next, q);
            } else {
                return diff(p, q.next);
            }
        }
        return p;
    }

    public static void main(String[] args){
        Node p = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, null))))));
        Node q = new Node(2, new Node(4, new Node(6, null)));
        Node ris = diff(p, q);
        System.out.println(ris.toString());
        
        Node ris2 = diff(p, null);
        System.out.println(ris2.toString());

        Node t = new Node(1, new Node(1, new Node(1, null)));
        Node m = new Node(1, null);
        Node ris3 = diff(t, m);
        System.out.println((ris3!=null)?ris3.toString():"null");
        
        Node ris4 = diff(q, p);
        System.out.println((ris4!=null)?ris4.toString():"null");
    }
}