import java.awt.Color;
/**
 * Write a description of class GreenChannelFilter here.
 *
 * @author John Burkert
 * @version April 29th 2019
 */
public class GreenChannelFilter extends Filter
{
    	/**
	 * Constructor for objects of class GreenChannelFilter.
	 * @param name The name of the filter.
	 */
	public GreenChannelFilter(String name)
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
                int green = (pix.getGreen());
                image.setPixel(x, y, new Color(0, green, 0));
            }
        }
    }
}
