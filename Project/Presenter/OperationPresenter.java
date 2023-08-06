package Presenter;

import java.io.FileWriter;
import java.util.ArrayList;
//import java.util.List;

import Model.Camels;
import Model.Cats;
import Model.Dogs;
import Model.Donkeys;
import Model.Hamsters;
import Model.Horses;
import Model.HumanFriends;

public class OperationPresenter {

    private static ArrayList<HumanFriends> listAnimal = new ArrayList<>();

    public void addNewAnimal(int id, String name, String command, int param) {
        System.out.println(id +  name + command + param);

        switch (param) {
            case 1:
                listAnimal.add(new Cats(id, name, command));
                //break;
            case 2:
                OperationPresenter.listAnimal.add(new Dogs(id, name, command));
                break;
            case 3:
                OperationPresenter.listAnimal.add(new Hamsters(id, name, command));
                break;
            case 4:
                OperationPresenter.listAnimal.add(new Camels(id, name, command));
                break;
            case 5:
                OperationPresenter.listAnimal.add(new Horses(id, name, command));
                break;
            case 6:
                OperationPresenter.listAnimal.add(new Donkeys(id, name, command));
            default:
                System.out.println("Недопустимая команда");
        }
        System.out.println(listAnimal.toString());
    }

    public void showListAnimal() {
        int index = 0;
        for (HumanFriends animal : listAnimal) {
            System.out.printf("%-3d) ", index);
            System.out.println(animal.toStringPrint());
            index++;
        }
    }

    public void storeListAnimal(String path) throws Exception {

        for (HumanFriends animal : listAnimal) {
            try (FileWriter wrFile = new FileWriter(path, true)) {
                wrFile.write(animal.toString());
                wrFile.flush();
                wrFile.append('\n');

            } catch (RuntimeException e) {
                e.printStackTrace();
            }
        }
    }

}
