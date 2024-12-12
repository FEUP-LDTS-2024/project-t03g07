package spacewars.view;

import com.googlecode.lanterna.TextColor;
import spacewars.gui.GUI;
import com.googlecode.lanterna.TerminalPosition;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppTextViewer implements TextViewer {
    private static final int charWidth = 16; // Width for each character
    private static final int charHeight = 16; // Height for each character
    private static final int spacing = 1; // Spacing between characters

    private final Font customFont;
    private final Map<Character, BufferedImage> charImages;

    public AppTextViewer(String fontPath, float fontSize) throws IOException, FontFormatException {
        // Load the custom font from the .ttf file
        this.customFont = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)).deriveFont(fontSize);
        this.charImages = new HashMap<>();
        preloadCharacters();
    }

    private void preloadCharacters() {
        // Pre-render ASCII characters into images
        for (char c = 32; c < 127; c++) {
            charImages.put(c, renderCharacter(c));
        }
    }

    private BufferedImage renderCharacter(char character) {
        // Create an image to render the character
        BufferedImage image = new BufferedImage(charWidth, charHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Set font and rendering hints
        g2d.setFont(customFont);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        // Draw the character
        g2d.setColor(Color.WHITE); // Default color; can be overridden in draw()
        FontMetrics metrics = g2d.getFontMetrics(customFont);
        int x = (charWidth - metrics.charWidth(character)) / 2;
        int y = (charHeight - metrics.getHeight()) / 2 + metrics.getAscent();
        g2d.drawString(String.valueOf(character), x, y);
        g2d.dispose();
        return image;
    }

    @Override
    public void draw(char character, double x, double y, TextColor foregroundColor, GUI gui) {
        BufferedImage charImage = charImages.get(character);
        if (charImage != null) {
            gui.drawImage(charImage, (int) Math.round(x), (int) Math.round(y));
        }
    }

    @Override
    public void draw(String string, double x, double y, TextColor foregroundColor, GUI gui) {
        double currentX = x;

        for (char character : string.toCharArray()) {
            draw(character, currentX, y, foregroundColor, gui);
            currentX += charWidth + spacing;
        }
    }
}
