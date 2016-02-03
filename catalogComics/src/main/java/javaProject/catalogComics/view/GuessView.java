package javaProject.catalogComics.view;

import java.util.ArrayList;
import java.util.List;

public class GuessView {

    public List<String> displayMenu() {
	List<String> menu = new ArrayList<String>();
	menu.add("Welcome to Sheldon Cooper's collection of Comics");
	menu.add("---------------------Menu-----------------------");
	menu.add("1- View collection of comics");
	menu.add("2- Login");
	menu.add("3- Exit");
	menu.add("Option: ");
	return menu;
    }

}
