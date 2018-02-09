import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Square extends JFrame implements ActionListener {

	private JButton bSquare;
	private JButton bQuit;

	private JTextField input;

	public Square(){
		super("Square calculator");
		bSquare = new JButton("Square");
		bQuit = new JButton("Quit");
		input = new JTextField();
		setLayout(new GridLayout(1,3));
		add(bSquare);
		add(input);
		add(bQuit);

		bSquare.addActionListener(this);
		bQuit.addActionListener(this);

		pack();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void computeSquare(){
		int v = Integer.parseInt(input.getText());
		input.setText(Integer.toString(v*v));
	}

	public void actionPerformed(ActionEvent e){
		if(e.getSource() == bSquare) {
			computeSquare();
		} else if (e.getSource() == bQuit) {
			System.exit(0);
		}
	}
}
*/

