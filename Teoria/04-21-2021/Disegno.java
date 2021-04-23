// Disegno.java
import java.awt.*;
import javax.swing.*;

public class Disegno extends JFrame {
    private Figura[] figure;

    public Disegno(Figura[] figure){
    	super();
    	this.figure = figure;
    }

    public void paint(Graphics g) {
    	int w = getSize().width;
    	int h = getSize().height;
    	g.clearRect(0, 0, w, h);
    	g.translate(w / 2, h / 2);
    	for (Figura f : figure) f.draw(g);
    }

    public static void main(String[] args) {
    	Figura[] figure = {
                            new Quadrato(50),
    			            new Cerchio(150),
                            new QuadratoColorato(75, 255, 0, 0), // 255,0,0 è il codice RGB del Rosso
                            new PoligonoRegolare(6, 25) 
    			          };
    	Disegno frame = new Disegno(figure);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(200,200);
    	frame.setVisible(true);

    }
}