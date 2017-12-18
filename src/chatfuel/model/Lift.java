package chatfuel.model;

import chatfuel.settings.AppSettings;
import chatfuel.view.console.UserInput;
import chatfuel.view.console.UserInput.Choice;

public class Lift extends Place implements ButtonLift {
    
    private static Lift lift;
    private Lift() {
        currentFloorNumber = AppSettings.floorsAmmount;
    }
    public static Lift instance() {
        if (lift == null) lift = new Lift();
        return lift;
    }

    private int currentFloorNumber;
    
    @Override
    public Place chooseAction() {
        Place demand = null;
        Choice choice = UserInput.instance().userInput(UserInput.InputType.insideLift);
        if ( choice.equals(Choice.number) ) {
            int floorNumber = UserInput.instance().getInputedNumber();
            moveToFloor( floorNumber );
            demand = this;            
        }
        else if ( choice.equals(Choice.exit) ) {
            demand = new Floor(this.currentFloorNumber);
        }

        return demand;
    }
    
    @Override
    public void moveToFloor(int number) {
        LiftEngine.instance().move(number);
    }    

    public int getCurrentFloorNumber() {
        return currentFloorNumber;
    }

    public void setCurrentFloorNumber(int currentFloorNumber) {
        this.currentFloorNumber = currentFloorNumber;
    }
    
    public void outMsg(String msg) {
        System.out.println( "[Лифт]: " + msg );
    }

}
