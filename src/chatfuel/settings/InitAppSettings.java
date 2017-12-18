package chatfuel.settings;
        
import chatfuel.utils.StringUtils;
import chatfuel.view.console.UserInput;

public final class InitAppSettings {
    
    public InitAppSettings() {
        AppSettings.floorsAmmount = input(AppVars.floors);
        AppSettings.floorHeight = input(AppVars.floorHeight);
        AppSettings.liftSpeed = input(AppVars.liftSpeed);
        AppSettings.timeLiftOpenCloseDoor = input(AppVars.liftOpenCloseDoorTime);
        AppSettings.setMilisPerFloor();
    }

    public int input(AppVars type) {
        boolean correct = false;
        int number=0;
        String value;
        
        while (!correct) {
            System.out.println(type.getInputMsg());
            String userInput = StringUtils.userInput();
            
            if ( StringUtils.hasNumber( userInput ) ) {
                number = StringUtils.getCheckedNumber();
                if ( type.inputIsCorrect() ) return number;
                correct = UserInput.instance().correctMaxFloorsNumbers(number);
            }
            else System.out.println("Значение не корректно.");
            
        }
        
        return number;
    }
    
}
