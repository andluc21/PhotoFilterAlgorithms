import java.awt.*;

public class additionalFilterMethods {

    public static DrawingPanel canvas;

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;


    /**
     * Helper method for grayscale
     */

    public static int brightness (Color color) {
        return (color.getRed() + color.getGreen() + color.getBlue())/3;
    }

    public static void blueOnly() {
        DrawingPanel blueOnly = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {

                int b = canvas.getPixel(x, y).getBlue();

                blueOnly.setPixel(x, y, new Color(0, 0, b));
            }
        }
    }

    public static void redOnly() {
        DrawingPanel blueOnly = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {

                int r = canvas.getPixel(x, y).getRed();

                blueOnly.setPixel(x, y, new Color(r, 0, 0));
            }
        }
    }

    public static void greenOnly() {
        DrawingPanel blueOnly = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {

                int g = canvas.getPixel(x, y).getGreen();

                blueOnly.setPixel(x, y, new Color(0, g, 0));
            }
        }
    }

    public static void redRemoved() {
        DrawingPanel redRemoved = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {

                int g = canvas.getPixel(x, y).getGreen();
                int b = canvas.getPixel(x, y).getBlue();

                redRemoved.setPixel(x, y, new Color(0, g, b));
            }
        }
    }

    public static void greenRemoved() {
        DrawingPanel greenRemoved = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {

                int r = canvas.getPixel(x, y).getRed();
                int b = canvas.getPixel(x, y).getBlue();

                greenRemoved.setPixel(x, y, new Color(r, 0, b));
            }
        }
    }

    public static void blueRemoved() {
        DrawingPanel blueRemoved = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {

                int r = canvas.getPixel(x, y).getRed();
                int g = canvas.getPixel(x, y).getGreen();

                blueRemoved.setPixel(x, y, new Color(r, g, 0));
            }
        }
    }

    public static void grayscale() {

        DrawingPanel grayscale = new DrawingPanel(WIDTH, HEIGHT);

        for ( int x = 0; x < WIDTH-1; x++) {
            for( int y = 0; y < HEIGHT-1; y++) {

                int b = brightness(canvas.getPixel(x,y));
                Color grayscaleColor = new Color(b,b,b);

                grayscale.setPixel(x, y, grayscaleColor);
            }
        }
    }

    public static void main(String[] args) {

        /**
         * This example uses a 500x500 pixel image called Seattle.jpg
         * If your .jpg image file is saved in the same folder as your
         * code, you should be able to load it onto your canvas like this.
         * If not, you can give the absolute path to your file.
         */
        String file = "logo.jpg";

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
        redOnly();
        greenOnly();
        blueOnly();
        redRemoved();
        greenRemoved();
        blueRemoved();
        grayscale();

    }
}