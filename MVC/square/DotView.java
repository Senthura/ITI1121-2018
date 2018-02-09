import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class DotView extends JPanel {

    private static final int DISPLAY_SIZE = 500;
 
    private SquareModel model;

    // Constructor
    
    public DotView(SquareModel model) {

            this.model = model;

        setBackground(Color.WHITE);
    }

    public Dimension getPreferredSize() {
        return new Dimension(DISPLAY_SIZE,DISPLAY_SIZE);
    }

    public void paint(Graphics g) {
        super.paint(g);
 
        long currentVal = model.getValue();
        int oneRow = (int)Math.ceil(Math.sqrt(currentVal));
        if(oneRow == 0){
            return;            
        }

        int dotWidth = DISPLAY_SIZE/(oneRow);
 
        if(dotWidth == 0){
            g.drawString("Too many to fit", DISPLAY_SIZE/2-30, 
                            DISPLAY_SIZE/2);
            return;            
        }
        
        int remainder = DISPLAY_SIZE%(oneRow);

        g.setColor( Color.BLUE );
        int numberDrawn = 0;
        int currentY = -dotWidth;
        int currentX;
        for(int i = 0; i < oneRow; i++){
            currentY += dotWidth;
            if(i<remainder)
                currentY++;
            currentX = -dotWidth;
            for(int j=0; j < oneRow; j++){
                currentX += dotWidth;
                if(j<remainder)
                    currentX++;
                g.fillOval( currentX, 
                            currentY, 
                            dotWidth, dotWidth );
                numberDrawn++;
                if(numberDrawn == currentVal)
                    return;
            }
        }
    }
   
}
