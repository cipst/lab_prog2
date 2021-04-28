import java.awt.*; //Abstract Window Toolkit

public class Triangolo extends Figura {

    // Base e altezza del triangolo
    private int b, h;

    // Centro del triangolo
    private int x, y;

    // Colore del perimetro triangolo
    private Color c;

    // Colore dell'area del triangolo
    private Color d;

    public Triangolo(int x, int y, int b, int h, Color c, Color d) {
        this.x = x;
        this.y = y;
        this.b = b;
        this.h = h;
        this.c = c;
        this.d = d;
    }

    public void draw(Graphics g) {
        g.setColor(this.c);
        g.drawLine((x - b) / 2, y, (x + b) / 2, y); // disegno primo lato in g
        g.drawLine((x + b) / 2, y, x, y + h); // disegno secondo lato in g
        g.drawLine(x, y + h, (x - b) / 2, y); // disegno terzo lato in g

        g.setColor(this.d);
        int[] xPoints = { (x - b) / 2, (x + b) / 2, x };
        int[] yPoints = { y, y, y + h };
        g.fillPolygon(xPoints, yPoints, 3);
    }
}