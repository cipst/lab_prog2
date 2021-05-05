//ListIterator.java Questa classe deve implementare Iterator<Integer>
import java.util.*;

public class ListIterator implements Iterator<Integer>{
   private Node next; //All’inizio = inizio lista
   public ListIterator(Node next){this.next = next;}

public boolean hasNext(){return  next != null;}

public Integer next(){
    int x = next.getElem(); //contenuto del prossimo nodo
    next = next.getNext();  //indirizzo del nodo dopo ancora
    return x;
    //x viene automaticamente trasformato da int a Integer
    // (via auto-boxing)
  }
}// end class ListIterator