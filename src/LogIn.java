import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LogIn extends JFrame implements ActionListener
{
	JPasswordField pass;
	JTextField user;
	JLabel lpass,luser,ltitle,icon;
	JPanel panel;
	JButton login,quit,ran;
	Connection conn;
	Statement st;
	ResultSet rs;
	Font f;
	Boolean isConnected = false;
	
	LogIn()
	{
		 f= new Font("Monospaced", Font.BOLD, 16);
				
		
		icon= new JLabel("");
		icon.setIcon(new ImageIcon (new ImageIcon("img/Student Marksheet icon.png").getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
	 	icon.setBounds(240, 20, 120, 120);
		
		ltitle= new JLabel("STUDENT MARKSHEET GENERATOR");
		ltitle.setFont(new Font("Monospaced", Font.PLAIN, 32));
	 	ltitle.setBounds(45, 150, 520, 40);
	 	
		panel = new JPanel();
		panel.setBounds(150, 200, 300, 60);
		panel.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
			
		
		luser=new JLabel(" Email :   ");
		luser.setBounds(20,20,80,30);
		user=new JTextField(15);		
		user.setBounds(100,20,100,30);
		user.setToolTipText("Enter Name");
		
		luser.setFont(f);
		
		lpass=new JLabel(" Password :");
		lpass.setBounds(20,60,80,30);
		pass=new JPasswordField(15);		
		pass.setBounds(100,60,100,30);
		pass.setToolTipText("Enter Password");
		lpass.setFont(f);
		
		login= new JButton("LOGIN");
		login.setBounds(150, 310, 145, 25);
		login.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
		login.setFont(f);
		login.setBackground(Color.LIGHT_GRAY);
		login.addActionListener(this);

		
		quit= new JButton("QUIT");
		quit.setBounds(305, 310, 145, 25);
		quit.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
		quit.setFont(f);
		quit.setBackground(Color.LIGHT_GRAY);
		quit.addActionListener(this);

		
		ran= new JButton("Create New Account?");
		ran.setBounds(295, 260, 190, 17);
		ran.setFont(new Font("Monospaced", Font.PLAIN, 10));
		ran.setOpaque(false);
		ran.setContentAreaFilled(false);
		ran.setBorderPainted(false);
		ran.addActionListener(this);
		
		add(ltitle);
		add(icon);
		add(panel);
		panel.add(luser);
		panel.add(user);
		panel.add(lpass);
		panel.add(pass);
		add(login);
		add(quit);
		add(ran);
		
		setconnection();
		this.setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("img/Student Marksheet icon.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.setIconImage(icon);
		this.setTitle("Marksheet Generator");
		setLayout(null);
		setSize(600,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==login)
		{	
			int n=cheakUser();
			if(n==1) {
						new LayOut();
						this.setVisible(false);
					}
			else if(n==2){
					JOptionPane.showMessageDialog(this,"Invalid Username or Password","Alert",JOptionPane.WARNING_MESSAGE);

			}
		}
		if(a.getSource()==quit)
		{
			if (JOptionPane.showConfirmDialog( this,"Are you sure you want to exit?","Quit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			System.exit(0);
		}
		if(a.getSource()==ran)
		{		
			if(isConnected) {
				newAccount();
			}
		}
	}
	
	
	int cheakUser() 
	{	
		int n=0;		
		if(!isConnected) {	
			if(user.getText().equals("system") && String.valueOf(pass.getPassword()).equals("system"))
			{
				 n= 1;									
			}else
			{
				 n =2;				
			}
		}
		else
		{
			try {
				rs = st.executeQuery("Select * from userdata");
				while(rs.next()) {
				
					if(user.getText().equals(rs.getString("name")) && String.valueOf(pass.getPassword()).equals(rs.getString("pass")))
					{
						 n= 1;
						 rs.beforeFirst();
						break;						
					}else
					{
						 n =2;
						 rs.beforeFirst();
						break;
					}
				} 				
			} catch (SQLException e) {			
				JOptionPane.showMessageDialog(this,e.getMessage()+"\n\tTry reconnecting","Alert",JOptionPane.WARNING_MESSAGE);
			}
		}
		return n;
		
	}
	
	void setconnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","root");
    		
            st = conn.createStatement();           
             rs = st.executeQuery("Select * from userdata");
             isConnected=true;
        } 
		catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(this,e.getMessage()+"\n\tTry reconnecting","Alert",JOptionPane.WARNING_MESSAGE);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(this,e.getMessage()+"\n\tTry reconnecting","Alert",JOptionPane.WARNING_MESSAGE);
        }
		catch(Exception e) {
			JOptionPane.showMessageDialog(this,e.getMessage()+"\n\t reconnecting","Alert",JOptionPane.WARNING_MESSAGE);
		}
		
	}
	
	void  newAccount() {
		JFrame newaccount = new JFrame("New Account");
		//this.add(newaccount);
		
		JPasswordField newpass[] = new JPasswordField[2];
		JTextField newuser;
		JLabel lnewpass[] = new JLabel[2],lnewuser;
		
		lnewuser=new JLabel(" Email :");
		lnewuser.setBounds(10,20,120,30);
		lnewuser.setFont(f);
		newuser=new JTextField(15);		
		newuser.setBounds(190,20,100,30);
		newuser.setToolTipText("Enter Email");		
		//lnewuser.setFont(f);
		
		lnewpass[0]=new JLabel(" Password :");
		lnewpass[0].setBounds(10,60,120,30);
		lnewpass[0].setFont(f);
		newpass[0]=new JPasswordField(15);		
		newpass[0].setBounds(190,60,100,30);
		newpass[0].setToolTipText("Enter Password");
		
		lnewpass[1]=new JLabel("Conform Password :");
		lnewpass[1].setBounds(10,100,190,30);
		lnewpass[1].setFont(f);	
		newpass[1]=new JPasswordField(15);		
		newpass[1].setBounds(190,100,100,30);	
		newpass[1].setToolTipText("Enter Password :");
	
		//lnewpass.setFont(f);
		
		JButton confirm= new JButton("Verify");
		confirm.setBounds(70, 150, 80, 25);		
		confirm.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				String password=String.valueOf(newpass[0].getPassword());
				
				if(!newuser.getText().isEmpty()	|| !password.isEmpty()) 
				{
					if(!cheakuser(newuser))
						{
							int b = (int)(Math.random()*(999999-100000+1)+100000);
							new SendMailSSL("black.soul2077@gmail.com","iamnotblackitsjustthename",newuser.getText(),"EMAIL VERIFICATION","YOUR OTP IS",b);
							String name=JOptionPane.showInputDialog(newaccount,"Enter OTP");  
								if(Integer.parseInt(name)==b) {
															
									try {
										PreparedStatement stm=conn.prepareStatement("insert into userdata values(?,?);");
							            stm.setString(1,newuser.getText());
							            stm.setString(2,password);
							            stm.executeUpdate();
							            JOptionPane.showMessageDialog(newaccount,"ACCOUNT CREATED SUCCSESSFULLY");
							            newaccount.dispose();
									} catch (SQLException e1) {
										
										e1.printStackTrace();
									}						
								}
								else
								{
									JOptionPane.showMessageDialog(newaccount,"WRONG OTP");
								}
						}
					else
					{
						JOptionPane.showMessageDialog(newaccount,"username already exist");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(newaccount,"Enter Email\\Password");
				}				
			}  
			});  
		
		JButton cancel= new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (JOptionPane.showConfirmDialog( newaccount,"Are you sure you want to exit?","Quit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
					
					newaccount.dispose();
			}
			
		});
		cancel.setBounds(170, 150, 80, 25);
		confirm.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
		confirm.setBackground(Color.LIGHT_GRAY);
		confirm.setFont(f);
		cancel.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
		cancel.setBackground(Color.LIGHT_GRAY);
		cancel.setFont(f);
		
		Image icon = Toolkit.getDefaultToolkit().getImage("img/Student Marksheet icon.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		newaccount.setIconImage(icon);
		newaccount.add(lnewuser);
		newaccount.add(newuser);
		newaccount.add(lnewpass[0]);
		newaccount.add(newpass[0]);
		newaccount.add(lnewpass[1]);
		newaccount.add(newpass[1]);
		newaccount.add(confirm);
		newaccount.add(cancel);
		newaccount.setLayout(null);
		newaccount.setSize(320,230);
		newaccount.setVisible(true);
		newaccount.setResizable(false);
		
		
	}
	
	Boolean cheakuser(JTextField usernew)
	{
		
		try {
			rs = st.executeQuery("Select * from userdata");
				
			while(rs.next()) {
				
				if(usernew.getText().equals(rs.getString("name")))
				{
					
					 rs.beforeFirst();
					 return true;
				}
					else
				{
					 
					 rs.beforeFirst();
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public static void main(String args[])
	{
		new LogIn();
	}

	
}