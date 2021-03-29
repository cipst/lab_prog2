public class ImmutableTriangle {
    private ImmutablePoint a;
    private ImmutablePoint b;
    private ImmutablePoint c;

    public ImmutableTriangle(ImmutablePoint a, ImmutablePoint b, ImmutablePoint c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }// constructor

    public ImmutablePoint getA() {
        return this.a;
    }// get A

    public ImmutablePoint getB() {
        return this.b;
    }// get B

    public ImmutablePoint getC() {
        return this.c;
    }// get C

    public ImmutableTriangle translate(double dx, double dy) {
        return new ImmutableTriangle(this.a.moveTo(dx,dy), this.b.moveTo(dx, dy), this.c.moveTo(dx, dy));
    }// translate

    public ImmutableTriangle rotate(double angle) {
        return new ImmutableTriangle(this.a.rotate(angle), this.b.rotate(angle), this.c.rotate(angle));
    }// rotate

    public double perimeter() {
        return this.a.distance(b) + this.b.distance(c) + this.a.distance(c);
    }// perimeter

    public double area() {
        double AB = this.a.distance(b);
        double BC = this.b.distance(c);
        double AC = this.a.distance(c);

        // Formula di Erone
        double s = (AB + BC + AC) / 2;

        return Math.sqrt(s * (s - AB) * (s - BC) * (s - AC));
    }// area
}
