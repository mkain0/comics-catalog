package javaProject.catalogComics.catalog;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Genre;

public class GenreCatalog {

    private static GenreCatalog uniqueInstance;
    private static int counter;
    private Set<Genre> genres = new HashSet<>();

    public static synchronized GenreCatalog getInstance() {
	if (uniqueInstance == null) {
	    return uniqueInstance = new GenreCatalog();
	}
	return uniqueInstance;
    }

    public static synchronized int getNext() {
	return ++counter;
    }

    public Set<Genre> findAll() {
	return genres;
    }

    public int save(Genre genre) {
	if (genre == null) {
	    throw new IllegalArgumentException();
	}
	genre.setId(GenreCatalog.getNext());
	GenreCatalog.getInstance().findAll().add(genre);
	return genre.getId();
    }

    public Genre findBy(int id) throws NotFoundException {
	for (Genre genre : genres) {
	    if (genre.getId() == id) {
		return genre;
	    }
	}
	throw new NotFoundException("Genre not found.");
    }

    public void update(Genre genreToUptade) {
	if (genreToUptade == null) {
	    throw new IllegalArgumentException();
	}
	GenreCatalog.getInstance().findAll().removeIf(condition(genreToUptade.getId()));
	GenreCatalog.getInstance().findAll().add(genreToUptade);
    }

    public void delete(int id) {
	GenreCatalog.getInstance().findAll().removeIf(condition(id));
    }

    private Predicate<? super Genre> condition(int id) {
	return element -> element.getId() == id;
    }
}
