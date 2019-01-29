import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;


public class Option extends Frame implements ActionListener
 {

	Button search,home,delete;
	TextField fname,lname,cno,age,id,bill,gender;
	TextArea addr;
	public Option()
	{
		
		super(" Option ");
		setLayout(null);
		
		search = new Button("   Search   ");
		delete = new Button("   DELETE   ");
		home = new Button("   HOME   ");
		addr = new TextArea("",3,100,0);
	    id = new TextField();
	    fname = new TextField("        ");
	    lname = new TextField("        ");
	    age = new TextField("       ");
	    cno = new TextField("       ");
	    bill= new TextField("  ");
	    gender= new TextField("  "); 
	    
	    id.setBounds(170, 115, 80, 20);
		addr.setBounds(170, 300, 160, 80);
		fname.setBounds(170, 177, 80, 20);
		lname.setBounds(440, 177, 80, 20); 
		age.setBounds(440, 240, 50, 20);
		cno.setBounds(440,295,100,20);
		gender.setBounds(170,240,80,20);
	   	bill.setBounds(170,420, 100, 20);
		
		addr.disable();
		age.disable();
		fname.disable();
		lname.disable();
		gender.disable();
	    cno.disable();
		bill.disable();
		
		addWindowListener(new WindowAdapter() 
		   {
			 public void windowClosing(WindowEvent we)
			   {
				dispose();
		   	   }
		   });
	    
	    home.setBounds(80, 500, 80, 30);
	    home.addActionListener(this);
	    
	    search.setBounds(200, 500, 80, 30);
	    search.addActionListener(this);
	    
	    delete.setBounds(320, 500, 80, 30);
	    delete.addActionListener(this);
	    
	    add(home);
	    add(addr);
	  	add(id);
		add(fname);
		add(lname); 
		add(age); 
		add(cno); 
		add(bill);
		add(gender);
		add(search);
		add(delete);
		setSize(600,650);
		setVisible(true);
	
	}

	
	public void delete() throws Exception
	{
		String a=id.getText();
		MongoClient clientobj = new MongoClient("localhost",27017); 
		DB db = clientobj.getDB("Hospital");
		DBCollection Patient = db.getCollection("Patient");
		DBObject query =new BasicDBObject();
		query.put("Id",a);
		DBCursor Cursor = Patient.find(query);
		query = Cursor.next();
		Patient.remove(query);
		DBCollection Bill = db.getCollection("Bill");
		DBObject query1 =new BasicDBObject();
		query1.put("Id",a);
		Bill.remove(query1);
		
		fname.setText(null);
		lname.setText(null);
		cno.setText(null);
		age.setText(null);
		id.setText(null);
		bill.setText(null);
		addr.setText(null);
		gender.setText(null);
		JOptionPane.showMessageDialog( this, "Record Successfully Deleted");
		
	}
	
	
public void Retrieve() throws Exception
	{
		String a=id.getText();
		MongoClient clientobj = new MongoClient("localhost",27017); 
		DB db = clientobj.getDB("Hospital");
		DBCollection Patient = db.getCollection("Patient");
		DBObject query =new BasicDBObject();
		query.put("Id",a);
		
		DBCursor Cursor = Patient.find(query);
		
		query = Cursor.next();
		

		Object name = query.get("First Name");
		fname.setText((String)name);
		Object gender1 = query.get("Gender");
		gender.setText((String)gender1);
		Object lsname = query.get("Last Name");
		lname.setText((String)lsname);
		Object add1 = query.get("Address");
		addr.setText((String)add1);
		Object con1 = query.get("Contact");
		cno.setText((String)con1);
		Object age1 = query.get("Age");
		age.setText((String)age1);
		
		
		DBCollection Bill = db.getCollection("Bill");
		DBObject query1 =new BasicDBObject();
		query1.put("Id",a);
	    DBCursor Cursor1 = Bill.find(query1);
		query1 = Cursor1.next();
	    Object name1 = query1.get("Bill");
		bill.setText((String)name1);
		
		
   	}

	
	 public static void main(String[] args)
	 {

         Option op=new Option();
	 }
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
	
	   if(e.getSource()==search)
		  {
		 
			try 
			 {
			   	Retrieve();
		     } 
			catch (Exception e1) 
			{
			fname.setText(null);
			lname.setText(null);
			cno.setText(null);
			age.setText(null);
			id.setText(null);
			bill.setText(null);
			addr.setText(null);
			gender.setText(null);	
			JOptionPane.showMessageDialog(this,"No Record Found");
			System.out.println(e1);
			}
		  } 
		else if(e.getSource()==delete)
		  { 
		    try
		     {
			   delete();
		     }
		    catch (Exception e1) 
		    {
			 JOptionPane.showMessageDialog(this,"No Record Found");
			 System.out.println(e1);
		    }
		  }
	    else 
	      {
	          Home home1=new Home();
	          this.dispose();
	      }
			
	}
	
public void paint(Graphics g)
    {
			Font font=new Font("TimesRoman",Font.PLAIN,20);
			g.setFont(font); 
			setBackground(Color.white);
			g.drawString(" Patient_Id : ",62,128);
			g.drawString("First Name : ",60, 190);
			g.drawString("Last Name : ",335, 190);
		    g.drawString("Address : ",83,310);
			g.drawString("Contact : ",360,310);
			g.drawString("Gender : ",90, 255);
			g.drawString("Age : ",388,255);
			g.drawString("Bill : ",118,435);
			      		
	 }
}


