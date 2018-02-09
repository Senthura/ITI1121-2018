import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class SquareController implements ActionListener, FocusListener {

    private SquareModel model;

    private View[] views;
    private int numberOfViews;

    private SquareView squareView;

    public SquareController(int value) {

        model = new SquareModel(value);

        views = new View[3];

        numberOfViews = 0;

        squareView = new SquareView(model, this);
        register(squareView);

        AlternateSquareView altView;
        altView = new AlternateSquareView(model,this);
        register(altView);

        register(new SquareTextView(model));

        altView.setLocation(squareView.getX()+squareView.getWidth()+10, 
            squareView.getY());

        update();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() instanceof JButton) {
            model.square();
            update();

        }

    }

    public void focusGained(FocusEvent e){
        //nothing
    }

    public void focusLost(FocusEvent e){
        if(e.getSource() instanceof JTextField) {
            model.setValue(squareView.getTheCurrentValue());
        }
    }

    private void register(View view) {
        views[numberOfViews] = view;
        numberOfViews++;
    }

    private void update() {
        for (int i=0; i<numberOfViews; i++) {
            views[i].update();
        }
    }

}
