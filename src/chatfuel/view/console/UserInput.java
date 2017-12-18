package chatfuel.view.console;

import chatfuel.settings.AppSettings;
import chatfuel.utils.StringUtils;
import java.util.Scanner;

public class UserInput {
    
    private static UserInput validation;
    private int inputedNumber;
    
    private UserInput(){
        
    }
    
    public static UserInput instance() {
        if (validation==null) validation = new UserInput();
        return validation;
    }
    
    public enum InputType {
        insideLift ("Выберите этаж [1-"+AppSettings.floorsAmmount+"],  [x]-выход из лифта", true),
        inTheFloor("[y]-вызвать лифт, [x]-уйти с лестничной площадки (выход)", false),
        enterLift("[y]-войти в лифт, [x]-уйти с лестничной площадки (выход)", false)
        ;
        private final String welcomeMsg;
        private final boolean allowNumber;
        InputType(String welcomeMsg, boolean allow) {
            this.welcomeMsg = welcomeMsg;
            this.allowNumber = allow;
        }

        public String getWelcomeMsg() {
            return welcomeMsg;
        }

    }
    
    public enum Choice {
        exit,
        number,
        yes,
    }
    
    public Choice userInput(InputType type) {
        String input;
        Choice choice;
        while (true) {
            Scanner in = new Scanner(System.in);
            System.out.println(type.getWelcomeMsg());            
            input = StringUtils.userInput();
            choice = getChoice(input);
            if (choice == null && type.allowNumber) {
                if (StringUtils.hasNumber(input)) {
                    inputedNumber = StringUtils.getCheckedNumber();
                    if (isCorrectFloorNumber(inputedNumber)) {
                        choice = Choice.number;
                        return choice;                        
                    }
                }
            }
            else {
                if (choice!=null) {
                    return choice;
                }
            }
        }
    }
    
    private Choice getChoice(String input) {
        if (input.equalsIgnoreCase("y")) return Choice.yes;
        if (input.equalsIgnoreCase("x")) return Choice.exit;
        return null;
    }
            
    private boolean isCorrectFloorNumber( int i ) {
        return (i >= 1 && i<= AppSettings.floorsAmmount);
    }

    public int getInputedNumber() {
        return inputedNumber;
    }
    
    public boolean correctMaxFloorsNumbers( int i ) {
        return (
                i <= AppSettings.maxNumberOfFloors.getValue() &&
                 i>= AppSettings.minNumberOfFloors.getValue()
                );
    }
    
}
