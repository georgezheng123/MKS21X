import javax.swing.*;
import java.awt.*;
public class Window extends JFrame implements ActionListener{
 private Container pane;

 private JButton b;
 private JLabel l;
 private JTextField t;
 private JCheckBox c;
 
  //CONSTRUCTOR SETS EVERYTHING UP
  public Window() {
     this.setTitle("My first GUI");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  
    
     b = new JButton("toF");
     l = new JLabel("Temperature Converter",null,JLabel.CENTER);
     t = new JTextField(12);
     pane.add(l);
     pane.add(b);
     pane.add(t);
 }

 public double CtoF(double t){
    return (9.0/5.0)*t + 32;
}

public double FtoC(double t){
    return (5.0/9.0)*t - 32;
}


  //MAIN JUST INSTANTIATES + MAKE VISIBLE
  public static void main(String[] args) {
     Window g = new Window();
     g.setVisible(true);
  }
}
