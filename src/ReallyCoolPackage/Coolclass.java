package ReallyCoolPackage;

import java.util.ArrayList;
import java.util.Random;

import processing.core.PApplet;

public class Coolclass extends PApplet {

	static final int WIDTH = 1250;
	static final int HEIGHT = 750;

	
	Random ccr = new Random();
	
	int changedir=0;
		//speed of the lines, should be chosen by the user, or oculd be entered through
		int speed = 4;
		//size of the lines, same stuff after the comma as before
		int thin = 50;
		//The height
		int tall = 100;
		//(should be a rage)how long things should be chained togegther before switching directicten (as in up and down), same stuff
		int chains =2; 
		int chainb = 4;
		int chainf;
		//finds the last line so it can find out when to add a new line
		int large;
		//(should be a range)the max distance the lines can be apart
		int ranges = 35;
		int rangeb = 35;
		
		
		ArrayList<lines> lines = new ArrayList<lines>();
		
	@Override
	public void settings() {
		//this is where things get set to stuff
		size(WIDTH,HEIGHT);
		lines.add(new lines(this));
	}
	public int chaincheck() {
		int chain = chainf=ccr.nextInt(chainb)+chains;
		System.out.println("chain " + chainf);
		return chain;
	}
		//new Segment(hx, hy, this
	@Override
	public void draw() {
		
	movelines();
		drawlines();
		addlines();
	}
		
		void drawlines() {
			for (int i = 0; i < lines.size(); i++) {
				lines.get(i).draw();
			}
			System.out.println(lines.size());
		}
		
		void movelines() {
			for (int i = 0; i < lines.size(); i++) {
				lines.get(i).x-=speed;
			}
			
		}
		
		void addlines() {
			for (int i = 0; i < lines.size(); i++) {
				large=i;
			}
			if(lines.get(large).x<(WIDTH)-thin) {
				lines.add(new lines(this));
			
			}
			
			
			
		}
		
		
	
public static void main(String[] args) {
		// TODO Auto-generated method stub

	PApplet.main(Coolclass.class.getName());
	
}
}
