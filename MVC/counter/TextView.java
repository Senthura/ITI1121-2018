public class TextView implements View {

    private Counter model;

    public TextView(Counter model) {
        this.model = model;
    }

    public void update() {
        System.out.println(model);
    }
    
   
}
