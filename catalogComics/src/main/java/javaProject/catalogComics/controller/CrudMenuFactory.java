package javaProject.catalogComics.controller;

public class CrudMenuFactory {

    public CrudController displayCrudMenu(int option) {
	if (option == 1) {
	    return new ComicController();
	}
	if (option == 2) {
	    return new GenreController();
	}
	return new UserController();
    }

}
