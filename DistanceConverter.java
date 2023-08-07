// Using return methods to create an imperial-metric distance converter

import hsa.Console;
import java.awt.*;

// DistanceConverter class
public class DistanceConverter
{
    // declaration statements
    // c; instance variable for Console object
    // choice; stores user character input for distance conversion choice
    // distance; stores double value for distance amount to convert
    // from; stores String value for what unit to convert from
    // to; stores String value for what unit to convert to
    private Console c;
    private char choice;
    private double distance;
    private String from;
    private String to;
    
    // DistanceConverter class constructor; creates new console object for output display
    public DistanceConverter()
    {
	c = new Console("Distance Converter");
    }
    
    
    // title method; prints program title on a clear screen
    private void title()
    {
	c.clear();
	c.print(' ',30);
	c.println("Distance Converter");
	c.println();
    }
    
    
    // pauseProgram method; pauses program and waits for user key input to continue
    private void pauseProgram()
    {
	c.println();
	c.println("(Press any key to continue)");
	c.getChar();
    }
    
    
    // splashScreen method; displays program splash screen for 5 seconds
    public void splashScreen()
    {
	// colour variables
	Color blue = new Color(59, 190, 255);
	Color purple = new Color(146, 68, 242);
	Color pink = new Color(245, 112, 255);
	Color darkBlue = new Color(0, 121, 214);
	
	c.setTextBackgroundColor(blue);
	c.clear();
	c.setColor(purple);
	c.drawRect(125,165,400,150);
	c.setColor(pink);
	c.drawRect(135,155,400,150);
	c.setColor(darkBlue);
	c.fillOval(140,330,20,20);
	c.fillOval(190,330,20,20);
	c.fillOval(240,330,20,20);
	c.fillOval(290,330,20,20);
	c.fillOval(340,330,20,20);
	c.fillOval(385,325,35,35);
	c.fillOval(440,330,20,20);
	c.fillOval(490,330,20,20);
	c.setColor(Color.white);
	c.setFont(new Font("Century Gothic", 1, 38));
	c.drawString("Distance Converter",150,250);
	c.setTextBackgroundColor(Color.white);
	try
	{
	    Thread.sleep(5000);
	}
	catch(Exception e)
	{
	}
    }
    
    
    // instructions method; prints program introduction
    public void instructions()
    {
	title();
	
	c.println("Welcome to the Distance Converter!");
	c.println("This program converts distances between imperial and metric units.");
	c.println("Imperial units: feet, inches");
	c.println("Metric units: metres, centimetres");
	c.println();
	c.println("Note: conversions can only be imperial-metric or metric-imperial.");
	
	pauseProgram();
    }
    
    
    // mainMenu method; displays distance conversion choices and prompts user for their conversion choice
    public void mainMenu()
    {
	// run; stores boolean value for program loop control    
	// ask; stores boolean value for local error handling loop control
	boolean run = true;
	boolean ask;
	
	while(run)
	{
	    ask = true;
	    
	    title();
	    
	    // displays distance conversion choices
	    c.println("What would you like to convert?");
	    c.println("(a) metres to feet");
	    c.println("(b) metres to inches");
	    c.println("(c) centimetres to feet");
	    c.println("(d) centimetres to inches");
	    c.println("(e) feet to metres");
	    c.println("(f) feet to centimetres");
	    c.println("(g) inches to metres");
	    c.println("(h) inches to centimetres");
	    
	    // prompts user for conversion choice
	    while(ask)
	    {
		choice = c.readChar();
		
		if(choice != 'a' && choice != 'b' && choice != 'c' && choice != 'd' && choice != 'e' && choice != 'f'
		&& choice != 'g' && choice != 'h')
		{
		    title();
		    c.println("What would you like to convert?");
		    c.println("(a) metres to feet");
		    c.println("(b) metres to inches");
		    c.println("(c) centimetres to feet");
		    c.println("(d) centimetres to inches");
		    c.println("(e) feet to metres");
		    c.println("(f) feet to centimetres");
		    c.println("(g) inches to metres");
		    c.println("(h) inches to centimetres");
		    c.println("Invalid choice. Please enter a valid choice.");
		}
		else
		{
		    ask = false;
		}
	    }
	    
	    // assigns from and to to their corresponding unit values based on user conversion choice
	    switch(choice)
	    {
		case 'a':
		    from = "metres";
		    to = "feet";
		    break;
		case 'b':
		    from = "metres";
		    to = "inches";
		    break;
		case 'c':
		    from = "centimetres";
		    to = "feet";
		    break;
		case 'd':
		    from = "centimetres";
		    to = "inches";
		    break;
		case 'e':
		    from = "feet";
		    to = "metres";
		    break;
		case 'f':
		    from = "feet";
		    to = "centimetres";
		    break;
		case 'g':
		    from = "inches";
		    to = "metres";
		    break;
		case 'h':
		    from = "inches";
		    to = "centimetres";
	    }
	    
	    askData();
	}
    }
    
    
    // askData method; prompts user for distance amount to convert
    public void askData()
    {
	// distanceStr; stores user String input that is parsed into type double for valid double input check
	// ask; stores boolean value for local error handling loop control
	String distanceStr;
	boolean ask = true;
	
	title();
	
	c.println("Enter distance in " + from + ":");
	while(ask)
	{
	    try
	    {
		distanceStr = c.readLine();
		distance = Double.parseDouble(distanceStr);
		ask = false;
	    }
	    catch(Exception e)
	    {
		title();
		c.println("Enter distance in " + from + ":");
		c.println("Invalid distance. Please enter a valid distance.");
	    }
	}
	
	display();
    }
    
    
    // convertDistance method; calculates converted result based on parameters and returns double value of result
    private double convertDistance(double a, char b)
    {
	// result; stores double value of converted distance
	double result = 0;
	
	// conversion calculation
	switch(b)
	{
	    case 'a':
		result = a * 3.28084;
		break;
	    case 'b':
		result = a * 39.3701;
		break;
	    case 'c':
		result = a * 0.0328084;
		break;
	    case 'd':
		result = a * 0.393701;
		break;
	    case 'e':
		result = a * 0.3048;
		break;
	    case 'f':
		result = a * 30.48;
		break;
	    case 'g':
		result = a * 0.0254;
		break;
	    case 'h':
		result = a * 2.54;
	}
	
	return result;            
    }
    
    
    // display method; displays final output statement with converted result along with original input
    public void display()
    {
	// loop; stores user String input for program loop control
	// ask; stores boolean value for local error handling loop control
	String loop;
	boolean ask = true;
	
	title();
	
	// final output statement
	c.print(distance + " " + from + " = ");
	c.print(convertDistance(distance, choice),0,2);
	c.println(" " + to);
	
	pauseProgram();
	
	// prompts user for whether they wish to continue or exit the program
	c.println();
	c.println("Would you like to convert another distance?");
	while(ask)
	{
	    loop = c.readLine();
	    
	    if(loop.equals("yes"))
	    {
		choice = ' ';
		distance = 0;
		from = "";
		to = "";
		ask = false;
	    }
	    else if(loop.equals("no"))
	    {
		goodbye();
	    }
	    else
	    {
		title();
		c.print(distance + " " + from + " = ");
		c.print(convertDistance(distance, choice),0,2);
		c.println(" " + to);
		c.println();
		c.println("(Press any key to continue)");
		c.println();
		c.println("Would you like to convert another distance?");
		c.println("Invalid response. Please enter a valid response.");
	    }
	}
    }
    
    
    // goodbye method; displays program exit screen
    public void goodbye()
    {
	title();
	
	c.println("Exited program.");
	c.println("Thank you for using the Distance Converter.");
	c.println("Goodbye!");
	
	pauseProgram();
	System.exit(0);
    }
    
    
    // main method; executes program
    public static void main(String[] args)
    {
	DistanceConverter d = new DistanceConverter();
	d.splashScreen();
	d.instructions();
	d.mainMenu();
    }
}
