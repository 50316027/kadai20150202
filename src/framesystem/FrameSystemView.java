package framesystem;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class FrameSystemView extends Frame implements ActionListener,WindowListener,KeyListener{

	private Button button1 = new Button("表示");
	CardLayout cardlayout;
	Panel panel1;
	Panel panel2;
	
	public FrameSystemView(FrameSystemController controller) {	
		// TODO Auto-generated constructor stub
		panel1 = new Panel();
		panel2 = new Panel();
		addWindowListener(this);
		setTitle("TOKYO TEMPERETURE");
		cardlayout = new CardLayout();
		setLayout(cardlayout);
		panel2.add(button1,BorderLayout.CENTER);
		add(panel2);
		add(panel1);
		button1.addActionListener(this);

	 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int month;
		double maxtempereture,monthlytempereture,mintempereture;
		ResultSet rs;
		lib.MySQL mysql = new lib.MySQL();
		rs = mysql.selectAll();
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		try{
			while(rs.next()){
				month = rs.getInt("Month");
				maxtempereture = rs.getDouble("MaxTempereture");
				monthlytempereture = rs.getDouble("MonthkyTempereture");
				mintempereture = rs.getDouble("MinTempereture");
                System.out.println("月：" + month);
                System.out.println("最高気温：" + maxtempereture);
                System.out.println("月間平均気温：" + monthlytempereture);
                System.out.println("最低気温：" + mintempereture);
                 data.addValue(maxtempereture,"MaxTempereture",month+"");
                 data.addValue(monthlytempereture,"MonthlyTempereture",month+"");
                 data.addValue(mintempereture,"MinTempereture",month+"");
		     }
		}catch(SQLException et){}
		 JFreeChart chart = 
			        ChartFactory.createLineChart("TOKYO TEMPERETURE",
			                             "month",
			                             "tempereture",
			                             data,
			                             PlotOrientation.VERTICAL,
			                             true,
			                             false,
			                             false);
                

        ChartPanel cpanel = new ChartPanel(chart);
        panel1.add(cpanel);
        cardlayout.next(this);
	}


	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}