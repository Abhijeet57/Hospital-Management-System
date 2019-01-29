
	import java.awt.Button;
	import java.awt.Checkbox;
	import java.awt.CheckboxGroup;
	import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
	import java.awt.FlowLayout;
	import java.awt.Font;
	import java.awt.Frame;
import java.awt.Graphics;
	import java.awt.Label;
import java.awt.Panel;
	import java.awt.TextArea;
	import java.awt.TextField;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.TextEvent;
	import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AttributeSet.ColorAttribute;


	public class Login  extends Frame implements ActionListener
	{
		 
		
		Button login,field1;
		JLabel label;
		TextField field;
		Login()
		{
			super("Login Page");
	        setLayout(null);
	        label=new JLabel(); 
		    login=new Button("        Login       ");
		    field1=new Button("        home       ");
		    field=new TextField(30);
	
	        field.setEchoChar('*');
	        setBackground(Color.gray);
	        login.setBounds(200,430,100,30);
	        field.setBounds(220,355,130,20);
	        field1.setBounds(220,325,130,20);	        
	    
	        
	        
	        add(login);
	        add(field);
	        add(field1);
		    
	        login.addActionListener(this);
		    
		    	   
				  
		    setSize(500,500);
		    setVisible(true);
		   
		    
		    addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					dispose();
				}
			});
		    
		}

		public static void main(String args[]) {
			Login obj=new Login();
			
		}

		public void actionPerformed(ActionEvent arg0) {
			boolean check = false;
			String password;
			String pass="Admin123";
			password = field.getText();
			if(password.equals(pass))
			{
				Home newentry =new Home();	
				this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog( this, "Incorrect Password");
				field.setText(null);
			}
		
			
		}

		
		public void paint(Graphics g) {
                  
	    Font   font=new Font("TimesRoman",Font.BOLD,20);
		g.setFont(font);
		setBackground(Color.black);
	    g.drawString("Password : ",120,370);
	    g.drawString("User : ",120,350);
	    
	    Font   font1=new Font("TimesRoman",Font.BOLD,40);
	    g.setFont(font1);
	    g.drawString("OM HOSPITAL",120,80); 
	  
	    
		}
		
		

		 
	}



