package javaProject.catalogComics.catalog;

import java.util.ArrayList;
import java.util.List;

import javaProject.catalogComics.model.Copy;

public class ComicCatalog {

    private static ComicCatalog uniqueInstance;
    private List<Copy> comicsCopies = new ArrayList<>();

    private ComicCatalog() {

    }

    public static synchronized ComicCatalog getInstance() {
	if (uniqueInstance == null) {
	    return uniqueInstance = new ComicCatalog();
	}
	return uniqueInstance;
    }

    public List<Copy> loadComics() {
	return comicsCopies;
    }

}
