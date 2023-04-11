package ReallyCoolPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import processing.core.PApplet;
//as levels get harder, have the color change
public class Coolclass extends PApplet {

	static final int WIDTH = 1250;
	static final int HEIGHT = 750;

	Random ccr = new Random();

	
	//makes it so if an up and down chain happenes, the lines overlap twice
	Boolean leniency =true; 
	//Max and minumum height of lines
	int maxheight = HEIGHT/20;
	int minheight = HEIGHT-(HEIGHT/20);
	
	int changedir = 0;
	// speed of the lines, should be chosen by the user, or oculd be entered through
	int speed = 4;
	// size of the lines, same stuff after the comma as before
	int thin = 50;
	// The height
	int tall = 100;
	// (should be a rage)how long things should be chained togegther before
	// switching directicten (as in up and down), same stuff
	int chains = 3;
	int chainb = 6;
	int chainf;
	// finds the last line so it can find out when to add a new line
	int large;
	// (should be a range)the max distance the lines can be apart
	int ranges = 25;
	int rangeb = 45;
//Checks to see if the lines should go to the middle or not
	Boolean mid = false;
	Boolean midt=false;
	Boolean midb =false;
	//middle of the screen
	int midscreen = HEIGHT/2;
	//-h-ow- -many l-ines it sh-ould make -to get t-o the cen-te-r
	//budget strike through ^^
//	-int -line-st-omid =- 1-0;
	
	
// just to make sure it doesn't give a null error	
	int linesfinaly = 5;

	ArrayList<Lines> lines = new ArrayList<Lines>();

	@Override
	public void setup() {

		lines.add(new Lines(this, getfinaly()));
	}

	@Override
	public void settings() {
		// this is where things get set to stuff
		size(WIDTH, HEIGHT);

	}

	public int chaincheck() {
		int chain = chainf = ccr.nextInt(chainb) + chains;
		System.out.println("chain " + chainf);
		return chain;
	}

	// new Segment(hx, hy, this
	@Override
	public void draw() {

		movelines();
		drawlines();
		addlines();
		for (int i = 0; i < lines.size(); i++) {

		}
	}

	void remove() {
		Iterator<Lines> it = lines.iterator();
		while (it.hasNext()) {
			Lines eachAlien = it.next();
			if (!eachAlien.isactive) {
				it.remove();

			}
		}
	}

	void outofbounds() {
		if ((WIDTH / speed) <= lines.size()) {
			lines.get(WIDTH / speed).isactive = false;
		}
	}

	void drawlines() {
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).draw();
	
		}
		System.out.println("Amount of lines " + lines.size());
	}

	void movelines() {
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).x -= speed;
		}

	}

	int getfinaly() {
		Integer linesy = 5;
		int linesfinaly = 0;
		int lineslasty = 5;
		linesy = lines.size();
		
		if (lines.isEmpty() == true) {
			lineslasty = height / 2;
		} else {
			if (!lines.isEmpty()) {
				lineslasty = lines.get(lines.size() - 1).finaly;
			}

		}

		Boolean linesisup = true;

		// chaining stuff

		if (changedir != 0) {
			linesisup = ccr.nextBoolean();
		} else {
			changedir = chaincheck();
		}

		// where I make the distance
		int linesry = ccr.nextInt(rangeb) + ranges;
		System.out.println("ry " + linesry);
		
		
		
		//checks to make sure its in bounds

		
		
		
		
		
		//the worse version
		

		
		
		
		
		
		// if it goes up, make sure it goes up
		if (linesisup) {
			if (linesry < 1) {
				linesry *= -1;
			}
		}
		//

		// if it is going down, make sure it goes down
		else {
			if (linesry > 1) {
				linesry *= -1;
			}
		}
		//

		
		
		
		//lineslasty = the y of the last line, and linesry = the difference between finaly and lasty
		linesfinaly = lineslasty + linesry;
		if(linesfinaly > minheight) {
			linesfinaly = lineslasty-linesry;
			
			changedir = chaincheck();
			linesisup=true;
	midt=true;

		}
		if(linesfinaly < maxheight) {
			linesfinaly = lineslasty-linesry;
			
			changedir = chaincheck();
			linesisup=false;
			midb=true;
		
		}
		
		if(midt) {
			if(linesfinaly<midscreen) {
				midt=false;
			}
			if(linesry<0) {
				linesry*=-1;
			}
			
		}
		if(midb) {
			if(linesfinaly>midscreen) {
				midb=false;
			}
			if(linesry>0) {
				linesry*=-1;
			}
		}
		
		
		
		linesfinaly = lineslasty-linesry;
		
		
			
		return linesfinaly;
	}

	void addlines() {
if(leniency) {
		if (lines.get(lines.size() - 1).x < (WIDTH) - ((thin/10)*9)) {
			lines.add(new Lines(this, getfinaly()));
		}
	}
	else {
		if (lines.get(lines.size() - 1).x < (WIDTH) - thin) {
			lines.add(new Lines(this, getfinaly()));
		}
	}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main(Coolclass.class.getName());

	}
}
