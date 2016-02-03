package javaProject.catalogComics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import javaProject.catalogComics.catalog.PeopleCatalog;
import javaProject.catalogComics.exception.NotFoundException;
import javaProject.catalogComics.model.Admin;
import javaProject.catalogComics.model.People;

public class PeopleTest {

    @BeforeClass
    public static void setUp() throws Exception {
	PeopleCatalog.getInstance().save(new Admin("Sheldon", "Bazinga", "Sheldon", "Cooper"));
    }

    @Test
    public void register() {
	assertEquals(1, PeopleCatalog.getInstance().save(new Admin("Sheldon", "Bazinga", "Sheldon", "Cooper")));
    }

    @Test
    public void modify() throws NotFoundException {
	People people = PeopleCatalog.getInstance().findBy(1);
	people.setFirstName("Paul");
	PeopleCatalog.getInstance().update(people);
	assertEquals("Paul", PeopleCatalog.getInstance().findBy(1).getFirstName());
    }

    @Test(expected = NotFoundException.class)
    public void peopleNotFoundException() throws NotFoundException {
	People people = PeopleCatalog.getInstance().findBy(2);
	assertEquals(2, people.getId());
    }

    @Test
    public void delete() throws NotFoundException {
	fail("Not implemented yet");
    }

    @Test
    public void list() {
	assertEquals(new ArrayList<People>(), PeopleCatalog.getInstance().findAll());
    }

}
