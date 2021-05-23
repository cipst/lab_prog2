import java.util.*;

public class TestTree {
    public static void main(String[] args) {
        Random r = new Random();
        // creo un albero con 10 numeri interi casuali
        Tree t = new Leaf();
        for (int i = 0; i < 10; i++)
            t = t.insert(r.nextInt(20));
        testTreeMethods(t);

        // creo un albero come nel testo della specifica
        Tree t1 = new Branch(3, new Branch(1, new Leaf(), new Branch(2, new Leaf(), new Leaf())),
                new Branch(5, new Leaf(), new Leaf()));
        testTreeMethods(t1);

        Tree t2 = new Branch(5,
                new Branch(2, new Branch(1, new Leaf(), new Leaf()),
                        new Branch(3, new Leaf(), new Branch(4, new Leaf(), new Leaf()))),
                new Branch(7, new Branch(6, new Leaf(), new Leaf()), new Branch(8, new Leaf(), new Leaf())));
        testTreeMethods(t2);

        Tree t3 = new Branch(7, new Leaf(), new Leaf());
        t3.insert(4);
        t3.insert(5);
        t3.insert(6);
        t3.insert(2);
        t3.insert(1);
        t3.insert(3);
        t3.insert(10);
        t3.insert(9);
        t3.insert(8);
        t3.insert(12);
        t3.insert(11);
        testTreeMethods(t3);
    }

    private static void testTreeMethods(Tree t) {
        System.out.println("t = " + t);
        System.out.println("t.empty() = " + t.empty());
        System.out.println("t.max() = " + t.max());
        System.out.println("t.contains(6) = " + t.contains(6));
        System.out.println("t.depth() = " + t.depth());
        // aggiungere le chiamate ai metodi da implementare
        System.out.println("t.size() = " + t.size());
        System.out.println("t.sum() = " + t.sum());
        System.out.println("t.contains(3, 2) == " + t.contains(3, 2));
        System.out.println("t.contains(2, 1) == " + t.contains(2, 1));
        System.out.println("t.balanced() == " + t.balanced());
        System.out.println("t.filter_le(2) = " + t.filter_le(2).toString());
        System.out.println("t.filter_le(5) = " + t.filter_le(5).toString());
        int ris = t.get(3);
        System.out.println("t.get(3) = " + (ris == Integer.MIN_VALUE ? "Elemento non trovato" : ris));
        ris = t.get(5);
        System.out.println("t.get(5) = " + (ris == Integer.MIN_VALUE ? "Elemento non trovato" : ris));
        ris = t.get(8);
        System.out.println("t.get(8) = " + (ris == Integer.MIN_VALUE ? "Elemento non trovato" : ris));
    }
}
