import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Window extends JFrame implements ActionListener{

 private JButton FtoC;
 private JButton CtoF;
 private Container pane;
 private JTextField t;

  //MAIN JUST INSTANTIATES + MAKE VISIBLE
 public static void main(String[] args) {
     Window g = new Window();
     g.setVisible(true);
 }

  //CONSTRUCTOR SETS EVERYTHING UP
 public Window() {
     this.setTitle("Convert FtoC and CtoF");
     this.setSize(600,400);
     this.setLocation(100,100);
     this.setDefaultCloseOperation(EXIT_ON_CLOSE);

     pane = this.getContentPane();
     pane.setLayout(new FlowLayout());  

     t = new JTextField(12);
     FtoC = new JButton("FtoC");
     CtoF = new JButton("CtoF");

     t.addActionListener(this);
     pane.add(t);

     FtoC.addActionListener(this);
     pane.add(FtoC);

     CtoF.addActionListener(this);
     pane.add(CtoF);
 }

 public static double CtoF(double t){
    return 1.8*t + 32;
}

public static double FtoC(double t){
    return (5.0/9.0)*(t - 32);
}

public void actionPerformed(ActionEvent e){
    String s = e.getActionCommand();
    if (s.equals("CtoF")) t.setText(CtoF(Double.parseDouble(t.getText()))+"");
    if (s.equals("FtoC")) t.setText(FtoC(Double.parseDouble(t.getText()))+"");
}

}
