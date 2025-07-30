import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Converter extends JFrame{
	private JTextField tf1 = new JTextField(8);
	private JTextField tf2 = new JTextField(8);
	private JRadioButton [] Conv = new JRadioButton[4];
	private String [] options = {"decimal", "binary", "octal", "hex"};
	public Converter() {
		setTitle("Digit Changer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(tf1);
		c.add(new JLabel("->"));
		c.add(tf2);
		
		for(int i = 0;i<Conv.length;i++) {
			Conv[i] = new JRadioButton(options[i]);
			c.add(Conv[i]);
			Conv[i].addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED) {
						if(e.getItem() == Conv[0]) {
							tf2.setText(Integer.toString(Integer.parseInt(tf1.getText())));
						}
						else if(e.getItem() == Conv[1]) {
							tf2.setText(Integer.toBinaryString(Integer.parseInt(tf1.getText())));
						}
						else if(e.getItem() == Conv[2]) {
							tf2.setText(Integer.toOctalString(Integer.parseInt(tf1.getText())));
						}
						else {
							tf2.setText(Integer.toHexString(Integer.parseInt(tf1.getText())));
						}
					}
				}
			});
		}
		setSize(250, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Converter();
		System.out.println("202221079 홍신영");
	}
}
