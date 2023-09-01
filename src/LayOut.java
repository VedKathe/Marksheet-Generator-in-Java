import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.*;


public class LayOut extends JFrame  implements ActionListener
{
	JTextField tname,tenroll,tseatno,tsubname[],tsubth[],tsubpr[],tsubthx[],tsubthm[],tsubprx[],tsubprm[];
	JLabel ltitle,lname,lenroll,lseatno,lexam,lcourse,linfo,lmark,lsem,icon,subname[],subth[],subpr[],slas[][];
	JButton badd,bremove,bnext,bquit,breset;
	String xm[]= {"Winter","Summer"};
	String core[]= {"Chemical Engineering","Civil Engineering","Computer Technology","Mechanical Engineering","Electrical Engineering","Information Technology"};
	String year[];
	String day[];
	String month[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};
	String sem[]= {"First Semister","Second Semister","Third Semister","Forth Semister","Fifth Semister","Sixth Semister",};
	JPanel infoPanel,panel2,marksPanel;
	JComboBox cbexam,cbcourse,cbday,cbmonth,cbyear,cbsem;
	int button_count=0;
	
	LayOut()
	{
		init();
		infoPanel.add(lname);
		infoPanel.add(tname);
		infoPanel.add(lenroll);
		infoPanel.add(tenroll);
		infoPanel.add(lseatno);
		infoPanel.add(tseatno);
		infoPanel.add(lexam);
		infoPanel.add(cbexam);
		infoPanel.add(lcourse);
		infoPanel.add(cbcourse);

		infoPanel.add(lsem);
		infoPanel.add(cbsem);
		for(int i=0;i<7;i++)
		{
			marksPanel.add(subname[i]);
			marksPanel.add(tsubname[i]);
			marksPanel.add(subth[i]);
			marksPanel.add(tsubth[i]);
			marksPanel.add(tsubthx[i]);
			marksPanel.add(tsubthm[i]);
			marksPanel.add(subpr[i]);
			marksPanel.add(tsubpr[i]);
			marksPanel.add(tsubprx[i]);
			marksPanel.add(tsubprm[i]);
			
			marksPanel.add(slas[0][i]);
			marksPanel.add(slas[1][i]);
			marksPanel.add(slas[2][i]);
			marksPanel.add(slas[3][i]);
		}
		marksPanel.add(badd);
		marksPanel.add(bremove);
				
		add(bnext);
	
		add(bquit);		
		add(icon);
		add(ltitle);
		add(linfo);
		add(infoPanel);
		add(lmark);
		add(panel2);
		add(marksPanel);
		Image icon = Toolkit.getDefaultToolkit().getImage("img/Student Marksheet icon.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.setIconImage(icon);
		this.setTitle("Marksheet Generator");
		infoPanel.setBounds(10, 60, 515, 135);
		marksPanel.setBounds(10, 205, 515, 55);
		infoPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
		panel2.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
		marksPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
		infoPanel.setLayout(null);
		marksPanel.setLayout(null);
		this.setResizable(false);
		setSize(550,350);
		this.setLayout(null);
		setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	//////constructor ends///////

	void init()
	{		
		 	Font fs= new Font("Serif", Font.BOLD, 12);
		 	Font f= new Font("Serif", Font.PLAIN, 12);
		 	
		 	//TITLE
		 	icon= new JLabel("");
			icon.setIcon(new ImageIcon (new ImageIcon("img/Student Marksheet icon.png").getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH)));
		 	icon.setBounds(20, 7, 45, 45);
		 	
		 	ltitle= new JLabel("STUDENT MARKSHEET GENERATOR");
		 	ltitle.setFont(new Font("Monospaced", Font.PLAIN, 27));
		 	ltitle.setBounds(80, 10, 480, 40);
		 	
		 	//Panel
		 	infoPanel = new JPanel();
		 	panel2 = new JPanel();
		 	marksPanel = new JPanel();
		 	
		 	//PANEL_TITLE
			linfo= new JLabel("Student Information");
			linfo.setBounds(200,53,138,15);
			linfo.setFont(new Font("Monospaced", Font.PLAIN, 11));
			linfo.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
			linfo.setBackground(Color.LIGHT_GRAY);
			linfo.setOpaque(true);
			
			lmark= new JLabel("Student Marks");
			lmark.setBounds(220,198,96,15);
			lmark.setFont(new Font("Monospaced", Font.PLAIN, 11));
			lmark.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
			lmark.setBackground(Color.LIGHT_GRAY);
			lmark.setOpaque(true);
		 	
		 	//NAME
		 	lname= new JLabel("Name     :");
			lname.setBounds(20, 15, 80, 30);
			lname.setFont(fs);
			tname= new JTextField();
			tname.setBounds(90, 15, 145, 30);
			tname.setHorizontalAlignment(JTextField.CENTER);
			tname.setFont(f);
			tname.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
			
			//ENROLLMENT
			lenroll= new JLabel("Enrollment   :");
			lenroll.setBounds(255, 15, 100, 30);
			lenroll.setFont(fs);
			tenroll= new JTextField();
			tenroll.setBounds(355, 15, 145, 30);
			tenroll.setHorizontalAlignment(JTextField.CENTER);
			tenroll.setFont(f);
			tenroll.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
			
			//SEAT NUMBER 
			lseatno= new JLabel("Seat No. :");
			lseatno.setBounds(20, 55, 100, 30);
			lseatno.setFont(fs);
			tseatno= new JTextField();
			tseatno.setBounds(90, 55, 145, 30);
			tseatno.setHorizontalAlignment(JTextField.CENTER);
			tseatno.setFont(f);
			tseatno.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
			
			//EXAMINATION
			lexam= new JLabel("Examination :");
			lexam.setBounds(255,55,100,30);
			lexam.setFont(fs);
			cbexam= new JComboBox(xm);
			cbexam.setBounds(355,55,145,30);
			cbexam.setFont(f);
			cbexam.setBackground(Color.WHITE);
			
			//COUSRE
			lcourse= new JLabel("Course   :");
			lcourse.setBounds(20,95,100,30);
			lcourse.setFont(fs);
			cbcourse= new JComboBox(core);
			cbcourse.setBounds(90,95,145,30);
			cbcourse.setFont(f);
			cbcourse.setBackground(Color.WHITE);
			
			//SEMISTER_INPUT
			lsem= new JLabel("Semister       :");
			lsem.setBounds(255,95,100,30);
			lsem.setFont(fs);
			cbsem= new JComboBox(sem);
			cbsem.setBounds(355,95,145,30);
			cbsem.setFont(f);
			cbsem.setBackground(Color.WHITE);
										
			//SUBJECT_INFO_INPUT
			
			subname=new JLabel[7];
		 	subth=new JLabel[7];
		 	subpr=new JLabel[7];
		 	slas= new JLabel[4][7];		 	
		 	tsubname=new JTextField[7];
		 	tsubth=new JTextField[7];
		 	tsubpr=new JTextField[7];
		 	tsubprx=new JTextField[7];
		 	tsubthx=new JTextField[7];
		 	tsubthm=new JTextField[7];
		 	tsubprm=new JTextField[7];
		 	
		 	for(int i=0,j=15;i<7;i++,j+=40)
			{
				subname[i]= new JLabel("SUB "+(i+1)+":");
				subname[i].setBounds(10,j,100,30);
				subname[i].setVisible(false);
				subname[i].setFont(fs);
				
				tsubname[i]= new JTextField();
				tsubname[i].setBounds(55,j,100,30);
				tsubname[i].setHorizontalAlignment(JTextField.CENTER);
				tsubname[i].setVisible(false);
				tsubname[i].setFont(f);
				tsubname[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
				
				subth[i]= new JLabel("TH Marks :");
				subth[i].setBounds(160,j,80,30);
				subth[i].setVisible(false);
				subth[i].setFont(fs);
				
				tsubth[i]= new JTextField();
				tsubth[i].setBounds(300,j,25,30);
				tsubth[i].setHorizontalAlignment(JTextField.CENTER);
				tsubth[i].setVisible(false);
				tsubth[i].setFont(f);
				tsubth[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
				
				slas[0][i]= new JLabel("/");
				slas[0][i].setBounds(260,j,25,30);
				slas[0][i].setVisible(false);
			
				
				tsubthm[i]= new JTextField("28");
			 	tsubthm[i].setBounds(265,j,25,30);
			 	tsubthm[i].setHorizontalAlignment(JTextField.CENTER);
			 	tsubthm[i].setVisible(false);
			 	tsubthm[i].setFont(f);
				tsubthm[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
				
				slas[1][i]= new JLabel("/");
				slas[1][i].setBounds(295,j,25,30);
				slas[1][i].setVisible(false);
	
				
				tsubthx[i]= new JTextField("70");
			 	tsubthx[i].setBounds(230,j,25,30);
			 	tsubthx[i].setHorizontalAlignment(JTextField.CENTER);
			 	tsubthx[i].setVisible(false);
			 	tsubthx[i].setFont(f);
			 	tsubthx[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
			 		
				subpr[i]= new JLabel("PR Marks :");
				subpr[i].setBounds(340,j,80,30);
				subpr[i].setVisible(false);
				subpr[i].setFont(fs);
				
				tsubpr[i]= new JTextField();
				tsubpr[i].setBounds(480,j,25,30);
				tsubpr[i].setHorizontalAlignment(JTextField.CENTER);
				tsubpr[i].setVisible(false);
				tsubpr[i].setFont(f);
				tsubpr[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
				
				slas[2][i]= new JLabel("/");
				slas[2][i].setBounds(440,j,25,30);
				slas[2][i].setVisible(false);
								
				tsubprm[i]= new JTextField("12");
				tsubprm[i].setBounds(445,j,25,30);
				tsubprm[i].setHorizontalAlignment(JTextField.CENTER);
				tsubprm[i].setVisible(false);
				tsubprm[i].setFont(f);
				tsubprm[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
				
				slas[3][i]= new JLabel("/");
				slas[3][i].setBounds(475,j,25,30);
				slas[3][i].setVisible(false);
		
				
				tsubprx[i]= new JTextField("30");
				tsubprx[i].setBounds(410,j,25,30);
				tsubprx[i].setHorizontalAlignment(JTextField.CENTER);
				tsubprx[i].setVisible(false);
				tsubprx[i].setFont(f);
				tsubprx[i].setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true));
			}
			
			//ADD_AND_REMOVE_BUTTON
			badd= new JButton("+");
			badd.setBounds(10, 15, 240, 30);
			badd.addActionListener(this);
			badd.setFont(fs);
			badd.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
			badd.setBackground(Color.LIGHT_GRAY);
			
			bremove= new JButton("-");
			bremove.setBounds(265, 15, 240, 30);
			bremove.addActionListener(this);
			bremove.setFont(fs);
			bremove.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
			bremove.setBackground(Color.LIGHT_GRAY);
			
			//NEXT_QUIT_RESET_BUTTON
			bnext= new JButton("Add");
			bnext.setBounds(180, 265, 70, 30);
			bnext.addActionListener(this);
			bnext.setFont(fs);
			bnext.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
			bnext.setBackground(Color.LIGHT_GRAY);
			
			breset= new JButton("Reset");
			breset.setBounds(220, 265, 70, 30);
			breset.addActionListener(this);
			breset.setFont(fs);
			breset.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
			breset.setBackground(Color.LIGHT_GRAY);	
			
			bquit= new JButton("Quit");
			bquit.setBounds(285, 265, 70, 30);
			bquit.addActionListener(this);
			bquit.setFont(fs);
			bquit.setBorder(BorderFactory.createLineBorder(Color.gray, 2, true));
			bquit.setBackground(Color.LIGHT_GRAY);
									
	}
		
	void hideButton()
	{	
		try {
		badd.setVisible(true);
		button_count--;
		subname[button_count].setVisible(false);
		tsubname[button_count].setVisible(false);
		subth[button_count].setVisible(false);
		tsubth[button_count].setVisible(false);	
		tsubthx[button_count].setVisible(false);
		tsubthm[button_count].setVisible(false);
		subpr[button_count].setVisible(false);
		tsubpr[button_count].setVisible(false);	
		tsubprx[button_count].setVisible(false);
		tsubprm[button_count].setVisible(false);
		slas[0][button_count].setVisible(false);
		slas[1][button_count].setVisible(false);
		slas[2][button_count].setVisible(false);
		slas[3][button_count].setVisible(false);
		badd.setBounds(10, tsubpr[button_count].getBounds().y, 240, 30);
		bremove.setBounds(265, tsubpr[button_count].getBounds().y, 240, 30);
		setSize(550,(tsubpr[button_count].getBounds().y+335));
		marksPanel.setBounds(10, 205, 515,tsubpr[button_count].getBounds().y+40);
		bnext.setBounds(180, tsubpr[button_count].getBounds().y+250, 70, 30);
		breset.setBounds(220, tsubpr[button_count].getBounds().y+250, 70, 30);
		bquit.setBounds(285, tsubpr[button_count].getBounds().y+250, 70, 30);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(this, "No Subject added");
			button_count++;
		}
	}
	
	
	void addButton()
	{
		subname[button_count].setVisible(true);
		tsubname[button_count].setVisible(true);
		subth[button_count].setVisible(true);
		tsubth[button_count].setVisible(true);
		tsubthx[button_count].setVisible(true);
		tsubthm[button_count].setVisible(true);
		subpr[button_count].setVisible(true);
		tsubpr[button_count].setVisible(true);
		tsubprx[button_count].setVisible(true);
		tsubprm[button_count].setVisible(true);
		slas[0][button_count].setVisible(true);
		slas[1][button_count].setVisible(true);
		slas[2][button_count].setVisible(true);
		slas[3][button_count].setVisible(true);
		badd.setBounds(10, tsubpr[button_count].getBounds().y+40, 240, 30);
		bremove.setBounds(265, tsubpr[button_count].getBounds().y+40, 240, 30);
		setSize(550,(tsubpr[button_count].getBounds().y+375));
		marksPanel.setBounds(10, 205, 515,tsubpr[button_count].getBounds().y+80);
		bnext.setBounds(180, tsubpr[button_count].getBounds().y+290, 70, 30);
		breset.setBounds(220, tsubpr[button_count].getBounds().y+290, 70, 30);
		bquit.setBounds(285, tsubpr[button_count].getBounds().y+290, 70, 30);
		button_count++;			
		if(button_count==7)
		{
			badd.setVisible(false);
			bremove.setBounds(10, tsubpr[6].getBounds().y+40, 495, 30);
		}
	}
	
	
	public void actionPerformed(ActionEvent a) {
		// TODO Auto-generated method stub
		if(a.getSource()==badd)
		{
			addButton();
		}
		
		if(a.getSource()==bremove)
		{
			hideButton();
		}			
		
		if(a.getSource()==bnext)
		{	
			
			for(int i=0;i<7;i++)
			{
				if(i<button_count)
				{	
					if(tsubth[i].getText().isEmpty()) {	
						tsubth[i].setText("0"); 
						tsubthx[i].setText("0"); 
						tsubthm[i].setText("0");
					}
					
					if(tsubpr[i].getText().isEmpty()) {	
						tsubpr[i].setText("0");
						tsubprx[i].setText("0");
						tsubprm[i].setText("0");
					}
					if(tname.getText().isEmpty()||tenroll.getText().isEmpty()||tseatno.getText().isEmpty())					
					{						
						JOptionPane.showMessageDialog(this,"Empty Student Data","Alert",JOptionPane.WARNING_MESSAGE);
						break;
						
					}
					else if(subcheak())
					{
						JOptionPane.showMessageDialog(this,"Empty Subject name","Alert",JOptionPane.WARNING_MESSAGE);
						break;
					}
					else if(tsubth[i].getText().isEmpty() && tsubpr[i].getText().isEmpty())
					{
						JOptionPane.showMessageDialog(this,"Empty Mark Data","Alert",JOptionPane.WARNING_MESSAGE);
						break;
					}			
					else if(Integer.parseInt(tsubprx[i].getText())<Integer.parseInt(tsubpr[i].getText()) || Integer.parseInt(tsubthx[i].getText())<Integer.parseInt(tsubth[i].getText()))
							{
								JOptionPane.showMessageDialog(this,"Obtain marks are more than Max mark ","Alert",JOptionPane.WARNING_MESSAGE);
								
								if(tsubth[i].getText().equals("0") && tsubthx[i].getText().equals("0") && tsubthm[i].getText().equals("0")) {	
									tsubth[i].setText(""); 
									tsubthx[i].setText("70"); 
									tsubthm[i].setText("28");
								}
								
								if(tsubpr[i].getText().equals("0") && tsubprx[i].getText().equals("0") && tsubprm[i].getText().equals("0")) {	
									tsubpr[i].setText("");
									tsubprx[i].setText("30");
									tsubprm[i].setText("12");
								}
								break;
							}											
					else 
					{							
						if(cheakNo()) 
						{
							this.setVisible(false);
							new Frame_marksheet(this);
							this.dispose();
							break;
						}
						else
						{
							JOptionPane.showMessageDialog(this,"Incorrect Input","Alert",JOptionPane.WARNING_MESSAGE);
							break;
						}
					}
				}
			}	
			
		}		
		if(a.getSource()==bquit)
		{
			if (JOptionPane.showConfirmDialog( this,"Are you sure you want to exit?","Quit",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
				System.exit(0);
		}
		
	}
	
	boolean cheakNo() {
		for(int i=0;i<7;i++) {
			if(!tsubth[i].getText().isEmpty() )
			{
				if(!Pattern.matches("[0-9]{0,3}", tsubth[i].getText()))
				{
					return false;
				}
			}
			if(!tsubthx[i].getText().isEmpty() || !tsubpr[i].getText().isEmpty())
			{
				if(!Pattern.matches("[0-9]{0,3}", tsubthx[i].getText()))
				{
					return false;
				}
			}
			if(!tsubthm[i].getText().isEmpty() )
			{
				if(!Pattern.matches("[0-9]{0,2}", tsubthm[i].getText()))
				{
					return false;
				}
			}
			if(!tsubpr[i].getText().isEmpty())
			{
				
					if(!Pattern.matches("[0-9]{0,2}", tsubpr[i].getText()))
					{
						return false;
					}
				
			}
			if(!tsubprx[i].getText().isEmpty())
			{
				if(!Pattern.matches("[0-9]{0,2}", tsubprx[i].getText()))
				{
					return false;
				}
			}
			if(!tsubprm[i].getText().isEmpty())
			{
				if(!Pattern.matches("[0-9]{0,2}", tsubprm[i].getText()))
				{
					return false;
				}
			}
			
			
		}
		return true;
	}
	
	boolean subcheak()
	{
		for(int i=0;i<7;i++)
		{
			if(i<button_count)
			{
				if(	(	!( tsubth[i].getText().isEmpty() && tsubthx[i].getText().isEmpty() && tsubthm[i].getText().isEmpty() ) || !( tsubpr[i].getText().isEmpty() &&tsubprm[i].getText().isEmpty() && tsubprx[i].getText().isEmpty())))
				{
					if(tsubname[i].getText().isEmpty())
					{	
						//JOptionPane.showMessageDialog(this,"Subname empty","Alert",JOptionPane.WARNING_MESSAGE);
						return true;
					}
				}
				
			}
		}

		return false;
	}
	
	public static void main(String arg[])
	{
		new LayOut();
	}
}
