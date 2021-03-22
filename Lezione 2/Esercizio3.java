public class Esercizio3 {
    public static void main(String[] args) {

        Point p = new Point(1, 3);
        p.moveTo(1, 2);
        System.out.println("MoveTo mutabile > (" + p.getX() + "," + p.getY() + ")");

        Point p1 = p.moveToImm(1, 2);
        System.out.println("MoveTo immutabile > (" + p1.getX() + "," + p1.getY() + ")");

        System.out.println("Distance from p to p1 > " + p1.distance(p));

        p.rotate(30);
        System.out.println("Rotate mutabile > (" + p.getX() + "," + p.getY() + ")");

        p1 = p1.rotateImm(30);
        System.out.println("Rotate immutabile > (" + p1.getX() + "," + p1.getY() + ")");

    }
}// class