import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GraphicalView extends JFrame implements View {

    // Instance Variables

    private JLabel input;

    private Counter model;

    // Constructor
    
    public GraphicalView(Counter model, Controller controller) {

        setTitle("Counter MVC Example");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,3));

        this.model = model;

        JButton button;
        button = new JButton("Increment");
        button.addActionListener(controller);
        add(button);

        JButton reset;
        reset = new JButton("Reset");
        reset.addActionListener(controller);
        add(reset);

        input = new JLabel(Integer.toString(model.getValue()),javax.swing.SwingConstants.CENTER);
        add(input);

        setResizable(false);
        
        pack();
        setVisible(true);
    }

    public void update() {
        input.setText(Integer.toString(model.getValue()));
    }

}
