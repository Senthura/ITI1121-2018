public class SquareTextView implements View {

    // Instance Variables
    private SquareModel model;

    // Constructor    
    public SquareTextView(SquareModel model) {

        this.model = model;
    }

    public void update() {
        System.out.println(model);
    }
  
}
