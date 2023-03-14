package ReallyCoolPackage;

import processing.core.PApplet;

public class lines {
	int x = 1250;
	
	Coolclass cc = new Coolclass();
	int y=cc.debugy;
	 PApplet pro;
	public lines(PApplet pro){
	 this.pro = pro;
	}
	 public void draw() {
 		pro.rect(x, y, cc.thin, cc.tall);
 	
}
}
