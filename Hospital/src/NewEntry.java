import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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
import java.net.UnknownHostException;
import java.util.GregorianCalendar;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import com.mongodb.*;



public class NewEntry extends Frame implements ActionListener
{
  private static final Color RED =null;
  Label g;
  String s;
  Button submit,back;
  TextField fname,lname,cno,age;
  TextField id;
  ButtonGroup group;
  JRadioButton male,female;
  TextArea area;
  
  NewEntry() 
	{
		super("NewEntry");
		setLayout(null);
		submit = new Button("   SUBMIT   ");
		back = new Button("   BACK   ");
	    area = new TextArea("",3,100,0);
	    
	    fname = new TextField();
	    lname = new TextField();
	    age = new TextField();
	    cno = new TextField();
	    id = new TextField();
	    g = new Label();
	   	group =new ButtonGroup();
	    male=new JRadioButton("Male");
		female=new JRadioButton("Female");
		group.add(male);
		group.add(female);
		male.setBounds(200, 248, 60, 20);
		female.setBounds(200,270 , 80,25);
		area.setBounds(200, 350, 150, 70);
		fname.setBounds(200, 150, 80, 20);
		lname.setBounds(200, 200, 80, 20); 
		age.setBounds(200, 315, 50, 20);
		cno.setBounds(200,430,100,20);
	    g.setBounds(200,460,20,20);
		id.setBounds(390,150, 55, 20);	
		
	    submit.setBounds(400, 450, 80, 30);
	    submit.addActionListener(this);
	    
	    back.setBounds(300, 450, 80, 30);
	    back.addActionListener(this);
	    
	    add(submit);
        add(back);
	    add(area);
	  	add(male);
		add(female);
		add(id);
		add(fname);
		add(lname); 
		add(age); 
		add(cno); 
		add(g);
		try{
			
		int a=assign_id();
		id.setText(String.valueOf(a));
		}catch (Exception e) {
			// TODO: handle exception
		}
		//id.disable();
		setSize(500,500);
		setVisible(true);
		
	    
		
					
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				dispose(); 
					
			}
		});
			
		
	}
	public void saveData() throws Exception
	{
		MongoClient clientobj = new MongoClient("localhost",27017); 
		DB db = clientobj.getDB("Hospital");
		DBCollection Patient = db.getCollection("Patient");
		BasicDBObject query = new BasicDBObject();
		query.append("Id",id.getText());
		query.append("First Name",fname.getText());
		query.append("Last Name",lname.getText());
		query.append("Address",area.getText());
		query.append("Age",age.getText());
		
		
		String sex;
		if(male.isSelected())
		{
			sex = "male";
		}
		else
		{
			sex = "female";
		}
		query.append("Gender",sex);
		query.append("Contact",cno.getText());
		GregorianCalendar g1=new GregorianCalendar();
		String s=g1.getTime().toString();
		query.append("Date",s);
		Patient.insert(query);
	}
	
	
	public int assign_id()
	{
		
		try {
			int val=0;
			MongoClient clientobj = new MongoClient("localhost",27017);
			DB db = clientobj.getDB("Hospital");
			DBCollection Patient = db.getCollection("Patient");
			BasicDBObject query = new BasicDBObject();
		
			query.put("Id", -1);
			DBCursor Cursor = Patient.find().sort(query).limit(1);
			DBObject x=Cursor.next();
			val =Integer.parseInt((String)x.get("Id"));
			return val+1;
		
		    }
		catch (UnknownHostException e)  
		    {
			System.out.println(e);
			return 1;
	    	} 
	
	}   
	
	public static void main(String[] args)  
	{
	    NewEntry obj = new NewEntry();	
	}
	
	public void actionPerformed(ActionEvent e) 
	 {
      
		if(e.getSource()== submit)
		 {
			

			try {
				saveData();
			    }
			catch (Exception e1)
			   {
				System.out.println(e1);
			   }
			JOptionPane.showMessageDialog(this,"Record Succesfully Saved");	
			fname.setText(null);
			lname.setText(null);
			cno.setText(null);
			age.setText(null);
			area.setText(null);
			int a=assign_id();
			id.setText(String.valueOf(a));
		}
		else
		{
		Home home=new Home();
		this.dispose();
		}
	
	 }
   
	public void paint(Graphics g) 
	{
	  Font font=new Font("TimesRoman",Font.PLAIN,20);
		g.setFont(font); 
		setBackground(Color.white);
	    g.drawString("First Name : ",80, 165);
	    g.drawString("Last Name  : ",80, 215);
	    g.drawString("Address : ",100,365);
	    g.drawString("Contact : ",110,445);
	    g.drawString("Gender : ",110, 263);
	    g.drawString("Age : ",135,328);
	    g.drawString("Id : ",350,165);

	    GregorianCalendar g1=new GregorianCalendar();
		String s=g1.getTime().toString();
		g.drawString(s,230 ,130 );
	  
	    Font font1=new Font("TimesRoman",Font.ITALIC,30); 
	    g.setFont(font1);
	    g.setColor(Color.red);
	    g.drawString("APPOINTMENT... ",120,80);
	  
	  
		
    }
}
