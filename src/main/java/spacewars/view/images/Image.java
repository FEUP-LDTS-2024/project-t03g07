package spacewars.view.images;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Image {
    private final BufferedImage image;

    public Image(String filepath) throws IOException {
        this.image = loadImage(filepath);
    }

    public BufferedImage loadImage(String filepath) throws IOException {
        InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(filepath);
        if (resourceStream == null) {
            throw new IOException("Resource not found: " + filepath);
        }
        return ImageIO.read(resourceStream);
    }

    public final void draw(GUI gui, double a, double b) throws IOException {
        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                int rgb = image.getRGB(x, y);
                TextColor.RGB color = getLanternaColor(rgb);
                if (getTransparency(rgb)==0)
                    continue;
                gui.drawPixel(a + x, b + y, color);
            }
        }
    }

    private TextColor.RGB getLanternaColor(int rgb) {
        int red = (rgb >> 16) & 0x000000FF;
        int green = (rgb >> 8) & 0x000000FF;
        int blue = (rgb) & 0x000000FF;
        return new TextColor.RGB(red, green, blue);
    }

    private int getTransparency(int rgb) {
        return rgb >> 24;
    }

}
