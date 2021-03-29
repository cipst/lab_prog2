class MutablePoint {

    private double x = 0.0;
    private double y = 0.0;

    public MutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void moveTo(double dx, double dy) {
        System.out.println("Coordinate prima della traslazione: (" + this.x + "," + this.y + ")");
        this.x += dx;
        this.y += dy;
        System.out.println("Coordinate dopo la traslazione: (" + this.x + "," + this.y + ")");
    }

    public void rotate(double angle) {
        System.out.println("Coordinate prima della rotazione: (" + this.x + "," + this.y + ")");
        this.x = x * Math.cos(angle) - y * Math.sin(angle);
        this.y = x * Math.sin(angle) + y * Math.cos(angle);
        System.out.println("Coordinate dopo la rotazione: (" + this.x + "," + this.y + ")");
    }

    public double distance(MutablePoint p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2));
    }
}