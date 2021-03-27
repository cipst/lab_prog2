/* Nel seguito, supponiamo che q={40,30,20,10} sia una lista, con q che punta al suo primo nodo.

0.	void scriviOutput(Node p). Stampa una lista concatenata. La scriviOutput(q) scrive: 40 30 20 10 andando a capo. 

1.	int length(Node p). Calcola la lunghezza di una lista. Traversiamo la lista con un ciclo, aggiungendo uno ogni volta che troviamo un nodo non nullo. length(L) vale 4.

2.	int sum(Node p). Somma degli elementi di una lista. Traversiamo la lista con un ciclo, sommando tutti gli elementi che incontriamo e mantenendo il risultato in una variabile s. Finita la lista, s è la somma di tutti gli elementi della lista. sum(q) vale 10+20+30+40=100.

3.	int max(Node p). Massimo degli elementi di una lista non nulla (non definito per la lista vuota). Traversiamo la lista con un ciclo, mantendo in una variabile m il più grande degli elementi trovati. Alla fine della lista m è il massimo. max(q) vale 40. 

4.	boolean member(Node p, int x). Controlla se x dato compare in una lista p. Traversiamo la lista con un ciclo, e non appena troviamo x usciamo con risposta true. Se arriviamo alla fine della lista senza trovare x, restituiamo false. member(q,30) vale true e member(q,50) vale false.

5.	String toString(Node p). Restituisce una stringa con i nodi di p separati da uno spazio. toString(q) vale "40 30 20 10".

6.	boolean sorted(Node p). Verifica se una lista concatenata è ordinata in modo debolmente crescente. sorted(q) vale true, se p = {10,20,30,40,30,20,10} allora sorted(p) vale false.

7.	boolean equals(Node p, Node q). Verifica se due liste concatenate sono uguali: hanno gli stessi elementi nello stesso ordine. equals(q,q) vale true, se p = {10,20,30,40,30,20,10} allora equals(p,q) vale false.

Per i metodi 1-4 daremo anche una soluzione ricorsiva. Per i metodi 5-7 non indichiamo suggerimenti. 
*/

public class NodeUtil {

    // 0
    public static void scriviOutput(Node p) {
        while (p != null) {
            System.out.println(p.getElem());
            p = p.getNext();
        }
    }

    // 1
    public static int length(Node p) {
        int l;
        for (l = 0; p != null; ++l)
            p = p.getNext();
        return l;
    }

    // 1 - rec
    public static int length_rec(Node p) {
        if (p != null)
            return 1 + length_rec(p.getNext());
        else
            return 0;
    }

    // 2
    public static int sum(Node p) {
        int s = 0;
        while (p != null) {
            s += p.getElem();
            p = p.getNext();
        }
        return s;
    }

    // 2 - rec
    public static int sum_rec(Node p) {
        if (p != null)
            return p.getElem() + sum_rec(p.getNext());
        else
            return 0;
    }

    // 3
    public static int max(Node p) {
        int m = -1;
        while (p != null) {
            if (m < p.getElem())
                m = p.getElem();
            p = p.getNext();
        }
        return m;
    }

    // 3 - rec
    public static int max_rec(Node p) {
        if (p != null) {
            int tmp = max_rec(p.getNext());
            return (tmp < p.getElem()) ? p.getElem() : tmp;
        } else {
            return -1;
        }
    }

    // 4
    public static boolean member(Node p, int x) {
        while (p != null) {
            if (p.getElem() == x)
                return true;
            p = p.getNext();
        }
        return false;
    }

    // 4 - rec
    public static boolean member_rec(Node p, int x){
        if(p!=null){
            return (p.getElem() == x)?true:member_rec(p.getNext(), x);
        }else{
            return false;
        }
    }

    //5
    public static String toString(Node p){
        String s="";
        while(p!=null){
            s+= p.getElem() + " ";
            p = p.getNext();
        }
        return s;
    }
}