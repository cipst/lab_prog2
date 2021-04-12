public class PilaDinamicaTest {

    public static void main(String[] args) {
        PilaDinamica p = new PilaDinamica();
        p.push(13);
        p.push(20);
        p.push(3);
        p.push(56);

        /* ESERCIZIO 1 */
        int[] a = p.toArray();
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

}// class