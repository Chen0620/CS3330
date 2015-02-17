//A frame with a calculator panel.
import javax.swing.JFrame;

class CalculatorFrame extends JFrame 
{
      public CalculatorFrame() 
      {
            super("Java Calculator");
            CalculatorPanel panel = new CalculatorPanel();
            add(panel);
            pack();
      }
}