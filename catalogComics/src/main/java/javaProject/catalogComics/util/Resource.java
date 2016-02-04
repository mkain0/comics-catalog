package javaProject.catalogComics.util;

import javaProject.catalogComics.catalog.GenreCatalog;
import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Admin;
import javaProject.catalogComics.model.Comic;
import javaProject.catalogComics.model.Genre;
import javaProject.catalogComics.model.User;
import javaProject.catalogComics.service.ComicService;

public class Resource {

    public static void init() {
	PeopleCatalog.getInstance().save(new Admin("Sheldon",
		"259dce1261c779a4fcdc2a42f4a6ee981fc7d819c7ee6462d8896c152ebf990a", "Sheldon", "Cooper"));

	falseResources();
    }

    // This is only for debugging
    private static void falseResources() {
	PeopleCatalog.getInstance().save(
		new User("Demo", "2a97516c354b68848cdbd8f54a226a0a55b21ed138e207ad6c5cbb9c00aa5aea", "Demo", "Demo"));
	GenreCatalog.getInstance().save(new Genre("Superheroes"));
	try {
	    new ComicService()
		    .saveComic(new Comic(1, "Superman", "Superman dead.", GenreCatalog.getInstance().findBy(1)), 1);
	} catch (NotFoundException e) {
	    e.printStackTrace();
	}
    }

}
