package ReallyCoolPackage;

import java.util.Random;

import processing.core.PApplet;

public class lines {
	int x = 1250;
	Integer y;
	int lasty;
	int finaly;
	Random r = new Random();
	Coolclass pro;
	Boolean isup =true;
	public lines(Coolclass pro) {
		
		
		
		
		
		this.pro = pro;
		y = pro.lines.size();
		if(pro.lines.isEmpty()==true) {
			lasty=pro.height/2;
		}
		
		
		
		else {
			
			
			
			//makes the chaining stuff work
			lasty=pro.lines.get(pro.lines.size()-2).y;
		}
		if(pro.changedir!=0) {
			 isup=r.nextBoolean();
		}
		else {
		pro.changedir=	pro.chaincheck();
		}
		
		//where I make the distance
			int ry = r.nextInt(pro.rangeb) + pro.ranges;
			System.out.println("ry "+ry);
			
			
			//if it goes up, make sure it goes up
			if(isup) {
				if(ry<1) {
					ry*=-1;
				}
			}
			//
			
			
			
			//if it is going down, make sure it goes down
			else {
				if(ry>1) {
					ry*=-1;
				}
			}
			//
			
		 finaly = lasty + ry;
		 
		
		 
		 
		 
		 
	}

	public void draw() {
		// Make a random int between pro.ranges and pro.rangeb and get the previous
		// lines y
		
		
		pro.rect(x, finaly, pro.thin, pro.tall);

	}
}

//Make a random number between chains and chainb-
//and have the line go a random number between ranges and rangeb relative to the previous-
//lines y in a direction for the amount -
//that the random number betweem chainb/s was

//Then change direction for chains/b amount of times and loop this whole thing again