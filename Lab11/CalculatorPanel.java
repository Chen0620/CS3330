//A panel with calculator buttons and a result display.
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

class CalculatorPanel extends JPanel
{
	  private JTextField display;
      private JPanel panel;
      private JPanel panel2;
      private String firstNumber;
      private String nextNumber;
      private int state;
      private String op;
      private int count=0;

      public CalculatorPanel() 
      {
            setLayout(new BorderLayout());

            firstNumber = "";
            nextNumber = "";
            state = 0;  //the current state of the calculator

            // add the display
            display = new JTextField(firstNumber);
            display.setEnabled(true);
            add(display, BorderLayout.NORTH);
 
            /*ActionListener for number insertions*/
            ActionListener insert = new InsertAction();
            /*ActionListener for operator insertion*/
            ActionListener command = new CommandAction();
            /*ActionListener for resetting*/
            ActionListener clear = new ClearAction();

            // add the buttons in a 4 x 4 grid
            panel = new JPanel();
            panel.setLayout(new GridLayout(4,4));
            panel2 = new JPanel();
            panel2.setLayout(new GridLayout(1,2));

            JButton J1 = new JButton("7");
            J1.addActionListener(insert);
            panel.add(J1);

            JButton J2 = new JButton("8");
            J2.addActionListener(insert);
            panel.add(J2);

            JButton J3 = new JButton("9");
            J3.addActionListener(insert);
            panel.add(J3);

            JButton J4 = new JButton("+");
            J4.addActionListener(command);
            panel.add(J4);
            
            JButton J5 = new JButton("4");
            J5.addActionListener(insert);
            panel.add(J5);

            JButton J6 = new JButton("5");
            J6.addActionListener(insert);
            panel.add(J6);

            JButton J7 = new JButton("6");
            J7.addActionListener(insert);
            panel.add(J7);

            JButton J8 = new JButton("-");
            J8.addActionListener(command);
            panel.add(J8);

            JButton J9 = new JButton("1");
            J9.addActionListener(insert);
            panel.add(J9);

            JButton J10 = new JButton("2");
            J10.addActionListener(insert);
            panel.add(J10);

            JButton J11 = new JButton("3");
            J11.addActionListener(insert);
            panel.add(J11);

            JButton J12 = new JButton("*");
            J12.addActionListener(command);
            panel.add(J12);
            
            JButton J13 = new JButton("0");
            J13.addActionListener(insert);
            panel.add(J13);

            JButton J14 = new JButton(".");
            J14.addActionListener(insert);
            panel.add(J14);

            JButton J15 = new JButton("%");
            J15.addActionListener(command);
            panel.add(J15);

            JButton J16 = new JButton("/");
            J16.addActionListener(command);
            panel.add(J16);
            
            add(panel,BorderLayout.CENTER);

            JButton J17 = new JButton("CL");
            J17.addActionListener(clear);
            panel2.add(J17);

            JButton J18 = new JButton("=");
            J18.addActionListener(command);
            panel2.add(J18);

            add(panel2,BorderLayout.SOUTH);
      }
      
      //This action inserts the button action string to the end of the display text.
      private class InsertAction implements ActionListener 
      {
              public void actionPerformed(ActionEvent event) 
              {
                    String input = event.getActionCommand();
                    if(input==".")
                    {
                    	if(op==""&&nextNumber=="")
                    	{
                    		if(display.getText().length()>0&&Double.parseDouble(display.getText())!=0)
                    		{
                    			if(Double.parseDouble(display.getText())%1==0)
	                    			count=0;
	                    		else
	                    			count=1;
                    		}
                    	}
                    	count++;
                    }
                    if(count>1)
                    {
                    	count=1;
                    	return;
                    }
                    else
                    {
	                    if (state == 0) 
	                    {
	                        if(op!="")
	                        {
	                        	if(op!=null)
	                        		op="";
	                        	if(firstNumber==""&&input==".")
	                            	firstNumber="0.";
	                        	else
	                        		firstNumber=firstNumber+input;
	                        }
	                        else
	                        {
	                        	if(firstNumber==""&&input==".")
	                            	firstNumber="0.";
	                        	else
	                        		firstNumber=firstNumber+input;
	                        }
	                        display.setText(firstNumber);
	                        
	                    }
	                    if (state==1) 
	                    {
	                	    if(nextNumber==""&&input==".")
	                	    {
	                		    nextNumber="0.";
	                		    display.setText(display.getText()+nextNumber);
	                	    }
	                	    else
	                	    {
	                		    nextNumber=nextNumber+input;
	                		    display.setText(display.getText()+input);
	                	    }
	                    }
                    }
              }
      }
      
      //This action executes the command that the button action string denotes.
      private class CommandAction implements ActionListener 
      {
              public void actionPerformed(ActionEvent event) 
              {
            	  String inputCommand = event.getActionCommand();
            	  if(inputCommand!="=")
            	  {
            		  if(op!=""&&nextNumber!="")
            		  {
            			  if(calculate()%1==0)
            				  display.setText(Integer.toString((int)calculate()));
            			  else
            				  display.setText(Double.toString(calculate()));
            				  
            			  nextNumber="";
            			  firstNumber=display.getText();
            		  }
            		  else if(op!=""&&nextNumber=="")
            		  {
            			  display.setText(firstNumber);
            		  }
        			  count=0;
            		  op=inputCommand;
            		  display.setText(display.getText()+op);
            		  state=1;
            	  }
            	  else
            	  {
            		  if(op==""||nextNumber=="")
            		  {
            			  display.setText(display.getText());
            		  }
            		  else
            		  {
	            		  if(calculate()%1==0)
	        				  display.setText(Integer.toString((int)calculate()));
	            		  else
	            			  display.setText(Double.toString(calculate()));
	            		  firstNumber=display.getText();
	            		  nextNumber="";
	            		  state=0;
	        			  count=0;
	        			  op="";
            		  } 
            	  }          	  
              }
      }
      
      private class ClearAction implements ActionListener 
      {
    	  public void actionPerformed(ActionEvent event) 
	      {
	      		display.setText("");
    		  	op="";
	      		firstNumber="";
	      		nextNumber="";
	      		state=0;
	      		count=0;
          }
      }
      
      //Carries out calculation.
      private double calculate() 
      {
            if (op.equals("+")) 
            {
                  return Double.parseDouble(firstNumber)+Double.parseDouble(nextNumber);
            }
            else if(op.equals("-")) 
            {
                  return Double.parseDouble(firstNumber)-Double.parseDouble(nextNumber);
            } 
            else if (op.equals("*"))
            {
            	return Double.parseDouble(firstNumber)*Double.parseDouble(nextNumber);
            } 
            else if (op.equals("/")) 
            {
            	return Double.parseDouble(firstNumber)/Double.parseDouble(nextNumber);
            } 
            else if (op.equals("%"))
            	return Double.parseDouble(firstNumber)%Double.parseDouble(nextNumber);

            return 0;
      }
}
      