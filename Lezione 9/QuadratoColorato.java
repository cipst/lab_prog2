import java.awt.*;

public class QuadratoColorato extends Quadrato {

    private Color color;

    public QuadratoColorato(int lato, Color color) {
        super(lato);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        super.draw(g);
    }
}
