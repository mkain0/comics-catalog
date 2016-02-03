package javaProject.catalogComics.catalog;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Comic;
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
	ComicCatalog.getInstance().findAll().add(comic);
    }

    public void update(Comic comicToUptade) {
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

    public Set<Comic> findAvailable() {
	for (Comic comic : comics) {
	    comic.getCopies().stream().filter(copy -> copy.getStatus().equals(CopyStatus.AVAILABLE));
	}
	return null;
    }
}
