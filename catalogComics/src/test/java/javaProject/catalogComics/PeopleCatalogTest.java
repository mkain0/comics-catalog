package javaProject.catalogComics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Admin;
import javaProject.catalogComics.model.People;
import javaProject.catalogComics.model.User;

public class PeopleCatalogTest {

    @BeforeClass
    public static void setUp() throws Exception {
	PeopleCatalog.getInstance().findAll().add(new Admin(7, "Bruce",
		"259dce1261c779a4fcdc2a42f4a6ee981fc7d819c7ee6462d8896c152ebf990a", "Bruce", "Wayne"));
    }

    @Test
    public void register() {
	assertEquals(1, PeopleCatalog.getInstance().save(new Admin("Sheldon",
		"259dce1261c779a4fcdc2a42f4a6ee981fc7d819c7ee6462d8896c152ebf990a", "Sheldon", "Cooper")));
    }

    @Test
    public void modify() throws NotFoundException {
	People people = PeopleCatalog.getInstance().findBy(7);
	people.setFirstName("Paul");
	PeopleCatalog.getInstance().update(people);
	assertEquals("Paul", PeopleCatalog.getInstance().findBy(7).getFirstName());
    }

    @Test(expected = NotFoundException.class)
    public void peopleNotFoundException() throws NotFoundException {
	People people = PeopleCatalog.getInstance().findBy(4);
	assertEquals(4, people.getId());
    }

    @Test(expected = NotFoundException.class)
    public void delete() throws NotFoundException {
	PeopleCatalog.getInstance().delete(1);
	PeopleCatalog.getInstance().findBy(1);
    }

    @Test
    public void isRegister() {
	assertTrue(PeopleCatalog.getInstance().isRegister(new User(7, "Bruce",
		"259dce1261c779a4fcdc2a42f4a6ee981fc7d819c7ee6462d8896c152ebf990a", "Bruce", "Wayne")));
	assertTrue(PeopleCatalog.getInstance().isRegister(new Admin(7, "Bruce",
		"259dce1261c779a4fcdc2a42f4a6ee981fc7d819c7ee6462d8896c152ebf990a", "Bruce", "Wayne")));
    }

    @Test
    public void isNotRegister() {
	assertFalse(PeopleCatalog.getInstance().isRegister(new User(8, "Peter",
		"259dce1261c779a4fcdc2a42f4a6ee981fc7d819c7ee6462d8896c152ebf990a", "Peter", "Parker")));
	assertFalse(PeopleCatalog.getInstance().isRegister(new Admin(8, "Peter",
		"259dce1261c779a4fcdc2a42f4a6ee981fc7d819c7ee6462d8896c152ebf990a", "Peter", "Parker")));
    }

}
