import javax.imageio.ImageIO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Frame_marksheet extends JFrame implements ActionListener {

	LayOut l;
Image img;
JLabel limage;
JPanel j,buttons;
int marksheetcount=7,h,h1,count1=0,failcount=0, conddiff=0;
float tol=0,tol1=0;
int condcount[]= {0,0,0,0,0,0,0};
JButton print,back;
JLabel ltitle,lname,lenroll,lseatno,lexam,lcourse,linfo,lmark,lsem,icon,subname[],
subth[],subpr[],tsubth[],tsubpr[],tsubthx[],tsubthm[],tsubprx[],tsubprm[],finmark[],
lthpr,lmin,lobt,lmax,ltmax,ltobt,ltmark,lcredits,lmaxmarks[],lpersent[],ldate[],lobtmarks[],lremark,lgrade[];

	Frame_marksheet(LayOut l)
	{	
		this.l=l;
		init();	
		cal();
		add(lname);
		add(lenroll);
		add(lseatno);
		add(lexam);
		add(lcourse);
		add(lsem);		
		add(lthpr);
		add(lmin);
		add(lmax);
		add(lobt);
		add(ltmax);
		add(ltobt);
		add(ltmark);
		add(lcredits);
		add(lmaxmarks[0]);
		add(lobtmarks[0]);
		add(ldate[0]);
		add(lpersent[0]);
		add(lmaxmarks[1]);
		add(lobtmarks[1]);
		add(ldate[1]);
		add(lpersent[1]);
		add(lremark);
		
		for(int i=0;i<7;i++)
		{
			add(subname[i]);
			add(subth[i]);
			add(subpr[i]);
			add(tsubth[i]);
			add(tsubpr[i]);
			add(tsubthx[i]);
			add(tsubprx[i]);
			add(tsubthm[i]);
			add(tsubprm[i]);
			add(finmark[i]);
			add(lgrade[i]);
		}
		
		//add(icon);
		//add(ltitle);
		add(linfo);
		add(lmark);	
		add(icon);		
		add(buttons);
		add(print);	
		add(back);
		j.add(ltitle);
		add(j);
		add(limage);
		limage.setSize(700, h);
		setSize(719,h+50);
		//pack();
		setLayout(null);		
		setVisible(true);
		this.setResizable(false);
		Image icon = Toolkit.getDefaultToolkit().getImage("img/Student Marksheet icon.png").getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		this.setIconImage(icon);
		this.setTitle("Marksheet Generator");
	}
	
	void init()
	{		
			
		 	Font fs= new Font("Serif", Font.BOLD, 12);
		 	Font f= new Font("Serif", Font.PLAIN, 16);
			Font fss= new Font("Dialog", Font.BOLD, 12);
			
		 	j = new JPanel();
		 	j.setBounds(85, 17, 590, 50);
			j.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
			j.setBackground(Color.LIGHT_GRAY);
			
			buttons = new JPanel();			

		 	print=new JButton("Save");
		 	print.addActionListener(this);
		 	print.setFont(fss);
		 	print.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
		 	print.setBackground(Color.LIGHT_GRAY);
		 	
		 	back=new JButton("Back");
		 	back.addActionListener(this);
		 	back.setFont(fss);
		 	back.setBorder(BorderFactory.createLineBorder(Color.gray, 1, true));
		 	back.setBackground(Color.LIGHT_GRAY);
		 	
		 	limage= new JLabel("");
			limage.setBounds(0,0, 800, 734);
		
			
		 	
		 	
		 	//TITLE
		 	icon= new JLabel("");
			icon.setIcon(new ImageIcon (new ImageIcon("img/Student Marksheet icon.png").getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH)));
		 	icon.setBounds(27, 9, 60, 60);
		 	icon.setBorder(BorderFactory.createLineBorder(Color.WHITE, 3));
		 	
		 	ltitle= new JLabel("STUDENT MARKSHEET");
		 	ltitle.setFont(new Font("Monospaced", Font.PLAIN, 30));
		 	
		 	
		 	//Panel
		 	
		 	
		 	//PANEL_TITLE
			linfo= new JLabel("Title of Courses");
			linfo.setBounds(100,155,138,15);
			
			
			lmark= new JLabel("Marks");
			lmark.setBounds(390,140,96,15);
		
		 	
		 	//NAME
		 	lname= new JLabel("Mr. / Ms.   "+l.tname.getText());
			lname.setBounds(30, 60, 200, 30);
			

			
			//ENROLLMENT
			lenroll= new JLabel("Enrollment No.  :  "+l.tenroll.getText());
			lenroll.setBounds(30, 80, 200, 30);
			

			
			//SEAT NUMBER 
			lseatno= new JLabel("Seat No. :  "+l.tseatno.getText());
			lseatno.setBounds(480, 80, 200, 30);
			
			
			//EXAMINATION
			lexam= new JLabel("Examination   :  "+l.cbexam.getSelectedItem());
			lexam.setBounds(280,80,200,30);
		

			
			//COUSRE
			lcourse= new JLabel("Course		:  "+l.cbcourse.getSelectedItem());
			lcourse.setBounds(280,100,300,30);
			

			//SEMISTER_INPUT
			lsem= new JLabel("Semister 	:  "+l.cbsem.getSelectedItem());
			lsem.setBounds(30,100,200,30);
			

			
		 	lthpr= new JLabel("Th/Pr");
			lthpr.setBounds(280, 140, 80, 30);
			

			
			//MAX
			lmax= new JLabel("Max.");
			lmax.setBounds(340, 160, 60, 30);
			

			
			//MIN 
			lmin= new JLabel("Min.");
			lmin.setBounds(400, 160, 60, 30);
			
			
			//OBT
			lobt= new JLabel("Obt.");
			lobt.setBounds(460,160,100,30);
			

			
			//TOTALMARKS
			ltmark= new JLabel("Total Mark");
			ltmark.setBounds(530,133,100,30);
			

			//TOTALMAX
			ltmax= new JLabel("Max");
			ltmax.setBounds(515,160,100,30);
										
			//TOTALMARKS OBT
			ltobt= new JLabel("Obt");
			ltobt.setBounds(575,160,100,30);
			

			//CREDITS
			lcredits= new JLabel("   Grade");
			lcredits.setBounds(618,147,55,30);
			lcredits.setBackground(Color.white);
			lcredits.setOpaque(true);
			
			//TOTAL MAX MARKS
			
			
			//SUBJECT_INFO_INPUT

			subname=new JLabel[7];
		 	subth=new JLabel[7];
		 	subpr=new JLabel[7];
		 	tsubth=new JLabel[7];
		 	tsubpr=new JLabel[7];
		 	tsubprx=new JLabel[7];
		 	tsubthx=new JLabel[7];
		 	tsubthm=new JLabel[7];
		 	tsubprm=new JLabel[7];
		 	finmark=new JLabel[7];
		 	lgrade=new JLabel[7];
		 	
			for(int i=0;i<7;i++)
			{
				subname[i]= new JLabel(l.tsubname[i].getText());
				subname[i].setFont(f);				
				subname[i].setHorizontalAlignment(JLabel.CENTER);
				
				subpr[i]= new JLabel("PR");								
				subth[i]= new JLabel("TH");
			
				tsubth[i]= new JLabel(l.tsubth[i].getText());
				tsubth[i].setHorizontalAlignment(JLabel.CENTER);
				tsubpr[i]=new JLabel(l.tsubpr[i].getText());
				tsubpr[i].setHorizontalAlignment(JLabel.CENTER);
				tsubthm[i]= new JLabel(l.tsubthm[i].getText());
				tsubthm[i].setHorizontalAlignment(JLabel.CENTER);
				tsubprm[i]=new JLabel(l.tsubprm[i].getText());
				tsubprm[i].setHorizontalAlignment(JLabel.CENTER);
				tsubthx[i]= new JLabel(l.tsubthx[i].getText());
				tsubthx[i].setHorizontalAlignment(JLabel.CENTER);
				tsubprx[i]=new JLabel(l.tsubprx[i].getText());
				tsubprx[i].setHorizontalAlignment(JLabel.CENTER);
				
				finmark[i] = new JLabel();
				lgrade[i] = new JLabel();
				lgrade[i].setHorizontalAlignment(JLabel.CENTER);
				select(i);
			}
			
			limage.setIcon(new ImageIcon (new ImageIcon("img/"+marksheetLayout()).getImage().getScaledInstance(700, h, Image.SCALE_SMOOTH)));
			back.setBounds(400, h-35, 60, 30);
			print.setBounds(240, h-35, 60, 30);
			
			lmaxmarks=new JLabel[2];
			lobtmarks=new JLabel[2];
			ldate=new JLabel[2];
			lpersent=new JLabel[2];
			
			lmaxmarks[0]= new JLabel("TOTAL MAX MARKS");
			lmaxmarks[0].setBounds(190,h1,164,30);
			lmaxmarks[0].setHorizontalAlignment(JLabel.CENTER);
			
			lobtmarks[0]= new JLabel("TOTAL MARKS OBTAINED");
			lobtmarks[0].setBounds(352,h1,163,30);
			lobtmarks[0].setHorizontalAlignment(JLabel.CENTER);
			
			ldate[0]= new JLabel("DATE");
			ldate[0].setBounds(28,h1,163,30);
			ldate[0].setHorizontalAlignment(JLabel.CENTER);
			
			lpersent[0]= new JLabel("PERSENT");
			lpersent[0].setBounds(516,h1,163,30);
			lpersent[0].setHorizontalAlignment(JLabel.CENTER);
			
			
			lmaxmarks[1]= new JLabel("");
			lmaxmarks[1].setBounds(190,h1+25,164,30);
			lmaxmarks[1].setHorizontalAlignment(JLabel.CENTER);
			
			lobtmarks[1]= new JLabel("");
			lobtmarks[1].setBounds(352,h1+25,163,30);
			lobtmarks[1].setHorizontalAlignment(JLabel.CENTER);
			
			//new Calendar();
			GregorianCalendar gcalendar = new GregorianCalendar();
			ldate[1]= new JLabel(gcalendar.get(Calendar.DATE)+"/"+(gcalendar.get(Calendar.MONTH)+1)+"/"+gcalendar.get(Calendar.YEAR));
			ldate[1].setBounds(28,h1+25,163,30);
			ldate[1].setHorizontalAlignment(JLabel.CENTER);
			
			lpersent[1]= new JLabel("");
			lpersent[1].setBounds(516,h1+25,163,30);
			lpersent[1].setHorizontalAlignment(JLabel.CENTER);
			
			lremark= new JLabel("THIS IS A REMAKE");
			lremark.setBounds(27,h1+55,648,30);
			lremark.setHorizontalAlignment(JLabel.CENTER);
			
			subname[0].setBounds(27,200,238,30);						
			subname[1].setBounds(30,255,238,30);						
			subname[2].setBounds(30,310,238,30);			
			subname[3].setBounds(30,370,238,30);				
			subname[4].setBounds(30,425,238,30);			
			subname[5].setBounds(30,480,238,30);			
			subname[6].setBounds(30,540,238,30);
							
			
			subth[0].setBounds(285,190,80,30);
			tsubthx[0].setBounds(322, 190, 60, 30);
			tsubthm[0].setBounds(381, 190, 60, 30);
			tsubth[0].setBounds(440, 190, 60, 30);
			finmark[0].setBounds(515, 205, 92, 30);
			lgrade[0].setBounds(618,205,55,30);
			
			subth[1].setBounds(285,245,80,30);
			tsubthx[1].setBounds(322, 245, 60, 30);
			tsubthm[1].setBounds(381, 245, 60, 30);
			tsubth[1].setBounds(440, 245, 60, 30);
			finmark[1].setBounds(515, 260, 92, 30);
			lgrade[1].setBounds(618,260,55,30);
			
			subth[2].setBounds(285,300,80,30);
			tsubthx[2].setBounds(322, 300, 60, 30);
			tsubthm[2].setBounds(381, 300, 60, 30);
			tsubth[2].setBounds(440, 300, 60, 30);
			finmark[2].setBounds(515, 315, 92, 30);
			lgrade[2].setBounds(618,315,55,30);
			
			subth[3].setBounds(285,360,80,30);
			tsubthx[3].setBounds(322, 360, 60, 30);
			tsubthm[3].setBounds(381, 360, 60, 30);
			tsubth[3].setBounds(440, 360, 60, 30);
			finmark[3].setBounds(515, 375, 92, 30);
			lgrade[3].setBounds(618,375,55,30);
			
			subth[4].setBounds(285,415,80,30);
			tsubthx[4].setBounds(322, 415, 60, 30);
			tsubthm[4].setBounds(381, 415, 60, 30);
			tsubth[4].setBounds(440, 415, 60, 30);
			finmark[4].setBounds(515, 430, 92, 30);
			lgrade[4].setBounds(618,430,55,30);
			
			subth[5].setBounds(285,470,80,30);
			tsubthx[5].setBounds(322, 470, 60, 30);
			tsubthm[5].setBounds(381, 470, 60, 30);
			tsubth[5].setBounds(440, 470, 60, 30);
			finmark[5].setBounds(515, 485, 92, 30);
			lgrade[5].setBounds(618,485,55,30);
			
			
			subth[6].setBounds(285,525,80,30);
			tsubthx[6].setBounds(322, 525, 60, 30);
			tsubthm[6].setBounds(381, 525, 60, 30);
			tsubth[6].setBounds(440, 525, 60, 30);
			finmark[6].setBounds(515, 540, 92, 30);
			lgrade[6].setBounds(618,540,55,30);
			
			subpr[0].setBounds(285,220,80,30);
			tsubprx[0].setBounds(322, 220, 60, 30);
			tsubprm[0].setBounds(381, 220, 60, 30);
			tsubpr[0].setBounds(440, 220, 60, 30);
			
			
			subpr[1].setBounds(285,275,80,30);
			tsubprx[1].setBounds(322, 275, 60, 30);
			tsubprm[1].setBounds(381, 275, 60, 30);
			tsubpr[1].setBounds(440, 275, 60, 30);
			
			subpr[2].setBounds(285,330,80,30);
			tsubprx[2].setBounds(322, 330, 60, 30);
			tsubprm[2].setBounds(381, 330, 60, 30);
			tsubpr[2].setBounds(440, 330, 60, 30);
			
			subpr[3].setBounds(285,390,80,30);
			tsubprx[3].setBounds(322, 390, 60, 30);
			tsubprm[3].setBounds(381, 390, 60, 30);
			tsubpr[3].setBounds(440, 390, 60, 30);
			
			subpr[4].setBounds(285,445,80,30);
			tsubprx[4].setBounds(322, 445, 60, 30);
			tsubprm[4].setBounds(381, 445, 60, 30);
			tsubpr[4].setBounds(440, 445, 60, 30);
			
			subpr[5].setBounds(285,500,80,30);
			tsubprx[5].setBounds(322, 500, 60, 30);
			tsubprm[5].setBounds(381, 500, 60, 30);
			tsubpr[5].setBounds(440, 500, 60, 30);
			
			subpr[6].setBounds(285,555,80,30);
			tsubprx[6].setBounds(322, 555, 60, 30);
			tsubprm[6].setBounds(381, 555, 60, 30);
			tsubpr[6].setBounds(440, 555, 60, 30);
					
			for(int i=0;i<7;i++) 			
			{
				if(l.tsubth[i].getText().equals("0")) {
				subpr[i].setBounds(subth[i].getBounds());
				tsubprx[i].setBounds(tsubthx[i].getBounds());
				tsubprm[i].setBounds(tsubthm[i].getBounds());
				tsubpr[i].setBounds(tsubth[i].getBounds());
				}
			}
	}
	
	void select(int i) {
			String n="";
			if(l.tsubpr[i].getText().isEmpty() && l.tsubth[i].getText().isEmpty()|| l.tsubpr[i].getText().equals("0") && l.tsubth[i].getText().equals("0")) {
				finmark[i].setVisible(false);	
				lgrade[i].setVisible(false);
				subname[i].setVisible(false);
				--this.marksheetcount;
			}	
			if(l.tsubth[i].getText().isEmpty() ||((l.tsubth[i].getText().equals("0") && l.tsubthx[i].getText().equals("0") && l.tsubthm[i].getText().equals("0")))) {	
				l.tsubth[i].setText("0"); 
				l.tsubthx[i].setText("0"); 
				l.tsubthm[i].setText("0"); 
				subth[i].setVisible(false);
				tsubthx[i].setVisible(false);
				tsubthm[i].setVisible(false);
				tsubth[i].setVisible(false);
				n="  ";
			}
			if(l.tsubpr[i].getText().isEmpty() ||((l.tsubpr[i].getText().equals("0") && l.tsubprx[i].getText().equals("0") && l.tsubprm[i].getText().equals("0")))) {	
				l.tsubpr[i].setText("0");
				l.tsubprx[i].setText("0");
				l.tsubprm[i].setText("0");
				subpr[i].setVisible(false);
				tsubprx[i].setVisible(false);
				tsubprm[i].setVisible(false);
				tsubpr[i].setVisible(false);
				n="  ";
			} 
			
				int max =Integer.parseInt(l.tsubprx[i].getText())+Integer.parseInt(l.tsubthx[i].getText());
				int obt=Integer.parseInt(l.tsubpr[i].getText())+Integer.parseInt(l.tsubth[i].getText());
				finmark[i].setText(n+max+"               "+obt);			
			
	}
	
	String marksheetLayout()
	{
		String j;
		
		switch(marksheetcount) {
		//1=365 2=415 3=470 4=525 5=585 6=645
			case 1:j= "Marksheet-templet 1.jpg"; h=400; h1=260;break;
			case 2:j= "Marksheet-templet 2.jpg"; h=450; h1=310;break;
			case 3:j= "Marksheet-templet 3.jpg"; h=500; h1=370;break;
			case 4:j= "Marksheet-templet 4.jpg"; h=560;	h1=425;break;
			case 5:j= "Marksheet-templet 5.jpg"; h=625;	h1=485;break;
			case 6:j= "Marksheet-templet 6.jpg"; h=680;	h1=540;break;
			case 7:j= "Marksheet-templet.png"; h=730;h1=595;break;
			default:j="Marksheet-templet.png";h=730;h1=595;break;
		}
		return j;
	}
	
	void cal()
	{
		tol=0;tol1=0;
		cheakfail();
		cond();
		
		for(int i=0;i<7;i++)
		{			
			tol= tol +Float.parseFloat(l.tsubprx[i].getText())+Float.parseFloat(l.tsubthx[i].getText());
			tol1=tol1 +Float.parseFloat(l.tsubpr[i].getText())+Float.parseFloat(l.tsubth[i].getText());	
			getGrade(i);
		}
		
		if(count1==1 || count1==2){
			for(int i=0;i<7;i++)
			{
				if(condcount[i] != 0) {
					tol1=tol1+conddiff;
					tsubth[i].setText(l.tsubth[i].getText()+"@");
					finmark[i].setText(finmark[i].getText()+"@");
				}				
			}			
		}
		float persent=(tol1*100)/tol;			
		lpersent[1].setText(String.format("%.2f", persent)+"%");		
		tol1=tol1-conddiff;
		lmaxmarks[1].setText(String.format("%.0f", tol)+"");
		for(int i=0;i<7;i++)
		{
			if(condcount[i]==0)
			{
				lobtmarks[1].setText(String.format("%.0f", tol1)+"");
				
			}
			else {
				lobtmarks[1].setText(String.format("%.0f", tol1)+"+"+conddiff);
				break;
			}
		}
		
		
		
		
		if(persent>=75 && persent<=100)
		{
			lremark.setText("First class distination");
		}
		if(persent>=60 && persent<=75)
		{
			lremark.setText("First class");
		}
		if(persent>=50 && persent<=60)
		{
			lremark.setText("Second class");
		}
		if(persent>=35 && persent<=50)
		{
			lremark.setText("Third class");
		}
		if(failcount>2)
		{
			lremark.setText("Fail");
		}
		if((count1==1 || count1==2) && persent>=35)
		{
			lremark.setText(lremark.getText()+" Com.");						
		}
		
	}
	
	void cond()
	{
		count1=0;
		for(int i=0;i<7;i++)
		{	
			if(i<l.button_count)
			if(!l.tsubth[i].getText().isEmpty()&& !l.tsubth[i].getText().equals("0"))
			{
				if(Integer.parseInt(l.tsubth[i].getText())<Integer.parseInt(l.tsubthm[i].getText())  )
				{	
					if(!l.tsubth[i].getText().equals("0") || Integer.parseInt(l.tsubpr[i].getText())>Integer.parseInt(l.tsubprm[i].getText()))
					{
						int diff=Integer.parseInt(l.tsubthm[i].getText())-Integer.parseInt(l.tsubth[i].getText());
						if(diff<=10)
						{
							
							condcount[i]=(Integer.parseInt(l.tsubth[i].getText())+diff);
							conddiff=conddiff+diff;
							count1++;
							
						}
					}
				}
			}			
		}
	}
	
	void cheakfail() {
		for(int i=0;i<7;i++)
		{			
			if(!l.tsubth[i].getText().isEmpty()&& !l.tsubth[i].getText().equals("0"))
			{
				if(Integer.parseInt(l.tsubth[i].getText())<Integer.parseInt(l.tsubthm[i].getText())  )
				{	
					++failcount;
				}
			}			
		}
	}
	public static void main(String arg[])
	{
		new Frame_marksheet(new LayOut());
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource()==print)
		{
			try {
	            Robot robot = new Robot();
	            String format = "jpg";
	            String fileName = "FullScreenshot." + format;	            	            
	            JFileChooser fc=new JFileChooser();    
	            int i=fc.showOpenDialog(this);    
	            Thread.sleep((long)500);
	            if(i==JFileChooser.APPROVE_OPTION){    
	                File f=fc.getSelectedFile();    
	                String filepath=f.getPath();   	    	                	               
		            BufferedImage img = new BufferedImage(this.getWidth(), this.getHeight()-50, BufferedImage.TYPE_3BYTE_BGR);
		            this.paint(img.getGraphics());
		            File outputfile = new File(filepath+".jpg");
		            ImageIO.write(img, "jpg", outputfile);
		            JOptionPane.showMessageDialog(this,"YOUR MARKSHEET IS SAVED","Alert",JOptionPane.WARNING_MESSAGE);
	            }    
	            
	        } catch (AWTException | IOException | InterruptedException ex) {
	            System.err.println(ex);
	        }
		}
		if(arg0.getSource()==back)
		{
			this.dispose();
			new LayOut();
		}		
	}
	
	void getGrade(int i)
	{
		float obt=Float.parseFloat(l.tsubpr[i].getText())+Float.parseFloat(l.tsubth[i].getText());
		float total=Float.parseFloat(l.tsubprx[i].getText())+Float.parseFloat(l.tsubthx[i].getText());;
		float persent1=(obt*100)/total;
		int persent=(int)persent1;
		
		if(persent<=35)
		{
			lgrade[i].setText("F");						
		}
		if(persent>=85 && persent<=100)
		{
			lgrade[i].setText("A");
		}
		if(persent>=70 && persent<=84)
		{
			lgrade[i].setText("B");
		}
		if(persent>=50 && persent<=69)
		{
			lgrade[i].setText("C");
		}
		if(persent>=35 && persent<=49)
		{
			lgrade[i].setText("D");
		}		
		
	}
}