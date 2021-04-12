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

        Node tmp = fromTo(-1, 2);
        System.out.println(tmp);

        tmp = fromTo(2, -1);
        System.out.println(tmp);
    }// main

    public static Node fromTo(int m, int n) {
        if (m <= n) {
            PilaDinamica p = new PilaDinamica();
            while (m <= n) {
                p.push(m);
                m++;
            }
            return p.top();
        } else {
            return null;
        }
    }

}// class