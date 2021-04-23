// QuadratoColorato.java
import java.awt.*;
import javax.swing.*;

public class QuadratoColorato extends Quadrato{
    private int r;
    private int g;
    private int b;

    public QuadratoColorato(int lato, int r, int g, int b){
        super(lato);//Il metodo super deve essere il primo metodo invocato nel costruttore (Se deve essere invocato)
        this.r = r; //Imposto i codici RGB per impostare successivamente il Colore
        this.g = g;
        this.b = b;
    }

    public void draw(Graphics f) {
        //Prima imposto il nuovo colore, poi disegno la Figura
        Color old = f.getColor();
        Color c = new Color(r,g,b);
        f.setColor(c);
        super.draw(f);
        f.setColor(old);
    }
}