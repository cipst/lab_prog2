// Pila di dimensione variable di interi, 
// realizzata come lista concatenata di Nodi
public class PilaDinamica {
    // Riferimento al nodo contenente l'elemento in cima alla pila
    // Invariante: top==null se la pila e' vuota, top!= null altrimenti.
    private Node top;

    // Costruttore: crea una pila vuota
    public PilaDinamica() {
        this.top = null;
    }

    // Ritorna true se la pila e' vuota
    public boolean vuota() {
        return this.top == null;
    }

    // Ritorna true se la pila e' piena.
    // Poiche' la pila ha dimensione dinamica, non puo' mai
    // essere piena, a meno di finire la memoria
    public boolean piena() {
        return false;
    }

    // Aggiungi l'intero @x in cima alla pila
    public void push(int x) {
        top = new Node(x, top);
    }

    // Elimina l'elemento in cima alla pila, e ritornane il valore.
    public int pop() {
        assert !vuota() : "non si puo' chiamare il metodo pop() se la pila e' vuota.";
        int tmp = top.getElem();
        top = top.getNext();
        return tmp;
    }

    public int[] toArray() {
        assert !vuota() : "non si puo' chiamare il metodo toArray() se la pila e' vuota. ";
        int[] a = new int[this.size()];
        int i = 0;
        for (Node tmp = top.getElem(); tmp != null; tmp = tmp.getNext()) {
            a[i++] = tmp.getElem();
        }
        return a;
    }

    public int[] toArray(Node tmp, int size){
        if(tmp == null){
            return new int[size];
        }else{
            int[] a = toArray(tmp.getNext(), size+1);
            a[size-1] = tmp.getElem();
            return a;
        }
    }

    public int[] toArrayWrap(){
        assert !vuoto() : "non si puo' chiamare toArrayWrap() se la pila e' vuota. ";
        return toArray(top, 0);
    }

    public int size() {
        int size = 0;
        for (Node tmp = top.getElem(); tmp != null; tmp = tmp.getNext()) {
            size++;
        }
        return size;
    }
}