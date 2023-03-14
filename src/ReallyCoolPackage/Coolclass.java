package ReallyCoolPackage;

import java.util.ArrayList;


import processing.core.PApplet;

public class Coolclass extends PApplet {

	static final int WIDTH = 1250;
	static final int HEIGHT = 750;

		//speed of the lines, should be chosen by the user, or oculd be entered through
		int speed = 15;
		//size of the lines, same stuff after the comma as before
		int thin = 20;
		//The height
		int tall = 450;
		//(should be a rage)how long things should be chained togegther before switching directicten (as in up and down), same stuff
		int chain =3; //set to an amount of lines for now
		//finds the last line so it can find out when to add a new line
		int large;
		//used to find large
		int small=0;
		//used when I was lowering the lines to see if they were being made
		int debugy=10;
		
		
		
		ArrayList<lines> lines = new ArrayList<lines>();
		
	@Override
	public void settings() {
		//this is where things get set to stuff
		size(WIDTH,HEIGHT);
		lines.add(new lines(this));
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
				lines.get(i).x--;
			}
			
		}
		
		void addlines() {
			for (int i = 0; i < lines.size(); i++) {
				large=i;
			}
			if(lines.get(large).x<(WIDTH)-thin) {
				lines.add(new lines(this));
				debugy++;
			}
			
			
			
		}
		
		
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
	PApplet.main(Coolclass.class.getName());
	
}
}
