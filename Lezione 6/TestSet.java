public class TestSet {
    public static void main(String[] args){
        Set<Integer> s = new Set<Integer>();
        s.add(2);
        s.add(3);
        s.add(4);
        Set<Integer> q = new Set<Integer>();
        q.add(5);
        q.add(6);
        q.add(0);
        q.add(9);
        System.out.println("s.contains(3): " + s.contains(3));
        System.out.println("s.contains(5): " + s.contains(5));
        //System.out.println("s.remove(3): " + s.remove(3));
        System.out.println("s.remove(7): " + s.remove(7));
        System.out.println("s.subsetOf(q): " + s.subsetOf(q));
        System.out.println("q.subsetOf(s): " + q.subsetOf(s));
        System.out.println("s.equalTo(q): " + s.equalTo(q));
        s.union(q).print();
        //q.print();
        s.intersection(q).print();
    }//main
}//class
