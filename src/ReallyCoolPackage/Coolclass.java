package ReallyCoolPackage;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.core.PFont;
//as levels get harder, have the color change
public class Coolclass extends PApplet{


	static final int WIDTH = 1250;
	static final int HEIGHT = 750;

	Random ccr = new Random();
   
	   
	//makes it so if an up and down chain happenes, the lines overlap twice
	Boolean leniency =false; 

	//used to keep the background red
	int scoretimer =0;
//does what the name impies
	boolean insidelines =false;
	int changedir = 0;
	//used to help debug the point system
	int cooldebugline;
	//this is what prevents you from getting points at the very begening 
	boolean juststarted =true;
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
	//Toggles the overlap box
	boolean overlap = true;
	//stores the good, bad, and net points
	int goodp;
	int badp;
	int netp;
	// finds the last line so it can find out when to add a new line
	int large;
	//used to store the speed when paused
	int speedsave;
	//used to have the pause stuff work
	boolean ispaused = true;
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
public void settings() {
		// this is where things get set to stuff
		size(WIDTH, HEIGHT);

	}
public int chaincheck() {

		int chain = chainf = ccr.nextInt(chainb) + chains;
		System.out.println("chain " + chainf);
		return chain;
	}
void points() {
	netp=goodp-badp;
	PFont font;
	font = createFont("Arial",8,true);
	textFont(font,36);
	fill(255, 255, 255);
	text("good " + goodp, 50, 50);
	text("bad " + badp, 50, 100);
	text("net " + netp, WIDTH-250, 50);
	if(!ispaused) {
	if(!juststarted) {
		
		if(insidelines) {
			goodp++;
		}
		if(!insidelines) {
			badp++;
		}
		
	
	}
	}
}
// new Segment(hx, hy, this
void juststarted() {
	if(juststarted) {
		if(ispaused) {
		PFont f;
		f = createFont("Arial",16,true);
		textFont(f,36);
		fill(235, 235, 255);
		text("Press [space] to start", WIDTH/2-150, HEIGHT/2);
		text("Press [shift + t] for tutorial", WIDTH/2-150, HEIGHT/2+100);
		
	}
	}
}
	@Override
	public void draw() {
		editor();
		mousecheck();
		points();
	
		tutorial();
		linesamount();
		slow();
		movelines();
		drawlines();
		addlines();
		restart();
		remove();
		overlap();
			juststarted();
	}
void editor() {
	//speed 4, thin 50, tall 100, chains/b 3/6, ranges/b 25/45, overlap t
	
	if(key==KeyEvent.VK_D) {
		
	
String len =	JOptionPane.showInputDialog("1/9 \n Press enter if you don't want to edit the variable \n Leniency \n false \n Has it so when the lines go in an up down up down pattern, there isn't a gap betweem them \n type t/f");
String spd =	JOptionPane.showInputDialog("2/9 \n speed \n 4 \n Changes how fast the lines should be, if it breaks something, try making it a multiple of 4");
String thn =JOptionPane.showInputDialog("3/9 \n thin \n 50 \n The width of the lines ");
String tal =	JOptionPane.showInputDialog("4/9 \n tall \n 100 \n The height of the lines");
	String chnb =	JOptionPane.showInputDialog("5/9 \n  chains \n 3 \n the minimum amount of times the lines must chain together in one direction");
	String chns =	JOptionPane.showInputDialog("6/9 \n chainb \n 6 \n The same as before but instead it's the maximum amount of times");
	String rngs =	JOptionPane.showInputDialog("7/9 \n ranges \n 25 \n the minimum distance the lines can be from each other");
	String rngb =	JOptionPane.showInputDialog("8/9 \n rangeb \n 45 \n the same as before but the max distance");
	String ovp =	JOptionPane.showInputDialog("9/9 \n overlap \n true \n toggles the white squares \n type t/f");
	
	if(!spd.isEmpty()) { int dspd = Integer.parseInt(spd);speed=dspd;}
	if(!thn.isEmpty()) {int dthn = Integer.parseInt(thn);thin=dthn;}
	if(!tal.isEmpty()) {int dtal = Integer.parseInt(tal);tall=dtal;}
	if(!chnb.isEmpty()) {int dchnb = Integer.parseInt(chnb);chainb=dchnb;}
	if(!chns.isEmpty()) {int dchns = Integer.parseInt(chns);chains=dchns;}
	if(!rngs.isEmpty()) {int drngs = Integer.parseInt(rngs);ranges=drngs;}
	if(!rngb.isEmpty()) {int drngb = Integer.parseInt(rngb);rangeb=drngb;}
	if(!len.isEmpty()) {
		if(len .equals ("t") ) {
			leniency=true;
			}
		
	if(len.equals("f")) {
			leniency=false;
			}
		}
	
	
	
	if(!ovp.isEmpty()) {
		if(ovp .equals ("t") ) {
			overlap=true;
			}if(ovp.equals("f")){
			 overlap=false;
			}
	}
	}
		}
	
	
	
			
		


void tutorial() {
	if(key ==KeyEvent.VK_P) {
		String consoleprintthing = JOptionPane.showInputDialog("I couldn't think of anything funny to put here");
		System.out.println(consoleprintthing);
	}
		if (key == KeyEvent.VK_T) {
			delay(500);
			JOptionPane.showMessageDialog(null, "1/7 \n You can press enter to go through the tutorial without pressing ok \n Keep your cursor inside the orange and white boxes");
		JOptionPane.showMessageDialog(null, "2/7 \n The white boxes are were the lines overlap, \n it's easier to think of it as going from white box to white box");
		JOptionPane.showMessageDialog(null, "3/7 \n Good stands for good points, you get those for being inside the lines \n Bad stands for bad points, you get those for being outside of the lines \n Net stands for net points, it's your good points with bad ones subtracted");
		JOptionPane.showMessageDialog(null, "4/7 \n Press space to pause and shift+r to restart quickly");
		JOptionPane.showMessageDialog(null, "5/7 \n Collect the tokens on the top and bottom of the screen to get rid of bad points \n Try to do it quickly though, since you still get bad points for being outside of the lines \n Hasn't been added yet though");
		JOptionPane.showMessageDialog(null, "6/7 \n Shift + r to restart");
		JOptionPane.showMessageDialog(null, "7/7 \n Shift + d to change variables (exit out of this popup (enter or ok) before doing so)");
		}
		if(key ==KeyEvent.VK_M) {
			delay(500);
			
		}
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
	if(overlap) {
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
			 fill(85, 55, 55);
			 if(!ispaused) {
				 fill(255, 255, 255);
			 }
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
			 
			 
			 fill(85, 55, 55);
			 if(!ispaused) {
				 fill(255, 255, 255);
			 }
			 rect(x2, y2, w3, h3);
				
		}
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
void mousecheck() {

	insidelines=false;
	for(int i=0;lines.size()-1>i;i++) {
		if(mouseY > lines.get(i).finaly && mouseY<(lines.get(i).finaly)+tall) {
			if(mouseX >lines.get(i).x && mouseX<(lines.get(i)).x+thin) {
			insidelines=true;
			juststarted=false;
			cooldebugline=i;
			}
		}
		
		//outside of for loop
	}
	background(50, 25, 10);
	if(!insidelines) {
	scoretimer=0;
	}
	if(insidelines) {
		scoretimer++;
		if(scoretimer>25) {
		background(10, 50, 25);
		}
	}

	
}
void restart() {
	if(key == KeyEvent.VK_M) {
		//restar the whole game
	}
	if(key == KeyEvent.VK_R) {
		//insta restart level
		juststarted=true;
		for(int i=0; i<lines.size()-1;i++) {
			lines.get(i).isactive=false;
		}
		Iterator<Lines> it = lines.iterator();
		while (it.hasNext()) {
			Lines eachAlien = it.next();
			if (!eachAlien.isactive) {
				it.remove();

			}
		}
		goodp=0;
		badp=0;
		netp=0;
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
