
// ListExt.java modifichiamo MiniLinkedList della Lezione 14 
// cambiando il nome della classe e aggiungendo le implementazioni
// richieste.

import java.util.*; //per le interfacce Iterable<T>, Comparable<T> 

/* Dichiariamo che ListExt implementa le interfacce (1) Iterable (la vincola a implementare un metodo iterator()) e (2) Comparable (la vincola a implementare un metodo compareTo()). Questo consentira' da un lato di (1) usare il costrutto iterativo for-each di Java per iterare sugli elementi di una struttura e dall'altro di (2) confrontare istanze della classe (che sono liste di interi) secondo l'ordine lessicografico.
*/

public class ListExt implements Iterable<Integer>, Comparable<ListExt> {
  private Node first; private int size;
  public ListExt() {first = null;size = 0;}
  public int size(){return size;}

  private Node node(int i) {
    assert i >= 0 && i < size;
    Node p = first;
    while (p != null && i > 0) {p = p.getNext();i--;}
    assert p != null;
    return p;
  }
   
   public int get(int i){return node(i).getElem();}
   public void set(int i, int x){node(i).setElem(x);}
   public void add(int i, int x) {
      assert 0 <= i && i <= size;
    size++;
    if (i == 0)
      first = new Node(x, first);
    else {
        Node prev = node(i - 1);
        prev.setNext(new Node(x, prev.getNext()));
    }
 }

 public int remove(int i) {
   assert 0 <= i && i < size;
   size--;
   if (i == 0) {
    int x = first.getElem(); 
    first = first.getNext();
    return x;
  } 
  else {
    Node prev = node(i - 1);
    Node p = prev.getNext();
    prev.setNext(p.getNext());
    return p.getElem();
  }
}

// Implementazione di iterator() su Integer
public ListIterator iterator()
      {return new ListIterator(first);} 
 
// Implementazione di Comparable<ListExt>: confrontiamo due liste
// rispetto all’ordine lessicografico
public int compareTo(ListExt lista) {   
  Node p = this.first, q = lista.first;
  //p, q = puntatori ai nodi delle due liste
  //scorro le due liste un passo alla volta  
  while ((p != null) && (q != null)){
    if (p.getElem() != q.getElem()) //le due liste sono diverse
       return p.getElem() - q.getElem(); 
       //valore positivo se la prima 
    // lista e' piu' grande, negativo se e' piu' piccola
   else //vado avanti in entrambe le liste
    {p = p.getNext(); q = q.getNext();}
  }
  // quando il while finisce ho esaurito almeno una delle due liste
  // trovando solo elementi uguali. La lista finita prima e' minore
  if (p == null) {  // la prima lista e' finita 
     if (q == null) // entrambe le liste sono finite 
        return 0;   // quindi sono uguali
     else //prima lista finita ma seconda lista no
        return -1;} //prima lista minore
  else //prima lista NON finita, dunque seconda lista e' finita
    return +1;     // seconda lista minore
 }
}// end class ListExt
