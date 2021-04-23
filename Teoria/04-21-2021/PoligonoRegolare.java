// PoligonoRegolare.java
import java.awt.*;
import javax.swing.*;

public class PoligonoRegolare extends Figura{
    private int n; //Numero di lati (= numero di vertici)
    private int raggio;

    public PoligonoRegolare(int n, int raggio){
        this.n = n;
        this.raggio = raggio;
    }

    public void draw(Graphics g){
        //Coordinate del vertice i-esimo: [r*cos((2pi*i)/n), r*sin((2pi*i)/n)]
        for(int i = 0; i < n; i++){
            int x1 = (int)(raggio * Math.cos((2 * Math.PI * i)/n));
            int y1 = (int)(raggio * Math.sin((2 * Math.PI * i)/n));
            int x2 = (int)(raggio * Math.cos((2 * Math.PI * (i+1))/n));
            int y2 = (int)(raggio * Math.sin((2 * Math.PI * (i+1))/n));
            g.drawLine(x1, y1, x2, y2);
        }
    }
}