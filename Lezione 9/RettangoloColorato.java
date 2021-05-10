import java.awt.*;

public class RettangoloColorato extends Rettangolo {

    private Color color;

    public RettangoloColorato(int b, int h, Color color) {
        super(b, h);
        this.color = color;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        super.draw(g);
    }
}
