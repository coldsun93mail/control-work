package Model;


public class Cats extends HomeAnimals {

    // protected Cats(int petId, String typeAnimals, String classAnimals, String name, String commands) {
    //     super(petId, "Домашние животные", "Cats", name, commands);
    //     //TODO Auto-generated constructor stub
    // }
    public Cats (int petId, String name, String commands) {
        super(petId, "Кошки", name, commands);
        //TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    @Override
    public void trainCommands() {
        // TODO Auto-generated method stub
        super.trainCommands();
    }

    
    
}
