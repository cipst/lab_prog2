//Cerchio.java
import java.awt.*;
import javax.swing.*;

public class Cerchio extends Figura{
    private int raggio;

    public Cerchio(int raggio)
        { this.raggio = raggio; }

    public void draw(Graphics g){
        g.drawOval(-(raggio/2), -(raggio/2), raggio, raggio); 
        //I punti di origine sono traslati al centro della finestra, quindi [-(raggio/2), -(raggio/2)] sarebbe il nuovo punto di origine
    }

}