package javaProject.catalogComics.util;

import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.model.Admin;

public class Resource {

    public static void init() {
	// Admin password: Bazinga
	PeopleCatalog.getInstance().save(new Admin("Sheldon",
		"259dce1261c779a4fcdc2a42f4a6ee981fc7d819c7ee6462d8896c152ebf990a", "Sheldon", "Cooper"));
    }

}
