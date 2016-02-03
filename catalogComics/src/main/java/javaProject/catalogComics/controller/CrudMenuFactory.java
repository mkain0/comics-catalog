package javaProject.catalogComics.controller;

public class CrudMenuFactory {

    public CrudController displayCrudMenu(int option) {
	if (option == 1) {
	    return new ComicController();
	}
	return new UserController();
    }

}
