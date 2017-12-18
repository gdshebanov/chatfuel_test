package chatfuel.model;

import chatfuel.view.console.UserInput;
import chatfuel.view.console.UserInput.Choice;

public class Floor extends Place implements ButtonFloor {
    
    private final int number;
    
    public Floor( int number ) {
        this.number = number;
    };
    

    @Override
    public Place chooseAction() {
        Place demand = null;
        Choice choice = UserInput.instance().userInput(UserInput.InputType.inTheFloor);
        System.out.println (choice);
        if (choice.equals(UserInput.Choice.yes)) {
            //вызвать
            System.out.println ("Вы вызвали лифт");
            callLift();
            choice = UserInput.instance().userInput(UserInput.InputType.enterLift);
            if (choice.equals(UserInput.Choice.yes)) {
                //войти
                System.out.println("Вы вошли в лифт");
                demand = Lift.instance();
            }
        }
        
        return demand;
    }   
    
    @Override
    public void callLift() {
        Lift.instance().moveToFloor(number);
    }

    
}
