package ReallyCoolPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import processing.core.PApplet;
//as levels get harder, have the color change
public class Coolclass extends PApplet{


	static final int WIDTH = 1250;
	static final int HEIGHT = 750;

	Random ccr = new Random();
   
	   
	//makes it so if an up and down chain happenes, the lines overlap twice
	Boolean leniency =false; 
//does what the name impies
	boolean insidelines =true;
	
	int changedir = 0;
	// speed of the lines, should be chosen by the user, or oculd be entered through
	int speed = 4;
	// size of the lines, same stuff after the comma as before
	int thin = 50;
	// The height
	int tall = 100;
		//Max and minumum height of lines
	int maxheight = tall*2;
	int minheight = HEIGHT-(tall*2);	
// (should be a rage)how long things should be chained togegther before
	// switching directicten (as in up and down), same stuff
	int chains = 3;
	int chainb = 6;
	int chainf;
	// finds the last line so it can find out when to add a new line
	int large;
	//used to store the speed when paused
	int speedsave;
	//used to have the pause stuff work
	boolean ispaused = false;
	// (should be a range)the max distance the lines can be apart
	int ranges = 25;
	int rangeb = 45;
	//helps with not flooding console with lines amount
	int linescounter=0;
//Checks to see if the lines should go to the middle or not
	Boolean mid = false;
	Boolean midt=false;
	Boolean midb =false;
	//middle of the screen
	int midscreen = HEIGHT/2;
	//-h-ow- -many l-ines it sh-ould make -to get t-o the cen-te-r
	//budget strike through ^^
//	-int -line-st-omid =- 1-0;
	//Used to add the overlap box
	int y1;
	int x1;
	int w1 = thin;
	int h1 = tall;
	
	int y2;
	int x2;
	int w2 = thin;
	int h2 = tall;
	
	int ax;
	int ay;
	int bx;
	int by;
	int w3;
	int h3;
	int y3;
	int x3;
	
	
	
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
		linesamount();
		slow();
		movelines();
		drawlines();
		addlines();
		remove();
		overlap();
	}

	void remove() {
		for (int i = 0; i < lines.size(); i++) {
			if(lines.get(i).x < -thin) {
				lines.get(i).isactive=false;
			}
		}
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
		background(0, 0, 0);
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).draw();
	
		}
		
	}

	void movelines() {
	if(!ispaused) {
		for (int i = 0; i < lines.size(); i++) {
			lines.get(i).x -= speed;
		}
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
	//	System.out.println("ry " + linesry);
		
		
		
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
void overlap() {
	for (int i = 1; i < lines.size(); i++) {
		if(lines.get(i-1).finaly > lines.get(i).finaly) {
			 y1 = lines.get(i-1).finaly;
			 x1 = lines.get(i-1).x;
			 y2 = lines.get(i).finaly;
			 x2 = lines.get(i).x;
			
			 ax=x1+thin;
			 ay=y1;
			 
			 bx=x2;
			 by=y2+tall;
			 
			 w3=ax-bx;
			 h3=by-ay;
			 
			 x3=ax-w3;
			// y3=ay;
			 fill(255, 255, 255);
			 rect(x3, y1, w3, h3);
			 //x,y,w,h
			 
	}
		else {
			 y1 = lines.get(i-1).finaly;
			 x1 = lines.get(i-1).x;
			 y2 = lines.get(i).finaly;
			 x2 = lines.get(i).x;
			 
			 ax=x1+thin;
			
			 
			 bx=x2;
			
			 
			 w3=ax-bx;
	
			 h3=y1+tall-y2;
			 
			 
			 fill (255, 255, 255);
			 rect(x2, y2, w3, h3);
				
		}
	}
	
}
void slow() {
	if(keyPressed) {
		System.out.println("hello");
		if (key == KeyEvent.VK_SPACE) {
			delay(500);
			if(!ispaused) {
			
				ispaused=true;
				
				System.out.println("paused");
			}
			else {
			
				ispaused=false;
				
				System.out.println("unpaused");
			}
			
		}
		
		
		
	}
	}
void cursorcheck() {
	for(int i=0;lines.size()>i;i++) {
		if(mouseY > lines.get(i).finaly && mouseY<lines.get(i).finaly+tall) {
			if(mouseX >lines.get(i).x && mouseY<lines.get(i).x+thin) {
			insidelines=true;
			}
		}
		//outside of for loop
	}
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
void linesamount(){
	if(linescounter==100) {
		System.out.println("Amount of lines " + lines.size());	
		linescounter=0;
	}
	linescounter++;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main(Coolclass.class.getName());
	


	}

	
	

	
	
	

	
	
}
