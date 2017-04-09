package alina.glumenko.controllers;

import alina.glumenko.models.Menu.MenuModel;

/**
 * Created by Alina on 08.04.2017.
 */
public class MenuController {

    private static MenuController menuController = new MenuController();
    private MenuModel model;

    private MenuController() {
        this.model = MenuModel.getInstance();
    }

    public static MenuController getInstance() {
        return menuController;
    }

}
