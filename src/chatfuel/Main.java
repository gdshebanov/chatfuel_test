package chatfuel;

import chatfuel.model.Floor;
import chatfuel.model.Place;
import chatfuel.settings.InitAppSettings;
import chatfuel.view.console.View;

public class Main {

    public static void main(String[] args) {
        new InitAppSettings();
        View view = new View();
        Place myPlace = new Floor(1);
        view.render(myPlace);
    }
    
}