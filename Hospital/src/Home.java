import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.UnknownHostException;


public class Home extends Frame implements ActionListener{
	
	Button newentry,bill,logout,option; 
	
	Home()
	{
		super("Home");
		setLayout(null);
		
		newentry = new Button(" New Entry ");
		bill = new Button(" Bill Amount  ");
		logout = new Button(" Log Out ");
		option =new Button(" Option ");
		
		newentry.setBounds(210, 170, 90, 30);
		bill.setBounds(210, 240, 90, 30);
		logout.setBounds(210, 380, 90, 30);
		option.setBounds(210, 310, 90, 30);
		
		newentry.addActionListener(this);
		bill.addActionListener(this);
		logout.addActionListener(this);
		option.addActionListener(this);
		
		add(newentry);
		add(bill);
		add(logout);	
	    add(option);
		
		setSize(500,500);
		setVisible(true);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose();
			}
		});
	}
	


	public static void main(String[] args) {
       Home home=new Home();

	}
	
	
	 public void paint(Graphics g) {
			Font   font=new Font("TimesRoman",Font.BOLD,30);
			g.setFont(font); 
	 
			g.drawString(" WELCOME ",170,100);	 
	 }

	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()== newentry)
		{ 
		
		    NewEntry login=new NewEntry();
		    this.dispose();
			
		}
		else if(e.getSource()==bill)
		{
		      Bill b=new Bill();
		      this.dispose();
		}
		else if(e.getSource()==option)
		{
			Password p=new Password();
	        this.dispose();
		}
		else
		{
			Login home=new Login();
			this.dispose();
		}	
		
	}
		
		
	}
	 
	 


