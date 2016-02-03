package javaProject.catalogComics.view;

import java.util.ArrayList;
import java.util.List;

public interface CrudViewTemplate {

    default List<String> getMenu() {
	List<String> menu = new ArrayList<String>();
	menu.add("1- Register");
	menu.add("2- Modify");
	menu.add("3- Delete");
	menu.add("4- List");
	menu.add("5- Back");
	menu.add("Option: ");
	return menu;
    };

    String getTitle();

    void register();

    void modify();

    void delete();

    void viewAll();

}
