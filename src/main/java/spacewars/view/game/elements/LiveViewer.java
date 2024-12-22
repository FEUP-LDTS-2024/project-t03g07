package spacewars.view.game.elements;

import spacewars.model.game.elements.Live;
import spacewars.view.images.ImageLoader;

import java.io.IOException;

public class LiveViewer extends AbstractElementViewer<Live> {

    public LiveViewer(ImageLoader imageLoader) throws IOException {
        super(imageLoader, "elements/lives/heart_lives.png");
    }

}
