import java.awt.*; // Abstract Window Toolkit

public class Rettangolo extends PoligonoRegolare {
    private int b, h;

    public Rettangolo(int b, int h) {
        this.b = b;
        this.h = h;
    }

    public void draw(Graphics g) {
        g.drawLine(b / 2, h / 2, -b / 2, h / 2);
        g.drawLine(-b / 2, h / 2, -b / 2, -h / 2);
        g.drawLine(-b / 2, -h / 2, b / 2, -h / 2);
        g.drawLine(b / 2, -h / 2, b / 2, h / 2);
    }
}
