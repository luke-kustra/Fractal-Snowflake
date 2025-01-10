package shapeSpray;
import java.awt.Graphics;

public class FractalFlake extends ShapeCopy{
	
	private final int limitVal = 12;
	private final int numBranches = 8;
	private int size;
	private int branchFactor;
	
	public FractalFlake(int size, int branchFactor)
	{
		super(50,50);
		this.size = size;
		this.branchFactor = branchFactor;
	}
	
	//@Override
	public void draw(Graphics g) {   //a redirect or facade
	     draw(g, getX(), getY(), limitVal,size);
	}

	
	private void draw(Graphics g, int startX, int startY, int limit, int size) { 

		 if(limit >= 3) {  //base case is depth <3

		  for ( int i = 0; i < numBranches; i++ )
		  {
			  int x2 = startX + (int) (size * Math.cos( (2 * Math.PI / numBranches) * i ));
			  int y2 = startY - (int) (size * Math.sin( (2 * Math.PI / numBranches) * i ));

		      g.drawLine( startX, startY, x2, y2 );  //do a branch    

		       // TODO: make a recursive call to draw() with expected arguments and limit/3
		        draw(g,x2,y2,limit/3,size / branchFactor);

		      }

		  } 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
