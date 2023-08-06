import java.io.IOException;

import View.ViewMenuUser;


public class Main {

    private static ViewMenuUser viewMenuUser;

    public static void main(String[] args) throws IOException {
        viewMenuUser= new ViewMenuUser();
        viewMenuUser.ViewMenu();
    }
}