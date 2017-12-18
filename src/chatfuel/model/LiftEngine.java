package chatfuel.model;

import chatfuel.settings.AppSettings;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LiftEngine {
    private static LiftEngine liftEngine;
    private LiftEngine() {
        this.doorsAreClosed = true;
    }
    
    public static LiftEngine instance() {
        if (liftEngine==null) liftEngine = new LiftEngine();
        return liftEngine;
    }
    
    private boolean doorsAreClosed;
    
    public void  move(int to) {
        int from = Lift.instance().getCurrentFloorNumber();
        
        if ( from != to && !doorsAreClosed ) {
            closeDoors();
        }
        
        if (from > to) { //down
            for (int i=from; i>=to; i--) {
                mooving(i);
            }
        }
        else if (from < to) { //up
            for (int i=from; i<=to; i++) {
                mooving(i);
            }
        }
        Lift.instance().outMsg("приехал");
        if ( doorsAreClosed ) openDoors();
    }
    
    private void mooving(int i) {
        latency(AppSettings.milisPerFloor);
        Lift.instance().setCurrentFloorNumber(i);
        Lift.instance().outMsg( i+ " этаж" );
    }
        
    private void openDoors() {
        latency(AppSettings.timeLiftOpenCloseDoor*1000);
        this.doorsAreClosed = false;
        Lift.instance().outMsg("двери открылись");
    }
    
    private void closeDoors() {
        latency(AppSettings.timeLiftOpenCloseDoor*1000);
        this.doorsAreClosed = true;
        Lift.instance().outMsg("двери закрылись");
    }
    
    private void latency( int time ) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException ex) {
            Logger.getLogger(LiftEngine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
