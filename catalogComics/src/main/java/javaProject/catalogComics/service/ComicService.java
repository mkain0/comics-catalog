package javaProject.catalogComics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javaProject.catalogComics.catalog.ComicCatalog;
import javaProject.catalogComics.catalog.GenreCatalog;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Comic;
import javaProject.catalogComics.model.Copy;
import javaProject.catalogComics.model.Genre;
import javaProject.catalogComics.util.CopyStatus;

public class ComicService {

    public Set<Comic> findComics() {
	return ComicCatalog.getInstance().findAll();
    }

    public Set<Comic> findComicAvailable() {
	return ComicCatalog.getInstance().findAvailable();
    }

    public Comic findComicBy(int isbn) throws NotFoundException {
	return ComicCatalog.getInstance().findBy(isbn);
    }

    public void saveComic(Comic comic, int quantity) {
	List<Copy> copies = new ArrayList<Copy>();
	for (int i = 1; i <= quantity; i++) {
	    copies.add(new Copy(i, CopyStatus.AVAILABLE, comic));
	}
	comic.setCopies(copies);
	ComicCatalog.getInstance().save(comic);
    }

    public void updateComic(Comic comic) {
	ComicCatalog.getInstance().update(comic);
    }

    public void deleteComic(int isbn) {
	ComicCatalog.getInstance().delete(isbn);
    }

    public int saveGenre(Genre genre) {
	return GenreCatalog.getInstance().save(genre);
    }

    public Set<Genre> findGenres() {
	return GenreCatalog.getInstance().findAll();
    }

    public Genre findGenreBy(int id) throws NotFoundException {
	return GenreCatalog.getInstance().findBy(id);
    }

    public void updateGenre(Genre genre) {
	GenreCatalog.getInstance().update(genre);
    }

    public void deleteGenre(int id) {
	// TODO Validate if there are comics with that genre.
	GenreCatalog.getInstance().delete(id);
    }

}
