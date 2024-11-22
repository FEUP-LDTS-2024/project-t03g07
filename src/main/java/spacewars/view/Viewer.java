package spacewars.view;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.LanternaFrame;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public abstract class Viewer
{
    BufferedImage image;

    public Viewer(String filepath) throws IOException
    {
        URL resource = getClass().getClassLoader().getResource(filepath);
        assert resource != null;
        image = ImageIO.read(new File((resource.getFile())));
    }

    public void draw(LanternaFrame frame, int a, int b)
    {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                TextColor.RGB color = getLanternaColor(rgb);
                frame.drawPixel(a + x, b + y, color);
            }
        }
    }

    private TextColor.RGB getLanternaColor(int rgb)
    {
        int red = (rgb >> 16) & 0x000000FF;
        int green = (rgb >> 8) & 0x000000FF;
        int blue = (rgb) & 0x000000FF;
        return new TextColor.RGB(red, green, blue);
    }

}

