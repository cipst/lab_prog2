class ImmutablePoint {

    private double x = 0.0;
    private double y = 0.0;

    public ImmutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public ImmutablePoint moveTo(double dx, double dy) {
        System.out.println("Coordinate prima della traslazione: (" + this.x + "," + this.y + ")");
        ImmutablePoint newPoint = new ImmutablePoint(this.x + dx, this.y + dy);
        System.out.println("Coordinate dopo la traslazione: (" + newPoint.getX() + "," + newPoint.getY() + ")");
        return newPoint;
    }

    public ImmutablePoint rotate(double angle) {
        System.out.println("Coordinate prima della rotazione: (" + this.x + "," + this.y + ")");
        ImmutablePoint newPoint = new ImmutablePoint(x * Math.cos(angle) - y * Math.sin(angle),
                x * Math.sin(angle) + y * Math.cos(angle));
        System.out.println("Coordinate dopo la rotazione: (" + newPoint.getX() + "," + newPoint.getY() + ")");
        return newPoint;
    }

    public double distance(ImmutablePoint p) {
        return Math.sqrt(Math.pow((this.x - p.getX()), 2) + Math.pow((this.y - p.getY()), 2));
    }
}