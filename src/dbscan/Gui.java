package dbscan;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

//import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.Timer;

public class Gui {
	
	public static int minpoints;
	public static int tdistance;
	public static Boolean a;
	public static int x1;
	public static int y1;
	public static int x2;
	public static int y2;
	public static Vector<Point> hset = new Vector<Point>();
	public static Vector<List> trl = new Vector<List>();
	static ArrayList<Point> temp =new ArrayList<Point>();
	private final static String newline = "\n";
	static Boolean Y = false;

	final static JTextField tfx = new JTextField(4);
	final static JTextField tfy = new JTextField(4);
	final static JLabel status = new JLabel(".");
	final static JLabel counter = new JLabel("Number of Points-" + hset.size());
	/*
	 *      FRAME
	 */
	static JFrame j1 = new JFrame("DBscan");
	
	static CardLayout card =new CardLayout();
	static JPanel wrap =new JPanel(card);
	
	public static void makeGui() {
		
		j1.add(wrap);
		j1.setBounds(250, 50, 800, 600);
		j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j1.setVisible(true);
		
		final JTextArea pta = new JTextArea(); 		pta.setEditable(false);
		final JTextArea cta = new JTextArea(); 		cta.setEditable(false);
		cta.setBorder(BorderFactory.createLineBorder(Color.black));
		
		MenuBar mbr =new MenuBar();
		Menu file =new Menu("File");
		MenuItem exit = new MenuItem("Exit");
		file.add(exit);
		mbr.add(file);
		
		j1.setMenuBar(mbr);
		
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				String str ="Exit";
					if(str.equals(ae.getActionCommand())){
				System.exit(0);
				;}
				
			}
		});

		status.setForeground(Color.BLACK);

		

		/*
		 *     ADD POINTS
		 */

		final JPanel jp = new JPanel();
		wrap.add(jp, "Add Points");
		
		jp.setLayout(new BorderLayout());
		
		JPanel jp2 = new JPanel();
		jp.add(jp2, BorderLayout.EAST);
		final  JPanel jp1 = new JPanel();
		jp.add(jp1, BorderLayout.CENTER);
		

		jp2.setLayout(new GridLayout(0,1));

		JButton enter = new JButton("Add Points");
		JButton reset = new JButton("Reset");
		JButton applydbscan = new JButton("Apply DBscan");
		
		
		enter.setAlignmentX( 0);
		reset.setAlignmentX(0);
		applydbscan.setAlignmentX(0);
		
		jp2.add(enter);
		jp2.add(reset);
		jp2.add(applydbscan);
		
		JButton clearpl = new JButton("Clear All");
		jp2.add(clearpl);

		
		JPanel lowerbar =new JPanel();
		jp.add(lowerbar,BorderLayout.SOUTH);
		lowerbar.setLayout(new BoxLayout(lowerbar,BoxLayout.X_AXIS));
		lowerbar.add(status);
		lowerbar.add(Box.createHorizontalGlue());
		lowerbar.add(counter);
		
		jp2.setBorder(BorderFactory.createLineBorder(Color.black));
		
		JPanel jp11 = new JPanel();
		jp11.setLayout(new BoxLayout(jp11, BoxLayout.Y_AXIS));
		JPanel pl1 =new JPanel();
		
		pl1.setBorder(BorderFactory.createLineBorder(Color.black));
		JLabel l1 = new JLabel("Enter Points");
		JLabel comma = new JLabel(",");

		jp1.setLayout(new BoxLayout(jp1, BoxLayout.Y_AXIS));
		l1.setAlignmentX((float) 0.5);
		pl1.add(l1);
		pl1.add(Box.createHorizontalGlue());
		pl1.add(l1);
		pl1.add(Box.createHorizontalGlue());
		jp1.add(pl1);
		

		JPanel jpp1 = new JPanel();
		JLabel x = new JLabel("X Coordinate");
		JLabel y = new JLabel("Y Coordinate");
		jp11.add(Box.createVerticalGlue());
		jpp1.add(x);
		jpp1.add(comma);
		jpp1.add(y);
		JPanel jpp2 = new JPanel();
		jpp2.add(tfx);
		jpp2.add(comma);
		jpp2.add(tfy);
		jp11.setBorder(BorderFactory.createLineBorder(Color.black));
		jp11.add(jpp1);
		jp11.add(jpp2);
		jp11.add(Box.createVerticalGlue());
		jp1.add(jp11);

		// Output Panel

		
		
		final JPanel ojp = new JPanel();
		ojp.setLayout(new BorderLayout());
		

		wrap.add(ojp,"Output");
		
		
		
		JPanel ojp2 = new JPanel();
		ojp.add(ojp2, BorderLayout.EAST);
		
		final JPanel ojp1 = new JPanel();
		
		//ojp.add(ojp1, BorderLayout.CENTER);

		ojp2.setLayout(new GridLayout(0,1));

		JButton oenter = new JButton("Add More Points");
		ojp2.add(oenter);
		
		JButton pointl = new JButton("PointsList");
		ojp2.add(pointl);
		ojp2.add(Box.createVerticalGlue());
		ojp2.add(Box.createVerticalGlue());
		
		ojp2.setBorder(BorderFactory.createLineBorder(Color.black));

		

		final JPanel txtpanel = new JPanel();
		txtpanel.setLayout(new BoxLayout(txtpanel, BoxLayout.Y_AXIS));
		//ojp.add(txtpanel, BorderLayout.WEST);
		JScrollPane jsp1 =new JScrollPane(txtpanel);
		jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		ojp.add(jsp1,BorderLayout.WEST);
		
		final JPanel cluster = new JPanel();

		cluster.setLayout(new BoxLayout(cluster, BoxLayout.Y_AXIS));
		cluster.setBorder(BorderFactory.createLineBorder(Color.black));
		ojp1.add(cluster);
		
		JScrollPane jsp =new JScrollPane(ojp1);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener(){

			
			public void adjustmentValueChanged(AdjustmentEvent ae) {
			
				if (ae.getValueIsAdjusting()) {
		            cluster.revalidate();
		        }
				
			}
			
		});

		ojp.add(jsp,BorderLayout.CENTER);
		
		
		/*
		 * 			GETTING INPUT VARIABLES
		 */
		
		JPanel var =new JPanel();
		var.setLayout(new BoxLayout(var ,BoxLayout.Y_AXIS));
		JPanel var1 =new JPanel();
		JPanel var2 =new JPanel();
		JLabel varl1 =new JLabel ("Minimum Points");
		JLabel varl2 =new JLabel ("Threshold Distance");
		final JTextField tvar1 =new JTextField(4);
		final JTextField tvar2 =new JTextField(4);
		JButton submit = new JButton("Submit");
		
		var1.add(varl1); var1.add(tvar1);
		var2.add(varl2); var2.add(tvar2);
		var.add(Box.createVerticalGlue());
		var.add(var1); var.add(var2); var.add(submit);
		var.add(Box.createVerticalGlue());
		
		var.setBorder(BorderFactory.createLineBorder(Color.black));		
		wrap.add(var, "Variables");
		card.show(wrap, "Variables");
		
		/*
		 * Submit Listener
		 */
		
		submit.addActionListener(new ActionListener(){

				public void actionPerformed(ActionEvent ae) {
					String str = "Submit";
					if ((str.compareTo(ae.getActionCommand()) == 0)) {
						minpoints = Integer.parseInt(tvar1.getText());
						tdistance = Integer.parseInt(tvar2.getText());
				
						card.show(wrap, "Add Points");
				
			}
			}});
		
		
		
		/*
		 * ADD MORE POINTS BUTTON LISTENER
		 */

		oenter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String str = "Add More Points";
				if ((str.compareTo(ae.getActionCommand()) == 0)) {
					// output.setVisible(false);
					
					jp.revalidate();
					card.show(wrap, "Add Points");

				}
			}
		});
		
		
		/*
		 * ClearBUTTON LISTENER
		 */

		clearpl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String str = "Clear All";
				if ((str.compareTo(ae.getActionCommand()) == 0)) {
					
					hset.clear();
					dbscan.pointList.clear();
					dbscan.resultList.clear();
					Utility.VisitList.clear();
					counter.setText("Number of Points-" + Integer.toString(hset.size()));
					status.setText("PointList Cleared");
					tfx.setText(null);
					tfy.setText(null);
					jp.revalidate();
					card.show(wrap, "Add Points");

				}
			}
		});
		/*
		 * RESET BUTTON LISTENER
		 */

		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String str = "Reset";
				if ((str.compareTo(ae.getActionCommand()) == 0)) {
					tfx.setText(null);
					tfy.setText(null);
					status.setText(null);
				}
			}
		});

		/*
		 * ADD POINTS BUTTON LISTENER
		 */

		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String str = "Add Points";
				if ((str.compareTo(ae.getActionCommand()) == 0)) {

					addpoints();
				}
			}
		});

		/*
		 * POINTS LIST LISTENER
		 */

		pointl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String str = "PointsList";
				if ((str.compareTo(ae.getActionCommand()) == 0)) {
					int i = 0;
					pta.setText("");
					txtpanel.add(pta);
					
					pta.append("Points" + newline + "------" + newline);
					Iterator<Point> pitr = hset.iterator();
					while (pitr.hasNext()) {
						Point pp = pitr.next();

						pta.append(pp.getX() + "," + pp.getY() + newline);

						i++;
					}
					pta.setFocusable(true);
					
					txtpanel.revalidate();
					ojp.revalidate();
				}
			}
		});

		/*
		 * APPLY DBSCAN BUTTON LISTENER
		 */

		applydbscan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String str = "Apply DBscan";
				if ((str.compareTo(ae.getActionCommand()) == 0)) {

					cluster.removeAll();
					pta.setText(null);
					trl.clear();
					trl.addAll(dbscan.applyDbscan());

					int index1 = 0;
					
					for(List l : trl){
												
						cluster.add(new Label("Cluster  :" + (index1 + 1)));
						
						Iterator<Point> j = l.iterator();
						while (j.hasNext()) {
							Point w = j.next();
							cluster.add(new Label((w.getX() + "," + w.getY())));
						}
						cluster.add(new Label("***************"));
						index1++;

					}

					
					card.show(wrap, "Output");
					
					cluster.revalidate();

				}
			}
		});

	}

	public static void addpoints() {
		
		try{
		x1 = Integer.parseInt(tfx.getText());
		y1 = Integer.parseInt(tfy.getText());
		a=true;}
		catch(Exception e){a= false;
		}
		Point np = new Point(x1, y1);
		
		if (a){
		for(Point f : hset){
			
		if (Utility.equalPoints(f, np)) {
				Y = true;
				break;
			} else
				{Y = false;}
		
		}

		if (!Y) {
			hset.add(np);
			status.setText("Point " + x1 + "," + y1 + " Added");
			status.setForeground(Color.BLUE);
			counter.setText("Number of Points-" + Integer.toString(hset.size()));
			tfx.setText(null);
			tfy.setText(null);
			
		}
		if (Y) {
			status.setText("Point " + x1 + "," + y1 + " Already Exists");
			tfx.setText(null);
			tfy.setText(null);
			status.setForeground(Color.BLACK);

		}
	}
		  else {
			  status.setText("Wrong Input");
			  status.setForeground(Color.RED);
			  tfx.setText(null);
			  tfy.setText(null); 
		 }
		}
		 

	
/*
	public static void homeScreen() {
		final JFrame home = new JFrame("DBscan");
		JPanel h1 = new JPanel();
		home.setBounds(250, 50, 800, 600);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		home.add(h1);
		
		
		java.net.URL imageURL = Gui.class.getResource("eag.gif");
		ImageIcon icon = new ImageIcon(imageURL);
		JLabel jlb = new JLabel(icon);
		h1.setBackground(Color.BLACK);
		h1.add(jlb);
		home.pack();
		home.setVisible(true);
		Timer t = new Timer();
		TimerTask t1 = new TimerTask() {

			@Override
			public void run() {
				
				home.setVisible(false);
				makeGui();
			}
		};
		t.schedule(t1, 3000);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException exc) {
		}
		t1.cancel();
	}
*/
	public static void main(String args[]) {
		
		makeGui();
		

	}
}


