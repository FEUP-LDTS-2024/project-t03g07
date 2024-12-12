package spacewars.view.images;

import java.io.IOException;

public interface ImageLoader {
    Image get(String imageFilepath) throws IOException;
}
