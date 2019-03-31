package View;

import Controller.GameController;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 


public class AvengersGameView
{
	GameController gameController;

  public AvengersGameView(GameController gameController) {
	  	this.gameController=gameController;
		initGame();
		createAndShowGUI();
	}


	//constants and global variables
	final static Color COLOURBACK =  Color.WHITE;
	final static Color COLOURCELL =  Color.ORANGE;

	final static Color COLOURGRID =  Color.BLACK;	 
	final static Color COLOURONE = new Color(255,255,255,200);
	final static Color COLOURONETXT = Color.BLUE;
	final static Color COLOURTWO = new Color(0,0,0,200);
	final static Color COLOURTWOTXT = new Color(255,100,255);
	final static int EMPTY = 0;
	final static int BSIZE = 10; //board size.
	final static int HEXSIZE = 60;	//hex size in pixels
	final static int BORDERS = 15;  
	final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS*3; //screen size (vertical dimension).

//	int[][] board = new int[BSIZE][BSIZE];

	void initGame(){
		hexmech.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.

		hexmech.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
		hexmech.setBorders(BORDERS);
	}

	private void createAndShowGUI()
	{
		DrawingPanel panel = new DrawingPanel();


		//JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("Avengers End Game");
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		Container content = frame.getContentPane();
		content.add(panel);
		//this.add(panel);  -- cannot be done in a static context
		//for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
		frame.setSize( (int)(SCRSIZE/1.23), SCRSIZE);
		frame.setResizable(false);
		frame.setLocationRelativeTo( null );
		frame.setVisible(true);
	}


	class DrawingPanel extends JPanel
	{		
		//mouse variables here
		//Point mPt = new Point(0,0);

		public DrawingPanel()
		{	
			setBackground(COLOURBACK);

			MyMouseListener ml = new MyMouseListener();            
			addMouseListener(ml);
		}

		public void paintComponent(Graphics g)
		{
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			super.paintComponent(g2);
			//draw grid
			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {
					hexmech.drawHex(i,j,g2);
				}
			}
			//fill in hexes
			for (int i=0;i<BSIZE;i++) {
				for (int j=0;j<BSIZE;j++) {
					hexmech.fillHex(i,j, gameController.getGame().getBoard().getHexagon(i, j), g2);
				}
			}
		}

		class MyMouseListener extends MouseAdapter	{	//inner class inside DrawingPanel 
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY(); 
				//mPt.x = x;
				//mPt.y = y;
				Point p = new Point( hexmech.pxtoHex(e.getX(),e.getY()) );
				if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

				if(e.getButton() == MouseEvent.BUTTON1) {
					System.out.println("Left Click!");
					gameController.leftClick(p.x, p.y);
				}
//				else if(e.getButton() == MouseEvent.BUTTON3) {
//					System.out.println("Right Click!");
//					selectedHex = null;
//				}
				repaint();
			}		 
		}
	}
}