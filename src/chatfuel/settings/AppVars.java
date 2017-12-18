package chatfuel.settings;

public enum AppVars {
    floors ("Введите колличество этажей (от "
                    + AppSettings.minNumberOfFloors.getValue()
                    + " до "
                    + AppSettings.maxNumberOfFloors.getValue()
                    + "): ",
            false
    ),
    liftSpeed("Введите скорость лифта (в метрах в секунду): ", true),
    floorHeight("Введите высоту этажа (в метрах): ", true),
    liftOpenCloseDoorTime("Введите скорость открытия/закрытия дверей (в секундах): ", true),
    ;
    
    private final String inputMsg;
    private final boolean inputIsCorrect;
    
    AppVars(String inputMsg, boolean inputIsCorrect) {
        this.inputMsg = inputMsg;
        this.inputIsCorrect = inputIsCorrect;
    }

    public String getInputMsg() {
        return inputMsg;
    }

    public boolean inputIsCorrect() {
        return inputIsCorrect;
    }

}
