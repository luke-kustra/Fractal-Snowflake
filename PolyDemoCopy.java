package shapeSpray;

import java.util.*;
import javax.swing.*;
import java.awt.*;
/*
* Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
*
* Author: Rob Nash
*/

/*
 * Code by Luke Kustra, CSSSKL 143 Section B
 */

public class PolyDemoCopy extends JFrame{
	
	public PolyDemoCopy() {
		getContentPane().add(new PolyDemoPanel());
		//just some windowing stuff that must happen for all Frames
		setSize( 300,300 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PolyDemoCopy myApp = new PolyDemoCopy();

	}
	
	//this is our first "inner" or internal class
	//the purpose of this class is solely to support the JFrame class above, and 
	//I don't want it reused in arbitrary contexts, so by nesting this class here
	//I can indicate the intent a bit more clearly that this class "goes with"
	//the class above it
	//In general, each class is a separate entity that should be contained in a
	//separate file
	public class PolyDemoPanel extends JPanel {
	ShapeCopy[] myShapes= new ShapeCopy[20];
	public PolyDemoPanel() {
	//Shape a = new Shape( getRandInt(), getRandInt());
	//Shape b = new Circle( getRandInt(), getRandInt(), getRandInt() );
	//a = new Square(getRandInt(), getRandInt(), getRandInt(),getRandInt() );
	//a = getRandShape();
	//( (Circle) b ).getRadius();
	/**********************************************************************************
	***********************************
	* Code for populating our myShapes changes minimally when new
	classes are introduced (only in getRandShape())
	***********************************************************************************
	**********************************/
	for( int i = 0; i < 20; i++ ) {
	myShapes[i] = getRandShape();
	}
	}
	/**********************************************************************************
	***********************************
	* Code for drawing our shapes doesn't change at all! Since we intended
	to take advantage of polymorphism, we coded
	* this "in general" with respect to the superclass, and not specific
	to any subclass.
	***********************************************************************************
	**********************************/
	public void paint( Graphics g ) {
	super.paint(g); //don't remove - required for GUI widgets to draw correctly
	/************************
	* Late Binding Demo
	************************/
	for( int i = 0; i < myShapes.length; i++ ){
	//which draw method is invoked here? There are many formsof the method (polymorphic), so which is chosen?
	//Java has RTTI about every object, and it uses this infoto choose the correct method to invoke!
		myShapes[i].draw( g );
	}
	}
	public int getRandInt() {
	return ( (int) ( Math.random() * 200 ) );
	}
	public ShapeCopy getRandShape() {
	ShapeCopy retVal = null;
	final int x = getRandInt();
	final int y = getRandInt();
	/********************************
	* Polymorphic extensibility demo
	*
	*******************************/
	switch( ( int )(Math.random() * 4) ) {
	case 0: retVal = new SprayCopy( x,y );//new Square( x, y, getRandInt(), getRandInt() );
	break;
	case 1: retVal = new FractalFlake(200,10);//Cube( x, y, getRandInt(), getRandInt(), getRandInt() );
	break;
	case 2: retVal = new FractalFlake(100,50);
	break;
	case 3: //retVal = new Spray( x,y );//new Circle( x,y,getRandInt() );////new Cylinder( x,y, getRandInt(), getRandInt() );
			retVal = new FractalFlake(100,100);
	break;
	
	}
	return retVal;
	}
	}

}
