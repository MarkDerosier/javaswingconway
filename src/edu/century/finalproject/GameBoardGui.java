package  edu.century.finalproject;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.layout.GridPane;

public class GameBoardGui<Grid> extends JFrame implements MouseListener, ActionListener {
	private int gbWidth = 800;
	private int gbHeight = 800;
	private int gridWidth = 50;
	private int gridHeight = 50;
	private static final int cellSize = 10;
	//private JPanel gridPanel = new JPanel();
	private JPanel topPanne = new JPanel();
	private JPanel bottomPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JLabel cBoxLabel = new JLabel("Moves Per Second");
	private int selectedMovesPerSecond = 1;
	private JButton startBtn = new JButton("Start");
	private JButton stopBtn = new JButton("Stop");
	//private JButton[][] gridButtons;
	private ArrayList<Point> point = new ArrayList<Point>(0);
	public GameBoardGui(String title, int width, int length) {
		super(title);
		setSize(gbWidth, gbHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);
		//mainPanel.setLayout(new GridLayout(2,1));
		//ArrayList<Point> point = new ArrayList<Point>(0);
		//mainPanel.add(bottomPanel);
		//add(mainPanel);
		createBottomPanel(BorderLayout.SOUTH); 
		
		
		//gridPanel.setBackground(Color.BLUE);
		
		//gridPanel.setLayout(new GridLayout(width, length));
		
	/*	gridPanel.setLayout(new GridLayout(width,length)); //set layout
        gridButtons = new JButton[width][length]; //allocate the size of grid
        for(int y = 0; y < length; y++){
                for(int x = 0; x < width; x++){
                        gridButtons[x][y] = new JButton(); //creates new button     
                        
                        gridPanel.add(gridButtons[x][y]); //adds button to grid
                        
                }
           }      */
      }

public void createBottomPanel(String south) {
	JPanel bottomPanel = new JPanel();
	//bottomPanel.setLayout(new FlowLayout());
	bottomPanel.add(startBtn);
	startBtn.addActionListener(this);
	bottomPanel.add(stopBtn);
	stopBtn.addActionListener(this);
	
	bottomPanel.add(new JLabel("Moves Per Second"));
	Integer[] movesPerSecondArray = {1,2,3,5,10,20};
	JComboBox movesPerSecond = new JComboBox(movesPerSecondArray);
	
	movesPerSecond.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
            selectedMovesPerSecond = (Integer)movesPerSecond.getSelectedItem();
           System.out.println(movesPerSecond);
        }
    });
	
	bottomPanel.add(movesPerSecond);
	add(bottomPanel);
}

public void createTopPanel(String north) {
	JPanel topPanel = new JPanel();
	//topPanel.add(paint(Graphics g));
}
@Override
	public void paint(Graphics g) {
    super.paint(g);
    try {// color a selected cell
        for (Point newCellArea : point) {
            g.setColor(Color.blue);
            g.fillRect(cellSize + (cellSize*newCellArea.x), cellSize + (cellSize*newCellArea.y), cellSize, cellSize);
        }
    } catch (ConcurrentModificationException cme) {}
    // Set up the grid
    g.setColor(Color.BLACK);
    for (int i=0; i<=gridWidth; i++) {
        g.drawLine(((i * cellSize) + cellSize), cellSize, (i * cellSize) + cellSize, cellSize + (cellSize * gridHeight));
    }
    for (int i=0; i<=gridHeight; i++) {
        g.drawLine(cellSize, ((i * cellSize) + cellSize), cellSize * (gridWidth+1), ((i * cellSize) + cellSize));
    }
}

private void updateArraySize() {
    ArrayList<Point> removeList = new ArrayList<Point>(0);
    for (Point current : point) {
        if ((current.x > gridWidth-1) || (current.y > gridHeight-1)) {
            removeList.add(current);
        }
    }
    point.removeAll(removeList);
    repaint();
}

public void addPoint(int x, int y) {
    if (!point.contains(new Point(x,y))) {
        point.add(new Point(x,y));
    } 
    repaint();
}

@Override
public void mouseClicked(MouseEvent e) {
	int x = e.getPoint().x/cellSize - 1;
	int y = e.getPoint().y/cellSize - 1;
	 if ((x >= 0) && (x < gridWidth) && (y >= 0) && (y < gridHeight)) {
         addPoint(x,y);
         System.out.println("X: " + x + "\tY: " + y);
    
     }
	
	
}

public void removePoint(int x, int y) {
    point.remove(new Point(x,y));
}

@Override
public void mouseEntered(MouseEvent e) {
	System.out.println("Mouse entered. ");
	
}

@Override
public void mouseExited(MouseEvent e) {
	System.out.println("Mouse exited. ");
	
}

@Override
public void mousePressed(MouseEvent e) {
	
	System.out.println("Mouse pressed. ");
	
}

@Override
public void mouseReleased(MouseEvent e) {
	System.out.println("Mouse released. ");
	
}

public static void main(String[] args) {
	GameBoardGui gui = new GameBoardGui("Game Board", 25, 25);
	gui.setVisible(true);
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}


	      
	      
	    
	    
	    
	


}
//try {
  //  Thread.sleep(1000/selecteMovesPerSecond);
    //run();
//} catch (InterruptedException ex) {}
//}

