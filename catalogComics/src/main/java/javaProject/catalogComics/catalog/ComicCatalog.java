package javaProject.catalogComics.catalog;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    public List<Copy> findAll() {
	return comicsCopies;
    }

    public void add(Copy copy) {
	ComicCatalog.getInstance().findAll().add(copy);
    }

    public void delete(int ISBN) {
	ComicCatalog.getInstance().findAll().removeIf(condition(ISBN));
    }

    private Predicate<? super Copy> condition(int ISBN) {
	return element -> element.getComic().getIsbn() == ISBN;
    }
}
