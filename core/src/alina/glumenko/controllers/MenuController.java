package alina.glumenko.controllers;


/**
 * Created by Alina on 08.04.2017.
 */
public class MenuController {

    private static MenuController menuController = new MenuController();

    public static MenuController getInstance() {
        return menuController;
    }

}
