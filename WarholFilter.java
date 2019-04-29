import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class WarholFilter here.
 *
 * @author John Burkert
 * @version April 29th 2019
 */
public class WarholFilter extends Filter
{
    
    private OFImage original;
    private int width;
    private int height;
    private int xpos;
    private int ypos;
    
    /**
     * Constructor for objects of class WarholFilter.
     * @param name The name of the filter.
     */
    public WarholFilter(String name)
    {
        super(name);
    }

    /**
     * Apply this filter to an image.
     * 
     * @param  image  The image to be changed by this filter.
     */
    public void apply(OFImage image)
    {
        
        original = new OFImage(image);
        width = original.getWidth();
        height = original.getHeight();

        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int red = (pix.getRed());
                int green = (pix.getGreen());
                int blue = (pix.getBlue());
                image.setPixel(x, y, new Color(red, green, blue));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int red = (pix.getRed());
                image.setPixel(x, y, new Color(red, 0, 0));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int green = (pix.getGreen());
                image.setPixel(x, y, new Color(0, green, 0));
            }
        }
        
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int blue = (pix.getBlue());
                image.setPixel(x, y, new Color(0, 0, blue));
            }
        }
     
    }
    
    
}
