import java.awt.Color;

/**
 * Write a description of class RedChannelFilter here.
 *
 * @author John Burkert
 * @version April 29th 2019
 */
public class RedChannelFilter extends Filter
{
    	/**
	 * Constructor for objects of class RedChannelFilter.
	 * @param name The name of the filter.
	 */
	public RedChannelFilter(String name)
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
        int height = image.getHeight();
        int width = image.getWidth();
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                Color pix = image.getPixel(x, y);
                int red = (pix.getRed());
                image.setPixel(x, y, new Color(red, 0, 0));
            }
        }
    }
}
