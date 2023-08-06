package Model;

public abstract class HumanFriends {

    protected int petId;
    protected String typeAnimals;
    protected String classAnimals;
    protected String name;
    protected String commands;

    public HumanFriends(int petId, String typeAnimals, String classAnimals, String name, String commands) {

    }

    public abstract void trainCommands();

    public String getCommand() {
        return commands;
    }

    public void setCommand(String newCommands) {
        this.commands = commands +", " + newCommands;
    }
    public String toStringPrint() {
        return String
                .format("<" + petId + "><" + typeAnimals + "><" + classAnimals + "><" + name + "><" + commands + ">");
        //String.format("<" + surname + "><" + name + "><" + patronymic + "><" + phone + ">");
    }

    @Override
    public String toString() {
        return String
                .format("<" + petId + "><" + typeAnimals + "><" + classAnimals + "><" + name + "><" + commands + ">");
    };

}
