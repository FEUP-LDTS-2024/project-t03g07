package spacewars.view.images;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class AppImageLoader implements ImageLoader {
    final Map<String, Image> imageMap;

    public AppImageLoader() {
        imageMap = new HashMap<>();
    }

    @Override
    public Image get(String imageFilepath) throws IOException {
        if (!imageMap.containsKey(imageFilepath))
            imageMap.put(imageFilepath, new Image(imageFilepath));
        return imageMap.get(imageFilepath);
    }

}
