public class TriangleDemo {
    public static void main(String[] args){
        MutableTriangle t = new MutableTriangle(new MutablePoint(0,0), new MutablePoint(29,14), new MutablePoint(9,22));
        System.out.println("Area= " + String.format("%.2f", t.area()));
        System.out.println("Perimeter= " + String.format("%.2f", t.perimeter()));

        ImmutableTriangle tImm = new ImmutableTriangle(new ImmutablePoint(0,0), new ImmutablePoint(29,14), new ImmutablePoint(9,22));
        System.out.println("Area= " + String.format("%.2f", tImm.area()));
        System.out.println("Perimeter= " + String.format("%.2f", tImm.perimeter()));
    }
}
