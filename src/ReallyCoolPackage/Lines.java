package ReallyCoolPackage;

import java.util.Random;

import processing.core.PApplet;

public class Lines {

	Coolclass pro;
	// int counter;
	// if(counter==0) {
	int x; 
	// }
	int finaly;
	boolean isactive = true;

	Lines(Coolclass cc, int y) {
		pro = cc;
		
		this.finaly = y;
	x = pro.WIDTH-(pro.thin/2);

	}

	public void draw() {
		// Make a random int between pro.ranges and pro.rangeb and get the previous
		// lines y

		System.out.println("lines x " + x);
		System.out.println("width of screen " + pro.WIDTH);
		System.out.println("lines final y " + finaly);
		System.out.println("line width " + pro.thin);
		System.out.println("Lines height " + pro.tall);
		System.out.println(pro.lines.size());
		System.out.println("midt "+pro.midt);
		System.out.println("midb "+pro.midb);
		// System.out.println("");
		// try {
		pro.stroke(255, 0, 0);
		pro.fill(255, 0, 0);
		// pro.rect(pro.WIDTH/2, 50, 50, 50);
		pro.fill(255, 170, 190);
		pro.rect(x, finaly, pro.thin, pro.tall);
		// counter++;
		// }
		// catch(NullPointerException e){
		// System.out.println("fail");

		// }

	}
}

//Make a random number between chains and chainb-
//and have the line go a random number between ranges and rangeb relative to the previous-
//lines y in a direction for the amount -
//that the random number betweem chainb/s was

//Then change direction for chains/b amount of times and loop this whole thing again