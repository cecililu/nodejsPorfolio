import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import javax.swing.border.LineBorder;
import java.io.IOException;

public class Mainframe extends JFrame implements ActionListener {
	private TextField alpha;
	private TextField beta;
	// private TextField BAC;
	// private TextField AB;
	// private TextField AC;
	// private TextField x;
	// private TextField y;
	private TextField XA;
	private TextField YA;
	private TextField XB;
	private TextField YB;
	private TextField XC;
	private TextField YC;
	private TextField XP;
	private TextField YP;
    private TextField rem;
	// private ImageIcon imagehelp;
        //  private JLabel help;
	
	private JButton button;
//constructor for the class

	public Mainframe(){
        super();
        this.setTitle("RESECTION Calculator");
        this.setSize(1000,600);
        this.setLocation(70,70); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JLabel botton1=new JLabel("Resection Calculator",SwingConstants.CENTER);
        botton1.setFont(new Font("Serif", Font.PLAIN, 30));
        JButton botton2=new JButton("Help");
        botton2.setPreferredSize(new Dimension(100, 100));
        JButton botton3=new JButton("About");
        JButton botton4=new JButton("CLEAR");
                
        JFrame f= new JFrame();  
        JDialog d = new JDialog(f , "Resection Calculator version 0.1.1 by Group 1", true);  
        d.setLayout( new CardLayout() );  
        d.add( new JLabel ("<html>About<br/>Resection Calculator v-0.1.1<br/>Cecil Ghimire <br/>Aadarsha dhakal<br/> Reeya Pokhrel <br/>Aneel Basnet</html>",SwingConstants.CENTER));
        

        d.setSize(300,300);    
        d.setVisible(false); 
        d.setLocation(100,100);
        
        botton3.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
               d.setVisible(true);  
            }  
        });  

        JFrame f1= new JFrame(); 
        JDialog d1 = new JDialog(f1 , "Help Dialogue box 1", true);  
        d1.setLayout( new CardLayout() );  
        d1.add( new JLabel ("<html> <center><i><u>Help</u><i/></center> <p><ul>In surveying, resection is a method of determining a location of unknown point in relation to known points.</ul> <ul>The instrument can be freely positioned so that all survey points are at suitable sight from the instrument.</ul> <br> <ul>If the unknown point P lies on a circle defined by the three known points then the solution is indeterminate or not uniquely possible. There are, theoretically, an infinite number of solutions for the observed angles. If the geometry is close to this, the solution is weak. In addition, there is no solution to this problem when all the points lie on a straight or nearly straight line. With the calculated coordinates and orientation of the instrument, it can be used to set out points in construction surveying, machine guidance, site plan or other types of surveys. <br> <b>Here, you need to input coordinates of 3 known points in meters and observed angles, α and β, in decimal degrees.</ul></p> <br/>The output is the coordinates of unknown point P in meters.</b>  </html>"));
        d1.setSize(500,500);    
        d1.setVisible(false); 
        d1.setLocation(200,200);
        
        botton2.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {  
               d1.setVisible(true);  
            }  
        });  
        

         
        botton4.addActionListener ( new ActionListener()  
        {  
            public void actionPerformed( ActionEvent e )  
            {   alpha.setText("");
                beta.setText("");
                XA.setText(" ");
	        YA.setText(" ");
	        XB.setText(" ");
	        YB.setText(" ");
                XC.setText(" ");
                YC.setText(" ");
	        XP.setText(" ");
	        YP.setText(" ");
                rem.setText(" ");
            }  
        });  


        botton2.setBackground(new Color(30, 61, 89));
        botton2.setForeground(Color.WHITE);
        botton3.setBackground(new Color(30, 61, 89));
        botton3.setForeground(Color.WHITE);
        botton4.setBackground(new Color(250, 12, 12));
        botton4.setForeground(Color.WHITE);
      

        Container mainContainer=this.getContentPane();


        mainContainer.setLayout(new BorderLayout(8,6));
        mainContainer.setBackground(new Color(255, 110, 64));

        //creating panels
        JPanel topPanel=new JPanel();
        topPanel.setBorder(new LineBorder(new Color(245, 240, 225),1));
        topPanel.setBackground(new Color(245, 240, 225));
        topPanel.setLayout(new FlowLayout(1));
        topPanel.add(botton1);
        mainContainer.add(topPanel,BorderLayout.NORTH);

       //panel sidepanel

        JPanel midPanel=new JPanel();
        midPanel.setLayout(new FlowLayout(2));
        midPanel.setBorder(new LineBorder(new Color(245, 240, 225),1));
        midPanel.setBackground(new Color(255, 193, 59));
        
        JPanel gridPanel=new JPanel();
        gridPanel.setLayout(new GridLayout(3,1,100,20));
        gridPanel.setBorder(new LineBorder(new Color(245, 240, 225),0));
        gridPanel.setBackground(new Color(255, 193, 59));
        gridPanel.add(botton2);

        //imagehelp=new ImageIcon(getClass().getResource("help.png"));
        //imagehelp=new ImageIcon(imagehelp.getImage().getScaledInstance(25, 30, Image.SCALE_DEFAULT));
        //help=new JLabel(imagehelp);
        //gridPanel.add(help);

        gridPanel.add(botton3);
        gridPanel.add(botton4);
        midPanel.add(gridPanel);     
        mainContainer.add(midPanel ,BorderLayout.WEST);
       
      // main calculation panel
        JPanel wPanel=new JPanel();
        wPanel.setLayout(new GridLayout(12,2,10,0));
        wPanel.setBorder(new LineBorder(new Color(30, 61, 89),10));
        wPanel.setBackground(new Color(30, 61, 89));
               JLabel label1=new JLabel("Enter beta angle: ");
                label1.setForeground(Color.WHITE);
                wPanel.add( label1);
	        beta=new TextField();
	        wPanel.add(beta);  

               JLabel label2=new JLabel("Enter alpha angle: ");
               label2.setForeground(Color.WHITE);
               wPanel.add( label2);
 	       alpha=new TextField(15);
 	       wPanel.add(alpha);   
 
                // JLabel label3=new JLabel("Enter BAC angle: ");
                // label3.setForeground(Color.WHITE);
                // wPanel.add(label3);
		// BAC=new TextField(15);
		// wPanel.add(BAC);
		
                // JLabel label4=new JLabel("Enter AB:");
                // label4.setForeground(Color.WHITE);
		// wPanel.add(label4);
		// AB=new TextField(15);
		// wPanel.add(AB);


                // JLabel label5=new JLabel("Enter AC: ");
                // label5.setForeground(Color.WHITE);
		// wPanel.add( label5);
		// AC=new TextField(15);
		// wPanel.add(AC);
		
                JLabel label6=new JLabel("Enter X coordinate of A:");
                label6.setForeground(Color.WHITE);
		wPanel.add(label6);
		XA=new TextField(15);
		wPanel.add(XA);
		
		JLabel label7=new JLabel("Enter Y coordinate of A:");
                label7.setForeground(Color.WHITE);
                wPanel.add(label7);
		YA=new TextField(15);
		wPanel.add(YA);
		
		JLabel label8=new JLabel("Enter X coordinate of B:");
                label8.setForeground(Color.WHITE);
                wPanel.add( label8);
		XB=new TextField(15);
		wPanel.add(XB);
		
		JLabel label9=new JLabel("Enter Y coordinate of B:");
                label9.setForeground(Color.WHITE);
                wPanel.add(label9);
		YB=new TextField(15);
		wPanel.add(YB);
		
		JLabel label10=new JLabel("Enter X coordinate of C:");
                label10.setForeground(Color.WHITE);
                wPanel.add(label10);
		XC=new TextField(15);
		wPanel.add(XC);
		
		JLabel label11=new JLabel("Enter Y coordinate of C:");
                label11.setForeground(Color.WHITE);
                wPanel.add(label11);
		YC=new TextField(15);
		wPanel.add(YC);

                
                JPanel bottomPanel=new JPanel();
                bottomPanel.setLayout(new FlowLayout(3
                ));
                bottomPanel.setBorder(new LineBorder(new Color(245, 240, 225),50));
                bottomPanel.setBackground(new Color(245, 240, 225));
             

                button = new JButton("Calculate and Generate Report");
                button.setBackground(new Color(50, 168, 82));
                button.setForeground(Color.WHITE);
                button.setPreferredSize(new Dimension(100,100));
                wPanel.add(button);
                button.addActionListener(this);
                
               
                // JLabel label12=new JLabel("x :");
                // label12.setFont(new Font("Serif", Font.PLAIN,30));
                // label12.setForeground(Color.BLACK); 
                // bottomPanel.add(label12);
		// x=new TextField(15);
		// bottomPanel.add(x);

                // JLabel label13=new JLabel("y:");
                // label13.setFont(new Font("Serif", Font.PLAIN, 30));
                // label13.setForeground(Color.BLACK);
	        // bottomPanel.add(label13);
		// y=new TextField(15);
	        // bottomPanel.add(y);
			
                
                bottomPanel.add(new Label("X coordinate of P:"));
		XP=new TextField(15);
		bottomPanel.add(XP);
		bottomPanel.add(new Label("Y coordinate of P:"));
		YP=new TextField(15);
		bottomPanel.add(YP);
         
        rem=new TextField(30);
        bottomPanel.add(new Label("Remarks Panel"));
		bottomPanel.add(rem);
                
                mainContainer.add(bottomPanel,BorderLayout.SOUTH);
                mainContainer.add(wPanel,BorderLayout.CENTER);
              
       }
public void actionPerformed(ActionEvent e){
		String num1 = beta.getText();
         Double Beta = Double.parseDouble(num1);
		 String num2 = alpha.getText();
         Double Alpha = Double.parseDouble(num2);
	//	String num3 = BAC.getText();
        // Double bac = Double.parseDouble(num3);
	//	 String num4 = AB.getText();
        // Double ab = Double.parseDouble(num4);
	//	  String num5 = AC.getText();
        // Double ac = Double.parseDouble(num5);
		 String num6 = XA.getText();
         Double xa = Double.parseDouble(num6);
		 String num7 = YA.getText();
         Double ya = Double.parseDouble(num7);
		  String num8 = XB.getText();
         Double xb = Double.parseDouble(num8);
		 String num9 = YB.getText();
         Double yb = Double.parseDouble(num9);
		  String num10 = XC.getText();
         Double xc = Double.parseDouble(num10);
		 String num11 = YC.getText();
         Double yc = Double.parseDouble(num11);
         double b1=0;
         double b2=0; 
        double phi,dist_AB,dist_BC,s,q,theta,dist_PB,cbp,bp,bpx,bpy,ep,np;
//calculating bearing for the ab
		if(xa>xb && ya>yb){
	                  b1=(Math.atan((xa-xb)/(ya-yb)))*180/Math.PI;
               }
	      else if(xa<xb && ya>yb){
			   b1=360-Math.abs(Math.atan(((xa-xb)/(ya-yb)))*180/Math.PI);
			    
		       }
		 else if(xa<xb && ya<yb){
			   
			   b1=Math.abs(Math.atan(((xa-xb)/(ya-yb)))*180/Math.PI)+ 180;
	
	        }
		  else if(xa>xb && ya<yb){
			   b1= 180-Math.abs(Math.atan(((xa-xb)/(ya-yb)))*180/Math.PI);
	     }
              
//calculating bearing for the bc
                    if(xc>xb && yc>yb){
	          b2=(Math.atan((xc-xb)/(yc-yb)))*180/Math.PI;
                  }
	      else if(xc<xb && yc>yb){
			   b2=360-Math.abs(Math.atan(((xc-xb)/(yc-yb)))*180/Math.PI);
			    
		       }
		 else if(xc<xb && yc<yb){
			   
			   b2=Math.abs(Math.atan(((xc-xb)/(yc-yb)))*180/Math.PI)+ 180;
	
	        }
		  else if(xc>xb && yc<yb){
			   b2= 180-Math.abs(Math.atan(((xc-xb)/(yc-yb)))*180/Math.PI);
		    }
               
		   
		phi=(b1-b2);
                dist_AB=Math.sqrt(Math.pow((xb-xa),2)+Math.pow((yb-ya),2));
                dist_BC=Math.sqrt(Math.pow((xb-xc),2)+Math.pow((yb-yc),2));       	
		s=(360-Alpha-Beta-phi);
                q=(dist_AB*Math.sin(Beta*Math.PI/180))/(dist_BC*Math.sin(Alpha*Math.PI/180));
                theta=(Math.atan(Math.sin(s*Math.PI/180)/(q+Math.cos(s*Math.PI/180))))*180/Math.PI;
                dist_PB=(dist_AB*(Math.sin(theta*Math.PI/180))/Math.sin(Alpha*Math.PI/180));
                cbp=180-Beta-s+theta;
                bp=b2+cbp;
                bpx=dist_PB*Math.sin(bp*Math.PI/180);
                bpy=dist_PB*Math.cos(bp*Math.PI/180);
                ep=xb+bpx;
                np=yb+bpy;
                
                XP.setText(ep+" ");
		YP.setText(np+" ");
        if (Beta<=0 || Alpha <=0){

            rem.setText("Please enter positive or non zero value for alpha and beta");
            
            XP.setText("Input error ");
            YP.setText("Input error ");
        }
        if (Beta>360 || Alpha >360){

                rem.setText("Please enter angle less than 360");
                
                XP.setText("Input error ");
                YP.setText("Input error ");
            }

               try{

               // File myObj = new File("filename.txt");
                FileWriter myWriter = new FileWriter("filename.txt");
                myWriter.write("Report of the Resection Calculator");
                myWriter.write(System.getProperty( "line.separator" )); 
		myWriter.write(System.getProperty( "line.separator" )); 
                 myWriter.write("1. "+"A coordinate : "+xa+"  "+ya);
		 myWriter.write(System.getProperty( "line.separator" )); 
                  myWriter.write("2. "+"B coordinate : "+xb+"  "+yb);
		 myWriter.write(System.getProperty( "line.separator" )); 
                    myWriter.write("3. "+"C coordinate : "+xc+"  "+yc);
		myWriter.write(System.getProperty( "line.separator" )); 
                 myWriter.write("4. "+"Distance AB : "+dist_AB);
		myWriter.write(System.getProperty( "line.separator" )); 
                 myWriter.write("5. "+"Distance BC : "+dist_BC);
                 myWriter.write(System.getProperty( "line.separator" ));
                   myWriter.write("6. "+"phi angle : "+phi);
                 myWriter.write(System.getProperty( "line.separator" ));
                   myWriter.write("7. "+"theta : "+theta);
                  



                  myWriter.write(System.getProperty( "line.separator" ));
                 myWriter.write("8. "+"Coordinate of P (x,y): "+"("+ep+","+np+")");
                
                  
                 myWriter.close();
                 }
                 catch(IOException ee) {
     		 System.out.println("An error occurred.");
      		ee.printStackTrace();
    			}
              
	}        
     
public static void main(String [] args){

    Mainframe frame=new Mainframe();
    frame.setVisible(true);
}
 
}