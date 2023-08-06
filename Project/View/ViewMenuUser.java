package View;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.MissingFormatArgumentException;

import Model.Counter;
import Presenter.OperationPresenter;

public class ViewMenuUser {

    private OperationPresenter mPresenter;

    public void ViewMenu() {
        mPresenter = new OperationPresenter();

        System.out.println("==========Выберете операцию=============");
        String nameAnimal;
        String commandAnimal;
        int input_str;
        String path = "Project/listAnimal.txt";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); Counter count = new Counter())  {
            while (true) {
                int keyMenu = menuUser(reader);
                if (keyMenu==1) {
                    input_str = menuAddClassAnimal(reader);
                    System.out.println("Кличка животного");
                    nameAnimal = reader.readLine();
                    System.out.println("Команды животного");
                    commandAnimal = reader.readLine();
                    count.add();
                    mPresenter.addNewAnimal(count.getCounter(), nameAnimal, commandAnimal, input_str);
                    //break;
                } else if (keyMenu==2) {
                    mPresenter.showListAnimal();
                    break;
                } else if (keyMenu==3) {
                    mPresenter.storeListAnimal(path);
                    break;
                } else if (keyMenu==4) {
                    break;
                }
                System.out.println("Введите данные: фамилия, имя, отчество и номер телефона");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (MissingFormatArgumentException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (RuntimeException e) {
            System.out.println("Ошибка ввода: " + e);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка сохранения: " + e);
        } catch (Exception e) {
            System.out.println("Ошибка выполнения: " + e);
        } catch (Throwable e) {
            System.out.println("Что-то пошло не так... " + e);
        }

    }

    private static int menuUser(BufferedReader reader) {
        System.out.println("Завести новое животное ввод - 1");
        System.out.println("Завершить и показать животных на экране  - 2");
        System.out.println("Записать в файл и выйти - 3");
        System.out.println("Выход - 4");
        String key;

        try {
            key = reader.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("Введен неверный ключ выбора");
        }

        switch (key) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            default:
                throw new ClassCastException("Введен неверный ключ");
        }
    }

        private static int menuAddClassAnimal(BufferedReader reader) {
        System.out.println("Добавить кота - 1");
        System.out.println("Добавить собаку  - 2");
        System.out.println("Добавить хомяка - 3");
        System.out.println("Добавить верблюда - 4");
        System.out.println("Добавить лошадь - 5");
        System.out.println("Добавить осла - 6");
        System.out.println("Выход - 7");
        String key;

        try {
            key = reader.readLine();
        } catch (Exception e) {
            throw new IllegalArgumentException("Введен неверный ключ выбора");
        }

        switch (key) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            default:
                throw new ClassCastException("Введен неверный ключ");
        }

    }

   
}
