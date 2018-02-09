import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.Color;

public class AlternateSquareView extends JFrame implements View {

 
    // Constructor
    
    public AlternateSquareView(SquareModel model, SquareController controller) {

        super("Square Alternate GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(Color.white);


            JButton button = new JButton("Square");
        button.addActionListener(controller);
        button.setBackground(Color.white);

        JPanel bPanel = new JPanel();
        bPanel.setBackground(Color.white);
        bPanel.add(button);
        add(bPanel, BorderLayout.SOUTH);

        add(new DotView(model),BorderLayout.CENTER);

        pack();
        setResizable(false);
        setVisible(true);
    }

    public void update() {
           repaint();
    }
    
   
}
