public class MutableTriangle {
    private MutablePoint a;
    private MutablePoint b;
    private MutablePoint c;

    public MutableTriangle(MutablePoint a, MutablePoint b, MutablePoint c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }// constructor

    public MutablePoint getA() {
        return this.a;
    }// get A

    public MutablePoint getB() {
        return this.b;
    }// get B

    public MutablePoint getC() {
        return this.c;
    }// get C

    public void translate(double dx, double dy) {
        this.a.moveTo(dx, dy);
        this.b.moveTo(dx, dy);
        this.c.moveTo(dx, dy);
    }// translate

    public void rotate(double angle) {
        this.a.rotate(angle);
        this.b.rotate(angle);
        this.c.rotate(angle);
    }// rotate

    public double perimeter() {
        return this.a.distance(b) + this.b.distance(c) + this.a.distance(c);
    }//perimeter

    public double area(){
        double AB = this.a.distance(b);
        double BC = this.b.distance(c);
        double AC = this.a.distance(c);
        
        //Formula di Erone
        double s = (AB+BC+AC)/2;

        return Math.sqrt(s*(s-AB)*(s-BC)*(s-AC));
    }//area
}// class