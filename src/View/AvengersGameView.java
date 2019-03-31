package View;

import Controller.GameController;
import Model.Hexagon;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 


public class AvengersGameView
{
//	private Game game;
	private GameController gameController;
	private Hexagon selectedHex;

  public AvengersGameView() {
  		this.gameController = new GameController();
		initGame();
		createAndShowGUI();
	}


	//constants and global variables
	final static Color COLOURBACK =  Color.WHITE;
	final static Color COLOURCELL =  Color.ORANGE;

	final static Color COLOURGRID =  Color.BLACK;	 
	final static Color COLOURONE = new Color(255,255,255,200);
	final static Color COLOURONETXT = Color.BLUE;
	final static Color COLOURTWOTXT = new Color(255,100,255);
	final static int BSIZE = 10; //board size.
	final static int HEXSIZE = 60;	//hex size in pixels
	final static int BORDERS = 10;
	final static int SCRSIZE = HEXSIZE * (BSIZE + 10) + BORDERS*3; //screen size (vertical dimension).


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
		JLabel lab1 = new JLabel("User Name", JLabel.LEFT);
        content.add(lab1);
        content.add(panel);
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
            g2.drawString("Attacker",350,500);

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
//					System.out.println("Left Click!");
//					gameController.leftClick(game.getBoard().getHexagon(p.x, p.y));
					if (selectedHex == null) {
						selectedHex = gameController.getGame().getBoard().getHexagon(p.x, p.y);
					}
					else {
						Hexagon targetedHex  = gameController.getGame().getBoard().getHexagon(p.x, p.y);
						gameController.movePiece(selectedHex, targetedHex);
						selectedHex = null;
					}

				}

				else if(e.getButton() == MouseEvent.BUTTON3) {
					System.out.println("Right Click!");

					if (selectedHex != null) {
						Hexagon targetedHex = gameController.getGame().getBoard().getHexagon(p.x, p.y);
						gameController.attackPiece(selectedHex, targetedHex);
					}
                }

				repaint();
			}		 
		}
	}
}