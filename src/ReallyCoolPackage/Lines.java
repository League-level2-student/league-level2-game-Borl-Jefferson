package ReallyCoolPackage;

import java.util.Random;

import processing.core.PApplet;

public class Lines {
	
	Coolclass pro;
	
	
	int x = 1250;
	int finaly=this.finaly;
	
			
		 
		 
		 
		 
	
 Lines(Coolclass cc){
	pro = cc;
	Integer finaly=pro.getfinaly();
	if( finaly==null) {
		finaly=pro.HEIGHT/2;
	}
	draw(finaly);
}
	public void draw(Integer finaly) {
		// Make a random int between pro.ranges and pro.rangeb and get the previous
		// lines y
		
		System.out.println(x);
		System.out.println(finaly);
		System.out.println(pro.thin);
		System.out.println(pro.tall);
		//try {
			pro.rect(x, finaly, pro.thin, pro.tall);
	//	}
		//catch(NullPointerException e){
		//	System.out.println("fail");
			
	//	}
		
		

	}
}

//Make a random number between chains and chainb-
//and have the line go a random number between ranges and rangeb relative to the previous-
//lines y in a direction for the amount -
//that the random number betweem chainb/s was

//Then change direction for chains/b amount of times and loop this whole thing again