package javaProject.catalogComics.catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Comic;
import javaProject.catalogComics.model.Copy;
import javaProject.catalogComics.util.CopyStatus;

public class ComicCatalog {

    private static ComicCatalog uniqueInstance;
    private Set<Comic> comics = new HashSet<>();

    private ComicCatalog() {

    }

    public static synchronized ComicCatalog getInstance() {
	if (uniqueInstance == null) {
	    return uniqueInstance = new ComicCatalog();
	}
	return uniqueInstance;
    }

    public Set<Comic> findAll() {
	return comics;
    }

    public void save(Comic comic) {
	if (comic == null) {
	    throw new IllegalArgumentException();
	}
	ComicCatalog.getInstance().findAll().add(comic);
    }

    public void update(Comic comicToUptade) {
	if (comicToUptade == null) {
	    throw new IllegalArgumentException();
	}
	ComicCatalog.getInstance().findAll().removeIf(condition(comicToUptade.getIsbn()));
	ComicCatalog.getInstance().findAll().add(comicToUptade);
    }

    public Comic findBy(int ISBN) throws NotFoundException {
	for (Comic comic : comics) {
	    if (comic.getIsbn() == ISBN) {
		return comic;
	    }
	}
	throw new NotFoundException("Comic not found.");
    }

    public void delete(int ISBN) {
	ComicCatalog.getInstance().findAll().removeIf(condition(ISBN));
    }

    private Predicate<? super Comic> condition(int ISBN) {
	return element -> element.getIsbn() == ISBN;
    }

    public List<Comic> findAvailable() {
	List<Comic> comicsAvailable = new ArrayList<>();
	for (Comic comic : comics) {
	    for (Copy copy : comic.getCopies()) {
		if (copy.getStatus().equals(CopyStatus.AVAILABLE)) {
		    comicsAvailable.add(comic);
		    break;
		}
	    }
	}
	Collections.sort(comicsAvailable, (c1, c2) -> c1.getTitle().compareTo(c2.getTitle()));
	return comicsAvailable;
    }
}
