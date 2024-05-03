import javax.swing.*; 
public class Frameexample{ 
 
 public static void main(String[] args){ 
JFrame f=new JFrame("Login Form"); 
 
JLabel l=new JLabel("Username:"); 
l.setBounds(60,100,100,40); 
JTextField t=new JTextField(); 
t.setBounds(130,100,100,40); 
 
JLabel l1=new JLabel("Password:"); 
l1.setBounds(60,160,100,40); 
 
JPasswordField p=new JPasswordField(); 
p.setBounds(130,160,100,40); 
 
 JCheckBox c=new JCheckBox("I agree"); 
c.setBounds(130,200,120,40); 
 
 JButton b=new JButton("login"); 
b.setBounds(130,250,100,40); 
 
 f.add(b); 
 f.add(t); 
 f.add(p); 
 f.add(l); 
 f.add(c); 
 
 
 
 f.add(l1); 
 
 f.setSize(400,500); 
 f.setLayout(null); 
 f.setVisible(true); 
} 
}