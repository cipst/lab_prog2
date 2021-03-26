public class Node {
    private int elem;
    private Node next;

    public Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }

    public int getElem() {
        return this.elem;
    }
    public Node getNode(){
        return this.next;
    }

    public void setElem(int elem){
        this.elem = elem;
    }
    public void setNode(Node next){
        this.next = next;
    }
}