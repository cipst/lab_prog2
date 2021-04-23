// Quadrato.java
import java.awt.*;
import javax.swing.*;

public class Quadrato extends Figura {
    private int lato;

    public Quadrato(int lato)
    { this.lato = lato; }

    public void draw(Graphics g) {
    	int m = lato / 2;
    	g.drawLine(m, m, -m, m);
    	g.drawLine(-m, m, -m, -m);
    	g.drawLine(-m, -m, m, -m);
    	g.drawLine(m, -m, m, m);
    }
}