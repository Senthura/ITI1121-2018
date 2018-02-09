import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener  {

    private Counter model;

    private View[] views;
    private int numberOfViews;

    public Controller() {

        views = new View[2];
        numberOfViews = 0;

        model = new Counter();

        register(new GraphicalView(model, this));
        register(new TextView(model));

        update();

    }

    private void register(View view) {
        views[numberOfViews] = view;
        numberOfViews++;
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Increment")) {
            model.increment();
        } else if (e.getActionCommand().equals("Reset")) {
            model.reset();
        } else {
            System.err.println("Unknown action: " + e.getActionCommand());
            System.exit(0);
        }

        update();
    }

    private void update() {
        for (int i=0; i<numberOfViews; i++) {
            views[i].update();
        }
    }

}
