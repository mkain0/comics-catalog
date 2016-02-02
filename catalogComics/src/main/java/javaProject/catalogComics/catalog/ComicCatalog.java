package javaProject.catalogComics.catalog;

import java.util.ArrayList;
import java.util.Iterator;
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

    public List<Copy> findAll() {
	return comicsCopies;
    }

    public void delete(int ISBN) {
	Iterator<Copy> iCopies = this.comicsCopies.iterator();
	while (iCopies.hasNext()) {
	    Copy copy = iCopies.next();
	    if (copy.getComic().getIsbn() == ISBN) {
		iCopies.remove();
	    }
	}
    }

}
