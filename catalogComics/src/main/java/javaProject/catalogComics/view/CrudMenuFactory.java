package javaProject.catalogComics.view;

public class CrudMenuFactory {

    public CrudViewTemplate displayCrudMenu(int option) {
	if (option == 1) {
	    return new ComicView();
	}
	if (option == 2) {
	    return new GenreView();
	}
	return new UserView();
    }

}
