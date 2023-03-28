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
		
		int linesfinaly=5;
		
		
		ArrayList<Lines> lines = new ArrayList<Lines>();
		
		
		@Override
		public void setup() {
			
			lines.add(new Lines(this));
		}

		
	@Override
	public void settings() {
		//this is where things get set to stuff
		size(WIDTH,HEIGHT);
		
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
				//lines.get(i).draw(linesfinaly);
			addlines();
			}
			System.out.println(lines.size());
		}
		
		void movelines() {
			for (int i = 0; i < lines.size(); i++) {
				lines.get(i).x-=speed;
			}
			
		}
		int getfinaly() {
			Integer linesy=5;
			int linesfinaly =0;
			int lineslasty=5;
			linesy=lines.size();
				if(lines.isEmpty()==true) {
					lineslasty=height/2;
				}
				else {
					if(!lines.isEmpty()){
						lineslasty=lines.get(lines.size()-1).finaly;
					}
					
					}
			
			Boolean linesisup =true;
			
	//this is just to debug
			
			//delete things before this
				
				
			//chaining stuff	
				
				
	
	if(changedir!=0) {
		linesisup=ccr.nextBoolean();
	}
	else {
	changedir=chaincheck();
	}
				
	//where I make the distance
	int linesry = ccr.nextInt(rangeb) + ranges;
	System.out.println("ry "+linesry);

	
	
	//if it goes up, make sure it goes up
	if(linesisup) {
		if(linesry<1) {
			linesry*=-1;
		}
	}
	//
	
	
	
	//if it is going down, make sure it goes down
	else {
		if(linesry>1) {
			linesry*=-1;
		}
	}
	//
	
 linesfinaly = lineslasty + linesry;  
	return linesfinaly;
		}
		void addlines() {

			
			if(lines.get(lines.size()-1).x<(WIDTH)-thin) {
				lines.add(new Lines(this));
			}	
			}
			
			
			


		
		
	
public static void main(String[] args) {
		// TODO Auto-generated method stub

	PApplet.main(Coolclass.class.getName());
	
}
}
