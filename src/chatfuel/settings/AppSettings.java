package chatfuel.settings;

public enum AppSettings {
    minNumberOfFloors (5),
    maxNumberOfFloors (20),
    liftDoorsDownTime (5), //время ожидания для входа в лифт
    ;
    
    private final int value;
    
    AppSettings(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
    public static float floorHeight;
    public static float liftSpeed;
    public static int timeLiftOpenCloseDoor;
    public static int floorsAmmount;
    public static int milisPerFloor;
    
    static void setMilisPerFloor() {
        milisPerFloor = (int) ((AppSettings.floorHeight/AppSettings.liftSpeed)*1000);
    }    
    
}
