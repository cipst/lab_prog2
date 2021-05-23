// classe per rappresentare una diramazione

public class Branch extends Tree {
    private int elem;
    private Tree left;
    private Tree right;

    public Branch(int elem, Tree left, Tree right) {
        this.elem = elem;
        this.left = left;
        this.right = right;
    }

    public boolean empty() {
        return false;
    }

    public int max() {
        return right.empty() ? elem : right.max();
    }

    public boolean contains(int x) {
        if (x == elem)
            // abbiamo trovato l'elemento
            return true;
        else if (x < elem)
            // siccome x e` piu` piccolo di elem cerchiamo x solo nel
            // sottoalbero sinistro
            return left.contains(x);
        else
            // siccome x e` piu` grande di elem cerchiamo x solo nel
            // sottoalbero destro
            return right.contains(x);
    }

    public Tree insert(int x) {
        if (x < elem)
            left = left.insert(x);
        else if (x > elem)
            right = right.insert(x);
        // se x == elem x e` gia` presente nell'albero e non lo inseriamo
        return this;
    }

    public Tree remove(int x) {
        if (x == elem) // trovato elemento da eliminare
            if (left.empty())
                // il sottoalbero sinistro e` vuoto, dunque resta il
                // sottoalbero destro
                return right;
            else if (right.empty())
                // il sottoalbero destro e` vuoto, dunque resta il
                // sottoalbero sinistro
                return left;
            else {
                // entrambi i sottoalberi sono non vuoti e dobbiamo
                // individuare un elemento da collocare alla radice
                // dell'albero dopo l'eliminazione di elem. Scegliamo
                // il massimo elemento del sottoalbero sinistro, il
                // quale sara` per definizione piu` grande di tutti
                // gli altri elementi del sottoalbero sinistro e, per
                // la proprieta` degli alberi binari di ricerca, piu`
                // piccolo di tutti gli elementi nel sottoalbero
                // destro. In alternativa sarebbe stato possibile
                // scegliere il minimo elemento del sottoalbero destro
                elem = left.max();
                // eliminiamo l'elemento massimo dal sottoalbero
                // sinistro
                left = left.remove(elem);
                return this;
            }
        else if (x < elem) {
            // se c'e`, l'elemento da eliminare e` nel sottoalbero
            // sinistro
            left = left.remove(x);
            return this;
        } else {
            // se c'e`, l'elemento da eliminare e` nel sottoalbero
            // destro
            right = right.remove(x);
            return this;
        }
    }

    public int depth() {
        return 1 + Math.max(left.depth(), right.depth());
    }

    public int size() {
        return 1 + this.right.size() + this.left.size();
    }

    public int sum() {
        return this.elem + this.left.sum() + this.right.sum();
    }

    public boolean contains(int x, int n) {
        if (n >= 0)
            if (this.elem == x)
                return true;
            else
                return this.left.contains(x, n - 1) || this.right.contains(x, n - 1);
        else
            return false;
    }

    public boolean balanced() {
        if (Math.abs(this.left.depth() - this.right.depth()) <= 1)
            return this.left.balanced() && this.right.balanced();
        else
            return false;
    }

    public Tree filter_le(int x) {
        if (this.elem == x) {
            return new Branch(this.elem, left.filter_le(x), new Leaf());
        }
        if (this.elem < x) {
            return new Branch(this.elem, left.filter_le(x), right.filter_le(x));
        } else {
            return left.filter_le(x);
        }
    }

    public int get(int i) {
        // conrtollo il numero di elementi presenti nel sotto albero sinistro
        // controllo solo il sinistro perchè per rispettare la proprietà
        // i < j ==> t.get(i) < t.get(j) devo partire sempre dal sotto albero sinistro
        /*
                           7
                      /        \
                    4            10 
                 /     \       /     \
                2       5     9       12
              /   \      \   /       /
             1     3      6 8       11
             
            l'elemento in posizione 0 deve assolutamente essere 1 (il + a sx)
            questo perchè
                se i<j ==> get(i) < get(j)
                allora 0<j ==> get(0) < get(j)
                e quindi : get(i) < n, per ogni n <==> i = 0
            es. i = 4, j = 5
                    i < j => OK
                get(i) = 5, get(j) = 6
                    get(i) < get(j) => OK
        */  
        int s = left.size();

        // se s < i
        // -- vuol dire che devo andare a dx perchè a sx ho le posizioni da 0 a s-1
        // -- che non mi interessano (s < i --> 0...s-1 < i)
        // -- cerco in right l'elemento in posizione i - s - 1
        // se s > i
        // -- vuol dire che devo andare a sx perchè a dx ho le posizione da i+1 a s
        // -- che non ni interessano (s > i --> i+1...s > i)
        // altrimenti (s == i)
        // -- ho raggiunto la posizione che stavo cercando
        if (s < i) {
            return right.get(i - s - 1);
        } else if (s > i) {
            return left.get(i);
        } else {
            return elem;
        }
    }

    public String toString() {
        return "Branch(" + elem + "," + left + "," + right + ")";
    }
}
