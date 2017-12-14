
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TemperatureWindow extends JFrame implements ActionListener {
 private Container pane;

 private JButton b;
 private JLabel l;
    private JTextField t0,t1;
 private JCheckBox c;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public TemperatureWindow() {
     this.setTitle("My first GUI");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  //NOTE!! THIS CAN BE CHANGED (see below)
    
     b = new JButton("Convert to Celcius");
     l = new JLabel("This is AWESOME! (lies)",null,JLabel.CENTER);
     t0 = new JTextField(50);
     t1 = new JTextField(50);
     c = new JCheckBox("Overclock!!!");
     pane.add(l);
     pane.add(b);
     pane.add(t0);
     pane.add(t1);
     pane.add(c);
 }
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	System.out.println(event);
	if (event.equals("Convert to Celcius")){
	        String temp = t0.getText();
		t1.setText(Double.toString(Temperature.FtoC(Double.parseDouble(temp))));
	}
    }
	
	

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     TemperatureWindow g = new TemperatureWindow();
     g.setVisible(true);
  }
}
