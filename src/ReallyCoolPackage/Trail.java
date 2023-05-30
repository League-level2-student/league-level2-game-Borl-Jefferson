package ReallyCoolPackage;

public class Trail {

	Coolclass pro;
	
	int x;
	int y;
	boolean isactive = true;

	Trail(Coolclass cc) {
		pro = cc;
			 x=pro.mouseX;
	y=pro.mouseY;
	
	
	}
 
	public void draw() {

		pro.stroke(225, 225, 40);	
		pro.fill(225, 225, 40);
		pro.rect(x-4, y-7, 7, 14);
	x-=pro.speed;
	}
}


