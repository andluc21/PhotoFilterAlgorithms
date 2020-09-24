import java.awt.*;

public class Main {

    public static DrawingPanel canvas;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public static void posterize() {
        DrawingPanel posterize = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {
                int oldValue = canvas.getPixel(x,y).getRed();
                int newValue = 0;
                int r = 0;
                int g = 0;
                int b = 0;
                // Loops through red, green, and blue and updates their value
                for (int idx = 0; idx < 3; idx++) {
                    if(oldValue < 64) {
                        newValue = 31;
                    } else if(oldValue >= 64 && oldValue <= 128) {
                        newValue = 95;
                    } else if(oldValue >= 128 && oldValue <= 192) {
                        newValue = 159;
                    } else {
                        newValue = 223;
                    }

                    if (idx == 0) {
                        r = newValue;
                        oldValue = canvas.getPixel(x,y).getGreen();
                    }
                    else if (idx == 1){
                        g = newValue;
                        oldValue = canvas.getPixel(x,y).getBlue();
                    }
                    else
                        b = newValue;
                }

                posterize.setPixel(x, y, new Color(r, g, b));
            }
        }
    } 

    public static void increaseContrast() {
        DrawingPanel increaseContrast = new DrawingPanel(WIDTH, HEIGHT);
        double oldValue1;
        double newValue1;
        double oldValue2;
        double newValue2;
        double oldValue3;
        double newValue3;

        int r,g,b;

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {
                oldValue1 = canvas.getPixel(x,y).getRed();
                oldValue2 = canvas.getPixel(x,y).getGreen();
                oldValue3 = canvas.getPixel(x,y).getBlue();
                if(oldValue1 > 125) {
                    newValue1 = Math.min(255,(oldValue1 * 1.15));
                } else  {
                    newValue1 = (oldValue1 / 1.15);}
                if(oldValue2 > 125) {
                    newValue2 = Math.min(255,(oldValue2 * 1.15));
                } else  {
                    newValue2 = (oldValue2 / 1.15);}
                if(oldValue3 > 125) {
                    newValue3 = Math.min(255,(oldValue3 * 1.15));
                } else  {
                    newValue3 = (oldValue3 / 1.15);}

                r = (int)Math.round(newValue1);     
                g = (int)Math.round(newValue2);
                b = (int)Math.round(newValue3);
                increaseContrast.setPixel(x, y, new Color(r, g, b));
            }

        }
    }

    public static void negative() {
        DrawingPanel negative = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {

                int newRed = 255 - canvas.getPixel(x, y).getRed();
                int newBlue = 255 - canvas.getPixel(x, y).getBlue();
                int newGreen = 255 - canvas.getPixel(x, y).getGreen();

                negative.setPixel(x, y, new Color(newRed, newGreen, newBlue));
            }
        }
    } 

    public static void lineDetection() {
        DrawingPanel lineDetection = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {
                int oldValueR = canvas.getPixel(x,y).getRed();
                int oldValueG = canvas.getPixel(x,y).getGreen();
                int oldValueB = canvas.getPixel(x,y).getBlue();
                int newValue = 0;
                int r = 0;
                int g = 0;
                int b = 0;                                             

                int cornerValueR = canvas.getPixel(x + 1,y + 1).getRed();
                int cornerValueG = canvas.getPixel(x + 1,y + 1).getGreen();
                int cornerValueB = canvas.getPixel(x + 1,y + 1).getBlue();

                int sum = oldValueR + oldValueG + oldValueB;
                int sum2 = cornerValueR + cornerValueG + cornerValueB;
                int diff = Math.abs(sum2-sum);
                int diff2 = Math.min(255,diff);

                {   r = diff2;

                    g = diff2;

                    b = diff2;
                }

                lineDetection.setPixel(x, y, new Color(r, g, b));

            }
        }
    }         

    public static void somethingUnique() {
        DrawingPanel somethingUnique = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {
                int oldValueR = canvas.getPixel(x,y).getRed();
                int oldValueG = canvas.getPixel(x,y).getGreen();
                int oldValueB = canvas.getPixel(x,y).getBlue();
                int newValue = 0;
                int r = 0;
                int g = 0;
                int b = 0;                                             

                int cornerValueR = canvas.getPixel(x + 1,y + 1).getRed();
                int cornerValueG = canvas.getPixel(x + 1,y + 1).getGreen();
                int cornerValueB = canvas.getPixel(x + 1,y + 1).getBlue();

                if (Math.abs(oldValueR-cornerValueR) > 10)
                    r = 0;
                else
                    r = 255;
                if (Math.abs(oldValueG-cornerValueG) > 10)
                    g = 0;
                else
                    g = 255;
                if (Math.abs(oldValueB-cornerValueB) > 10)
                    b = 0;
                else
                    b = 255;



                somethingUnique.setPixel(x, y, new Color(r, g, b));

            }
        }
    }                

    public static void pixelate() {
        DrawingPanel pixelate = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x=x+5) {
            for( int y = 0; y < HEIGHT-1; y=y+5) {
                int newRed =  canvas.getPixel(x, y).getRed();
                int newBlue = canvas.getPixel(x, y).getBlue();
                int newGreen = canvas.getPixel(x, y).getGreen();

                for ( int x2 = x; x2 < x+5 && x2< WIDTH-1; x2++) {
                    for( int y2 = y; y < y+5 && y2 < HEIGHT-1; y2++) 

                        pixelate.setPixel(x2, y2, new Color(newRed, newGreen, newBlue));
                }
            }
        } 
    }

    public static void sepia() {
        DrawingPanel sepia = new DrawingPanel(WIDTH, HEIGHT);    

    
        for(int y = 0; y < HEIGHT - 1; y++){
            for(int x = 0; x < WIDTH - 1; x++){
                int p = canvas.getPixel(x, y).getRGB();

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;

                
                int tr = (int)(0.393*r + 0.769*g + 0.189*b);
                int tg = (int)(0.349*r + 0.686*g + 0.168*b);
                int tb = (int)(0.272*r + 0.534*g + 0.131*b);

                
                if(tr > 255){
                    r = 255;
                }else{
                    r = tr;
                }

                if(tg > 255){
                    g = 255;
                }else{
                    g = tg;
                }

                if(tb > 255){
                    b = 255;
                }else{
                    b = tb;
                }

                p = (a<<24) | (r<<16) | (g<<8) | b;
                sepia.setPixel(x, y, new Color(r, g, b));
            }
        }}


    


    public static void main(String[] args) {
        String file = "Seattle.jpg";
        canvas = new DrawingPanel(WIDTH, HEIGHT);
        /**
         * These steps will load the image from the file onto
         * the DrawingPanel canvas.
         */

        Image img = canvas.loadImage(file);
        Graphics g = canvas.getGraphics();
        g.drawImage(img, 0, 0, canvas);

        /**
         * These are the individual photo transformation methods from above
         * Each will generate and display a new DrawingPanel Object
         */

        negative();
        posterize();
        increaseContrast();
        lineDetection();
        somethingUnique();
        pixelate();
        sepia();

    }
}
