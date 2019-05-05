import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
/**
 * Creates a four grided image with the orginal image an dthe three channels applied.
 *
 * @author John Burkert
 * @version April 29th 2019
 */
public class WarholFilter extends Filter
{
    
    private OFImage original;
    private OFImage blueChannel;
    private OFImage redChannel;
    private OFImage greenChannel;
    
    private int width;
    private int height;
    
    
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
        blueChannel = new OFImage(image);
        redChannel = new OFImage(image);
        greenChannel = new OFImage(image);
        
        int width = original.getWidth() /2;
        int height = original.getHeight() /2;
        
        int width1 = blueChannel.getWidth() /2;
        int height1 = blueChannel.getHeight() /2;
        
        int width2 = redChannel.getWidth() /2;
        int height2 = redChannel.getHeight() /2;
        
        int width3 = greenChannel.getWidth() /2;
        int height3 = greenChannel.getHeight() /2;


        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int red = (pix.getRed());
                int green = (pix.getGreen());
                int blue = (pix.getBlue());
                image.setPixel(x, y, new Color(red, green, blue));
            }
        } 
        
        for(int y = 0; y < height2; y++) {
            for(int x = 0; x < width2; x++) {
                Color pix = redChannel.getPixel(x, y);
                int red = (pix.getRed());
                image.setPixel(x + width2, y, new Color(red, 0, 0));
            }
        } 
        
        for(int y = 0; y < height3; y++) {
            for(int x = 0; x < width3; x++) {
                Color pix = greenChannel.getPixel(x, y);
                int green = (pix.getGreen());
                image.setPixel(x, y + height3, new Color(0, green, 0));
            }
        } 
        
            for(int y = 0; y < height1; y++) {
            for(int x = 0; x < width1; x++) {                
                Color pix = blueChannel.getPixel(x, y);
                int blue = (pix.getBlue());
                image.setPixel(x + width1, y + height1, new Color(0, 0, blue));
            }
        }  
     
    }

}
