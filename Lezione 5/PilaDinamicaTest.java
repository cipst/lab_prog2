public class PilaDinamicaTest {

    public static void main(String[] args) {
        PilaDinamica pDinamica = new PilaDinamica();
        pDinamica.push(13);
        pDinamica.push(20);
        pDinamica.push(3);
        pDinamica.push(56);

        /* ESERCIZIO 1 */
        int[] a = pDinamica.toArray();
        System.out.println("length: " + a.length);
        for (int i = 0; i < a.length; ++i)
            System.out.print(a[i] + " | ");
        System.out.println();
        System.out.println();

        Node tmp = fromTo(-1, 2);
        System.out.println(tmp);
        tmp = fromTo(2, -1);
        System.out.println(tmp);
        System.out.println();

        tmp = new Node(1, null);
        tmp = new Node(1, tmp);
        tmp = new Node(2, tmp);
        tmp = new Node(3, tmp);
        System.out.println("# occurences '1' : " + occurences(tmp, 1));
        System.out.println();

        Node p = new Node(1, null);
        p = new Node(2, p);
        p = new Node(3, p);
        System.out.println("p: " + p);
        Node q = new Node(0, null);
        q = new Node(1, q);
        q = new Node(2, q);
        q = new Node(2, q);
        q = new Node(0, q);
        q = new Node(3, q);
        q = new Node(4, q);
        System.out.println("q: " + q);
        System.out.println("p is included in q: " + included(p, q));
        System.out.println("q is included in p: " + included(q, p));
        System.out.println();

        Node z = reverse(p);
        System.out.println(z);
        System.out.println();

        Node x = new Node(1, null);
        x = new Node(2, x);
        x = new Node(3, x);
        Node y = new Node(4, null);
        y = new Node(5, y);
        y = new Node(6, y);
        System.out.println(zipSum(x, y));

    }// main

    public static Node fromTo(int m, int n) {
        if (m <= n) {
            Node tmp = new Node(m++, null);
            while (m <= n) {
                tmp = new Node(m++, tmp);
            }
            return tmp;
        } else {
            return null;
        }
    }

    public static int occurences(Node p, int x) {
        if (p == null)
            return -1;
        else {
            int count = 0;
            for (Node tmp = p; tmp != null; tmp = tmp.getNext())
                count += (tmp.getElem() == x) ? 1 : 0;
            return count;
        }
    }

    public static boolean included(Node p, Node q) {
        if (p == null && q != null || p != null && q == null)
            return false;

        while (p != null && q != null) {
            if (p.getElem() == q.getElem()) {
                p = p.getNext();
            }
            q = q.getNext();
        }

        // se p == null --> vuol dire che l'ho visitato tutto --> quindi p è incluso in
        // q
        return p == null;
    }

    public static Node reverse(Node p) {
        // imposto il precedente e il successivo a null
        Node prev = null;
        // imposto il nodo correntea p
        Node current = p;
        Node next = null;
        while (current != null) {
            // il successivo diventa l'effettivo nodo successivo al corrente
            next = current.getNext();
            // l'effettivo successivo al nodo diventa il precedente
            current.setNext(prev);
            // il precedente diventa il nodo corrente
            prev = current;
            // il corrente diventa il successivo
            current = next;
        }
        // ritorno il precedente perchè il corrente sarebbe null
        return prev;
    }

    public static Node zipSum(Node p, Node q) {
        if (p.getNext() == null) {
            return new Node(p.getElem() + q.getElem(), null);
        } else {
            return new Node(p.getElem() + q.getElem(), zipSum(p.getNext(), q.getNext()));
        }
    }
}// class