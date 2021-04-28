import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class AppletApplication extends Applet implements WindowListener {
	private static int cnt;
    public static void main(java.lang.String[] args) {
		cnt = 0;
        AppletApplication applet = new AppletApplication();
        Frame w = new Frame("Applet");
        w.addWindowListener(applet);
        w.add("Center", applet);
				
        w.setSize(400, 400);
        w.setVisible(true);
        applet.init();
        applet.start();
    }

    public void paint(Graphics g) {
		System.out.println("paint()");
        super.paint(g);
        g.drawString("paint() call num " + cnt, 10, 10);	// Upper left corner
		cnt = cnt +1;
    }

    public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing()");
        System.exit(0);	// Exit the application when the window is closed
    }
    
    // Metodi overridden da 
    public void windowActivated(WindowEvent e) {System.out.println("windowActivated()"); }
    public void windowClosed(WindowEvent e) {System.out.println("windowClosed()"); }
    public void windowDeactivated(WindowEvent e) {System.out.println("windowDeactivated()"); }
    public void windowDeiconified(WindowEvent e) { }
    public void windowIconified(WindowEvent e) { }
    public void windowOpened(WindowEvent e) {System.out.println("windowOpened()"); }

}