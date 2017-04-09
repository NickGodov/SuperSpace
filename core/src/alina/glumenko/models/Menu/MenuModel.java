package alina.glumenko.models.Menu;

/**
 * Created by Alina on 02.04.2017.
 */
public class MenuModel {

    private static MenuModel menuModel = new MenuModel();

    public static MenuModel getInstance() {
        return menuModel;
    }
}
