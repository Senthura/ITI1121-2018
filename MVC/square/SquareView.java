import java.awt.GridLayout;
import javax.swing.*;

public class SquareView extends JFrame implements View {

    // Instance Variables

    private JTextField input;

    private SquareModel model;

    // Constructor
    
    public SquareView(SquareModel model, SquareController controller) {

        super("Square GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1,2));

        this.model = model;

        JButton button;
        button = new JButton("Square");
        button.addActionListener(controller);
        add(button);

        input = new JTextField();
        input.addActionListener(controller);
        input.addFocusListener(controller);
        add(input);

        pack();
        setVisible(true);
    }

    public void update() {
        input.setText(Long.toString(model.getValue()));
    }

    public Long getTheCurrentValue(){
        return Long.parseLong(input.getText());
    }
    
   
}
