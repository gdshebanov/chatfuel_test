package chatfuel.view.console;

import chatfuel.model.Place;

public class View {

    public void render(Place place) {
        while (place != null) {
            place = place.chooseAction();
        }
    }
}
