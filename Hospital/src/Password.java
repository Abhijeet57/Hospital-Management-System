import java.awt.Button;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class Password extends Frame implements ActionListener
{
 TextField pass,	gender,fname,lname,cno,age,id,bill,addr;
 Button ok;	
 Password()
	{
		super("Enter Password");
        setLayout(null);
        
        pass = new TextField("");
        ok=new Button("  OK  ");
       
        pass.setEchoChar('*');
        
        pass.setBounds(160, 40, 80, 20);
        ok.setBounds(100, 80, 80, 20);
        
        ok.addActionListener(this);
        
        add(pass);
        add(ok);
        
		setSize(280,130);
	    setVisible(true);
	}
	public static void main(String[] args)
	{
		Password q = new Password();

	}

	public void paint(Graphics g)
	  {
		Font   font=new Font("TimesRoman",Font.PLAIN,20);
		g.setFont(font);
	    g.drawString("Enter Password : ",20,55); 
        
	  }
		
	
	public void actionPerformed(ActionEvent arg0)
	{
        
		String pass2="Admin";
		String pass1 = pass.getText();
		if(pass1.equals(pass2))
		 {
			try {
				Option  e=new Option();
				this.dispose();
			    } catch (Exception e)
			    {
			 
			    }
		 }
		else
		 {
			JOptionPane.showMessageDialog( this, "Incorrect Password");
			pass.setText(null);
			Home h=new Home();
		    this.dispose();
		 }
	    
	}

}

