import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

//test
public class RecursionExample extends JFrame{
	public void paint (Graphics g) {
		super.paint(g);
		Turtle t = new Turtle(this.getContentPane(),0,0);
		// SimpleFigDrawer fd = new SimpleFigDrawer(this.getContentPane());
		// Hilbert-Kurve
		t.goTo(0.01,0.99,false);
		hilbert(t ,0.015,1,6);
		// Farn
		//t.goTo(0.5,1,false);
		//t.turn(90);
		//farn(t,1,0.005);    // draw the curve

		// Staude
		//t.goTo(0.5,1,false);
		//t.turn(90);
		//staude(t,0.9,0.005);
		// Koch - Kurve
		//t.goTo(0,0.5,false);
		//kochKurve(t,1,5);
		
	}

	public void kochKurve (Turtle t, double dist, int level) {
		// a Koch curve of level n consists of 4 Koch curves of level n-1!
		if (level < 0) return;
		if (level == 0) t.move(dist);
		else {
			kochKurve(t, dist/3, level-1);
			t.turn();
			kochKurve(t, dist/3, level-1);
			t.turn();
			kochKurve(t, dist/3, level-1);
			t.turn();
			kochKurve(t, dist/3, level-1);				
		}
	}

	public void staude(Turtle t,double s, double limit){
		// Turtle steht am Anfang und am Ende an Staudenwurzel
		// und schaut in Stengel Richtung
		if (s>limit){
			t.move(0.6*s); // stengel
			// linke staude
			t.turn();
			staude(t,.3*s,limit);
			// mittlere Staude
			t.turn();
			staude(t,.2*s,limit);
			t.turn();
			staude(t,.3*s,limit);
			t.turn();
			t.moveBackwards(0.6*s); // alter Ort, alte Orientierung 
		}	
	}

	public void farn (Turtle t, double strecke, double limit) {
		if (strecke > limit) {
			t.move(strecke*0.07);
			t.turn();
			farn(t,strecke*0.25,limit);
			t.turn();
			t.move(0.2*strecke/10);
			t.turn();
			farn(t,strecke*0.15,limit);
			t.turn();
			t.move(strecke*0.01);
			t.turn();
			farn(t,strecke*0.9,limit);
			t.turn();
			t.moveBackwards(0.1*strecke,true);        	
		}
	}

	/**
	 * @param t Turtle
	 * @param s Länge des Basiselements der Kurve (z.B. 0.01)
	 * @param sign UmlaufSinn der Kurve (+1 oder -1)
	 * @param level Ordnung der Kurve
	 */
	public void hilbert(Turtle t,double s, int sign, int level){
		if (level > 0){
			t.turn(sign*1);
			hilbert(t,s,-sign,level-1);
			t.move(s);
			t.turn(-sign*1);
			hilbert(t,s,sign,level-1);
			t.move(s);
			hilbert(t,s,sign,level-1);
			t.turn(-sign*1);
			t.move(s);
			hilbert(t,s,-sign,level-1);
			t.turn(sign*1);
		}
	}	

	public static void main (String [] args) {
		RecursionExample kprog = new RecursionExample();
		kprog.setTitle("Recursion");
		kprog.setLocation(100,100);
		kprog.setSize(600,600);
		kprog.getContentPane().setBackground(Color.white);
		kprog.setVisible(true);
		kprog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		kprog.repaint();
	}
}