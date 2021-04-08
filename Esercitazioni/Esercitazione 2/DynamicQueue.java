// coda di dimensione dinamica, implementata come lista di Nodi
public class DynamicQueue {
	// riferimento al primo nodo della lista, o null
	private Node first;
	// riferimento all'ultimo nodo della lista, o null
	private Node last;

	// INVARIANTE:
	// vale: first==last==null,
	// oppure: first.getNext(). ... .getNext() == last
	// && last.getNext() == null

	// costruttore: crea una coda vuota
	public DynamicQueue() {
		first = last = null;
	}// costruttore

	// scrivi una rappresentazione della coda su terminale
	public void scriviOutput() {
		for (Node n = first; n != null; n = n.getNext())
			System.out.println("Elem: " + n.getElem());
	}// scriviOutput

	// inserisci un nuovo elemento @x in fondo alla coda
	public void enqueue(int elem) {
		Node n = new Node(elem, null);
		if (empty()) {
			first = last = n;
		} else {
			last.setNext(n);
			last = n;
		}
		assert first != null && last != null && last.getNext() == null;
	}// enqueue

	// rimuovi e ritorna l'elemento in testa alla coda
	public int dequeue() {
		assert !empty() : "Impossible remove element from an empty queue!";
		Node n = first;
		first = first.getNext();
		return n.getElem();
	}// dequeue

	// ritorna true se la coda e' vuota
	public boolean empty() {
		return (first == null);
	}// empty

	// ritorna l'elemento in testa alla coda, senza rimuoverlo
	public int front() {
		assert !empty() : "Impossible get the head element from an empty queue!";
		return first.getElem();
	}// front

	// ritorna la dimensione della coda
	public int size() {
		int size = 0;
		for (Node n = first; n != null; n = n.getNext())
			size++;
		return size;
	}// size

	// ritorna true se @x e' contenuto nella coda, false altrimenti
	public boolean contains(int x) {
		if (empty())
			return false;
		else {
			boolean flag = false;
			for (Node n = first; n != null && !flag; n = n.getNext())
				flag = n.getElem() == x;
			return flag;
		}
	}// contains

}